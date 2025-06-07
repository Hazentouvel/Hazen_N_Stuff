package net.hazen.hazennstuff.item.armor.Geckolib.Calamitas;

import net.hazen.hazennstuff.HazenNStuff;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.DefaultedEntityGeoModel;

public class CalamitasArmorModel extends DefaultedEntityGeoModel<CalamitasArmorItem> {
    public CalamitasArmorModel() {
        super(ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, ""));
    }

    // Just replace where the path is with the file path of your texture, EZ PZ
    @Override
    public ResourceLocation getModelResource(CalamitasArmorItem animatable) {
        return ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "geo/calamitas.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(CalamitasArmorItem animatable) {
        return ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "textures/models/armor/geckolib/calamitas.png");
    }

    @Override
    public ResourceLocation getAnimationResource(CalamitasArmorItem animatable) {
        return ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "animations/calamitas.animation.json");
    }
}
