package net.hazen.hazennstuff.Item.Armor.Geckolib.Chlorophyte.Headgear;

import io.redspace.ironsspellbooks.IronsSpellbooks;
import net.hazen.hazennstuff.HazenNStuff;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.DefaultedEntityGeoModel;

public class ChlorophyteHeadgearArmorModel extends DefaultedEntityGeoModel<ChlorophyteHeadgearArmorItem> {
    public ChlorophyteHeadgearArmorModel() {
        super(ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, ""));
    }

    // Just replace where the path is with the file path of your texture, EZ PZ
    @Override
    public ResourceLocation getModelResource(ChlorophyteHeadgearArmorItem animatable) {
        return ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "geo/armor/chlorophyte_armor.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(ChlorophyteHeadgearArmorItem animatable) {
        return ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "textures/armor/chlorophyte_headgear_armor.png");
    }

    @Override
    public ResourceLocation getAnimationResource(ChlorophyteHeadgearArmorItem animatable) {
        return ResourceLocation.fromNamespaceAndPath(IronsSpellbooks.MODID, "animations/wizard_armor_animation.json");
    }
}
