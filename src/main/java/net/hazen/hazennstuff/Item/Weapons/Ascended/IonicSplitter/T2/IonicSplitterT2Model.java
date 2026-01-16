package net.hazen.hazennstuff.Item.Weapons.Ascended.IonicSplitter.T2;

import io.redspace.ironsspellbooks.IronsSpellbooks;
import net.hazen.hazennstuff.HazenNStuff;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.DefaultedItemGeoModel;

public class IonicSplitterT2Model extends DefaultedItemGeoModel<IonicSplitterT2Item> {
    public IonicSplitterT2Model() {
        super(ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, ""));
    }

    @Override
    public ResourceLocation getModelResource(IonicSplitterT2Item animatable) {
        return ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "geo/item/weapons/ionic_splitter.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(IonicSplitterT2Item animatable) {
        return ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "textures/item/weapons/ionic_splitter_t2.png");
    }

    @Override
    public ResourceLocation getAnimationResource(IonicSplitterT2Item animatable) {
        return ResourceLocation.fromNamespaceAndPath(IronsSpellbooks.MODID, "animations/wizard_armor_animation.json");
    }
}
