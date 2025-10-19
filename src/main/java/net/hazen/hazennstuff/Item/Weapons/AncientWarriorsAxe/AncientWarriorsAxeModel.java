package net.hazen.hazennstuff.Item.Weapons.AncientWarriorsAxe;

import io.redspace.ironsspellbooks.IronsSpellbooks;
import net.hazen.hazennstuff.HazenNStuff;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.DefaultedItemGeoModel;

public class AncientWarriorsAxeModel extends DefaultedItemGeoModel<AncientWarriorsAxeItem> {
    public AncientWarriorsAxeModel() {
        super(ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, ""));
    }

    @Override
    public ResourceLocation getModelResource(AncientWarriorsAxeItem animatable) {
        return ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "geo/item/weapons/ancient_warriors_axe.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(AncientWarriorsAxeItem animatable) {
        return ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "textures/item/weapons/ancient_warriors_axe.png");
    }

    @Override
    public ResourceLocation getAnimationResource(AncientWarriorsAxeItem animatable) {
        return ResourceLocation.fromNamespaceAndPath(IronsSpellbooks.MODID, "animations/wizard_armor_animation.json");
    }
}
