package net.hazen.hazennstuff.Items.Extensions;

import io.redspace.ironsspellbooks.api.item.weapons.MagicSwordItem;
import io.redspace.ironsspellbooks.api.registry.SpellDataRegistryHolder;
import io.redspace.ironsspellbooks.api.spells.SpellData;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import net.minecraft.client.renderer.BlockEntityWithoutLevelRenderer;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Tier;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.extensions.common.IClientItemExtensions;
import org.jetbrains.annotations.NotNull;
import software.bernie.geckolib.animatable.GeoItem;
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.core.animation.AnimatableManager;
import software.bernie.geckolib.core.animation.AnimationController;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.core.animation.RawAnimation;
import software.bernie.geckolib.core.object.PlayState;
import software.bernie.geckolib.util.GeckoLibUtil;

public abstract class HnSGeoMagicSwordItem extends MagicSwordItem implements GeoItem {
    private final AnimatableInstanceCache cache = GeckoLibUtil.createInstanceCache(this);

    public HnSGeoMagicSwordItem(Tier tier, double attackDamage, double attackSpeed, SpellDataRegistryHolder[] spellDataRegistryHolders, Map<Attribute, AttributeModifier> additionalAttributes, Properties properties) {
        super(tier, attackDamage, attackSpeed, spellDataRegistryHolders, additionalAttributes, properties);
    }

    @OnlyIn(Dist.CLIENT)
    protected abstract BlockEntityWithoutLevelRenderer getRenderer();

    private PlayState idlePredicate(AnimationState<HnSGeoMagicSwordItem> event) {
        event.getController().setAnimation(RawAnimation.begin().thenLoop("idle"));
        return PlayState.CONTINUE;
    }

    public void registerControllers(AnimatableManager.ControllerRegistrar data) {
        data.add(new AnimationController[]{new AnimationController(this, "controller", 20, this::idlePredicate)});
    }

    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return this.cache;
    }

    @OnlyIn(Dist.CLIENT)
    public void initializeClient(Consumer<IClientItemExtensions> consumer) {
        consumer.accept(new IClientItemExtensions() {
            private final BlockEntityWithoutLevelRenderer renderer = HnSGeoMagicSwordItem.this.getRenderer();

            public @NotNull BlockEntityWithoutLevelRenderer getCustomRenderer() {
                return this.renderer;
            }
        });
    }

    public void initializeSpellContainer(ItemStack itemStack) {
        super.initializeSpellContainer(itemStack);
    }

    public List<SpellData> getSpells() {
        return super.getSpells();
    }
}
