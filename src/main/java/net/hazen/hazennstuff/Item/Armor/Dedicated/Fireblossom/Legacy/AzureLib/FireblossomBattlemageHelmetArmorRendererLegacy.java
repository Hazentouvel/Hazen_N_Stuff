package net.hazen.hazennstuff.Item.Armor.Dedicated.Fireblossom.Legacy.AzureLib;

import mod.azure.azurelib.common.render.armor.AzArmorRenderer;
import mod.azure.azurelib.common.render.armor.AzArmorRendererConfig;
import mod.azure.azurelib.common.render.layer.AzAutoGlowingLayer;
import net.hazen.hazennstuff.HazenNStuff;
import net.hazen.hazennstuff.Item.HnSUtilities.AzArmorLeggingTorsoLayerPipeline;
import net.minecraft.resources.ResourceLocation;

public class FireblossomBattlemageHelmetArmorRendererLegacy extends AzArmorRenderer {
    private static final ResourceLocation GEO = ResourceLocation.fromNamespaceAndPath(
            HazenNStuff.MOD_ID,
            "geo/armor/fireblossom_battlemage_armor_legacy.geo.json"
    );

    private static final ResourceLocation TEX = ResourceLocation.fromNamespaceAndPath(
            HazenNStuff.MOD_ID,
            "textures/armor/fireblossom_battlemage_helmet_armor_legacy.png"
    );

    public FireblossomBattlemageHelmetArmorRendererLegacy() {
        super(
                AzArmorRendererConfig.builder(GEO, TEX)
                        .setAnimatorProvider(FireblossomAnimatorLegacy::new)
                        .setPipelineContext(AzArmorLeggingTorsoLayerPipeline::new)
                        .addRenderLayer(new AzAutoGlowingLayer<>())
                        .build()
        );
    }
}