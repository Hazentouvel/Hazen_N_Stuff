package net.hazen.hazennstuff.Item.Armor.Geckolib.ArbitriumRobes;

import net.hazen.hazennstuff.HazenNStuff;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.DefaultedEntityGeoModel;

public class GeckolibArbitriumRobesArmorModel extends DefaultedEntityGeoModel<GeckolibArbitriumRobesArmorItem> {
    public GeckolibArbitriumRobesArmorModel() {
        super(ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, ""));
    }

    // Just replace where the path is with the file path of your texture, EZ PZ
    @Override
    public ResourceLocation getModelResource(GeckolibArbitriumRobesArmorItem animatable) {
        return ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "geo/armor/arbitrium_robes_armor.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(GeckolibArbitriumRobesArmorItem animatable) {
        return ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "textures/armor/arbitrium_robes_armor_geckolib.png");
    }

    @Override
    public ResourceLocation getAnimationResource(GeckolibArbitriumRobesArmorItem animatable) {
        return ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "animations/armor/arbitrium_robes_armor.animation.json");
    }
}
