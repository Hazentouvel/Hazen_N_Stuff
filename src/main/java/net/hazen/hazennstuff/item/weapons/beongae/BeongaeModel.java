package net.hazen.hazennstuff.item.weapons.beongae;

import net.hazen.hazennstuff.HazenNStuff;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.DefaultedItemGeoModel;

public class BeongaeModel extends DefaultedItemGeoModel<BeongaeItem> {
    public BeongaeModel() {
        super(ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, ""));
    }

    @Override
    public ResourceLocation getModelResource(BeongaeItem animatable) {
        return ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "geo/item/weapons/beongae.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(BeongaeItem animatable) {
        return ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "textures/item/weapons/beongae/beongae.png");
    }

    @Override
    public ResourceLocation getAnimationResource(BeongaeItem animatable) {
        return ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "animations/beongae.animation.json");
    }
}
