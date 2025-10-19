package net.hazen.hazennstuff.Item.Armor.Geckolib.CrystalArachnid;

import io.redspace.ironsspellbooks.IronsSpellbooks;
import net.hazen.hazennstuff.HazenNStuff;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.DefaultedEntityGeoModel;

public class CrystalArachnidArmorModel extends DefaultedEntityGeoModel<CrystalArachnidArmorItem> {
    public CrystalArachnidArmorModel() {
        super(ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, ""));
    }

    // Just replace where the path is with the file path of your texture, EZ PZ
    @Override
    public ResourceLocation getModelResource(CrystalArachnidArmorItem animatable) {
        return ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "geo/armor/crystal_arachnid_armor.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(CrystalArachnidArmorItem animatable) {
        return ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "textures/armor/crystal_arachnid_armor.png");
    }

    @Override
    public ResourceLocation getAnimationResource(CrystalArachnidArmorItem animatable) {
        return ResourceLocation.fromNamespaceAndPath(IronsSpellbooks.MODID, "animations/wizard_armor_animation.json");
    }
}
