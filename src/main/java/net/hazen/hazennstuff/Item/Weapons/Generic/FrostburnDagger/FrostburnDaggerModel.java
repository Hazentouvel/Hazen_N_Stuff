package net.hazen.hazennstuff.Item.Weapons.Generic.FrostburnDagger;

import io.redspace.ironsspellbooks.IronsSpellbooks;
import net.hazen.hazennstuff.HazenNStuff;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.DefaultedItemGeoModel;

public class FrostburnDaggerModel extends DefaultedItemGeoModel<FrostburnDaggerItem> {
    public FrostburnDaggerModel() {
        super(ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, ""));
    }

    @Override
    public ResourceLocation getModelResource(FrostburnDaggerItem animatable) {
        return ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "geo/item/weapons/frostburn_dagger.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(FrostburnDaggerItem animatable) {
        return ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "textures/item/weapons/frostburn_dagger.png");
    }

    @Override
    public ResourceLocation getAnimationResource(FrostburnDaggerItem animatable) {
        return ResourceLocation.fromNamespaceAndPath(IronsSpellbooks.MODID, "animations/wizard_armor_animation.json");
    }
}
