package net.hazen.hazennstuff.Item.Armor.Geckolib.BishopOfDeceitArmor;

import io.redspace.ironsspellbooks.IronsSpellbooks;
import net.hazen.hazennstuff.HazenNStuff;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.DefaultedEntityGeoModel;

public class BishopOfDeceitArmorModel extends DefaultedEntityGeoModel<BishopOfDeceitArmorItem> {
    public BishopOfDeceitArmorModel() {
        super(ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, ""));
    }

    // Just replace where the path is with the file path of your texture, EZ PZ
    @Override
    public ResourceLocation getModelResource(BishopOfDeceitArmorItem animatable) {
        return ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "geo/armor/bishop_of_deceit_armor.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(BishopOfDeceitArmorItem animatable) {
        return ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "textures/armor/bishop_of_deceit_armor.png");
    }

    @Override
    public ResourceLocation getAnimationResource(BishopOfDeceitArmorItem animatable) {
        return ResourceLocation.fromNamespaceAndPath(IronsSpellbooks.MODID, "animations/wizard_armor_animation.json");
    }
}
