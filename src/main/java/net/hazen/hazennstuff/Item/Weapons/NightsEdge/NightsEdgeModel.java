package net.hazen.hazennstuff.Item.Weapons.NightsEdge;

import io.redspace.ironsspellbooks.IronsSpellbooks;
import net.hazen.hazennstuff.HazenNStuff;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.DefaultedItemGeoModel;

public class NightsEdgeModel extends DefaultedItemGeoModel<NightsEdgeItem> {
    public NightsEdgeModel() {
        super(ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, ""));
    }

    @Override
    public ResourceLocation getModelResource(NightsEdgeItem animatable) {
        return ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "geo/item/weapons/nights_edge.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(NightsEdgeItem animatable) {
        return ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "textures/item/weapons/nights_edge.png");
    }

    @Override
    public ResourceLocation getAnimationResource(NightsEdgeItem animatable) {
        return ResourceLocation.fromNamespaceAndPath(IronsSpellbooks.MODID, "animations/wizard_armor_animation.json");
    }
}
