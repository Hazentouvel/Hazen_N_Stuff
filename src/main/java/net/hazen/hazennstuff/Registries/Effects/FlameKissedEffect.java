package net.hazen.hazennstuff.Registries.Effects;

import io.redspace.ironsspellbooks.effect.ISyncedMobEffect;
import io.redspace.ironsspellbooks.effect.MagicMobEffect;
import net.minecraft.world.effect.MobEffectCategory;

public class FlameKissedEffect extends MagicMobEffect implements ISyncedMobEffect {
    public static final float FIRE_SPELL_POWER_PER_LEVEL = 0.03F;
    public static final float FIRE_DAMAGE_PER_LEVEL = 0.03F;

    public FlameKissedEffect(MobEffectCategory mobEffectCategory, int color) {
        super(mobEffectCategory, color);
    }
}
