package net.hazen.hazennstuff.Item.Armor.Geckolib.GabrielULTRAKILL;

import net.hazen.hazennstuff.HazenNStuff;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.DefaultedEntityGeoModel;

public class GeckolibGabrielElytraArmorModel extends DefaultedEntityGeoModel<GeckolibGabrielElytraItem> {
    public GeckolibGabrielElytraArmorModel() {
        super(ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, ""));
    }

    // Just replace where the path is with the file path of your texture, EZ PZ
    @Override
    public ResourceLocation getModelResource(GeckolibGabrielElytraItem animatable) {
        return ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "geo/armor/gabriel_ultrakill_armor.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(GeckolibGabrielElytraItem animatable) {
        return ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "textures/armor/gabriel_ultrakill_armor.png");
    }

    @Override
    public ResourceLocation getAnimationResource(GeckolibGabrielElytraItem animatable) {
        return ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "animations/armor/gabriel_ultrakill_armor.animation.json");
    }
}
