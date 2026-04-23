package net.hazen.hazennstuff.HnSUtilities;

import io.redspace.ironsspellbooks.api.registry.AttributeRegistry;
import net.acetheeldritchking.aces_spell_utils.registries.ASAttributeRegistry;
import net.hazen.hazennstuff.Datagen.HnSEnchantmentTags;
import net.hazen.hazennstuff.Datagen.HnSTags;
import net.hazen.hazennstuff.HazenNStuff;
import net.hazen.hazennstuff.Registries.HnSAttributeRegistry;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EquipmentSlotGroup;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentEffectComponents;
import net.minecraft.world.item.enchantment.LevelBasedValue;
import net.minecraft.world.item.enchantment.effects.EnchantmentAttributeEffect;

public class HnSEnchantments {
    public static final ResourceKey<Enchantment> FIRE_ATTUNEMENT = ResourceKey.create(Registries.ENCHANTMENT,
            ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "fire_attunement"));
    public static final ResourceKey<Enchantment> ICE_ATTUNEMENT = ResourceKey.create(Registries.ENCHANTMENT,
            ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "ice_attunement"));
    public static final ResourceKey<Enchantment> NATURE_ATTUNEMENT = ResourceKey.create(Registries.ENCHANTMENT,
            ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "nature_attunement"));
    public static final ResourceKey<Enchantment> LIGHTNING_ATTUNEMENT = ResourceKey.create(Registries.ENCHANTMENT,
            ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "lightning_attunement"));
    public static final ResourceKey<Enchantment> ENDER_ATTUNEMENT = ResourceKey.create(Registries.ENCHANTMENT,
            ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "ender_attunement"));
    public static final ResourceKey<Enchantment> BLOOD_ATTUNEMENT = ResourceKey.create(Registries.ENCHANTMENT,
            ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "blood_attunement"));
    public static final ResourceKey<Enchantment> EVOCATION_ATTUNEMENT = ResourceKey.create(Registries.ENCHANTMENT,
            ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "evocation_attunement"));
    public static final ResourceKey<Enchantment> HOLY_ATTUNEMENT = ResourceKey.create(Registries.ENCHANTMENT,
            ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "holy_attunement"));
    public static final ResourceKey<Enchantment> RADIANCE_ATTUNEMENT = ResourceKey.create(Registries.ENCHANTMENT,
            ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "radiance_attunement"));
    public static final ResourceKey<Enchantment> SHADOW_ATTUNEMENT = ResourceKey.create(Registries.ENCHANTMENT,
            ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "shadow_attunement"));
    public static final ResourceKey<Enchantment> HYDRO_ATTUNEMENT = ResourceKey.create(Registries.ENCHANTMENT,
            ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "hydro_attunement"));
    public static final ResourceKey<Enchantment> COSMIC_ATTUNEMENT = ResourceKey.create(Registries.ENCHANTMENT,
            ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "cosmic_attunement"));
    public static final ResourceKey<Enchantment> TECHNOMANCY_ATTUNEMENT = ResourceKey.create(Registries.ENCHANTMENT,
            ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "technomancy_attunement"));
    public static final ResourceKey<Enchantment> OCCULT_ATTUNEMENT = ResourceKey.create(Registries.ENCHANTMENT,
            ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "occult_attunement"));
    public static final ResourceKey<Enchantment> ELDRITCH_ATTUNEMENT = ResourceKey.create(Registries.ENCHANTMENT,
            ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "eldritch_attunement"));

    public static final ResourceKey<Enchantment> ARCANE_AFFINITY = ResourceKey.create(Registries.ENCHANTMENT,
            ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "arcane_affinity"));

    public static final ResourceKey<Enchantment> CINDERKISSED = ResourceKey.create(Registries.ENCHANTMENT,
            ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "cinderkissed"));

    public static void bootstrap (BootstrapContext<Enchantment> context) {
        var enchantments = context.lookup(Registries.ENCHANTMENT);
        var items = context.lookup(Registries.ITEM);

        register(context, FIRE_ATTUNEMENT, Enchantment.enchantment(Enchantment.definition(
                        items.getOrThrow(HnSTags.ENCHANTED_SPELLBOOK),
                        1,
                        3,
                        Enchantment.dynamicCost(5, 7),
                        Enchantment.dynamicCost(25, 7),
                        3,
                        EquipmentSlotGroup.MAINHAND))
                .exclusiveWith(enchantments.getOrThrow(HnSEnchantmentTags.SPELLBOOK_EXCLUSIVE))
                .withEffect(
                        EnchantmentEffectComponents.ATTRIBUTES,
                        new EnchantmentAttributeEffect(
                                ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "fire_attunement"),
                                AttributeRegistry.FIRE_SPELL_POWER,
                                LevelBasedValue.perLevel(0.05F),
                                AttributeModifier.Operation.ADD_MULTIPLIED_BASE
                        )
                )
        );

        register(context, ICE_ATTUNEMENT, Enchantment.enchantment(Enchantment.definition(
                        items.getOrThrow(HnSTags.ENCHANTED_SPELLBOOK),
                        1,
                        3,
                        Enchantment.dynamicCost(5, 7),
                        Enchantment.dynamicCost(25, 7),
                        3,
                        EquipmentSlotGroup.MAINHAND))
                .exclusiveWith(enchantments.getOrThrow(HnSEnchantmentTags.SPELLBOOK_EXCLUSIVE))
                .withEffect(
                        EnchantmentEffectComponents.ATTRIBUTES,
                        new EnchantmentAttributeEffect(
                                ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "ice_attunement"),
                                AttributeRegistry.ICE_SPELL_POWER,
                                LevelBasedValue.perLevel(0.05F),
                                AttributeModifier.Operation.ADD_MULTIPLIED_BASE
                        )
                )
        );

        register(context, NATURE_ATTUNEMENT, Enchantment.enchantment(Enchantment.definition(
                        items.getOrThrow(HnSTags.ENCHANTED_SPELLBOOK),
                        1,
                        3,
                        Enchantment.dynamicCost(5, 7),
                        Enchantment.dynamicCost(25, 7),
                        3,
                        EquipmentSlotGroup.MAINHAND))
                .exclusiveWith(enchantments.getOrThrow(HnSEnchantmentTags.SPELLBOOK_EXCLUSIVE))
                .withEffect(
                        EnchantmentEffectComponents.ATTRIBUTES,
                        new EnchantmentAttributeEffect(
                                ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "nature_attunement"),
                                AttributeRegistry.NATURE_SPELL_POWER,
                                LevelBasedValue.perLevel(0.05F),
                                AttributeModifier.Operation.ADD_MULTIPLIED_BASE
                        )
                )
        );

        register(context, LIGHTNING_ATTUNEMENT, Enchantment.enchantment(Enchantment.definition(
                        items.getOrThrow(HnSTags.ENCHANTED_SPELLBOOK),
                        1,
                        3,
                        Enchantment.dynamicCost(5, 7),
                        Enchantment.dynamicCost(25, 7),
                        3,
                        EquipmentSlotGroup.MAINHAND))
                .exclusiveWith(enchantments.getOrThrow(HnSEnchantmentTags.SPELLBOOK_EXCLUSIVE))
                .withEffect(
                        EnchantmentEffectComponents.ATTRIBUTES,
                        new EnchantmentAttributeEffect(
                                ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "lightning_attunement"),
                                AttributeRegistry.LIGHTNING_SPELL_POWER,
                                LevelBasedValue.perLevel(0.05F),
                                AttributeModifier.Operation.ADD_MULTIPLIED_BASE
                        )
                )
        );

        register(context, ENDER_ATTUNEMENT, Enchantment.enchantment(Enchantment.definition(
                        items.getOrThrow(HnSTags.ENCHANTED_SPELLBOOK),
                        1,
                        3,
                        Enchantment.dynamicCost(5, 7),
                        Enchantment.dynamicCost(25, 7),
                        3,
                        EquipmentSlotGroup.MAINHAND))
                .exclusiveWith(enchantments.getOrThrow(HnSEnchantmentTags.SPELLBOOK_EXCLUSIVE))
                .withEffect(
                        EnchantmentEffectComponents.ATTRIBUTES,
                        new EnchantmentAttributeEffect(
                                ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "ender_attunement"),
                                AttributeRegistry.ENDER_SPELL_POWER,
                                LevelBasedValue.perLevel(0.05F),
                                AttributeModifier.Operation.ADD_MULTIPLIED_BASE
                        )
                )
        );

        register(context, BLOOD_ATTUNEMENT, Enchantment.enchantment(Enchantment.definition(
                        items.getOrThrow(HnSTags.ENCHANTED_SPELLBOOK),
                        1,
                        3,
                        Enchantment.dynamicCost(5, 7),
                        Enchantment.dynamicCost(25, 7),
                        3,
                        EquipmentSlotGroup.MAINHAND))
                .exclusiveWith(enchantments.getOrThrow(HnSEnchantmentTags.SPELLBOOK_EXCLUSIVE))
                .withEffect(
                        EnchantmentEffectComponents.ATTRIBUTES,
                        new EnchantmentAttributeEffect(
                                ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "blood_attunement"),
                                AttributeRegistry.BLOOD_SPELL_POWER,
                                LevelBasedValue.perLevel(0.05F),
                                AttributeModifier.Operation.ADD_MULTIPLIED_BASE
                        )
                )
        );

        register(context, EVOCATION_ATTUNEMENT, Enchantment.enchantment(Enchantment.definition(
                        items.getOrThrow(HnSTags.ENCHANTED_SPELLBOOK),
                        1,
                        3,
                        Enchantment.dynamicCost(5, 7),
                        Enchantment.dynamicCost(25, 7),
                        3,
                        EquipmentSlotGroup.MAINHAND))
                .exclusiveWith(enchantments.getOrThrow(HnSEnchantmentTags.SPELLBOOK_EXCLUSIVE))
                .withEffect(
                        EnchantmentEffectComponents.ATTRIBUTES,
                        new EnchantmentAttributeEffect(
                                ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "evocation_attunement"),
                                AttributeRegistry.EVOCATION_SPELL_POWER,
                                LevelBasedValue.perLevel(0.05F),
                                AttributeModifier.Operation.ADD_MULTIPLIED_BASE
                        )
                )
        );

        register(context, HOLY_ATTUNEMENT, Enchantment.enchantment(Enchantment.definition(
                        items.getOrThrow(HnSTags.ENCHANTED_SPELLBOOK),
                        1,
                        3,
                        Enchantment.dynamicCost(5, 7),
                        Enchantment.dynamicCost(25, 7),
                        3,
                        EquipmentSlotGroup.MAINHAND))
                .exclusiveWith(enchantments.getOrThrow(HnSEnchantmentTags.SPELLBOOK_EXCLUSIVE))
                .withEffect(
                        EnchantmentEffectComponents.ATTRIBUTES,
                        new EnchantmentAttributeEffect(
                                ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "holy_attunement"),
                                AttributeRegistry.HOLY_SPELL_POWER,
                                LevelBasedValue.perLevel(0.05F),
                                AttributeModifier.Operation.ADD_MULTIPLIED_BASE
                        )
                )
        );

        register(context, RADIANCE_ATTUNEMENT, Enchantment.enchantment(Enchantment.definition(
                        items.getOrThrow(HnSTags.ENCHANTED_SPELLBOOK),
                        1,
                        3,
                        Enchantment.dynamicCost(5, 7),
                        Enchantment.dynamicCost(25, 7),
                        3,
                        EquipmentSlotGroup.MAINHAND))
                .exclusiveWith(enchantments.getOrThrow(HnSEnchantmentTags.SPELLBOOK_EXCLUSIVE))
                .withEffect(
                        EnchantmentEffectComponents.ATTRIBUTES,
                        new EnchantmentAttributeEffect(
                                ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "radiance_attunement"),
                                HnSAttributeRegistry.RADIANCE_SPELL_POWER,
                                LevelBasedValue.perLevel(0.05F),
                                AttributeModifier.Operation.ADD_MULTIPLIED_BASE
                        )
                )
        );

        register(context, SHADOW_ATTUNEMENT, Enchantment.enchantment(Enchantment.definition(
                        items.getOrThrow(HnSTags.ENCHANTED_SPELLBOOK),
                        1,
                        3,
                        Enchantment.dynamicCost(5, 7),
                        Enchantment.dynamicCost(25, 7),
                        3,
                        EquipmentSlotGroup.MAINHAND))
                .exclusiveWith(enchantments.getOrThrow(HnSEnchantmentTags.SPELLBOOK_EXCLUSIVE))
                .withEffect(
                        EnchantmentEffectComponents.ATTRIBUTES,
                        new EnchantmentAttributeEffect(
                                ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "shadow_attunement"),
                                HnSAttributeRegistry.SHADOW_SPELL_POWER,
                                LevelBasedValue.perLevel(0.05F),
                                AttributeModifier.Operation.ADD_MULTIPLIED_BASE
                        )
                )
        );

        register(context, COSMIC_ATTUNEMENT, Enchantment.enchantment(Enchantment.definition(
                        items.getOrThrow(HnSTags.ENCHANTED_SPELLBOOK),
                        1,
                        3,
                        Enchantment.dynamicCost(5, 7),
                        Enchantment.dynamicCost(25, 7),
                        3,
                        EquipmentSlotGroup.MAINHAND))
                .exclusiveWith(enchantments.getOrThrow(HnSEnchantmentTags.SPELLBOOK_EXCLUSIVE))
                .withEffect(
                        EnchantmentEffectComponents.ATTRIBUTES,
                        new EnchantmentAttributeEffect(
                                ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "cosmic_attunement"),
                                HnSAttributeRegistry.COSMIC_SPELL_POWER,
                                LevelBasedValue.perLevel(0.05F),
                                AttributeModifier.Operation.ADD_MULTIPLIED_BASE
                        )
                )
        );

        register(context, HYDRO_ATTUNEMENT, Enchantment.enchantment(Enchantment.definition(
                        items.getOrThrow(HnSTags.ENCHANTED_SPELLBOOK),
                        1,
                        3,
                        Enchantment.dynamicCost(5, 7),
                        Enchantment.dynamicCost(25, 7),
                        3,
                        EquipmentSlotGroup.MAINHAND))
                .exclusiveWith(enchantments.getOrThrow(HnSEnchantmentTags.SPELLBOOK_EXCLUSIVE))
                .withEffect(
                        EnchantmentEffectComponents.ATTRIBUTES,
                        new EnchantmentAttributeEffect(
                                ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "hydro_attunement"),
                                ASAttributeRegistry.HYDRO_MAGIC_POWER,
                                LevelBasedValue.perLevel(0.05F),
                                AttributeModifier.Operation.ADD_MULTIPLIED_BASE
                        )
                )
        );

        register(context, TECHNOMANCY_ATTUNEMENT, Enchantment.enchantment(Enchantment.definition(
                        items.getOrThrow(HnSTags.ENCHANTED_SPELLBOOK),
                        1,
                        3,
                        Enchantment.dynamicCost(5, 7),
                        Enchantment.dynamicCost(25, 7),
                        3,
                        EquipmentSlotGroup.MAINHAND))
                .exclusiveWith(enchantments.getOrThrow(HnSEnchantmentTags.SPELLBOOK_EXCLUSIVE))
                .withEffect(
                        EnchantmentEffectComponents.ATTRIBUTES,
                        new EnchantmentAttributeEffect(
                                ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "technomancy_attunement"),
                                ASAttributeRegistry.TECHNOMANCY_MAGIC_POWER,
                                LevelBasedValue.perLevel(0.05F),
                                AttributeModifier.Operation.ADD_MULTIPLIED_BASE
                        )
                )
        );

        register(context, OCCULT_ATTUNEMENT, Enchantment.enchantment(Enchantment.definition(
                        items.getOrThrow(HnSTags.ENCHANTED_SPELLBOOK),
                        1,
                        3,
                        Enchantment.dynamicCost(5, 7),
                        Enchantment.dynamicCost(25, 7),
                        3,
                        EquipmentSlotGroup.MAINHAND))
                .exclusiveWith(enchantments.getOrThrow(HnSEnchantmentTags.SPELLBOOK_EXCLUSIVE))
                .withEffect(
                        EnchantmentEffectComponents.ATTRIBUTES,
                        new EnchantmentAttributeEffect(
                                ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "occult_attunement"),
                                ASAttributeRegistry.RITUAL_MAGIC_POWER,
                                LevelBasedValue.perLevel(0.05F),
                                AttributeModifier.Operation.ADD_MULTIPLIED_BASE
                        )
                )
        );

        register(context, ELDRITCH_ATTUNEMENT, Enchantment.enchantment(Enchantment.definition(
                        items.getOrThrow(HnSTags.ENCHANTED_SPELLBOOK),
                        1,
                        3,
                        Enchantment.dynamicCost(5, 7),
                        Enchantment.dynamicCost(25, 7),
                        3,
                        EquipmentSlotGroup.MAINHAND))
                .exclusiveWith(enchantments.getOrThrow(HnSEnchantmentTags.SPELLBOOK_EXCLUSIVE))
                .withEffect(
                        EnchantmentEffectComponents.ATTRIBUTES,
                        new EnchantmentAttributeEffect(
                                ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "eldritch_attunement"),
                                AttributeRegistry.ELDRITCH_SPELL_POWER,
                                LevelBasedValue.perLevel(0.05F),
                                AttributeModifier.Operation.ADD_MULTIPLIED_BASE
                        )
                )
        );


        register(context, ARCANE_AFFINITY, Enchantment.enchantment(Enchantment.definition(
                        items.getOrThrow(HnSTags.ENCHANTED_SPELLBOOK),
                        3,
                        4,
                        Enchantment.dynamicCost(5, 7),
                        Enchantment.dynamicCost(25, 7),
                        2,
                        EquipmentSlotGroup.MAINHAND))
                .exclusiveWith(enchantments.getOrThrow(HnSEnchantmentTags.SPELLBOOK_EXCLUSIVE))
                .withEffect(
                        EnchantmentEffectComponents.ATTRIBUTES,
                        new EnchantmentAttributeEffect(
                                ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "max_mana"),
                                AttributeRegistry.MAX_MANA,
                                LevelBasedValue.perLevel(75F),
                                AttributeModifier.Operation.ADD_VALUE
                        )
                )
                .withEffect(
                        EnchantmentEffectComponents.ATTRIBUTES,
                        new EnchantmentAttributeEffect(
                                ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "mana_regen"),
                                AttributeRegistry.MANA_REGEN,
                                LevelBasedValue.perLevel(0.05F),
                                AttributeModifier.Operation.ADD_MULTIPLIED_BASE
                        )
                )
        );

        register(context, CINDERKISSED, Enchantment.enchantment(Enchantment.definition(
                        items.getOrThrow(HnSTags.FIRE_SPELLBOOK),
                        1,
                        1,
                        Enchantment.dynamicCost(5, 7),
                        Enchantment.dynamicCost(25, 7),
                        5,
                        EquipmentSlotGroup.MAINHAND))
                .exclusiveWith(enchantments.getOrThrow(HnSEnchantmentTags.SPELL_ENHANCEMENT))
        );
    }

    private static void register(BootstrapContext<Enchantment> registry,
                                 ResourceKey<Enchantment> key,
                                 Enchantment.Builder builder)
    {
        registry.register(key, builder.build(key.location()));
    }

}
