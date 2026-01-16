package net.hazen.hazennstuff.Item.Weapons.Ascended.Umbranova.T3;

import net.hazen.hazennstuff.HazenNStuff;
import net.hazen.hazennstuff.Item.Weapons.Ascended.Umbranova.T1.UmbranovaT1;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.DefaultedItemGeoModel;

public class UmbranovaT3Model extends DefaultedItemGeoModel<UmbranovaT3> {
    public UmbranovaT3Model() {
        super(ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, ""));
    }

    @Override
    public ResourceLocation getModelResource(UmbranovaT3 animatable) {
        return ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "geo/item/weapons/umbranova.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(UmbranovaT3 animatable) {
        return ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "textures/item/weapons/umbranova.png");
    }

    @Override
    public ResourceLocation getAnimationResource(UmbranovaT3 animatable) {
        return ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "animations/item/weapons/umbranova.animation.json");
    }
}
