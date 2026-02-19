package net.hazen.hazennstuff.Item.UpgradeOrbs.Concentrated.Ice;

import net.hazen.hazennstuff.HazenNStuff;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.DefaultedItemGeoModel;

public class ConcentratedIceUpgradeOrbModel extends DefaultedItemGeoModel<ConcentratedIceUpgradeOrb> {
    public ConcentratedIceUpgradeOrbModel() {
        super(ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, ""));
    }

    @Override
    public ResourceLocation getModelResource(ConcentratedIceUpgradeOrb animatable) {
        return ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "geo/item/upgrade_orbs/concentrated_upgrade_orb_ice.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(ConcentratedIceUpgradeOrb animatable) {
        return ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "textures/upgrade_orbs/concentrated_upgrade_orb_ice.png");
    }

    @Override
    public ResourceLocation getAnimationResource(ConcentratedIceUpgradeOrb animatable) {
        return ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "animations/upgrade_orbs/concentrated_upgrade_orb_ice.animation.json");
    }
}
