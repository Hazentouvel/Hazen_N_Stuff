package net.hazen.hazennstuff.Item.Armor.Geckolib.LegionnaireRuler.Soul;

import io.redspace.ironsspellbooks.IronsSpellbooks;
import net.hazen.hazennstuff.HazenNStuff;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.DefaultedEntityGeoModel;

public class SoulLegionnaireRulerArmorModel extends DefaultedEntityGeoModel<SoulLegionnaireRulerArmorItem> {
    public SoulLegionnaireRulerArmorModel() {
        super(ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, ""));
    }

    // Just replace where the path is with the file path of your texture, EZ PZ
    @Override
    public ResourceLocation getModelResource(SoulLegionnaireRulerArmorItem animatable) {
        return ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "geo/armor/legionnaire_ruler_armor.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(SoulLegionnaireRulerArmorItem animatable) {
        return ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "textures/armor/legionnaire_ruler_soul_armor.png");
    }

    @Override
    public ResourceLocation getAnimationResource(SoulLegionnaireRulerArmorItem animatable) {
        return ResourceLocation.fromNamespaceAndPath(IronsSpellbooks.MODID, "animations/wizard_armor_animation.json");
    }
}
