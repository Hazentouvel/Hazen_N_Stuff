package net.hazen.hazennstuff.Item.Weapons.Generic.Excalibur.Terraria;

import io.redspace.ironsspellbooks.IronsSpellbooks;
import net.hazen.hazennstuff.HazenNStuff;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.DefaultedItemGeoModel;

public class ExcaliburModel extends DefaultedItemGeoModel<ExcaliburItem> {
    public ExcaliburModel() {
        super(ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, ""));
    }

    @Override
    public ResourceLocation getModelResource(ExcaliburItem animatable) {
        return ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "geo/item/weapons/excalibur.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(ExcaliburItem animatable) {
        return ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "textures/item/weapons/excalibur.png");
    }

    @Override
    public ResourceLocation getAnimationResource(ExcaliburItem animatable) {
        return ResourceLocation.fromNamespaceAndPath(IronsSpellbooks.MODID, "animations/wizard_armor_animation.json");
    }
}
