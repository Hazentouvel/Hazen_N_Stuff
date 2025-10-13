package net.hazen.hazennstuff.entity.spells.nature.death_sentence;

import net.hazen.hazennstuff.HazenNStuff;
import net.hazen.hazennstuff.entity.spells.eldritch.soul_seeker.SoulSeeker;
import net.hazen.hazennstuff.entity.spells.nature.thorn_chakram.ThornChakram;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class DeathSentenceModel extends GeoModel<DeathSentence> {

    @Override
    public ResourceLocation getModelResource(DeathSentence animatable) {
        return ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "geo/entities/spells/death_sentence.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(DeathSentence animatable) {
        return ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "textures/spells/death_sentence.png");
    }

    @Override
    public ResourceLocation getAnimationResource(DeathSentence animatable) {
        return ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "animations/entities/spells/spark.animation.json");
    }
}