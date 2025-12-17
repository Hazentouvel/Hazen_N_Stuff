package net.hazen.hazennstuff.Registries;

import net.hazen.hazennstuff.Entity.Mobs.Mobs.Blazes.CinderousFurnace.CinderousFurnace;
import net.hazen.hazennstuff.Entity.Mobs.Mobs.Blazes.TheInferno.TheInferno;
import net.hazen.hazennstuff.Entity.Mobs.Summons.ReignOfTyros.Keeper.SummonKeeper;
import net.hazen.hazennstuff.Entity.Mobs.Summons.SummonTerraprisma.SummonedTerraprisma;
import net.hazen.hazennstuff.Entity.Mobs.Wizards.Evil.BishopOfDeciet.BishopOfDeceitEntity;
import net.hazen.hazennstuff.Entity.Mobs.Wizards.Evil.Electromancer.ElectromancerEntity;
import net.hazen.hazennstuff.Entity.Mobs.Wizards.Evil.Necromancers.NamelessOne.NamelessOneEntity;
import net.hazen.hazennstuff.Entity.Mobs.Wizards.Evil.Necromancers.Necromancer.NecromancerEntity;
import net.hazen.hazennstuff.Entity.Mobs.Wizards.Evil.PiglinPyromancer.PiglinPyromancerEntity;
import net.hazen.hazennstuff.Entity.Mobs.Wizards.Evil.ReignOfTyros.Aegis.AegisEntity;
import net.hazen.hazennstuff.Entity.Mobs.Wizards.Evil.ReignOfTyros.Aptos.AptosEntity;
import net.hazen.hazennstuff.Entity.Mobs.Wizards.Evil.ReignOfTyros.Pyromus.PyromusEntity;
import net.hazen.hazennstuff.Entity.Mobs.Wizards.Evil.ServantsOfEnder.ServantsOfEnderEntity;
import net.hazen.hazennstuff.Entity.Mobs.Wizards.Good.Dryad.DryadEntity;
import net.hazen.hazennstuff.Entity.Mobs.Wizards.Good.TheRecluse.TheRecluseEntity;
import net.hazen.hazennstuff.Entity.Spells.Blood.LifestealKnife.VampireKnife;
import net.hazen.hazennstuff.Entity.Spells.Eldritch.SoulSeeker.SoulSeeker;
import net.hazen.hazennstuff.Entity.Spells.Evocation.SpectralAxe.SpectralAxe;
import net.hazen.hazennstuff.Entity.Spells.Fire.BrimstoneHellblast.BrimstoneHellblast;
import net.hazen.hazennstuff.Entity.Spells.Fire.FireDaggers.FieryDaggerMagicProjectile;
import net.hazen.hazennstuff.Entity.Spells.Fire.ImmolatingObliterator.ScorchingSlash;
import net.hazen.hazennstuff.Entity.Spells.Holy.IchorStream.IchorStream;
import net.hazen.hazennstuff.Entity.Spells.Ice.IceArrow.CrystalVolley.CrystalVolley;
import net.hazen.hazennstuff.Entity.Spells.Ice.IceArrow.IceArrow;
import net.hazen.hazennstuff.Entity.Spells.Ice.IceArrow.IceCloud.IceCloud;
import net.hazen.hazennstuff.Entity.Spells.Lightning.EnergyBurst.EnergyBurst;
import net.hazen.hazennstuff.Entity.Spells.Lightning.InstantLightningStrike.LightningStrike;
import net.hazen.hazennstuff.Entity.Spells.Nature.DeathSentence.DeathSentence;
import net.hazen.hazennstuff.Entity.Spells.Nature.SpiderLily.SpiderLily;
import net.hazen.hazennstuff.Entity.Spells.Nature.ThornChakram.ThornChakram;
import net.hazen.hazennstuff.Entity.Spells.Radiance.CrystalineMirror.CrystalineMirror;
import net.hazen.hazennstuff.Entity.Spells.Radiance.ShootingStar.FallingStars.FallingStar;
import net.hazen.hazennstuff.Entity.Spells.Radiance.ShootingStar.ShootingStar;
import net.hazen.hazennstuff.Entity.Spells.Radiance.Syringe.Syringe;
import net.hazen.hazennstuff.Entity.Spells.Radiance.Terraprisma.Terraprisma;
import net.hazen.hazennstuff.Entity.Spells.Shadow.NightsEdgeAfterSlash.NightsEdgeAfterSlash;
import net.hazen.hazennstuff.HazenNStuff;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class HnSEntityRegistry {
    private static final DeferredRegister<EntityType<?>> ENTITIES = DeferredRegister
            .create(Registries.ENTITY_TYPE, HazenNStuff.MOD_ID);


    /*
    *** Spells
     */


    // Brimstone Hellblast
    public static final DeferredHolder<EntityType<?>, EntityType<BrimstoneHellblast>> BRIMSTONE_HELLBLAST =
            ENTITIES.register("brimstone_hellblast", () -> EntityType.Builder.<BrimstoneHellblast>of(BrimstoneHellblast::new, MobCategory.MISC)
                    .sized(1f, 1f)
                    .clientTrackingRange(4)
                    .build(ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "brimstone_hellblast").toString())
            );

    // Spark
    public static final DeferredHolder<EntityType<?>, EntityType<EnergyBurst>> ENERGY_BURST =
            ENTITIES.register("energy_burst", () -> EntityType.Builder.<EnergyBurst>of(EnergyBurst::new, MobCategory.MISC)
                    .sized(1f, 1f)
                    .clientTrackingRange(4)
                    .build(ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "energy_burst").toString())
            );

    // Syringe
    public static final DeferredHolder<EntityType<?>, EntityType<Syringe>> SYRINGE =
            ENTITIES.register("syringe", () -> EntityType.Builder.<Syringe>of(Syringe::new, MobCategory.MISC)
                    .sized(1f, 1f)
                    .clientTrackingRange(4)
                    .build(ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "syringe").toString())
            );

    // Lifesteal Knife
    public static final DeferredHolder<EntityType<?>, EntityType<VampireKnife>> LIFESTEAL_KNIFE =
            ENTITIES.register("lifesteal_knife", () -> EntityType.Builder.<VampireKnife>of(VampireKnife::new, MobCategory.MISC)
                    .sized(1f, 1f)
                    .clientTrackingRange(4)
                    .build(ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "lifesteal_knife").toString())
            );

    // Thorn Chakram
    public static final DeferredHolder<EntityType<?>, EntityType<ThornChakram>> THORN_CHAKRAM=
            ENTITIES.register("thorn_chakram", () -> EntityType.Builder.<ThornChakram>of(ThornChakram::new, MobCategory.MISC)
                    .sized(1f, 1f)
                    .clientTrackingRange(64)
                    .build( ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "thorn_chakram").toString())
            );

    // Ice Arrow
    public static final DeferredHolder<EntityType<?>, EntityType<IceArrow>> ICE_ARROW=
            ENTITIES.register("ice_arrow", () -> EntityType.Builder.<IceArrow>of(IceArrow::new, MobCategory.MISC)
                    .sized(1f, 1f)
                    .clientTrackingRange(64)
                    .build( ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "ice_arrow").toString())
            );


    // Crystal Volley
    public static final DeferredHolder<EntityType<?>, EntityType<CrystalVolley>> CRYSTAL_VOLLEY =
            ENTITIES.register("crystal_volley", () -> EntityType.Builder.<CrystalVolley>of(CrystalVolley::new, MobCategory.MISC)
                    .sized(1f, 1f)
                    .clientTrackingRange(64)
                    .build( ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "crystal_volley").toString())
            );

    // Spectral Axe
    public static final DeferredHolder<EntityType<?>, EntityType<SpectralAxe>> SPECTRAL_AXE =
            ENTITIES.register("spectral_axe", () -> EntityType.Builder.<SpectralAxe>of(SpectralAxe::new, MobCategory.MISC)
                    .sized(1f, 1f)
                    .clientTrackingRange(64)
                    .build( ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "spectral_axe").toString())
            );

    // Soul Seeker
    public static final DeferredHolder<EntityType<?>, EntityType<SoulSeeker>> SOUL_SEEKER =
            ENTITIES.register("soul_seeker", () -> EntityType.Builder.<SoulSeeker>of(SoulSeeker::new, MobCategory.MISC)
                    .sized(1f, 1f)
                    .clientTrackingRange(64)
                    .build( ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "soul_seeker").toString())
            );

    // Spider lily
    public static final DeferredHolder<EntityType<?>, EntityType<SpiderLily>> SPIDER_LILY =
            ENTITIES.register("spider_lily", () -> EntityType.Builder.<SpiderLily>of(SpiderLily::new, MobCategory.MISC)
                    .sized(1f, 1f)
                    .clientTrackingRange(64)
                    .build( ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "spider_lily").toString())
            );

    // Death Sentence
    public static final DeferredHolder<EntityType<?>, EntityType<DeathSentence>> DEATH_SENTENCE =
            ENTITIES.register("death_sentence", () -> EntityType.Builder.<DeathSentence>of(DeathSentence::new, MobCategory.MISC)
                    .sized(1.5f, 3f)
                    .clientTrackingRange(64)
                    .build( ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "death_sentence").toString())
            );

    // Night's Edge After Slash
    public static final DeferredHolder<EntityType<?>, EntityType<NightsEdgeAfterSlash>> NIGHTS_EDGE_AFTER_SLASH =
            ENTITIES.register("nights_edge_after_slash", () -> EntityType.Builder.<NightsEdgeAfterSlash>of(NightsEdgeAfterSlash::new, MobCategory.MISC)
                    .sized(4f, 1f)
                    .clientTrackingRange(64)
                    .build( ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "nights_edge_after_slash").toString())
            );

    // Scorching Slash
    public static final DeferredHolder<EntityType<?>, EntityType<ScorchingSlash>> SCORCHING_SLASH =
            ENTITIES.register("scorching_slash", () -> EntityType.Builder.<ScorchingSlash>of(ScorchingSlash::new, MobCategory.MISC)
                    .sized(4f, 1f)
                    .clientTrackingRange(64)
                    .build( ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "scorching_slash").toString())
            );

    // Shooting Star
    public static final DeferredHolder<EntityType<?>, EntityType<ShootingStar>> SHOOTING_STAR =
            ENTITIES.register("shooting_star", () -> EntityType.Builder.<ShootingStar>of(ShootingStar::new, MobCategory.MISC)
                    .sized(1f, 1f)
                    .clientTrackingRange(64)
                    .build( ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "shooting_star").toString())
            );

    // Falling Star
    public static final DeferredHolder<EntityType<?>, EntityType<FallingStar>> FALLING_STAR =
            ENTITIES.register("falling_star", () -> EntityType.Builder.<FallingStar>of(FallingStar::new, MobCategory.MISC)
                    .sized(1f, 1f)
                    .clientTrackingRange(64)
                    .build( ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "falling_star").toString())
            );

    // Terraprisma
    public static final DeferredHolder<EntityType<?>, EntityType<Terraprisma>> TERRAPRISMA_PROJECTILE =
            ENTITIES.register("terraprisma_projectile", () -> EntityType.Builder.<Terraprisma>of(Terraprisma::new, MobCategory.MISC)
                    .sized(1f, 1f)
                    .clientTrackingRange(64)
                    .build( ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "terraprisma_projectile").toString())
            );

    // Fiery Dagger Magic Projectile
    public static final DeferredHolder<EntityType<?>, EntityType<FieryDaggerMagicProjectile>> FIERY_DAGGER_MAGIC_PROJECTILE =
            ENTITIES.register("fiery_dagger_magic_projectile", () -> EntityType.Builder.<FieryDaggerMagicProjectile>of(FieryDaggerMagicProjectile::new, MobCategory.MISC)
                    .sized(0.5f, 0.5f)
                    .clientTrackingRange(64)
                    .build( ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "fiery_dagger_magic_projectile").toString())
            );

    // Fiery Dagger Magic Projectile
    public static final DeferredHolder<EntityType<?>, EntityType<CrystalineMirror>> CRYSTALINE_MIRROR =
            ENTITIES.register("crystaline_mirror", () -> EntityType.Builder.<CrystalineMirror>of(CrystalineMirror::new, MobCategory.MISC)
                    .sized(0.5f, 0.5f)
                    .clientTrackingRange(64)
                    .build( ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "crystaline_mirror").toString())
            );




    /*
    *** Entities
     */

    //Electromancer
    public static final DeferredHolder<EntityType<?>, EntityType<ElectromancerEntity>> ELECTROMANCER =
            ENTITIES.register("electromancer", () -> EntityType.Builder.of(ElectromancerEntity::new, MobCategory.MONSTER)
                    .sized(.6f, 1.8f)
                    .clientTrackingRange(64)
                    .build(ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "electromancer").toString()));

    //Aptos
    public static final DeferredHolder<EntityType<?>, EntityType<AptosEntity>> APTOS =
            ENTITIES.register("aptos", () -> EntityType.Builder.<AptosEntity>of(AptosEntity::new, MobCategory.MONSTER)
                    .sized(.85f, 2.3f)
                    .clientTrackingRange(64)
                    .eyeHeight(2.3f)
                    .build(ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "aptos").toString()));

    //Pyromus
    public static final DeferredHolder<EntityType<?>, EntityType<PyromusEntity>> PYROMUS =
            ENTITIES.register("pyromus", () -> EntityType.Builder.<PyromusEntity>of(PyromusEntity::new, MobCategory.MONSTER)
                    .sized(.85f, 2.3f)
                    .clientTrackingRange(64)
                    .eyeHeight(2.3f)
                    .build(ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "pyromus").toString()));

    //Aegis
    public static final DeferredHolder<EntityType<?>, EntityType<AegisEntity>> AEGIS =
            ENTITIES.register("aegis", () -> EntityType.Builder.<AegisEntity>of(AegisEntity::new, MobCategory.MONSTER)
                    .sized(.85f, 2.3f)
                    .clientTrackingRange(64)
                    .eyeHeight(2.3f)
                    .build(ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "aegis").toString()));

    //The Recluse
    public static final DeferredHolder<EntityType<?>, EntityType<TheRecluseEntity>> THE_RECLUSE =
            ENTITIES.register("the_recluse", () -> EntityType.Builder.<TheRecluseEntity>of(TheRecluseEntity::new, MobCategory.MONSTER)
                    .sized(.6f, 3f)
                    .clientTrackingRange(64)
                    .eyeHeight(3f)
                    .build(ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "the_recluse").toString()));

    //Piglin Pyromancer
    public static final DeferredHolder<EntityType<?>, EntityType<PiglinPyromancerEntity>> PIGLIN_PYROMANCER =
            ENTITIES.register("piglin_pyromancer", () -> EntityType.Builder.<PiglinPyromancerEntity>of(PiglinPyromancerEntity::new, MobCategory.MONSTER)
                    .sized(.6f, 1.8f)
                    .clientTrackingRange(64)
                    .eyeHeight(2.3f)
                    .build(ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "piglin_pyromancer").toString()));

    //Servant of Ender
    public static final DeferredHolder<EntityType<?>, EntityType<ServantsOfEnderEntity>> SERVANT_OF_ENDER =
            ENTITIES.register("servant_of_ender", () -> EntityType.Builder.<ServantsOfEnderEntity>of(ServantsOfEnderEntity::new, MobCategory.MONSTER)
                    .sized(.6f, 3f)
                    .clientTrackingRange(64)
                    .eyeHeight(3f)
                    .build(ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "servant_of_ender").toString()));

    //Bishop of Deceit
    public static final DeferredHolder<EntityType<?>, EntityType<BishopOfDeceitEntity>> BISHOP_OF_DECEIT =
            ENTITIES.register("bishop_of_deceit", () -> EntityType.Builder.<BishopOfDeceitEntity>of(BishopOfDeceitEntity::new, MobCategory.MONSTER)
                    .sized(.6f, 1.8f)
                    .clientTrackingRange(64)
                    .eyeHeight(3f)
                    .build(ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "bishop_of_deceit").toString()));

    //Dryad
    public static final DeferredHolder<EntityType<?>, EntityType<DryadEntity>> DRYAD =
            ENTITIES.register("dryad", () -> EntityType.Builder.<DryadEntity>of(DryadEntity::new, MobCategory.MONSTER)
                    .sized(.6f, 1.8f)
                    .clientTrackingRange(64)
                    .eyeHeight(3f)
                    .build(ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "dryad").toString()));

    //Nameless One
    public static final DeferredHolder<EntityType<?>, EntityType<NamelessOneEntity>> NAMELESS_ONE =
            ENTITIES.register("nameless_one", () -> EntityType.Builder.<NamelessOneEntity>of(NamelessOneEntity::new, MobCategory.MONSTER)
                    .sized(.6f, 1.8f)
                    .clientTrackingRange(64)
                    .eyeHeight(3f)
                    .build(ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "nameless_one").toString()));

    //Necromancer
    public static final DeferredHolder<EntityType<?>, EntityType<NecromancerEntity>> NECROMANCER =
            ENTITIES.register("necromancer", () -> EntityType.Builder.<NecromancerEntity>of(NecromancerEntity::new, MobCategory.MONSTER)
                    .sized(.6f, 1.8f)
                    .clientTrackingRange(64)
                    .eyeHeight(3f)
                    .build(ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "necromancer").toString()));

    // Terraprisma
    public static final DeferredHolder<EntityType<?>, EntityType<SummonedTerraprisma>> TERRAPRISMA =
            ENTITIES.register("terraprisma", () -> EntityType.Builder.<SummonedTerraprisma>of(SummonedTerraprisma::new, MobCategory.MONSTER)
                    .sized(.6f, 1.8f)
                    .clientTrackingRange(64)
                    .eyeHeight(1.6f)
                    .build(ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "terraprisma").toString()));

    // Cinderous Furnace
    public static final DeferredHolder<EntityType<?>, EntityType<CinderousFurnace>> CINDEROUS_FURNACE =
            ENTITIES.register("cinderous_furnace", () -> EntityType.Builder.<CinderousFurnace>of(CinderousFurnace::new, MobCategory.MONSTER)
                    .fireImmune()
                    .sized(0.6F, 1.8F)
                    .clientTrackingRange(8)
                    .eyeHeight(1.6f)
                    .build(ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "cinderous_furnace").toString()));

    // The Inferno
    public static final DeferredHolder<EntityType<?>, EntityType<TheInferno>> THE_INFERNO =
            ENTITIES.register("the_inferno", () -> EntityType.Builder.of(TheInferno::new, MobCategory.MONSTER)
                    .fireImmune()
                    .sized(0.6F, 1.8F)
                    .clientTrackingRange(8)
                    .eyeHeight(1.6f)
                    .build(ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "the_inferno").toString()));

    // The Inferno
    public static final DeferredHolder<EntityType<?>, EntityType<SummonKeeper>> SUMMON_KEEPER =
            ENTITIES.register("summon_keeper",  () -> EntityType.Builder.<SummonKeeper>of(SummonKeeper::new, MobCategory.MONSTER)
                    .sized(0.85F, 2.3F)
                    .clientTrackingRange(64)
                    .eyeHeight(2.3F)
                    .build(ResourceLocation.fromNamespaceAndPath("summoned_keeper", "summon_keeper").toString())
            );





    /*
    *** Particles
     */

    public static final DeferredHolder<EntityType<?>, EntityType<IceCloud>> ICE_CLOUD =
            ENTITIES.register("ice_cloud", () -> EntityType.Builder.<IceCloud>of(IceCloud::new, MobCategory.MISC)
                    .sized(4f, 1.2f)
                    .clientTrackingRange(64)
                    .build(ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "ice_cloud").toString()));

    public static final DeferredHolder<EntityType<?>, EntityType<IchorStream>> ICHOR_STREAM =
            ENTITIES.register("ichor_stream", () -> EntityType.Builder.<IchorStream>of(IchorStream::new, MobCategory.MISC)
                    .sized(1.2f, 1.2f)
                    .clientTrackingRange(64)
                    .build(ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "ichor_stream").toString()));

    public static final DeferredHolder<EntityType<?>, EntityType<LightningStrike>> LIGHTNING_STRIKE =
            ENTITIES.register("lightning_strike", () -> EntityType.Builder.<LightningStrike>of(LightningStrike::new, MobCategory.MISC)
                    .sized(1.2f, 1.2f)
                    .clientTrackingRange(64)
                    .build(ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "lightning_strike").toString()));

    public static void register(IEventBus eventBus)
    {
        ENTITIES.register(eventBus);
    }
}