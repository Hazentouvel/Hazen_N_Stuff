package net.hazen.hazennstuff.Item.Weapons.Ascended.IonicSplitter.T2;

import io.redspace.ironsspellbooks.api.item.weapons.ExtendedSwordItem;
import io.redspace.ironsspellbooks.util.ItemPropertiesHelper;
import net.hazen.hazennstuff.Item.Weapons.HnSExtendedWeaponsTiers;
import net.hazen.hazennstuff.Rarity.HnSRarities;
import net.hazen.hazennstuff.Registries.HnSSounds;
import net.minecraft.client.renderer.BlockEntityWithoutLevelRenderer;
import net.minecraft.core.component.DataComponents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.MaceItem;
import software.bernie.geckolib.animatable.GeoItem;
import software.bernie.geckolib.animatable.client.GeoRenderProvider;
import software.bernie.geckolib.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.animation.*;
import software.bernie.geckolib.util.GeckoLibUtil;

import java.util.function.Consumer;

public class IonicSplitterT2Item extends ExtendedSwordItem implements GeoItem {
    private final AnimatableInstanceCache cache = GeckoLibUtil.createInstanceCache(this);

    public IonicSplitterT2Item() {
        super(
                HnSExtendedWeaponsTiers.IONIC_SPLITTER_T2,
                ItemPropertiesHelper
                        .equipment(1)
                        .fireResistant()
                        .rarity(HnSRarities.LIGHTNING_RARITY.getValue())
                        .attributes(ExtendedSwordItem.createAttributes(HnSExtendedWeaponsTiers.IONIC_SPLITTER_T2))
        );
    }


    @Override
    public boolean hurtEnemy(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        if (!attacker.level().isClientSide) {
            attacker.level().playSound(
                    null,
                    target.getX(),
                    target.getY(),
                    target.getZ(),
                    HnSSounds.ELECTRIC_IMPACT,
                    SoundSource.PLAYERS,
                    1.0f,
                    1.0f
            );
        }

        return super.hurtEnemy(stack, target, attacker);
    }


    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllerRegistrar) {
        //controllerRegistrar.add(animationController);
    }

    private static final RawAnimation IDLE_ANIMATION = RawAnimation.begin().thenLoop("idle");

    private final AnimationController<IonicSplitterT2Item> animationController = new AnimationController<>(this, "controller", 0, this::predicate);

    // Make your animations in this predicate
    private PlayState predicate(AnimationState<IonicSplitterT2Item> event)
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
            private IonicSplitterT2Renderer renderer;

            @Override
            public BlockEntityWithoutLevelRenderer getGeoItemRenderer() {
                if (this.renderer == null)
                    this.renderer = new IonicSplitterT2Renderer();

                return this.renderer;
            }
        });
    }

//    @Override
//    public void appendHoverText(@NotNull ItemStack stack,
//                                @NotNull TooltipContext context,
//                                @NotNull List<Component> lines,
//                                @NotNull TooltipFlag flag) {
//        super.appendHoverText(stack, context, lines, flag);
//
//        lines.add(Component.translatable("item.hazennstuff.skyscorcher.description")
//                .withStyle(ChatFormatting.AQUA, ChatFormatting.ITALIC));
//    }
}
