package net.hazen.hazennstuff.Item.Armor.PureTier.EnderDragon.AzureLib;

import mod.azure.azurelib.common.render.armor.AzArmorRenderer;
import mod.azure.azurelib.common.render.armor.AzArmorRendererConfig;
import mod.azure.azurelib.common.render.layer.AzAutoGlowingLayer;
import net.hazen.hazennstuff.HazenNStuff;
import net.hazen.hazennstuff.HnSUtilities.AzArmorLeggingTorsoLayerPipeline;
import net.minecraft.resources.ResourceLocation;

public class EnderDragonArmorRenderer extends AzArmorRenderer {
    private static final ResourceLocation GEO = ResourceLocation.fromNamespaceAndPath(
            HazenNStuff.MOD_ID,
            "geo/armor/ender_dragon_armor.geo.json"
    );

    private static final ResourceLocation TEX = ResourceLocation.fromNamespaceAndPath(
            HazenNStuff.MOD_ID,
            "textures/armor/ender_dragon_armor.png"
    );

    public EnderDragonArmorRenderer() {
        super(
                AzArmorRendererConfig.builder(GEO, TEX)
                        .addRenderLayer(new AzAutoGlowingLayer<>())
                        .setPipelineContext(AzArmorLeggingTorsoLayerPipeline::new)
                        .build()
        );
    }
}