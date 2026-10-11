package net.hazen.hazennstuff.Item.Weapons.Ascended.Umbranova.T1;

import io.redspace.ironsspellbooks.api.util.Utils;
import io.redspace.ironsspellbooks.capabilities.magic.MagicManager;
import io.redspace.ironsspellbooks.particle.TraceParticleOptions;
import io.redspace.ironsspellbooks.registries.SoundRegistry;
import net.hazen.hazennstuff.Packets.Umbranova.UmbranovaT1AnimationPacket;
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
import org.joml.Vector3f;

public final class UmbranovaT1AttackManager {
    private static final String NEXT_ATTACK_KEY = "hazennstuff:umbranova_t1_next_attack";
    private static final String ATTACK_READY_AT_KEY = "hazennstuff:umbranova_t1_attack_ready_at";
    private static final double ATTACK_RADIUS = 5.0D;

    private UmbranovaT1AttackManager() {
    }

    public static void attack(ServerPlayer player) {
        ItemStack weapon = player.getMainHandItem();
        if (!player.isAlive() || player.isSpectator() || !(weapon.getItem() instanceof UmbranovaT1)) {
            return;
        }

        long gameTime = player.level().getGameTime();
        var data = player.getPersistentData();
        if (gameTime < data.getLong(ATTACK_READY_AT_KEY)) {
            return;
        }

        double attackSpeed = player.getAttributeValue(Attributes.ATTACK_SPEED);
        int cooldownTicks = attackSpeed > 0.0D ? Math.max(1, (int)Math.ceil(20.0D / attackSpeed)) : 20;
        data.putLong(ATTACK_READY_AT_KEY, gameTime + cooldownTicks);

        boolean rightAttack = data.getBoolean(NEXT_ATTACK_KEY);
        data.putBoolean(NEXT_ATTACK_KEY, !rightAttack);

        PacketDistributor.sendToPlayersTrackingEntityAndSelf(player, new UmbranovaT1AnimationPacket(player.getId(), rightAttack));
        player.swing(net.minecraft.world.InteractionHand.MAIN_HAND, true);

        Vec3 look = player.getLookAngle().normalize();
        Vec3 eyePosition = player.getEyePosition();

        double range = 5.0D;
        double halfWidth = 1.5D;
        double height = 2.0D;

        Vec3 end = eyePosition.add(look.scale(range));
        AABB searchArea = new AABB(eyePosition, end).inflate(halfWidth, height / 2.0D, halfWidth);
        float damage = (float) player.getAttributeValue(Attributes.ATTACK_DAMAGE);

        for (LivingEntity target : player.level().getEntitiesOfClass(LivingEntity.class, searchArea, entity -> entity != player && entity.isAlive())) {
            Vec3 toTarget = target.getBoundingBox().getCenter()
                    .subtract(eyePosition);

            if (toTarget.dot(look) <= 0.0D || toTarget.length() > range || !player.hasLineOfSight(target)) {
                continue;
            }

            target.invulnerableTime = 0;

            if (target.hurt(player.damageSources().playerAttack(player), damage)) {
                double knockback = player.getAttributeValue(Attributes.ATTACK_KNOCKBACK);

                if (knockback > 0.0D) {
                    target.knockback(
                            knockback * 0.5D,
                            player.getX() - target.getX(),
                            player.getZ() - target.getZ()
                    );
                }

                weapon.hurtEnemy(target, player);
            }
        }

        Vec3 forward = player.getForward();
        Vec3 hitLocation = player.position()
                .add(0.0, player.getBbHeight() * 0.3F, 0.0)
                .add(forward.scale(1.9));

        Vec3 rayVector = forward.scale(6.0D);

        int trailParticles = 15;
        double speed = rayVector.length() / 6.0D * 0.75D;

        for (int i = 0; i < trailParticles; ++i) {
            Vec3 particleStart = player.getBoundingBox().getCenter().add(Utils.getRandomVec3(1.0F + player.getBbWidth()));
            Vec3 particleEnd = particleStart.add(rayVector);

            MagicManager.spawnParticles(player.level(), new TraceParticleOptions(Utils.v3f(particleEnd), new Vector3f(1.0F, 0.333F, 1.0F)), particleStart.x, particleStart.y, particleStart.z, 1, 0.0D, 0.0D, 0.0D, speed, false
            );
        }

        boolean mirrored = !rightAttack;

        float pitch = mirrored ? 1.1F : 0.9F;

        player.level().playSound(null, player.getX(), player.getY(), player.getZ(),
                SoundRegistry.ECHOING_STRIKE,
                SoundSource.PLAYERS,
                0.75F,
                pitch
        );



        MagicManager.spawnParticles(player.level(), new EnderThrustOptions((float) forward.x, (float) forward.y, (float) forward.z, mirrored, false, 1.0F), hitLocation.x, hitLocation.y + 0.3, hitLocation.z, 1, 0, 0, 0, 0, true);

        mirrored = !mirrored;
    }
}
