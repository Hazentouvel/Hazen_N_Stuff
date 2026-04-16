package net.hazen.hazennstuff.HnSUtilities.Item;

import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;

public abstract class HnSSpawnEggs extends Item {
    public HnSSpawnEggs() {
        super(
                (new Item.Properties())
                        .rarity(Rarity.COMMON)
                        .stacksTo(64)
        );
    }

    public InteractionResult useOn(UseOnContext context) {
        Level worldIn = context.getLevel();
        Player player = context.getPlayer();
        BlockPos pos = context.getClickedPos();
        ItemStack stack = context.getItemInHand();
        stack.shrink(1);
        this.spawnMob(worldIn, player, pos);

        return InteractionResult.SUCCESS;
    }

    protected void spawnMob(Level worldIn, Player player, BlockPos pos) {
    }
}
