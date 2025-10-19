package net.hazen.hazennstuff.Item.Armor.Geckolib.ThunderProwler;

import io.redspace.ironsspellbooks.IronsSpellbooks;
import net.hazen.hazennstuff.HazenNStuff;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.DefaultedEntityGeoModel;

public class ThunderProwlerArmorModel extends DefaultedEntityGeoModel<ThunderProwlerArmorItem> {
    public ThunderProwlerArmorModel() {
        super(ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, ""));
    }

    // Just replace where the path is with the file path of your texture, EZ PZ
    @Override
    public ResourceLocation getModelResource(ThunderProwlerArmorItem animatable) {
        return ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "geo/armor/thunder_prowler_armor.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(ThunderProwlerArmorItem animatable) {
        return ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "textures/armor/thunder_prowler_armor.png");
    }

    @Override
    public ResourceLocation getAnimationResource(ThunderProwlerArmorItem animatable) {
        return ResourceLocation.fromNamespaceAndPath(IronsSpellbooks.MODID, "animations/wizard_armor_animation.json");
    }
}
