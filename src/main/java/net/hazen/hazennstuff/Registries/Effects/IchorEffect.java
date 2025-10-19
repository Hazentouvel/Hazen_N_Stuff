package net.hazen.hazennstuff.Registries.Effects;

import io.redspace.ironsspellbooks.effect.ISyncedMobEffect;
import io.redspace.ironsspellbooks.effect.MagicMobEffect;
import net.minecraft.world.effect.MobEffectCategory;

public class IchorEffect extends MagicMobEffect implements ISyncedMobEffect {
    public static final float DEFENSE_LOWERED_PER_LEVEL = -0.1F;
    public static final float SPELL_VULNERABILITY_PER_LEVEL = -0.05F;
    public static final float REDUCED_TOUGHNESS_PER_LEVEL = -0.1F;

    public IchorEffect(MobEffectCategory mobEffectCategory, int color) {
        super(mobEffectCategory, color);
    }
}
