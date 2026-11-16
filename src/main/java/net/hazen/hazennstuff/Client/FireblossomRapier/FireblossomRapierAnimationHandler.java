package net.hazen.hazennstuff.Client.FireblossomRapier;

import io.redspace.ironsspellbooks.render.animation.AnimationHelper;
import net.hazen.hazennstuff.HnSUtilities.Animations.HnSPlayerAnimations;
import net.hazen.hazennstuff.Packets.FireblossomRapier.FireblossomRapierAnimationPacket;
import net.minecraft.client.Minecraft;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;

public final class FireblossomRapierAnimationHandler {
    private FireblossomRapierAnimationHandler() {
    }

    public static void handle(FireblossomRapierAnimationPacket packet) {
        Minecraft minecraft = Minecraft.getInstance();
        if (minecraft.level == null) {
            return;
        }

        Entity entity = minecraft.level.getEntity(packet.entityId());
        if (entity instanceof Player player) {
            var animation = packet.barrage()
                    ? (HnSPlayerAnimations.RAPIER_THRUST_BURST)
                    : (packet.basicAttack() ? HnSPlayerAnimations.RAPIER_THRUST : HnSPlayerAnimations.RAPIER_THRUST);
            animation.getForPlayer().ifPresent(playerAnimation -> AnimationHelper.animatePlayerStart(player, playerAnimation));
        }
    }
}
