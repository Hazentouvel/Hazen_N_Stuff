package net.hazen.hazennstuff.Item.Armor.Geckolib.PyriumBattlemage;

import io.redspace.ironsspellbooks.IronsSpellbooks;
import net.hazen.hazennstuff.HazenNStuff;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.DefaultedEntityGeoModel;

public class PyriumBattlemageArmorModel extends DefaultedEntityGeoModel<PyriumBattlemageArmorItem> {
    public PyriumBattlemageArmorModel() {
        super(ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, ""));
    }

    // Just replace where the path is with the file path of your texture, EZ PZ
    @Override
    public ResourceLocation getModelResource(PyriumBattlemageArmorItem animatable) {
        return ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "geo/armor/pyrium_battlemage_armor.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(PyriumBattlemageArmorItem animatable) {
        return ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "textures/armor/pyrium_battlemage_armor.png");
    }

    @Override
    public ResourceLocation getAnimationResource(PyriumBattlemageArmorItem animatable) {
        return ResourceLocation.fromNamespaceAndPath(IronsSpellbooks.MODID, "animations/wizard_armor_animation.json");
    }
}
