package net.hazen.hazennstuff.item.armor.Geckolib.FrostbiteKnight;

import io.redspace.ironsspellbooks.IronsSpellbooks;
import net.hazen.hazennstuff.HazenNStuff;
import net.hazen.hazennstuff.item.armor.Geckolib.FrostbiteHunter.FrostbiteHunterArmorItem;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.DefaultedEntityGeoModel;

public class FrostbiteKnightArmorModel extends DefaultedEntityGeoModel<FrostbiteKnightArmorItem> {
    public FrostbiteKnightArmorModel() {
        super(ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, ""));
    }

    // Just replace where the path is with the file path of your texture, EZ PZ
    @Override
    public ResourceLocation getModelResource(FrostbiteKnightArmorItem animatable) {
        return ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "geo/armor/frostbite_knight_armor.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(FrostbiteKnightArmorItem animatable) {
        return ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "textures/armor/frostbite_knight_armor.png");
    }

    @Override
    public ResourceLocation getAnimationResource(FrostbiteKnightArmorItem animatable) {
        return ResourceLocation.fromNamespaceAndPath(IronsSpellbooks.MODID, "animations/wizard_armor_animation.json");
    }
}
