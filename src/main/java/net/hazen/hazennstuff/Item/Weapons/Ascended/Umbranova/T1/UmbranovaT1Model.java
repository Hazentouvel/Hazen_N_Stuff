package net.hazen.hazennstuff.Item.Weapons.Ascended.Umbranova.T1;

import io.redspace.ironsspellbooks.IronsSpellbooks;
import net.hazen.hazennstuff.HazenNStuff;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.DefaultedItemGeoModel;

public class UmbranovaT1Model extends DefaultedItemGeoModel<UmbranovaT1> {
    public UmbranovaT1Model() {
        super(ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, ""));
    }

    @Override
    public ResourceLocation getModelResource(UmbranovaT1 animatable) {
        return ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "geo/item/weapons/umbranova.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(UmbranovaT1 animatable) {
        return ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "textures/item/weapons/umbranova.png");
    }

    @Override
    public ResourceLocation getAnimationResource(UmbranovaT1 animatable) {
        return ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "animations/item/weapons/umbranova.animation.json");
    }
}
