package net.hazen.hazennstuff.Item.Weapons.Ascended.Devastator.T1;

import io.redspace.ironsspellbooks.IronsSpellbooks;
import net.hazen.hazennstuff.HazenNStuff;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.DefaultedItemGeoModel;

public class DevastatorT1Model extends DefaultedItemGeoModel<DevastatorT1> {
    public DevastatorT1Model() {
        super(ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, ""));
    }

    @Override
    public ResourceLocation getModelResource(DevastatorT1 animatable) {
        return ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "geo/item/weapons/devastator.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(DevastatorT1 animatable) {
        return ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "textures/item/weapons/devastator.png");
    }

    @Override
    public ResourceLocation getAnimationResource(DevastatorT1 animatable) {
        return ResourceLocation.fromNamespaceAndPath(IronsSpellbooks.MODID, "animations/wizard_armor_animation.json");
    }
}
