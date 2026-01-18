package net.hazen.hazennstuff.Datagen.Items;

import net.hazen.hazennstuff.Datagen.HnSTags;
import net.hazen.hazennstuff.HazenNStuff;
import net.hazen.hazennstuff.Registries.HnSItemRegistry;
import net.hazen.hazennstuff.Registries.HnSItemRegistry;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class HnSItemTagGenerator extends ItemTagsProvider {
    public HnSItemTagGenerator(PackOutput p_275343_, CompletableFuture<HolderLookup.Provider> p_275729_,
                               CompletableFuture<TagLookup<Block>> p_275322_, @Nullable ExistingFileHelper existingFileHelper) {
        super(p_275343_, p_275729_, p_275322_, HazenNStuff.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {

        this.tag(Tags.Items.INGOTS)
                .add(HnSItemRegistry.ZENALITE_INGOT.get())
                .add(HnSItemRegistry.STEEL_INGOT.get())

        ;

        this.tag(HnSTags.Items.INGOTS_STEEL)
                .add(HnSItemRegistry.STEEL_INGOT.get())

        ;

        this.tag(Tags.Items.NUGGETS)
                .add(HnSItemRegistry.STEEL_NUGGET.get())
        ;

        this.tag(Tags.Items.ORES)
                .add(HnSItemRegistry.RAW_ZENALITE.get())
                .add(HnSItemRegistry.STARKISSED_ZENALITE.get())
                .add(HnSItemRegistry.CRUDE_METAL.get())
        ;

        this.tag(HnSTags.Items.ELDRITCH_RUNE)
                .add(HnSItemRegistry.ELDRITCH_RUNE.get())
        ;

        this.tag(Tags.Items.ARMORS)
                .add(HnSItemRegistry.HAZEL_HELMET.get())
                .add(HnSItemRegistry.HAZEL_CHESTPLATE.get())
                .add(HnSItemRegistry.BIG_HAZEL_CHESTPLATE.get())
                .add(HnSItemRegistry.HAZEL_LEGGINGS.get())
                .add(HnSItemRegistry.HAZEL_BOOTS.get())

                .add(HnSItemRegistry.BLAZEBORNE_HELMET.get())
                .add(HnSItemRegistry.BLAZEBORNE_CHESTPLATE.get())
                .add(HnSItemRegistry.BLAZEBORNE_LEGGINGS.get())
                .add(HnSItemRegistry.BLAZEBORNE_BOOTS.get())

                .add(HnSItemRegistry.CRYOGENIC_RULER_HELMET.get())
                .add(HnSItemRegistry.CRYOGENIC_RULER_CHESTPLATE.get())
                .add(HnSItemRegistry.CRYOGENIC_RULER_LEGGINGS.get())
                .add(HnSItemRegistry.CRYOGENIC_RULER_BOOTS.get())

                .add(HnSItemRegistry.CREAKING_SORCERER_HELMET.get())
                .add(HnSItemRegistry.CREAKING_SORCERER_CHESTPLATE.get())
                .add(HnSItemRegistry.CREAKING_SORCERER_LEGGINGS.get())
                .add(HnSItemRegistry.CREAKING_SORCERER_BOOTS.get())

                .add(HnSItemRegistry.THUNDER_PROWLER_HELMET.get())
                .add(HnSItemRegistry.THUNDER_PROWLER_CHESTPLATE.get())
                .add(HnSItemRegistry.THUNDER_PROWLER_LEGGINGS.get())
                .add(HnSItemRegistry.THUNDER_PROWLER_BOOTS.get())

                .add(HnSItemRegistry.ENDER_DRAGON_HELMET.get())
                .add(HnSItemRegistry.ENDER_DRAGON_CHESTPLATE.get())
                .add(HnSItemRegistry.ENDER_DRAGON_LEGGINGS.get())
                .add(HnSItemRegistry.ENDER_DRAGON_BOOTS.get())

                .add(HnSItemRegistry.FLESH_MASS_HELMET.get())
                .add(HnSItemRegistry.FLESH_MASS_CHESTPLATE.get())
                .add(HnSItemRegistry.FLESH_MASS_LEGGINGS.get())
                .add(HnSItemRegistry.FLESH_MASS_BOOTS.get())

                .add(HnSItemRegistry.ALCHEMIST_SUPREME_HELMET.get())
                .add(HnSItemRegistry.ALCHEMIST_SUPREME_CHESTPLATE.get())
                .add(HnSItemRegistry.ALCHEMIST_SUPREME_LEGGINGS.get())
                .add(HnSItemRegistry.ALCHEMIST_SUPREME_BOOTS.get())

                .add(HnSItemRegistry.INFESTATION_HELMET.get())
                .add(HnSItemRegistry.INFESTATION_CHESTPLATE.get())
                .add(HnSItemRegistry.INFESTATION_LEGGINGS.get())
                .add(HnSItemRegistry.INFESTATION_BOOTS.get())

                .add(HnSItemRegistry.FIREBLOSSOM_BATTLEMAGE_HELMET.get())
                .add(HnSItemRegistry.FIREBLOSSOM_BATTLEMAGE_CROWN.get())
                .add(HnSItemRegistry.FIREBLOSSOM_BATTLEMAGE_CHESTPLATE.get())
                .add(HnSItemRegistry.FIREBLOSSOM_BATTLEMAGE_LEGGINGS.get())
                .add(HnSItemRegistry.FIREBLOSSOM_BATTLEMAGE_BOOTS.get())

                .add(HnSItemRegistry.ATLAS_HELMET.get())
                .add(HnSItemRegistry.ATLAS_CHESTPLATE.get())
                .add(HnSItemRegistry.ATLAS_LEGGINGS.get())
                .add(HnSItemRegistry.ATLAS_BOOTS.get())
        ;

        this.tag(Tags.Items.ARMORS_HELMETS)
                .add(HnSItemRegistry.HAZEL_HELMET.get())
                .add(HnSItemRegistry.BLAZEBORNE_HELMET.get())
                .add(HnSItemRegistry.CRYOGENIC_RULER_HELMET.get())
                .add(HnSItemRegistry.CREAKING_SORCERER_HELMET.get())
                .add(HnSItemRegistry.THUNDER_PROWLER_HELMET.get())
                .add(HnSItemRegistry.ENDER_DRAGON_HELMET.get())
                .add(HnSItemRegistry.FLESH_MASS_HELMET.get())
                .add(HnSItemRegistry.ALCHEMIST_SUPREME_HELMET.get())
                .add(HnSItemRegistry.INFESTATION_HELMET.get())
                .add(HnSItemRegistry.FIREBLOSSOM_BATTLEMAGE_HELMET.get())
                .add(HnSItemRegistry.FIREBLOSSOM_BATTLEMAGE_CROWN.get())
                .add(HnSItemRegistry.ATLAS_HELMET.get())
        ;

        this.tag(Tags.Items.ARMORS_CHESTPLATES)
                .add(HnSItemRegistry.HAZEL_CHESTPLATE.get())
                .add(HnSItemRegistry.BIG_HAZEL_CHESTPLATE.get())
                .add(HnSItemRegistry.BLAZEBORNE_CHESTPLATE.get())
                .add(HnSItemRegistry.CRYOGENIC_RULER_CHESTPLATE.get())
                .add(HnSItemRegistry.CREAKING_SORCERER_CHESTPLATE.get())
                .add(HnSItemRegistry.THUNDER_PROWLER_CHESTPLATE.get())
                .add(HnSItemRegistry.ENDER_DRAGON_CHESTPLATE.get())
                .add(HnSItemRegistry.FLESH_MASS_CHESTPLATE.get())
                .add(HnSItemRegistry.ALCHEMIST_SUPREME_CHESTPLATE.get())
                .add(HnSItemRegistry.INFESTATION_CHESTPLATE.get())
                .add(HnSItemRegistry.FIREBLOSSOM_BATTLEMAGE_CHESTPLATE.get())
                .add(HnSItemRegistry.ATLAS_CHESTPLATE.get())
        ;

        this.tag(Tags.Items.ARMORS_LEGGINGS)
                .add(HnSItemRegistry.HAZEL_LEGGINGS.get())
                .add(HnSItemRegistry.BLAZEBORNE_LEGGINGS.get())
                .add(HnSItemRegistry.CRYOGENIC_RULER_LEGGINGS.get())
                .add(HnSItemRegistry.CREAKING_SORCERER_LEGGINGS.get())
                .add(HnSItemRegistry.THUNDER_PROWLER_LEGGINGS.get())
                .add(HnSItemRegistry.ENDER_DRAGON_LEGGINGS.get())
                .add(HnSItemRegistry.FLESH_MASS_LEGGINGS.get())
                .add(HnSItemRegistry.ALCHEMIST_SUPREME_LEGGINGS.get())
                .add(HnSItemRegistry.INFESTATION_LEGGINGS.get())
                .add(HnSItemRegistry.FIREBLOSSOM_BATTLEMAGE_LEGGINGS.get())
                .add(HnSItemRegistry.ATLAS_LEGGINGS.get())
        ;

        this.tag(Tags.Items.ARMORS_BOOTS)
                .add(HnSItemRegistry.HAZEL_BOOTS.get())
                .add(HnSItemRegistry.BLAZEBORNE_BOOTS.get())
                .add(HnSItemRegistry.CRYOGENIC_RULER_BOOTS.get())
                .add(HnSItemRegistry.CREAKING_SORCERER_BOOTS.get())
                .add(HnSItemRegistry.THUNDER_PROWLER_BOOTS.get())
                .add(HnSItemRegistry.ENDER_DRAGON_BOOTS.get())
                .add(HnSItemRegistry.FLESH_MASS_BOOTS.get())
                .add(HnSItemRegistry.ALCHEMIST_SUPREME_BOOTS.get())
                .add(HnSItemRegistry.INFESTATION_BOOTS.get())
                .add(HnSItemRegistry.FIREBLOSSOM_BATTLEMAGE_BOOTS.get())
                .add(HnSItemRegistry.ATLAS_BOOTS.get())
        ;


    }
}