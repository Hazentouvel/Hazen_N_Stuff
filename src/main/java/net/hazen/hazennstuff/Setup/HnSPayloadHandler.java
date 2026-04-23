package net.hazen.hazennstuff.Setup;

import net.hazen.hazennstuff.HazenNStuff;
import net.hazen.hazennstuff.HnSUtilities.Armor.HnSMessageArmorKey;
import net.hazen.hazennstuff.Particle.EnderExplosionParticlesPacket;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.network.event.RegisterPayloadHandlersEvent;
import net.neoforged.neoforge.network.registration.PayloadRegistrar;

@EventBusSubscriber

public class HnSPayloadHandler {

    @SubscribeEvent
    public static void register(final RegisterPayloadHandlersEvent event) {
        final PayloadRegistrar payloadRegistrar = event.registrar(HazenNStuff.MOD_ID).versioned("1.0.0").optional();

        payloadRegistrar.playToServer(HnSMessageArmorKey.TYPE, HnSMessageArmorKey.STREAM_CODEC, HnSMessageArmorKey::handle);

        payloadRegistrar.playToClient(EnderExplosionParticlesPacket.TYPE, EnderExplosionParticlesPacket.STREAM_CODEC, EnderExplosionParticlesPacket::handle);

    }
}
