package net.hazen.hazennstuff.Item.Weapons.IonicSplitter.Dormant;

import io.redspace.ironsspellbooks.IronsSpellbooks;
import net.hazen.hazennstuff.HazenNStuff;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.DefaultedItemGeoModel;

public class IonicSplitterModel extends DefaultedItemGeoModel<IonicSplitterItem> {
    public IonicSplitterModel() {
        super(ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, ""));
    }

    @Override
    public ResourceLocation getModelResource(IonicSplitterItem animatable) {
        return ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "geo/item/weapons/ionic_splitter.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(IonicSplitterItem animatable) {
        return ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "textures/item/weapons/ionic_splitter_dormant.png");
    }

    @Override
    public ResourceLocation getAnimationResource(IonicSplitterItem animatable) {
        return ResourceLocation.fromNamespaceAndPath(IronsSpellbooks.MODID, "animations/wizard_armor_animation.json");
    }
}
