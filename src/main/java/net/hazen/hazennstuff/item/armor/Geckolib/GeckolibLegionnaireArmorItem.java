package net.hazen.hazennstuff.item.armor.Geckolib;

import io.redspace.ironsspellbooks.api.registry.AttributeRegistry;
import io.redspace.ironsspellbooks.entity.armor.GenericCustomArmorRenderer;
import io.redspace.ironsspellbooks.item.weapons.AttributeContainer;
import net.hazen.hazennstuff.registries.HnSEffects;
import net.hazen.hazennstuff.entity.armor.Geckolib.GeckolibLegionnaireArmorModel;
import net.hazen.hazennstuff.item.armor.HnSArmorMaterials;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import software.bernie.geckolib.renderer.GeoArmorRenderer;

public class GeckolibLegionnaireArmorItem extends HnSGeckolibArmorItem {
    public GeckolibLegionnaireArmorItem(Type type, Properties settings) {
        super(HnSArmorMaterials.LEGIONNAIRE_MATERIAL, type, settings,
                new AttributeContainer(AttributeRegistry.SPELL_RESIST, .05, AttributeModifier.Operation.ADD_VALUE),
                new AttributeContainer(Attributes.MAX_HEALTH, 1.25, AttributeModifier.Operation.ADD_VALUE)
        );
    }

    // Just supply the armor model here; you don't have to worry about making a new renderer
    // ISS already has a custom renderer used for armor models
    @Override
    @OnlyIn(Dist.CLIENT)
    public GeoArmorRenderer<?> supplyRenderer() {
        return new GenericCustomArmorRenderer<>(new GeckolibLegionnaireArmorModel());
    }

    @Override
    public void inventoryTick(ItemStack stack, Level level, Entity entity, int slotId, boolean isSelected) {
        if (entity instanceof Player player && !level.isClientSide() && isWearingFullSet(player)) {
            evaluateArmorEffects(player);
        }
    }

    private void evaluateArmorEffects(Player player) {
        if (!player.hasEffect(HnSEffects.TYRANTS_GRACE_EFFECT)) {
            player.addEffect(new MobEffectInstance(HnSEffects.TYRANTS_GRACE_EFFECT, 200, 0, false, false, true));
        }
    }

    private boolean isWearingFullSet(Player player) {
        return player.getItemBySlot(ArmorItem.Type.HELMET.getSlot()).getItem() instanceof GeckolibLegionnaireArmorItem &&
                player.getItemBySlot(ArmorItem.Type.CHESTPLATE.getSlot()).getItem() instanceof GeckolibLegionnaireArmorItem &&
                player.getItemBySlot(ArmorItem.Type.LEGGINGS.getSlot()).getItem() instanceof GeckolibLegionnaireArmorItem &&
                player.getItemBySlot(ArmorItem.Type.BOOTS.getSlot()).getItem() instanceof GeckolibLegionnaireArmorItem;
    }
}