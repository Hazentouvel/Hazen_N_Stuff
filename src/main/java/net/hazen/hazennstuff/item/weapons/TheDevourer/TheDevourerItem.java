package net.hazen.hazennstuff.item.weapons.TheDevourer;

import io.redspace.ironsspellbooks.api.item.curios.AffinityData;
import io.redspace.ironsspellbooks.api.item.weapons.ExtendedSwordItem;
import io.redspace.ironsspellbooks.api.item.weapons.MagicSwordItem;
import io.redspace.ironsspellbooks.api.registry.SpellDataRegistryHolder;
import io.redspace.ironsspellbooks.api.registry.SpellRegistry;
import io.redspace.ironsspellbooks.registries.ComponentRegistry;
import io.redspace.ironsspellbooks.util.ItemPropertiesHelper;
import io.redspace.ironsspellbooks.util.TooltipsUtils;
import net.hazen.hazennstuff.entity.spells.blood.lifesteal_knife.LifestealKnife;
import net.hazen.hazennstuff.item.weapons.HnSExtendedWeaponsTiers;
import net.hazen.hazennstuff.rarity.EldritchRarity;
import net.hazen.hazennstuff.registries.HnSSounds;
import net.minecraft.client.renderer.BlockEntityWithoutLevelRenderer;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.NotNull;
import software.bernie.geckolib.animatable.GeoItem;
import software.bernie.geckolib.animatable.client.GeoRenderProvider;
import software.bernie.geckolib.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.animation.*;
import software.bernie.geckolib.util.GeckoLibUtil;

import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

public class TheDevourerItem extends MagicSwordItem implements GeoItem {
    private final AnimatableInstanceCache cache = GeckoLibUtil.createInstanceCache(this);

    public TheDevourerItem() {
        super(
                HnSExtendedWeaponsTiers.THE_DEVOURER,
                ItemPropertiesHelper
                        .equipment(1)
                        .fireResistant()
                        .rarity(EldritchRarity.ELDRITCH_RARITY_PROXY.getValue())
                        .attributes(ExtendedSwordItem.createAttributes(HnSExtendedWeaponsTiers.THE_DEVOURER)
                        ),
                SpellDataRegistryHolder.of(
                )
        );
    }

    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllerRegistrar) {
        //controllerRegistrar.add(animationController);
    }

    // Animations and stuff
    private static final RawAnimation IDLE_ANIMATION = RawAnimation.begin().thenLoop("idle");

    private final AnimationController<TheDevourerItem> animationController = new AnimationController<>(this, "controller", 0, this::predicate);

    // Make your animations in this predicate
    private PlayState predicate(AnimationState<TheDevourerItem> event)
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
            private TheDevourerRenderer renderer;

            @Override
            public BlockEntityWithoutLevelRenderer getGeoItemRenderer() {
                if (this.renderer == null)
                    this.renderer = new TheDevourerRenderer();

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

    @Override
    public void appendHoverText(@NotNull ItemStack itemStack, @NotNull TooltipContext context, @NotNull List<Component> lines, @NotNull TooltipFlag flag) {
        super.appendHoverText(itemStack, context, lines, flag);
        var affinityData = AffinityData.getAffinityData(itemStack);
        if (!affinityData.affinityData().isEmpty()) {
            int i = TooltipsUtils.indexOfComponent(lines, "tooltip.hazennstuff.spellbook_spell_count");
            lines.addAll(i < 0 ? lines.size() : i + 1, affinityData.getDescriptionComponent());
        }
    }

    @Override
    public void initializeSpellContainer(ItemStack itemStack) {
        if (itemStack == null) {
            return;
        }

        super.initializeSpellContainer(itemStack);
        itemStack.set(ComponentRegistry.AFFINITY_COMPONENT, new AffinityData(Map.of(
                SpellRegistry.BLOOD_NEEDLES_SPELL.get().getSpellResource(), 1
        )));
    }
}
