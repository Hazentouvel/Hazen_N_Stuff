package net.hazen.hazennstuff.Item.Weapons.Generic.MageBane;

import io.redspace.ironsspellbooks.IronsSpellbooks;
import net.hazen.hazennstuff.HazenNStuff;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.DefaultedItemGeoModel;

public class MageBaneModel extends DefaultedItemGeoModel<MageBaneItem> {
    public MageBaneModel() {
        super(ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, ""));
    }

    @Override
    public ResourceLocation getModelResource(MageBaneItem animatable) {
        return ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "geo/item/weapons/mage_bane.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(MageBaneItem animatable) {
        return ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "textures/item/weapons/mage_bane.png");
    }

    @Override
    public ResourceLocation getAnimationResource(MageBaneItem animatable) {
        return ResourceLocation.fromNamespaceAndPath(IronsSpellbooks.MODID, "animations/wizard_armor_animation.json");
    }
}
