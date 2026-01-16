package net.hazen.hazennstuff.Item.Weapons.Generic.Excalibur.HazenStyle;

import io.redspace.ironsspellbooks.IronsSpellbooks;
import net.hazen.hazennstuff.HazenNStuff;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.DefaultedItemGeoModel;

public class HazensExcaliburModel extends DefaultedItemGeoModel<HazensExcaliburItem> {
    public HazensExcaliburModel() {
        super(ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, ""));
    }

    @Override
    public ResourceLocation getModelResource(HazensExcaliburItem animatable) {
        return ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "geo/item/weapons/excalibur_hazen_style.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(HazensExcaliburItem animatable) {
        return ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "textures/item/weapons/excalibur_hazen_style.png");
    }

    @Override
    public ResourceLocation getAnimationResource(HazensExcaliburItem animatable) {
        return ResourceLocation.fromNamespaceAndPath(IronsSpellbooks.MODID, "animations/wizard_armor_animation.json");
    }
}
