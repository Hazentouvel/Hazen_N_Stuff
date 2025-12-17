package net.hazen.hazennstuff.Item.Weapons.VampireKnives;

import io.redspace.ironsspellbooks.IronsSpellbooks;
import net.hazen.hazennstuff.HazenNStuff;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.DefaultedItemGeoModel;

public class VampireKnivesModel extends DefaultedItemGeoModel<VampireKnivesItem> {
    public VampireKnivesModel() {
        super(ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, ""));
    }

    @Override
    public ResourceLocation getModelResource(VampireKnivesItem animatable) {
        return ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "geo/item/weapons/vampire_knives.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(VampireKnivesItem animatable) {
        return ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "textures/item/weapons/vampire_knives.png");
    }

    @Override
    public ResourceLocation getAnimationResource(VampireKnivesItem animatable) {
        return ResourceLocation.fromNamespaceAndPath(IronsSpellbooks.MODID, "animations/wizard_armor_animation.json");
    }
}
