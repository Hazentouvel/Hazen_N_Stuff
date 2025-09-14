package net.hazen.hazennstuff.registries;

import io.redspace.ironsspellbooks.api.spells.AbstractSpell;
import net.hazen.hazennstuff.HazenNStuff;
import net.hazen.hazennstuff.spells.shadow.NightsEdgeStrikeSpell;
import net.hazen.hazennstuff.spells.shadow.ChaoticTeleportSpell;
import net.hazen.hazennstuff.spells.fire.BrimstoneHellblastSpell;
import net.hazen.hazennstuff.spells.fire.CinderousStepSpell;
import net.hazen.hazennstuff.spells.ice.CrystalVolleySpell;
import net.hazen.hazennstuff.spells.ice.IceArrowSpell;
import net.hazen.hazennstuff.spells.lightning.EnergyBurstSpell;
import net.hazen.hazennstuff.spells.radiance.SyringeBarrageSpell;
import net.hazen.hazennstuff.spells.nature.ThornChakramSpell;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

import static io.redspace.ironsspellbooks.api.registry.SpellRegistry.SPELL_REGISTRY_KEY;

public class HnSSpellRegistries {
    public static final DeferredRegister<AbstractSpell> SPELLS = DeferredRegister.create(SPELL_REGISTRY_KEY, HazenNStuff.MOD_ID);

    public static Supplier<AbstractSpell> registerSpell(AbstractSpell spell) {
        return SPELLS.register(spell.getSpellName(), () -> spell);
    }

    /***
     * Ender
     */

    /***
     * Blood
     */


    /***
     * Fire
     */

    //Brimstone Hellblast
    public static final Supplier<AbstractSpell> BRIMSTONE_HELLBLAST = registerSpell(new BrimstoneHellblastSpell());

    //Cinderous Step
    public static final Supplier<AbstractSpell> CINDEROUS_STEP = registerSpell(new CinderousStepSpell());

    /*
    *** Ice
     */

    //Ice Arrow
    public static final Supplier<AbstractSpell> ICE_ARROW = registerSpell(new IceArrowSpell());

    //Crystal Volley
    public static final Supplier<AbstractSpell> CRYSTAL_VOLLEY = registerSpell(new CrystalVolleySpell());

    /***
     * Lightning
     */

    //Energy Burst
    public static final Supplier<AbstractSpell> ENERGY_BURST = registerSpell(new EnergyBurstSpell());


    /*
    *** Nature
     */

//Energy Burst
    public static final Supplier<AbstractSpell> THORN_CHAKRAM = registerSpell(new ThornChakramSpell());



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

    //Chaotic Teleport
    public static final Supplier<AbstractSpell> CHAOTIC_TELEPORT = registerSpell(new ChaoticTeleportSpell());


    public static void register(IEventBus eventBus)
    {
        SPELLS.register(eventBus);
    }
}