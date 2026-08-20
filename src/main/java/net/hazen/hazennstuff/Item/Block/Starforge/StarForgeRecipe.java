package net.hazen.hazennstuff.Item.Block.Starforge;

import com.mojang.serialization.Codec;
import com.mojang.serialization.DataResult;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.hazen.hazennstuff.Registries.HnSRecipes;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.NonNullList;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeInput;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.Level;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public record StarForgeRecipe(
        List<SizedInput> ingredients,
        ItemStack result,
        int smeltTime
) implements Recipe<StarForgeRecipe.Input> {

    public static final int MAX_INGREDIENTS = 3;
    public static final int DEFAULT_SMELT_TIME = 200;

    public record SizedInput(Ingredient ingredient, int count) {

        public static final Codec<SizedInput> CODEC = Codec.withAlternative(
                RecordCodecBuilder.create(instance -> instance.group(
                        Ingredient.CODEC.fieldOf("ingredient").forGetter(SizedInput::ingredient),
                        Codec.INT.optionalFieldOf("count", 1).forGetter(SizedInput::count)
                ).apply(instance, SizedInput::new)),
                Ingredient.CODEC,
                ingredient -> new SizedInput(ingredient, 1)
        );

        public static final StreamCodec<RegistryFriendlyByteBuf, SizedInput> STREAM_CODEC =
                StreamCodec.composite(
                        Ingredient.CONTENTS_STREAM_CODEC, SizedInput::ingredient,
                        ByteBufCodecs.VAR_INT, SizedInput::count,
                        SizedInput::new
                );

        public boolean test(ItemStack stack) {
            return ingredient.test(stack) && stack.getCount() >= count;
        }
    }

    public record Input(List<ItemStack> mainItems) implements RecipeInput {

        @Override
        public ItemStack getItem(int index) {
            return mainItems.get(index);
        }

        @Override
        public int size() {
            return mainItems.size();
        }

        @Override
        public boolean isEmpty() {
            return mainItems.stream().allMatch(ItemStack::isEmpty);
        }
    }

    @Override
    public boolean matches(Input input, Level level) {
        return findAssignment(input) != null;
    }

    @Nullable
    public int[] findAssignment(Input input) {
        if (ingredients.isEmpty() || ingredients.size() > MAX_INGREDIENTS) return null;

        List<Integer> filled = new ArrayList<>(MAX_INGREDIENTS);
        for (int slot = 0; slot < input.mainItems().size(); slot++) {
            if (!input.mainItems().get(slot).isEmpty()) filled.add(slot);
        }

        if (filled.size() != ingredients.size()) return null;

        int[] assignment = new int[ingredients.size()];
        Arrays.fill(assignment, -1);
        boolean[] used = new boolean[filled.size()];

        return solve(input, filled, used, assignment, 0) ? assignment : null;
    }

    private boolean solve(Input input, List<Integer> filled, boolean[] used, int[] assignment, int index) {
        if (index >= ingredients.size()) return true;

        SizedInput ingredient = ingredients.get(index);
        for (int i = 0; i < filled.size(); i++) {
            if (used[i]) continue;

            int slot = filled.get(i);
            if (!ingredient.test(input.mainItems().get(slot))) continue;

            used[i] = true;
            assignment[index] = slot;
            if (solve(input, filled, used, assignment, index + 1)) return true;
            used[i] = false;
            assignment[index] = -1;
        }
        return false;
    }

    public int countFor(int ingredientIndex) {
        return ingredients.get(ingredientIndex).count();
    }

    @Override
    public ItemStack assemble(Input input, HolderLookup.Provider registries) {
        return result.copy();
    }

    @Override
    public ItemStack getResultItem(HolderLookup.Provider registries) {
        return result.copy();
    }

    @Override
    public NonNullList<Ingredient> getIngredients() {
        NonNullList<Ingredient> list = NonNullList.create();
        ingredients.forEach(i -> list.add(i.ingredient()));
        return list;
    }

    @Override
    public boolean isSpecial() {
        return true;
    }

    @Override
    public boolean canCraftInDimensions(int width, int height) {
        return false;
    }

    @Override
    public RecipeSerializer<?> getSerializer() {
        return HnSRecipes.STARFORGE_SERIALIZER.get();
    }

    @Override
    public RecipeType<?> getType() {
        return HnSRecipes.STARFORGE_TYPE.get();
    }

    // Serializer

    public static class Serializer implements RecipeSerializer<StarForgeRecipe> {

        public static final MapCodec<StarForgeRecipe> CODEC = RecordCodecBuilder.mapCodec(builder -> builder.group(
                SizedInput.CODEC.listOf().fieldOf("ingredients").flatXmap(list -> {
                    if (list.isEmpty()) {
                        return DataResult.error(() -> "A Star Forge recipe needs at least one ingredient");
                    }
                    if (list.size() > MAX_INGREDIENTS) {
                        return DataResult.error(() -> "A Star Forge recipe accepts at most "
                                + MAX_INGREDIENTS + " ingredients, got " + list.size());
                    }
                    return DataResult.success(list);
                }, DataResult::success).forGetter(StarForgeRecipe::ingredients),

                ItemStack.CODEC.fieldOf("result").forGetter(StarForgeRecipe::result),

                Codec.INT.optionalFieldOf("smelt_time", DEFAULT_SMELT_TIME).flatXmap(time ->
                                time > 0 ? DataResult.success(time)
                                        : DataResult.error(() -> "smelt_time must be positive"),
                        DataResult::success).forGetter(StarForgeRecipe::smeltTime)
        ).apply(builder, StarForgeRecipe::new));

        public static final StreamCodec<RegistryFriendlyByteBuf, StarForgeRecipe> STREAM_CODEC =
                StreamCodec.composite(
                        SizedInput.STREAM_CODEC.apply(ByteBufCodecs.list()), StarForgeRecipe::ingredients,
                        ItemStack.STREAM_CODEC, StarForgeRecipe::result,
                        ByteBufCodecs.VAR_INT, StarForgeRecipe::smeltTime,
                        StarForgeRecipe::new
                );

        @Override
        public MapCodec<StarForgeRecipe> codec() {
            return CODEC;
        }

        @Override
        public StreamCodec<RegistryFriendlyByteBuf, StarForgeRecipe> streamCodec() {
            return STREAM_CODEC;
        }
    }
}
