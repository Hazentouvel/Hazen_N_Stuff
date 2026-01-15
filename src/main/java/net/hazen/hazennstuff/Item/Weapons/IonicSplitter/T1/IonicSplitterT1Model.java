package net.hazen.hazennstuff.Item.Weapons.IonicSplitter.T1;

import io.redspace.ironsspellbooks.IronsSpellbooks;
import net.hazen.hazennstuff.HazenNStuff;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.DefaultedItemGeoModel;

public class IonicSplitterT1Model extends DefaultedItemGeoModel<IonicSplitterT1Item> {
    public IonicSplitterT1Model() {
        super(ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, ""));
    }

    @Override
    public ResourceLocation getModelResource(IonicSplitterT1Item animatable) {
        return ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "geo/item/weapons/ionic_splitter.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(IonicSplitterT1Item animatable) {
        return ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "textures/item/weapons/ionic_splitter_t1.png");
    }

    @Override
    public ResourceLocation getAnimationResource(IonicSplitterT1Item animatable) {
        return ResourceLocation.fromNamespaceAndPath(IronsSpellbooks.MODID, "animations/wizard_armor_animation.json");
    }
}
