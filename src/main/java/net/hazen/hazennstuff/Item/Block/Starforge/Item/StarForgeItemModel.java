package net.hazen.hazennstuff.Item.Block.Starforge.Item;

import net.hazen.hazennstuff.HazenNStuff;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.DefaultedItemGeoModel;

public class StarForgeItemModel extends DefaultedItemGeoModel<StarForgeItem> {
    public StarForgeItemModel() {
        super(ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, ""));
    }

    @Override
    public ResourceLocation getModelResource(StarForgeItem animatable) {
        return ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "geo/block/starforge.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(StarForgeItem animatable) {
        return ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "textures/block/starforge.png");
    }

    @Override
    public ResourceLocation getAnimationResource(StarForgeItem animatable) {
        return ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "animations/block/starforge.animation.json");
    }
}
