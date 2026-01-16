package net.hazen.hazennstuff.Item.Weapons.Ascended.Provocation.T3;

import io.redspace.ironsspellbooks.IronsSpellbooks;
import net.hazen.hazennstuff.HazenNStuff;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.DefaultedItemGeoModel;

public class ProvocationT3Model extends DefaultedItemGeoModel<ProvocationT3> {
    public ProvocationT3Model() {
        super(ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, ""));
    }

    @Override
    public ResourceLocation getModelResource(ProvocationT3 animatable) {
        return ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "geo/item/weapons/provocation.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(ProvocationT3 animatable) {
        return ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "textures/item/weapons/provocation.png");
    }

    @Override
    public ResourceLocation getAnimationResource(ProvocationT3 animatable) {
        return ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "animations/item/weapons/provocation.animation.json");
    }
}
