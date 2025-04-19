package net.hazen.hazennstuff.item.weapons;

import io.redspace.ironsspellbooks.IronsSpellbooks;
import net.hazen.hazennstuff.HazenNStuff;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.DefaultedItemGeoModel;

public class IcePikeModel extends DefaultedItemGeoModel<IcePikeItem> {
    public IcePikeModel() {
        super(ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, ""));
    }

    @Override
    public ResourceLocation getModelResource(IcePikeItem animatable) {
        return ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "geo/ice_pike.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(IcePikeItem animatable) {
        return ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "textures/item/weapons/ice_pike/ice_pike.png");
    }

    @Override
    public ResourceLocation getAnimationResource(IcePikeItem animatable) {
        // Replace with your animation file
        return ResourceLocation.fromNamespaceAndPath(IronsSpellbooks.MODID, "animations/wizard_armor_animation.json");
    }
}
