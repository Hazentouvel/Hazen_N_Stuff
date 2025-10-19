package net.hazen.hazennstuff.Item.Weapons.DivineGreatsword;

import io.redspace.ironsspellbooks.IronsSpellbooks;
import net.hazen.hazennstuff.HazenNStuff;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.DefaultedItemGeoModel;

public class DivineGreatswordModel extends DefaultedItemGeoModel<DivineGreatswordItem> {
    public DivineGreatswordModel() {
        super(ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, ""));
    }

    @Override
    public ResourceLocation getModelResource(DivineGreatswordItem animatable) {
        return ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "geo/item/weapons/divine_greatsword.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(DivineGreatswordItem animatable) {
        return ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "textures/item/weapons/divine_greatsword.png");
    }

    @Override
    public ResourceLocation getAnimationResource(DivineGreatswordItem animatable) {
        return ResourceLocation.fromNamespaceAndPath(IronsSpellbooks.MODID, "animations/wizard_armor_animation.json");
    }
}
