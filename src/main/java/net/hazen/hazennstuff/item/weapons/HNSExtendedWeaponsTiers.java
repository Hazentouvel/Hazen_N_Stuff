package net.hazen.hazennstuff.item.weapons;

import dev.shadowsoffire.apothic_attributes.api.ALObjects;
import io.redspace.ironsspellbooks.api.registry.AttributeRegistry;
import io.redspace.ironsspellbooks.item.weapons.AttributeContainer;
import io.redspace.ironsspellbooks.item.weapons.IronsWeaponTier;
import io.redspace.ironsspellbooks.registries.ItemRegistry;
import net.acetheeldritchking.aces_spell_utils.registries.ASAttributeRegistry;
import net.hazen.hazennstuff.registries.HnSAttributeRegistry;
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

    /*
    *** Ice
    */

    public static HNSExtendedWeaponsTiers ICE_PIKE = new HNSExtendedWeaponsTiers(
            8064,
            10,
            -3.0F,
            10,
            BlockTags.INCORRECT_FOR_NETHERITE_TOOL,
            () -> Ingredient.of(HnSItems.ZENALITE_INGOT.get()),
            new AttributeContainer(AttributeRegistry.ICE_SPELL_POWER, 0.15, AttributeModifier.Operation.ADD_MULTIPLIED_BASE),
            new AttributeContainer(ALObjects.Attributes.COLD_DAMAGE, 5, AttributeModifier.Operation.ADD_VALUE),
            new AttributeContainer(Attributes.ENTITY_INTERACTION_RANGE, 2, AttributeModifier.Operation.ADD_VALUE),
            new AttributeContainer(Attributes.ATTACK_SPEED, -0.3, AttributeModifier.Operation.ADD_VALUE)
    );

    public static HNSExtendedWeaponsTiers FROSTBURN_DAGGER = new HNSExtendedWeaponsTiers(
            8064,
            7,
            -3.0F,
            10,
            BlockTags.INCORRECT_FOR_NETHERITE_TOOL,
            () -> Ingredient.of(HnSItems.ZENALITE_INGOT.get()),
            new AttributeContainer(AttributeRegistry.ICE_SPELL_POWER, 0.20, AttributeModifier.Operation.ADD_MULTIPLIED_BASE),
            new AttributeContainer(ALObjects.Attributes.COLD_DAMAGE, 3, AttributeModifier.Operation.ADD_VALUE),
            new AttributeContainer(Attributes.ATTACK_SPEED, 0.4, AttributeModifier.Operation.ADD_VALUE)
    );

    /*
    *** Fire
     */

    public static HNSExtendedWeaponsTiers DRACONIC_SPLITTER = new HNSExtendedWeaponsTiers(
            8064,
            7,
            -3.0F,
            10,
            BlockTags.INCORRECT_FOR_NETHERITE_TOOL,
            () -> Ingredient.of(HnSItems.ZENALITE_INGOT.get()),
            new AttributeContainer(AttributeRegistry.FIRE_SPELL_POWER, 0.15, AttributeModifier.Operation.ADD_MULTIPLIED_BASE),
            new AttributeContainer(ALObjects.Attributes.FIRE_DAMAGE, 5, AttributeModifier.Operation.ADD_VALUE),
            new AttributeContainer(Attributes.ENTITY_INTERACTION_RANGE, 2, AttributeModifier.Operation.ADD_VALUE),
            new AttributeContainer(Attributes.ATTACK_SPEED, -0.3, AttributeModifier.Operation.ADD_VALUE)
    );

    public static HNSExtendedWeaponsTiers FIREBRAND = new HNSExtendedWeaponsTiers(
            8064,
            7,
            -3.0F,
            10,
            BlockTags.INCORRECT_FOR_NETHERITE_TOOL,
            () -> Ingredient.of(HnSItems.ZENALITE_INGOT.get()),
            new AttributeContainer(AttributeRegistry.FIRE_SPELL_POWER, 0.15, AttributeModifier.Operation.ADD_MULTIPLIED_BASE),
            new AttributeContainer(ALObjects.Attributes.FIRE_DAMAGE, 5, AttributeModifier.Operation.ADD_VALUE),
            new AttributeContainer(Attributes.ENTITY_INTERACTION_RANGE, 2, AttributeModifier.Operation.ADD_VALUE),
            new AttributeContainer(Attributes.ATTACK_SPEED, -0.3, AttributeModifier.Operation.ADD_VALUE)
    );

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

    /*
    *** Lightning
     */

    public static HNSExtendedWeaponsTiers BEONGAE = new HNSExtendedWeaponsTiers(
            8064,
            7,
            -3.0F,
            10,
            BlockTags.INCORRECT_FOR_NETHERITE_TOOL,
            () -> Ingredient.of(HnSItems.ZENALITE_INGOT.get()),
            new AttributeContainer(AttributeRegistry.LIGHTNING_SPELL_POWER, 0.1, AttributeModifier.Operation.ADD_MULTIPLIED_BASE),
            new AttributeContainer(ALObjects.Attributes.CRIT_DAMAGE, .05, AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL),
            new AttributeContainer(Attributes.ATTACK_SPEED, -0.2, AttributeModifier.Operation.ADD_VALUE)
    );

    public static HNSExtendedWeaponsTiers SKYSCORCHER = new HNSExtendedWeaponsTiers(
            8064,
            9,
            -3.0F,
            10,
            BlockTags.INCORRECT_FOR_NETHERITE_TOOL,
            () -> Ingredient.of(HnSItems.ZENALITE_INGOT.get()),
            new AttributeContainer(AttributeRegistry.LIGHTNING_SPELL_POWER, 0.15, AttributeModifier.Operation.ADD_MULTIPLIED_BASE),
            new AttributeContainer(ALObjects.Attributes.CRIT_DAMAGE, .25, AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL),
            new AttributeContainer(ALObjects.Attributes.CRIT_CHANCE, .15, AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL),
            new AttributeContainer(Attributes.ATTACK_SPEED, -0.3, AttributeModifier.Operation.ADD_VALUE)
    );

    /*
    *** Evocation
     */

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

    public static HNSExtendedWeaponsTiers MALICE = new HNSExtendedWeaponsTiers(
            8064,
            7,
            -3.0F,
            10,
            BlockTags.INCORRECT_FOR_NETHERITE_TOOL,
            () -> Ingredient.of(HnSItems.ZENALITE_INGOT.get()),
            new AttributeContainer(ALObjects.Attributes.ARMOR_SHRED, .1, AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL),
            new AttributeContainer(ALObjects.Attributes.PROT_PIERCE, .1, AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL),
            new AttributeContainer(ALObjects.Attributes.CRIT_CHANCE, .15, AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL),
            new AttributeContainer(AttributeRegistry.EVOCATION_SPELL_POWER, .2, AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL)
    );

    /*
    *** Holy
     */

    public static HNSExtendedWeaponsTiers HAMMER_OF_JUSTICE = new HNSExtendedWeaponsTiers(
            8064,
            9,
            -3.0F,
            10,
            BlockTags.INCORRECT_FOR_NETHERITE_TOOL,
            () -> Ingredient.of(HnSItems.ZENALITE_INGOT.get()),
            new AttributeContainer(ASAttributeRegistry.SPELL_RES_PENETRATION, .1, AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL),
            new AttributeContainer(ALObjects.Attributes.ARMOR_PIERCE, .1, AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL),
            new AttributeContainer(ALObjects.Attributes.ARMOR_SHRED, .1, AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL),
            new AttributeContainer(AttributeRegistry.HOLY_SPELL_POWER, .15, AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL),
            new AttributeContainer(Attributes.ATTACK_SPEED, -0.3, AttributeModifier.Operation.ADD_VALUE)
    );

    public static HNSExtendedWeaponsTiers EXCALIBUR = new HNSExtendedWeaponsTiers(
            8064,
            7,
            -3.0F,
            10,
            BlockTags.INCORRECT_FOR_NETHERITE_TOOL,
            () -> Ingredient.of(HnSItems.ZENALITE_INGOT.get()),
            new AttributeContainer(ASAttributeRegistry.SPELL_RES_PENETRATION, .1, AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL),
            new AttributeContainer(ALObjects.Attributes.ARMOR_SHRED, .1, AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL),
            new AttributeContainer(ALObjects.Attributes.PROT_SHRED, .1, AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL),
            new AttributeContainer(AttributeRegistry.HOLY_SPELL_POWER, .15, AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL),
            new AttributeContainer(Attributes.ATTACK_SPEED, -0.3, AttributeModifier.Operation.ADD_VALUE)
    );

    public static HNSExtendedWeaponsTiers DIVINE_GREATSWORD = new HNSExtendedWeaponsTiers(
            8064,
            7,
            -3.0F,
            10,
            BlockTags.INCORRECT_FOR_NETHERITE_TOOL,
            () -> Ingredient.of(HnSItems.ZENALITE_INGOT.get()),
            new AttributeContainer(ALObjects.Attributes.PROT_PIERCE, .1, AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL),
            new AttributeContainer(ALObjects.Attributes.ARMOR_PIERCE, .1, AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL),
            new AttributeContainer(AttributeRegistry.HOLY_SPELL_POWER, .1, AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL),
            new AttributeContainer(Attributes.ATTACK_SPEED, -0.3, AttributeModifier.Operation.ADD_VALUE)

    );


    /*
    *** Nature
     */

    public static HNSExtendedWeaponsTiers BOUNTIFUL_HARVEST = new HNSExtendedWeaponsTiers(
            8064,
            13,
            -3.0F,
            10,
            BlockTags.INCORRECT_FOR_NETHERITE_TOOL,
            () -> Ingredient.of(HnSItems.ZENALITE_INGOT.get()),
            new AttributeContainer(AttributeRegistry.NATURE_SPELL_POWER, 0.15, AttributeModifier.Operation.ADD_MULTIPLIED_BASE),
            new AttributeContainer(ALObjects.Attributes.PROT_PIERCE, .1, AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL),
            new AttributeContainer(ALObjects.Attributes.ARMOR_PIERCE, .1, AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL),
            new AttributeContainer(Attributes.ATTACK_SPEED, -0.3, AttributeModifier.Operation.ADD_VALUE)
    );

    public static HNSExtendedWeaponsTiers THORN_CHAKRAM = new HNSExtendedWeaponsTiers(
            8064,
            7,
            1.2F,
            10,
            BlockTags.INCORRECT_FOR_NETHERITE_TOOL,
            () -> Ingredient.of(HnSItems.ZENALITE_INGOT.get()),
            new AttributeContainer(AttributeRegistry.NATURE_SPELL_POWER, 0.15, AttributeModifier.Operation.ADD_MULTIPLIED_BASE),
            new AttributeContainer(ALObjects.Attributes.ARMOR_SHRED, .1, AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL),
            new AttributeContainer(ALObjects.Attributes.PROT_SHRED, .1, AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL)
    );

    /*
    *** Ender
     */

    public static HNSExtendedWeaponsTiers OBSIDIAN_CLAYMORE = new HNSExtendedWeaponsTiers(
            8064,
            7,
            -3.0F,
            10,
            BlockTags.INCORRECT_FOR_NETHERITE_TOOL,
            () -> Ingredient.of(HnSItems.ZENALITE_INGOT.get()),
            new AttributeContainer(ASAttributeRegistry.MANA_REND, .15, AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL),
            new AttributeContainer(ALObjects.Attributes.ARMOR_PIERCE, .1, AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL),
            new AttributeContainer(AttributeRegistry.ENDER_SPELL_POWER, .15, AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL),
            new AttributeContainer(Attributes.ATTACK_SPEED, -0.3, AttributeModifier.Operation.ADD_VALUE)
    );

    public static HNSExtendedWeaponsTiers STARFURY = new HNSExtendedWeaponsTiers(
            8064,
            9,
            -3.0F,
            10,
            BlockTags.INCORRECT_FOR_NETHERITE_TOOL,
            () -> Ingredient.of(HnSItems.ZENALITE_INGOT.get()),
            new AttributeContainer(ALObjects.Attributes.ARMOR_SHRED, .1, AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL),
            new AttributeContainer(ALObjects.Attributes.ARMOR_PIERCE, .1, AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL),
            new AttributeContainer(AttributeRegistry.ENDER_SPELL_POWER, .05, AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL),
            new AttributeContainer(Attributes.ATTACK_SPEED, 0.8, AttributeModifier.Operation.ADD_VALUE)
    );

    /*
    *** Blood
     */

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

    /*
    *** Eldritch
     */

    public static HNSExtendedWeaponsTiers THE_DEVOURER = new HNSExtendedWeaponsTiers(
            8064,
            13,
            -3.0F,
            10,
            BlockTags.INCORRECT_FOR_NETHERITE_TOOL,
            () -> Ingredient.of(HnSItems.ZENALITE_INGOT.get()),
            new AttributeContainer(ALObjects.Attributes.ARMOR_SHRED, .15, AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL),
            new AttributeContainer(ALObjects.Attributes.PROT_SHRED, .15, AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL),
            new AttributeContainer(ASAttributeRegistry.GOLIATH_SLAYER, .1, AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL),
            new AttributeContainer(ASAttributeRegistry.MANA_REND, .1, AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL),
            new AttributeContainer(AttributeRegistry.ELDRITCH_SPELL_POWER, .2, AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL),
            new AttributeContainer(Attributes.ENTITY_INTERACTION_RANGE, 3, AttributeModifier.Operation.ADD_VALUE),
            new AttributeContainer(Attributes.ATTACK_SPEED, -0.8, AttributeModifier.Operation.ADD_VALUE)
    );

    /*
    *** Radiance
    */

    public static HNSExtendedWeaponsTiers HAMMUSH = new HNSExtendedWeaponsTiers(
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

    public static HNSExtendedWeaponsTiers SPECTRUM = new HNSExtendedWeaponsTiers(
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

    public static HNSExtendedWeaponsTiers MEOWMERE = new HNSExtendedWeaponsTiers(
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

    /*
    *** Shadow
     */

    public static HNSExtendedWeaponsTiers LIGHTS_BANE = new HNSExtendedWeaponsTiers(
            8064,
            9,
            -3.0F,
            10,
            BlockTags.INCORRECT_FOR_NETHERITE_TOOL,
            () -> Ingredient.of(HnSItems.ZENALITE_INGOT.get()),
            new AttributeContainer(HnSAttributeRegistry.SHADOW_MAGIC_POWER, .1, AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL),
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
            new AttributeContainer(HnSAttributeRegistry.SHADOW_MAGIC_POWER, .15, AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL),
            new AttributeContainer(AttributeRegistry.FIRE_SPELL_POWER, .15, AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL),
            new AttributeContainer(AttributeRegistry.NATURE_SPELL_POWER, .15, AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL),
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
            new AttributeContainer(HnSAttributeRegistry.SHADOW_MAGIC_POWER, .2, AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL),
            new AttributeContainer(AttributeRegistry.FIRE_SPELL_POWER, .2, AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL),
            new AttributeContainer(AttributeRegistry.NATURE_SPELL_POWER, .2, AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL),
            new AttributeContainer(Attributes.ATTACK_SPEED, -0.5, AttributeModifier.Operation.ADD_VALUE)
    );

    /*
    *** Misc
     */

    public static HNSExtendedWeaponsTiers MITHRIL = new HNSExtendedWeaponsTiers(
            4032,
            6,
            5.0F,
            10,
            BlockTags.INCORRECT_FOR_NETHERITE_TOOL,
            () -> Ingredient.of(ItemRegistry.MITHRIL_SCRAP.get()),
            new AttributeContainer(AttributeRegistry.SPELL_POWER, 0.1, AttributeModifier.Operation.ADD_MULTIPLIED_BASE)
    );

    public static HNSExtendedWeaponsTiers SPECTRAL_PICKAXE = new HNSExtendedWeaponsTiers(
            4032,
            6,
            5.0F,
            10,
            BlockTags.INCORRECT_FOR_NETHERITE_TOOL,
            () -> Ingredient.of(ItemRegistry.MITHRIL_SCRAP.get()),
            new AttributeContainer(AttributeRegistry.EVOCATION_SPELL_POWER, 0.1, AttributeModifier.Operation.ADD_MULTIPLIED_BASE)
    );

    public static HNSExtendedWeaponsTiers MAGE_BANE = new HNSExtendedWeaponsTiers(
            8064,
            8,
            -3.0F,
            10,
            BlockTags.INCORRECT_FOR_NETHERITE_TOOL,
            () -> Ingredient.of(HnSItems.ZENALITE_INGOT.get()),
            new AttributeContainer(ALObjects.Attributes.ARMOR_PIERCE, .15, AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL),
            new AttributeContainer(AttributeRegistry.SPELL_RESIST, .15, AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL),
            new AttributeContainer(Attributes.ATTACK_SPEED, -3, AttributeModifier.Operation.ADD_VALUE),
            new AttributeContainer(ASAttributeRegistry.MANA_REND, .15, AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL),
            new AttributeContainer(ASAttributeRegistry.SPELL_RES_PENETRATION, .15, AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL)
    );

    public static HNSExtendedWeaponsTiers LEGIONNAIRE_WARLOCK_AXE = new HNSExtendedWeaponsTiers(
            8064,
            11,
            -3F,
            10,
            BlockTags.INCORRECT_FOR_NETHERITE_TOOL,
            () -> Ingredient.of(HnSItems.ZENALITE_INGOT.get()),
            new AttributeContainer(ALObjects.Attributes.ARMOR_PIERCE, .15, AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL),
            new AttributeContainer(Attributes.ATTACK_SPEED, -0.3, AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL),
            new AttributeContainer(AttributeRegistry.SPELL_RESIST, .1, AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL),
            new AttributeContainer(ASAttributeRegistry.MANA_REND, .15, AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL),
            new AttributeContainer(ASAttributeRegistry.SPELL_RES_PENETRATION, .15, AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL)
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