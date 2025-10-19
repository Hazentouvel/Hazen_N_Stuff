package net.hazen.hazennstuff.Item.Armor.Geckolib.CryogenicRuler;

import net.hazen.hazennstuff.HazenNStuff;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.DefaultedEntityGeoModel;

public class CryogenicRulerArmorModel extends DefaultedEntityGeoModel<CryogenicRulerArmorItem> {
    public CryogenicRulerArmorModel() {
        super(ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, ""));
    }

    // Just replace where the path is with the file path of your texture, EZ PZ
    @Override
    public ResourceLocation getModelResource(CryogenicRulerArmorItem animatable) {
        return ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "geo/armor/cryogenic_ruler_armor.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(CryogenicRulerArmorItem animatable) {
        return ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "textures/armor/cryogenic_ruler_armor.png");
    }

    @Override
    public ResourceLocation getAnimationResource(CryogenicRulerArmorItem animatable) {
        return ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "animations/armor/cryogenic_ruler_armor.animation.json");

    }
}
