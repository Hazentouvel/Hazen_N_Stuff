package net.hazen.hazennstuff.Setup;

import io.redspace.ironsspellbooks.api.config.ModifyDefaultConfigValuesEvent;
import io.redspace.ironsspellbooks.api.config.SpellConfigParameter;
import io.redspace.ironsspellbooks.api.events.CustomizeScrollModNameEvent;
import io.redspace.ironsspellbooks.spells.blood.WitherSkullSpell;
import io.redspace.ironsspellbooks.spells.ender.BlackHoleSpell;
import io.redspace.ironsspellbooks.spells.ender.StarfallSpell;
import net.hazen.hazennstuff.HazenNStuff;
import net.hazen.hazentouvelib.Registries.HLSchoolRegistry;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;


@EventBusSubscriber
public class HnSServerEvents {

    @SubscribeEvent
    public static void modifyModNameDisplay(CustomizeScrollModNameEvent event) {
        if (event.getModId().equals(HazenNStuff.MOD_ID)) {
            event.setModName(
                    Component.literal("\u2999 - Hazen 'n Stuff - \u2999")
                            .withStyle(ChatFormatting.GOLD)
                            .withStyle(ChatFormatting.BOLD)
            );
        }
    }

    /*
    *** Changing Spell Schools *****************************************************************************************
     */

    @SubscribeEvent
    public static void modifySpellSchool(ModifyDefaultConfigValuesEvent event) {
        if(event.getSpell() instanceof BlackHoleSpell) {
            event.setDefaultValue(SpellConfigParameter.SCHOOL, HLSchoolRegistry.COSMIC.get());
        }

        if(event.getSpell() instanceof StarfallSpell) {
            event.setDefaultValue(SpellConfigParameter.SCHOOL, HLSchoolRegistry.COSMIC.get());
        }

        if(event.getSpell() instanceof WitherSkullSpell) {
            event.setDefaultValue(SpellConfigParameter.SCHOOL, HLSchoolRegistry.SHADOW.get());
        }
    }
}