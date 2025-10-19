package net.hazen.hazennstuff.Item.Weapons.BountifulHarvest;

import io.redspace.ironsspellbooks.IronsSpellbooks;
import net.hazen.hazennstuff.HazenNStuff;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.DefaultedItemGeoModel;

public class BountifulHarvestModel extends DefaultedItemGeoModel<BountifulHarvestItem> {
    public BountifulHarvestModel() {
        super(ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, ""));
    }

    @Override
    public ResourceLocation getModelResource(BountifulHarvestItem animatable) {
        return ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "geo/item/weapons/bountiful_harvest.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(BountifulHarvestItem animatable) {
        return ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "textures/item/weapons/bountiful_harvest.png");
    }

    @Override
    public ResourceLocation getAnimationResource(BountifulHarvestItem animatable) {
        return ResourceLocation.fromNamespaceAndPath(IronsSpellbooks.MODID, "animations/wizard_armor_animation.json");
    }
}
