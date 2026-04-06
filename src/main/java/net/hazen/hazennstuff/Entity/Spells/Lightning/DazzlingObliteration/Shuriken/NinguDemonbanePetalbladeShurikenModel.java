package net.hazen.hazennstuff.Entity.Spells.Lightning.DazzlingObliteration.Shuriken;

import net.hazen.hazennstuff.HazenNStuff;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class NinguDemonbanePetalbladeShurikenModel extends GeoModel<NinguDemonbanePetalbladeShuriken> {

    @Override
    public ResourceLocation getModelResource(NinguDemonbanePetalbladeShuriken animatable) {
        return ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "geo/entities/spells/ningu_demonbane_petalblade_shuriken.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(NinguDemonbanePetalbladeShuriken animatable) {
        return ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "textures/spells/ningu_demonbane_petalblade.png");
    }

    @Override
    public ResourceLocation getAnimationResource(NinguDemonbanePetalbladeShuriken animatable) {
        return ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "animations/entities/spells/ningu_demonbane_petalblade.animation.json");
    }
}