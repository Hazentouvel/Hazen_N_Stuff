package net.hazen.hazennstuff.Registries.Effects;

import io.redspace.ironsspellbooks.effect.ISyncedMobEffect;
import io.redspace.ironsspellbooks.effect.MagicMobEffect;
import net.minecraft.world.effect.MobEffectCategory;

public class MoonkissedEffect extends MagicMobEffect implements ISyncedMobEffect {
    public static final float SPELL_POWER_PER_LEVEL = 0.05F;
    public static final float SUBMERGED_LEVEL = 1F;

    public MoonkissedEffect(MobEffectCategory mobEffectCategory, int color) {
        super(mobEffectCategory, color);
    }
}
