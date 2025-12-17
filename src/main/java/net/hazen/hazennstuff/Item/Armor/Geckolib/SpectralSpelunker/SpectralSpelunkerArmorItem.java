package net.hazen.hazennstuff.Item.Armor.Geckolib.SpectralSpelunker;

import io.redspace.ironsspellbooks.api.registry.AttributeRegistry;
import io.redspace.ironsspellbooks.entity.armor.GenericCustomArmorRenderer;
import io.redspace.ironsspellbooks.item.armor.IDisableHat;
import io.redspace.ironsspellbooks.item.armor.IDisableJacket;
import io.redspace.ironsspellbooks.item.weapons.AttributeContainer;
import io.redspace.ironsspellbooks.registries.ArmorMaterialRegistry;
import net.hazen.hazennstuff.Item.Armor.Geckolib.ImbuableGeckolibHnSArmorItem;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import software.bernie.geckolib.renderer.GeoArmorRenderer;

public class SpectralSpelunkerArmorItem extends ImbuableGeckolibHnSArmorItem implements IDisableJacket, IDisableHat {
    public SpectralSpelunkerArmorItem(Type type, Properties settings) {
        // Add in your armor tier + additional attributes for your item
        super(ArmorMaterialRegistry.NETHERITE_BATTLEMAGE, type, settings,
                new AttributeContainer(AttributeRegistry.EVOCATION_SPELL_POWER, 0.06, AttributeModifier.Operation.ADD_VALUE),
                new AttributeContainer(AttributeRegistry.SPELL_POWER, 0.05, AttributeModifier.Operation.ADD_VALUE),
                new AttributeContainer(AttributeRegistry.MAX_MANA, 175, AttributeModifier.Operation.ADD_VALUE),
                new AttributeContainer(Attributes.SUBMERGED_MINING_SPEED, 0.2, AttributeModifier.Operation.ADD_VALUE),
                new AttributeContainer(Attributes.MINING_EFFICIENCY, 0.1, AttributeModifier.Operation.ADD_VALUE)
        );
    }

    // Just supply the armor model here; you don't have to worry about making a new renderer
    // ISS already has a custom renderer used for armor models
    @Override
    @OnlyIn(Dist.CLIENT)
    public GeoArmorRenderer<?> supplyRenderer() {
        return new GenericCustomArmorRenderer<>(new SpectralSpelunkerArmorModel());
    }

    @Override
    public void inventoryTick(ItemStack stack, Level level, Entity entity, int slotId, boolean isSelected) {
        if (entity instanceof Player player && !level.isClientSide() && isWearingFullSet(player)) {
            evaluateArmorEffects(player);
        }
    }

    private void evaluateArmorEffects(Player player) {
        if (!player.hasEffect(MobEffects.NIGHT_VISION)) {
            player.addEffect(new MobEffectInstance(MobEffects.NIGHT_VISION, 320, 0, false, false, false));
        }
    }

    private boolean isWearingFullSet(Player player) {
        return player.getItemBySlot(Type.HELMET.getSlot()).getItem() instanceof SpectralSpelunkerArmorItem &&
                player.getItemBySlot(Type.CHESTPLATE.getSlot()).getItem() instanceof SpectralSpelunkerArmorItem &&
                player.getItemBySlot(Type.LEGGINGS.getSlot()).getItem() instanceof SpectralSpelunkerArmorItem &&
                player.getItemBySlot(Type.BOOTS.getSlot()).getItem() instanceof SpectralSpelunkerArmorItem;
    }
}
