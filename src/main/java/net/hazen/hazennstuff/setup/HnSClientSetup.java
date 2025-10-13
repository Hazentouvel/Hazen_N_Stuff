package net.hazen.hazennstuff.setup;

import net.hazen.hazennstuff.HazenNStuff;
import net.hazen.hazennstuff.entity.mobs.wizards.Evil.BishopOfDeciet.BishopOfDeceitRenderer;
import net.hazen.hazennstuff.entity.mobs.wizards.Evil.Necromancers.NamelessOne.NamelessOneRenderer;
import net.hazen.hazennstuff.entity.mobs.wizards.Evil.Necromancers.Necromancer.NecromancerRenderer;
import net.hazen.hazennstuff.entity.mobs.wizards.Good.Dryad.DryadRenderer;
import net.hazen.hazennstuff.entity.mobs.wizards.Evil.ReignOfTyros.Aegis.AegisRenderer;
import net.hazen.hazennstuff.entity.mobs.wizards.Evil.ReignOfTyros.Aptos.AptosRenderer;
import net.hazen.hazennstuff.entity.mobs.wizards.Evil.ReignOfTyros.Pyromus.PyromusRenderer;
import net.hazen.hazennstuff.entity.mobs.wizards.Evil.Electromancer.ElectromancerRenderer;
import net.hazen.hazennstuff.entity.mobs.wizards.Evil.PiglinPyromancer.PiglinPyromancerRenderer;
import net.hazen.hazennstuff.entity.mobs.wizards.Evil.ServantsOfEnder.ServantsOfEnderRenderer;
import net.hazen.hazennstuff.entity.mobs.wizards.Good.TheRecluse.TheRecluseRenderer;
import net.hazen.hazennstuff.entity.spells.blood.lifesteal_knife.LifestealKnifeRenderer;
import net.hazen.hazennstuff.entity.spells.eldritch.soul_seeker.SoulSeekerRenderer;
import net.hazen.hazennstuff.entity.spells.evocation.spectral_axe.SpectralRenderer;
import net.hazen.hazennstuff.entity.spells.fire.immolating_obliterator.ScorchingSlashRenderer;
import net.hazen.hazennstuff.entity.spells.nature.death_sentence.DeathSentenceRenderer;
import net.hazen.hazennstuff.entity.spells.nature.spider_lily.SpiderLilyRenderer;
import net.hazen.hazennstuff.entity.spells.fire.brimstone_hellblast.BrimstoneHellblastRenderer;
import net.hazen.hazennstuff.entity.spells.ice.ice_arrow.IceArrowRenderer;
import net.hazen.hazennstuff.entity.spells.ice.ice_arrow.crystal_volley.CrystalVolleyRenderer;
import net.hazen.hazennstuff.entity.spells.lightning.spark.EnergyBurstRenderer;
import net.hazen.hazennstuff.entity.spells.radiance.syringe.SyringeRenderer;
import net.hazen.hazennstuff.entity.spells.nature.thorn_chakram.ThornChakramRenderer;
import net.hazen.hazennstuff.entity.spells.shadow.nights_edge_after_slash.NightsEdgeAfterSlashRenderer;
import net.hazen.hazennstuff.registries.HnSEntityRegistry;
import net.hazen.hazennstuff.registries.HnSParticleRegistry;
import net.hazen.hazennstuff.registries.particle.LeafParticle.LeafParticle;
import net.hazen.hazennstuff.registries.particle.General.HnSGenericParticle;
import net.hazen.hazennstuff.registries.particle.NatureSlash.NatureSlash;
import net.hazen.hazennstuff.registries.particle.NightsEdgeStrike.NightsEdgeStrike;
import net.minecraft.client.renderer.entity.NoopRenderer;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.neoforged.neoforge.client.event.RegisterParticleProvidersEvent;

@EventBusSubscriber(modid = HazenNStuff.MOD_ID, bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class HnSClientSetup {


    @SubscribeEvent
    public static void registerRenderer(EntityRenderersEvent.RegisterRenderers event) {

        /*
        *** Spells
         */
        event.registerEntityRenderer(HnSEntityRegistry.BRIMSTONE_HELLBLAST.get(), BrimstoneHellblastRenderer::new);
        event.registerEntityRenderer(HnSEntityRegistry.ENERGY_BURST.get(), EnergyBurstRenderer::new);
        event.registerEntityRenderer(HnSEntityRegistry.SYRINGE.get(), SyringeRenderer::new);
        event.registerEntityRenderer(HnSEntityRegistry.LIFESTEAL_KNIFE.get(), LifestealKnifeRenderer::new);
        event.registerEntityRenderer(HnSEntityRegistry.THORN_CHAKRAM.get(), ThornChakramRenderer::new);
        event.registerEntityRenderer(HnSEntityRegistry.ICE_ARROW.get(), IceArrowRenderer::new);
        event.registerEntityRenderer(HnSEntityRegistry.CRYSTAL_VOLLEY.get(), CrystalVolleyRenderer::new);
        event.registerEntityRenderer(HnSEntityRegistry.SPECTRAL_AXE.get(), SpectralRenderer::new);
        event.registerEntityRenderer(HnSEntityRegistry.SOUL_SEEKER.get(), SoulSeekerRenderer::new);
        event.registerEntityRenderer(HnSEntityRegistry.SPIDER_LILY.get(), SpiderLilyRenderer::new);
        event.registerEntityRenderer(HnSEntityRegistry.DEATH_SENTENCE.get(), DeathSentenceRenderer::new);
        event.registerEntityRenderer(HnSEntityRegistry.NIGHTS_EDGE_AFTER_SLASH.get(), NightsEdgeAfterSlashRenderer::new);
        event.registerEntityRenderer(HnSEntityRegistry.SCORCHING_SLASH.get(), ScorchingSlashRenderer::new);


        /*
        *** Entities
         */

        event.registerEntityRenderer(HnSEntityRegistry.ELECTROMANCER.get(), ElectromancerRenderer::new);
        event.registerEntityRenderer(HnSEntityRegistry.APTOS.get(), AptosRenderer::new);
        event.registerEntityRenderer(HnSEntityRegistry.PYROMUS.get(), PyromusRenderer::new);
        event.registerEntityRenderer(HnSEntityRegistry.AEGIS.get(), AegisRenderer::new);
        event.registerEntityRenderer(HnSEntityRegistry.THE_RECLUSE.get(), TheRecluseRenderer::new);
        event.registerEntityRenderer(HnSEntityRegistry.PIGLIN_PYROMANCER.get(), PiglinPyromancerRenderer::new);
        event.registerEntityRenderer(HnSEntityRegistry.SERVANT_OF_ENDER.get(), ServantsOfEnderRenderer::new);
        event.registerEntityRenderer(HnSEntityRegistry.BISHOP_OF_DECEIT.get(), BishopOfDeceitRenderer::new);
        event.registerEntityRenderer(HnSEntityRegistry.DRYAD.get(), DryadRenderer::new);
        event.registerEntityRenderer(HnSEntityRegistry.NECROMANCER.get(), NecromancerRenderer::new);
        event.registerEntityRenderer(HnSEntityRegistry.NAMELESS_ONE.get(), NamelessOneRenderer::new);


        /*
        *** Particles
         */

        event.registerEntityRenderer(HnSEntityRegistry.ICE_CLOUD.get(), NoopRenderer::new);
        event.registerEntityRenderer(HnSEntityRegistry.ICHOR_STREAM.get(), NoopRenderer::new);
        event.registerEntityRenderer(HnSEntityRegistry.LIGHTNING_STRIKE.get(), NoopRenderer::new);
    }

    @SubscribeEvent
    public static void registerParticles(RegisterParticleProvidersEvent event)
    {
        event.registerSpriteSet(HnSParticleRegistry.MUSHROOM_PARTICLE.get(), HnSGenericParticle.Provider::new);
        event.registerSpriteSet(HnSParticleRegistry.BLADE_PARTICLES.get(), HnSGenericParticle.Provider::new);
        event.registerSpriteSet(HnSParticleRegistry.NIGHTS_EDGE_PARTICLE.get(), HnSGenericParticle.Provider::new);
        event.registerSpriteSet(HnSParticleRegistry.ROD_OF_DISCORD_PARTICLE.get(), HnSGenericParticle.Provider::new);
        event.registerSpriteSet(HnSParticleRegistry.LEAF_PARTICLE.get(), LeafParticle.Provider::new);

        event.registerSpriteSet(HnSParticleRegistry.NIGHTS_EDGE_STRIKE_PARTICLE.get(), NightsEdgeStrike.Provider::new);
        event.registerSpriteSet(HnSParticleRegistry.NATURE_SLASH_PARTICLE.get(), NatureSlash.Provider::new);
    }

}