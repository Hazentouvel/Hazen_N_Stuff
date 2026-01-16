package net.hazen.hazennstuff.Item.Weapons.Generic.ObsidianClaymore;

import io.redspace.ironsspellbooks.IronsSpellbooks;
import net.hazen.hazennstuff.HazenNStuff;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.DefaultedItemGeoModel;

public class ObsidianClaymoreModel extends DefaultedItemGeoModel<ObsidianClaymoreItem> {
    public ObsidianClaymoreModel() {
        super(ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, ""));
    }

    @Override
    public ResourceLocation getModelResource(ObsidianClaymoreItem animatable) {
        return ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "geo/item/weapons/obsidian_claymore.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(ObsidianClaymoreItem animatable) {
        return ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "textures/item/weapons/obsidian_claymore.png");
    }

    @Override
    public ResourceLocation getAnimationResource(ObsidianClaymoreItem animatable) {
        return ResourceLocation.fromNamespaceAndPath(IronsSpellbooks.MODID, "animations/wizard_armor_animation.json");
    }
}
