package net.hazen.hazennstuff.item.armor.Geckolib.Utau;

import io.redspace.ironsspellbooks.IronsSpellbooks;
import net.hazen.hazennstuff.HazenNStuff;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.DefaultedEntityGeoModel;

public class GeckolibUtauArmorModel extends DefaultedEntityGeoModel<GeckolibUtauArmorItem> {
    public GeckolibUtauArmorModel() {
        super(ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, ""));
    }

    // Just replace where the path is with the file path of your texture, EZ PZ
    @Override
    public ResourceLocation getModelResource(GeckolibUtauArmorItem animatable) {
        return ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "geo/armor/teto_kasane_utau_armor.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(GeckolibUtauArmorItem animatable) {
        return ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "textures/armor/teto_kasane_utau_armor.png");
    }

    @Override
    public ResourceLocation getAnimationResource(GeckolibUtauArmorItem animatable) {
        return ResourceLocation.fromNamespaceAndPath(IronsSpellbooks.MODID, "animations/wizard_armor_animation.json");

    }
}
