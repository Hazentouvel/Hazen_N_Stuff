package net.hazen.hazennstuff.Registries.Effects;

import io.redspace.ironsspellbooks.effect.ISyncedMobEffect;
import io.redspace.ironsspellbooks.effect.MagicMobEffect;
import net.minecraft.world.effect.MobEffectCategory;

public class HarmonizedEffect extends MagicMobEffect implements ISyncedMobEffect {
    public static final float CRIT_PER_LEVEL = 0.05F;

    public HarmonizedEffect(MobEffectCategory mobEffectCategory, int color) {
        super(mobEffectCategory, color);
    }
}
