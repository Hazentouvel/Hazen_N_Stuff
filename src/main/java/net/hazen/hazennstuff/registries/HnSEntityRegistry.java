package net.hazen.hazennstuff.registries;

import net.hazen.hazennstuff.HazenNStuff;
import net.hazen.hazennstuff.entity.mobs.wizards.Evil.BishopOfDeciet.BishopOfDeceitEntity;
import net.hazen.hazennstuff.entity.mobs.wizards.Evil.Necromancers.NamelessOne.NamelessOneEntity;
import net.hazen.hazennstuff.entity.mobs.wizards.Evil.Necromancers.Necromancer.NecromancerEntity;
import net.hazen.hazennstuff.entity.mobs.wizards.Good.Dryad.DryadEntity;
import net.hazen.hazennstuff.entity.mobs.wizards.Evil.ReignOfTyros.Aegis.AegisEntity;
import net.hazen.hazennstuff.entity.mobs.wizards.Evil.ReignOfTyros.Aptos.AptosEntity;
import net.hazen.hazennstuff.entity.mobs.wizards.Evil.ReignOfTyros.Pyromus.PyromusEntity;
import net.hazen.hazennstuff.entity.mobs.wizards.Evil.Electromancer.ElectromancerEntity;
import net.hazen.hazennstuff.entity.mobs.wizards.Evil.PiglinPyromancer.PiglinPyromancerEntity;
import net.hazen.hazennstuff.entity.mobs.wizards.Evil.ServantsOfEnder.ServantsOfEnderEntity;
import net.hazen.hazennstuff.entity.mobs.wizards.Good.TheRecluse.TheRecluseEntity;
import net.hazen.hazennstuff.entity.spells.blood.lifesteal_knife.LifestealKnife;
import net.hazen.hazennstuff.entity.spells.eldritch.soul_seeker.SoulSeeker;
import net.hazen.hazennstuff.entity.spells.evocation.spectral_axe.SpectralAxe;
import net.hazen.hazennstuff.entity.spells.holy.ichor_stream.IchorStream;
import net.hazen.hazennstuff.entity.spells.lightning.InstantLightningStrike.LightningStrike;
import net.hazen.hazennstuff.entity.spells.nature.spider_lily.SpiderLily;
import net.hazen.hazennstuff.entity.spells.shadow.nights_edge_strike.NightsEdgeStrike;
import net.hazen.hazennstuff.entity.spells.fire.brimstone_hellblast.BrimstoneHellblast;
import net.hazen.hazennstuff.entity.spells.ice.ice_arrow.IceCloud.IceCloud;
import net.hazen.hazennstuff.entity.spells.ice.ice_arrow.IceArrow;
import net.hazen.hazennstuff.entity.spells.ice.ice_arrow.crystal_volley.CrystalVolley;
import net.hazen.hazennstuff.entity.spells.lightning.spark.EnergyBurst;
import net.hazen.hazennstuff.entity.spells.radiance.syringe.Syringe;
import net.hazen.hazennstuff.entity.spells.nature.thorn_chakram.ThornChakram;
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
    public static final DeferredHolder<EntityType<?>, EntityType<LifestealKnife>> LIFESTEAL_KNIFE =
            ENTITIES.register("lifesteal_knife", () -> EntityType.Builder.<LifestealKnife>of(LifestealKnife::new, MobCategory.MISC)
                    .sized(1f, 1f)
                    .clientTrackingRange(4)
                    .build(ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "lifesteal_knife").toString())
            );

    //Nights Edge Strike
    public static final DeferredHolder<EntityType<?>, EntityType<NightsEdgeStrike>> NIGHTS_EDGE_STRIKE=
            ENTITIES.register("nights_edge_strike", () -> EntityType.Builder.<NightsEdgeStrike>of(NightsEdgeStrike::new, MobCategory.MISC)
                    .sized(8f, 1f)
                    .clientTrackingRange(64)
                    .build( ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "nights_edge_strike").toString())
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