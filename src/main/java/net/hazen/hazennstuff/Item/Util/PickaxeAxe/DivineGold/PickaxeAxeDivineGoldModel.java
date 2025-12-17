package net.hazen.hazennstuff.Item.Util.PickaxeAxe.DivineGold;

import io.redspace.ironsspellbooks.IronsSpellbooks;
import net.hazen.hazennstuff.HazenNStuff;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.DefaultedItemGeoModel;

public class PickaxeAxeDivineGoldModel extends DefaultedItemGeoModel<PickaxeAxeDivineGoldItem> {
    public PickaxeAxeDivineGoldModel() {
        super(ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, ""));
    }

    @Override
    public ResourceLocation getModelResource(PickaxeAxeDivineGoldItem animatable) {
        return ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "geo/item/tools/pickaxe_axe.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(PickaxeAxeDivineGoldItem animatable) {
        return ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "textures/item/tools/pickaxe_axe_divine_gold.png");
    }

    @Override
    public ResourceLocation getAnimationResource(PickaxeAxeDivineGoldItem animatable) {
        return ResourceLocation.fromNamespaceAndPath(IronsSpellbooks.MODID, "animations/wizard_armor_animation.json");
    }
}
