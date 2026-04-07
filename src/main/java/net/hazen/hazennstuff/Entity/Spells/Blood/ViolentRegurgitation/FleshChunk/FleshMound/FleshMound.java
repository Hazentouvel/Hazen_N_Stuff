package net.hazen.hazennstuff.Entity.Spells.Blood.ViolentRegurgitation.FleshChunk.FleshMound;

import io.redspace.ironsspellbooks.api.magic.MagicData;
import net.hazen.hazennstuff.Registries.HnSEffects;
import net.hazen.hazennstuff.Registries.HnSSounds;
import net.hazen.hazennstuff.Spells.HnSSpellRegistries;
import net.hazen.hazennstuff.Registries.HnSEntityRegistry;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.level.Level;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.NotNull;
import software.bernie.geckolib.animatable.GeoEntity;
import software.bernie.geckolib.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.animation.*;
import software.bernie.geckolib.util.GeckoLibUtil;

import java.util.Optional;

public class FleshMound extends Entity implements GeoEntity {
    private final AnimatableInstanceCache cache = GeckoLibUtil.createInstanceCache(this);
    private int sourceSpellLevel = 1;
    private int duration = 300;
    private int age = 0;
    private float damage = 0f;

    public FleshMound(EntityType<? extends Entity> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
    }

    public FleshMound(Level level) {
        this(HnSEntityRegistry.FLESH_MOUND.get(), level);
    }

    public Optional<ParticleOptions> getParticle() {
        return Optional.empty();
    }

    @Override
    protected void defineSynchedData(SynchedEntityData.Builder pBuilder) {
    }

    @Override
    protected void readAdditionalSaveData(CompoundTag compoundTag) {
        if (compoundTag.contains("Duration")) this.duration = compoundTag.getInt("Duration");
        if (compoundTag.contains("Age")) this.age = compoundTag.getInt("Age");
        if (compoundTag.contains("Damage")) this.damage = compoundTag.getFloat("Damage");
        if (compoundTag.contains("SourceSpellLevel")) this.sourceSpellLevel = compoundTag.getInt("SourceSpellLevel");
    }

    @Override
    protected void addAdditionalSaveData(CompoundTag compoundTag) {
        compoundTag.putInt("Duration", this.duration);
        compoundTag.putInt("Age", this.age);
        compoundTag.putFloat("Damage", this.damage);
        compoundTag.putInt("SourceSpellLevel", this.sourceSpellLevel);
    }

    @Override
    public void tick() {
        super.tick();

        if (!this.level.isClientSide) {
            this.age++;
            if (this.duration > 0 && this.age >= this.duration) {
                this.discard();
            }
        }
    }

    @Override
    public @NotNull InteractionResult interact(@NotNull Player player, @NotNull InteractionHand hand) {
        if (!this.level.isClientSide && hand == InteractionHand.MAIN_HAND) {
            doConsume(player);
            return InteractionResult.sidedSuccess(this.level.isClientSide);
        }

        return InteractionResult.sidedSuccess(this.level.isClientSide);
    }

    @Override
    public @NotNull InteractionResult interactAt(@NotNull Player player, @NotNull Vec3 vec, @NotNull InteractionHand hand) {
        return this.interact(player, hand);
    }

    private void doConsume(Player player) {
        int hungerRestore = Math.min(10, Math.max(1, this.sourceSpellLevel));

        float saturation;
        if (hungerRestore <= 1) saturation = 0.1f;
        else saturation = 0.1f + ((float)(hungerRestore - 1) / 9f) * (1.0f - 0.1f);

        int duration = 20 * (5 + this.sourceSpellLevel * 5);

        player.getFoodData().eat(hungerRestore, saturation);

        player.addEffect(new MobEffectInstance(HnSEffects.GLUTTONOUS_HUNGER, duration, 1));

        MagicData magicData = MagicData.getPlayerMagicData(player);
        if (magicData != null) {
            magicData.getPlayerCooldowns().removeCooldown(HnSSpellRegistries.VIOLENT_REGURGITATION.get().getSpellResource().toString());
        }

        this.level.playSound(null, player.getX(), player.getY(), player.getZ(), HnSSounds.FLESH_MOUND_BITE, SoundSource.PLAYERS, 1.0F, 1.0F);

        this.discard();
    }

    @Override
    public boolean isPickable() {
        return true;
    }

    public float getPickRadius() {
        return 2.0F;
    }

    public boolean canChangeDimensions() {
        return false;
    }

    public void setSourceSpellLevel(int level) {
        this.sourceSpellLevel = Math.max(1, level);
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public int getDuration() {
        return this.duration;
    }


    //ANIMATION
    private final RawAnimation idle = RawAnimation.begin().thenLoop("idle");

    private PlayState predicate(AnimationState<FleshMound> event) {
        event.getController().setAnimation(idle);
        return PlayState.CONTINUE;
    }

    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllerRegistrar) {
        controllerRegistrar.add(new AnimationController<>(this, "controller", 0, this::predicate));
    }

    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return this.cache;
    }
}
