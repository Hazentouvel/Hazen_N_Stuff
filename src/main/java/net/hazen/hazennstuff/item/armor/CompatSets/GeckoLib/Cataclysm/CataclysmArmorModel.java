package net.hazen.hazennstuff.item.armor.CompatSets.GeckoLib.Cataclysm;

import io.redspace.ironsspellbooks.IronsSpellbooks;
import net.hazen.hazennstuff.HazenNStuff;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.DefaultedEntityGeoModel;

public class CataclysmArmorModel extends DefaultedEntityGeoModel<CataclysmArmorItem> {
    public CataclysmArmorModel() {
        super(ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, ""));
    }

    @Override
    public ResourceLocation getModelResource(CataclysmArmorItem animatable) {
        return ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "geo/armor/cataclysm_armor.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(CataclysmArmorItem animatable) {
        return ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "textures/armor/cataclysm_armor.png");
    }

    @Override
    public ResourceLocation getAnimationResource(CataclysmArmorItem animatable) {
        return ResourceLocation.fromNamespaceAndPath(IronsSpellbooks.MODID, "animations/wizard_armor_animation.json");
    }
}
