package net.hazen.hazennstuff.Item.Armor.Geckolib.ShadowWalkerEnderman;

import io.redspace.ironsspellbooks.IronsSpellbooks;
import net.hazen.hazennstuff.HazenNStuff;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.DefaultedEntityGeoModel;

public class ShadowwalkerEndermanArmorModel extends DefaultedEntityGeoModel<ShadowwalkerEndermanArmorItem> {
    public ShadowwalkerEndermanArmorModel() {
        super(ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, ""));
    }

    // Just replace where the path is with the file path of your texture, EZ PZ
    @Override
    public ResourceLocation getModelResource(ShadowwalkerEndermanArmorItem animatable) {
        return ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "geo/armor/shadowwalker_enderman_armor.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(ShadowwalkerEndermanArmorItem animatable) {
        return ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "textures/armor/shadowwalker_enderman_armor.png");
    }

    @Override
    public ResourceLocation getAnimationResource(ShadowwalkerEndermanArmorItem animatable) {
        return ResourceLocation.fromNamespaceAndPath(IronsSpellbooks.MODID, "animations/wizard_armor_animation.json");

    }
}

