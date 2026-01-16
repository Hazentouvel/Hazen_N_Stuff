package net.hazen.hazennstuff.Item.Weapons.Generic.LegionnaireWarlockAxe;

import io.redspace.ironsspellbooks.IronsSpellbooks;
import net.hazen.hazennstuff.HazenNStuff;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.DefaultedItemGeoModel;

public class LegionnaireWarlockAxeModel extends DefaultedItemGeoModel<LegionnaireWarlockAxeItem> {
    public LegionnaireWarlockAxeModel() {
        super(ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, ""));
    }

    @Override
    public ResourceLocation getModelResource(LegionnaireWarlockAxeItem animatable) {
        return ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "geo/item/weapons/legionnaire_warlock_axe.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(LegionnaireWarlockAxeItem animatable) {
        return ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "textures/item/weapons/legionnaire_warlock_axe.png");
    }

    @Override
    public ResourceLocation getAnimationResource(LegionnaireWarlockAxeItem animatable) {
        return ResourceLocation.fromNamespaceAndPath(IronsSpellbooks.MODID, "animations/wizard_armor_animation.json");
    }
}
