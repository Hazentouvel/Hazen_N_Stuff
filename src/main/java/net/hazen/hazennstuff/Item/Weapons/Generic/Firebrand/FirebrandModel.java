package net.hazen.hazennstuff.Item.Weapons.Generic.Firebrand;

import io.redspace.ironsspellbooks.IronsSpellbooks;
import net.hazen.hazennstuff.HazenNStuff;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.DefaultedItemGeoModel;

public class FirebrandModel extends DefaultedItemGeoModel<FirebrandItem> {
    public FirebrandModel() {
        super(ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, ""));
    }

    @Override
    public ResourceLocation getModelResource(FirebrandItem animatable) {
        return ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "geo/item/weapons/firebrand.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(FirebrandItem animatable) {
        return ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "textures/item/weapons/firebrand.png");
    }

    @Override
    public ResourceLocation getAnimationResource(FirebrandItem animatable) {
        return ResourceLocation.fromNamespaceAndPath(IronsSpellbooks.MODID, "animations/wizard_armor_animation.json");
    }
}
