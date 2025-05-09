package net.hazen.hazennstuff.entity.armor.Geckolib;

import io.redspace.ironsspellbooks.IronsSpellbooks;
import net.hazen.hazennstuff.HazenNStuff;
import net.hazen.hazennstuff.item.armor.Geckolib.GeckolibDarkRitualTemplarArmorItem;
import net.hazen.hazennstuff.item.armor.Geckolib.GeckolibFleshMassArmorItem;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.DefaultedEntityGeoModel;

public class GeckolibDarkRitualTemplarArmorModel extends DefaultedEntityGeoModel<GeckolibDarkRitualTemplarArmorItem> {
    public GeckolibDarkRitualTemplarArmorModel() {
        super(ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, ""));
    }

    // Just replace where the path is with the file path of your texture, EZ PZ
    @Override
    public ResourceLocation getModelResource(GeckolibDarkRitualTemplarArmorItem animatable) {
        return ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "geo/dark_ritual_templar_armor_geckolib.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(GeckolibDarkRitualTemplarArmorItem animatable) {
        return ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "textures/models/armor/geckolib/dark_ritual_templar_armor.png");
    }

    @Override
    public ResourceLocation getAnimationResource(GeckolibDarkRitualTemplarArmorItem animatable) {
        return ResourceLocation.fromNamespaceAndPath(IronsSpellbooks.MODID, "animations/wizard_armor_animation.json");
    }
}

