package net.hazen.hazennstuff.registries;

import io.redspace.ironsspellbooks.api.registry.AttributeRegistry;
import net.hazen.hazennstuff.HazenNStuff;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;
import dev.shadowsoffire.apothic_attributes.api.ALObjects;

public class HnSEffects {
    public static final DeferredRegister<MobEffect> MOB_EFFECTS =
            DeferredRegister.create(BuiltInRegistries.MOB_EFFECT, HazenNStuff.MOD_ID);

    public static final Holder<MobEffect> TYRANTS_GRACE_EFFECT = MOB_EFFECTS.register("tyrants_grace",
            () -> new HazensEffect(MobEffectCategory.BENEFICIAL, 0xfbb741)
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
    );

    public static final Holder<MobEffect> FIREBLOSSOM_RULER_EFFECT = MOB_EFFECTS.register("fireblossom_ruler",
            () -> new HazensEffect(MobEffectCategory.BENEFICIAL, 0xfbb741)
                    .addAttributeModifier(AttributeRegistry.CASTING_MOVESPEED,
                            ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "fireblossom_ruler"), 0.15f,
                            AttributeModifier.Operation.ADD_MULTIPLIED_BASE)
                    .addAttributeModifier(AttributeRegistry.SPELL_RESIST,
                            ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "fireblossom_ruler"), 0.1f,
                            AttributeModifier.Operation.ADD_MULTIPLIED_BASE));

    public static final Holder<MobEffect> FIREBLOSSOM_WARRIOR_EFFECT = MOB_EFFECTS.register("fireblossom_warrior",
            () -> new HazensEffect(MobEffectCategory.BENEFICIAL, 0xfbb741)
                    .addAttributeModifier(Attributes.ARMOR,
                            ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "fireblossom_warrior"), 2f,
                            AttributeModifier.Operation.ADD_MULTIPLIED_BASE)
                    .addAttributeModifier(Attributes.ARMOR_TOUGHNESS,
                            ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "fireblossom_warrior"), 2f,
                            AttributeModifier.Operation.ADD_MULTIPLIED_BASE)
                    .addAttributeModifier(ALObjects.Attributes.PROT_SHRED,
                            ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "fireblossom_warrior"), 0.15f,
                            AttributeModifier.Operation.ADD_MULTIPLIED_BASE));

    public static final Holder<MobEffect> PURE_ARMOR_SET_BONUS = MOB_EFFECTS.register("pure_armor_set_bonus",
            () -> new HazensEffect(MobEffectCategory.BENEFICIAL, 0xfbb741)
                    .addAttributeModifier(AttributeRegistry.CASTING_MOVESPEED,
                            ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "pure_armor_set_bonus"), 0.15f,
                            AttributeModifier.Operation.ADD_MULTIPLIED_BASE)
                    .addAttributeModifier(AttributeRegistry.SPELL_RESIST,
                            ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "pure_armor_set_bonus"), 0.1f,
                            AttributeModifier.Operation.ADD_MULTIPLIED_BASE)
    );

    public static final Holder<MobEffect> FLAME_KISSED = MOB_EFFECTS.register("flame_kissed",
            () -> new HazensEffect(MobEffectCategory.BENEFICIAL, 0xfbb741)
                    .addAttributeModifier(AttributeRegistry.FIRE_SPELL_POWER,
                            ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "flame_kissed"), 0.5f,
                            AttributeModifier.Operation.ADD_MULTIPLIED_BASE)
                    .addAttributeModifier(ALObjects.Attributes.FIRE_DAMAGE,
                            ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "flame_kissed"), 2f,
                            AttributeModifier.Operation.ADD_VALUE)
    );

    public static void register(IEventBus eventBus) {
        MOB_EFFECTS.register(eventBus);
    }

}
