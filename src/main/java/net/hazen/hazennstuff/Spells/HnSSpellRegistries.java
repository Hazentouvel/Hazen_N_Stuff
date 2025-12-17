package net.hazen.hazennstuff.Spells;

import io.redspace.ironsspellbooks.api.spells.AbstractSpell;
import net.hazen.hazennstuff.HazenNStuff;
import net.hazen.hazennstuff.Spells.Schools.Eldritch.SoulSeekersSpell;
import net.hazen.hazennstuff.Spells.Schools.Evocation.ParrySpell;
import net.hazen.hazennstuff.Spells.Schools.Evocation.SpectralAxeSpell;
import net.hazen.hazennstuff.Spells.Schools.Fire.*;
import net.hazen.hazennstuff.Spells.Schools.Holy.GoldenShowerSpell;
import net.hazen.hazennstuff.Spells.Schools.Ice.CrystalVolleySpell;
import net.hazen.hazennstuff.Spells.Schools.Ice.IceArrowSpell;
import net.hazen.hazennstuff.Spells.Schools.Lightning.EnergyBurstSpell;
import net.hazen.hazennstuff.Spells.Schools.Lightning.IonicSlashSpell;
import net.hazen.hazennstuff.Spells.Schools.Nature.CounterspellSpiderLilySpell;
import net.hazen.hazennstuff.Spells.Schools.Nature.DeathSentenceSpell;
import net.hazen.hazennstuff.Spells.Schools.Nature.ShardSwordSpell;
import net.hazen.hazennstuff.Spells.Schools.Nature.ThornChakramSpell;
import net.hazen.hazennstuff.Spells.Schools.Radiance.*;
import net.hazen.hazennstuff.Spells.Shadow.ChaoticTeleportSpell;
import net.hazen.hazennstuff.Spells.Shadow.NightsEdgeStrikeSpell;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

import static io.redspace.ironsspellbooks.api.registry.SpellRegistry.SPELL_REGISTRY_KEY;

public class HnSSpellRegistries {
    public static final DeferredRegister<AbstractSpell> SPELLS = DeferredRegister.create(SPELL_REGISTRY_KEY, HazenNStuff.MOD_ID);

    public static Supplier<AbstractSpell> registerSpell(AbstractSpell spell) {
        return SPELLS.register(spell.getSpellName(), () -> spell);
    }

    /*
     *** Ender
     */

    /*
     *** Blood
     */


    /*
     *** Fire
     */

    //Brimstone Hellblast
    public static final Supplier<AbstractSpell> BRIMSTONE_HELLBLAST = registerSpell(new BrimstoneHellblastSpell());

    //Cinderous Step
    public static final Supplier<AbstractSpell> CINDEROUS_STEP = registerSpell(new CinderousStepSpell());

    //Scorching Slash
    public static final Supplier<AbstractSpell> SCORCHING_SLASH = registerSpell(new ScorchingSlashSpell());

    //Fiery Dagger
    public static final Supplier<AbstractSpell> FIERY_DAGGER = registerSpell(new FieryDaggerSpell());

    //Reign of Tyros
    public static final Supplier<AbstractSpell> REIGN_OF_TYROS = registerSpell(new ReignOfTyrosSpell());

    /*
    *** Ice
     */

    //Ice Arrow
    public static final Supplier<AbstractSpell> ICE_ARROW = registerSpell(new IceArrowSpell());

    //Crystal Volley
    public static final Supplier<AbstractSpell> CRYSTAL_VOLLEY = registerSpell(new CrystalVolleySpell());

    /*
     *** Lightning
     */

    //Energy Burst
    public static final Supplier<AbstractSpell> ENERGY_BURST = registerSpell(new EnergyBurstSpell());

    //Ionic Slash
    public static final Supplier<AbstractSpell> IONIC_SLASH = registerSpell(new IonicSlashSpell());


    /*
    *** Nature
     */

    //Thorn Chakram
    public static final Supplier<AbstractSpell> THORN_CHAKRAM = registerSpell(new ThornChakramSpell());

    //Counter Spell Spider Lily
    public static final Supplier<AbstractSpell> COUNTERSPELL_SPIDER_LILY = registerSpell(new CounterspellSpiderLilySpell());

    //Shard Sword
    public static final Supplier<AbstractSpell> SHARD_SWORD = registerSpell(new ShardSwordSpell());

    //Death Sentence
    public static final Supplier<AbstractSpell> DEATH_SENTENCE = registerSpell(new DeathSentenceSpell());


    /*
    *** Evocation
     */

    //Spectral Axe
    public static final Supplier<AbstractSpell> SPECTRAL_AXE = registerSpell(new SpectralAxeSpell());

    //Parry
    public static final Supplier<AbstractSpell> PARRY = registerSpell(new ParrySpell());

    /*
     *** Holy
     */

    // Golden Shower
    public static final Supplier<AbstractSpell> GOLDEN_SHOWER = registerSpell(new GoldenShowerSpell());

    /*
     *** Radiance
     */

    //Syringe Barrage
    public static final Supplier<AbstractSpell> SYRINGE_BARRAGE = registerSpell(new SyringeBarrageSpell());

    // Shooting Star
    public static final Supplier<AbstractSpell> SHOOTING_STAR = registerSpell(new ShootingStarSpell());

    // Falling Stars
    public static final Supplier<AbstractSpell> STELLAR_COLLAPSE = registerSpell(new StellarCollapseSpell());

    // Terraprisma
    public static final Supplier<AbstractSpell> TERRAPRISMIC_BARRAGE = registerSpell(new TerraprismicBarrageSpell());

    // Call Forth Terraprisma
    public static final Supplier<AbstractSpell> CALL_FORTH_TERRAPRISMA = registerSpell(new CallForthTerraprismaSpell());

    // Call Forth Terraprisma
    //public static final Supplier<AbstractSpell> CRYSTALINE_MIRROR = registerSpell(new CrystalineMirrorSpell());

    /*
     *** Dark
     */

    //Night's Edge Strike
    public static final Supplier<AbstractSpell> NIGHTS_EDGE_STRIKE = registerSpell(new NightsEdgeStrikeSpell());

    //Chaotic Teleport
    public static final Supplier<AbstractSpell> CHAOTIC_TELEPORT = registerSpell(new ChaoticTeleportSpell());


    /*
     *** Eldritch
     */

    // Soul Seekers
    public static final Supplier<AbstractSpell> SOUL_SEEKERS = registerSpell(new SoulSeekersSpell());



    public static void register(IEventBus eventBus)
    {
        SPELLS.register(eventBus);
    }
}