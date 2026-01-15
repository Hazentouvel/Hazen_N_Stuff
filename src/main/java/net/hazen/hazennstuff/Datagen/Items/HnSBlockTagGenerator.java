package net.hazen.hazennstuff.Datagen.Items;

import net.hazen.hazennstuff.Blocks.HnSBlockRegistry;
import net.hazen.hazennstuff.HazenNStuff;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class HnSBlockTagGenerator extends BlockTagsProvider {
    public HnSBlockTagGenerator(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, HazenNStuff.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {
        this.tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(HnSBlockRegistry.ZENALITE_BLOCK.get(),
                        HnSBlockRegistry.STONE_ZENALITE_ORE.get(),
                        HnSBlockRegistry.DEEPSLATE_ZENALITE_ORE.get(),
                        HnSBlockRegistry.END_STONE_ZENALITE_ORE.get())

        ;


        this.tag(BlockTags.NEEDS_IRON_TOOL);

        this.tag(Tags.Blocks.NEEDS_NETHERITE_TOOL)
                .add(HnSBlockRegistry.STONE_ZENALITE_ORE.get())
                .add(HnSBlockRegistry.DEEPSLATE_ZENALITE_ORE.get())
                .add(HnSBlockRegistry.END_STONE_ZENALITE_ORE.get())

        ;

        this.tag(BlockTags.NEEDS_DIAMOND_TOOL)
                ;

        this.tag(BlockTags.NEEDS_STONE_TOOL)

        ;

        this.tag(Tags.Blocks.NEEDS_NETHERITE_TOOL)

        ;


    }
}