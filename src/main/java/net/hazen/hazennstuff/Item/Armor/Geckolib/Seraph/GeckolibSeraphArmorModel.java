package net.hazen.hazennstuff.Item.Armor.Geckolib.Seraph;

import net.hazen.hazennstuff.HazenNStuff;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.DefaultedEntityGeoModel;

public class GeckolibSeraphArmorModel extends DefaultedEntityGeoModel<GeckolibSeraphArmorItem> {
    public GeckolibSeraphArmorModel() {
        super(ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, ""));
    }

    @Override
    public ResourceLocation getModelResource(GeckolibSeraphArmorItem animatable) {
        return ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "geo/armor/seraph_armor.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(GeckolibSeraphArmorItem animatable) {
        return ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "textures/armor/seraph_armor_geckolib.png");
    }

    @Override
    public ResourceLocation getAnimationResource(GeckolibSeraphArmorItem animatable) {
        return ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "animations/armor/seraph_armor.animation.json");
    }
}
