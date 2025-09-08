package net.hazen.hazennstuff.item.armor.Geckolib.FrostbiteHunter;

import dev.shadowsoffire.apothic_attributes.api.ALObjects;
import io.redspace.ironsspellbooks.api.item.curios.AffinityData;
import io.redspace.ironsspellbooks.api.registry.AttributeRegistry;
import io.redspace.ironsspellbooks.api.registry.SpellRegistry;
import io.redspace.ironsspellbooks.entity.armor.GenericCustomArmorRenderer;
import io.redspace.ironsspellbooks.item.weapons.AttributeContainer;
import io.redspace.ironsspellbooks.registries.ComponentRegistry;
import net.hazen.hazennstuff.compat.ArsNoveauCompat;
import net.hazen.hazennstuff.compat.MalumCompat;
import net.hazen.hazennstuff.item.armor.Geckolib.CryogenicRuler.CryogenicRulerArmorModel;
import net.hazen.hazennstuff.item.armor.Geckolib.ImbuableGeckolibHnSArmorItem;
import net.hazen.hazennstuff.item.armor.HnSArmorMaterials;
import net.hazen.hazennstuff.registries.HnSEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlotGroup;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.component.ItemAttributeModifiers;
import net.minecraft.world.level.Level;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import software.bernie.geckolib.renderer.GeoArmorRenderer;

import java.util.List;
import java.util.Map;

public class FrostbiteHunterArmorItem extends ImbuableGeckolibHnSArmorItem {
    public FrostbiteHunterArmorItem(Type type, Properties settings) {
        // Add in your armor tier + additional attributes for your item
        super(HnSArmorMaterials.HUNTER_MATERIAL, type, settings,
                new AttributeContainer(AttributeRegistry.MAX_MANA, 100.0, AttributeModifier.Operation.ADD_VALUE),
                new AttributeContainer(AttributeRegistry.ICE_SPELL_POWER, .1, AttributeModifier.Operation.ADD_VALUE),
                new AttributeContainer(ALObjects.Attributes.ARROW_DAMAGE, .1, AttributeModifier.Operation.ADD_VALUE),
                new AttributeContainer(ALObjects.Attributes.ARROW_VELOCITY, .1, AttributeModifier.Operation.ADD_VALUE),
                new AttributeContainer(AttributeRegistry.SPELL_POWER, .05, AttributeModifier.Operation.ADD_VALUE),
                new AttributeContainer(Attributes.MOVEMENT_SPEED, .15, AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL)
        );
    }

    // Just supply the armor model here; you don't have to worry about making a new renderer
    // ISS already has a custom renderer used for armor models
    @Override
    @OnlyIn(Dist.CLIENT)
    public GeoArmorRenderer<?> supplyRenderer() {
        return new GenericCustomArmorRenderer<>(new FrostbiteHunterArmorModel());
    }

    @Override
    public void inventoryTick(ItemStack stack, Level level, Entity entity, int slotId, boolean isSelected) {
        if (entity instanceof Player player && !level.isClientSide() && isWearingFullSet(player)) {
            evaluateArmorEffects(player);
        }
    }

    private void evaluateArmorEffects(Player player) {
        if (!player.hasEffect(HnSEffects.PURE_ARMOR_SET_BONUS)) {
            player.addEffect(new MobEffectInstance(HnSEffects.PURE_ARMOR_SET_BONUS, 400, 0, false, false, false));
        }
    }

    private boolean isWearingFullSet(Player player) {
        return player.getItemBySlot(Type.HELMET.getSlot()).getItem() instanceof FrostbiteHunterArmorItem &&
                player.getItemBySlot(Type.CHESTPLATE.getSlot()).getItem() instanceof FrostbiteHunterArmorItem &&
                player.getItemBySlot(Type.LEGGINGS.getSlot()).getItem() instanceof FrostbiteHunterArmorItem &&
                player.getItemBySlot(Type.BOOTS.getSlot()).getItem() instanceof FrostbiteHunterArmorItem;
    }

    @Override
    public void initializeSpellContainer(ItemStack itemStack) {
        if (itemStack == null) {
            return;
        }

        super.initializeSpellContainer(itemStack);
        itemStack.set(ComponentRegistry.AFFINITY_COMPONENT, new AffinityData(Map.of(
                SpellRegistry.FROSTBITE_SPELL.get().getSpellResource(), 1
        )));
    }
}