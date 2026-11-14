package net.hazen.hazennstuff.Item.Block.RadiantAltar;

import com.mojang.serialization.Codec;
import com.mojang.serialization.DataResult;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.hazen.hazennstuff.Item.Block.Starforge.StarForgeRecipe.SizedInput;
import net.hazen.hazennstuff.Registries.HnSRecipes;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.NonNullList;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeHolder;
import net.minecraft.world.item.crafting.RecipeInput;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.Level;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

/**
 * A Radiant Altar recipe.
 */
public record RadiantAltarRecipe(
        Ingredient main,
        Optional<SizedInput> secondary,
        List<SizedInput> materials,
        ItemStack result,
        int mana,
        int craftTime,
        boolean keepComponents
) implements Recipe<RadiantAltarRecipe.Input> {

    public static final int MAX_MATERIALS = 12;
    public static final int DEFAULT_CRAFT_TIME = 200;

    public record Input(ItemStack main, ItemStack secondary) implements RecipeInput {
        @Override
        public ItemStack getItem(int index) {
            return index == 0 ? main : secondary;
        }

        @Override
        public int size() {
            return 2;
        }
    }

    public boolean acceptsMain(ItemStack stack) {
        return !stack.isEmpty() && main.test(stack);
    }

    public boolean secondarySatisfied(ItemStack stack) {
        return secondary.map(s -> s.test(stack)).orElse(true);
    }

    @Override
    public boolean matches(Input input, Level level) {
        return acceptsMain(input.main()) && secondarySatisfied(input.secondary());
    }

    @Override
    public ItemStack assemble(Input input, HolderLookup.Provider registries) {
        if (keepComponents && !input.main().isEmpty()) {
            ItemStack out = input.main().transmuteCopy(result.getItem(), result.getCount());
            out.applyComponents(result.getComponentsPatch());
            return out;
        }
        return result.copy();
    }

    @Override
    public ItemStack getResultItem(HolderLookup.Provider registries) {
        return result.copy();
    }

    @Override
    public NonNullList<Ingredient> getIngredients() {
        NonNullList<Ingredient> list = NonNullList.create();
        list.add(main);
        secondary.ifPresent(s -> list.add(s.ingredient()));
        materials.forEach(m -> list.add(m.ingredient()));
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
        return HnSRecipes.RADIANT_ALTAR_SERIALIZER.get();
    }

    @Override
    public RecipeType<?> getType() {
        return HnSRecipes.RADIANT_ALTAR_TYPE.get();
    }

    public static List<RecipeHolder<RadiantAltarRecipe>> sortedRecipes(Level level) {
        return level.getRecipeManager()
                .getAllRecipesFor(HnSRecipes.RADIANT_ALTAR_TYPE.get())
                .stream()
                .sorted(Comparator.comparing(h -> h.id().toString()))
                .toList();
    }

    public static List<RecipeHolder<RadiantAltarRecipe>> recipesFor(Level level, ItemStack main) {
        if (main.isEmpty()) return List.of();
        return sortedRecipes(level).stream().filter(h -> h.value().acceptsMain(main)).toList();
    }

    // Serializer

    public static class Serializer implements RecipeSerializer<RadiantAltarRecipe> {

        public static final MapCodec<RadiantAltarRecipe> CODEC = RecordCodecBuilder.mapCodec(b -> b.group(
                Ingredient.CODEC_NONEMPTY.fieldOf("main").forGetter(RadiantAltarRecipe::main),

                SizedInput.CODEC.optionalFieldOf("secondary").forGetter(RadiantAltarRecipe::secondary),

                SizedInput.CODEC.listOf().optionalFieldOf("materials", List.of()).flatXmap(list ->
                        list.size() > MAX_MATERIALS
                                ? DataResult.error(() -> "A Radiant Altar recipe accepts at most "
                                + MAX_MATERIALS + " materials, got " + list.size())
                                : DataResult.success(list), DataResult::success)
                        .forGetter(RadiantAltarRecipe::materials),

                ItemStack.CODEC.fieldOf("result").forGetter(RadiantAltarRecipe::result),

                Codec.INT.optionalFieldOf("mana", 0).flatXmap(m ->
                        m >= 0 ? DataResult.success(m) : DataResult.error(() -> "mana must not be negative"),
                        DataResult::success).forGetter(RadiantAltarRecipe::mana),

                Codec.INT.optionalFieldOf("craft_time", DEFAULT_CRAFT_TIME).flatXmap(t ->
                        t > 0 ? DataResult.success(t) : DataResult.error(() -> "craft_time must be positive"),
                        DataResult::success).forGetter(RadiantAltarRecipe::craftTime),

                Codec.BOOL.optionalFieldOf("keep_components", false).forGetter(RadiantAltarRecipe::keepComponents)
        ).apply(b, RadiantAltarRecipe::new));

        // Seven fields is past StreamCodec.composite's limit, so this one is written by hand.
        public static final StreamCodec<RegistryFriendlyByteBuf, RadiantAltarRecipe> STREAM_CODEC = StreamCodec.of(
                (buf, r) -> {
                    Ingredient.CONTENTS_STREAM_CODEC.encode(buf, r.main());
                    ByteBufCodecs.optional(SizedInput.STREAM_CODEC).encode(buf, r.secondary());
                    SizedInput.STREAM_CODEC.apply(ByteBufCodecs.list()).encode(buf, r.materials());
                    ItemStack.STREAM_CODEC.encode(buf, r.result());
                    buf.writeVarInt(r.mana());
                    buf.writeVarInt(r.craftTime());
                    buf.writeBoolean(r.keepComponents());
                },
                buf -> new RadiantAltarRecipe(
                        Ingredient.CONTENTS_STREAM_CODEC.decode(buf),
                        ByteBufCodecs.optional(SizedInput.STREAM_CODEC).decode(buf),
                        SizedInput.STREAM_CODEC.apply(ByteBufCodecs.list()).decode(buf),
                        ItemStack.STREAM_CODEC.decode(buf),
                        buf.readVarInt(),
                        buf.readVarInt(),
                        buf.readBoolean())
        );

        @Override
        public MapCodec<RadiantAltarRecipe> codec() {
            return CODEC;
        }

        @Override
        public StreamCodec<RegistryFriendlyByteBuf, RadiantAltarRecipe> streamCodec() {
            return STREAM_CODEC;
        }
    }
}
