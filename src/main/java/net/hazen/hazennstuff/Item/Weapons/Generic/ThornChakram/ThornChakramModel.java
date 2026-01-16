package net.hazen.hazennstuff.Item.Weapons.Generic.ThornChakram;

import io.redspace.ironsspellbooks.IronsSpellbooks;
import net.hazen.hazennstuff.HazenNStuff;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.DefaultedItemGeoModel;

public class ThornChakramModel extends DefaultedItemGeoModel<ThornChakramItem> {
    public ThornChakramModel() {
        super(ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, ""));
    }

    @Override
    public ResourceLocation getModelResource(ThornChakramItem animatable) {
        return ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "geo/item/weapons/thorn_chakram.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(ThornChakramItem animatable) {
        return ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "textures/item/weapons/thorn_chakram.png");
    }

    @Override
    public ResourceLocation getAnimationResource(ThornChakramItem animatable) {
        return ResourceLocation.fromNamespaceAndPath(IronsSpellbooks.MODID, "animations/wizard_armor_animation.json");
    }
}
