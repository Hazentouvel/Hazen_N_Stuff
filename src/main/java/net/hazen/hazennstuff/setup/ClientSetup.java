package net.hazen.hazennstuff.setup;

import net.hazen.hazennstuff.HazenNStuff;
import net.hazen.hazennstuff.entity.spells.fire.brimstone_hellblast.BrimstoneHellblastRenderer;
import net.hazen.hazennstuff.entity.spells.lightning.spark.SparkRenderer;
import net.hazen.hazennstuff.entity.spells.luminescent.syringe.SyringeRenderer;
import net.hazen.hazennstuff.particle.nights_edge_strike.NightsEdgeStrikeParticle;
import net.hazen.hazennstuff.registries.HnSEntityRegistry;
import net.hazen.hazennstuff.registries.HnSParticleRegistry;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.neoforged.neoforge.client.event.RegisterParticleProvidersEvent;

@EventBusSubscriber(modid = HazenNStuff.MOD_ID, bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ClientSetup {


    @SubscribeEvent
    public static void registerRenderer(EntityRenderersEvent.RegisterRenderers event) {
        event.registerEntityRenderer(HnSEntityRegistry.BRIMSTONE_HELLBLAST.get(), BrimstoneHellblastRenderer::new);
        event.registerEntityRenderer(HnSEntityRegistry.SPARK.get(), SparkRenderer::new);
        event.registerEntityRenderer(HnSEntityRegistry.SYRINGE.get(), SyringeRenderer::new);
    }

    @SubscribeEvent
    public static void registerParticles(RegisterParticleProvidersEvent event) {
        event.registerSpriteSet(HnSParticleRegistry.NIGHTS_EDGE_STRIKE_PARTICLE.get(), NightsEdgeStrikeParticle.Provider::new);

    }

}