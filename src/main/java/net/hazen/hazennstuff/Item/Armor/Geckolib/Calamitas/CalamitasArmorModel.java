package net.hazen.hazennstuff.Item.Armor.Geckolib.Calamitas;

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
        return ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "geo/armor/calamitas_armor.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(CalamitasArmorItem animatable) {
        return ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "textures/armor/calamitas_armor.png");
    }

    @Override
    public ResourceLocation getAnimationResource(CalamitasArmorItem animatable) {
        return ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "animations/armor/calamitas_armor.animation.json");
    }
}
