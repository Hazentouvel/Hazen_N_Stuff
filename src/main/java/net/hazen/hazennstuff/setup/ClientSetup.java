package net.hazen.hazennstuff.setup;

import net.hazen.hazennstuff.HazenNStuff;
import net.hazen.hazennstuff.entity.mobs.ReignOfTyros.Aegis.AegisRenderer;
import net.hazen.hazennstuff.entity.mobs.ReignOfTyros.Aptos.AptosRenderer;
import net.hazen.hazennstuff.entity.mobs.ReignOfTyros.Pyromus.PyromusRenderer;
import net.hazen.hazennstuff.entity.mobs.wizards.Electromancer.ElectromancerRenderer;
import net.hazen.hazennstuff.entity.spells.blood.lifesteal_knife.LifestealKnifeRenderer;
import net.hazen.hazennstuff.entity.spells.shadow.nights_edge_strike.NightsEdgeStrikeRenderer;
import net.hazen.hazennstuff.entity.spells.fire.brimstone_hellblast.BrimstoneHellblastRenderer;
import net.hazen.hazennstuff.entity.spells.ice.ice_arrow.IceArrowRenderer;
import net.hazen.hazennstuff.entity.spells.ice.ice_arrow.crystal_volley.CrystalVolleyRenderer;
import net.hazen.hazennstuff.entity.spells.lightning.spark.EnergyBurstRenderer;
import net.hazen.hazennstuff.entity.spells.radiance.syringe.SyringeRenderer;
import net.hazen.hazennstuff.entity.spells.nature.thorn_chakram.ThornChakramRenderer;
import net.hazen.hazennstuff.registries.HnSEntityRegistry;
import net.hazen.hazennstuff.registries.HnSParticleRegistry;
import net.hazen.hazennstuff.registries.particle.MushroomParticle;
import net.minecraft.client.renderer.entity.NoopRenderer;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.neoforged.neoforge.client.event.RegisterParticleProvidersEvent;

@EventBusSubscriber(modid = HazenNStuff.MOD_ID, bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ClientSetup {


    @SubscribeEvent
    public static void registerRenderer(EntityRenderersEvent.RegisterRenderers event) {

        /*
        *** Spells
         */
        event.registerEntityRenderer(HnSEntityRegistry.BRIMSTONE_HELLBLAST.get(), BrimstoneHellblastRenderer::new);
        event.registerEntityRenderer(HnSEntityRegistry.ENERGY_BURST.get(), EnergyBurstRenderer::new);
        event.registerEntityRenderer(HnSEntityRegistry.SYRINGE.get(), SyringeRenderer::new);
        event.registerEntityRenderer(HnSEntityRegistry.LIFESTEAL_KNIFE.get(), LifestealKnifeRenderer::new);
        event.registerEntityRenderer(HnSEntityRegistry.NIGHTS_EDGE_STRIKE.get(), NightsEdgeStrikeRenderer::new);
        event.registerEntityRenderer(HnSEntityRegistry.THORN_CHAKRAM.get(), ThornChakramRenderer::new);
        event.registerEntityRenderer(HnSEntityRegistry.ICE_ARROW.get(), IceArrowRenderer::new);
        event.registerEntityRenderer(HnSEntityRegistry.CRYSTAL_VOLLEY.get(), CrystalVolleyRenderer::new);


        /*
        *** Entities
         */

        event.registerEntityRenderer(HnSEntityRegistry.ELECTROMANCER.get(), ElectromancerRenderer::new);
        event.registerEntityRenderer(HnSEntityRegistry.APTOS.get(), AptosRenderer::new);
        event.registerEntityRenderer(HnSEntityRegistry.PYROMUS.get(), PyromusRenderer::new);
        event.registerEntityRenderer(HnSEntityRegistry.AEGIS.get(), AegisRenderer::new);


        /*
        *** Particles
         */

        event.registerEntityRenderer(HnSEntityRegistry.ICE_CLOUD.get(), NoopRenderer::new);
    }

    @SubscribeEvent
    public static void registerParticles(RegisterParticleProvidersEvent event)
    {
        event.registerSpriteSet(HnSParticleRegistry.MUSHROOM_PARTICLE.get(), MushroomParticle.Provider::new);
    }

}