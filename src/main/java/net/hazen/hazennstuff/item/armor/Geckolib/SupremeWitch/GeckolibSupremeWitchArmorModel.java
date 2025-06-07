package net.hazen.hazennstuff.item.armor.Geckolib.SupremeWitch;

import net.hazen.hazennstuff.HazenNStuff;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.DefaultedEntityGeoModel;

public class GeckolibSupremeWitchArmorModel extends DefaultedEntityGeoModel<GeckolibSupremeWitchArmorItem> {
    public GeckolibSupremeWitchArmorModel() {
        super(ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, ""));
    }

    // Just replace where the path is with the file path of your texture, EZ PZ
    @Override
    public ResourceLocation getModelResource(GeckolibSupremeWitchArmorItem animatable) {
        return ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "geo/supreme_witch_armor_geckolib.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(GeckolibSupremeWitchArmorItem animatable) {
        return ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "textures/models/armor/geckolib/supreme_witch_armor.png");
    }

    @Override
    public ResourceLocation getAnimationResource(GeckolibSupremeWitchArmorItem animatable) {
        return ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "animations/supreme_witch_armor_geckolib.animation.json");
    }
}
