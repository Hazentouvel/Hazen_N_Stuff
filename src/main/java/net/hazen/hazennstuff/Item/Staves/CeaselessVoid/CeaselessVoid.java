package net.hazen.hazennstuff.Item.Staves.CeaselessVoid;

import io.redspace.ironsspellbooks.api.item.weapons.ExtendedSwordItem;
import io.redspace.ironsspellbooks.item.weapons.StaffItem;
import io.redspace.ironsspellbooks.registries.SoundRegistry;
import io.redspace.ironsspellbooks.util.ItemPropertiesHelper;
import net.hazen.hazennstuff.Animations.HnSDispatcher;
import net.hazen.hazennstuff.Item.HnSUtilities.HnSStaffTier;
import net.hazen.hazennstuff.Rarity.HnSRarities;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Style;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class CeaselessVoid extends StaffItem {

    public CeaselessVoid() {
        super(
                ItemPropertiesHelper
                        .equipment(1)
                        .fireResistant()
                        .rarity(HnSRarities.SHADOW_RARITY.getValue())
                        .attributes(ExtendedSwordItem
                                .createAttributes(HnSStaffTier.CEASELESS_VOID))
        );
    }
}
