package net.hazen.hazennstuff.item.armor.Geckolib.CryogenicRuler;

import net.hazen.hazennstuff.HazenNStuff;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.DefaultedEntityGeoModel;

public class GeckolibCryogenicRulerArmorModel extends DefaultedEntityGeoModel<GeckolibCryogenicRulerArmorItem> {
    public GeckolibCryogenicRulerArmorModel() {
        super(ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, ""));
    }

    // Just replace where the path is with the file path of your texture, EZ PZ
    @Override
    public ResourceLocation getModelResource(GeckolibCryogenicRulerArmorItem animatable) {
        return ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "geo/cryogenic_ruler_armor_geckolib.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(GeckolibCryogenicRulerArmorItem animatable) {
        return ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "textures/models/armor/geckolib/cryogenic_ruler_armor.png");
    }

    @Override
    public ResourceLocation getAnimationResource(GeckolibCryogenicRulerArmorItem animatable) {
        return ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "animations/cryogenic_ruler_armor_geckolib.animation.json");

    }
}
