package net.hazen.hazennstuff.Item.Armor.SchoolTier.MaskedFool;

import io.redspace.ironsspellbooks.IronsSpellbooks;
import net.hazen.hazennstuff.HazenNStuff;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.DefaultedEntityGeoModel;

public class MaskedFoolArmorModel extends DefaultedEntityGeoModel<MaskedFoolArmorItem> {
    public MaskedFoolArmorModel() {
        super(ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, ""));
    }

    // Just replace where the path is with the file path of your texture, EZ PZ
    @Override
    public ResourceLocation getModelResource(MaskedFoolArmorItem animatable) {
        return ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "geo/armor/masked_fool_armor.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(MaskedFoolArmorItem animatable) {
        return ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "textures/armor/masked_fool_armor.png");
    }

    @Override
    public ResourceLocation getAnimationResource(MaskedFoolArmorItem animatable) {
        return ResourceLocation.fromNamespaceAndPath(IronsSpellbooks.MODID, "animations/wizard_armor_animation.json");
    }
}

