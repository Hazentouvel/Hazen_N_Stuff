package net.hazen.hazennstuff.item.weapons.vampire_knives;

import io.redspace.ironsspellbooks.api.events.ModifySpellLevelEvent;
import io.redspace.ironsspellbooks.api.item.weapons.ExtendedSwordItem;
import io.redspace.ironsspellbooks.api.item.weapons.MagicSwordItem;
import io.redspace.ironsspellbooks.api.registry.SpellDataRegistryHolder;
import io.redspace.ironsspellbooks.api.registry.SpellRegistry;
import io.redspace.ironsspellbooks.util.ItemPropertiesHelper;
import net.hazen.hazennstuff.HazenNStuff;
import net.hazen.hazennstuff.entity.spells.blood.lifesteal_knife.LifestealKnife;
import net.hazen.hazennstuff.item.weapons.HNSExtendedWeaponsTiers;
import net.hazen.hazennstuff.rarity.BloodRarity;
import net.hazen.hazennstuff.registries.HnSSounds;
import net.minecraft.client.renderer.BlockEntityWithoutLevelRenderer;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import software.bernie.geckolib.animatable.GeoItem;
import software.bernie.geckolib.animatable.client.GeoRenderProvider;
import software.bernie.geckolib.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.animation.*;
import software.bernie.geckolib.util.GeckoLibUtil;

import java.util.function.Consumer;

public class VampireKnivesItem extends MagicSwordItem implements GeoItem {
    private final AnimatableInstanceCache cache = GeckoLibUtil.createInstanceCache(this);

    public VampireKnivesItem() {
        super(
                HNSExtendedWeaponsTiers.VAMPIRE_KNIVES,
                ItemPropertiesHelper
                        .equipment(1)
                        .fireResistant()
                        .rarity(BloodRarity.BLOOD_RARITY_PROXY.getValue())
                        .attributes(ExtendedSwordItem.createAttributes(HNSExtendedWeaponsTiers.VAMPIRE_KNIVES)
                        ),
                SpellDataRegistryHolder.of(
                        new SpellDataRegistryHolder(SpellRegistry.BLOOD_NEEDLES_SPELL, 5)
                )
        );
    }

    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllerRegistrar) {
        //controllerRegistrar.add(animationController);
    }

    // Animations and stuff
    private static final RawAnimation IDLE_ANIMATION = RawAnimation.begin().thenLoop("idle");

    private final AnimationController<VampireKnivesItem> animationController = new AnimationController<>(this, "controller", 0, this::predicate);

    // Make your animations in this predicate
    private PlayState predicate(AnimationState<VampireKnivesItem> event)
    {
        event.getController().setAnimation(IDLE_ANIMATION);

        return PlayState.CONTINUE;
    }

    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return cache;
    }

    // Your renderer for items
    @Override
    public void createGeoRenderer(Consumer<GeoRenderProvider> consumer) {
        consumer.accept(new GeoRenderProvider() {
            private VampireKnivesRenderer renderer;

            @Override
            public BlockEntityWithoutLevelRenderer getGeoItemRenderer() {
                if (this.renderer == null)
                    this.renderer = new VampireKnivesRenderer();

                return this.renderer;
            }
        });
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        if (!level.isClientSide) {
            ItemStack stack = player.getItemInHand(hand);

            Vec3 look = player.getLookAngle();
            double spread = 0.2;

            for (int i = 0; i < 5; i++) {
                double xPower = look.x + (level.random.nextGaussian() * spread);
                double yPower = look.y + (level.random.nextGaussian() * spread);
                double zPower = look.z + (level.random.nextGaussian() * spread);

                LifestealKnife projectile = new LifestealKnife(level, player);
                projectile.setPos(player.getX(), player.getEyeY() - 0.1, player.getZ());
                projectile.shoot(xPower, yPower, zPower, 1.5f, 0); // velocity and inaccuracy
                level.addFreshEntity(projectile);
            }

            level.playSound(null, player.getX(), player.getY(), player.getZ(), HnSSounds.VAMPIRE_KNIFE_THROW, SoundSource.PLAYERS, 1.0f, 1.0f);
            player.getCooldowns().addCooldown(this, 40);
        }

        return InteractionResultHolder.sidedSuccess(player.getItemInHand(hand), level.isClientSide());
    }

    @EventBusSubscriber(modid = HazenNStuff.MOD_ID, bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public class SpellEvents {

        @SubscribeEvent
        public static void onModifySpellLevel(ModifySpellLevelEvent event) {
            LivingEntity caster = event.getEntity();
            if (caster == null) return;

            // 🔍 Only modify a specific spell (e.g., Magic Missile)
            if (event.getSpell() != SpellRegistry.BLOOD_NEEDLES_SPELL.get()) {
                return;
            }

            ItemStack mainHand = caster.getMainHandItem();
            ItemStack offHand = caster.getOffhandItem();

            boolean usingKnives = mainHand.getItem() instanceof VampireKnivesItem ||
                    offHand.getItem() instanceof VampireKnivesItem;

            if (usingKnives) {
                event.addLevels(1);
            }
        }
    }

}
