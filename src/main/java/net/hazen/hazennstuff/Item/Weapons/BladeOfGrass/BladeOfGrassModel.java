package net.hazen.hazennstuff.Item.Weapons.BladeOfGrass;

import io.redspace.ironsspellbooks.IronsSpellbooks;
import net.hazen.hazennstuff.HazenNStuff;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.DefaultedItemGeoModel;

public class BladeOfGrassModel extends DefaultedItemGeoModel<BladeOfGrassItem> {
    public BladeOfGrassModel() {
        super(ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, ""));
    }

    @Override
    public ResourceLocation getModelResource(BladeOfGrassItem animatable) {
        return ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "geo/item/weapons/blade_of_grass.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(BladeOfGrassItem animatable) {
        return ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "textures/item/weapons/blade_of_grass.png");
    }

    @Override
    public ResourceLocation getAnimationResource(BladeOfGrassItem animatable) {
        return ResourceLocation.fromNamespaceAndPath(IronsSpellbooks.MODID, "animations/wizard_armor_animation.json");
    }
}
