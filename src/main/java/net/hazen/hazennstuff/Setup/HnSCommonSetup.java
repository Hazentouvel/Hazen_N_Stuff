package net.hazen.hazennstuff.Setup;

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
import net.hazen.hazennstuff.Registries.HnSEntityRegistry;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.EntityAttributeCreationEvent;

@EventBusSubscriber(value = Dist.CLIENT)
public class HnSCommonSetup {

    @SubscribeEvent
    public static void onAttributeCreate(EntityAttributeCreationEvent event) {
        event.put(HnSEntityRegistry.ELECTROMANCER.get(), ElectromancerEntity.prepareAttributes().build());
        event.put(HnSEntityRegistry.APTOS.get(), AptosEntity.prepareAttributes().build());
        event.put(HnSEntityRegistry.PYROMUS.get(), PyromusEntity.prepareAttributes().build());
        event.put(HnSEntityRegistry.AEGIS.get(), AegisEntity.prepareAttributes().build());
        event.put(HnSEntityRegistry.THE_RECLUSE.get(), TheRecluseEntity.prepareAttributes().build());
        event.put(HnSEntityRegistry.PIGLIN_PYROMANCER.get(), PiglinPyromancerEntity.prepareAttributes().build());
        event.put(HnSEntityRegistry.SERVANT_OF_ENDER.get(), ServantsOfEnderEntity.prepareAttributes().build());
        event.put(HnSEntityRegistry.BISHOP_OF_DECEIT.get(), BishopOfDeceitEntity.prepareAttributes().build());
        event.put(HnSEntityRegistry.DRYAD.get(), DryadEntity.prepareAttributes().build());
        event.put(HnSEntityRegistry.NAMELESS_ONE.get(), NamelessOneEntity.prepareAttributes().build());
        event.put(HnSEntityRegistry.NECROMANCER.get(), NecromancerEntity.prepareAttributes().build());
    }
}

