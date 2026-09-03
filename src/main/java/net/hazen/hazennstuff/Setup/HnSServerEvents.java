package net.hazen.hazennstuff.Setup;

import io.redspace.ironsspellbooks.api.config.ModifyDefaultConfigValuesEvent;
import io.redspace.ironsspellbooks.api.config.SpellConfigParameter;
import io.redspace.ironsspellbooks.api.events.CustomizeScrollModNameEvent;
import io.redspace.ironsspellbooks.spells.blood.WitherSkullSpell;
import io.redspace.ironsspellbooks.spells.ender.BlackHoleSpell;
import io.redspace.ironsspellbooks.spells.ender.StarfallSpell;
import net.hazen.hazennstuff.Entity.Mobs.Mobs.VoidWanderer.VoidWandererPatrolSpawner;
import net.hazen.hazennstuff.HazenNStuff;
import net.hazen.hazentouvelib.Registries.HLSchoolRegistry;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.level.Level;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.level.ModifyCustomSpawnersEvent;


@EventBusSubscriber
public class HnSServerEvents {

    @SubscribeEvent
    public static void registerPatrolSpawners(ModifyCustomSpawnersEvent event) {
        if (event.getLevel().dimension().equals(Level.END)) {
            event.addCustomSpawner(new VoidWandererPatrolSpawner());
        }
    }

}