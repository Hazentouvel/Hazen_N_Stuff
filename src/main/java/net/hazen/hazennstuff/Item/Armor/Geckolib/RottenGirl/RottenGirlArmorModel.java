package net.hazen.hazennstuff.Item.Armor.Geckolib.RottenGirl;

import io.redspace.ironsspellbooks.IronsSpellbooks;
import net.hazen.hazennstuff.HazenNStuff;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.DefaultedEntityGeoModel;

public class RottenGirlArmorModel extends DefaultedEntityGeoModel<RottenGirlArmorItem> {
    public RottenGirlArmorModel() {
        super(ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, ""));
    }

    // Just replace where the path is with the file path of your texture, EZ PZ
    @Override
    public ResourceLocation getModelResource(RottenGirlArmorItem animatable) {
        return ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "geo/armor/rotten_girl_armor.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(RottenGirlArmorItem animatable) {
        return ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "textures/armor/rotten_girl_armor.png");
    }

    @Override
    public ResourceLocation getAnimationResource(RottenGirlArmorItem animatable) {
        return ResourceLocation.fromNamespaceAndPath(IronsSpellbooks.MODID, "animations/wizard_armor_animation.json");
    }
}
