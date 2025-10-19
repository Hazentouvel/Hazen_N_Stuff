package net.hazen.hazennstuff.Item.Weapons.Starfury;

import io.redspace.ironsspellbooks.api.events.ModifySpellLevelEvent;
import io.redspace.ironsspellbooks.api.item.curios.AffinityData;
import io.redspace.ironsspellbooks.api.item.weapons.ExtendedSwordItem;
import io.redspace.ironsspellbooks.api.item.weapons.MagicSwordItem;
import io.redspace.ironsspellbooks.api.registry.SpellDataRegistryHolder;
import io.redspace.ironsspellbooks.api.registry.SpellRegistry;
import io.redspace.ironsspellbooks.registries.ComponentRegistry;
import io.redspace.ironsspellbooks.util.ItemPropertiesHelper;
import io.redspace.ironsspellbooks.util.TooltipsUtils;
import net.hazen.hazennstuff.Item.Weapons.HnSExtendedWeaponsTiers;
import net.hazen.hazennstuff.Rarity.ShadowRarity;
import net.minecraft.ChatFormatting;
import net.minecraft.client.renderer.BlockEntityWithoutLevelRenderer;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import org.jetbrains.annotations.NotNull;
import software.bernie.geckolib.animatable.GeoItem;
import software.bernie.geckolib.animatable.client.GeoRenderProvider;
import software.bernie.geckolib.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.animation.*;
import software.bernie.geckolib.util.GeckoLibUtil;

import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

public class StarfuryItem extends MagicSwordItem implements GeoItem {
    private final AnimatableInstanceCache cache = GeckoLibUtil.createInstanceCache(this);

    public StarfuryItem() {
        super(
                HnSExtendedWeaponsTiers.STARFURY,
                ItemPropertiesHelper
                        .equipment(1)
                        .fireResistant()
                        .rarity(ShadowRarity.SHADOW_RARITY_PROXY.getValue())
                        .attributes(ExtendedSwordItem.createAttributes(HnSExtendedWeaponsTiers.STARFURY)
                        ),
                SpellDataRegistryHolder.of(
                        new SpellDataRegistryHolder(SpellRegistry.STARFALL_SPELL, 6)
                )
        );
    }

    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllerRegistrar) {
        //controllerRegistrar.add(animationController);
    }

    // Animations and stuff
    private static final RawAnimation IDLE_ANIMATION = RawAnimation.begin().thenLoop("idle");

    private final AnimationController<StarfuryItem> animationController = new AnimationController<>(this, "controller", 0, this::predicate);

    // Make your animations in this predicate
    private PlayState predicate(AnimationState<StarfuryItem> event)
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
            private StarfuryRenderer renderer;

            @Override
            public BlockEntityWithoutLevelRenderer getGeoItemRenderer() {
                if (this.renderer == null)
                    this.renderer = new StarfuryRenderer();

                return this.renderer;
            }
        });
    }

    @Override
    public void initializeSpellContainer(ItemStack itemStack) {
        if (itemStack == null) {
            return;
        }

        super.initializeSpellContainer(itemStack);
        itemStack.set(ComponentRegistry.AFFINITY_COMPONENT, new AffinityData(Map.of(
                SpellRegistry.STARFALL_SPELL.get().getSpellResource(), 1
        )));
    }

    @EventBusSubscriber(value = Dist.CLIENT)
    public class SpellEvents {

        @SubscribeEvent
        public static void onModifySpellLevel(ModifySpellLevelEvent event) {
            LivingEntity caster = event.getEntity();
            if (caster == null) return;

            if (event.getSpell() != SpellRegistry.STARFALL_SPELL.get()) {
                return;
            }

            ItemStack mainHand = caster.getMainHandItem();
            ItemStack offHand = caster.getOffhandItem();

            boolean usingKnives = mainHand.getItem() instanceof StarfuryItem ||
                    offHand.getItem() instanceof StarfuryItem;

            if (usingKnives) {
                event.addLevels(1);
            }
        }
    }

    @Override
    public void appendHoverText(@NotNull ItemStack stack,
                                @NotNull TooltipContext context,
                                @NotNull List<Component> lines,
                                @NotNull TooltipFlag flag) {
        super.appendHoverText(stack, context, lines, flag);

        // Affinity tooltip section
        var affinityData = AffinityData.getAffinityData(stack);
        if (!affinityData.affinityData().isEmpty()) {
            int i = TooltipsUtils.indexOfComponent(lines, "tooltip.hazennstuff.spellbook_spell_count");
            lines.addAll(i < 0 ? lines.size() : i + 1, affinityData.getDescriptionComponent());
        }

        // Custom item description section
        lines.add(Component.translatable("item.hazennstuff.terraria.description")
                .withStyle(ChatFormatting.WHITE, ChatFormatting.ITALIC));
    }
}
