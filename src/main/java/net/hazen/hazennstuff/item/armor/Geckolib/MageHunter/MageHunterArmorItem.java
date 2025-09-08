package net.hazen.hazennstuff.item.armor.Geckolib.MageHunter;

import io.redspace.ironsspellbooks.api.registry.AttributeRegistry;
import io.redspace.ironsspellbooks.entity.armor.GenericCustomArmorRenderer;
import io.redspace.ironsspellbooks.item.weapons.AttributeContainer;
import net.hazen.hazennstuff.compat.MalumCompat;
import net.hazen.hazennstuff.item.armor.Geckolib.HnSGeckolibArmorItem;
import net.hazen.hazennstuff.item.armor.Geckolib.Legionnaire.OldLegionnaireArmorModel;
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

public class MageHunterArmorItem extends HnSGeckolibArmorItem {
    public MageHunterArmorItem(Type type, Properties settings) {
        super(HnSArmorMaterials.MAGEHUNTER_MATERIAL, type, settings,
                new AttributeContainer(AttributeRegistry.SPELL_RESIST, .125, AttributeModifier.Operation.ADD_VALUE),
                new AttributeContainer(AttributeRegistry.SPELL_POWER, -.2, AttributeModifier.Operation.ADD_VALUE),
                new AttributeContainer(AttributeRegistry.COOLDOWN_REDUCTION, -.1, AttributeModifier.Operation.ADD_VALUE)
        );
    }

    // Just supply the armor model here; you don't have to worry about making a new renderer
    // ISS already has a custom renderer used for armor models
    @Override
    @OnlyIn(Dist.CLIENT)
    public GeoArmorRenderer<?> supplyRenderer() {
        return new GenericCustomArmorRenderer<>(new MageHunterArmorModel());
    }
}