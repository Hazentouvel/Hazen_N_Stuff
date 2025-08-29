package net.hazen.hazennstuff.compat.MalumCompat;

import com.sammy.malum.registry.common.MalumAttributes;
import net.hazen.hazennstuff.HazenNStuff;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.core.*;
import net.minecraft.resources.*;
import net.minecraft.server.level.*;
import net.minecraft.world.damagesource.*;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.*;
import net.minecraft.world.entity.player.*;
import net.minecraft.world.item.*;
import net.minecraft.world.item.component.*;
import net.neoforged.fml.*;
import net.neoforged.neoforge.common.*;
import net.neoforged.neoforge.event.entity.living.*;


public class MalumCompat {

    public static boolean LOADED;

    public static void init() {
        LOADED = true;
    }
    public static void addArcaneResonance(ItemAttributeModifiers.Builder attributes, EquipmentSlotGroup group) {
        if (LOADED) {
            LoadedOnly.addArcaneResonance(attributes, group);
        }
    }

    public static class LoadedOnly {

        public static void addArcaneResonance(ItemAttributeModifiers.Builder attributes, EquipmentSlotGroup group) {
            attributes.add(MalumAttributes.ARCANE_RESONANCE,
                    new AttributeModifier(HazenNStuff.id("seraph_armor"), 1f, AttributeModifier.Operation.ADD_MULTIPLIED_BASE),
                    group);
        }
    }
}
