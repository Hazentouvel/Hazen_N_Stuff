package net.hazen.hazennstuff.Setup;

import io.redspace.ironsspellbooks.entity.mobs.keeper.KeeperRenderer;
import io.redspace.ironsspellbooks.entity.spells.fiery_dagger.FieryDaggerRenderer;
import net.hazen.hazennstuff.Item.Block.Statues.HazelStatue.HazelStatueRenderer;
import net.hazen.hazennstuff.Item.Block.HnSBlockEntities;
import net.hazen.hazennstuff.Entity.Mobs.Mobs.Blazes.CinderousFurnace.CinderousFurnaceRenderer;
import net.hazen.hazennstuff.Entity.Mobs.Mobs.Blazes.TheInferno.TheInfernoRenderer;
import net.hazen.hazennstuff.Entity.Mobs.Summons.SummonTerraprisma.SummonedTerraprismaRenderer;
import net.hazen.hazennstuff.Entity.Mobs.Wizards.Evil.BishopOfDeciet.BishopOfDeceitRenderer;
import net.hazen.hazennstuff.Entity.Mobs.Wizards.Evil.Electromancer.ElectromancerRenderer;
import net.hazen.hazennstuff.Entity.Mobs.Wizards.Evil.Necromancers.NamelessOne.NamelessOneRenderer;
import net.hazen.hazennstuff.Entity.Mobs.Wizards.Evil.Necromancers.Necromancer.NecromancerRenderer;
import net.hazen.hazennstuff.Entity.Mobs.Wizards.Evil.PiglinPyromancer.PiglinPyromancerRenderer;
import net.hazen.hazennstuff.Entity.Mobs.Wizards.Evil.ReignOfTyros.Aegis.AegisRenderer;
import net.hazen.hazennstuff.Entity.Mobs.Wizards.Evil.ReignOfTyros.Aptos.AptosRenderer;
import net.hazen.hazennstuff.Entity.Mobs.Wizards.Evil.ReignOfTyros.Pyromus.PyromusRenderer;
import net.hazen.hazennstuff.Entity.Mobs.Wizards.Evil.ServantsOfEnder.ServantsOfEnderRenderer;
import net.hazen.hazennstuff.Entity.Mobs.Wizards.Good.Dryad.DryadRenderer;
import net.hazen.hazennstuff.Entity.Mobs.Wizards.Good.TheRecluse.TheRecluseRenderer;
import net.hazen.hazennstuff.Entity.Spells.Blood.LifestealKnife.LifestealKnifeRenderer;
import net.hazen.hazennstuff.Entity.Spells.Eldritch.SoulSeeker.SoulSeekerRenderer;
import net.hazen.hazennstuff.Entity.Spells.Evocation.SpectralAxe.SpectralRenderer;
import net.hazen.hazennstuff.Entity.Spells.Fire.BrimstoneHellblast.BrimstoneHellblastRenderer;
import net.hazen.hazennstuff.Entity.Spells.Fire.ImmolatingObliterator.ScorchingSlashRenderer;
import net.hazen.hazennstuff.Entity.Spells.Ice.IceArrow.CrystalVolley.CrystalVolleyRenderer;
import net.hazen.hazennstuff.Entity.Spells.Ice.IceArrow.IceArrowRenderer;
import net.hazen.hazennstuff.Entity.Spells.Lightning.EnergyBurst.EnergyBurstRenderer;
import net.hazen.hazennstuff.Entity.Spells.Nature.DeathSentence.DeathSentenceRenderer;
import net.hazen.hazennstuff.Entity.Spells.Nature.SpiderLily.SpiderLilyRenderer;
import net.hazen.hazennstuff.Entity.Spells.Nature.ThornChakram.ThornChakramRenderer;
import net.hazen.hazennstuff.Entity.Spells.Radiance.CrystalineMirror.CrystalineMirrorRenderer;
import net.hazen.hazennstuff.Entity.Spells.Radiance.ShootingStar.FallingStars.FallingStarRenderer;
import net.hazen.hazennstuff.Entity.Spells.Radiance.ShootingStar.ShootingStarRenderer;
import net.hazen.hazennstuff.Entity.Spells.Radiance.Syringe.SyringeRenderer;
import net.hazen.hazennstuff.Entity.Spells.Radiance.Terraprisma.TerraprismaRenderer;
import net.hazen.hazennstuff.Entity.Spells.Shadow.NightsEdgeAfterSlash.NightsEdgeAfterSlashRenderer;
import net.hazen.hazennstuff.Registries.HnSEntityRegistry;
import net.hazen.hazennstuff.Registries.HnSParticleRegistry;
import net.hazen.hazennstuff.Particle.General.HnSGenericParticle;
import net.hazen.hazennstuff.Particle.LeafParticle.LeafParticle;
import net.hazen.hazennstuff.Particle.SlashParticles.Spells.IonicSLash.IonicSlash;
import net.hazen.hazennstuff.Particle.SlashParticles.Spells.NatureSlash.NatureSlash;
import net.hazen.hazennstuff.Particle.SlashParticles.Spells.NightsEdgeStrike.NightsEdgeStrike;
import net.minecraft.client.renderer.entity.NoopRenderer;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.neoforged.neoforge.client.event.RegisterParticleProvidersEvent;

@EventBusSubscriber(value = Dist.CLIENT)
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
        event.registerEntityRenderer(HnSEntityRegistry.SHOOTING_STAR.get(), ShootingStarRenderer::new);
        event.registerEntityRenderer(HnSEntityRegistry.FALLING_STAR.get(), FallingStarRenderer::new);
        event.registerEntityRenderer(HnSEntityRegistry.TERRAPRISMA_PROJECTILE.get(), TerraprismaRenderer::new);
        event.registerEntityRenderer(HnSEntityRegistry.FIERY_DAGGER_MAGIC_PROJECTILE.get(), FieryDaggerRenderer::new);


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
        event.registerEntityRenderer(HnSEntityRegistry.TERRAPRISMA.get(), SummonedTerraprismaRenderer::new);
        event.registerEntityRenderer(HnSEntityRegistry.CINDEROUS_FURNACE.get(), CinderousFurnaceRenderer::new);
        event.registerEntityRenderer(HnSEntityRegistry.THE_INFERNO.get(), TheInfernoRenderer::new);
        event.registerEntityRenderer(HnSEntityRegistry.SUMMON_KEEPER.get(), KeeperRenderer::new);
        event.registerEntityRenderer(HnSEntityRegistry.CRYSTALINE_MIRROR.get(), CrystalineMirrorRenderer::new);


        /*
        *** Particles
         */

        event.registerEntityRenderer(HnSEntityRegistry.ICE_CLOUD.get(), NoopRenderer::new);
        event.registerEntityRenderer(HnSEntityRegistry.ICHOR_STREAM.get(), NoopRenderer::new);
        event.registerEntityRenderer(HnSEntityRegistry.LIGHTNING_STRIKE.get(), NoopRenderer::new);

        /*
        *** Blocks
         */

        event.registerBlockEntityRenderer(HnSBlockEntities.HAZEL_STATUE.get(), HazelStatueRenderer::new);
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
        event.registerSpriteSet(HnSParticleRegistry.IONIC_SLASH.get(), IonicSlash.Provider::new);
    }

}