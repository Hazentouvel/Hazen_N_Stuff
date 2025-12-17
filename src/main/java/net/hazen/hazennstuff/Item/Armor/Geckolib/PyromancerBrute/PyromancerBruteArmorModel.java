package net.hazen.hazennstuff.Item.Armor.Geckolib.PyromancerBrute;

import io.redspace.ironsspellbooks.IronsSpellbooks;
import net.hazen.hazennstuff.HazenNStuff;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.DefaultedEntityGeoModel;

public class PyromancerBruteArmorModel extends DefaultedEntityGeoModel<PyromancerBruteArmorItem> {
    public PyromancerBruteArmorModel() {
        super(ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, ""));
    }

    // Just replace where the path is with the file path of your texture, EZ PZ
    @Override
    public ResourceLocation getModelResource(PyromancerBruteArmorItem animatable) {
        return ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "geo/armor/thunder_prowler_armor.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(PyromancerBruteArmorItem animatable) {
        return ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "textures/armor/thunder_prowler_armor.png");
    }

    @Override
    public ResourceLocation getAnimationResource(PyromancerBruteArmorItem animatable) {
        return ResourceLocation.fromNamespaceAndPath(IronsSpellbooks.MODID, "animations/wizard_armor_animation.json");
    }
}
