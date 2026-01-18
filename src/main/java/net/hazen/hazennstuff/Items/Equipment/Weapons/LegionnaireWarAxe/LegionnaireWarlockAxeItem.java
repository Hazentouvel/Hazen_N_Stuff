package net.hazen.hazennstuff.Items.Equipment.Weapons.LegionnaireWarAxe;

import io.redspace.ironsspellbooks.api.registry.AttributeRegistry;
import io.redspace.ironsspellbooks.api.registry.SpellDataRegistryHolder;
import io.redspace.ironsspellbooks.item.UniqueItem;
import io.redspace.ironsspellbooks.util.ItemPropertiesHelper;
import net.hazen.hazennstuff.Items.Extensions.HnSExtendedWeaponTiers;
import net.hazen.hazennstuff.Items.Extensions.HnSGeoMagicSwordItem;
import net.minecraft.client.renderer.BlockEntityWithoutLevelRenderer;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.item.Rarity;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import java.util.Map;
import java.util.UUID;

public class LegionnaireWarlockAxeItem extends HnSGeoMagicSwordItem implements UniqueItem {

    public LegionnaireWarlockAxeItem(SpellDataRegistryHolder[] spellDataRegistryHolders) {
        super(HnSExtendedWeaponTiers.PYRIUM_TIER,
                HnSExtendedWeaponTiers.PYRIUM_TIER.getAttackDamageBonus(),
                HnSExtendedWeaponTiers.PYRIUM_TIER.getSpeed(),
                spellDataRegistryHolders,
                Map.of(
                        AttributeRegistry.FIRE_SPELL_POWER.get(), new AttributeModifier(UUID.fromString("a552273e-6669-4cd2-80b3-a703b7616336"),
                                "Fire Spell Power", 0.15f, AttributeModifier.Operation.MULTIPLY_TOTAL),

                        AttributeRegistry.COOLDOWN_REDUCTION.get(), new AttributeModifier(UUID.fromString("a552273e-6669-4cd2-80b3-a703b7616336"),
                                "Cooldown Reduction", 0.1f, AttributeModifier.Operation.MULTIPLY_TOTAL),

                        AttributeRegistry.CASTING_MOVESPEED.get(), new AttributeModifier(UUID.fromString("b552273e-6669-4cd2-80b3-a703b7616336"),
                                "Casting Movespeed", 0.3f, AttributeModifier.Operation.MULTIPLY_TOTAL)
                ),
                ItemPropertiesHelper
                        .equipment(1)
                        .rarity(Rarity.EPIC));
    }

    @Override
    @OnlyIn(Dist.CLIENT)
    public BlockEntityWithoutLevelRenderer getRenderer() {
        return new LegionnaireWarlockAxeRenderer(new LegionnaireWarlockAxeModel());
    }
}