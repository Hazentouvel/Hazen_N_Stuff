package net.hazen.hazennstuff.Item.Armor.Geckolib.Infestation;

import net.hazen.hazennstuff.HazenNStuff;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.DefaultedEntityGeoModel;

public class GeckolibInfestationArmorModel extends DefaultedEntityGeoModel<GeckolibInfestationArmorItem> {
    public GeckolibInfestationArmorModel() {
        super(ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, ""));
    }

    // Just replace where the path is with the file path of your texture, EZ PZ
    @Override
    public ResourceLocation getModelResource(GeckolibInfestationArmorItem animatable) {
        return ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "geo/armor/infestation_armor.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(GeckolibInfestationArmorItem animatable) {
        return ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "textures/armor/infestation_armor.png");
    }

    @Override
    public ResourceLocation getAnimationResource(GeckolibInfestationArmorItem animatable) {
        return ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "animations/armor/infestation_armor_animation.json");
    }
}

