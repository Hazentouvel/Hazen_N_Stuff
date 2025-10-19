package net.hazen.hazennstuff.Item.Weapons.Muramasa;

import io.redspace.ironsspellbooks.IronsSpellbooks;
import net.hazen.hazennstuff.HazenNStuff;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.DefaultedItemGeoModel;

public class MuramasaModel extends DefaultedItemGeoModel<MuramasaItem> {
    public MuramasaModel() {
        super(ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, ""));
    }

    @Override
    public ResourceLocation getModelResource(MuramasaItem animatable) {
        return ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "geo/item/weapons/muramasa.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(MuramasaItem animatable) {
        return ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "textures/item/weapons/muramasa.png");
    }

    @Override
    public ResourceLocation getAnimationResource(MuramasaItem animatable) {
        return ResourceLocation.fromNamespaceAndPath(IronsSpellbooks.MODID, "animations/wizard_armor_animation.json");
    }
}
