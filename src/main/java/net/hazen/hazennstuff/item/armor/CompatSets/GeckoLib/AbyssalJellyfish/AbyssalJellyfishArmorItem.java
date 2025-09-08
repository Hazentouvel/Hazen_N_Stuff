package net.hazen.hazennstuff.item.armor.CompatSets.GeckoLib.AbyssalJellyfish;

import io.redspace.ironsspellbooks.api.registry.AttributeRegistry;
import io.redspace.ironsspellbooks.entity.armor.GenericCustomArmorRenderer;
import io.redspace.ironsspellbooks.item.weapons.AttributeContainer;
import net.hazen.hazennstuff.compat.ArsNoveauCompat;
import net.hazen.hazennstuff.compat.CataclysmSpellbooksCompat;
import net.hazen.hazennstuff.compat.MalumCompat;
import net.hazen.hazennstuff.item.armor.Geckolib.ImbuableGeckolibHnSArmorItem;
import net.hazen.hazennstuff.item.armor.HnSArmorMaterials;
import net.hazen.hazennstuff.registries.HnSEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlotGroup;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.component.ItemAttributeModifiers;
import net.minecraft.world.level.Level;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import software.bernie.geckolib.renderer.GeoArmorRenderer;

import java.util.List;

public class AbyssalJellyfishArmorItem extends ImbuableGeckolibHnSArmorItem {
    public AbyssalJellyfishArmorItem(Type type, Properties settings) {
        super(HnSArmorMaterials.AUTOMATON_MATERIAL, type, settings,
                new AttributeContainer(AttributeRegistry.MAX_MANA, 125.0, AttributeModifier.Operation.ADD_VALUE),
                new AttributeContainer(AttributeRegistry.SPELL_POWER, 0.05, AttributeModifier.Operation.ADD_VALUE),
                new AttributeContainer(AttributeRegistry.LIGHTNING_SPELL_POWER, 0.15, AttributeModifier.Operation.ADD_VALUE)
        );
    }

    public List<ItemAttributeModifiers.Entry> createExtraAttributes() {
        var group = EquipmentSlotGroup.bySlot(getEquipmentSlot());
        ItemAttributeModifiers.Builder attributes = ItemAttributeModifiers.builder();
        MalumCompat.addArcaneResonance(attributes, group);
        ArsNoveauCompat.addMaxMana(attributes, group);
        ArsNoveauCompat.addManaRegen(attributes, group);
        CataclysmSpellbooksCompat.addAbyssalSpellPower(attributes, group);
        return attributes.build().modifiers();
    }

    @Override
    @OnlyIn(Dist.CLIENT)
    public GeoArmorRenderer<?> supplyRenderer() {
        return new GenericCustomArmorRenderer<>(new AbyssalJellyfishArmorModel());
    }

    @Override
    public void inventoryTick(ItemStack stack, Level level, Entity entity, int slotId, boolean isSelected) {
        if (entity instanceof Player player && !level.isClientSide() && isWearingFullSet(player)) {
            evaluateArmorEffects(player);
        }
    }

    private void evaluateArmorEffects(Player player) {
        if (!player.hasEffect(HnSEffects.PURE_ARMOR_SET_BONUS)) {
            player.addEffect(new MobEffectInstance(HnSEffects.PURE_ARMOR_SET_BONUS, 200, 0, false, false, false));
        }
        if (!player.hasEffect(MobEffects.MOVEMENT_SPEED)) {
            player.addEffect(new MobEffectInstance(MobEffects.WATER_BREATHING, 40, 0, false, false, false));
        }
    }

    private boolean isWearingFullSet(Player player) {
        return player.getItemBySlot(ArmorItem.Type.HELMET.getSlot()).getItem() instanceof AbyssalJellyfishArmorItem &&
                player.getItemBySlot(ArmorItem.Type.CHESTPLATE.getSlot()).getItem() instanceof AbyssalJellyfishArmorItem &&
                player.getItemBySlot(ArmorItem.Type.LEGGINGS.getSlot()).getItem() instanceof AbyssalJellyfishArmorItem &&
                player.getItemBySlot(ArmorItem.Type.BOOTS.getSlot()).getItem() instanceof AbyssalJellyfishArmorItem;
    }
}
