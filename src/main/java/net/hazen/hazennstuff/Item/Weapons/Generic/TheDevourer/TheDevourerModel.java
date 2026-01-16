package net.hazen.hazennstuff.Item.Weapons.Generic.TheDevourer;

import io.redspace.ironsspellbooks.IronsSpellbooks;
import net.hazen.hazennstuff.HazenNStuff;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.DefaultedItemGeoModel;

public class TheDevourerModel extends DefaultedItemGeoModel<TheDevourerItem> {
    public TheDevourerModel() {
        super(ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, ""));
    }

    @Override
    public ResourceLocation getModelResource(TheDevourerItem animatable) {
        return ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "geo/item/weapons/the_devourer.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(TheDevourerItem animatable) {
        return ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "textures/item/weapons/the_devourer.png");
    }

    @Override
    public ResourceLocation getAnimationResource(TheDevourerItem animatable) {
        return ResourceLocation.fromNamespaceAndPath(IronsSpellbooks.MODID, "animations/wizard_armor_animation.json");
    }
}
