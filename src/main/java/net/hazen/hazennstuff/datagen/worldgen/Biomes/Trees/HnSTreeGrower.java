package net.hazen.hazennstuff.datagen.worldgen.Biomes.Trees;

import net.hazen.hazennstuff.HazenNStuff;
import net.hazen.hazennstuff.datagen.worldgen.HnSConfiguredFeatures;
import net.minecraft.world.level.block.grower.TreeGrower;

import java.util.Optional;

public class HnSTreeGrower {
    public static final TreeGrower FROSTBITE_BIRCH = new TreeGrower(HazenNStuff.MOD_ID + "frostbite_birch",
            Optional.empty(), Optional.of(HnSConfiguredFeatures.FROSTBITE_BIRCH_KEY), Optional.empty());

    public static final TreeGrower WISEWOOD = new TreeGrower(HazenNStuff.MOD_ID + "wisewood",
            Optional.empty(), Optional.of(HnSConfiguredFeatures.WISEWOOD_KEY), Optional.empty());
}
