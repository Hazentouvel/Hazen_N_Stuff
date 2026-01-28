package net.hazen.hazennstuff.Item.UpgradeOrbs.Tier2.Test;

import io.redspace.ironsspellbooks.IronsSpellbooks;
import net.hazen.hazennstuff.HazenNStuff;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.DefaultedItemGeoModel;

public class EnhancedFireUpgradeOrbModel extends DefaultedItemGeoModel<EnhancedFireUpgradeOrb> {
    public EnhancedFireUpgradeOrbModel() {
        super(ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, ""));
    }

    @Override
    public ResourceLocation getModelResource(EnhancedFireUpgradeOrb animatable) {
        return ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "geo/item/staves/divine_scepter.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(EnhancedFireUpgradeOrb animatable) {
        return ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "textures/item/staves/divine_scepter.png");
    }

    @Override
    public ResourceLocation getAnimationResource(EnhancedFireUpgradeOrb animatable) {
        return ResourceLocation.fromNamespaceAndPath(IronsSpellbooks.MODID, "animations/wizard_armor_animation.json");
    }
}
