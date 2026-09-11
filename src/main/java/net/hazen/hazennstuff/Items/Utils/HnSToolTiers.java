package net.hazen.hazennstuff.Items.Utils;

import net.hazen.hazennstuff.Datagen.Tags.HnSTags;
import net.minecraft.world.item.ToolMaterial;

public class HnSToolTiers {
    public static final ToolMaterial STEEL = new ToolMaterial(HnSTags.Blocks.INCORRECT_FOR_STEEL_TOOL,
            2400,
            12.0F,
            3f,
            22,
            HnSTags.Items.STEEL_REPAIR);

    public static final ToolMaterial ZENALITE = new ToolMaterial(HnSTags.Blocks.INCORRECT_FOR_ZENALITE_TOOL,
            2400,
            12.0F,
            5f,
            22,
            HnSTags.Items.ZENALITE_REPAIR);

}