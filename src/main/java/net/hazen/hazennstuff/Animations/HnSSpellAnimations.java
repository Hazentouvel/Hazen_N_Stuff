package net.hazen.hazennstuff.Animations;

import io.redspace.ironsspellbooks.api.util.AnimationHolder;
import net.hazen.hazennstuff.HazenNStuff;
import net.minecraft.resources.ResourceLocation;

public class HnSSpellAnimations {
    public static ResourceLocation ANIMATION_RESOURCE = ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "animation");

    public static final AnimationHolder COMMAND_CHARGE = new AnimationHolder(HazenNStuff.id("command_charging"), true);
    public static final AnimationHolder COMMAND_CAST = new AnimationHolder(HazenNStuff.id("command_cast"), true);
    public static final AnimationHolder FIERY_DAGGER_CAST = new AnimationHolder(HazenNStuff.id("fiery_dagger_cast"), true);
    public static final AnimationHolder FIERY_DAGGER_SUMMON = new AnimationHolder(HazenNStuff.id("fiery_dagger_summon"), true);
    public static final AnimationHolder PARRY = new AnimationHolder(HazenNStuff.id("parry"), true);
}