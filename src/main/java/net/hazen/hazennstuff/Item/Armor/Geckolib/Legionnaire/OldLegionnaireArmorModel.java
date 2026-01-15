package net.hazen.hazennstuff.Item.Armor.Geckolib.Legionnaire;

import io.redspace.ironsspellbooks.IronsSpellbooks;
import net.hazen.hazennstuff.HazenNStuff;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.DefaultedEntityGeoModel;

public class OldLegionnaireArmorModel extends DefaultedEntityGeoModel<OldLegionnaireArmorItem> {
    public OldLegionnaireArmorModel() {
        super(ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, ""));
    }

    // Just replace where the path is with the file path of your texture, EZ PZ
    @Override
    public ResourceLocation getModelResource(OldLegionnaireArmorItem animatable) {
        return ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "geo/armor/legionnaire_armor.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(OldLegionnaireArmorItem animatable) {
        return ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "textures/armor/legionnaire_armor.png");
    }

    @Override
    public ResourceLocation getAnimationResource(OldLegionnaireArmorItem animatable) {
        return ResourceLocation.fromNamespaceAndPath(IronsSpellbooks.MODID, "animations/wizard_armor_animation.json");
    }
}
