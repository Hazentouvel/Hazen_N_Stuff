package net.hazen.hazennstuff.Item.UpgradeOrbs.Concentrated.Fire;

import net.hazen.hazennstuff.HazenNStuff;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.DefaultedItemGeoModel;

public class ConcentratedFireUpgradeOrbModel extends DefaultedItemGeoModel<ConcentratedFireUpgradeOrb> {
    public ConcentratedFireUpgradeOrbModel() {
        super(ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, ""));
    }

    @Override
    public ResourceLocation getModelResource(ConcentratedFireUpgradeOrb animatable) {
        return ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "geo/item/upgrade_orbs/concentrated_upgrade_orb_core.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(ConcentratedFireUpgradeOrb animatable) {
        return ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "textures/upgrade_orbs/concentrated_upgrade_orb_fire.png");
    }

    @Override
    public ResourceLocation getAnimationResource(ConcentratedFireUpgradeOrb animatable) {
        return ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "animations/upgrade_orbs/concentrated_upgrade_orb.animation.json");
    }
}
