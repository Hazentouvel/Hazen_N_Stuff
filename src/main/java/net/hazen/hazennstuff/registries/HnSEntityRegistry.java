package net.hazen.hazennstuff.registries;

import net.hazen.hazennstuff.HazenNStuff;
import net.hazen.hazennstuff.entity.spells.blood.lifesteal_knife.LifestealKnife;
import net.hazen.hazennstuff.entity.spells.blood.lifesteal_knife.LifestealKnifeModel;
import net.hazen.hazennstuff.entity.spells.dark.nights_edge_strike.NightsEdgeStrike;
import net.hazen.hazennstuff.entity.spells.fire.brimstone_hellblast.BrimstoneHellblast;
import net.hazen.hazennstuff.entity.spells.lightning.spark.Spark;
import net.hazen.hazennstuff.entity.spells.luminescent.syringe.Syringe;
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

    // Brimstone Hellblast
    public static final DeferredHolder<EntityType<?>, EntityType<BrimstoneHellblast>> BRIMSTONE_HELLBLAST =
            ENTITIES.register("brimstone_hellblast", () -> EntityType.Builder.<BrimstoneHellblast>of(BrimstoneHellblast::new, MobCategory.MISC)
                    .sized(1f, 1f)
                    .clientTrackingRange(4)
                    .build(ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "brimstone_hellblast").toString())
            );

    // Spark
    public static final DeferredHolder<EntityType<?>, EntityType<Spark>> SPARK =
            ENTITIES.register("spark", () -> EntityType.Builder.<Spark>of(Spark::new, MobCategory.MISC)
                    .sized(1f, 1f)
                    .clientTrackingRange(4)
                    .build(ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "spark").toString())
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
                    .build( ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "overwhelm").toString()));



    public static void register(IEventBus eventBus)
    {
        ENTITIES.register(eventBus);
    }
}