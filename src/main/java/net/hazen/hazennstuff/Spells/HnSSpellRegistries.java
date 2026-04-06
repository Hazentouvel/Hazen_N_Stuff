package net.hazen.hazennstuff.Spells;

import io.redspace.ironsspellbooks.api.spells.AbstractSpell;
import net.hazen.hazennstuff.HazenNStuff;
import net.hazen.hazennstuff.Spells.Schools.Cosmic.CosmicBoltSpell;
import net.hazen.hazennstuff.Spells.Schools.Cosmic.EvercometBarrageSpell;
import net.hazen.hazennstuff.Spells.Schools.Cosmic.MoonkissedSpell;
import net.hazen.hazennstuff.Spells.Schools.Cosmic.ShootingStarSpell;
import net.hazen.hazennstuff.Spells.Schools.Eldritch.SoulSeekersSpell;
import net.hazen.hazennstuff.Spells.Schools.Ender.EndraconicMeteorSpell;
import net.hazen.hazennstuff.Spells.Schools.Evocation.ParrySpell;
import net.hazen.hazennstuff.Spells.Schools.Evocation.SpectralAxeSpell;
import net.hazen.hazennstuff.Spells.Schools.Fire.*;
import net.hazen.hazennstuff.Spells.Schools.Holy.GoldenShowerSpell;
import net.hazen.hazennstuff.Spells.Schools.Hydro.*;
import net.hazen.hazennstuff.Spells.Schools.Ice.HailstormSpell;
import net.hazen.hazennstuff.Spells.Schools.Ice.IceArrowSpell;
import net.hazen.hazennstuff.Spells.Schools.Lightning.EnergyBurstSpell;
import net.hazen.hazennstuff.Spells.Schools.Lightning.IonicSlashSpell;
import net.hazen.hazennstuff.Spells.Schools.Lightning.DazzlingObliterationSpell;
import net.hazen.hazennstuff.Spells.Schools.Nature.CounterspellSpiderLilySpell;
import net.hazen.hazennstuff.Spells.Schools.Nature.DeathSentenceSpell;
import net.hazen.hazennstuff.Spells.Schools.Nature.ShardSwordSpell;
import net.hazen.hazennstuff.Spells.Schools.Nature.ThornChakramSpell;
import net.hazen.hazennstuff.Spells.Schools.Radiance.*;
import net.hazen.hazennstuff.Spells.Schools.Radiance.PrismaticShiftSpell;
import net.hazen.hazennstuff.Spells.Schools.Shadow.ArcaneCardsSpell;
import net.hazen.hazennstuff.Spells.Schools.Shadow.NightsEdgeStrikeSpell;
import net.hazen.hazennstuff.Spells.Schools.Shadow.ShadowReaverSpell;
import net.hazen.hazennstuff.Spells.Schools.Shadow.UmbrashiftBarrageSpell;
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

    //Ice Arrow
    public static final Supplier<AbstractSpell> ENDRACONIC_METEOR = registerSpell(new EndraconicMeteorSpell());

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
    //public static final Supplier<AbstractSpell> REIGN_OF_TYROS = registerSpell(new ReignOfTyrosSpell());

    /*
    *** Ice
     */

    //Ice Arrow
    public static final Supplier<AbstractSpell> ICE_ARROW = registerSpell(new IceArrowSpell());

    //Crystal Volley
    public static final Supplier<AbstractSpell> HAILSTORM = registerSpell(new HailstormSpell());

    /*
     *** Lightning
     */

    //Energy Burst
    public static final Supplier<AbstractSpell> ENERGY_BURST = registerSpell(new EnergyBurstSpell());

    //Ionic Slash
    public static final Supplier<AbstractSpell> IONIC_SLASH = registerSpell(new IonicSlashSpell());

    //Dazzling Obliteration
    public static final Supplier<AbstractSpell> DAZZLING_OBLITERATION = registerSpell(new DazzlingObliterationSpell());


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

    // Terraprisma
    public static final Supplier<AbstractSpell> TERRAPRISMIC_BARRAGE = registerSpell(new TerraprismicBarrageSpell());

    // Call Forth Terraprisma
    public static final Supplier<AbstractSpell> CALL_FORTH_TERRAPRISMA = registerSpell(new CallForthTerraprismaSpell());

    //Prismatic Shift
    public static final Supplier<AbstractSpell> PRISMATIC_SHIFT = registerSpell(new PrismaticShiftSpell());

    /*
     *** Shadow
     */

    //Night's Edge Strike
    public static final Supplier<AbstractSpell> NIGHTS_EDGE_STRIKE = registerSpell(new NightsEdgeStrikeSpell());

    //Umbrashift Barrage
    public static final Supplier<AbstractSpell> UMBRASHIFT_BARRAGE = registerSpell(new UmbrashiftBarrageSpell());

    //Umbrashift Barrage
    public static final Supplier<AbstractSpell> SHADOW_REAVER = registerSpell(new ShadowReaverSpell());

    //Arcane Cards
    public static final Supplier<AbstractSpell> ARCANE_CARDS = registerSpell(new ArcaneCardsSpell());


    /*
     *** Eldritch
     */

    // Soul Seekers
    public static final Supplier<AbstractSpell> SOUL_SEEKERS = registerSpell(new SoulSeekersSpell());

    /*
    *** Cosmic
     */

    // Shooting Star
    public static final Supplier<AbstractSpell> SHOOTING_STAR = registerSpell(new ShootingStarSpell());

    // Cosmic Bolt
    public static final Supplier<AbstractSpell> COSMIC_BOLT = registerSpell(new CosmicBoltSpell());

    // Evercomet Barrage
    public static final Supplier<AbstractSpell> EVERCOMET_BARRAGE = registerSpell(new EvercometBarrageSpell());

    // Moonkissed
    public static final Supplier<AbstractSpell> MOONKISSED = registerSpell(new MoonkissedSpell());

    /*
    *** Hydro
     */

    // CosmicBolt
    public static final Supplier<AbstractSpell> HYDROBULLET = registerSpell(new HydrobulletSpell());

    // Water Bolt
    public static final Supplier<AbstractSpell> WATER_BOLT = registerSpell(new WaterBoltSpell());

    // Razorblade Typhoon
    public static final Supplier<AbstractSpell> RAZORBLADE_TYPHOON = registerSpell(new RazorbladeTyphoonSpell());

    // Trident Jetstream
    public static final Supplier<AbstractSpell> TRIDENT_JETSTREAM = registerSpell(new TridentJetstreamSpell());

    // Horn Shell
    public static final Supplier<AbstractSpell> HORN_SHELL = registerSpell(new HornShellSpell());



    public static void register(IEventBus eventBus)
    {
        SPELLS.register(eventBus);
    }

}