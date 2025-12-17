package net.hazen.hazennstuff.Item.Armor.Geckolib.FireblossomBattlemage;

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
        return ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "geo/armor/fireblossom_battlemage_armor.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(GeckolibFireblossomBattlemageHelmetArmorItem animatable) {
        return ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "textures/armor/fireblossom_battlemage_helmet_armor.png");
    }

    @Override
    public ResourceLocation getAnimationResource(GeckolibFireblossomBattlemageHelmetArmorItem animatable) {
        return ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "animations/armor/fireblossom_battlemage_armor.animation.json");

    }
}
