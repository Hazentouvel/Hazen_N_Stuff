package net.hazen.hazennstuff.Item.Weapons.Ascended.IonicSplitter.T2;

import io.redspace.ironsspellbooks.capabilities.magic.MagicManager;
import io.redspace.ironsspellbooks.registries.SoundRegistry;
import net.hazen.hazennstuff.HazenNStuff;
import net.hazen.hazennstuff.Packets.IonicSplitter.IonicSplitterT2AnimationPacket;
import net.hazen.hazennstuff.Particle.SlashParticles.Spells.IonicSlash.IonicSlashOptions;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.neoforged.neoforge.event.tick.EntityTickEvent;
import net.neoforged.neoforge.network.PacketDistributor;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;

@EventBusSubscriber(modid = HazenNStuff.MOD_ID)
public final class IonicSplitterT2AttackManager {
    private static final String NEXT_ACTION_KEY = "hazennstuff:ionic_splitter_t2_next_action";
    private static final String ATTACK_READY_AT_KEY = "hazennstuff:ionic_splitter_t2_attack_ready_at";
    private static final String BARRAGE_HITS_REMAINING_KEY = "hazennstuff:ionic_splitter_t2_barrage_hits_remaining";
    private static final String BARRAGE_NEXT_HIT_AT_KEY = "hazennstuff:ionic_splitter_t2_barrage_next_hit_at";
    private static final String BARRAGE_NEXT_MIRRORED_KEY = "hazennstuff:ionic_splitter_t2_barrage_next_mirrored";
    private static final double SLASH_RADIUS = 5.0D;
    private static final int BARRAGE_HIT_INTERVAL = 2;

    private IonicSplitterT2AttackManager() {
    }

    public static void attack(ServerPlayer player) {
        ItemStack weapon = player.getMainHandItem();
        if (!player.isAlive() || player.isSpectator() || !(weapon.getItem() instanceof IonicSplitterT2Item)) {
            return;
        }

        var data = player.getPersistentData();
        if (data.getInt(BARRAGE_HITS_REMAINING_KEY) > 0) {
            return;
        }

        long gameTime = player.level().getGameTime();
        if (gameTime < data.getLong(ATTACK_READY_AT_KEY)) {
            return;
        }

        double attackSpeed = player.getAttributeValue(Attributes.ATTACK_SPEED);
        int cooldownTicks = attackSpeed > 0.0D ? Math.max(1, (int)Math.ceil(20.0D / attackSpeed)) : 20;
        data.putLong(ATTACK_READY_AT_KEY, gameTime + cooldownTicks);

        int action = Math.floorMod(data.getInt(NEXT_ACTION_KEY), 8);
        data.putInt(NEXT_ACTION_KEY, (action + 1) % 8);
        boolean rightSideCombo = action < 4;
        int comboAction = action % 4;
        boolean barrage = comboAction == 3;
        boolean rightAttack = barrage ? rightSideCombo : rightSideCombo == (comboAction != 1);

        PacketDistributor.sendToPlayersTrackingEntityAndSelf(
                player,
                new IonicSplitterT2AnimationPacket(player.getId(), rightAttack, barrage)
        );

        boolean mirrored = !rightAttack;
        performStrike(player, weapon, mirrored);
        if (barrage) {
            data.putInt(BARRAGE_HITS_REMAINING_KEY, 2);
            data.putLong(BARRAGE_NEXT_HIT_AT_KEY, gameTime + BARRAGE_HIT_INTERVAL);
            data.putBoolean(BARRAGE_NEXT_MIRRORED_KEY, !mirrored);
        }
    }

    @SubscribeEvent
    public static void onEntityTick(EntityTickEvent.Post event) {
        Entity entity = event.getEntity();
        if (!(entity instanceof ServerPlayer player)) {
            return;
        }

        var data = player.getPersistentData();
        int hitsRemaining = data.getInt(BARRAGE_HITS_REMAINING_KEY);
        if (hitsRemaining <= 0) {
            return;
        }

        if (!player.isAlive() || player.isSpectator() || !(player.getMainHandItem().getItem() instanceof IonicSplitterT2Item)) {
            data.putInt(BARRAGE_HITS_REMAINING_KEY, 0);
            return;
        }

        long gameTime = player.level().getGameTime();
        if (gameTime < data.getLong(BARRAGE_NEXT_HIT_AT_KEY)) {
            return;
        }

        performStrike(player, player.getMainHandItem(), data.getBoolean(BARRAGE_NEXT_MIRRORED_KEY));
        hitsRemaining--;
        data.putInt(BARRAGE_HITS_REMAINING_KEY, hitsRemaining);
        if (hitsRemaining > 0) {
            data.putLong(BARRAGE_NEXT_HIT_AT_KEY, gameTime + BARRAGE_HIT_INTERVAL);
            data.putBoolean(BARRAGE_NEXT_MIRRORED_KEY, !data.getBoolean(BARRAGE_NEXT_MIRRORED_KEY));
        }
    }

    private static void performStrike(ServerPlayer player, ItemStack weapon, boolean mirrored) {
        player.swing(InteractionHand.MAIN_HAND, true);

        Vec3 look = player.getLookAngle();
        Vec3 eyePosition = player.getEyePosition();
        AABB searchArea = player.getBoundingBox().inflate(SLASH_RADIUS);
        float damage = (float)player.getAttributeValue(Attributes.ATTACK_DAMAGE);

        for (LivingEntity target : player.level().getEntitiesOfClass(
                LivingEntity.class,
                searchArea,
                entity -> entity != player && entity.isAlive()
        )) {
            Vec3 toTarget = target.getBoundingBox().getCenter().subtract(eyePosition);
            target.invulnerableTime = 0;
            if (player.distanceToSqr(target) > SLASH_RADIUS * SLASH_RADIUS
                    || toTarget.dot(look) <= 0.0D
                    || !player.hasLineOfSight(target)) {
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


        float pitch = mirrored ? 1.1F : 0.9F;

        player.level().playSound(null, player.getX(), player.getY(), player.getZ(),
                SoundRegistry.GENERIC_BLADE_SWING,
                SoundSource.PLAYERS,
                0.75F,
                pitch
        );

        MagicManager.spawnParticles(player.level(), new IonicSlashOptions((float)forward.x, (float)forward.y, (float)forward.z, mirrored, false, 1.0F), hitLocation.x, hitLocation.y + 0.3, hitLocation.z, 1, 0, 0, 0, 0, true);
    }
}
