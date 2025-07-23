package net.hazen.hazennstuff.item.armor.Geckolib.Atlas;

import net.hazen.hazennstuff.HazenNStuff;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.DefaultedEntityGeoModel;

public class AtlasArmorModel extends DefaultedEntityGeoModel<AtlasArmorItem> {
    public AtlasArmorModel() {
        super(ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, ""));
    }

    // Just replace where the path is with the file path of your texture, EZ PZ
    @Override
    public ResourceLocation getModelResource(AtlasArmorItem animatable) {
        return ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "geo/armor/atlas/atlas.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(AtlasArmorItem animatable) {
        return ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "textures/armor/atlas/atlas.png");
    }

    @Override
    public ResourceLocation getAnimationResource(AtlasArmorItem animatable) {
        return ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "animations/armor/atlas/atlas.animation.json");
    }
}
