package net.hazen.hazennstuff.Item.Weapons.Generic.SoulReaper;

import io.redspace.ironsspellbooks.IronsSpellbooks;
import net.hazen.hazennstuff.HazenNStuff;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.DefaultedItemGeoModel;

public class SoulReaperModel extends DefaultedItemGeoModel<SoulReaper> {
    public SoulReaperModel() {
        super(ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, ""));
    }

    @Override
    public ResourceLocation getModelResource(SoulReaper animatable) {
        return ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "geo/item/weapons/soul_reaper.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(SoulReaper animatable) {
        return ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "textures/item/weapons/soul_reaper.png");
    }

    @Override
    public ResourceLocation getAnimationResource(SoulReaper animatable) {
        return ResourceLocation.fromNamespaceAndPath(IronsSpellbooks.MODID, "animations/wizard_armor_animation.json");
    }
}
