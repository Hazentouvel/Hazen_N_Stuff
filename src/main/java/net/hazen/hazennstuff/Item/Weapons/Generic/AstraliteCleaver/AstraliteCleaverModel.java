package net.hazen.hazennstuff.Item.Weapons.Generic.AstraliteCleaver;

import io.redspace.ironsspellbooks.IronsSpellbooks;
import net.hazen.hazennstuff.HazenNStuff;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.DefaultedItemGeoModel;

public class AstraliteCleaverModel extends DefaultedItemGeoModel<AstraliteCleaver> {
    public AstraliteCleaverModel() {
        super(ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, ""));
    }

    @Override
    public ResourceLocation getModelResource(AstraliteCleaver animatable) {
        return ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "geo/item/weapons/astralite_cleaver.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(AstraliteCleaver animatable) {
        return ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "textures/item/weapons/astralite_cleaver.png");
    }

    @Override
    public ResourceLocation getAnimationResource(AstraliteCleaver animatable) {
        return ResourceLocation.fromNamespaceAndPath(IronsSpellbooks.MODID, "animations/wizard_armor_animation.json");
    }
}
