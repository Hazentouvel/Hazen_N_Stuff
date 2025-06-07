package net.hazen.hazennstuff.item.armor.Geckolib.Frieren;

import io.redspace.ironsspellbooks.IronsSpellbooks;
import net.hazen.hazennstuff.HazenNStuff;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.DefaultedEntityGeoModel;

public class GeckolibFrierenArmorModel extends DefaultedEntityGeoModel<GeckolibFrierenArmorItem> {
    public GeckolibFrierenArmorModel() {
        super(ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, ""));
    }

    // Just replace where the path is with the file path of your texture, EZ PZ
    @Override
    public ResourceLocation getModelResource(GeckolibFrierenArmorItem animatable) {
        return ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "geo/frieren_armor_geckolib.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(GeckolibFrierenArmorItem animatable) {
        return ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "textures/models/armor/geckolib/frieren_armor_geckolib.png");
    }

    @Override
    public ResourceLocation getAnimationResource(GeckolibFrierenArmorItem animatable) {
        return ResourceLocation.fromNamespaceAndPath(IronsSpellbooks.MODID, "animations/wizard_armor_animation.json");
    }
}
