package net.hazen.hazennstuff.Entity.Mobs.Mobs.VoidWanderer;

import io.redspace.ironsspellbooks.registries.SoundRegistry;

import java.util.ArrayList;
import java.util.List;

import net.hazen.hazennstuff.Datagen.HnSTags;
import net.hazen.hazennstuff.HnSConfig;
import net.hazen.hazennstuff.Registries.HnSEntityRegistry;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.world.Difficulty;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.SpawnGroupData;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.CustomSpawner;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LightLayer;
import net.minecraft.world.level.NaturalSpawner;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.Heightmap.Types;
import net.neoforged.neoforge.event.EventHooks;

public class VoidWandererPatrolSpawner implements CustomSpawner {
    private static final int DELAY_FIXED = 9600;
    private static final int DELAY_VARIABLE = 3600;
    private int tickDelay;

    public VoidWandererPatrolSpawner() {
    }

    public int tick(ServerLevel level, boolean spawnEnemies, boolean spawnFriendlies) {
        if (spawnEnemies && (Boolean) HnSConfig.WANDERING_VOID_WANDERER.get()) {
            int playercount = level.players().size();
            if (playercount < 1) {
                return 0;
            } else {
                RandomSource randomsource = level.random;
                --this.tickDelay;
                if (this.tickDelay > 0) {
                    return 0;
                } else {
                    this.tickDelay = 9600 / getGroupedPlayerCount(level) + randomsource.nextInt(3600);
                    if (!randomsource.nextBoolean()) {
                        Player player = null;

                        for(int i = 0; i < playercount; ++i) {
                            player = (Player)level.players().get(randomsource.nextInt(playercount));
                            if (!player.isSpectator() && !player.isCreative()) {
                                break;
                            }

                            player = null;
                        }

                        if (player == null) {
                            return 0;
                        } else {
                            return performVoidWandererWandering(level, player, 4) ? 1 : 0;
                        }
                    } else {
                        return 0;
                    }
                }
            }
        } else {
            return 0;
        }
    }

    public static boolean performVoidWandererWandering(ServerLevel level, LivingEntity targetEntity, int maxAttempts) {
        for(int i = 0; i < maxAttempts; ++i) {
            if (i > 0) {
                Holder<Biome> holder = level.getBiome(targetEntity.blockPosition());
                if (!holder.is(HnSTags.VOID_WANDERER_BIOMES)) {
                    return false;
                }
            }

            RandomSource randomsource = level.random;
            int k = (24 + randomsource.nextInt(24)) * (randomsource.nextBoolean() ? -1 : 1);
            int l = (24 + randomsource.nextInt(24)) * (randomsource.nextBoolean() ? -1 : 1);
            BlockPos.MutableBlockPos blockpos$mutableblockpos = targetEntity.blockPosition().mutable().move(k, 0, l);
            if (!level.hasChunksAt(blockpos$mutableblockpos.getX() - 10, blockpos$mutableblockpos.getZ() - 10, blockpos$mutableblockpos.getX() + 10, blockpos$mutableblockpos.getZ() + 10)) {
                break;
            }

            Holder<Biome> holder = level.getBiome(blockpos$mutableblockpos);
            if (!holder.is(HnSTags.VOID_WANDERER_BIOMES)) {
                break;
            }

            blockpos$mutableblockpos.setY(level.getHeightmapPos(Types.MOTION_BLOCKING_NO_LEAVES, blockpos$mutableblockpos).getY());
            if (createSpider(level, blockpos$mutableblockpos, targetEntity)) {
                return true;
            }
        }

        return false;
    }

    private static int getGroupedPlayerCount(ServerLevel serverLevel) {
        List<BlockPos> groupPositions = new ArrayList();
        int count = 0;
        int groupRange = 48;

        for(Player player : serverLevel.players()) {
            if (groupPositions.stream().noneMatch((pos) -> pos.distSqr(player.blockPosition()) < (double)(groupRange * groupRange))) {
                ++count;
                groupPositions.add(player.blockPosition());
            }
        }

        return count;
    }

    private static boolean createSpider(ServerLevel level, BlockPos.MutableBlockPos pos, LivingEntity targetEntity) {
        BlockState blockstate = level.getBlockState(pos);
        if (!NaturalSpawner.isValidEmptySpawnBlock(level, pos, blockstate, blockstate.getFluidState(), (EntityType)HnSEntityRegistry.VOID_WANDERER.get())) {
            return false;
        } else if (!checkPatrollingMonsterSpawnRules((EntityType) HnSEntityRegistry.VOID_WANDERER.get(), level, MobSpawnType.PATROL, pos, level.random)) {
            return false;
        } else {
            VoidWanderer voidWanderer = new VoidWanderer(HnSEntityRegistry.VOID_WANDERER.get(), level);
            voidWanderer.moveTo(pos.immutable(), 0.0F, 0.0F);
            voidWanderer.setTarget(targetEntity);
            level.playSound((Player)null, voidWanderer.blockPosition(), (SoundEvent)SoundRegistry.ICE_SPIDER_HOWL.get(), SoundSource.HOSTILE, 4.0F, 1.0F);
            if (!EventHooks.checkSpawnPosition(voidWanderer, level, MobSpawnType.PATROL)) {
                return false;
            } else {
                level.addFreshEntity(voidWanderer);
                voidWanderer.finalizeSpawn(level, level.getCurrentDifficultyAt(pos), MobSpawnType.PATROL, (SpawnGroupData)null);
                return true;
            }
        }
    }

    public static boolean checkPatrollingMonsterSpawnRules(EntityType<? extends Mob> mob, LevelAccessor level, MobSpawnType spawnType, BlockPos pos, RandomSource random) {
        return level.getBrightness(LightLayer.BLOCK, pos) <= 8 && level.getDifficulty() != Difficulty.PEACEFUL && Monster.checkMobSpawnRules(mob, level, spawnType, pos, random);
    }
}
