package net.hazen.hazennstuff.datagen;

import io.redspace.ironsspellbooks.registries.ItemRegistry;
import net.hazen.hazennstuff.HazenNStuff;
import net.hazen.hazennstuff.registries.HnSItems;
import net.hazen.hazennstuff.registries.HnSTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.Tags;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModItemTagProvider extends ItemTagsProvider {
    public ModItemTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, CompletableFuture<TagLookup<Block>> blockTags, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, blockTags, HazenNStuff.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {

        //Ores and Ingots
        tag(Tags.Items.INGOTS)
                .add(HnSItems.ZENALITE_INGOT.get())
        ;

        tag(Tags.Items.NUGGETS)
                .add(HnSItems.PYRIUM_NUGGET.get())
        ;

        tag(Tags.Items.ORES)

                .add(HnSItems.RAW_ZENALITE.get())

        ;

        tag(Tags.Items.RAW_MATERIALS)

                .add(HnSItems.RAW_ZENALITE.get())

        ;

        tag(Tags.Items.GEMS)

        ;

        tag(Tags.Items.GEMS_QUARTZ)

        ;

        tag(HnSTags.ZENALITE)

                .add(HnSItems.RAW_ZENALITE.get())
                .add(HnSItems.STARKISSED_ZENALITE.get())

        ;


        /*
        *** Enchantable Tags
         */

        tag(Tags.Items.ENCHANTABLES)

                //Calamitas Armor
                .add(HnSItems.CALAMITAS_HELMET.get())
                .add(HnSItems.CALAMITAS_CHESTPLATE.get())
                .add(HnSItems.CALAMITAS_LEGGINGS.get())
                .add(HnSItems.CALAMITAS_BOOTS.get())

        ;

        tag(ItemTags.EQUIPPABLE_ENCHANTABLE)

                //Calamitas Armor
                .add(HnSItems.CALAMITAS_HELMET.get())
                .add(HnSItems.CALAMITAS_CHESTPLATE.get())
                .add(HnSItems.CALAMITAS_LEGGINGS.get())
                .add(HnSItems.CALAMITAS_BOOTS.get())

        ;

        tag(ItemTags.DURABILITY_ENCHANTABLE)

                //Calamitas Armor
                .add(HnSItems.CALAMITAS_HELMET.get())
                .add(HnSItems.CALAMITAS_CHESTPLATE.get())
                .add(HnSItems.CALAMITAS_LEGGINGS.get())
                .add(HnSItems.CALAMITAS_BOOTS.get())

        ;

        /*
        *** Armor Tags
         */

        tag(Tags.Items.ARMORS)

                //Calamitas Armor
                .add(HnSItems.CALAMITAS_HELMET.get())
                .add(HnSItems.CALAMITAS_CHESTPLATE.get())
                .add(HnSItems.CALAMITAS_LEGGINGS.get())
                .add(HnSItems.CALAMITAS_BOOTS.get())

        ;

        tag(ItemTags.HEAD_ARMOR)

                //Calamitas Armor
                .add(HnSItems.CALAMITAS_HELMET.get())

        ;

        tag(ItemTags.CHEST_ARMOR)

                //Calamitas Armor
                .add(HnSItems.CALAMITAS_CHESTPLATE.get())

        ;

        tag(ItemTags.LEG_ARMOR)

                //Calamitas Armor
                .add(HnSItems.CALAMITAS_LEGGINGS.get())

        ;

        tag(ItemTags.FOOT_ARMOR)

                //Calamitas Armor
                .add(HnSItems.CALAMITAS_BOOTS.get())

        ;

        tag(ItemTags.ARMOR_ENCHANTABLE)

                //Calamitas Armor
                .add(HnSItems.CALAMITAS_HELMET.get())
                .add(HnSItems.CALAMITAS_CHESTPLATE.get())
                .add(HnSItems.CALAMITAS_LEGGINGS.get())
                .add(HnSItems.CALAMITAS_BOOTS.get())

        ;

        tag(ItemTags.HEAD_ARMOR_ENCHANTABLE)

                //Calamitas Armor
                .add(HnSItems.CALAMITAS_HELMET.get())

        ;

        tag(ItemTags.CHEST_ARMOR_ENCHANTABLE)

                //Calamitas Armor
                .add(HnSItems.CALAMITAS_CHESTPLATE.get())

        ;

        tag(ItemTags.LEG_ARMOR_ENCHANTABLE)

                //Calamitas Armor
                .add(HnSItems.CALAMITAS_LEGGINGS.get())

        ;

        tag(ItemTags.FOOT_ARMOR_ENCHANTABLE)

                //Calamitas Armor
                .add(HnSItems.CALAMITAS_BOOTS.get())

        ;

        /*
        *** Tools and Weapons Tags
         */

        tag(ItemTags.AXES)

                .add(HnSItems.BEONGAE.get())
                .add(HnSItems.SKYSCORCHER.get())
                .add(HnSItems.ANCIENT_WARRIORS_AXE.get())
                .add(HnSItems.FIREBRAND.get())

                ;

        tag(ItemTags.SWORDS)

                //Tags

                //Fire
                .add(HnSItems.FIREBLOSSOM_RAPIER.get())
                .add(HnSItems.DRACONIC_SPLITTER.get())
                .add(HnSItems.FIREBRAND.get())

                //Ice
                .add(HnSItems.ICE_PIKE.get())
                .add(HnSItems.FROSTBURN_DAGGER.get())

                //Lightning
                .add(HnSItems.BEONGAE.get())
                .add(HnSItems.SKYSCORCHER.get())

                //Nature
                .add(HnSItems.BOUNTIFUL_HARVEST.get())
                .add(HnSItems.THORN_CHAKRAM.get())

                //Blood
                .add(HnSItems.VAMPIRE_KNIVES.get())

                //Ender
                .add(HnSItems.OBSIDIAN_CLAYMORE.get())
                .add(HnSItems.STARFURY.get())

                //Radiance
                .add(HnSItems.SPECTRUM.get())
                .add(HnSItems.MEOWMERE.get())
                .add(HnSItems.HAMMUSH.get())

                //Shadow
                .add(HnSItems.LIGHTS_BANE.get())
                .add(HnSItems.NIGHTS_EDGE.get())
                .add(HnSItems.TRUE_NIGHTS_EDGE.get())

                //Holy
                .add(HnSItems.HAMMER_OF_JUSTICE.get())
                .add(HnSItems.DIVINE_GREATSWORD.get())
                .add(HnSItems.EXCALIBUR.get())
                .add(HnSItems.HAZENS_EXCALIBUR.get())
                .add(HnSItems.ISS_EXCALIBUR.get())

                //Evocation
                .add(HnSItems.MALICE.get())
                .add(HnSItems.ANCIENT_WARRIORS_AXE.get())

                //Eldritch
                .add(HnSItems.THE_DEVOURER.get())

                //Misc
                .add(HnSItems.MAGE_BANE.get())

        ;

        tag(ItemTags.PICKAXES)

                .add(HnSItems.SPECTRAL_PICKAXE.get())

        ;

        tag(Tags.Items.TOOLS_MACE)

                .add(HnSItems.SKYSCORCHER.get())

        ;

        tag(Tags.Items.TOOLS_SPEAR)

                .add(HnSItems.ICE_PIKE.get())

        ;


        /*
        *** Misc
         */


        tag(Tags.Items.ENCHANTING_FUELS)

                .add(ItemRegistry.ARCANE_ESSENCE.get())

        ;

        tag(Tags.Items.BONES)

                .add(HnSItems.OVERGROWN_BONE.get())
                .add(HnSItems.CHARRED_BONES.get())

        ;

        tag(Tags.Items.HIDDEN_FROM_RECIPE_VIEWERS)

                .add(HnSItems.HAZEL_HOLY_MOLLY_CHESTPLATE.get())
                .add(HnSItems.MOTHIC_WITCH_SECRET_CHESTPLATE.get())

        ;

    }
}