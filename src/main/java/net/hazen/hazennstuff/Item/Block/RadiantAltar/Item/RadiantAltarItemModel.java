package net.hazen.hazennstuff.Item.Block.RadiantAltar.Item;

import net.hazen.hazennstuff.HazenNStuff;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.DefaultedItemGeoModel;

public class RadiantAltarItemModel extends DefaultedItemGeoModel<RadiantAltarItem> {
    public RadiantAltarItemModel() {
        super(ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, ""));
    }

    @Override
    public ResourceLocation getModelResource(RadiantAltarItem animatable) {
        return ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "geo/block/radiant_altar.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(RadiantAltarItem animatable) {
        return ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "textures/block/radiant_altar.png");
    }

    @Override
    public ResourceLocation getAnimationResource(RadiantAltarItem animatable) {
        return ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "animations/block/radiant_altar.animation.json");
    }
}
