package net.hazen.hazennstuff.item.weapons;

import io.redspace.ironsspellbooks.IronsSpellbooks;
import net.hazen.hazennstuff.HazenNStuff;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.DefaultedItemGeoModel;

public class FireblossomRapierModel extends DefaultedItemGeoModel<FireblossomRapierItem> {
    public FireblossomRapierModel() {
        super(ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, ""));
    }

    @Override
    public ResourceLocation getModelResource(FireblossomRapierItem animatable) {
        return ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "geo/fireblossom_rapier.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(FireblossomRapierItem animatable) {
        return ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "textures/item/weapons/fireblossom_rapier/fireblossom_rapier.png");
    }

    @Override
    public ResourceLocation getAnimationResource(FireblossomRapierItem animatable) {
        return ResourceLocation.fromNamespaceAndPath(IronsSpellbooks.MODID, "animations/wizard_armor_animation.json");
    }
}
