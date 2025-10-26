package net.hazen.hazennstuff.Spells;

import io.redspace.ironsspellbooks.api.util.AnimationHolder;
import net.hazen.hazennstuff.HazenNStuff;
import net.minecraft.resources.ResourceLocation;

public class HnSSpellAnimations {
    public static ResourceLocation ANIMATION_RESOURCE = ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "animation");

    public static final AnimationHolder COMMAND_CHARGE = new AnimationHolder(HazenNStuff.MOD_ID + ":command_charging", true);
    public static final AnimationHolder COMMAND_CAST = new AnimationHolder(HazenNStuff.MOD_ID + ":command_cast", true);
}