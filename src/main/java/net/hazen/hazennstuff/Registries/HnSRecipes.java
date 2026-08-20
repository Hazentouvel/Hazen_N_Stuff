package net.hazen.hazennstuff.Registries;

import net.hazen.hazennstuff.HazenNStuff;
import net.hazen.hazennstuff.Item.Block.Starforge.StarForgeRecipe;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class HnSRecipes {

    private static final DeferredRegister<RecipeType<?>> RECIPE_TYPES =
            DeferredRegister.create(Registries.RECIPE_TYPE, HazenNStuff.MOD_ID);
    private static final DeferredRegister<RecipeSerializer<?>> RECIPE_SERIALIZERS =
            DeferredRegister.create(Registries.RECIPE_SERIALIZER, HazenNStuff.MOD_ID);

    public static void register(IEventBus eventBus) {
        RECIPE_TYPES.register(eventBus);
        RECIPE_SERIALIZERS.register(eventBus);
    }

    public static final DeferredHolder<RecipeSerializer<?>, RecipeSerializer<StarForgeRecipe>> STARFORGE_SERIALIZER =
            RECIPE_SERIALIZERS.register("starforge", StarForgeRecipe.Serializer::new);

    public static final DeferredHolder<RecipeType<?>, RecipeType<StarForgeRecipe>> STARFORGE_TYPE =
            RECIPE_TYPES.register("starforge", registry -> new RecipeType<StarForgeRecipe>() {
                @Override
                public String toString() {
                    return registry.toString();
                }
            });
}
