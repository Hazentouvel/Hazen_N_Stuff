package net.hazen.hazennstuff.Item.Weapons.DraconicSplitter;

import io.redspace.ironsspellbooks.IronsSpellbooks;
import net.hazen.hazennstuff.HazenNStuff;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.DefaultedItemGeoModel;

public class DraconicSplitterModel extends DefaultedItemGeoModel<DraconicSplitterItem> {
    public DraconicSplitterModel() {
        super(ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, ""));
    }

    @Override
    public ResourceLocation getModelResource(DraconicSplitterItem animatable) {
        return ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "geo/item/weapons/draconic_splitter.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(DraconicSplitterItem animatable) {
        return ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "textures/item/weapons/draconic_splitter.png");
    }

    @Override
    public ResourceLocation getAnimationResource(DraconicSplitterItem animatable) {
        return ResourceLocation.fromNamespaceAndPath(IronsSpellbooks.MODID, "animations/wizard_armor_animation.json");
    }
}
