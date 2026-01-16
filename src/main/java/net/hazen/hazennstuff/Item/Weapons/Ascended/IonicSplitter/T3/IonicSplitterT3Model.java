package net.hazen.hazennstuff.Item.Weapons.Ascended.IonicSplitter.T3;

import io.redspace.ironsspellbooks.IronsSpellbooks;
import net.hazen.hazennstuff.HazenNStuff;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.DefaultedItemGeoModel;

public class IonicSplitterT3Model extends DefaultedItemGeoModel<IonicSplitterT3Item> {
    public IonicSplitterT3Model() {
        super(ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, ""));
    }

    @Override
    public ResourceLocation getModelResource(IonicSplitterT3Item animatable) {
        return ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "geo/item/weapons/ionic_splitter.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(IonicSplitterT3Item animatable) {
        return ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "textures/item/weapons/ionic_splitter_t3.png");
    }

    @Override
    public ResourceLocation getAnimationResource(IonicSplitterT3Item animatable) {
        return ResourceLocation.fromNamespaceAndPath(IronsSpellbooks.MODID, "animations/wizard_armor_animation.json");
    }
}
