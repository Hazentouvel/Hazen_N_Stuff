package net.hazen.hazennstuff.item.armor.Geckolib.Seraph;

import net.hazen.hazennstuff.HazenNStuff;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.DefaultedEntityGeoModel;

public class GeckolibSeraphArmorModel extends DefaultedEntityGeoModel<GeckolibSeraphArmorItem> {
    public GeckolibSeraphArmorModel() {
        super(ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, ""));
    }

    @Override
    public ResourceLocation getModelResource(GeckolibSeraphArmorItem animatable) {
        return ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "geo/seraph_armor_geckolib.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(GeckolibSeraphArmorItem animatable) {
        return ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "textures/models/armor/geckolib/seraph_armor.png");
    }

    @Override
    public ResourceLocation getAnimationResource(GeckolibSeraphArmorItem animatable) {
        return ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "animations/seraph_armor_geckolib.animation.json");
    }
}
