package net.hazen.hazennstuff.item.weapons.hammer_of_justice;

import io.redspace.ironsspellbooks.api.item.weapons.ExtendedSwordItem;
import io.redspace.ironsspellbooks.api.item.weapons.MagicSwordItem;
import io.redspace.ironsspellbooks.api.registry.SpellDataRegistryHolder;
import io.redspace.ironsspellbooks.api.registry.SpellRegistry;
import io.redspace.ironsspellbooks.util.ItemPropertiesHelper;
import net.hazen.hazennstuff.item.dispatcher.HnSItemDispatcher;
import net.hazen.hazennstuff.item.weapons.HNSExtendedWeaponsTiers;
import net.hazen.hazennstuff.rarity.DivineRarity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class HammerOfJusticeItem extends MagicSwordItem {
    public final HnSItemDispatcher dispatcher;

    public HammerOfJusticeItem() {
        super(
                HNSExtendedWeaponsTiers.HAMMER_OF_JUSTICE,
                ItemPropertiesHelper
                        .equipment(1)
                        .fireResistant()
                        .rarity(DivineRarity.DIVINE_RARITY_PROXY.getValue())
                        .attributes(ExtendedSwordItem.createAttributes(HNSExtendedWeaponsTiers.ICE_PIKE)
                        ),
                SpellDataRegistryHolder.of(
                        new SpellDataRegistryHolder(SpellRegistry.DIVINE_SMITE_SPELL, 10)
                )
        );
        this.dispatcher = new HnSItemDispatcher();
    }

    @Override
    public void inventoryTick(ItemStack stack, Level level, Entity entity, int slotId, boolean isSelected) {
        if (!level.isClientSide && entity instanceof Player player )
        {
            dispatcher.idle(player, stack);
        }
    }
}