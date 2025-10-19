package net.hazen.hazennstuff.Item.Weapons.LightsBane;

import io.redspace.ironsspellbooks.IronsSpellbooks;
import net.hazen.hazennstuff.HazenNStuff;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.DefaultedItemGeoModel;

public class LightsBaneModel extends DefaultedItemGeoModel<LightsBaneItem> {
    public LightsBaneModel() {
        super(ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, ""));
    }

    @Override
    public ResourceLocation getModelResource(LightsBaneItem animatable) {
        return ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "geo/item/weapons/lights_bane.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(LightsBaneItem animatable) {
        return ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "textures/item/weapons/lights_bane.png");
    }

    @Override
    public ResourceLocation getAnimationResource(LightsBaneItem animatable) {
        return ResourceLocation.fromNamespaceAndPath(IronsSpellbooks.MODID, "animations/wizard_armor_animation.json");
    }
}
