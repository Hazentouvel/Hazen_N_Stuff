package net.hazen.hazennstuff.Client.IonicSplitter;

import io.redspace.ironsspellbooks.render.animation.AnimationHelper;
import net.hazen.hazennstuff.HnSUtilities.Animations.HnSPlayerAnimations;
import net.hazen.hazennstuff.Packets.IonicSplitter.IonicSplitterT2AnimationPacket;
import net.minecraft.client.Minecraft;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;

public final class IonicSplitterT2AnimationHandler {
    private IonicSplitterT2AnimationHandler() {
    }

    public static void handle(IonicSplitterT2AnimationPacket packet) {
        Minecraft minecraft = Minecraft.getInstance();
        if (minecraft.level == null) {
            return;
        }

        Entity entity = minecraft.level.getEntity(packet.entityId());
        if (entity instanceof Player player) {
            var animation = packet.barrage()
                    ? (packet.rightAttack() ? HnSPlayerAnimations.IONIC_SLASH_BARRAGE_RIGHT : HnSPlayerAnimations.IONIC_SLASH_BARRAGE_LEFT)
                    : (packet.rightAttack() ? HnSPlayerAnimations.IONIC_SLASH_RIGHT : HnSPlayerAnimations.IONIC_SLASH_LEFT);
            animation.getForPlayer().ifPresent(playerAnimation -> AnimationHelper.animatePlayerStart(player, playerAnimation));
        }
    }
}
