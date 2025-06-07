package net.hazen.hazennstuff.item.armor.Geckolib.FireblossomBattlemage;

import net.hazen.hazennstuff.HazenNStuff;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.DefaultedEntityGeoModel;

public class GeckolibFireblossomBattlemageHelmetArmorModel extends DefaultedEntityGeoModel<GeckolibFireblossomBattlemageHelmetArmorItem> {
    public GeckolibFireblossomBattlemageHelmetArmorModel() {
        super(ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, ""));
    }

    // Just replace where the path is with the file path of your texture, EZ PZ
    @Override
    public ResourceLocation getModelResource(GeckolibFireblossomBattlemageHelmetArmorItem animatable) {
        return ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "geo/fireblossom_battlemage_armor_geckolib.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(GeckolibFireblossomBattlemageHelmetArmorItem animatable) {
        return ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "textures/models/armor/geckolib/fireblossom_battlemage_helmet_armor.png");
    }

    @Override
    public ResourceLocation getAnimationResource(GeckolibFireblossomBattlemageHelmetArmorItem animatable) {
        return ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "animations/fireblossom_battlemage_armor_geckolib.animation.json");

    }
}
