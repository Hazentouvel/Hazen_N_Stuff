package net.hazen.hazennstuff.Item.Weapons.Ascended.OFortuna.Dormant;

import io.redspace.ironsspellbooks.IronsSpellbooks;
import net.hazen.hazennstuff.HazenNStuff;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.DefaultedItemGeoModel;

public class OFortunaModel extends DefaultedItemGeoModel<OFortuna> {
    public OFortunaModel() {
        super(ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, ""));
    }

    @Override
    public ResourceLocation getModelResource(OFortuna animatable) {
        return ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "geo/item/weapons/o_fortuna.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(OFortuna animatable) {
        return ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "textures/item/weapons/o_fortuna.png");
    }

    @Override
    public ResourceLocation getAnimationResource(OFortuna animatable) {
        return ResourceLocation.fromNamespaceAndPath(IronsSpellbooks.MODID, "animations/wizard_armor_animation.json");
    }
}
