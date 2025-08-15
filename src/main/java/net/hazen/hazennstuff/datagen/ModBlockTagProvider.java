package net.hazen.hazennstuff.datagen;

import net.hazen.hazennstuff.HazenNStuff;
import net.hazen.hazennstuff.registries.HnSItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends BlockTagsProvider {
    public ModBlockTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, HazenNStuff.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(HnSItems.HnSBlocks.ZENALITE_ABYSSLATE_ORE.get())
                .add(HnSItems.HnSBlocks.ZENALITE_DEEPSLATE_ORE.get());

        tag(BlockTags.INCORRECT_FOR_DIAMOND_TOOL);

        tag(BlockTags.INCORRECT_FOR_IRON_TOOL)
                .add(HnSItems.HnSBlocks.ZENALITE_ABYSSLATE_ORE.get())
                .add(HnSItems.HnSBlocks.ZENALITE_DEEPSLATE_ORE.get());

        tag(BlockTags.INCORRECT_FOR_GOLD_TOOL)
                .add(HnSItems.HnSBlocks.ZENALITE_DEEPSLATE_ORE.get());

        tag(BlockTags.INCORRECT_FOR_STONE_TOOL)
                .add(HnSItems.HnSBlocks.ZENALITE_DEEPSLATE_ORE.get());

        tag(BlockTags.INCORRECT_FOR_WOODEN_TOOL);

        tag(BlockTags.NEEDS_DIAMOND_TOOL)
                .add(HnSItems.HnSBlocks.ZENALITE_DEEPSLATE_ORE.get())
                .add(HnSItems.HnSBlocks.ZENALITE_ABYSSLATE_ORE.get());

        tag(BlockTags.NEEDS_IRON_TOOL)
                .add(HnSItems.HnSBlocks.ZENALITE_ABYSSLATE_ORE.get());

    }
}