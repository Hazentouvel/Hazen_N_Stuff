package net.hazen.hazennstuff.item.armor.Geckolib.ArbitriumRobes;

import net.hazen.hazennstuff.HazenNStuff;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.DefaultedEntityGeoModel;

public class GeckolibArbitriumRobesArmorModel extends DefaultedEntityGeoModel<ArbitriumRobesGeckolibArmorItem> {
    public GeckolibArbitriumRobesArmorModel() {
        super(ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, ""));
    }

    // Just replace where the path is with the file path of your texture, EZ PZ
    @Override
    public ResourceLocation getModelResource(ArbitriumRobesGeckolibArmorItem animatable) {
        return ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "geo/armor/arbitrium_robes_armor.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(ArbitriumRobesGeckolibArmorItem animatable) {
        return ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "textures/armor/arbitrium_robes_geckolib.png");
    }

    @Override
    public ResourceLocation getAnimationResource(ArbitriumRobesGeckolibArmorItem animatable) {
        return ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "animations/armor/arbitrium_robes_geckolib.animation.json");
    }
}
