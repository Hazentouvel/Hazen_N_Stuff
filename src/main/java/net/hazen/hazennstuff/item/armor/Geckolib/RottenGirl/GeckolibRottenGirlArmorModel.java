package net.hazen.hazennstuff.item.armor.Geckolib.RottenGirl;

import io.redspace.ironsspellbooks.IronsSpellbooks;
import net.hazen.hazennstuff.HazenNStuff;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.DefaultedEntityGeoModel;

public class GeckolibRottenGirlArmorModel extends DefaultedEntityGeoModel<GeckolibRottenGirlArmorItem> {
    public GeckolibRottenGirlArmorModel() {
        super(ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, ""));
    }

    // Just replace where the path is with the file path of your texture, EZ PZ
    @Override
    public ResourceLocation getModelResource(GeckolibRottenGirlArmorItem animatable) {
        return ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "geo/rotten_girl_geckolib.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(GeckolibRottenGirlArmorItem animatable) {
        return ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "textures/models/armor/geckolib/rotten_girl_armor.png");
    }

    @Override
    public ResourceLocation getAnimationResource(GeckolibRottenGirlArmorItem animatable) {
        return ResourceLocation.fromNamespaceAndPath(IronsSpellbooks.MODID, "animations/wizard_armor_animation.json");
    }
}
