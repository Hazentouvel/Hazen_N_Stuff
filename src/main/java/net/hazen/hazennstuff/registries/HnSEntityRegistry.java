package net.hazen.hazennstuff.registries;

import net.hazen.hazennstuff.HazenNStuff;
import net.hazen.hazennstuff.entity.mobs.ReignOfTyros.Aegis.AegisEntity;
import net.hazen.hazennstuff.entity.mobs.ReignOfTyros.Aptos.AptosEntity;
import net.hazen.hazennstuff.entity.mobs.ReignOfTyros.Pyromus.PyromusEntity;
import net.hazen.hazennstuff.entity.mobs.wizards.Electromancer.ElectromancerEntity;
import net.hazen.hazennstuff.entity.spells.blood.lifesteal_knife.LifestealKnife;
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

    // Thorn Chakram
    public static final DeferredHolder<EntityType<?>, EntityType<IceArrow>> ICE_ARROW=
            ENTITIES.register("ice_arrow", () -> EntityType.Builder.<IceArrow>of(IceArrow::new, MobCategory.MISC)
                    .sized(1f, 1f)
                    .clientTrackingRange(64)
                    .build( ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "ice_arrow").toString())
            );


    // Thorn Chakram
    public static final DeferredHolder<EntityType<?>, EntityType<CrystalVolley>> CRYSTAL_VOLLEY =
            ENTITIES.register("crystal_volley", () -> EntityType.Builder.<CrystalVolley>of(CrystalVolley::new, MobCategory.MISC)
                    .sized(1f, 1f)
                    .clientTrackingRange(64)
                    .build( ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "crystal_volley").toString())
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

    /*
    *** Particles
     */

    public static final DeferredHolder<EntityType<?>, EntityType<IceCloud>> ICE_CLOUD =
            ENTITIES.register("ice_cloud", () -> EntityType.Builder.<IceCloud>of(IceCloud::new, MobCategory.MISC)
                    .sized(4f, 1.2f)
                    .clientTrackingRange(64)
                    .build(ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "ice_cloud").toString()));


    public static void register(IEventBus eventBus)
    {
        ENTITIES.register(eventBus);
    }
}