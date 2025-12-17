package net.hazen.hazennstuff.Registries;

import dev.shadowsoffire.apothic_attributes.api.ALObjects;
import io.redspace.ironsspellbooks.api.registry.AttributeRegistry;
import net.acetheeldritchking.aces_spell_utils.registries.ASAttributeRegistry;
import net.hazen.hazennstuff.HazenNStuff;
import net.hazen.hazennstuff.Registries.Effects.*;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class HnSEffects {
    public static final DeferredRegister<MobEffect> MOB_EFFECTS =
            DeferredRegister.create(BuiltInRegistries.MOB_EFFECT, HazenNStuff.MOD_ID);



    public static final Holder<MobEffect> TYRANTS_GRACE_EFFECT = MOB_EFFECTS.register("tyrants_grace",
            () -> new GenericHazenEffect(MobEffectCategory.BENEFICIAL, 0xfbb741)
                    .addAttributeModifier(Attributes.ATTACK_DAMAGE,
                            ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "tyrants_grace"), 1.0f,
                            AttributeModifier.Operation.ADD_VALUE)
                    .addAttributeModifier(AttributeRegistry.CASTING_MOVESPEED,
                            ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "tyrants_grace"), 0.2f,
                            AttributeModifier.Operation.ADD_MULTIPLIED_BASE)
                    .addAttributeModifier(AttributeRegistry.FIRE_SPELL_POWER,
                            ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "tyrants_grace"), 0.12f,
                            AttributeModifier.Operation.ADD_MULTIPLIED_BASE)
                    .addAttributeModifier(Attributes.ATTACK_SPEED,
                            ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "tyrants_grace"), 1.0f,
                            AttributeModifier.Operation.ADD_VALUE)
                    .addAttributeModifier(ALObjects.Attributes.ARROW_DAMAGE,
                            ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "tyrants_grace"), 1.0f,
                            AttributeModifier.Operation.ADD_MULTIPLIED_BASE)
    );

    public static final Holder<MobEffect> FIREBLOSSOM_RULER_EFFECT = MOB_EFFECTS.register("fireblossom_ruler",
            () -> new GenericHazenEffect(MobEffectCategory.BENEFICIAL, 0xfbb741)
                    .addAttributeModifier(AttributeRegistry.CASTING_MOVESPEED,
                            ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "fireblossom_ruler"), 0.15f,
                            AttributeModifier.Operation.ADD_MULTIPLIED_BASE)
                    .addAttributeModifier(AttributeRegistry.SPELL_RESIST,
                            ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "fireblossom_ruler"), 0.1f,
                            AttributeModifier.Operation.ADD_MULTIPLIED_BASE));

    public static final Holder<MobEffect> FIREBLOSSOM_WARRIOR_EFFECT = MOB_EFFECTS.register("fireblossom_warrior",
            () -> new GenericHazenEffect(MobEffectCategory.BENEFICIAL, 0xfbb741)
                    .addAttributeModifier(Attributes.ARMOR,
                            ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "fireblossom_warrior"), 2f,
                            AttributeModifier.Operation.ADD_MULTIPLIED_BASE)
                    .addAttributeModifier(Attributes.ARMOR_TOUGHNESS,
                            ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "fireblossom_warrior"), 2f,
                            AttributeModifier.Operation.ADD_MULTIPLIED_BASE)
                    .addAttributeModifier(ALObjects.Attributes.PROT_SHRED,
                            ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "fireblossom_warrior"), 0.15f,
                            AttributeModifier.Operation.ADD_MULTIPLIED_BASE));

    public static final Holder<MobEffect> MAGE_SET_BONUS = MOB_EFFECTS.register("mage_set_bonus",
            () -> new GenericHazenEffect(MobEffectCategory.BENEFICIAL, 0xfbb741)
                    .addAttributeModifier(AttributeRegistry.CASTING_MOVESPEED,
                            ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "mage_set_bonus"), 0.15f,
                            AttributeModifier.Operation.ADD_MULTIPLIED_BASE)
                    .addAttributeModifier(AttributeRegistry.SPELL_RESIST,
                            ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "mage_set_bonus"), 0.1f,
                            AttributeModifier.Operation.ADD_MULTIPLIED_BASE)
    );

    public static final Holder<MobEffect> SWORDMASTER_SET_BONUS = MOB_EFFECTS.register("swordmaster_set_bonus",
            () -> new GenericHazenEffect(MobEffectCategory.BENEFICIAL, 0xfbb741)
                    .addAttributeModifier(Attributes.ATTACK_SPEED,
                            ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "swordmaster_set_bonus"), 0.15f,
                            AttributeModifier.Operation.ADD_MULTIPLIED_BASE)
                    .addAttributeModifier(ALObjects.Attributes.PROT_SHRED,
                            ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "swordmaster_set_bonus"), 0.1f,
                            AttributeModifier.Operation.ADD_MULTIPLIED_BASE)
    );

    public static final Holder<MobEffect> ARCHER_SET_BONUS = MOB_EFFECTS.register("archer_set_bonus",
            () -> new GenericHazenEffect(MobEffectCategory.BENEFICIAL, 0xfbb741)
                    .addAttributeModifier(Attributes.MOVEMENT_SPEED,
                            ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "archer_set_bonus"), 0.15f,
                            AttributeModifier.Operation.ADD_MULTIPLIED_BASE)
                    .addAttributeModifier(ALObjects.Attributes.ARROW_DAMAGE,
                            ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "archer_set_bonus"), 0.1f,
                            AttributeModifier.Operation.ADD_MULTIPLIED_BASE)
                    .addAttributeModifier(ALObjects.Attributes.ARROW_VELOCITY,
                            ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "archer_set_bonus"), 0.1f,
                            AttributeModifier.Operation.ADD_MULTIPLIED_BASE)
    );

    public static final Holder<MobEffect> SUMMONER_SET_BONUS = MOB_EFFECTS.register("summoner_set_bonus",
            () -> new GenericHazenEffect(MobEffectCategory.BENEFICIAL, 0xfbb741)
                    .addAttributeModifier(AttributeRegistry.SUMMON_DAMAGE,
                            ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "summoner_set_bonus"), 0.15f,
                            AttributeModifier.Operation.ADD_MULTIPLIED_BASE)
                    .addAttributeModifier(ASAttributeRegistry.MANA_STEAL,
                            ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "summoner_set_bonus"), 0.1f,
                            AttributeModifier.Operation.ADD_MULTIPLIED_BASE)
    );

    public static final DeferredHolder<MobEffect, MobEffect> FLAME_KISSED = MOB_EFFECTS.register("flame_kissed", () -> new FlameKissedEffect(MobEffectCategory.BENEFICIAL, 3311322)
            .addAttributeModifier(AttributeRegistry.FIRE_SPELL_POWER,
                    HazenNStuff.id("flame_kissed"),
                    FlameKissedEffect.FIRE_SPELL_POWER_PER_LEVEL,
                    AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL)

            .addAttributeModifier(ALObjects.Attributes.FIRE_DAMAGE,
                    HazenNStuff.id("flame_kissed"),
                    FlameKissedEffect.FIRE_DAMAGE_PER_LEVEL,
                    AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL)
    );

    public static final DeferredHolder<MobEffect, MobEffect> ICHOR = MOB_EFFECTS.register("ichor", () -> new IchorEffect(MobEffectCategory.HARMFUL, 3311322)
            .addAttributeModifier(Attributes.ARMOR,
                    HazenNStuff.id("ichor"),
                    IchorEffect.DEFENSE_LOWERED_PER_LEVEL,
                    AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL)

            .addAttributeModifier(AttributeRegistry.SPELL_RESIST,
                    HazenNStuff.id("ichor"),
                    IchorEffect.SPELL_VULNERABILITY_PER_LEVEL,
                    AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL)

            .addAttributeModifier(Attributes.ARMOR_TOUGHNESS,
                    HazenNStuff.id("ichor"),
                    IchorEffect.REDUCED_TOUGHNESS_PER_LEVEL,
                    AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL)
    );

    public static final DeferredHolder<MobEffect, MobEffect> DRYADS_BLESSING = MOB_EFFECTS.register("dryads_blessing", () -> new DryadsBlessingEffect(MobEffectCategory.BENEFICIAL, 3311322)
            .addAttributeModifier(Attributes.ARMOR,
                    HazenNStuff.id("dryads_blessing"),
                    DryadsBlessingEffect.ARMOR_PER_LEVEL,
                    AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL)

            .addAttributeModifier(ALObjects.Attributes.OVERHEAL,
                    HazenNStuff.id("dryads_blessing"),
                    DryadsBlessingEffect.OVERHEAL_PER_LEVEL,
                    AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL)

            .addAttributeModifier(ALObjects.Attributes.HEALING_RECEIVED,
                    HazenNStuff.id("dryads_blessing"),
                    DryadsBlessingEffect.HEALING_RECIEVED_PER_LEVEL,
                    AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL)
    );

    public static final Holder<MobEffect> MANA_SICKNESS = MOB_EFFECTS.register("mana_sickness",
            () -> new GenericHazenEffect(MobEffectCategory.HARMFUL, 0xfbb741)
                    .addAttributeModifier(AttributeRegistry.MAX_MANA,
                            ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "mana_sickness"), -0.25f,
                            AttributeModifier.Operation.ADD_MULTIPLIED_BASE)
                    .addAttributeModifier(AttributeRegistry.MANA_REGEN,
                            ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "mana_sickness"), -0.15f,
                            AttributeModifier.Operation.ADD_MULTIPLIED_BASE)
                    .addAttributeModifier(AttributeRegistry.SPELL_RESIST,
                            ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "mana_sickness"), -0.15f,
                            AttributeModifier.Operation.ADD_MULTIPLIED_BASE)
    );

    public static final Holder<MobEffect> COOLDOWN_RESET = MOB_EFFECTS.register("cooldown_reset",
            () -> new GenericHazenEffect(MobEffectCategory.BENEFICIAL, 0xfbb741)
                    .addAttributeModifier(AttributeRegistry.COOLDOWN_REDUCTION,
                            ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "cooldown_reset"), 90000f,
                            AttributeModifier.Operation.ADD_VALUE)
    );

    public static final DeferredHolder<MobEffect, MobEffect> INFESTED = MOB_EFFECTS.register("infested",
            () -> new InfestedEffect(MobEffectCategory.HARMFUL, 0x2E2EFF));

    public static final DeferredHolder<MobEffect, MobEffect> SPORES = MOB_EFFECTS.register("spores",
            () -> new SporeEffect(MobEffectCategory.HARMFUL, 0x2E2EFF));

    public static final DeferredHolder<MobEffect, MobEffect> ELECTROCUTED = MOB_EFFECTS.register("electrocuted",
            () -> new ElectrocutedEffect(MobEffectCategory.HARMFUL, 0x2E2EFF));

    public static final DeferredHolder<MobEffect, MobEffect> HEXED = MOB_EFFECTS.register("hexed",
            () -> new GenericHazenEffect(MobEffectCategory.HARMFUL, 0x2E2EFF));


    public static void register(IEventBus eventBus) {
        MOB_EFFECTS.register(eventBus);
    }

}
