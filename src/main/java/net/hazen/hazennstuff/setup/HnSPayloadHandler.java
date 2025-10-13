package net.hazen.hazennstuff.setup;

import net.hazen.hazennstuff.HazenNStuff;
import net.hazen.hazennstuff.registries.particle.General.HnSRodOfDiscordParticlesPacket;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.network.event.RegisterPayloadHandlersEvent;
import net.neoforged.neoforge.network.registration.PayloadRegistrar;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD, modid = HazenNStuff.MOD_ID)
public class HnSPayloadHandler {

    @SubscribeEvent
    public static void register(final RegisterPayloadHandlersEvent event) {
        final PayloadRegistrar payloadRegistrar = event.registrar(HazenNStuff.MOD_ID).versioned("1.0.0").optional();


        payloadRegistrar.playToClient(HnSRodOfDiscordParticlesPacket.TYPE, HnSRodOfDiscordParticlesPacket.STREAM_CODEC, HnSRodOfDiscordParticlesPacket::handle);


    }
}
