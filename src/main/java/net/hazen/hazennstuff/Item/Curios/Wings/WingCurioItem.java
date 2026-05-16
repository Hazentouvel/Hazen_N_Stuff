package net.hazen.hazennstuff.Item.Curios.Wings;

import com.google.common.collect.LinkedHashMultimap;
import com.google.common.collect.Multimap;
import dev.shadowsoffire.apothic_attributes.api.ALObjects;
import io.redspace.ironsspellbooks.item.curios.CurioBaseItem;
import net.minecraft.core.Holder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.gameevent.GameEvent;
import net.neoforged.neoforge.common.extensions.IItemExtension;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import software.bernie.geckolib.animatable.GeoItem;
import software.bernie.geckolib.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.animation.*;
import software.bernie.geckolib.constant.DataTickets;
import software.bernie.geckolib.util.GeckoLibUtil;
import top.theillusivec4.curios.api.SlotContext;

public abstract class WingCurioItem extends CurioBaseItem implements GeoItem, IItemExtension {

    private final AnimatableInstanceCache cache =
            GeckoLibUtil.createInstanceCache(this);

    public WingCurioItem(Properties properties) {
        super(properties);
    }

    @Override
    public Multimap<Holder<Attribute>, AttributeModifier> getAttributeModifiers(SlotContext slotContext, ResourceLocation id, ItemStack stack) {
        Multimap<Holder<Attribute>, AttributeModifier> attr = LinkedHashMultimap.create();
        attr.put(ALObjects.Attributes.ELYTRA_FLIGHT, new AttributeModifier(id, 1f, AttributeModifier.Operation.ADD_VALUE));
        return attr;
    }

    @Override
    public boolean canEquipFromUse(SlotContext slotContext, ItemStack stack) {
        return true;
    }

    @Override
    public boolean canElytraFly(ItemStack stack, LivingEntity entity) {
        if (stack.getMaxDamage() > 0) {
            return stack.getDamageValue() < stack.getMaxDamage() - 1;
        }
        return true;
    }

    @Override
    public boolean elytraFlightTick(ItemStack stack, LivingEntity entity, int flightTicks) {
        if (!entity.level().isClientSide) {
            int nextFlightTick = flightTicks + 1;
            if (nextFlightTick % 10 == 0) {
                entity.gameEvent(GameEvent.ELYTRA_GLIDE);
            }
        }

        if (entity instanceof LivingEntity living) {
            living.fallDistance = 0.0F;
        }

        return true;
    }

    @Override
    public void curioTick(SlotContext slotContext, ItemStack stack) {

        LivingEntity entity = slotContext.entity();

        if (!(entity instanceof Player player))
            return;

        // Client-side: set a tag on the player so the animation predicate can use it
        if (player.level().isClientSide) {
            String anim = "idle_1";
            if (player.isFallFlying()) {
                double speed = player.getDeltaMovement().length();
                if (speed > 0.65 || player.getXRot() > 35.0f) {
                    anim = "dive";
                } else {
                    anim = "flight";
                }
            } else if (player.getAbilities().flying) {
                anim = "flight";
            } else {
                anim = "idle_1";
            }
            player.getPersistentData().putString("hazentouvelib:wing_anim", anim);
        }

        if (!player.level().isClientSide) {

            // Conditions copied from vanilla Elytra checks: not on ground, not already fall-flying, not in water, and moving downward
            boolean canStartFly = !player.onGround() && !player.isFallFlying() && !player.isInWater() && player.getDeltaMovement().y < 0.0D;

            if (canStartFly && canElytraFly(stack, player)) {
                // Start fall flying on the server — this will cause the client to enter gliding
                player.startFallFlying();
            }
        }
    }

    @OnlyIn(Dist.CLIENT)
    protected PlayState wings(AnimationState<?> animationState) {

        Entity entity = animationState.getData(DataTickets.ENTITY);

        // Fallback to client player if DataTickets didn't provide an entity (curios rendering context)
        if (!(entity instanceof Player)) {
            try {
                net.minecraft.client.Minecraft mc = net.minecraft.client.Minecraft.getInstance();
                entity = mc.player;
            } catch (Throwable t) {
                // not running on client or Minecraft not available; stop animation
                return PlayState.STOP;
            }
        }

        if (!(entity instanceof Player player)) {
            return PlayState.STOP;
        }

        // Prefer explicit animation state set by curioTick on the client, fall back to computed state
        String forcedAnim = null;
        if (player.getPersistentData().contains("hazentouvelib:wing_anim")) {
            forcedAnim = player.getPersistentData().getString("hazentouvelib:wing_anim");
        }

        boolean flying = player.getAbilities().flying;
        boolean gliding = player.isFallFlying() && !player.onGround();

        String anim;

        if (forcedAnim != null && !forcedAnim.isEmpty()) {
            anim = forcedAnim;
        } else if (gliding) {
            double speed = player.getDeltaMovement().length();

            if (speed > 0.75 || player.getXRot() > 35.0f) {
                anim = "dive";
            } else {
                anim = "flight";
            }
        } else if (flying) {
            anim = "flight";
        } else {
            anim = "idle_1";
        }

        animationState.getController().setAnimation(
                RawAnimation.begin().then(anim, Animation.LoopType.LOOP)
        );

        return PlayState.CONTINUE;
    }

    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllers) {
        controllers.add(new AnimationController<>(this, "wings", 5, this::wings));
    }

    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return cache;
    }
}