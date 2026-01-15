package net.hazen.hazennstuff.Item.Armor.Geckolib.SupremeWitch;

import io.redspace.ironsspellbooks.IronsSpellbooks;
import net.hazen.hazennstuff.HazenNStuff;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.DefaultedEntityGeoModel;

public class GeckolibSupremeWitchArmorModel extends DefaultedEntityGeoModel<GeckolibSupremeWitchArmorItem> {
    public GeckolibSupremeWitchArmorModel() {
        super(ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, ""));
    }

    // Just replace where the path is with the file path of your texture, EZ PZ
    @Override
    public ResourceLocation getModelResource(GeckolibSupremeWitchArmorItem animatable) {
        return ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "geo/armor/supreme_witch_armor.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(GeckolibSupremeWitchArmorItem animatable) {
        return ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "textures/armor/supreme_witch_armor.png");
    }

    @Override
    public ResourceLocation getAnimationResource(GeckolibSupremeWitchArmorItem animatable) {
        return ResourceLocation.fromNamespaceAndPath(IronsSpellbooks.MODID, "animations/wizard_armor_animation.json");
    }
}
