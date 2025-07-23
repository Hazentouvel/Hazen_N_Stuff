package net.hazen.hazennstuff.item.armor.Geckolib.Legionnaire;

import io.redspace.ironsspellbooks.IronsSpellbooks;
import net.hazen.hazennstuff.HazenNStuff;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.DefaultedEntityGeoModel;

public class GeckolibLegionnaireArmorModel extends DefaultedEntityGeoModel<GeckolibLegionnaireArmorItem> {
    public GeckolibLegionnaireArmorModel() {
        super(ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, ""));
    }

    // Just replace where the path is with the file path of your texture, EZ PZ
    @Override
    public ResourceLocation getModelResource(GeckolibLegionnaireArmorItem animatable) {
        return ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "geo/armor/legionnaire/legionnaire_armor.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(GeckolibLegionnaireArmorItem animatable) {
        return ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "textures/armor/legionnaire/legionnaire_armor.png");
    }

    @Override
    public ResourceLocation getAnimationResource(GeckolibLegionnaireArmorItem animatable) {
        return ResourceLocation.fromNamespaceAndPath(IronsSpellbooks.MODID, "animations/wizard_armor_animation.json");
    }
}
