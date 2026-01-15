package net.hazen.hazennstuff.Item.Armor.Geckolib.MithrilBattlemage;

import io.redspace.ironsspellbooks.IronsSpellbooks;
import net.hazen.hazennstuff.HazenNStuff;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.DefaultedEntityGeoModel;

public class MithrilBattlemageArmorModel extends DefaultedEntityGeoModel<MithrilBattlemageArmorItem> {
    public MithrilBattlemageArmorModel() {
        super(ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, ""));
    }

    // Just replace where the path is with the file path of your texture, EZ PZ
    @Override
    public ResourceLocation getModelResource(MithrilBattlemageArmorItem animatable) {
        return ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "geo/armor/mithril_battlemage_armor.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(MithrilBattlemageArmorItem animatable) {
        return ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "textures/armor/mithril_battlemage_armor.png");
    }

    @Override
    public ResourceLocation getAnimationResource(MithrilBattlemageArmorItem animatable) {
        return ResourceLocation.fromNamespaceAndPath(IronsSpellbooks.MODID, "animations/wizard_armor_animation.json");
    }
}
