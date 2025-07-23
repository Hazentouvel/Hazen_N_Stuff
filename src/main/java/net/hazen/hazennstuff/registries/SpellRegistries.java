package net.hazen.hazennstuff.registries;

import io.redspace.ironsspellbooks.api.spells.AbstractSpell;
import net.hazen.hazennstuff.HazenNStuff;
import net.hazen.hazennstuff.spells.dark.NightsEdgeStrikeSpell;
import net.hazen.hazennstuff.spells.ender.ChaoticTeleportSpell;
import net.hazen.hazennstuff.spells.fire.BrimstoneHellblastSpell;
import net.hazen.hazennstuff.spells.lightning.SparkSpell;
import net.hazen.hazennstuff.spells.luminescent.SyringeBarrageSpell;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

import static io.redspace.ironsspellbooks.api.registry.SpellRegistry.SPELL_REGISTRY_KEY;

public class SpellRegistries {
    public static final DeferredRegister<AbstractSpell> SPELLS = DeferredRegister.create(SPELL_REGISTRY_KEY, HazenNStuff.MOD_ID);

    public static Supplier<AbstractSpell> registerSpell(AbstractSpell spell) {
        return SPELLS.register(spell.getSpellName(), () -> spell);
    }

    /***
     * Ender
     */

  //Chaotic Teleport
    public static final Supplier<AbstractSpell> CHAOTIC_TELEPORT = registerSpell(new ChaoticTeleportSpell());

    /***
     * Blood
     */


    /***
     * Fire
     */

    //Brimstone Hellblast
    public static final Supplier<AbstractSpell> BRIMSTONE_HELLBLAST = registerSpell(new BrimstoneHellblastSpell());

    /***
     * Lightning
     */

    //Brimstone Hellblast
    public static final Supplier<AbstractSpell> SPARK = registerSpell(new SparkSpell());

    /***
     * Luminescent
     */

    //Syringe Barrage
    public static final Supplier<AbstractSpell> SYRINGE_BARRAGE = registerSpell(new SyringeBarrageSpell());

    /***
     * Dark
     */

    //Night's Edge Strike
    public static final Supplier<AbstractSpell> NIGHTS_EDGE_STRIKE = registerSpell(new NightsEdgeStrikeSpell());


    public static void register(IEventBus eventBus)
    {
        SPELLS.register(eventBus);
    }
}