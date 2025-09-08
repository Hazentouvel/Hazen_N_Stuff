package net.hazen.hazennstuff.item.armor.Geckolib.Blazeborne;

import io.redspace.ironsspellbooks.IronsSpellbooks;
import net.hazen.hazennstuff.HazenNStuff;
import net.hazen.hazennstuff.item.armor.Geckolib.SoulFlame.GeckolibSoulFlameArmorItem;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.DefaultedEntityGeoModel;

public class GeckolibBlazeborneArmorModel extends DefaultedEntityGeoModel<GeckolibSoulFlameArmorItem> {
    public GeckolibBlazeborneArmorModel() {
        super(ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, ""));
    }

    // Just replace where the path is with the file path of your texture, EZ PZ
    @Override
    public ResourceLocation getModelResource(GeckolibSoulFlameArmorItem animatable) {
        return ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "geo/armor/blazeborne_armor_geckolib.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(GeckolibSoulFlameArmorItem animatable) {
        return ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "textures/armor/blazeborne_armor.png");
    }

    @Override
    public ResourceLocation getAnimationResource(GeckolibSoulFlameArmorItem animatable) {
        return ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "animations/armor/blazeborne_armor.animation.json");
    }
}

