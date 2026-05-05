package net.hazen.hazennstuff.Item.SpawnEggs;

import net.hazen.hazennstuff.Entity.Mobs.Mobs.VoidWanderer.VoidWanderer;
import net.hazen.hazennstuff.HnSUtilities.Item.HnSSpawnEggs;
import net.hazen.hazennstuff.Registries.HnSEntityRegistry;
import net.hazen.hazentouvelib.Items.Misc.HLSpawnEggs;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;

public class SpawnVoidWanderer extends HLSpawnEggs {
    public SpawnVoidWanderer() {
    }

    protected void spawnMob(Level worldIn, Player player, BlockPos pos) {
        VoidWanderer voidWanderer = new VoidWanderer(HnSEntityRegistry.VOID_WANDERER.get(), worldIn);
        voidWanderer.setPos(pos.getCenter().add((double)0.0F, (double)1.0F, (double)0.0F));
        voidWanderer.setYRot(-player.getYRot());
        worldIn.addFreshEntity(voidWanderer);
    }
}
