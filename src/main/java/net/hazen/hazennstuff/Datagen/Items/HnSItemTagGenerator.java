package net.hazen.hazennstuff.Datagen.Items;

import net.hazen.hazennstuff.Datagen.HnSTags;
import net.hazen.hazennstuff.HazenNStuff;
import net.hazen.hazennstuff.Registries.ItemRegistries.HnSArmorItemRegistry;
import net.hazen.hazennstuff.Registries.ItemRegistries.HnSMaterialItemRegistry;
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
                .add(HnSMaterialItemRegistry.ZENALITE_INGOT.get())
                .add(HnSMaterialItemRegistry.STEEL_INGOT.get())

        ;

        this.tag(HnSTags.Items.INGOTS_STEEL)
                .add(HnSMaterialItemRegistry.STEEL_INGOT.get())

        ;

        this.tag(Tags.Items.NUGGETS)
                .add(HnSMaterialItemRegistry.STEEL_NUGGET.get())
        ;

        this.tag(Tags.Items.ORES)
                .add(HnSMaterialItemRegistry.RAW_ZENALITE.get())
                .add(HnSMaterialItemRegistry.STARKISSED_ZENALITE.get())
                .add(HnSMaterialItemRegistry.CRUDE_METAL.get())
        ;

        this.tag(HnSTags.Items.ELDRITCH_RUNE)
                .add(HnSMaterialItemRegistry.ELDRITCH_RUNE.get())
        ;

        this.tag(Tags.Items.ARMORS)
                .add(HnSArmorItemRegistry.HAZEL_HELMET.get())
                .add(HnSArmorItemRegistry.HAZEL_CHESTPLATE.get())
                .add(HnSArmorItemRegistry.BIG_HAZEL_CHESTPLATE.get())
                .add(HnSArmorItemRegistry.HAZEL_LEGGINGS.get())
                .add(HnSArmorItemRegistry.HAZEL_BOOTS.get())

                .add(HnSArmorItemRegistry.BLAZEBORNE_HELMET.get())
                .add(HnSArmorItemRegistry.BLAZEBORNE_CHESTPLATE.get())
                .add(HnSArmorItemRegistry.BLAZEBORNE_LEGGINGS.get())
                .add(HnSArmorItemRegistry.BLAZEBORNE_BOOTS.get())

                .add(HnSArmorItemRegistry.CRYOGENIC_RULER_HELMET.get())
                .add(HnSArmorItemRegistry.CRYOGENIC_RULER_CHESTPLATE.get())
                .add(HnSArmorItemRegistry.CRYOGENIC_RULER_LEGGINGS.get())
                .add(HnSArmorItemRegistry.CRYOGENIC_RULER_BOOTS.get())

                .add(HnSArmorItemRegistry.CREAKING_SORCERER_HELMET.get())
                .add(HnSArmorItemRegistry.CREAKING_SORCERER_CHESTPLATE.get())
                .add(HnSArmorItemRegistry.CREAKING_SORCERER_LEGGINGS.get())
                .add(HnSArmorItemRegistry.CREAKING_SORCERER_BOOTS.get())

                .add(HnSArmorItemRegistry.THUNDER_PROWLER_HELMET.get())
                .add(HnSArmorItemRegistry.THUNDER_PROWLER_CHESTPLATE.get())
                .add(HnSArmorItemRegistry.THUNDER_PROWLER_LEGGINGS.get())
                .add(HnSArmorItemRegistry.THUNDER_PROWLER_BOOTS.get())

                .add(HnSArmorItemRegistry.ENDER_DRAGON_HELMET.get())
                .add(HnSArmorItemRegistry.ENDER_DRAGON_CHESTPLATE.get())
                .add(HnSArmorItemRegistry.ENDER_DRAGON_LEGGINGS.get())
                .add(HnSArmorItemRegistry.ENDER_DRAGON_BOOTS.get())

                .add(HnSArmorItemRegistry.FLESH_MASS_HELMET.get())
                .add(HnSArmorItemRegistry.FLESH_MASS_CHESTPLATE.get())
                .add(HnSArmorItemRegistry.FLESH_MASS_LEGGINGS.get())
                .add(HnSArmorItemRegistry.FLESH_MASS_BOOTS.get())

                .add(HnSArmorItemRegistry.ALCHEMIST_SUPREME_HELMET.get())
                .add(HnSArmorItemRegistry.ALCHEMIST_SUPREME_CHESTPLATE.get())
                .add(HnSArmorItemRegistry.ALCHEMIST_SUPREME_LEGGINGS.get())
                .add(HnSArmorItemRegistry.ALCHEMIST_SUPREME_BOOTS.get())

                .add(HnSArmorItemRegistry.INFESTATION_HELMET.get())
                .add(HnSArmorItemRegistry.INFESTATION_CHESTPLATE.get())
                .add(HnSArmorItemRegistry.INFESTATION_LEGGINGS.get())
                .add(HnSArmorItemRegistry.INFESTATION_BOOTS.get())

                .add(HnSArmorItemRegistry.FIREBLOSSOM_BATTLEMAGE_HELMET.get())
                .add(HnSArmorItemRegistry.FIREBLOSSOM_BATTLEMAGE_CHESTPLATE.get())
                .add(HnSArmorItemRegistry.FIREBLOSSOM_BATTLEMAGE_LEGGINGS.get())
                .add(HnSArmorItemRegistry.FIREBLOSSOM_BATTLEMAGE_BOOTS.get())
        ;

        this.tag(Tags.Items.ARMORS_HELMETS)
                .add(HnSArmorItemRegistry.HAZEL_HELMET.get())
                .add(HnSArmorItemRegistry.BLAZEBORNE_HELMET.get())
                .add(HnSArmorItemRegistry.CRYOGENIC_RULER_HELMET.get())
                .add(HnSArmorItemRegistry.CREAKING_SORCERER_HELMET.get())
                .add(HnSArmorItemRegistry.THUNDER_PROWLER_HELMET.get())
                .add(HnSArmorItemRegistry.ENDER_DRAGON_HELMET.get())
                .add(HnSArmorItemRegistry.FLESH_MASS_HELMET.get())
                .add(HnSArmorItemRegistry.ALCHEMIST_SUPREME_HELMET.get())
                .add(HnSArmorItemRegistry.INFESTATION_HELMET.get())
                .add(HnSArmorItemRegistry.FIREBLOSSOM_BATTLEMAGE_HELMET.get())
                .add(HnSArmorItemRegistry.FIREBLOSSOM_BATTLEMAGE_CROWN.get())
        ;

        this.tag(Tags.Items.ARMORS_CHESTPLATES)
                .add(HnSArmorItemRegistry.HAZEL_CHESTPLATE.get())
                .add(HnSArmorItemRegistry.BIG_HAZEL_CHESTPLATE.get())
                .add(HnSArmorItemRegistry.BLAZEBORNE_CHESTPLATE.get())
                .add(HnSArmorItemRegistry.CRYOGENIC_RULER_CHESTPLATE.get())
                .add(HnSArmorItemRegistry.CREAKING_SORCERER_CHESTPLATE.get())
                .add(HnSArmorItemRegistry.THUNDER_PROWLER_CHESTPLATE.get())
                .add(HnSArmorItemRegistry.ENDER_DRAGON_CHESTPLATE.get())
                .add(HnSArmorItemRegistry.FLESH_MASS_CHESTPLATE.get())
                .add(HnSArmorItemRegistry.ALCHEMIST_SUPREME_CHESTPLATE.get())
                .add(HnSArmorItemRegistry.INFESTATION_CHESTPLATE.get())
                .add(HnSArmorItemRegistry.FIREBLOSSOM_BATTLEMAGE_CHESTPLATE.get())
        ;

        this.tag(Tags.Items.ARMORS_LEGGINGS)
                .add(HnSArmorItemRegistry.HAZEL_LEGGINGS.get())
                .add(HnSArmorItemRegistry.BLAZEBORNE_LEGGINGS.get())
                .add(HnSArmorItemRegistry.CRYOGENIC_RULER_LEGGINGS.get())
                .add(HnSArmorItemRegistry.CREAKING_SORCERER_LEGGINGS.get())
                .add(HnSArmorItemRegistry.THUNDER_PROWLER_LEGGINGS.get())
                .add(HnSArmorItemRegistry.ENDER_DRAGON_LEGGINGS.get())
                .add(HnSArmorItemRegistry.FLESH_MASS_LEGGINGS.get())
                .add(HnSArmorItemRegistry.ALCHEMIST_SUPREME_LEGGINGS.get())
                .add(HnSArmorItemRegistry.INFESTATION_LEGGINGS.get())
                .add(HnSArmorItemRegistry.FIREBLOSSOM_BATTLEMAGE_LEGGINGS.get())
        ;

        this.tag(Tags.Items.ARMORS_BOOTS)
                .add(HnSArmorItemRegistry.HAZEL_BOOTS.get())
                .add(HnSArmorItemRegistry.BLAZEBORNE_BOOTS.get())
                .add(HnSArmorItemRegistry.CRYOGENIC_RULER_BOOTS.get())
                .add(HnSArmorItemRegistry.CREAKING_SORCERER_BOOTS.get())
                .add(HnSArmorItemRegistry.THUNDER_PROWLER_BOOTS.get())
                .add(HnSArmorItemRegistry.ENDER_DRAGON_BOOTS.get())
                .add(HnSArmorItemRegistry.FLESH_MASS_BOOTS.get())
                .add(HnSArmorItemRegistry.ALCHEMIST_SUPREME_BOOTS.get())
                .add(HnSArmorItemRegistry.INFESTATION_BOOTS.get())
                .add(HnSArmorItemRegistry.FIREBLOSSOM_BATTLEMAGE_BOOTS.get())
        ;


    }
}