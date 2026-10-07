package net.hazen.hazennstuff.Spells;

import io.redspace.ironsspellbooks.api.registry.SpellRegistry;
import io.redspace.ironsspellbooks.api.spells.AbstractSpell;
import net.hazen.hazennstuff.Datagen.HnSTags;
import net.hazen.hazennstuff.HazenNStuff;
import net.hazen.hazennstuff.Spells.AbstractSpells.TyrosSpells;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

public final class ScrollTextureRegistry {

    private static final Map<ResourceLocation, ResourceLocation> SPELL_MODELS =
            new LinkedHashMap<>();

    private ScrollTextureRegistry() {
    }

    public static void register() {
        SPELL_MODELS.clear();


        /*
        *** Soul Flame
         */

        registerSpell(HnSSpellRegistries.SOUL_FLAMING_STRIKE.get(), "item/scroll_soul_flame");
        registerSpell(HnSSpellRegistries.SOUL_FLAME_BOLT.get(), "item/scroll_soul_flame");

        /*
        *** Tyros
         */
        registerSpell(HnSSpellRegistries.FIERY_DAGGER.get(), "item/scroll_tyros");
        //registerSpell(HnSSpellRegistries.REIGN_OF_TYROS.get(), "item/scroll_tyros");
        registerSpell(SpellRegistry.RAISE_HELL_SPELL.get(), "item/scroll_tyros");

    }

    private static void registerSpell(
            AbstractSpell spell,
            String modelPath
    ) {
        ResourceLocation spellId = spell.getSpellResource();

        ResourceLocation modelLocation =
                ResourceLocation.fromNamespaceAndPath(
                        HazenNStuff.MOD_ID,
                        modelPath
                );

        SPELL_MODELS.put(spellId, modelLocation);
    }



    public static ResourceLocation getModel(ResourceLocation spellId) {
        return SPELL_MODELS.get(spellId);
    }

    public static Map<ResourceLocation, ResourceLocation> getRegisteredModels() {
        return Collections.unmodifiableMap(SPELL_MODELS);
    }


}