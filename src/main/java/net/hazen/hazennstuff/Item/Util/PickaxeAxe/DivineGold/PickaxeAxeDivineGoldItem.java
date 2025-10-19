package net.hazen.hazennstuff.Item.Util.PickaxeAxe.DivineGold;

import io.redspace.ironsspellbooks.api.item.weapons.ExtendedSwordItem;
import io.redspace.ironsspellbooks.util.ItemPropertiesHelper;
import net.hazen.hazennstuff.Item.Util.HnSToolTiers;
import net.hazen.hazennstuff.Item.Weapons.HnSExtendedWeaponsTiers;
import net.minecraft.ChatFormatting;
import net.minecraft.client.renderer.BlockEntityWithoutLevelRenderer;
import net.minecraft.core.component.DataComponents;
import net.minecraft.network.chat.Component;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;
import software.bernie.geckolib.animatable.GeoItem;
import software.bernie.geckolib.animatable.client.GeoRenderProvider;
import software.bernie.geckolib.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.animation.*;
import software.bernie.geckolib.util.GeckoLibUtil;

import java.util.List;
import java.util.function.Consumer;

public class PickaxeAxeDivineGoldItem extends ExtendedSwordItem implements GeoItem {
    private final AnimatableInstanceCache cache = GeckoLibUtil.createInstanceCache(this);

    public PickaxeAxeDivineGoldItem() {
        super(
                HnSExtendedWeaponsTiers.PICKAXE_AXE,
                ItemPropertiesHelper
                        .equipment(1)
                        .fireResistant()
                        .rarity(Rarity.EPIC)
                        .attributes(ExtendedSwordItem.createAttributes(HnSExtendedWeaponsTiers.PICKAXE_AXE))
                        .component(DataComponents.TOOL, HnSToolTiers.MITHRIL.createToolProperties(BlockTags.MINEABLE_WITH_PICKAXE))

        );
    }

    @Override
    public void appendHoverText(@NotNull ItemStack stack,
                                @NotNull TooltipContext context,
                                @NotNull List<Component> lines,
                                @NotNull TooltipFlag flag) {
        super.appendHoverText(stack, context, lines, flag);

        // Custom item description section
        lines.add(Component.translatable("item.hazennstuff.terraria.description")
                .withStyle(ChatFormatting.AQUA, ChatFormatting.ITALIC));
    }

    @Override
    public boolean isCorrectToolForDrops(ItemStack stack, BlockState state) {
        return state.is(BlockTags.MINEABLE_WITH_PICKAXE) || state.is(BlockTags.MINEABLE_WITH_AXE);
    }

    @Override
    public float getDestroySpeed(ItemStack stack, BlockState state) {
        if (state.is(BlockTags.MINEABLE_WITH_PICKAXE)) {
            return HnSToolTiers.MITHRIL.getSpeed();
        }
        else if (state.is(BlockTags.MINEABLE_WITH_AXE)) {
            return HnSToolTiers.MITHRIL.getSpeed();
        }
        return 1.0F;
    }

    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllerRegistrar) {
        //controllerRegistrar.add(animationController);
    }

    // Animations and stuff
    private static final RawAnimation IDLE_ANIMATION = RawAnimation.begin().thenLoop("idle");

    private final AnimationController<PickaxeAxeDivineGoldItem> animationController = new AnimationController<>(this, "controller", 0, this::predicate);

    // Make your animations in this predicate
    private PlayState predicate(AnimationState<PickaxeAxeDivineGoldItem> event)
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
            private PickaxeAxeDivineGoldRenderer renderer;

            @Override
            public BlockEntityWithoutLevelRenderer getGeoItemRenderer() {
                if (this.renderer == null)
                    this.renderer = new PickaxeAxeDivineGoldRenderer();

                return this.renderer;
            }
        });
    }
}
