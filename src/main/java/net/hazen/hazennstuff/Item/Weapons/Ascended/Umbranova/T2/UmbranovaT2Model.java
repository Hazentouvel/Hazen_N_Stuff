package net.hazen.hazennstuff.Item.Weapons.Ascended.Umbranova.T2;

import net.hazen.hazennstuff.HazenNStuff;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.DefaultedItemGeoModel;

public class UmbranovaT2Model extends DefaultedItemGeoModel<UmbranovaT2> {
    public UmbranovaT2Model() {
        super(ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, ""));
    }

    @Override
    public ResourceLocation getModelResource(UmbranovaT2 animatable) {
        return ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "geo/item/weapons/umbranova.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(UmbranovaT2 animatable) {
        return ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "textures/item/weapons/umbranova.png");
    }

    @Override
    public ResourceLocation getAnimationResource(UmbranovaT2 animatable) {
        return ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "animations/item/weapons/umbranova.animation.json");
    }
}
