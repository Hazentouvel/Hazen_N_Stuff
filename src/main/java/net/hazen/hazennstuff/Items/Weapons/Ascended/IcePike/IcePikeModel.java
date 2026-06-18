package net.hazen.hazennstuff.Items.Weapons.Ascended.IcePike;

import net.hazen.hazennstuff.HazenNStuff;

public class IcePikeModel extends DefaultedItemGeoModel<IcePikeItem> {
    public IcePikeModel() {
        super(ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, ""));
    }

    @Override
    public ResourceLocation getModelResource(IcePikeItem animatable) {
        return ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "geo/item/weapons/ice_pike.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(IcePikeItem animatable) {
        return ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "textures/item/weapons/ice_pike.png");
    }

    @Override
    public ResourceLocation getAnimationResource(IcePikeItem animatable) {
        return ResourceLocation.fromNamespaceAndPath(IronsSpellbooks.MODID, "animations/wizard_armor_animation.json");
    }
}
