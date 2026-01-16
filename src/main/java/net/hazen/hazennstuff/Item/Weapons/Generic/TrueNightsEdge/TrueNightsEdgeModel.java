package net.hazen.hazennstuff.Item.Weapons.Generic.TrueNightsEdge;

import io.redspace.ironsspellbooks.IronsSpellbooks;
import net.hazen.hazennstuff.HazenNStuff;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.DefaultedItemGeoModel;

public class TrueNightsEdgeModel extends DefaultedItemGeoModel<TrueNightsEdgeItem> {
    public TrueNightsEdgeModel() {
        super(ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, ""));
    }

    @Override
    public ResourceLocation getModelResource(TrueNightsEdgeItem animatable) {
        return ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "geo/item/weapons/true_nights_edge.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(TrueNightsEdgeItem animatable) {
        return ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "textures/item/weapons/true_nights_edge.png");
    }

    @Override
    public ResourceLocation getAnimationResource(TrueNightsEdgeItem animatable) {
        return ResourceLocation.fromNamespaceAndPath(IronsSpellbooks.MODID, "animations/wizard_armor_animation.json");
    }
}
