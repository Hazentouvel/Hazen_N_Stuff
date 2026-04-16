package net.hazen.hazennstuff.Item.Armor.Dedicated.ArbitriumRobes.AzureLib;

import mod.azure.azurelib.common.render.armor.AzArmorRenderer;
import mod.azure.azurelib.common.render.armor.AzArmorRendererConfig;
import mod.azure.azurelib.common.render.layer.AzAutoGlowingLayer;
import net.hazen.hazennstuff.HazenNStuff;
import net.hazen.hazennstuff.HnSUtilities.AzArmorLeggingTorsoLayerPipeline;
import net.minecraft.resources.ResourceLocation;

public class ArbitriumRobesArmorRenderer extends AzArmorRenderer {
    private static final ResourceLocation GEO = ResourceLocation.fromNamespaceAndPath(
            HazenNStuff.MOD_ID,
            "geo/armor/arbitrium_robes_armor.geo.json"
    );

    private static final ResourceLocation TEX = ResourceLocation.fromNamespaceAndPath(
            HazenNStuff.MOD_ID,
            "textures/armor/arbitrium_robes_armor.png"
    );

    public ArbitriumRobesArmorRenderer() {
        super(
                AzArmorRendererConfig.builder(GEO, TEX)
                        .setAnimatorProvider(ArbitriumAnimator::new)
                        .addRenderLayer(new AzAutoGlowingLayer<>())
                        .setPipelineContext(AzArmorLeggingTorsoLayerPipeline::new)
                        .build()
        );
    }
}