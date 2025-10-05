package net.hazen.hazennstuff.item.weapons.ThornChakram;

import io.redspace.ironsspellbooks.api.events.ModifySpellLevelEvent;
import io.redspace.ironsspellbooks.api.item.curios.AffinityData;
import io.redspace.ironsspellbooks.api.item.weapons.ExtendedSwordItem;
import io.redspace.ironsspellbooks.api.item.weapons.MagicSwordItem;
import io.redspace.ironsspellbooks.api.registry.SpellDataRegistryHolder;
import io.redspace.ironsspellbooks.api.registry.SpellRegistry;
import io.redspace.ironsspellbooks.registries.ComponentRegistry;
import io.redspace.ironsspellbooks.util.ItemPropertiesHelper;
import net.hazen.hazennstuff.HazenNStuff;
import net.hazen.hazennstuff.item.weapons.HnSExtendedWeaponsTiers;
import net.hazen.hazennstuff.item.weapons.vampire_knives.VampireKnivesItem;
import net.hazen.hazennstuff.rarity.NatureRarity;
import net.hazen.hazennstuff.spells.HnSSpellRegistries;
import net.minecraft.client.renderer.BlockEntityWithoutLevelRenderer;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import software.bernie.geckolib.animatable.GeoItem;
import software.bernie.geckolib.animatable.client.GeoRenderProvider;
import software.bernie.geckolib.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.animation.*;
import software.bernie.geckolib.util.GeckoLibUtil;

import java.util.Map;
import java.util.function.Consumer;

public class ThornChakramItem extends MagicSwordItem implements GeoItem {
    private final AnimatableInstanceCache cache = GeckoLibUtil.createInstanceCache(this);

    public ThornChakramItem() {
        super(
                HnSExtendedWeaponsTiers.THORN_CHAKRAM,
                ItemPropertiesHelper
                        .equipment(1)
                        .fireResistant()
                        .rarity(NatureRarity.NATURE_RARITY_PROXY.getValue())
                        .attributes(ExtendedSwordItem.createAttributes(HnSExtendedWeaponsTiers.THORN_CHAKRAM)
                        ),
                SpellDataRegistryHolder.of(
                        new SpellDataRegistryHolder(HnSSpellRegistries.THORN_CHAKRAM, 5)
                )
        );
    }

    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllerRegistrar) {
        //controllerRegistrar.add(animationController);
    }

    // Animations and stuff
    private static final RawAnimation IDLE_ANIMATION = RawAnimation.begin().thenLoop("idle");

    private final AnimationController<ThornChakramItem> animationController = new AnimationController<>(this, "controller", 0, this::predicate);

    // Make your animations in this predicate
    private PlayState predicate(AnimationState<ThornChakramItem> event)
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
            private ThornChakramRenderer renderer;

            @Override
            public BlockEntityWithoutLevelRenderer getGeoItemRenderer() {
                if (this.renderer == null)
                    this.renderer = new ThornChakramRenderer();

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
                HnSSpellRegistries.THORN_CHAKRAM.get().getSpellResource(), 1
        )));
    }

    @EventBusSubscriber(modid = HazenNStuff.MOD_ID, bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public class SpellEvents {

        @SubscribeEvent
        public static void onModifySpellLevel(ModifySpellLevelEvent event) {
            LivingEntity caster = event.getEntity();
            if (caster == null) return;

            if (event.getSpell() != HnSSpellRegistries.THORN_CHAKRAM.get()) {
                return;
            }

            ItemStack mainHand = caster.getMainHandItem();
            ItemStack offHand = caster.getOffhandItem();

            boolean usingKnives = mainHand.getItem() instanceof ThornChakramItem ||
                    offHand.getItem() instanceof ThornChakramItem;

            if (usingKnives) {
                event.addLevels(1);
            }
        }
    }
}
