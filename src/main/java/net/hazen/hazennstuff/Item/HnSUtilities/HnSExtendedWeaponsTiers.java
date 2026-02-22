package net.hazen.hazennstuff.Item.HnSUtilities;

import dev.shadowsoffire.apothic_attributes.api.ALObjects;
import io.redspace.ironsspellbooks.api.registry.AttributeRegistry;
import io.redspace.ironsspellbooks.item.weapons.AttributeContainer;
import io.redspace.ironsspellbooks.item.weapons.IronsWeaponTier;
import io.redspace.ironsspellbooks.registries.ItemRegistry;
import net.acetheeldritchking.aces_spell_utils.registries.ASAttributeRegistry;
import net.hazen.hazennstuff.Datagen.HnSTags;
import net.hazen.hazennstuff.Registries.HnSAttributeRegistry;
import net.hazen.hazennstuff.Registries.HnSItemRegistry;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.block.Block;

import java.util.function.Supplier;

public class HnSExtendedWeaponsTiers implements Tier, IronsWeaponTier {

    /*
     *** Ice
     */

    public static HnSExtendedWeaponsTiers ICE_PIKE = new HnSExtendedWeaponsTiers(
            8064,
            11,
            -2.9F,
            10,
            BlockTags.INCORRECT_FOR_NETHERITE_TOOL,
            () -> Ingredient.of(HnSItemRegistry.ZENALITE_INGOT.get()),
            new AttributeContainer(AttributeRegistry.ICE_SPELL_POWER, 0.15, AttributeModifier.Operation.ADD_MULTIPLIED_BASE),
            new AttributeContainer(ALObjects.Attributes.COLD_DAMAGE, 5, AttributeModifier.Operation.ADD_VALUE),
            new AttributeContainer(Attributes.ENTITY_INTERACTION_RANGE, 2, AttributeModifier.Operation.ADD_VALUE)
    );

    public static HnSExtendedWeaponsTiers FROSTBURN_DAGGER = new HnSExtendedWeaponsTiers(
            8064,
            7,
            -1.7F,
            10,
            BlockTags.INCORRECT_FOR_NETHERITE_TOOL,
            () -> Ingredient.of(HnSItemRegistry.ZENALITE_INGOT.get()),
            new AttributeContainer(AttributeRegistry.ICE_SPELL_POWER, 0.20, AttributeModifier.Operation.ADD_MULTIPLIED_BASE),
            new AttributeContainer(ALObjects.Attributes.COLD_DAMAGE, 3, AttributeModifier.Operation.ADD_VALUE)
    );

    /*
     *** Fire
     */

    public static HnSExtendedWeaponsTiers DRACONIC_SPLITTER = new HnSExtendedWeaponsTiers(
            8064,
            12,
            -2.6F,
            10,
            BlockTags.INCORRECT_FOR_NETHERITE_TOOL,
            () -> Ingredient.of(HnSItemRegistry.ZENALITE_INGOT.get()),
            new AttributeContainer(AttributeRegistry.FIRE_SPELL_POWER, 0.15, AttributeModifier.Operation.ADD_MULTIPLIED_BASE),
            new AttributeContainer(ALObjects.Attributes.FIRE_DAMAGE, 5, AttributeModifier.Operation.ADD_VALUE),
            new AttributeContainer(Attributes.ENTITY_INTERACTION_RANGE, 2, AttributeModifier.Operation.ADD_VALUE)
    );

    public static HnSExtendedWeaponsTiers FIREBRAND = new HnSExtendedWeaponsTiers(
            8064,
            9,
            -3F,
            10,
            BlockTags.INCORRECT_FOR_NETHERITE_TOOL,
            () -> Ingredient.of(HnSItemRegistry.ZENALITE_INGOT.get()),
            new AttributeContainer(AttributeRegistry.FIRE_SPELL_POWER, 0.15, AttributeModifier.Operation.ADD_MULTIPLIED_BASE),
            new AttributeContainer(ALObjects.Attributes.FIRE_DAMAGE, 5, AttributeModifier.Operation.ADD_VALUE),
            new AttributeContainer(Attributes.ENTITY_INTERACTION_RANGE, 2, AttributeModifier.Operation.ADD_VALUE)
    );

    public static HnSExtendedWeaponsTiers VOLCANO = new HnSExtendedWeaponsTiers(
            8064,
            9,
            -2.7F,
            10,
            BlockTags.INCORRECT_FOR_NETHERITE_TOOL,
            () -> Ingredient.of(HnSItemRegistry.ZENALITE_INGOT.get()),
            new AttributeContainer(AttributeRegistry.FIRE_SPELL_POWER, 0.15, AttributeModifier.Operation.ADD_MULTIPLIED_BASE)
    );

    public static HnSExtendedWeaponsTiers FIREBLOSSOM_RAPIER = new HnSExtendedWeaponsTiers(
            8064,
            8,
            -1.7F,
            10,
            BlockTags.INCORRECT_FOR_NETHERITE_TOOL,
            () -> Ingredient.of(HnSItemRegistry.ZENALITE_INGOT.get()),
            new AttributeContainer(AttributeRegistry.FIRE_SPELL_POWER, 0.20, AttributeModifier.Operation.ADD_MULTIPLIED_BASE),
            new AttributeContainer(AttributeRegistry.NATURE_SPELL_POWER, 0.20, AttributeModifier.Operation.ADD_MULTIPLIED_BASE),
            new AttributeContainer(ALObjects.Attributes.FIRE_DAMAGE, 3, AttributeModifier.Operation.ADD_VALUE),
            new AttributeContainer(Attributes.ENTITY_INTERACTION_RANGE, 2, AttributeModifier.Operation.ADD_VALUE)
    );

    public static HnSExtendedWeaponsTiers WARFLAMING_LANCE = new HnSExtendedWeaponsTiers(
            8064,
            10,
            -2.7F,
            10,
            BlockTags.INCORRECT_FOR_NETHERITE_TOOL,
            () -> Ingredient.of(HnSItemRegistry.ZENALITE_INGOT.get()),
            new AttributeContainer(AttributeRegistry.FIRE_SPELL_POWER, 0.15, AttributeModifier.Operation.ADD_MULTIPLIED_BASE),
            new AttributeContainer(ALObjects.Attributes.FIRE_DAMAGE, 5, AttributeModifier.Operation.ADD_VALUE),
            new AttributeContainer(Attributes.ENTITY_INTERACTION_RANGE, 3, AttributeModifier.Operation.ADD_VALUE)
    );

    public static HnSExtendedWeaponsTiers RAVENS_BANE = new HnSExtendedWeaponsTiers(
            8064,
            13,
            -2.6F,
            10,
            BlockTags.INCORRECT_FOR_NETHERITE_TOOL,
            () -> Ingredient.of(HnSItemRegistry.ZENALITE_INGOT.get()),
            new AttributeContainer(AttributeRegistry.FIRE_SPELL_POWER, 0.15, AttributeModifier.Operation.ADD_MULTIPLIED_BASE),
            new AttributeContainer(ALObjects.Attributes.FIRE_DAMAGE, 5, AttributeModifier.Operation.ADD_VALUE),
            new AttributeContainer(Attributes.ENTITY_INTERACTION_RANGE, 3, AttributeModifier.Operation.ADD_VALUE),
            new AttributeContainer(Attributes.ATTACK_SPEED, -0.1, AttributeModifier.Operation.ADD_VALUE)
    );

    /*
     *** Lightning
     */

    public static HnSExtendedWeaponsTiers BEONGAE = new HnSExtendedWeaponsTiers(
            8064,
            9,
            -3F,
            10,
            BlockTags.INCORRECT_FOR_NETHERITE_TOOL,
            () -> Ingredient.of(HnSItemRegistry.ZENALITE_INGOT.get()),
            new AttributeContainer(AttributeRegistry.LIGHTNING_SPELL_POWER, 0.1, AttributeModifier.Operation.ADD_MULTIPLIED_BASE),
            new AttributeContainer(ALObjects.Attributes.CRIT_DAMAGE, .05, AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL)
    );

    public static HnSExtendedWeaponsTiers SKYSCORCHER = new HnSExtendedWeaponsTiers(
            8064,
            12,
            -3.4F,
            10,
            BlockTags.INCORRECT_FOR_NETHERITE_TOOL,
            () -> Ingredient.of(HnSItemRegistry.ZENALITE_INGOT.get()),
            new AttributeContainer(AttributeRegistry.LIGHTNING_SPELL_POWER, 0.15, AttributeModifier.Operation.ADD_MULTIPLIED_BASE),
            new AttributeContainer(ALObjects.Attributes.CRIT_DAMAGE, .25, AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL),
            new AttributeContainer(ALObjects.Attributes.CRIT_CHANCE, .15, AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL)
    );

    public static HnSExtendedWeaponsTiers IONIC_SPLITTER_DORMANT = new HnSExtendedWeaponsTiers(
            8064,
            6,
            -2F,
            10,
            BlockTags.INCORRECT_FOR_NETHERITE_TOOL,
            () -> Ingredient.of(HnSItemRegistry.ZENALITE_INGOT.get()),
            new AttributeContainer(AttributeRegistry.LIGHTNING_SPELL_POWER, 0.1, AttributeModifier.Operation.ADD_MULTIPLIED_BASE)
    );

    public static HnSExtendedWeaponsTiers IONIC_SPLITTER_T1 = new HnSExtendedWeaponsTiers(
            8064,
            7,
            -2F,
            10,
            BlockTags.INCORRECT_FOR_NETHERITE_TOOL,
            () -> Ingredient.of(HnSItemRegistry.ZENALITE_INGOT.get()),
            new AttributeContainer(AttributeRegistry.LIGHTNING_SPELL_POWER, 0.15, AttributeModifier.Operation.ADD_MULTIPLIED_BASE)
    );

    public static HnSExtendedWeaponsTiers IONIC_SPLITTER_T2 = new HnSExtendedWeaponsTiers(
            8064,
            8,
            -1.9F,
            10,
            BlockTags.INCORRECT_FOR_NETHERITE_TOOL,
            () -> Ingredient.of(HnSItemRegistry.ZENALITE_INGOT.get()),
            new AttributeContainer(AttributeRegistry.LIGHTNING_SPELL_POWER, 0.2, AttributeModifier.Operation.ADD_MULTIPLIED_BASE)
    );

    public static HnSExtendedWeaponsTiers IONIC_SPLITTER_T3 = new HnSExtendedWeaponsTiers(
            8064,
            9,
            -1.8F,
            10,
            BlockTags.INCORRECT_FOR_NETHERITE_TOOL,
            () -> Ingredient.of(HnSItemRegistry.ZENALITE_INGOT.get()),
            new AttributeContainer(AttributeRegistry.LIGHTNING_SPELL_POWER, 0.25, AttributeModifier.Operation.ADD_MULTIPLIED_BASE)
    );

    /*
     *** Evocation
     */

    public static HnSExtendedWeaponsTiers ANCIENT_WARRIORS_AXE = new HnSExtendedWeaponsTiers(
            8064,
            9,
            -3F,
            10,
            BlockTags.INCORRECT_FOR_NETHERITE_TOOL,
            () -> Ingredient.of(HnSItemRegistry.ZENALITE_INGOT.get()),
            new AttributeContainer(AttributeRegistry.EVOCATION_SPELL_POWER, 0.1, AttributeModifier.Operation.ADD_MULTIPLIED_BASE),
            new AttributeContainer(ALObjects.Attributes.CRIT_DAMAGE, .15, AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL)
    );

    public static HnSExtendedWeaponsTiers MALICE = new HnSExtendedWeaponsTiers(
            8064,
            8,
            -2.4F,
            10,
            BlockTags.INCORRECT_FOR_NETHERITE_TOOL,
            () -> Ingredient.of(HnSItemRegistry.ZENALITE_INGOT.get()),
            new AttributeContainer(ALObjects.Attributes.ARMOR_SHRED, .1, AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL),
            new AttributeContainer(ALObjects.Attributes.PROT_PIERCE, .1, AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL),
            new AttributeContainer(ALObjects.Attributes.CRIT_CHANCE, .15, AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL),
            new AttributeContainer(AttributeRegistry.EVOCATION_SPELL_POWER, .2, AttributeModifier.Operation.ADD_MULTIPLIED_BASE)
    );

    public static HnSExtendedWeaponsTiers PROVOCATION_DORMANT = new HnSExtendedWeaponsTiers(
            8064,
            6,
            -2F,
            10,
            BlockTags.INCORRECT_FOR_NETHERITE_TOOL,
            () -> Ingredient.of(HnSItemRegistry.ZENALITE_INGOT.get()),
            new AttributeContainer(AttributeRegistry.EVOCATION_SPELL_POWER, 0.1, AttributeModifier.Operation.ADD_MULTIPLIED_BASE)
    );

    public static HnSExtendedWeaponsTiers PROVOCATION_T1 = new HnSExtendedWeaponsTiers(
            8064,
            7,
            -2F,
            10,
            BlockTags.INCORRECT_FOR_NETHERITE_TOOL,
            () -> Ingredient.of(HnSItemRegistry.ZENALITE_INGOT.get()),
            new AttributeContainer(AttributeRegistry.EVOCATION_SPELL_POWER, 0.15, AttributeModifier.Operation.ADD_MULTIPLIED_BASE)
    );

    public static HnSExtendedWeaponsTiers PROVOCATION_T2 = new HnSExtendedWeaponsTiers(
            8064,
            8,
            -1.9F,
            10,
            BlockTags.INCORRECT_FOR_NETHERITE_TOOL,
            () -> Ingredient.of(HnSItemRegistry.ZENALITE_INGOT.get()),
            new AttributeContainer(AttributeRegistry.EVOCATION_SPELL_POWER, 0.2, AttributeModifier.Operation.ADD_MULTIPLIED_BASE)
    );

    public static HnSExtendedWeaponsTiers PROVOCATION_T3 = new HnSExtendedWeaponsTiers(
            8064,
            9,
            -1.8F,
            10,
            BlockTags.INCORRECT_FOR_NETHERITE_TOOL,
            () -> Ingredient.of(HnSItemRegistry.ZENALITE_INGOT.get()),
            new AttributeContainer(AttributeRegistry.EVOCATION_SPELL_POWER, 0.25, AttributeModifier.Operation.ADD_MULTIPLIED_BASE)
    );

    /*
     *** Holy
     */

    public static HnSExtendedWeaponsTiers HAMMER_OF_JUSTICE = new HnSExtendedWeaponsTiers(
            8064,
            9,
            -3.1F,
            10,
            BlockTags.INCORRECT_FOR_NETHERITE_TOOL,
            () -> Ingredient.of(HnSItemRegistry.ZENALITE_INGOT.get()),
            new AttributeContainer(ASAttributeRegistry.SPELL_RES_PENETRATION, .1, AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL),
            new AttributeContainer(ALObjects.Attributes.ARMOR_PIERCE, .1, AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL),
            new AttributeContainer(ALObjects.Attributes.ARMOR_SHRED, .1, AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL),
            new AttributeContainer(AttributeRegistry.HOLY_SPELL_POWER, .15, AttributeModifier.Operation.ADD_MULTIPLIED_BASE)
    );

    public static HnSExtendedWeaponsTiers EXCALIBUR = new HnSExtendedWeaponsTiers(
            8064,
            9,
            -2.7F,
            10,
            BlockTags.INCORRECT_FOR_NETHERITE_TOOL,
            () -> Ingredient.of(HnSItemRegistry.ZENALITE_INGOT.get()),
            new AttributeContainer(ASAttributeRegistry.SPELL_RES_PENETRATION, .1, AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL),
            new AttributeContainer(ALObjects.Attributes.ARMOR_SHRED, .1, AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL),
            new AttributeContainer(ALObjects.Attributes.PROT_SHRED, .1, AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL),
            new AttributeContainer(AttributeRegistry.HOLY_SPELL_POWER, .15, AttributeModifier.Operation.ADD_MULTIPLIED_BASE)
    );

    public static HnSExtendedWeaponsTiers DIVINE_GREATSWORD = new HnSExtendedWeaponsTiers(
            8064,
            9,
            -2.7F,
            10,
            BlockTags.INCORRECT_FOR_NETHERITE_TOOL,
            () -> Ingredient.of(HnSItemRegistry.ZENALITE_INGOT.get()),
            new AttributeContainer(ALObjects.Attributes.PROT_PIERCE, .1, AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL),
            new AttributeContainer(ALObjects.Attributes.ARMOR_PIERCE, .1, AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL),
            new AttributeContainer(AttributeRegistry.HOLY_SPELL_POWER, .1, AttributeModifier.Operation.ADD_MULTIPLIED_BASE)

    );


    /*
     *** Nature
     */

    public static HnSExtendedWeaponsTiers BOUNTIFUL_HARVEST = new HnSExtendedWeaponsTiers(
            8064,
            13,
            -2.6F,
            10,
            BlockTags.INCORRECT_FOR_NETHERITE_TOOL,
            () -> Ingredient.of(HnSItemRegistry.ZENALITE_INGOT.get()),
            new AttributeContainer(AttributeRegistry.NATURE_SPELL_POWER, 0.15, AttributeModifier.Operation.ADD_MULTIPLIED_BASE),
            new AttributeContainer(ALObjects.Attributes.PROT_PIERCE, .1, AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL),
            new AttributeContainer(ALObjects.Attributes.ARMOR_PIERCE, .1, AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL)
    );

    public static HnSExtendedWeaponsTiers THORN_CHAKRAM = new HnSExtendedWeaponsTiers(
            8064,
            8,
            -1.7F,
            10,
            BlockTags.INCORRECT_FOR_NETHERITE_TOOL,
            () -> Ingredient.of(HnSItemRegistry.ZENALITE_INGOT.get()),
            new AttributeContainer(AttributeRegistry.NATURE_SPELL_POWER, 0.15, AttributeModifier.Operation.ADD_MULTIPLIED_BASE),
            new AttributeContainer(ALObjects.Attributes.ARMOR_SHRED, .1, AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL),
            new AttributeContainer(ALObjects.Attributes.PROT_SHRED, .1, AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL)
    );

    public static HnSExtendedWeaponsTiers BLADE_OF_GRASS = new HnSExtendedWeaponsTiers(
            8064,
            8,
            -2.7F,
            10,
            BlockTags.INCORRECT_FOR_NETHERITE_TOOL,
            () -> Ingredient.of(HnSItemRegistry.ZENALITE_INGOT.get()),
            new AttributeContainer(AttributeRegistry.NATURE_SPELL_POWER, 0.15, AttributeModifier.Operation.ADD_MULTIPLIED_BASE)
    );

    public static HnSExtendedWeaponsTiers O_FORTUNA_DORMANT = new HnSExtendedWeaponsTiers(
            8064,
            6,
            -2F,
            10,
            BlockTags.INCORRECT_FOR_NETHERITE_TOOL,
            () -> Ingredient.of(HnSItemRegistry.ZENALITE_INGOT.get()),
            new AttributeContainer(AttributeRegistry.NATURE_SPELL_POWER, 0.1, AttributeModifier.Operation.ADD_MULTIPLIED_BASE)
    );

    public static HnSExtendedWeaponsTiers O_FORTUNA_T1 = new HnSExtendedWeaponsTiers(
            8064,
            7,
            -2F,
            10,
            BlockTags.INCORRECT_FOR_NETHERITE_TOOL,
            () -> Ingredient.of(HnSItemRegistry.ZENALITE_INGOT.get()),
            new AttributeContainer(AttributeRegistry.NATURE_SPELL_POWER, 0.15, AttributeModifier.Operation.ADD_MULTIPLIED_BASE)
    );

    public static HnSExtendedWeaponsTiers O_FORTUNA_T2 = new HnSExtendedWeaponsTiers(
            8064,
            8,
            -1.9F,
            10,
            BlockTags.INCORRECT_FOR_NETHERITE_TOOL,
            () -> Ingredient.of(HnSItemRegistry.ZENALITE_INGOT.get()),
            new AttributeContainer(AttributeRegistry.NATURE_SPELL_POWER, 0.2, AttributeModifier.Operation.ADD_MULTIPLIED_BASE)
    );

    public static HnSExtendedWeaponsTiers O_FORTUNA_T3 = new HnSExtendedWeaponsTiers(
            8064,
            9,
            -1.8F,
            10,
            BlockTags.INCORRECT_FOR_NETHERITE_TOOL,
            () -> Ingredient.of(HnSItemRegistry.ZENALITE_INGOT.get()),
            new AttributeContainer(AttributeRegistry.NATURE_SPELL_POWER, 0.25, AttributeModifier.Operation.ADD_MULTIPLIED_BASE)
    );

    /*
     *** Ender
     */

    public static HnSExtendedWeaponsTiers OBSIDIAN_CLAYMORE = new HnSExtendedWeaponsTiers(
            8064,
            9,
            -2.7F,
            10,
            BlockTags.INCORRECT_FOR_NETHERITE_TOOL,
            () -> Ingredient.of(HnSItemRegistry.ZENALITE_INGOT.get()),
            new AttributeContainer(ASAttributeRegistry.MANA_REND, .15, AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL),
            new AttributeContainer(ALObjects.Attributes.ARMOR_PIERCE, .1, AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL),
            new AttributeContainer(AttributeRegistry.ENDER_SPELL_POWER, .15, AttributeModifier.Operation.ADD_MULTIPLIED_BASE)
    );

    public static HnSExtendedWeaponsTiers STARFURY = new HnSExtendedWeaponsTiers(
            8064,
            9,
            -2.4F,
            10,
            BlockTags.INCORRECT_FOR_NETHERITE_TOOL,
            () -> Ingredient.of(HnSItemRegistry.ZENALITE_INGOT.get()),
            new AttributeContainer(ALObjects.Attributes.ARMOR_SHRED, .1, AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL),
            new AttributeContainer(ALObjects.Attributes.ARMOR_PIERCE, .1, AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL),
            new AttributeContainer(HnSAttributeRegistry.RADIANCE_SPELL_POWER, .15, AttributeModifier.Operation.ADD_MULTIPLIED_BASE)
    );

    public static HnSExtendedWeaponsTiers UMBRANOVA_DORMANT = new HnSExtendedWeaponsTiers(
            8064,
            6,
            -2F,
            10,
            BlockTags.INCORRECT_FOR_NETHERITE_TOOL,
            () -> Ingredient.of(HnSItemRegistry.ZENALITE_INGOT.get()),
            new AttributeContainer(AttributeRegistry.ENDER_SPELL_POWER, 0.1, AttributeModifier.Operation.ADD_MULTIPLIED_BASE)
    );

    public static HnSExtendedWeaponsTiers UMBRANOVA_T1 = new HnSExtendedWeaponsTiers(
            8064,
            7,
            -2F,
            10,
            BlockTags.INCORRECT_FOR_NETHERITE_TOOL,
            () -> Ingredient.of(HnSItemRegistry.ZENALITE_INGOT.get()),
            new AttributeContainer(AttributeRegistry.ENDER_SPELL_POWER, 0.15, AttributeModifier.Operation.ADD_MULTIPLIED_BASE)
    );

    public static HnSExtendedWeaponsTiers UMBRANOVA_T2 = new HnSExtendedWeaponsTiers(
            8064,
            8,
            -1.9F,
            10,
            BlockTags.INCORRECT_FOR_NETHERITE_TOOL,
            () -> Ingredient.of(HnSItemRegistry.ZENALITE_INGOT.get()),
            new AttributeContainer(AttributeRegistry.ENDER_SPELL_POWER, 0.2, AttributeModifier.Operation.ADD_MULTIPLIED_BASE)
    );

    public static HnSExtendedWeaponsTiers UMBRANOVA_T3 = new HnSExtendedWeaponsTiers(
            8064,
            9,
            -1.8F,
            10,
            BlockTags.INCORRECT_FOR_NETHERITE_TOOL,
            () -> Ingredient.of(HnSItemRegistry.ZENALITE_INGOT.get()),
            new AttributeContainer(AttributeRegistry.ENDER_SPELL_POWER, 0.25, AttributeModifier.Operation.ADD_MULTIPLIED_BASE)
    );

    /*
     *** Blood
     */

    public static HnSExtendedWeaponsTiers VAMPIRE_KNIVES = new HnSExtendedWeaponsTiers(
            8064,
            8,
            -1.7F,
            10,
            BlockTags.INCORRECT_FOR_NETHERITE_TOOL,
            () -> Ingredient.of(HnSItemRegistry.ZENALITE_INGOT.get()),
            new AttributeContainer(ALObjects.Attributes.ARMOR_SHRED, .15, AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL),
            new AttributeContainer(ALObjects.Attributes.LIFE_STEAL, .1, AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL),
            new AttributeContainer(AttributeRegistry.BLOOD_SPELL_POWER, .2, AttributeModifier.Operation.ADD_MULTIPLIED_BASE)
    );

    public static HnSExtendedWeaponsTiers DEVESTATOR_DORMANT = new HnSExtendedWeaponsTiers(
            8064,
            6,
            -2F,
            10,
            BlockTags.INCORRECT_FOR_NETHERITE_TOOL,
            () -> Ingredient.of(HnSItemRegistry.ZENALITE_INGOT.get()),
            new AttributeContainer(AttributeRegistry.BLOOD_SPELL_POWER, 0.1, AttributeModifier.Operation.ADD_MULTIPLIED_BASE)
    );

    public static HnSExtendedWeaponsTiers DEVESTATOR_T1 = new HnSExtendedWeaponsTiers(
            8064,
            7,
            -2F,
            10,
            BlockTags.INCORRECT_FOR_NETHERITE_TOOL,
            () -> Ingredient.of(HnSItemRegistry.ZENALITE_INGOT.get()),
            new AttributeContainer(AttributeRegistry.BLOOD_SPELL_POWER, 0.15, AttributeModifier.Operation.ADD_MULTIPLIED_BASE)
    );

    public static HnSExtendedWeaponsTiers DEVESTATOR_T2 = new HnSExtendedWeaponsTiers(
            8064,
            8,
            -1.9F,
            10,
            BlockTags.INCORRECT_FOR_NETHERITE_TOOL,
            () -> Ingredient.of(HnSItemRegistry.ZENALITE_INGOT.get()),
            new AttributeContainer(AttributeRegistry.BLOOD_SPELL_POWER, 0.2, AttributeModifier.Operation.ADD_MULTIPLIED_BASE)
    );

    public static HnSExtendedWeaponsTiers DEVESTATOR_T3 = new HnSExtendedWeaponsTiers(
            8064,
            9,
            -1.8F,
            10,
            BlockTags.INCORRECT_FOR_NETHERITE_TOOL,
            () -> Ingredient.of(HnSItemRegistry.ZENALITE_INGOT.get()),
            new AttributeContainer(AttributeRegistry.BLOOD_SPELL_POWER, 0.25, AttributeModifier.Operation.ADD_MULTIPLIED_BASE)
    );

    /*
     *** Eldritch
     */

    public static HnSExtendedWeaponsTiers THE_DEVOURER = new HnSExtendedWeaponsTiers(
            8064,
            13,
            -3.1F,
            10,
            BlockTags.INCORRECT_FOR_NETHERITE_TOOL,
            () -> Ingredient.of(HnSItemRegistry.ZENALITE_INGOT.get()),
            new AttributeContainer(ALObjects.Attributes.ARMOR_SHRED, .15, AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL),
            new AttributeContainer(ALObjects.Attributes.PROT_SHRED, .15, AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL),
            new AttributeContainer(ASAttributeRegistry.GOLIATH_SLAYER, .1, AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL),
            new AttributeContainer(ASAttributeRegistry.MANA_REND, .1, AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL),
            new AttributeContainer(AttributeRegistry.ELDRITCH_SPELL_POWER, .2, AttributeModifier.Operation.ADD_MULTIPLIED_BASE),
            new AttributeContainer(Attributes.ENTITY_INTERACTION_RANGE, 3, AttributeModifier.Operation.ADD_VALUE)
    );

    /*
     *** Radiance
     */

    public static HnSExtendedWeaponsTiers HAMMUSH = new HnSExtendedWeaponsTiers(
            8064,
            12,
            -2.6F,
            10,
            BlockTags.INCORRECT_FOR_NETHERITE_TOOL,
            () -> Ingredient.of(HnSItemRegistry.ZENALITE_INGOT.get()),
            new AttributeContainer(ALObjects.Attributes.ARMOR_SHRED, .15, AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL),
            new AttributeContainer(HnSAttributeRegistry.RADIANCE_SPELL_POWER, .15, AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL),
            new AttributeContainer(AttributeRegistry.NATURE_SPELL_POWER, .15, AttributeModifier.Operation.ADD_MULTIPLIED_BASE)
    );

    public static HnSExtendedWeaponsTiers SPECTRUM = new HnSExtendedWeaponsTiers(
            8064,
            11,
            -2.6F,
            10,
            BlockTags.INCORRECT_FOR_NETHERITE_TOOL,
            () -> Ingredient.of(HnSItemRegistry.ZENALITE_INGOT.get()),
            new AttributeContainer(ALObjects.Attributes.ARMOR_SHRED, .15, AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL),
            new AttributeContainer(HnSAttributeRegistry.RADIANCE_SPELL_POWER, 0.2, AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL),
            new AttributeContainer(ALObjects.Attributes.PROT_SHRED, .15, AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL),
            new AttributeContainer(ALObjects.Attributes.PROT_PIERCE, .15, AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL)
    );

    public static HnSExtendedWeaponsTiers MEOWMERE = new HnSExtendedWeaponsTiers(
            8064,
            11,
            -2.6F,
            10,
            BlockTags.INCORRECT_FOR_NETHERITE_TOOL,
            () -> Ingredient.of(HnSItemRegistry.ZENALITE_INGOT.get()),
            new AttributeContainer(ALObjects.Attributes.ARMOR_SHRED, .15, AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL),
            new AttributeContainer(ALObjects.Attributes.PROT_PIERCE, .15, AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL),
            new AttributeContainer(ALObjects.Attributes.PROT_SHRED, .15, AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL),
            new AttributeContainer(HnSAttributeRegistry.RADIANCE_SPELL_POWER, 0.2, AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL)
    );

    public static HnSExtendedWeaponsTiers TERRAPRISMA = new HnSExtendedWeaponsTiers(
            8064,
            10,
            -2.7F,
            10,
            BlockTags.INCORRECT_FOR_NETHERITE_TOOL,
            () -> Ingredient.of(HnSItemRegistry.ZENALITE_INGOT.get()),
            new AttributeContainer(ALObjects.Attributes.ARMOR_SHRED, .15, AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL),
            new AttributeContainer(ALObjects.Attributes.PROT_PIERCE, .15, AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL),
            new AttributeContainer(ALObjects.Attributes.PROT_SHRED, .15, AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL),
            new AttributeContainer(HnSAttributeRegistry.RADIANCE_SPELL_POWER, 0.2, AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL)
    );

    /*
     *** Shadow
     */

    public static HnSExtendedWeaponsTiers LIGHTS_BANE = new HnSExtendedWeaponsTiers(
            8064,
            8,
            -1.7F,
            10,
            BlockTags.INCORRECT_FOR_NETHERITE_TOOL,
            () -> Ingredient.of(HnSItemRegistry.ZENALITE_INGOT.get()),
            new AttributeContainer(HnSAttributeRegistry.SHADOW_SPELL_POWER, .1, AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL)
    );

    public static HnSExtendedWeaponsTiers NIGHTS_EDGE = new HnSExtendedWeaponsTiers(
            8064,
            10,
            -2.7F,
            10,
            BlockTags.INCORRECT_FOR_NETHERITE_TOOL,
            () -> Ingredient.of(HnSItemRegistry.ZENALITE_INGOT.get()),
            new AttributeContainer(ALObjects.Attributes.ARMOR_SHRED, .1, AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL),
            new AttributeContainer(AttributeRegistry.SPELL_POWER, .15, AttributeModifier.Operation.ADD_MULTIPLIED_BASE)
    );

    public static HnSExtendedWeaponsTiers TRUE_NIGHTS_EDGE = new HnSExtendedWeaponsTiers(
            8064,
            12,
            -2.8F,
            10,
            BlockTags.INCORRECT_FOR_NETHERITE_TOOL,
            () -> Ingredient.of(HnSItemRegistry.ZENALITE_INGOT.get()),
            new AttributeContainer(ALObjects.Attributes.ARMOR_SHRED, .15, AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL),
            new AttributeContainer(ALObjects.Attributes.PROT_SHRED, .15, AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL),
            new AttributeContainer(ALObjects.Attributes.CRIT_CHANCE, .2, AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL),
            new AttributeContainer(AttributeRegistry.SPELL_POWER, .2, AttributeModifier.Operation.ADD_MULTIPLIED_BASE)
    );

    /*
     *** Misc
     */

    public static HnSExtendedWeaponsTiers MITHRIL = new HnSExtendedWeaponsTiers(
            4032,
            6,
            -3F,
            10,
            BlockTags.INCORRECT_FOR_NETHERITE_TOOL,
            () -> Ingredient.of(ItemRegistry.MITHRIL_SCRAP.get()),
            new AttributeContainer(AttributeRegistry.SPELL_POWER, 0.1, AttributeModifier.Operation.ADD_MULTIPLIED_BASE)
    );

    public static HnSExtendedWeaponsTiers SPECTRAL_PICKAXE = new HnSExtendedWeaponsTiers(
            4032,
            6,
            -3F,
            10,
            BlockTags.INCORRECT_FOR_NETHERITE_TOOL,
            () -> Ingredient.of(ItemRegistry.MITHRIL_SCRAP.get()),
            new AttributeContainer(AttributeRegistry.EVOCATION_SPELL_POWER, 0.1, AttributeModifier.Operation.ADD_MULTIPLIED_BASE)
    );

    public static HnSExtendedWeaponsTiers PICKAXE_AXE = new HnSExtendedWeaponsTiers(
            4032,
            6,
            -3F,
            10,
            HnSTags.Blocks.INCORRECT_FOR_MITHRIL_TOOl,
            () -> Ingredient.of(ItemRegistry.MITHRIL_SCRAP.get()),
            new AttributeContainer(AttributeRegistry.HOLY_SPELL_POWER, 0.1, AttributeModifier.Operation.ADD_MULTIPLIED_BASE)
    );

    public static HnSExtendedWeaponsTiers MAGE_BANE = new HnSExtendedWeaponsTiers(
            8064,
            8,
            -2.7F,
            10,
            BlockTags.INCORRECT_FOR_NETHERITE_TOOL,
            () -> Ingredient.of(HnSItemRegistry.ZENALITE_INGOT.get()),
            new AttributeContainer(ALObjects.Attributes.ARMOR_PIERCE, .15, AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL),
            new AttributeContainer(AttributeRegistry.SPELL_RESIST, .15, AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL),
            new AttributeContainer(ASAttributeRegistry.MANA_REND, .15, AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL),
            new AttributeContainer(ASAttributeRegistry.SPELL_RES_PENETRATION, .15, AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL)
    );

    public static HnSExtendedWeaponsTiers LEGIONNAIRE_WARLOCK_AXE = new HnSExtendedWeaponsTiers(
            8064,
            11,
            -3F,
            10,
            BlockTags.INCORRECT_FOR_NETHERITE_TOOL,
            () -> Ingredient.of(HnSItemRegistry.ZENALITE_INGOT.get()),
            new AttributeContainer(ALObjects.Attributes.ARMOR_PIERCE, .15, AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL),
            new AttributeContainer(AttributeRegistry.SPELL_RESIST, .1, AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL),
            new AttributeContainer(ASAttributeRegistry.MANA_REND, .15, AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL),
            new AttributeContainer(ASAttributeRegistry.SPELL_RES_PENETRATION, .15, AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL)
    );

    public static HnSExtendedWeaponsTiers DAWNMAKER = new HnSExtendedWeaponsTiers(
            8064,
            7,
            -2.4F,
            10,
            BlockTags.INCORRECT_FOR_NETHERITE_TOOL,
            () -> Ingredient.of(HnSItemRegistry.ZENALITE_INGOT.get()),
            new AttributeContainer(AttributeRegistry.SPELL_RESIST, .1, AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL),
            new AttributeContainer(ASAttributeRegistry.MANA_REND, .1, AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL)
    );

    public static HnSExtendedWeaponsTiers MURAMASA = new HnSExtendedWeaponsTiers(
            8064,
            6,
            -2.4F,
            10,
            BlockTags.INCORRECT_FOR_DIAMOND_TOOL,
            () -> Ingredient.of(HnSItemRegistry.ZENALITE_INGOT.get()),
            new AttributeContainer(ALObjects.Attributes.ARMOR_PIERCE, .05, AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL)
    );

    //private final int level;
    int uses;
    float damage;
    float speed;
    int enchantmentValue;
    TagKey<Block> incorrectBlocksForDrops;
    Supplier<Ingredient> repairIngredient;
    AttributeContainer[] attributes;

    private HnSExtendedWeaponsTiers(int uses, float damage, float speed, int enchantmentValue, TagKey<Block> incorrectBlocksForDrops, Supplier<Ingredient> repairIngredient, AttributeContainer... attributes) {
        this.uses = uses;
        this.damage = damage;
        this.speed = speed;
        this.enchantmentValue = enchantmentValue;
        this.incorrectBlocksForDrops = incorrectBlocksForDrops;
        this.repairIngredient = repairIngredient;
        this.attributes = attributes;
    }



    public AttributeContainer[] getAdditionalAttributes() {
        return this.attributes;
    }

    @Override
    public int getUses() {
        return uses;
    }

    @Override
    public float getSpeed() {
        return speed;
    }

    @Override
    public float getAttackDamageBonus() {
        return damage;
    }

    @Override
    public TagKey<Block> getIncorrectBlocksForDrops() {
        return incorrectBlocksForDrops;
    }

    @Override
    public int getEnchantmentValue() {
        return enchantmentValue;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return this.repairIngredient.get();
    }
}