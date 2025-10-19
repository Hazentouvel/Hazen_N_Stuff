package net.hazen.hazennstuff.Registries.Effects;

import io.redspace.ironsspellbooks.effect.ISyncedMobEffect;
import io.redspace.ironsspellbooks.effect.MagicMobEffect;
import net.minecraft.world.effect.MobEffectCategory;

public class DryadsBlessingEffect extends MagicMobEffect implements ISyncedMobEffect {
    public static final float ARMOR_PER_LEVEL = 0.05f;
    public static final float OVERHEAL_PER_LEVEL = 0.05f;
    public static final float HEALING_RECIEVED_PER_LEVEL = 0.05f;

    public DryadsBlessingEffect(MobEffectCategory mobEffectCategory, int color) {
        super(mobEffectCategory, color);
    }
}
