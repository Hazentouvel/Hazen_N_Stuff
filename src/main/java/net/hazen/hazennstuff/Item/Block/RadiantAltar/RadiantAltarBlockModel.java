package net.hazen.hazennstuff.Item.Block.RadiantAltar;

import net.hazen.hazennstuff.HazenNStuff;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.DefaultedBlockGeoModel;

public class RadiantAltarBlockModel extends DefaultedBlockGeoModel<RadiantAltarBlockEntity> {
    public RadiantAltarBlockModel() {
        super(ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, ""));
    }

    @Override
    public ResourceLocation getModelResource(RadiantAltarBlockEntity animatable) {
        return ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "geo/block/radiant_altar.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(RadiantAltarBlockEntity animatable) {
        return ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "textures/block/radiant_altar.png");
    }

    @Override
    public ResourceLocation getAnimationResource(RadiantAltarBlockEntity animatable) {
        return ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "animations/block/radiant_altar.animation.json");
    }
}
