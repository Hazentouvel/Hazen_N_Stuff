package net.hazen.hazennstuff.Item.Staves.CeaselessVoid;

import mod.azure.azurelib.common.render.item.AzItemRenderer;
import mod.azure.azurelib.common.render.item.AzItemRendererConfig;
import mod.azure.azurelib.common.render.layer.AzAutoGlowingLayer;
import net.hazen.hazennstuff.HazenNStuff;
import net.minecraft.resources.ResourceLocation;

public class CeaselessVoidRenderer extends AzItemRenderer {
    private static final ResourceLocation GEO = ResourceLocation.fromNamespaceAndPath(
            HazenNStuff.MOD_ID,
            "geo/item/staves/ceaseless_void.geo.json"
    );

    private static final ResourceLocation TEX = ResourceLocation.fromNamespaceAndPath(
            HazenNStuff.MOD_ID,
            "textures/item/staves/ceaseless_void_animated.png"
    );

    public CeaselessVoidRenderer() {
        super(
                AzItemRendererConfig.builder(GEO, TEX)
                        .build()
        );
    }
}