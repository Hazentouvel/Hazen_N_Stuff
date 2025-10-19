package net.hazen.hazennstuff.Item.Armor.Geckolib.FleshMass;

import net.hazen.hazennstuff.HazenNStuff;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.DefaultedEntityGeoModel;

public class FleshMassArmorModel extends DefaultedEntityGeoModel<FleshMassArmorItem> {
    public FleshMassArmorModel() {
        super(ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, ""));
    }

    // Just replace where the path is with the file path of your texture, EZ PZ
    @Override
    public ResourceLocation getModelResource(FleshMassArmorItem animatable) {
        return ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "geo/armor/flesh_mass_armor.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(FleshMassArmorItem animatable) {
        return ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "textures/armor/flesh_mass_armor.png");
    }

    @Override
    public ResourceLocation getAnimationResource(FleshMassArmorItem animatable) {
        return ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "animations/armor/flesh_mass_armor.animation.json");
    }
}

