package net.hazen.hazennstuff.Item.Weapons.Excalibur.ISSxTerraria;

import io.redspace.ironsspellbooks.IronsSpellbooks;
import net.hazen.hazennstuff.HazenNStuff;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.DefaultedItemGeoModel;

public class ISSExcaliburModel extends DefaultedItemGeoModel<ISSExcaliburItem> {
    public ISSExcaliburModel() {
        super(ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, ""));
    }

    @Override
    public ResourceLocation getModelResource(ISSExcaliburItem animatable) {
        return ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "geo/item/weapons/excalibur.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(ISSExcaliburItem animatable) {
        return ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "textures/item/weapons/excalibur_divine_gold.png");
    }

    @Override
    public ResourceLocation getAnimationResource(ISSExcaliburItem animatable) {
        return ResourceLocation.fromNamespaceAndPath(IronsSpellbooks.MODID, "animations/wizard_armor_animation.json");
    }
}
