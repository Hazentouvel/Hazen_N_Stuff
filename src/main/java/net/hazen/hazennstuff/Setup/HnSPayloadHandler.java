package net.hazen.hazennstuff.Setup;

import net.hazen.hazennstuff.HazenNStuff;
import net.hazen.hazennstuff.Packets.IonicSplitter.IonicSplitterT1AnimationPacket;
import net.hazen.hazennstuff.Packets.EnderExplosionParticlesPacket;
import net.hazen.hazennstuff.Packets.IonicSplitter.IonicSplitterT1Packet;
import net.hazen.hazennstuff.Packets.IonicSplitter.IonicSplitterT2AnimationPacket;
import net.hazen.hazennstuff.Packets.IonicSplitter.IonicSplitterT2Packet;
import net.hazen.hazennstuff.Packets.Umbranova.UmbranovaT1AnimationPacket;
import net.hazen.hazennstuff.Packets.Umbranova.UmbranovaT1Packet;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.network.event.RegisterPayloadHandlersEvent;
import net.neoforged.neoforge.network.registration.PayloadRegistrar;

@EventBusSubscriber
public class HnSPayloadHandler {
    @SubscribeEvent
    public static void register(final RegisterPayloadHandlersEvent event) {
        final PayloadRegistrar payloadRegistrar = event.registrar(HazenNStuff.MOD_ID).versioned("1.0.0").optional();


        payloadRegistrar.playToClient(EnderExplosionParticlesPacket.TYPE, EnderExplosionParticlesPacket.STREAM_CODEC, EnderExplosionParticlesPacket::handle);

        // Ionic Splitter
        payloadRegistrar.playToServer(IonicSplitterT1Packet.TYPE, IonicSplitterT1Packet.STREAM_CODEC, IonicSplitterT1Packet::handle);
        payloadRegistrar.playToClient(IonicSplitterT1AnimationPacket.TYPE, IonicSplitterT1AnimationPacket.STREAM_CODEC, IonicSplitterT1AnimationPacket::handle);

        payloadRegistrar.playToServer(IonicSplitterT2Packet.TYPE, IonicSplitterT2Packet.STREAM_CODEC, IonicSplitterT2Packet::handle);
        payloadRegistrar.playToClient(IonicSplitterT2AnimationPacket.TYPE, IonicSplitterT2AnimationPacket.STREAM_CODEC, IonicSplitterT2AnimationPacket::handle);


        // Umbranova
        payloadRegistrar.playToServer(UmbranovaT1Packet.TYPE, UmbranovaT1Packet.STREAM_CODEC, UmbranovaT1Packet::handle);
        payloadRegistrar.playToClient(UmbranovaT1AnimationPacket.TYPE, UmbranovaT1AnimationPacket.STREAM_CODEC, UmbranovaT1AnimationPacket::handle);

    }
}
