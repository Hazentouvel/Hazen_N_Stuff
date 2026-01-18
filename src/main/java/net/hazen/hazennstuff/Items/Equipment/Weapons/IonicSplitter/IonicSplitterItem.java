package net.hazen.hazennstuff.Items.Equipment.Weapons.IonicSplitter;

import com.gametechbc.spelllib.init.GSLAttributeRegistry;
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

public class IonicSplitterItem extends HnSGeoMagicSwordItem implements UniqueItem {

    public IonicSplitterItem(SpellDataRegistryHolder[] spellDataRegistryHolders) {
        super(HnSExtendedWeaponTiers.IONIC_SPLITTER,
                HnSExtendedWeaponTiers.IONIC_SPLITTER.getAttackDamageBonus(),
                HnSExtendedWeaponTiers.IONIC_SPLITTER.getSpeed(),
                spellDataRegistryHolders,
                Map.of(
                        AttributeRegistry.LIGHTNING_SPELL_POWER.get(), new AttributeModifier(UUID.fromString("a552273e-6669-4cd2-80b3-a703b7616336"),
                                "Lightning Spell Power", 0.15f, AttributeModifier.Operation.MULTIPLY_TOTAL),

                        AttributeRegistry.SPELL_POWER.get(), new AttributeModifier(UUID.fromString("b552273e-6669-4cd2-80b3-a703b7616336"),
                                "Spell Power", 0.15f, AttributeModifier.Operation.MULTIPLY_TOTAL),

                        GSLAttributeRegistry.SPELL_CRIT_DAMAGE.get(), new AttributeModifier(UUID.fromString("c552273e-6669-4cd2-80b3-a703b7616336"),
                                "Spell Crit Damage", 0.25f, AttributeModifier.Operation.MULTIPLY_TOTAL)
                ),
                ItemPropertiesHelper
                        .equipment(1)
                        .rarity(Rarity.EPIC));
    }

    @Override
    @OnlyIn(Dist.CLIENT)
    public BlockEntityWithoutLevelRenderer getRenderer() {
        return new IonicSplitterRenderer(new IonicSplitterModel());
    }
}