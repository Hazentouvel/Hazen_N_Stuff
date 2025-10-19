package net.hazen.hazennstuff.Item.Util.PickaxeAxe;

import io.redspace.ironsspellbooks.IronsSpellbooks;
import net.hazen.hazennstuff.HazenNStuff;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.DefaultedItemGeoModel;

public class PickaxeAxeModel extends DefaultedItemGeoModel<PickaxeAxeItem> {
    public PickaxeAxeModel() {
        super(ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, ""));
    }

    @Override
    public ResourceLocation getModelResource(PickaxeAxeItem animatable) {
        return ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "geo/item/tools/pickaxe_axe.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(PickaxeAxeItem animatable) {
        return ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "textures/item/tools/pickaxe_axe.png");
    }

    @Override
    public ResourceLocation getAnimationResource(PickaxeAxeItem animatable) {
        return ResourceLocation.fromNamespaceAndPath(IronsSpellbooks.MODID, "animations/wizard_armor_animation.json");
    }
}
