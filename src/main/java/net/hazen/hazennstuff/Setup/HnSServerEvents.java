package net.hazen.hazennstuff.Setup;

import io.redspace.ironsspellbooks.api.config.ModifyDefaultConfigValuesEvent;
import io.redspace.ironsspellbooks.api.config.SpellConfigParameter;
import io.redspace.ironsspellbooks.spells.blood.WitherSkullSpell;
import io.redspace.ironsspellbooks.spells.ender.BlackHoleSpell;
import io.redspace.ironsspellbooks.spells.ender.StarfallSpell;
import net.hazen.hazentouvelib.Registries.HLSchoolRegistry;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;


@EventBusSubscriber
public class HnSServerEvents {

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