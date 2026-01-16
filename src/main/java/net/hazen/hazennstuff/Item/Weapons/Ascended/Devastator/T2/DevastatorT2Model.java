package net.hazen.hazennstuff.Item.Weapons.Ascended.Devastator.T2;

import io.redspace.ironsspellbooks.IronsSpellbooks;
import net.hazen.hazennstuff.HazenNStuff;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.DefaultedItemGeoModel;

public class DevastatorT2Model extends DefaultedItemGeoModel<DevastatorT2> {
    public DevastatorT2Model() {
        super(ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, ""));
    }

    @Override
    public ResourceLocation getModelResource(DevastatorT2 animatable) {
        return ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "geo/item/weapons/devastator.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(DevastatorT2 animatable) {
        return ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "textures/item/weapons/devastator.png");
    }

    @Override
    public ResourceLocation getAnimationResource(DevastatorT2 animatable) {
        return ResourceLocation.fromNamespaceAndPath(IronsSpellbooks.MODID, "animations/wizard_armor_animation.json");
    }
}
