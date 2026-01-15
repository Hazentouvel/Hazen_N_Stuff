package net.hazen.hazennstuff.Item.Weapons.Dawnmaker;

import io.redspace.ironsspellbooks.IronsSpellbooks;
import net.hazen.hazennstuff.HazenNStuff;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.DefaultedItemGeoModel;

public class DawnmakerModel extends DefaultedItemGeoModel<DawnmakerItem> {
    public DawnmakerModel() {
        super(ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, ""));
    }

    @Override
    public ResourceLocation getModelResource(DawnmakerItem animatable) {
        return ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "geo/item/weapons/flame_reaver.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(DawnmakerItem animatable) {
        return ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "textures/item/weapons/flame_reaver.png");
    }

    @Override
    public ResourceLocation getAnimationResource(DawnmakerItem animatable) {
        return ResourceLocation.fromNamespaceAndPath(IronsSpellbooks.MODID, "animations/wizard_armor_animation.json");
    }
}
