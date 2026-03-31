package net.hazen.hazennstuff.Item.Armor.Cosmetic.SchoolTier.MyceliumGuardian;

import io.redspace.ironsspellbooks.api.registry.AttributeRegistry;
import io.redspace.ironsspellbooks.entity.armor.GenericCustomArmorRenderer;
import io.redspace.ironsspellbooks.item.armor.IDisableHat;
import io.redspace.ironsspellbooks.item.armor.IDisableJacket;
import net.hazen.hazennstuff.Compat.ArsNoveauCompat;
import net.hazen.hazennstuff.Compat.MalumCompat;
import net.hazen.hazennstuff.Item.HnSUtilities.ImbuableGeckolibHnSArmorItem;
import net.hazen.hazennstuff.Item.HnSUtilities.HnSArmorMaterials;
import net.hazen.hazennstuff.Registries.HnSAttributeRegistry;
import net.hazen.hazennstuff.Registries.HnSEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlotGroup;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.component.ItemAttributeModifiers;
import net.minecraft.world.level.Level;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import software.bernie.geckolib.renderer.GeoArmorRenderer;

import java.util.List;

public class MyceliumGuardianArmorItem extends ImbuableGeckolibHnSArmorItem implements IDisableJacket, IDisableHat {
    public MyceliumGuardianArmorItem(Type type, Properties settings) {
        super(HnSArmorMaterials.PURE_ARMOR_TIER_MATERIAL, type, settings, schoolTierMulti(
                HnSAttributeRegistry.RADIANCE_SPELL_POWER,
                AttributeRegistry.NATURE_SPELL_POWER
        ));
    }

    // Just supply the armor model here; you don't have to worry about making a new renderer
    // ISS already has a custom renderer used for armor models
    @Override
    @OnlyIn(Dist.CLIENT)
    public GeoArmorRenderer<?> supplyRenderer() {
        return new GenericCustomArmorRenderer<>(new MyceliumGuardianArmorModel());
    }
}