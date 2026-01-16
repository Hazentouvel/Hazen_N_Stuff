package net.hazen.hazennstuff.Item.Weapons.Ascended.Umbranova.Dormant;

import io.redspace.ironsspellbooks.IronsSpellbooks;
import net.hazen.hazennstuff.HazenNStuff;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.DefaultedItemGeoModel;

public class UmbranovaModel extends DefaultedItemGeoModel<Umbranova> {
    public UmbranovaModel() {
        super(ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, ""));
    }

    @Override
    public ResourceLocation getModelResource(Umbranova animatable) {
        return ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "geo/item/weapons/umbranova.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(Umbranova animatable) {
        return ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "textures/item/weapons/umbranova.png");
    }

    @Override
    public ResourceLocation getAnimationResource(Umbranova animatable) {
        return ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "animations/item/weapons/umbranova.animation.json");
    }
}
