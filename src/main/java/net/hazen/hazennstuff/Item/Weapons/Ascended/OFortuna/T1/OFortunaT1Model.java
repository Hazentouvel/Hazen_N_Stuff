package net.hazen.hazennstuff.Item.Weapons.Ascended.OFortuna.T1;

import io.redspace.ironsspellbooks.IronsSpellbooks;
import net.hazen.hazennstuff.HazenNStuff;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.DefaultedItemGeoModel;

public class OFortunaT1Model extends DefaultedItemGeoModel<OFortunaT1> {
    public OFortunaT1Model() {
        super(ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, ""));
    }

    @Override
    public ResourceLocation getModelResource(OFortunaT1 animatable) {
        return ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "geo/item/weapons/o_fortuna.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(OFortunaT1 animatable) {
        return ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "textures/item/weapons/o_fortuna.png");
    }

    @Override
    public ResourceLocation getAnimationResource(OFortunaT1 animatable) {
        return ResourceLocation.fromNamespaceAndPath(IronsSpellbooks.MODID, "animations/wizard_armor_animation.json");
    }
}
