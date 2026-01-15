package net.hazen.hazennstuff.Datagen;

import io.redspace.ironsspellbooks.registries.ParticleRegistry;
import net.hazen.hazennstuff.HazenNStuff;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.biome.*;
import net.minecraft.world.level.block.Block;

public class HnSTags {

    /***
     * Items
     */

    // Radiance School Focus
    public static final TagKey<Item> RADIANCE_FOCUS = ItemTags
            .create(ResourceLocation.parse(ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "focus/radiance_focus").toString()));
    // Shadow School Focus
    public static final TagKey<Item> SHADOW_FOCUS = ItemTags
            .create(ResourceLocation.parse(ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "focus/shadow_focus").toString()));
    // Radiance School Focus
    public static final TagKey<Item> MELEE_FOCUS = ItemTags
            .create(ResourceLocation.parse(ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "focus/melee_focus").toString()));
    // Shadow School Focus
    public static final TagKey<Item> ARCHERY_FOCUS = ItemTags
            .create(ResourceLocation.parse(ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "focus/archery_focus").toString()));
    // Radiance School Focus
    public static final TagKey<Item> HEALTH_FOCUS = ItemTags
            .create(ResourceLocation.parse(ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "focus/health_focus").toString()));

    // Ores
    public static final TagKey<Item> ZENALITE = ItemTags
            .create(ResourceLocation.parse(ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "ores/zenalite").toString()));

    //Armor
    public static final TagKey<Item> SCHOOL_HELMET = ItemTags
            .create(ResourceLocation.parse(ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "armors/school/school_helmet").toString()));
    public static final TagKey<Item> SCHOOL_CHESTPLATE = ItemTags
            .create(ResourceLocation.parse(ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "armors/school/school_chestplate").toString()));
    public static final TagKey<Item> SCHOOL_LEGGINGS = ItemTags
            .create(ResourceLocation.parse(ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "armors/school/school_leggings").toString()));
    public static final TagKey<Item> SCHOOL_BOOTS = ItemTags
            .create(ResourceLocation.parse(ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "armors/school/school_boots").toString()));


    public static final TagKey<Item> NETHERITE_BATTLEMAGE_HELMET = ItemTags
            .create(ResourceLocation.parse(ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "armors/netherite_battlemage/netherite_battlemage_helmet").toString()));
    public static final TagKey<Item> NETHERITE_BATTLEMAGE_CHESTPLATE = ItemTags
            .create(ResourceLocation.parse(ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "armors/netherite_battlemage/netherite_battlemage_chestplate").toString()));
    public static final TagKey<Item> NETHERITE_BATTLEMAGE_LEGGINGS = ItemTags
            .create(ResourceLocation.parse(ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "armors/netherite_battlemage/netherite_battlemage_leggings").toString()));
    public static final TagKey<Item> NETHERITE_BATTLEMAGE_BOOTS = ItemTags
            .create(ResourceLocation.parse(ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "armors/netherite_battlemage/netherite_battlemage_boots").toString()));



    public static final TagKey<Item> PURE_HELMET = ItemTags
            .create(ResourceLocation.parse(ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "armors/pure/pure_helmet").toString()));
    public static final TagKey<Item> PURE_CHESTPLATE = ItemTags
            .create(ResourceLocation.parse(ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "armors/pure/pure_chestplate").toString()));
    public static final TagKey<Item> PURE_LEGGINGS = ItemTags
            .create(ResourceLocation.parse(ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "armors/pure/pure_leggings").toString()));
    public static final TagKey<Item> PURE_BOOTS = ItemTags
            .create(ResourceLocation.parse(ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "armors/pure/pure_boots").toString()));

    // Ores
    public static final TagKey<Item> CINDEROUS_EQUIPMENT = ItemTags
            .create(ResourceLocation.parse(ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "cinderous_equipment").toString()));


    public static class Blocks {

        public static final TagKey<Block> NEEDS_MITRHIL_TOOL = BlockTags
                .create(ResourceLocation.parse(ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "needs_mithril_tool").toString()));

        public static final TagKey<Block> INCORRECT_FOR_MITHRIL_TOOl = BlockTags
                .create(ResourceLocation.parse(ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "incorrect_for_mithril_tool").toString()));


    }

    public static final ResourceKey<Biome> WISEWOOD_FOREST = create("wisewood_forest");
    public static final ResourceKey<Biome> PERMAFROST_FOREST = create("permafrost_forest");


    private static Biome.BiomeBuilder baseBiomeBuilder(BiomeSpecialEffects.Builder specialEffects, MobSpawnSettings.Builder mobSpawnSettings, BiomeGenerationSettings.Builder genSettings) {
        return new Biome.BiomeBuilder()
                .hasPrecipitation(true)
                .temperature(0.5F)
                .downfall(0.5F)
                .specialEffects(specialEffects.build())
                .mobSpawnSettings(mobSpawnSettings.build())
                .generationSettings(genSettings.build())
                .temperatureAdjustment(Biome.TemperatureModifier.NONE);
    }


    private static BiomeSpecialEffects.Builder baseEffectsBuilder() {
        return baseEffectsBuilder(true);
    }


    private static BiomeSpecialEffects.Builder baseEffectsBuilder(boolean ambientParticle) {
        BiomeSpecialEffects.Builder builder = new BiomeSpecialEffects.Builder()
                .fogColor(5195923)
                .foliageColorOverride(5195923)
                .grassColorOverride(5195923)
                .waterColor(6187416)
                .waterFogColor(1184291)
                .skyColor(5658761)
                ;
        if (ambientParticle) {
            builder.ambientParticle(new AmbientParticleSettings(ParticleRegistry.SNOWFLAKE_PARTICLE.get(), 0.001f));
        }
        return builder;
    }



    public static ResourceKey<Biome> create(String name) {
        return ResourceKey.create(Registries.BIOME, HazenNStuff.id(name));
    }

    public static class Items {
        public static final TagKey<Item> MITHRIL_REPAIRABLE = createTag("mithril_repairable");

        private static TagKey<Item> createTag (String name) {
            return ItemTags.create(ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, name));
        }
    }

    public static class Biomes {
        private static TagKey<Biome> createTag(String name) {
            return TagKey.create(Registries.BIOME, ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, name));
        }
    }

    private static TagKey<Block> createTag (String name) {
        return BlockTags.create(ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, name));

    }



}