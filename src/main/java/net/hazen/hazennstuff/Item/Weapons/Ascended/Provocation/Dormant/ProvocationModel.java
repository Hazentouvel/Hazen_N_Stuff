package net.hazen.hazennstuff.Item.Weapons.Ascended.Provocation.Dormant;

import io.redspace.ironsspellbooks.IronsSpellbooks;
import net.hazen.hazennstuff.HazenNStuff;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.DefaultedItemGeoModel;

public class ProvocationModel extends DefaultedItemGeoModel<Provocation> {
    public ProvocationModel() {
        super(ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, ""));
    }

    @Override
    public ResourceLocation getModelResource(Provocation animatable) {
        return ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "geo/item/weapons/provocation.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(Provocation animatable) {
        return ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "textures/item/weapons/provocation.png");
    }

    @Override
    public ResourceLocation getAnimationResource(Provocation animatable) {
        return ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "animations/item/weapons/provocation.animation.json");
    }
}
