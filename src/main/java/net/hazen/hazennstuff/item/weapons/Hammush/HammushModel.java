package net.hazen.hazennstuff.item.weapons.Hammush;

import io.redspace.ironsspellbooks.IronsSpellbooks;
import net.hazen.hazennstuff.HazenNStuff;
import net.hazen.hazennstuff.item.weapons.ice_pike.IcePikeItem;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.DefaultedItemGeoModel;

public class HammushModel extends DefaultedItemGeoModel<HammushItem> {
    public HammushModel() {
        super(ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, ""));
    }

    @Override
    public ResourceLocation getModelResource(HammushItem animatable) {
        return ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "geo/item/weapons/hammush.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(HammushItem animatable) {
        return ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "textures/item/weapons/hammush.png");
    }

    @Override
    public ResourceLocation getAnimationResource(HammushItem animatable) {
        return ResourceLocation.fromNamespaceAndPath(IronsSpellbooks.MODID, "animations/wizard_armor_animation.json");
    }
}
