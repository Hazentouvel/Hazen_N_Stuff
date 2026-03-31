package net.hazen.hazennstuff.Item.Armor.Dedicated.Fireblossom.Legacy;

import net.hazen.hazennstuff.HazenNStuff;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.DefaultedEntityGeoModel;

public class GeckolibFireblossomBattlemageArmorModelLegacy extends DefaultedEntityGeoModel<GeckolibFireblossomBattlemageArmorItemLegacy> {
    public GeckolibFireblossomBattlemageArmorModelLegacy() {
        super(ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, ""));
    }

    // Just replace where the path is with the file path of your texture, EZ PZ
    @Override
    public ResourceLocation getModelResource(GeckolibFireblossomBattlemageArmorItemLegacy animatable) {
        return ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "geo/armor/fireblossom_battlemage_armor_legacy.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(GeckolibFireblossomBattlemageArmorItemLegacy animatable) {
        return ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "textures/armor/fireblossom_battlemage_crowned_armor_legacy.png");
    }

    @Override
    public ResourceLocation getAnimationResource(GeckolibFireblossomBattlemageArmorItemLegacy animatable) {
        return ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "animations/armor/fireblossom_battlemage_armor_legacy.animation.json");

    }
}
