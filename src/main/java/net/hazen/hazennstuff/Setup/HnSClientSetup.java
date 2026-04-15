package net.hazen.hazennstuff.Setup;

import io.redspace.ironsspellbooks.entity.mobs.keeper.KeeperRenderer;
import io.redspace.ironsspellbooks.entity.spells.fiery_dagger.FieryDaggerRenderer;
import net.hazen.hazennstuff.Entity.Mobs.Mobs.VoidWanderer.VoidWandererRenderer;
import net.hazen.hazennstuff.Entity.Spells.Blood.BoneBolt.BoneBoltRenderer;
import net.hazen.hazennstuff.Entity.Spells.Blood.ViolentRegurgitation.FleshChunk.FleshChunkRenderer;
import net.hazen.hazennstuff.Entity.Spells.Blood.ViolentRegurgitation.FleshChunk.FleshMound.FleshMoundRenderer;
import net.hazen.hazennstuff.Entity.Spells.Blood.ViolentRegurgitation.FleshPiece.FleshPieceRenderer;
import net.hazen.hazennstuff.Entity.Spells.Cosmic.Evercomet.EvercometRenderer;
import net.hazen.hazennstuff.Entity.Spells.Cosmic.CosmicBolt.CosmicBoltRenderer;
import net.hazen.hazennstuff.Entity.Spells.Ender.EndraconicMeteor.EndraconicBreath.EndraconicBreathRenderer;
import net.hazen.hazennstuff.Entity.Spells.Ender.EndraconicMeteor.EndraconicMeteorRenderer;
import net.hazen.hazennstuff.Entity.Spells.Fire.ScorchingSlash.ScorchingBladeRenderer;
import net.hazen.hazennstuff.Entity.Spells.Hydro.HornShell.HornShellRenderer;
import net.hazen.hazennstuff.Entity.Spells.Hydro.Hydrobullet.HydroBulletRenderer;
import net.hazen.hazennstuff.Entity.Spells.Hydro.RazorbladeTyphoon.RazorbladeTyphoonRenderer;
import net.hazen.hazennstuff.Entity.Spells.Hydro.TridentBarrage.TridentJetstreamRenderer;
import net.hazen.hazennstuff.Entity.Spells.Hydro.WaterBolt.WaterBoltRenderer;
import net.hazen.hazennstuff.Entity.Spells.Ice.Hailstorm.IceChunkA.IceChunkARenderer;
import net.hazen.hazennstuff.Entity.Spells.Ice.Hailstorm.IceChunkB.IceChunkBRenderer;
import net.hazen.hazennstuff.Entity.Spells.Ice.Hailstorm.IceChunkC.IceChunkCRenderer;
import net.hazen.hazennstuff.Entity.Spells.Lightning.DazzlingObliteration.NinguDemonbanePetalbladeRenderer;
import net.hazen.hazennstuff.Entity.Spells.Lightning.DazzlingObliteration.Shuriken.NinguDemonbanePetalbladeShurikenRenderer;
import net.hazen.hazennstuff.Entity.Spells.Shadow.ArcaneCards.Club.ClubRenderer;
import net.hazen.hazennstuff.Entity.Spells.Shadow.ArcaneCards.Diamond.DiamondRenderer;
import net.hazen.hazennstuff.Entity.Spells.Shadow.ArcaneCards.Heart.HeartRenderer;
import net.hazen.hazennstuff.Entity.Spells.Shadow.ArcaneCards.Spade.SpadeRenderer;
import net.hazen.hazennstuff.Entity.Spells.Shadow.ShadowDagger.ShadowDaggerRenderer;
import net.hazen.hazennstuff.Entity.Spells.Shadow.ShadowReaver.ShadowReaverRenderer;
import net.hazen.hazennstuff.HazenNStuff;
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
import net.hazen.hazennstuff.Entity.Spells.Evocation.SpectralAxe.SpectralAxeRenderer;
import net.hazen.hazennstuff.Entity.Spells.Fire.BrimstoneHellblast.BrimstoneHellblastRenderer;
import net.hazen.hazennstuff.Entity.Spells.Ice.IceArrow.IceArrowRenderer;
import net.hazen.hazennstuff.Entity.Spells.Lightning.EnergyBurst.EnergyBurstRenderer;
import net.hazen.hazennstuff.Entity.Spells.Nature.DeathSentence.DeathSentenceRenderer;
import net.hazen.hazennstuff.Entity.Spells.Nature.SpiderLily.SpiderLilyRenderer;
import net.hazen.hazennstuff.Entity.Spells.Nature.ThornChakram.ThornChakramRenderer;
import net.hazen.hazennstuff.Entity.Spells.Cosmic.ShootingStar.ShootingStarRenderer;
import net.hazen.hazennstuff.Entity.Spells.Radiance.Syringe.SyringeRenderer;
import net.hazen.hazennstuff.Entity.Spells.Radiance.Terraprisma.TerraprismaRenderer;
import net.hazen.hazennstuff.Entity.Spells.Shadow.NightsEdgeAfterSlash.NightsEdgeAfterSlashRenderer;
import net.hazen.hazennstuff.Particle.SlashParticles.Spells.ScorchingSlash.ScorchingSlash;
import net.hazen.hazennstuff.Registries.HnSEntityRegistry;
import net.hazen.hazennstuff.Registries.HnSParticleRegistry;
import net.hazen.hazennstuff.Particle.HnSGenericParticle;
import net.hazen.hazennstuff.Particle.LeafParticle.LeafParticle;
import net.hazen.hazennstuff.Particle.SlashParticles.Spells.IonicSLash.IonicSlash;
import net.hazen.hazennstuff.Particle.SlashParticles.Spells.NatureSlash.NatureSlash;
import net.hazen.hazennstuff.Particle.SlashParticles.Spells.NightsEdgeStrike.NightsEdgeStrike;
import net.hazen.hazennstuff.Spells.Tooltips.LightningClientTooltipComponent;
import net.minecraft.client.renderer.entity.NoopRenderer;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.neoforged.neoforge.client.event.RegisterClientTooltipComponentFactoriesEvent;
import net.neoforged.neoforge.client.event.RegisterParticleProvidersEvent;

@EventBusSubscriber(modid = HazenNStuff.MOD_ID)
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
        event.registerEntityRenderer(HnSEntityRegistry.ICE_CHUNK_A.get(), IceChunkARenderer::new);
        event.registerEntityRenderer(HnSEntityRegistry.ICE_CHUNK_B.get(), IceChunkBRenderer::new);
        event.registerEntityRenderer(HnSEntityRegistry.ICE_CHUNK_C.get(), IceChunkCRenderer::new);
        event.registerEntityRenderer(HnSEntityRegistry.SPECTRAL_AXE.get(), SpectralAxeRenderer::new);
        event.registerEntityRenderer(HnSEntityRegistry.SOUL_SEEKER.get(), SoulSeekerRenderer::new);
        event.registerEntityRenderer(HnSEntityRegistry.SPIDER_LILY.get(), SpiderLilyRenderer::new);
        event.registerEntityRenderer(HnSEntityRegistry.DEATH_SENTENCE.get(), DeathSentenceRenderer::new);
        event.registerEntityRenderer(HnSEntityRegistry.NIGHTS_EDGE_AFTER_SLASH.get(), NightsEdgeAfterSlashRenderer::new);
        event.registerEntityRenderer(HnSEntityRegistry.SCORCHING_SLASH.get(), ScorchingBladeRenderer::new);
        event.registerEntityRenderer(HnSEntityRegistry.SHOOTING_STAR.get(), ShootingStarRenderer::new);
        event.registerEntityRenderer(HnSEntityRegistry.TERRAPRISMA_PROJECTILE.get(), TerraprismaRenderer::new);
        event.registerEntityRenderer(HnSEntityRegistry.FIERY_DAGGER_MAGIC_PROJECTILE.get(), FieryDaggerRenderer::new);
        event.registerEntityRenderer(HnSEntityRegistry.SHADOW_DAGGER.get(), ShadowDaggerRenderer::new);
        event.registerEntityRenderer(HnSEntityRegistry.COSMIC_BOLT.get(), CosmicBoltRenderer::new);
        event.registerEntityRenderer(HnSEntityRegistry.SHADOW_REAVER.get(), ShadowReaverRenderer::new);
        event.registerEntityRenderer(HnSEntityRegistry.EVERCOMET.get(), EvercometRenderer::new);
        event.registerEntityRenderer(HnSEntityRegistry.HYDROBULLET.get(), HydroBulletRenderer::new);
        event.registerEntityRenderer(HnSEntityRegistry.WATER_BOLT.get(), WaterBoltRenderer::new);
        event.registerEntityRenderer(HnSEntityRegistry.SPADE.get(), SpadeRenderer::new);
        event.registerEntityRenderer(HnSEntityRegistry.CLUB.get(), ClubRenderer::new);
        event.registerEntityRenderer(HnSEntityRegistry.DIAMOND.get(), DiamondRenderer::new);
        event.registerEntityRenderer(HnSEntityRegistry.HEART.get(), HeartRenderer::new);
        event.registerEntityRenderer(HnSEntityRegistry.RAZORBLADE_TYPHOON.get(), RazorbladeTyphoonRenderer::new);
        event.registerEntityRenderer(HnSEntityRegistry.HORN_SHELL.get(), HornShellRenderer::new);
        event.registerEntityRenderer(HnSEntityRegistry.TRIDENT_JETSTREAM.get(), TridentJetstreamRenderer::new);
        event.registerEntityRenderer(HnSEntityRegistry.NINGU_DEMONBANE_PETALBLADE.get(), NinguDemonbanePetalbladeRenderer::new);
        event.registerEntityRenderer(HnSEntityRegistry.NINGU_DEMONBANE_PETALBLADE_SHURIKEN.get(), NinguDemonbanePetalbladeShurikenRenderer::new);
        event.registerEntityRenderer(HnSEntityRegistry.ENDRACONIC_METEOR.get(), EndraconicMeteorRenderer::new);
        event.registerEntityRenderer(HnSEntityRegistry.ENDRACONIC_BREATH.get(), EndraconicBreathRenderer::new);
        event.registerEntityRenderer(HnSEntityRegistry.FLESH_CHUNK.get(), FleshChunkRenderer::new);
        event.registerEntityRenderer(HnSEntityRegistry.FLESH_PIECE.get(), FleshPieceRenderer::new);
        event.registerEntityRenderer(HnSEntityRegistry.FLESH_MOUND.get(), FleshMoundRenderer::new);
        event.registerEntityRenderer(HnSEntityRegistry.BONE_BOLT.get(), BoneBoltRenderer::new);


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
        event.registerEntityRenderer(HnSEntityRegistry.VOID_WANDERER.get(), VoidWandererRenderer::new);


        /*
        *** Particles
         */

        event.registerEntityRenderer(HnSEntityRegistry.ICE_CLOUD.get(), NoopRenderer::new);
        event.registerEntityRenderer(HnSEntityRegistry.ENDRACONIC_BREATH.get(), EndraconicBreathRenderer::new);
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
        event.registerSpriteSet(HnSParticleRegistry.ELDRITCH_SOUL_PARTICLE.get(), HnSGenericParticle.Provider::new);

        event.registerSpriteSet(HnSParticleRegistry.MUSHROOM_PARTICLE.get(), HnSGenericParticle.Provider::new);

        event.registerSpriteSet(HnSParticleRegistry.STAR_PARTICLE.get(), HnSGenericParticle.Provider::new);
        event.registerSpriteSet(HnSParticleRegistry.STAR_IMPACT_PARTICLE.get(), HnSGenericParticle.Provider::new);
        event.registerSpriteSet(HnSParticleRegistry.COSMIC_EMBER_PARTICLE.get(), HnSGenericParticle.Provider::new);
        event.registerSpriteSet(HnSParticleRegistry.ENDER_EMBER_PARTICLE.get(), HnSGenericParticle.Provider::new);

        event.registerSpriteSet(HnSParticleRegistry.BLADE_PARTICLES.get(), HnSGenericParticle.Provider::new);
        event.registerSpriteSet(HnSParticleRegistry.NIGHTS_EDGE_PARTICLE.get(), HnSGenericParticle.Provider::new);
        event.registerSpriteSet(HnSParticleRegistry.ROD_OF_DISCORD_PARTICLE.get(), HnSGenericParticle.Provider::new);
        event.registerSpriteSet(HnSParticleRegistry.LEAF_PARTICLE.get(), LeafParticle.Provider::new);

        event.registerSpriteSet(HnSParticleRegistry.NIGHTS_EDGE_STRIKE_PARTICLE.get(), NightsEdgeStrike.Provider::new);
        event.registerSpriteSet(HnSParticleRegistry.NATURE_SLASH_PARTICLE.get(), NatureSlash.Provider::new);
        event.registerSpriteSet(HnSParticleRegistry.IONIC_SLASH.get(), IonicSlash.Provider::new);
        event.registerSpriteSet(HnSParticleRegistry.SCORCHING_SLASH.get(), ScorchingSlash.Provider::new);
    }

    @SubscribeEvent
    public static void onRegisterTooltipComponents(RegisterClientTooltipComponentFactoriesEvent event) {
        event.register(LightningClientTooltipComponent.LightningTooltipData.class, LightningClientTooltipComponent::new);
    }

}