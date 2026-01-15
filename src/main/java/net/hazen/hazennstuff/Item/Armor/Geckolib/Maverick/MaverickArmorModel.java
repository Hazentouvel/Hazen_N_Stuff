package net.hazen.hazennstuff.Item.Armor.Geckolib.Maverick;

import net.hazen.hazennstuff.HazenNStuff;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.DefaultedEntityGeoModel;

public class MaverickArmorModel extends DefaultedEntityGeoModel<MaverickArmorItem> {
    public MaverickArmorModel() {
        super(ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, ""));
    }

    // Just replace where the path is with the file path of your texture, EZ PZ
    @Override
    public ResourceLocation getModelResource(MaverickArmorItem animatable) {
        return ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "geo/armor/maverick_armor.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(MaverickArmorItem animatable) {
        return ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "textures/armor/maverick_armor.png");
    }

    @Override
    public ResourceLocation getAnimationResource(MaverickArmorItem animatable) {
        return ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "animations/armor/maverick_armor.animation.json");
    }
}
