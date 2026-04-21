package net.hazen.hazennstuff.HnSUtilities.Animations;

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
    public static final AnimationHolder SCORCHING_SLASH_STANCE = new AnimationHolder(HazenNStuff.id("scorching_slash_stance"), true);
    public static final AnimationHolder SCORCHING_SLASH_SLASH = new AnimationHolder(HazenNStuff.id("scorching_slash_slash"), true);
    public static final AnimationHolder RAPPA_RECAST_1 = new AnimationHolder(HazenNStuff.id("rappa_recast_1"), true);
    public static final AnimationHolder RAPPA_RECAST_2 = new AnimationHolder(HazenNStuff.id("rappa_recast_2"), true);
    public static final AnimationHolder RAPPA_RECAST_3 = new AnimationHolder(HazenNStuff.id("rappa_recast_3"), true);
    public static final AnimationHolder VIOLENT_REGURGITATION_CHARGING = new AnimationHolder(HazenNStuff.id("violent_regurgitation_charging"), true);
    public static final AnimationHolder VIOLENT_REGURGITATION_CAST = new AnimationHolder(HazenNStuff.id("violent_regurgitation_cast"), true);
}