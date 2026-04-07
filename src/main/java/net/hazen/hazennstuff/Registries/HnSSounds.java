package net.hazen.hazennstuff.Registries;

import net.hazen.hazennstuff.HazenNStuff;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.common.util.DeferredSoundType;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class HnSSounds {
    public static final DeferredRegister<SoundEvent> SOUND_EVENTS =
            DeferredRegister.create(BuiltInRegistries.SOUND_EVENT, HazenNStuff.MOD_ID);


    /***
     * Entity
     */



    /*
     * Spell Sounds
     */

    // Terraria Cast
    public static DeferredHolder<SoundEvent, SoundEvent> TERRARIA_CAST = registerSoundEvent("terraria_cast");

    // Scorching Slash Wind Up
    public static DeferredHolder<SoundEvent, SoundEvent> SCORCHING_SLASH_WIND_UP = registerSoundEvent("scorching_slash_wind_up");
    // Scorching Slash Swing
    public static DeferredHolder<SoundEvent, SoundEvent> SCORCHING_SLASH_SWING = registerSoundEvent("scorching_slash_swing");

    // Brimstone Cast
    public static DeferredHolder<SoundEvent, SoundEvent> BRIMSTONE_CAST = registerSoundEvent("brimstone_cast");
    // Brimstone Hellblast Impact
    public static DeferredHolder<SoundEvent, SoundEvent> BRIMSTONE_HELLBLAST_IMPACT = registerSoundEvent("brimstone_hellblast_impact");
    // Brimstone Hellblast Cast
    public static DeferredHolder<SoundEvent, SoundEvent> BRIMSTONE_HELLBLAST_CAST = registerSoundEvent("brimstone_hellblast_cast");

    // Electric Cast
    public static DeferredHolder<SoundEvent, SoundEvent> ELECTRIC_CAST = registerSoundEvent("electric_cast");

    // Electric Impact
    public static DeferredHolder<SoundEvent, SoundEvent> ELECTRIC_IMPACT_1 = registerSoundEvent("electric_impact_1");
    public static DeferredHolder<SoundEvent, SoundEvent> ELECTRIC_IMPACT_2 = registerSoundEvent("electric_impact_2");

    public static final Holder<SoundEvent> ELECTRIC_IMPACT = registerSoundEvent("electric_impact");

    //Spark Cast
    public static final Holder<SoundEvent> SPARK_CAST_1 = registerSoundEvent("spark_cast_1");
    public static final Holder<SoundEvent> SPARK_CAST_2 = registerSoundEvent("spark_cast_2");
    public static final Holder<SoundEvent> SPARK_CAST_3 = registerSoundEvent("spark_cast_3");

    public static final Holder<SoundEvent> SPARK_CAST = registerSoundEvent("spark_cast");

    public static final DeferredHolder<SoundEvent, SoundEvent> VIOLENT_REGURGITATION_CHARGING = registerSoundEvent("violent_regurgitation_charging");
    public static final DeferredHolder<SoundEvent, SoundEvent> VIOLENT_REGURGITATION_CAST = registerSoundEvent("violent_regurgitation_cast");

    public static final DeferredHolder<SoundEvent, SoundEvent> FLESH_IMPACT = registerSoundEvent("flesh_impact");
    public static final DeferredHolder<SoundEvent, SoundEvent> FLESH_MOUND_BITE = registerSoundEvent("flesh_mound_bite");


    public static final DeferredHolder<SoundEvent, SoundEvent> ENDRACONIC_METEOR_CHARGING = registerSoundEvent("endraconic_meteor_charging");
    public static final DeferredHolder<SoundEvent, SoundEvent> ENDRACONIC_METEOR_CAST = registerSoundEvent("endraconic_meteor_cast");
    public static final DeferredHolder<SoundEvent, SoundEvent> ENDRACONIC_METEOR_IMPACT = registerSoundEvent("endraconic_meteor_impact");

    // Charged
    public static DeferredHolder<SoundEvent, SoundEvent> CHARGED = registerSoundEvent("charged");

    //Spark Cast
    public static final Holder<SoundEvent> NINGU_DEMONBANE_PETALBLADE_CAST_1 = registerSoundEvent("ningu_demonbane_petalblade_cast_1");
    public static final Holder<SoundEvent> NINGU_DEMONBANE_PETALBLADE_CAST_2 = registerSoundEvent("ningu_demonbane_petalblade_cast_2");
    public static final Holder<SoundEvent> NINGU_DEMONBANE_PETALBLADE_CAST_3 = registerSoundEvent("ningu_demonbane_petalblade_cast_3");

    // Syringe Barrage Cast
    public static DeferredHolder<SoundEvent, SoundEvent> SYRINGE_BARRAGE_CAST = registerSoundEvent("syringe_barrage_cast");

    //Syringe Barrage Hit
    public static final Holder<SoundEvent> SYRINGE_BARRAGE_HIT_1 = registerSoundEvent("syringe_barrage_hit_1");
    public static final Holder<SoundEvent> SYRINGE_BARRAGE_HIT_2 = registerSoundEvent("syringe_barrage_hit_2");
    public static final Holder<SoundEvent> SYRINGE_BARRAGE_HIT_3 = registerSoundEvent("syringe_barrage_hit_3");

    public static final Holder<SoundEvent> SYRINGE_BARRAGE_HIT = registerSoundEvent("syringe_barrage_hit");

    // Syringe Barrage Miss
    public static DeferredHolder<SoundEvent, SoundEvent> SYRINGE_BARRAGE_MISS = registerSoundEvent("syringe_barrage_miss");

    // Vampire Knife Throw
    public static DeferredHolder<SoundEvent, SoundEvent> VAMPIRE_KNIFE_THROW = registerSoundEvent("vampire_knife_throw");

    public static DeferredHolder<SoundEvent, SoundEvent> VAMPIRE_KNIFE_HIT = registerSoundEvent("vampire_knife_hit");

    // Vampire Knife Throw
    public static DeferredHolder<SoundEvent, SoundEvent> GOLDEN_SHOWER_CAST = registerSoundEvent("golden_shower_cast");

    /*
     ***Terraprisma Sounds
     */

    // Cast
    public static DeferredHolder<SoundEvent, SoundEvent> TERRAPRISMA_CASTING = registerSoundEvent("terraprisma_casting");
    public static DeferredHolder<SoundEvent, SoundEvent> TERRAPRISMA_SUMMON = registerSoundEvent("terraprisma_summon");
    public static DeferredHolder<SoundEvent, SoundEvent> TERRARIA_SUMMON = registerSoundEvent("terraria_summon");

    /*
    *** Umbrashift Barrage Sounds
     */

    //Spark Cast
    public static final Holder<SoundEvent> SHADOW_DAGGER_HIT_1 = registerSoundEvent("shadow_dagger_hit_1");
    public static final Holder<SoundEvent> SHADOW_DAGGER_HIT_2 = registerSoundEvent("shadow_dagger_hit_2");
    public static final Holder<SoundEvent> SHADOW_DAGGER_HIT_3 = registerSoundEvent("shadow_dagger_hit_3");

    public static final Holder<SoundEvent> SHADOW_DAGGER_HIT = registerSoundEvent("shadow_dagger_hit");

    public static DeferredHolder<SoundEvent, SoundEvent> UMBRASHIFT_BARRAGE = registerSoundEvent("umbrashift_barrage_cast");

    /*
    *** Cosmic Sounds
     */

    // Cosmic Casting
    public static DeferredHolder<SoundEvent, SoundEvent> COSMIC_CAST_INSTANT = registerSoundEvent("cosmic_cast_instant");
    public static DeferredHolder<SoundEvent, SoundEvent> COSMIC_CAST_LONG = registerSoundEvent("cosmic_cast_long");

    // Evercomet Spell
    public static DeferredHolder<SoundEvent, SoundEvent> EVERCOMET_CAST = registerSoundEvent("evercomet_cast");
    public static DeferredHolder<SoundEvent, SoundEvent> EVERCOMET_IMPACT = registerSoundEvent("evercomet_impact");

    // Cosmic Bolt Spell
    public static DeferredHolder<SoundEvent, SoundEvent> COSMIC_BOLT_HIT = registerSoundEvent("cosmic_bolt_hit");
    public static DeferredHolder<SoundEvent, SoundEvent> COSMIC_BOLT_OKAY = registerSoundEvent("cosmic_bolt_okay");
    public static DeferredHolder<SoundEvent, SoundEvent> COSMIC_BOLT_GOOD = registerSoundEvent("cosmic_bolt_good");
    public static DeferredHolder<SoundEvent, SoundEvent> COSMIC_BOLT_EXCELLENT = registerSoundEvent("cosmic_bolt_excellent");

    //Star Cast
    public static DeferredHolder<SoundEvent, SoundEvent> STAR_CAST_1 = registerSoundEvent("star_cast_1");
    public static DeferredHolder<SoundEvent, SoundEvent> STAR_CAST_2 = registerSoundEvent("star_cast_2");

    // Hydro cast
    public static DeferredHolder<SoundEvent, SoundEvent> HYDRO_CAST_1 = registerSoundEvent("hydro_cast_1");
    public static DeferredHolder<SoundEvent, SoundEvent> HYDRO_CAST_2 = registerSoundEvent("hydro_cast_2");

    public static DeferredHolder<SoundEvent, SoundEvent> TRIDENT_JETSTREAM_CAST = registerSoundEvent("trident_jetstream_cast");
    public static DeferredHolder<SoundEvent, SoundEvent> RAZORBLADE_TYPHOON_CAST = registerSoundEvent("razorblade_typhoon_cast");

    public static DeferredHolder<SoundEvent, SoundEvent> ARCANE_CARD_CAST = registerSoundEvent("arcane_card_cast");

    /*
    *** Melee Sounds
     */

    //Terrablade Slash
    public static DeferredHolder<SoundEvent, SoundEvent> TERRABLADE_SLASH = registerSoundEvent("terrablade_slash");


    //Terraria Sword Sounds
    public static DeferredHolder<SoundEvent, SoundEvent> TERRARIA_SWING = registerSoundEvent("terraria_swing");
    public static DeferredHolder<SoundEvent, SoundEvent> TERRARIA_IMPACT = registerSoundEvent("terraria_impact");

    //Cat Sounds
    public static DeferredHolder<SoundEvent, SoundEvent> CAT_SWING = registerSoundEvent("cat_swing");
    public static DeferredHolder<SoundEvent, SoundEvent> CAT_CAST = registerSoundEvent("cat_cast");
    public static DeferredHolder<SoundEvent, SoundEvent> CAT_IMPACT = registerSoundEvent("cat_impact");

    //Parry
    public static DeferredHolder<SoundEvent, SoundEvent> PARRY = registerSoundEvent("parry");
    public static DeferredHolder<SoundEvent, SoundEvent> PUNCH = registerSoundEvent("punch");

    /***
     * Equip Sounds
     */



    //Soul Flame Equip
    public static final Holder<SoundEvent> SOUL_FLAME_EQUIP_1 = registerSoundEvent("soul_flame_equip_1");
    public static final Holder<SoundEvent> SOUL_FLAME_EQUIP_2 = registerSoundEvent("soul_flame_equip_2");
    public static final Holder<SoundEvent> SOUL_FLAME_EQUIP_3 = registerSoundEvent("soul_flame_equip_3");
    public static final Holder<SoundEvent> SOUL_FLAME_EQUIP_4 = registerSoundEvent("soul_flame_equip_4");

    public static final Holder<SoundEvent> SOUL_FLAME_EQUIP = registerSoundEvent("soul_flame_equip");

    //Supreme Witch Equip

    public static final Holder<SoundEvent> SUPREME_WITCH_EQUIP_1 = registerSoundEvent("supreme_witch_equip_1");
    public static final Holder<SoundEvent> SUPREME_WITCH_EQUIP_2 = registerSoundEvent("supreme_witch_equip_2");
    public static final Holder<SoundEvent> SUPREME_WITCH_EQUIP_3 = registerSoundEvent("supreme_witch_equip_3");
    public static final Holder<SoundEvent> SUPREME_WITCH_EQUIP_4 = registerSoundEvent("supreme_witch_equip_4");

    public static final Holder<SoundEvent> SUPREME_WITCH_EQUIP = registerSoundEvent("supreme_witch_equip");

    //Seraph Equip

    public static final Holder<SoundEvent> SERAPH_EQUIP_1 = registerSoundEvent("seraph_equip_1");
    public static final Holder<SoundEvent> SERAPH_EQUIP_2 = registerSoundEvent("seraph_equip_2");
    public static final Holder<SoundEvent> SERAPH_EQUIP_3 = registerSoundEvent("seraph_equip_3");
    public static final Holder<SoundEvent> SERAPH_EQUIP_4 = registerSoundEvent("seraph_equip_4");

    public static final Holder<SoundEvent> SERAPH_EQUIP = registerSoundEvent("seraph_equip");

    //Charged Scourge Equip

    public static final Holder<SoundEvent> CHARGED_SCOURGE_EQUIP_1 = registerSoundEvent("charged_scourge_equip_1");
    public static final Holder<SoundEvent> CHARGED_SCOURGE_EQUIP_2 = registerSoundEvent("charged_scourge_equip_2");
    public static final Holder<SoundEvent> CHARGED_SCOURGE_EQUIP_3 = registerSoundEvent("charged_scourge_equip_3");
    public static final Holder<SoundEvent> CHARGED_SCOURGE_EQUIP_4 = registerSoundEvent("charged_scourge_equip_4");

    public static final Holder<SoundEvent> CHARGED_SCOURGE_EQUIP = registerSoundEvent("charged_scourge_equip");

    //Creaking Sorcerer Equip

    public static final Holder<SoundEvent> CREAKING_SORCERER_EQUIP_1 = registerSoundEvent("creaking_sorcerer_equip_1");
    public static final Holder<SoundEvent> CREAKING_SORCERER_EQUIP_2 = registerSoundEvent("creaking_sorcerer_equip_2");
    public static final Holder<SoundEvent> CREAKING_SORCERER_EQUIP_3 = registerSoundEvent("creaking_sorcerer_equip_3");
    public static final Holder<SoundEvent> CREAKING_SORCERER_EQUIP_4 = registerSoundEvent("creaking_sorcerer_equip_4");

    public static final Holder<SoundEvent> CREAKING_SORCERER_EQUIP = registerSoundEvent("creaking_sorcerer_equip");

    //Flesh Mass Equip

    public static final Holder<SoundEvent> FLESH_MASS_EQUIP_1 = registerSoundEvent("flesh_mass_equip_1");
    public static final Holder<SoundEvent> FLESH_MASS_EQUIP_2 = registerSoundEvent("flesh_mass_equip_2");
    public static final Holder<SoundEvent> FLESH_MASS_EQUIP_3 = registerSoundEvent("flesh_mass_equip_3");
    public static final Holder<SoundEvent> FLESH_MASS_EQUIP_4 = registerSoundEvent("flesh_mass_equip_4");
    public static final Holder<SoundEvent> FLESH_MASS_EQUIP_5 = registerSoundEvent("flesh_mass_equip_5");
    public static final Holder<SoundEvent> FLESH_MASS_EQUIP_6 = registerSoundEvent("flesh_mass_equip_6");
    public static final Holder<SoundEvent> FLESH_MASS_EQUIP_7 = registerSoundEvent("flesh_mass_equip_7");

    public static final Holder<SoundEvent> FLESH_MASS_EQUIP = registerSoundEvent("flesh_mass_equip");

    //Cryogenic Ruler Equip

    public static final Holder<SoundEvent> CRYOGENIC_RULER_EQUIP_1 = registerSoundEvent("cryogenic_ruler_equip_1");
    public static final Holder<SoundEvent> CRYOGENIC_RULER_EQUIP_2 = registerSoundEvent("cryogenic_ruler_equip_2");
    public static final Holder<SoundEvent> CRYOGENIC_RULER_EQUIP_3 = registerSoundEvent("cryogenic_ruler_equip_3");
    public static final Holder<SoundEvent> CRYOGENIC_RULER_EQUIP_4 = registerSoundEvent("cryogenic_ruler_equip_4");

    public static final Holder<SoundEvent> CRYOGENIC_RULER_EQUIP = registerSoundEvent("cryogenic_ruler_equip");


    //Ender Dragon Equip

    public static final Holder<SoundEvent> ENDER_DRAGON_EQUIP_1 = registerSoundEvent("ender_dragon_equip_1");
    public static final Holder<SoundEvent> ENDER_DRAGON_EQUIP_2 = registerSoundEvent("ender_dragon_equip_2");
    public static final Holder<SoundEvent> ENDER_DRAGON_EQUIP_3 = registerSoundEvent("ender_dragon_equip_3");
    public static final Holder<SoundEvent> ENDER_DRAGON_EQUIP_4 = registerSoundEvent("ender_dragon_equip_4");

    public static final Holder<SoundEvent> ENDER_DRAGON_EQUIP = registerSoundEvent("ender_dragon_equip");

    //Calamitas
    public static final Holder<SoundEvent> CALAMITAS_EQUIP_1 = registerSoundEvent("calamitas_equip_1");
    public static final Holder<SoundEvent> CALAMITAS_EQUIP_2 = registerSoundEvent("calamitas_equip_2");
    public static final Holder<SoundEvent> CALAMITAS_EQUIP_3 = registerSoundEvent("calamitas_equip_3");
    public static final Holder<SoundEvent> CALAMITAS_EQUIP_4 = registerSoundEvent("calamitas_equip_4");

    public static final Holder<SoundEvent> CALAMITAS_EQUIP = registerSoundEvent("calamitas_equip");


    /***
     * Block Sounds
     */

    //Special Ore
    public static final Supplier<SoundEvent> SPECIAL_ORE_BREAK = registerSoundEvent("special_ore_break");
    public static final Supplier<SoundEvent> SPECIAL_ORE_STEP = registerSoundEvent("special_ore_step");
    public static final Supplier<SoundEvent> SPECIAL_ORE_PLACE = registerSoundEvent("special_ore_place");
    public static final Supplier<SoundEvent> SPECIAL_ORE_HIT = registerSoundEvent("special_ore_hit");
    public static final Supplier<SoundEvent> SPECIAL_ORE_FALL = registerSoundEvent("special_ore_fall");

    public static final DeferredSoundType SPECIAL_ORE = new DeferredSoundType(1f, 1f,
            HnSSounds.SPECIAL_ORE_BREAK, HnSSounds.SPECIAL_ORE_STEP, HnSSounds.SPECIAL_ORE_PLACE,
            HnSSounds.SPECIAL_ORE_HIT, HnSSounds.SPECIAL_ORE_FALL);



    private static DeferredHolder<SoundEvent, SoundEvent> registerSoundEvent(String name)
    {
        return SOUND_EVENTS.register(name, () -> SoundEvent.createVariableRangeEvent
                (ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, name)));
    }


    public static void register(IEventBus eventBus) {
        SOUND_EVENTS.register(eventBus);
    }
}
