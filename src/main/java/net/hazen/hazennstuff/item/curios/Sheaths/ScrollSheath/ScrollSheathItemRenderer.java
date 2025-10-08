package net.hazen.hazennstuff.item.curios.Sheaths.ScrollSheath;

import mod.azure.azurelib.rewrite.render.armor.AzArmorRenderer;
import mod.azure.azurelib.rewrite.render.armor.AzArmorRendererConfig;
import mod.azure.azurelib.rewrite.render.layer.AzAutoGlowingLayer;
import net.hazen.hazennstuff.HazenNStuff;
import net.hazen.hazennstuff.item.curios.Sheaths.GalvanizedSheath.GalvanizedSheathAnimator;
import net.minecraft.resources.ResourceLocation;

public class ScrollSheathItemRenderer extends AzArmorRenderer {
    public static final ResourceLocation GEO = ResourceLocation.fromNamespaceAndPath(
            HazenNStuff.MOD_ID,
            "geo/curios/scroll_sheath.geo.json"
    );

    public static final ResourceLocation TEX = ResourceLocation.fromNamespaceAndPath(
            HazenNStuff.MOD_ID,
            "textures/curios/scroll_sheath.png"
    );

    public ScrollSheathItemRenderer() {
        super(
                AzArmorRendererConfig.builder(GEO, TEX)
                        .setAnimatorProvider(ScrollSheathAnimator::new)
                        .addRenderLayer(new AzAutoGlowingLayer<>())
                        .build()
        );
    }
}