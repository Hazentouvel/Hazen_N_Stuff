package net.hazen.hazennstuff.item.weapons;

import dev.shadowsoffire.apothic_attributes.api.ALObjects;
import io.redspace.ironsspellbooks.api.registry.AttributeRegistry;
import io.redspace.ironsspellbooks.item.weapons.AttributeContainer;
import io.redspace.ironsspellbooks.item.weapons.IronsWeaponTier;
import io.redspace.ironsspellbooks.registries.ItemRegistry;
import net.hazen.hazennstuff.registries.HnSAttributeRegistry;
import net.hazen.hazennstuff.registries.HnSDamageTypes;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.block.Block;
import net.hazen.hazennstuff.registries.HnSItems;
import java.util.function.Supplier;

public class HNSExtendedWeaponsTiers implements Tier, IronsWeaponTier {
    //  Ice Pike
    public static HNSExtendedWeaponsTiers ICE_PIKE = new HNSExtendedWeaponsTiers(
            8064,
            10,
            -3.0F,
            10,
            BlockTags.INCORRECT_FOR_NETHERITE_TOOL,
            () -> Ingredient.of(HnSItems.ZENALITE_INGOT.get()),
            new AttributeContainer(AttributeRegistry.ICE_SPELL_POWER, 0.20, AttributeModifier.Operation.ADD_MULTIPLIED_BASE),
            new AttributeContainer(ALObjects.Attributes.COLD_DAMAGE, 3, AttributeModifier.Operation.ADD_VALUE),
            new AttributeContainer(Attributes.ENTITY_INTERACTION_RANGE, 2, AttributeModifier.Operation.ADD_VALUE),
            new AttributeContainer(Attributes.ATTACK_SPEED, -0.3, AttributeModifier.Operation.ADD_VALUE)
    );

    //  Fireblossom Rapier - Feel free to change the values, I just have this for testing purposes
    public static HNSExtendedWeaponsTiers FIREBLOSSOM_RAPIER = new HNSExtendedWeaponsTiers(
            8064,
            8,
            -3.0F,
            10,
            BlockTags.INCORRECT_FOR_NETHERITE_TOOL,
            () -> Ingredient.of(HnSItems.ZENALITE_INGOT.get()),
            new AttributeContainer(AttributeRegistry.FIRE_SPELL_POWER, 0.20, AttributeModifier.Operation.ADD_MULTIPLIED_BASE),
            new AttributeContainer(AttributeRegistry.NATURE_SPELL_POWER, 0.20, AttributeModifier.Operation.ADD_MULTIPLIED_BASE),
            new AttributeContainer(Attributes.ATTACK_SPEED, 1.3, AttributeModifier.Operation.ADD_VALUE),
            new AttributeContainer(ALObjects.Attributes.FIRE_DAMAGE, 3, AttributeModifier.Operation.ADD_VALUE),
            new AttributeContainer(Attributes.ENTITY_INTERACTION_RANGE, 2, AttributeModifier.Operation.ADD_VALUE)
    );

    //  Beongae
    public static HNSExtendedWeaponsTiers BEONGAE = new HNSExtendedWeaponsTiers(
            8064,
            7,
            -3.0F,
            10,
            BlockTags.INCORRECT_FOR_NETHERITE_TOOL,
            () -> Ingredient.of(HnSItems.ZENALITE_INGOT.get()),
            new AttributeContainer(AttributeRegistry.LIGHTNING_SPELL_POWER, 0.1, AttributeModifier.Operation.ADD_MULTIPLIED_BASE),
            new AttributeContainer(ALObjects.Attributes.CRIT_DAMAGE, .1, AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL),
            new AttributeContainer(Attributes.ATTACK_SPEED, -0.2, AttributeModifier.Operation.ADD_VALUE)
    );

    //  Ancient Warrior's Axe
    public static HNSExtendedWeaponsTiers ANCIENT_WARRIORS_AXE = new HNSExtendedWeaponsTiers(
            8064,
            9,
            -3.0F,
            10,
            BlockTags.INCORRECT_FOR_NETHERITE_TOOL,
            () -> Ingredient.of(HnSItems.ZENALITE_INGOT.get()),
            new AttributeContainer(AttributeRegistry.EVOCATION_SPELL_POWER, 0.1, AttributeModifier.Operation.ADD_MULTIPLIED_BASE),
            new AttributeContainer(ALObjects.Attributes.CRIT_DAMAGE, .15, AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL)
    );

    public static HNSExtendedWeaponsTiers MITHRIL = new HNSExtendedWeaponsTiers(
            4032,
            6,
            5.0F,
            10,
            BlockTags.INCORRECT_FOR_NETHERITE_TOOL,
            () -> Ingredient.of(ItemRegistry.MITHRIL_SCRAP.get()),
            new AttributeContainer(AttributeRegistry.EVOCATION_SPELL_POWER, 0.1, AttributeModifier.Operation.ADD_MULTIPLIED_BASE)
    );

    public static HNSExtendedWeaponsTiers SKYSCORCHER = new HNSExtendedWeaponsTiers(
            8064,
            9,
            -3.0F,
            10,
            BlockTags.INCORRECT_FOR_NETHERITE_TOOL,
            () -> Ingredient.of(HnSItems.ZENALITE_INGOT.get()),
            new AttributeContainer(AttributeRegistry.LIGHTNING_SPELL_POWER, 0.20, AttributeModifier.Operation.ADD_MULTIPLIED_BASE),
            new AttributeContainer(ALObjects.Attributes.CRIT_DAMAGE, .25, AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL),
            new AttributeContainer(ALObjects.Attributes.CRIT_CHANCE, .5, AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL),
            new AttributeContainer(Attributes.ATTACK_SPEED, -0.3, AttributeModifier.Operation.ADD_VALUE)
    );

    public static HNSExtendedWeaponsTiers BOUNTIFUL_HARVEST = new HNSExtendedWeaponsTiers(
            8064,
            13,
            -3.0F,
            10,
            BlockTags.INCORRECT_FOR_NETHERITE_TOOL,
            () -> Ingredient.of(HnSItems.ZENALITE_INGOT.get()),
            new AttributeContainer(AttributeRegistry.NATURE_SPELL_POWER, 0.2, AttributeModifier.Operation.ADD_MULTIPLIED_BASE),
            new AttributeContainer(ALObjects.Attributes.PROT_PIERCE, .1, AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL),
            new AttributeContainer(ALObjects.Attributes.ARMOR_PIERCE, .1, AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL),
            new AttributeContainer(Attributes.ATTACK_SPEED, -0.4, AttributeModifier.Operation.ADD_VALUE)
    );

    public static HNSExtendedWeaponsTiers STARFURY = new HNSExtendedWeaponsTiers(
            8064,
            9,
            -3.0F,
            10,
            BlockTags.INCORRECT_FOR_NETHERITE_TOOL,
            () -> Ingredient.of(HnSItems.ZENALITE_INGOT.get()),
            new AttributeContainer(ALObjects.Attributes.PROT_PIERCE, .1, AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL),
            new AttributeContainer(ALObjects.Attributes.ARMOR_PIERCE, .1, AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL),
            new AttributeContainer(AttributeRegistry.ENDER_SPELL_POWER, .05, AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL),
            new AttributeContainer(Attributes.ATTACK_SPEED, 0.8, AttributeModifier.Operation.ADD_VALUE)
    );


    public static HNSExtendedWeaponsTiers HAMMER_OF_JUSTICE = new HNSExtendedWeaponsTiers(
            8064,
            9,
            -3.0F,
            10,
            BlockTags.INCORRECT_FOR_NETHERITE_TOOL,
            () -> Ingredient.of(HnSItems.ZENALITE_INGOT.get()),
            new AttributeContainer(ALObjects.Attributes.PROT_PIERCE, .1, AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL),
            new AttributeContainer(ALObjects.Attributes.ARMOR_PIERCE, .1, AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL),
            new AttributeContainer(AttributeRegistry.HOLY_SPELL_POWER, .15, AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL),
            new AttributeContainer(Attributes.ATTACK_SPEED, -0.3, AttributeModifier.Operation.ADD_VALUE)
    );

    public static HNSExtendedWeaponsTiers LIGHTS_BANE = new HNSExtendedWeaponsTiers(
            8064,
            9,
            -3.0F,
            10,
            BlockTags.INCORRECT_FOR_NETHERITE_TOOL,
            () -> Ingredient.of(HnSItems.ZENALITE_INGOT.get()),
            new AttributeContainer(HnSAttributeRegistry.DARK_MAGIC_POWER, .5, AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL),
            new AttributeContainer(Attributes.ATTACK_SPEED, .8 , AttributeModifier.Operation.ADD_VALUE)
    );

    public static HNSExtendedWeaponsTiers NIGHTS_EDGE = new HNSExtendedWeaponsTiers(
            8064,
            10,
            -3.0F,
            10,
            BlockTags.INCORRECT_FOR_NETHERITE_TOOL,
            () -> Ingredient.of(HnSItems.ZENALITE_INGOT.get()),
            new AttributeContainer(ALObjects.Attributes.ARMOR_SHRED, .1, AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL),
            new AttributeContainer(ALObjects.Attributes.PROT_SHRED, .1, AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL),
            new AttributeContainer(HnSAttributeRegistry.DARK_MAGIC_POWER, .15, AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL),
            new AttributeContainer(Attributes.ATTACK_SPEED, -0.3, AttributeModifier.Operation.ADD_VALUE)
    );

    public static HNSExtendedWeaponsTiers TRUE_NIGHTS_EDGE = new HNSExtendedWeaponsTiers(
            8064,
            12,
            -3.0F,
            10,
            BlockTags.INCORRECT_FOR_NETHERITE_TOOL,
            () -> Ingredient.of(HnSItems.ZENALITE_INGOT.get()),
            new AttributeContainer(ALObjects.Attributes.ARMOR_SHRED, .15, AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL),
            new AttributeContainer(ALObjects.Attributes.PROT_SHRED, .15, AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL),
            new AttributeContainer(ALObjects.Attributes.CRIT_CHANCE, .2, AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL),
            new AttributeContainer(HnSAttributeRegistry.DARK_MAGIC_POWER, .2, AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL),
            new AttributeContainer(Attributes.ATTACK_SPEED, -0.4, AttributeModifier.Operation.ADD_VALUE)
    );

    public static HNSExtendedWeaponsTiers VAMPIRE_KNIVES = new HNSExtendedWeaponsTiers(
            8064,
            7,
            -3.0F,
            10,
            BlockTags.INCORRECT_FOR_NETHERITE_TOOL,
            () -> Ingredient.of(HnSItems.ZENALITE_INGOT.get()),
            new AttributeContainer(ALObjects.Attributes.ARMOR_SHRED, .15, AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL),
            new AttributeContainer(ALObjects.Attributes.LIFE_STEAL, .1, AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL),
            new AttributeContainer(AttributeRegistry.BLOOD_SPELL_POWER, .2, AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL),
            new AttributeContainer(Attributes.ATTACK_SPEED, 1, AttributeModifier.Operation.ADD_VALUE)
    );

    //private final int level;
    private final int uses;
    private final float speed;
    private final float damage;
    private final int enchantmentValue;
    private final TagKey<Block> incorrectBlocksForDrops;
    private final Supplier<Ingredient> repairIngredient;
    private final AttributeContainer[] attributeContainers;

    private HNSExtendedWeaponsTiers(int uses, float damage, float speed, int enchantmentValue, TagKey<Block> incorrectBlocksForDrops, Supplier<Ingredient> repairIngredient, AttributeContainer... attributes) {
        //this.level = level;
        this.uses = uses;
        this.speed = speed;
        this.damage = damage;
        this.enchantmentValue = enchantmentValue;
        this.incorrectBlocksForDrops = incorrectBlocksForDrops;
        this.repairIngredient = repairIngredient;
        this.attributeContainers = attributes;
    }

    @Override
    public AttributeContainer[] getAdditionalAttributes() {
        return this.attributeContainers;
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