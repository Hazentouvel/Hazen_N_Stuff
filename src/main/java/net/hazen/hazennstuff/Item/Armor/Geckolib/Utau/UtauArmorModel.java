package net.hazen.hazennstuff.Item.Armor.Geckolib.Utau;

import io.redspace.ironsspellbooks.IronsSpellbooks;
import net.hazen.hazennstuff.HazenNStuff;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.DefaultedEntityGeoModel;

public class UtauArmorModel extends DefaultedEntityGeoModel<UtauArmorItem> {
    public UtauArmorModel() {
        super(ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, ""));
    }

    // Just replace where the path is with the file path of your texture, EZ PZ
    @Override
    public ResourceLocation getModelResource(UtauArmorItem animatable) {
        return ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "geo/armor/teto_kasane_utau_armor.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(UtauArmorItem animatable) {
        return ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "textures/armor/teto_kasane_utau_armor.png");
    }

    @Override
    public ResourceLocation getAnimationResource(UtauArmorItem animatable) {
        return ResourceLocation.fromNamespaceAndPath(IronsSpellbooks.MODID, "animations/wizard_armor_animation.json");

    }
}
