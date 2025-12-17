package net.hazen.hazennstuff.Item.Armor.Geckolib.LegionnaireCommander;

import io.redspace.ironsspellbooks.IronsSpellbooks;
import net.hazen.hazennstuff.HazenNStuff;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.DefaultedEntityGeoModel;

public class LegionnaireCommanderArmorModel extends DefaultedEntityGeoModel<LegionnaireCommanderArmorItem> {
    public LegionnaireCommanderArmorModel() {
        super(ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, ""));
    }

    // Just replace where the path is with the file path of your texture, EZ PZ
    @Override
    public ResourceLocation getModelResource(LegionnaireCommanderArmorItem animatable) {
        return ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "geo/armor/legionnaire_commander_armor.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(LegionnaireCommanderArmorItem animatable) {
        return ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "textures/armor/legionnaire_commander_armor.png");
    }

    @Override
    public ResourceLocation getAnimationResource(LegionnaireCommanderArmorItem animatable) {
        return ResourceLocation.fromNamespaceAndPath(IronsSpellbooks.MODID, "animations/wizard_armor_animation.json");
    }
}
