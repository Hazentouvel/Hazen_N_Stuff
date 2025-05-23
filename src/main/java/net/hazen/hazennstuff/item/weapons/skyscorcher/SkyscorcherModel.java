package net.hazen.hazennstuff.item.weapons.skyscorcher;

import io.redspace.ironsspellbooks.IronsSpellbooks;
import net.hazen.hazennstuff.HazenNStuff;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.DefaultedItemGeoModel;

public class SkyscorcherModel extends DefaultedItemGeoModel<SkyscorcherItem> {
    public SkyscorcherModel() {
        super(ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, ""));
    }

    @Override
    public ResourceLocation getModelResource(SkyscorcherItem animatable) {
        return ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "geo/skyscorcher.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(SkyscorcherItem animatable) {
        return ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "textures/item/weapons/skyscorcher/skyscorcher.png");
    }

    @Override
    public ResourceLocation getAnimationResource(SkyscorcherItem animatable) {
        return ResourceLocation.fromNamespaceAndPath(IronsSpellbooks.MODID, "animations/wizard_armor_animation.json");
    }
}
