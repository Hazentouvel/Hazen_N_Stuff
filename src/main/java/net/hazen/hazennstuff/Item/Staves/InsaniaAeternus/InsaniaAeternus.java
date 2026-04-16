package net.hazen.hazennstuff.Item.Staves.InsaniaAeternus;

import io.redspace.ironsspellbooks.api.item.weapons.ExtendedSwordItem;
import io.redspace.ironsspellbooks.item.weapons.StaffItem;
import io.redspace.ironsspellbooks.util.ItemPropertiesHelper;
import net.hazen.hazennstuff.Animations.HnSDispatcher;
import net.hazen.hazennstuff.HnSUtilities.Item.HnSStaffTier;
import net.hazen.hazennstuff.Rarity.HnSRarities;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class InsaniaAeternus extends StaffItem {
    public final HnSDispatcher dispatcher;

    public InsaniaAeternus() {
        super(
                ItemPropertiesHelper
                        .equipment(1)
                        .fireResistant()
                        .rarity(HnSRarities.ELDRITCH_RARITY.getValue())
                        .attributes(ExtendedSwordItem
                                .createAttributes(HnSStaffTier.INSANIA_AETERNUS)
                        )
        );
        this.dispatcher = new HnSDispatcher();
    }

    @Override
    public void inventoryTick(ItemStack stack, Level level, Entity entity, int slotId, boolean isSelected) {
        if (!level.isClientSide && entity instanceof Player player )
        {
            dispatcher.idle(player, stack);
        }
    }

//    @Override
//    public void appendHoverText(@NotNull ItemStack stack,
//                                @NotNull TooltipContext context,
//                                @NotNull List<Component> lines,
//                                @NotNull TooltipFlag flag) {
//        super.appendHoverText(stack, context, lines, flag);
//
//        // Custom item description section
//        lines.add(Component.translatable("item.hazennstuff.soulcalling_scepter.description")
//                .withStyle(Style.EMPTY.withColor(15881518).withItalic(true)));
//    }
}
