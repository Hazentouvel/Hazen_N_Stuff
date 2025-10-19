package net.hazen.hazennstuff.Item.Armor.Geckolib.MothicWitch;

import io.redspace.ironsspellbooks.IronsSpellbooks;
import net.hazen.hazennstuff.HazenNStuff;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.DefaultedEntityGeoModel;

public class NerfedMothicWitchArmorModel extends DefaultedEntityGeoModel<NerfedMothicWitchArmorItem> {
    public NerfedMothicWitchArmorModel() {
        super(ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, ""));
    }

    // Just replace where the path is with the file path of your texture, EZ PZ
    @Override
    public ResourceLocation getModelResource(NerfedMothicWitchArmorItem animatable) {
        return ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "geo/armor/mothic_witch_armor.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(NerfedMothicWitchArmorItem animatable) {
        return ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "textures/armor/nerfed_mothic_witch_armor.png");
    }

    @Override
    public ResourceLocation getAnimationResource(NerfedMothicWitchArmorItem animatable) {
        return ResourceLocation.fromNamespaceAndPath(IronsSpellbooks.MODID, "animations/wizard_armor_animation.json");
    }
}

