package net.hazen.hazennstuff.Item.Armor.Geckolib.MothicWitch;

import io.redspace.ironsspellbooks.IronsSpellbooks;
import net.hazen.hazennstuff.HazenNStuff;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.DefaultedEntityGeoModel;

public class MothicWitchArmorModel extends DefaultedEntityGeoModel<MothicWitchArmorItem> {
    public MothicWitchArmorModel() {
        super(ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, ""));
    }

    // Just replace where the path is with the file path of your texture, EZ PZ
    @Override
    public ResourceLocation getModelResource(MothicWitchArmorItem animatable) {
        return ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "geo/armor/mothic_witch_armor.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(MothicWitchArmorItem animatable) {
        return ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "textures/armor/mothic_witch_armor.png");
    }

    @Override
    public ResourceLocation getAnimationResource(MothicWitchArmorItem animatable) {
        return ResourceLocation.fromNamespaceAndPath(IronsSpellbooks.MODID, "animations/wizard_armor_animation.json");
    }
}

