package net.hazen.hazennstuff.item.armor.Geckolib.ShadowScale;

import io.redspace.ironsspellbooks.IronsSpellbooks;
import net.hazen.hazennstuff.HazenNStuff;
import net.hazen.hazennstuff.item.armor.Geckolib.SoulFlame.GeckolibSoulFlameArmorItem;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.DefaultedEntityGeoModel;

public class ShadowScaleArmorModel extends DefaultedEntityGeoModel<ShadowScaleArmorItem> {
    public ShadowScaleArmorModel() {
        super(ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, ""));
    }

    // Just replace where the path is with the file path of your texture, EZ PZ
    @Override
    public ResourceLocation getModelResource(ShadowScaleArmorItem animatable) {
        return ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "geo/armor/soul_flame_armor_geckolib.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(ShadowScaleArmorItem animatable) {
        return ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "textures/armor/soul_flame_armor.png");
    }

    @Override
    public ResourceLocation getAnimationResource(ShadowScaleArmorItem animatable) {
        return ResourceLocation.fromNamespaceAndPath(IronsSpellbooks.MODID, "animations/wizard_armor_animation.json");
    }
}

