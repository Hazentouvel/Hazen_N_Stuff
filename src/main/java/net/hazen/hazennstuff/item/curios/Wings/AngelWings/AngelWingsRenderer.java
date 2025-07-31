package net.hazen.hazennstuff.item.curios.Wings.AngelWings;

import mod.azure.azurelib.rewrite.render.item.AzItemRenderer;
import mod.azure.azurelib.rewrite.render.item.AzItemRendererConfig;
import net.hazen.hazennstuff.HazenNStuff;
import net.minecraft.resources.ResourceLocation;

public class AngelWingsRenderer extends AzItemRenderer {
    private static final ResourceLocation GEO = ResourceLocation.fromNamespaceAndPath(
            HazenNStuff.MOD_ID,
            "geo/curios/angel_wings.geo.json"
    );

    private static final ResourceLocation TEX = ResourceLocation.fromNamespaceAndPath(
            HazenNStuff.MOD_ID,
            "textures/curios/angel_wings.png"
    );

    public AngelWingsRenderer() {
        super(
                AzItemRendererConfig.builder(GEO, TEX)
                        .setAnimatorProvider(AngelWingsAnimator::new)
                        .build()
        );
    }
}