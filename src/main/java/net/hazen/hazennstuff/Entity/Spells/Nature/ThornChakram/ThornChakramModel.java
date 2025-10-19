package net.hazen.hazennstuff.Entity.Spells.Nature.ThornChakram;

import net.hazen.hazennstuff.HazenNStuff;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class ThornChakramModel extends GeoModel<ThornChakram> {

    @Override
    public ResourceLocation getModelResource(ThornChakram animatable) {
        return ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "geo/entities/spells/thorn_chakram_spell.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(ThornChakram animatable) {
        return ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "textures/spells/thorn_chakram_spell.png");
    }

    @Override
    public ResourceLocation getAnimationResource(ThornChakram animatable) {
        return ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "animations/entities/spells/thorn_chakram_spell.animation.json");
    }
}