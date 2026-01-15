package net.hazen.hazennstuff.Item.Armor.Geckolib.GarmentsOfTheFirstFlamebearer.SoulMode;

import io.redspace.ironsspellbooks.IronsSpellbooks;
import net.hazen.hazennstuff.HazenNStuff;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.DefaultedEntityGeoModel;

public class GarmentsOfTheFirstFlamebearerSoulArmorModel extends DefaultedEntityGeoModel<GarmentsOfTheFirstFlamebearerSoulArmorItem> {
    public GarmentsOfTheFirstFlamebearerSoulArmorModel() {
        super(ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, ""));
    }

    // Just replace where the path is with the file path of your texture, EZ PZ
    @Override
    public ResourceLocation getModelResource(GarmentsOfTheFirstFlamebearerSoulArmorItem animatable) {
        return ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "geo/armor/garments_of_the_first_flamebearer_armor.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(GarmentsOfTheFirstFlamebearerSoulArmorItem animatable) {
        return ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "textures/armor/garments_of_the_first_flamebearer_soul_armor.png");
    }

    @Override
    public ResourceLocation getAnimationResource(GarmentsOfTheFirstFlamebearerSoulArmorItem animatable) {
        return ResourceLocation.fromNamespaceAndPath(IronsSpellbooks.MODID, "animations/wizard_armor_animation.json");
    }
}

