package net.hazen.hazennstuff.setup;

import net.hazen.hazennstuff.HazenNStuff;
import net.hazen.hazennstuff.entity.spells.blood.lifesteal_knife.LifestealKnifeRenderer;
import net.hazen.hazennstuff.entity.spells.dark.nights_edge_strike.NightsEdgeStrikeRenderer;
import net.hazen.hazennstuff.entity.spells.fire.brimstone_hellblast.BrimstoneHellblastRenderer;
import net.hazen.hazennstuff.entity.spells.lightning.spark.SparkRenderer;
import net.hazen.hazennstuff.entity.spells.luminescent.syringe.SyringeRenderer;
import net.hazen.hazennstuff.registries.HnSEntityRegistry;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;

@EventBusSubscriber(modid = HazenNStuff.MOD_ID, bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ClientSetup {


    @SubscribeEvent
    public static void registerRenderer(EntityRenderersEvent.RegisterRenderers event) {
        event.registerEntityRenderer(HnSEntityRegistry.BRIMSTONE_HELLBLAST.get(), BrimstoneHellblastRenderer::new);
        event.registerEntityRenderer(HnSEntityRegistry.SPARK.get(), SparkRenderer::new);
        event.registerEntityRenderer(HnSEntityRegistry.SYRINGE.get(), SyringeRenderer::new);
        event.registerEntityRenderer(HnSEntityRegistry.LIFESTEAL_KNIFE.get(), LifestealKnifeRenderer::new);
        event.registerEntityRenderer(HnSEntityRegistry.NIGHTS_EDGE_STRIKE.get(), NightsEdgeStrikeRenderer::new);

    }
}