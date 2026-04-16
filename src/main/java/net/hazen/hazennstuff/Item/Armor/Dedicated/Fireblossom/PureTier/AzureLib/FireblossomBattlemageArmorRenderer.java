package net.hazen.hazennstuff.Item.Armor.Dedicated.Fireblossom.PureTier.AzureLib;

import mod.azure.azurelib.common.render.armor.AzArmorRenderer;
import mod.azure.azurelib.common.render.armor.AzArmorRendererConfig;
import mod.azure.azurelib.common.render.layer.AzAutoGlowingLayer;
import net.hazen.hazennstuff.HazenNStuff;
import net.hazen.hazennstuff.HnSUtilities.AzArmorLeggingTorsoLayerPipeline;
import net.minecraft.resources.ResourceLocation;

public class FireblossomBattlemageArmorRenderer extends AzArmorRenderer {
    private static final ResourceLocation GEO = ResourceLocation.fromNamespaceAndPath(
            HazenNStuff.MOD_ID,
            "geo/armor/fireblossom_battlemage_armor.geo.json"
    );

    private static final ResourceLocation TEX = ResourceLocation.fromNamespaceAndPath(
            HazenNStuff.MOD_ID,
            "textures/armor/fireblossom_battlemage_armor.png"
    );

    public FireblossomBattlemageArmorRenderer() {
        super(
                AzArmorRendererConfig.builder(GEO, TEX)
                        .setAnimatorProvider(FireblossomBattlemageAnimator::new)
                        .addRenderLayer(new AzAutoGlowingLayer<>())
                        .setPipelineContext(AzArmorLeggingTorsoLayerPipeline::new)
                        .build()
        );
    }
}