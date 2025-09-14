package net.hazen.hazennstuff.setup;

import net.hazen.hazennstuff.HazenNStuff;
import net.hazen.hazennstuff.entity.mobs.ReignOfTyros.Aegis.AegisEntity;
import net.hazen.hazennstuff.entity.mobs.ReignOfTyros.Aptos.AptosEntity;
import net.hazen.hazennstuff.entity.mobs.ReignOfTyros.Pyromus.PyromusEntity;
import net.hazen.hazennstuff.entity.mobs.wizards.Electromancer.ElectromancerEntity;
import net.hazen.hazennstuff.registries.HnSEntityRegistry;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.EntityAttributeCreationEvent;

@EventBusSubscriber(modid = HazenNStuff.MOD_ID, bus = EventBusSubscriber.Bus.MOD)
public class CommonSetup {

    @SubscribeEvent
    public static void onAttributeCreate(EntityAttributeCreationEvent event) {
        event.put(HnSEntityRegistry.ELECTROMANCER.get(), ElectromancerEntity.prepareAttributes().build());
        event.put(HnSEntityRegistry.APTOS.get(), AptosEntity.prepareAttributes().build());
        event.put(HnSEntityRegistry.PYROMUS.get(), PyromusEntity.prepareAttributes().build());
        event.put(HnSEntityRegistry.AEGIS.get(), AegisEntity.prepareAttributes().build());
    }
}

