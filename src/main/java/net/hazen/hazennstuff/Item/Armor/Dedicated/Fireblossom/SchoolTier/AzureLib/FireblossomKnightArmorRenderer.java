package net.hazen.hazennstuff.Item.Armor.Dedicated.Fireblossom.SchoolTier.AzureLib;

import mod.azure.azurelib.common.render.armor.AzArmorRenderer;
import mod.azure.azurelib.common.render.armor.AzArmorRendererConfig;
import mod.azure.azurelib.common.render.layer.AzAutoGlowingLayer;
import net.hazen.hazennstuff.HazenNStuff;
import net.hazen.hazennstuff.Item.HnSUtilities.AzArmorLeggingTorsoLayerPipeline;
import net.minecraft.resources.ResourceLocation;

public class FireblossomKnightArmorRenderer extends AzArmorRenderer {
    private static final ResourceLocation GEO = ResourceLocation.fromNamespaceAndPath(
            HazenNStuff.MOD_ID,
            "geo/armor/fireblossom_knight_armor.geo.json"
    );

    private static final ResourceLocation TEX = ResourceLocation.fromNamespaceAndPath(
            HazenNStuff.MOD_ID,
            "textures/armor/fireblossom_knight_armor.png"
    );

    public FireblossomKnightArmorRenderer() {
        super(
                AzArmorRendererConfig.builder(GEO, TEX)
                        .setPipelineContext(AzArmorLeggingTorsoLayerPipeline::new)
                        .addRenderLayer(new AzAutoGlowingLayer<>())
                        .build()
        );
    }
}