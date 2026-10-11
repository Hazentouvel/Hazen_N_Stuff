package net.hazen.hazennstuff.Item.Weapons.Ascended.IonicSplitter.T1;

import io.redspace.ironsspellbooks.capabilities.magic.MagicManager;
import io.redspace.ironsspellbooks.registries.SoundRegistry;
import net.hazen.hazennstuff.Packets.IonicSplitter.IonicSplitterT1AnimationPacket;
import net.hazen.hazennstuff.Particle.SlashParticles.Spells.EnderThrust.EnderThrustOptions;
import net.hazen.hazennstuff.Particle.SlashParticles.Spells.IonicSlash.IonicSlashOptions;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.neoforged.neoforge.network.PacketDistributor;

public final class IonicSplitterT1AttackManager {
    private static final String NEXT_SLASH_KEY = "hazennstuff:ionic_splitter_t1_next_attack";
    private static final String SLASH_READY_AT_KEY = "hazennstuff:ionic_splitter_t1_attack_ready_at";
    private static final double SLASH_RADIUS = 5.0D;

    private IonicSplitterT1AttackManager() {
    }

    public static void attack(ServerPlayer player) {
        ItemStack weapon = player.getMainHandItem();
        if (!player.isAlive() || player.isSpectator() || !(weapon.getItem() instanceof IonicSplitterT1Item)) {
            return;
        }

        long gameTime = player.level().getGameTime();
        var data = player.getPersistentData();
        if (gameTime < data.getLong(SLASH_READY_AT_KEY)) {
            return;
        }

        double attackSpeed = player.getAttributeValue(Attributes.ATTACK_SPEED);
        int cooldownTicks = attackSpeed > 0.0D ? Math.max(1, (int)Math.ceil(20.0D / attackSpeed)) : 20;
        data.putLong(SLASH_READY_AT_KEY, gameTime + cooldownTicks);

        boolean rightSlash = data.getBoolean(NEXT_SLASH_KEY);
        data.putBoolean(NEXT_SLASH_KEY, !rightSlash);

        PacketDistributor.sendToPlayersTrackingEntityAndSelf(player, new IonicSplitterT1AnimationPacket(player.getId(), rightSlash));
        player.swing(net.minecraft.world.InteractionHand.MAIN_HAND, true);

        Vec3 look = player.getLookAngle();
        Vec3 eyePosition = player.getEyePosition();
        AABB searchArea = player.getBoundingBox().inflate(SLASH_RADIUS);
        float damage = (float)player.getAttributeValue(Attributes.ATTACK_DAMAGE);

        for (LivingEntity target : player.level().getEntitiesOfClass(LivingEntity.class, searchArea, entity -> entity != player && entity.isAlive())) {
            Vec3 toTarget = target.getBoundingBox().getCenter().subtract(eyePosition);
            target.invulnerableTime = 0;
            if (player.distanceToSqr(target) > SLASH_RADIUS * SLASH_RADIUS || toTarget.dot(look) <= 0.0D || !player.hasLineOfSight(target)) {
                continue;
            }

            if (target.hurt(player.damageSources().playerAttack(player), damage)) {
                double knockback = player.getAttributeValue(Attributes.ATTACK_KNOCKBACK);

                if (knockback > 0.0D) {
                    target.knockback(knockback * 0.5D, player.getX() - target.getX(), player.getZ() - target.getZ());
                }

                weapon.hurtEnemy(target, player);
            }
        }

        Vec3 forward = player.getForward();
        Vec3 hitLocation = player.position()
                .add(0.0, player.getBbHeight() * 0.3F, 0.0)
                .add(forward.scale(1.9));

        boolean mirrored = !rightSlash;

        float pitch = mirrored ? 1.1F : 0.9F;

        player.level().playSound(null, player.getX(), player.getY(), player.getZ(),
                SoundRegistry.GENERIC_BLADE_SWING,
                SoundSource.PLAYERS,
                0.75F,
                pitch
        );

        MagicManager.spawnParticles(player.level(), new IonicSlashOptions((float) forward.x, (float) forward.y, (float) forward.z, mirrored, false, 1.0F), hitLocation.x, hitLocation.y + 0.3, hitLocation.z, 1, 0, 0, 0, 0, true);

        mirrored = !mirrored;
    }
}
