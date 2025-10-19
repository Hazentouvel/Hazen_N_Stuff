package net.hazen.hazennstuff.Item.Armor.Geckolib.TheWither;

import net.hazen.hazennstuff.HazenNStuff;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.DefaultedEntityGeoModel;

public class GeckolibTheWitherArmorModel extends DefaultedEntityGeoModel<GeckolibTheWitherArmorItem> {
    public GeckolibTheWitherArmorModel() {
        super(ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, ""));
    }

    // Just replace where the path is with the file path of your texture, EZ PZ
    @Override
    public ResourceLocation getModelResource(GeckolibTheWitherArmorItem animatable) {
        return ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "geo/armor/the_wither_armor.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(GeckolibTheWitherArmorItem animatable) {
        return ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "textures/armor/the_wither_armor.png");
    }

    @Override
    public ResourceLocation getAnimationResource(GeckolibTheWitherArmorItem animatable) {
        return ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "animations/armor/the_wither_armor.animation.json");
    }
}
