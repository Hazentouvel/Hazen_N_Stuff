package net.hazen.hazennstuff.item.armor.Geckolib.PermafrostPrince;

import dev.shadowsoffire.apothic_attributes.api.ALObjects;
import io.redspace.ironsspellbooks.api.item.curios.AffinityData;
import io.redspace.ironsspellbooks.api.registry.AttributeRegistry;
import io.redspace.ironsspellbooks.api.registry.SpellRegistry;
import io.redspace.ironsspellbooks.entity.armor.GenericCustomArmorRenderer;
import io.redspace.ironsspellbooks.item.armor.IDisableHat;
import io.redspace.ironsspellbooks.item.armor.IDisableJacket;
import io.redspace.ironsspellbooks.item.weapons.AttributeContainer;
import io.redspace.ironsspellbooks.registries.ComponentRegistry;
import net.hazen.hazennstuff.item.armor.Geckolib.ImbuableGeckolibHnSArmorItem;
import net.hazen.hazennstuff.item.armor.HnSArmorMaterials;
import net.hazen.hazennstuff.registries.HnSEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import software.bernie.geckolib.renderer.GeoArmorRenderer;

import java.util.Map;

public class PermafrostPrinceArmorItem extends ImbuableGeckolibHnSArmorItem implements IDisableJacket, IDisableHat {
    public PermafrostPrinceArmorItem(Type type, Properties settings) {
        // Add in your armor tier + additional attributes for your item
        super(HnSArmorMaterials.HUNTER_MATERIAL, type, settings,
                new AttributeContainer(AttributeRegistry.MAX_MANA, 150.0, AttributeModifier.Operation.ADD_VALUE),
                new AttributeContainer(AttributeRegistry.ICE_SPELL_POWER, .15, AttributeModifier.Operation.ADD_VALUE),
                new AttributeContainer(ALObjects.Attributes.ARROW_DAMAGE, .15, AttributeModifier.Operation.ADD_VALUE),
                new AttributeContainer(ALObjects.Attributes.ARROW_VELOCITY, .15, AttributeModifier.Operation.ADD_VALUE),
                new AttributeContainer(AttributeRegistry.SPELL_POWER, .15, AttributeModifier.Operation.ADD_VALUE),
                new AttributeContainer(Attributes.MOVEMENT_SPEED, .25, AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL)
        );
    }

    // Just supply the armor model here; you don't have to worry about making a new renderer
    // ISS already has a custom renderer used for armor models
    @Override
    @OnlyIn(Dist.CLIENT)
    public GeoArmorRenderer<?> supplyRenderer() {
        return new GenericCustomArmorRenderer<>(new PermafrostPrinceArmorModel());
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
        return player.getItemBySlot(Type.HELMET.getSlot()).getItem() instanceof PermafrostPrinceArmorItem &&
                player.getItemBySlot(Type.CHESTPLATE.getSlot()).getItem() instanceof PermafrostPrinceArmorItem &&
                player.getItemBySlot(Type.LEGGINGS.getSlot()).getItem() instanceof PermafrostPrinceArmorItem &&
                player.getItemBySlot(Type.BOOTS.getSlot()).getItem() instanceof PermafrostPrinceArmorItem;
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