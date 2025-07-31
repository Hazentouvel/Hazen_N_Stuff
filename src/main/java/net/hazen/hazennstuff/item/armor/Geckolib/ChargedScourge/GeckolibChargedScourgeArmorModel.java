package net.hazen.hazennstuff.item.armor.Geckolib.ChargedScourge;

import io.redspace.ironsspellbooks.IronsSpellbooks;
import net.hazen.hazennstuff.HazenNStuff;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.DefaultedEntityGeoModel;

public class GeckolibChargedScourgeArmorModel extends DefaultedEntityGeoModel<GeckolibChargedScourgeArmorItem> {
    public GeckolibChargedScourgeArmorModel() {
        super(ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, ""));
    }

    // Just replace where the path is with the file path of your texture, EZ PZ
    @Override
    public ResourceLocation getModelResource(GeckolibChargedScourgeArmorItem animatable) {
        return ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "geo/armor/charged_scourge_armor_geckolib.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(GeckolibChargedScourgeArmorItem animatable) {
        return ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "textures/armor/charged_scourge_armor.png");
    }

    @Override
    public ResourceLocation getAnimationResource(GeckolibChargedScourgeArmorItem animatable) {
        return ResourceLocation.fromNamespaceAndPath(IronsSpellbooks.MODID, "animations/wizard_armor_animation.json");
    }
}
