package net.hazen.hazennstuff.Item.Staves.EnderconicScepter;

import io.redspace.ironsspellbooks.IronsSpellbooks;
import net.hazen.hazennstuff.HazenNStuff;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.DefaultedItemGeoModel;

public class EnderconicScepterModel extends DefaultedItemGeoModel<EnderconicScepter> {
    public EnderconicScepterModel() {
        super(ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, ""));
    }

    @Override
    public ResourceLocation getModelResource(EnderconicScepter animatable) {
        return ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "geo/item/staves/enderconic_scepter.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(EnderconicScepter animatable) {
        return ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "textures/item/staves/enderconic_scepter.png");
    }

    @Override
    public ResourceLocation getAnimationResource(EnderconicScepter animatable) {
        return ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "animations/item/staves/enderconic_scepter.animation.json");
    }
}
