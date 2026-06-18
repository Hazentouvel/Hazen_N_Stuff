package net.hazen.hazennstuff.Items.Weapons.Special.Skyscorcher;

import net.hazen.hazennstuff.HazenNStuff;

public class SkyscorcherModel extends DefaultedItemGeoModel<SkyscorcherItem> {
    public SkyscorcherModel() {
        super(ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, ""));
    }

    @Override
    public ResourceLocation getModelResource(SkyscorcherItem animatable) {
        return ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "geo/item/weapons/skyscorcher.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(SkyscorcherItem animatable) {
        return ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "textures/item/weapons/skyscorcher.png");
    }

    @Override
    public ResourceLocation getAnimationResource(SkyscorcherItem animatable) {
        return ResourceLocation.fromNamespaceAndPath(IronsSpellbooks.MODID, "animations/wizard_armor_animation.json");
    }
}
