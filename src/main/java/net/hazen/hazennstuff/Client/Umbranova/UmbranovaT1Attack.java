package net.hazen.hazennstuff.Client.Umbranova;

import net.hazen.hazennstuff.HazenNStuff;
import net.hazen.hazennstuff.Item.Weapons.Ascended.Umbranova.T1.UmbranovaT1;
import net.hazen.hazennstuff.Packets.Umbranova.UmbranovaT1Packet;
import net.minecraft.client.Minecraft;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.EventPriority;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.ClientTickEvent;
import net.neoforged.neoforge.client.event.InputEvent;
import net.neoforged.neoforge.network.PacketDistributor;

@EventBusSubscriber(modid = HazenNStuff.MOD_ID, value = Dist.CLIENT)
public final class UmbranovaT1Attack {
    private static float attackCooldown = 0;

    private UmbranovaT1Attack() {
    }

    @SubscribeEvent
    static void onAttackInput(InputEvent.InteractionKeyMappingTriggered event) {
        LocalPlayer player = Minecraft.getInstance().player;
        if (!event.isAttack()) {
            return;
        }
        if (player == null || !(player.getMainHandItem().getItem() instanceof UmbranovaT1)) {
            return;
        }

        event.setSwingHand(false);
        event.setCanceled(true);
    }

    @SubscribeEvent(priority = EventPriority.LOWEST)
    static void onClientTick(ClientTickEvent.Post event) {
        Minecraft minecraft = Minecraft.getInstance();
        LocalPlayer player = minecraft.player;
        if (player == null) {
            attackCooldown = 0;
            return;
        }

        handleAttackInput(minecraft, player);
    }

    private static void handleAttackInput(Minecraft minecraft, LocalPlayer player) {
        boolean canInput = minecraft.screen == null && minecraft.mouseHandler.isMouseGrabbed();
        boolean attackHeld = canInput && minecraft.options.keyAttack.isDown();

        if (!attackHeld) {
            attackCooldown = 0;
            return;
        }

        if (attackCooldown > 0) {
            attackCooldown--;
            return;
        }

        double attackSpeed = player.getAttributeValue(Attributes.ATTACK_SPEED);
        attackSpeed = Math.max(0.1, attackSpeed);
        int cooldownTicks = Math.max(1, (int) Math.ceil(20.0 / attackSpeed)
        );

        PacketDistributor.sendToServer(new UmbranovaT1Packet());
        attackCooldown = cooldownTicks - 1;
    }
}