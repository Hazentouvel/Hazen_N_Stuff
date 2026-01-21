package net.hazen.hazennstuff.Items.Extensions;

import io.redspace.ironsspellbooks.api.registry.AttributeRegistry;

import java.util.EnumMap;
import java.util.Map;
import java.util.function.Supplier;

import io.redspace.ironsspellbooks.registries.ItemRegistry;
import net.minecraft.Util;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.LazyLoadedValue;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.attributes.AttributeModifier.Operation;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ArmorItem.Type;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;
import org.w3c.dom.Attr;

public enum HnSArmorMaterial implements ArmorMaterial {

    /*
    *** Pure Armor
     */

    PYROMANCER("pyromancer",
            38, schoolArmorMap(),
            15, SoundEvents.ARMOR_EQUIP_NETHERITE,
            0.0F,
            0.0F,
            () -> Ingredient.of(new ItemLike[]{(ItemLike) ItemRegistry.MITHRIL_WEAVE.get()}),
            Map.of(
                    (Attribute)AttributeRegistry.MAX_MANA.get(), new AttributeModifier("Max Mana", (double)200.0F, Operation.ADDITION),
                    (Attribute)AttributeRegistry.FIRE_SPELL_POWER.get(), new AttributeModifier("Fire Power", 0.15, Operation.MULTIPLY_BASE),
                    (Attribute)AttributeRegistry.ELDRITCH_SPELL_POWER.get(), new AttributeModifier("Eldritch Power", 0.05, Operation.MULTIPLY_BASE),
                    (Attribute)AttributeRegistry.SPELL_POWER.get(), new AttributeModifier("Base Power", 0.15, Operation.MULTIPLY_BASE))),

    CRYOMANCER("cryomancer",
            38, schoolArmorMap(),
            15, SoundEvents.ARMOR_EQUIP_NETHERITE,
            0.0F,
            0.0F,
            () -> Ingredient.of(new ItemLike[]{(ItemLike) ItemRegistry.MITHRIL_WEAVE.get()}),
            Map.of(
                    (Attribute)AttributeRegistry.MAX_MANA.get(), new AttributeModifier("Max Mana", (double)200.0F, Operation.ADDITION),
                    (Attribute)AttributeRegistry.ICE_SPELL_POWER.get(), new AttributeModifier("Ice Power", 0.15, Operation.MULTIPLY_BASE),
                    (Attribute)AttributeRegistry.ELDRITCH_SPELL_POWER.get(), new AttributeModifier("Eldritch Power", 0.05, Operation.MULTIPLY_BASE),
                    (Attribute)AttributeRegistry.SPELL_POWER.get(), new AttributeModifier("Base Power", 0.15, Operation.MULTIPLY_BASE))),

    ELECTROMANCER("electromancer",
            38, schoolArmorMap(),
            15, SoundEvents.ARMOR_EQUIP_NETHERITE,
            0.0F,
            0.0F,
            () -> Ingredient.of(new ItemLike[]{(ItemLike) ItemRegistry.MITHRIL_WEAVE.get()}),
            Map.of(
                    (Attribute)AttributeRegistry.MAX_MANA.get(), new AttributeModifier("Max Mana", (double)200.0F, Operation.ADDITION),
                    (Attribute)AttributeRegistry.LIGHTNING_SPELL_POWER.get(), new AttributeModifier("Lightning Power", 0.15, Operation.MULTIPLY_BASE),
                    (Attribute)AttributeRegistry.ELDRITCH_SPELL_POWER.get(), new AttributeModifier("Eldritch Power", 0.05, Operation.MULTIPLY_BASE),
                    (Attribute)AttributeRegistry.SPELL_POWER.get(), new AttributeModifier("Base Power", 0.15, Operation.MULTIPLY_BASE))),

    BOTAMANCER("botamancer",
            38, schoolArmorMap(),
            15, SoundEvents.ARMOR_EQUIP_NETHERITE,
            0.0F,
            0.0F,
            () -> Ingredient.of(new ItemLike[]{(ItemLike) ItemRegistry.MITHRIL_WEAVE.get()}),
            Map.of(
                    (Attribute)AttributeRegistry.MAX_MANA.get(), new AttributeModifier("Max Mana", (double)200.0F, Operation.ADDITION),
                    (Attribute)AttributeRegistry.NATURE_SPELL_POWER.get(), new AttributeModifier("Nature Power", 0.15, Operation.MULTIPLY_BASE),
                    (Attribute)AttributeRegistry.ELDRITCH_SPELL_POWER.get(), new AttributeModifier("Eldritch Power", 0.05, Operation.MULTIPLY_BASE),
                    (Attribute)AttributeRegistry.SPELL_POWER.get(), new AttributeModifier("Base Power", 0.15, Operation.MULTIPLY_BASE))),

    ENDERMANCER("endermancer",
            38, schoolArmorMap(),
            15, SoundEvents.ARMOR_EQUIP_NETHERITE,
            0.0F,
            0.0F,
            () -> Ingredient.of(new ItemLike[]{(ItemLike) ItemRegistry.MITHRIL_WEAVE.get()}),
            Map.of(
                    (Attribute)AttributeRegistry.MAX_MANA.get(), new AttributeModifier("Max Mana", (double)200.0F, Operation.ADDITION),
                    (Attribute)AttributeRegistry.ENDER_SPELL_POWER.get(), new AttributeModifier("Ender Power", 0.15, Operation.MULTIPLY_BASE),
                    (Attribute)AttributeRegistry.ELDRITCH_SPELL_POWER.get(), new AttributeModifier("Eldritch Power", 0.05, Operation.MULTIPLY_BASE),
                    (Attribute)AttributeRegistry.SPELL_POWER.get(), new AttributeModifier("Base Power", 0.15, Operation.MULTIPLY_BASE))),

    SANGUINEMANCER("sanguinemancer",
            38, schoolArmorMap(),
            15, SoundEvents.ARMOR_EQUIP_NETHERITE,
            0.0F,
            0.0F,
            () -> Ingredient.of(new ItemLike[]{(ItemLike) ItemRegistry.MITHRIL_WEAVE.get()}),
            Map.of(
                    (Attribute)AttributeRegistry.MAX_MANA.get(), new AttributeModifier("Max Mana", (double)200.0F, Operation.ADDITION),
                    (Attribute)AttributeRegistry.BLOOD_SPELL_POWER.get(), new AttributeModifier("Blood Power", 0.15, Operation.MULTIPLY_BASE),
                    (Attribute)AttributeRegistry.ELDRITCH_SPELL_POWER.get(), new AttributeModifier("Eldritch Power", 0.05, Operation.MULTIPLY_BASE),
                    (Attribute)AttributeRegistry.SPELL_POWER.get(), new AttributeModifier("Base Power", 0.15, Operation.MULTIPLY_BASE))),

    HOLYMANCER("holymancer",
            38, schoolArmorMap(),
            15, SoundEvents.ARMOR_EQUIP_NETHERITE,
            0.0F,
            0.0F,
            () -> Ingredient.of(new ItemLike[]{(ItemLike) ItemRegistry.MITHRIL_WEAVE.get()}),
            Map.of(
                    (Attribute)AttributeRegistry.MAX_MANA.get(), new AttributeModifier("Max Mana", (double)200.0F, Operation.ADDITION),
                    (Attribute)AttributeRegistry.HOLY_SPELL_POWER.get(), new AttributeModifier("Holy Power", 0.15, Operation.MULTIPLY_BASE),
                    (Attribute)AttributeRegistry.ELDRITCH_SPELL_POWER.get(), new AttributeModifier("Eldritch Power", 0.05, Operation.MULTIPLY_BASE),
                    (Attribute)AttributeRegistry.SPELL_POWER.get(), new AttributeModifier("Base Power", 0.15, Operation.MULTIPLY_BASE))),

    EVOMANCER("evomancer",
            38, schoolArmorMap(),
            15, SoundEvents.ARMOR_EQUIP_NETHERITE,
            0.0F,
            0.0F,
            () -> Ingredient.of(new ItemLike[]{(ItemLike) ItemRegistry.MITHRIL_WEAVE.get()}),
            Map.of(
                    (Attribute)AttributeRegistry.MAX_MANA.get(), new AttributeModifier("Max Mana", (double)200.0F, Operation.ADDITION),
                    (Attribute)AttributeRegistry.EVOCATION_SPELL_POWER.get(), new AttributeModifier("Evocation Power", 0.15, Operation.MULTIPLY_BASE),
                    (Attribute)AttributeRegistry.ELDRITCH_SPELL_POWER.get(), new AttributeModifier("Eldritch Power", 0.05, Operation.MULTIPLY_BASE),
                    (Attribute)AttributeRegistry.SPELL_POWER.get(), new AttributeModifier("Base Power", 0.15, Operation.MULTIPLY_BASE))),


    ELDRITCHMANCER("eldritchmancer",
            38, schoolArmorMap(),
            15, SoundEvents.ARMOR_EQUIP_NETHERITE,
            0.0F,
            0.0F,
            () -> Ingredient.of(new ItemLike[]{(ItemLike) ItemRegistry.MITHRIL_WEAVE.get()}),
            Map.of(
                    (Attribute)AttributeRegistry.MAX_MANA.get(), new AttributeModifier("Max Mana", (double)200.0F, Operation.ADDITION),
                    (Attribute)AttributeRegistry.ELDRITCH_SPELL_POWER.get(), new AttributeModifier("Eldritch Power", 0.2, Operation.MULTIPLY_BASE),
                    (Attribute)AttributeRegistry.SPELL_POWER.get(), new AttributeModifier("Base Power", 0.15, Operation.MULTIPLY_BASE))),

    PYRIUM("pyrium",
            38, pyriumArmorMap(),
            20, SoundEvents.ARMOR_EQUIP_NETHERITE,
            0.5F,
            0.0F,
            () -> Ingredient.of(new ItemLike[]{(ItemLike) ItemRegistry.PYRIUM_INGOT.get()}),
            Map.of(
                    (Attribute) Attributes.MOVEMENT_SPEED, new AttributeModifier("Movement Speed", 0.05, Operation.MULTIPLY_BASE),
                    (Attribute) Attributes.KNOCKBACK_RESISTANCE, new AttributeModifier("Knockback Resistance", 1.0D, Operation.ADDITION)
            )),

    PYRIUM_BATTLEMAGE("pyrium_battlemage",
            38, pyriumArmorMap(),
            15, SoundEvents.ARMOR_EQUIP_NETHERITE,
            0.0F,
            0.0F,
            () -> Ingredient.of(new ItemLike[]{(ItemLike) ItemRegistry.PYRIUM_INGOT.get()}),
            Map.of(
                    (Attribute)AttributeRegistry.MAX_MANA.get(), new AttributeModifier("Max Mana", 200.0D, Operation.ADDITION),
                    (Attribute)AttributeRegistry.CASTING_MOVESPEED.get(), new AttributeModifier("Casting Movespeed", 0.15, Operation.MULTIPLY_BASE),
                    (Attribute)AttributeRegistry.CAST_TIME_REDUCTION.get(), new AttributeModifier("Cast Time Reduction", 0.15, Operation.MULTIPLY_BASE),
                    (Attribute)AttributeRegistry.SPELL_POWER.get(), new AttributeModifier("Base Power", 0.15, Operation.MULTIPLY_BASE))),

    MITHRIL_BATTLEMAGE("mithril_battlemage",
            38, schoolArmorMap(),
            15, SoundEvents.ARMOR_EQUIP_NETHERITE,
            0.0F,
            0.0F,
            () -> Ingredient.of(new ItemLike[]{(ItemLike) ItemRegistry.PYRIUM_INGOT.get()}),
            Map.of(
                    (Attribute)AttributeRegistry.MAX_MANA.get(), new AttributeModifier("Max Mana", 200.0D, Operation.ADDITION),
                    (Attribute)AttributeRegistry.CASTING_MOVESPEED.get(), new AttributeModifier("Casting Movespeed", 0.15, Operation.MULTIPLY_BASE),
                    (Attribute)AttributeRegistry.COOLDOWN_REDUCTION.get(), new AttributeModifier("Cooldown Reduction", 0.15, Operation.MULTIPLY_BASE),
                    (Attribute)AttributeRegistry.SPELL_POWER.get(), new AttributeModifier("Base Power", 0.15, Operation.MULTIPLY_BASE))),

    LEGIONNAIRE_RULER("legionnaire_ruler",
            38, pyriumArmorMap(),
            15, SoundEvents.ARMOR_EQUIP_NETHERITE,
            0.0F,
            0.0F,
            () -> Ingredient.of(new ItemLike[]{(ItemLike) ItemRegistry.PYRIUM_INGOT.get()}),
            Map.of(
                    (Attribute)AttributeRegistry.MAX_MANA.get(), new AttributeModifier("Max Mana", 300.0D, Operation.ADDITION),
                    (Attribute)AttributeRegistry.FIRE_SPELL_POWER.get(), new AttributeModifier("Fire Power", 0.15, Operation.MULTIPLY_BASE),
                    (Attribute)AttributeRegistry.CAST_TIME_REDUCTION.get(), new AttributeModifier("Fire Power", 0.05, Operation.MULTIPLY_BASE),
                    (Attribute)AttributeRegistry.SUMMON_DAMAGE.get(), new AttributeModifier("Nature Power", 0.1, Operation.MULTIPLY_BASE),
                    (Attribute)AttributeRegistry.SPELL_POWER.get(), new AttributeModifier("Base Power", 0.15, Operation.MULTIPLY_BASE))),

    LEGIONNAIRE_COMMANDER("legionnaire_ruler",
            38, pyriumArmorMap(),
            15, SoundEvents.ARMOR_EQUIP_NETHERITE,
            0.0F,
            0.0F,
            () -> Ingredient.of(new ItemLike[]{(ItemLike) ItemRegistry.PYRIUM_INGOT.get()}),
            Map.of(
                    (Attribute)AttributeRegistry.MAX_MANA.get(), new AttributeModifier("Max Mana", 150.0D, Operation.ADDITION),
                    (Attribute)Attributes.ATTACK_DAMAGE, new AttributeModifier("Attack Damage", 0.5D, Operation.ADDITION),
                    (Attribute)AttributeRegistry.FIRE_SPELL_POWER.get(), new AttributeModifier("Fire Power", 0.1, Operation.MULTIPLY_BASE),
                    (Attribute)Attributes.ATTACK_SPEED, new AttributeModifier("Attack Speed", 0.1, Operation.MULTIPLY_BASE),
                    (Attribute)AttributeRegistry.SPELL_POWER.get(), new AttributeModifier("Base Power", 0.15, Operation.MULTIPLY_BASE))),

    ATLAS("atlas",
            38, schoolArmorMap(),
            15, SoundEvents.ARMOR_EQUIP_NETHERITE,
            0.0F,
            0.0F,
            () -> Ingredient.of(new ItemLike[]{(ItemLike) ItemRegistry.MITHRIL_WEAVE.get()}),
            Map.of(
                    (Attribute)AttributeRegistry.MAX_MANA.get(), new AttributeModifier("Max Mana", 200.0D, Operation.ADDITION),
                    (Attribute)AttributeRegistry.EVOCATION_SPELL_POWER.get(), new AttributeModifier("Evocation Power", 0.15, Operation.MULTIPLY_BASE),
                    (Attribute)AttributeRegistry.NATURE_SPELL_POWER.get(), new AttributeModifier("Nature Power", 0.15, Operation.MULTIPLY_BASE),
                    (Attribute)AttributeRegistry.SPELL_POWER.get(), new AttributeModifier("Base Power", 0.15, Operation.MULTIPLY_BASE))),


    FIREBLOSSOM("fireblossom",
                           38, schoolArmorMap(),
            15, SoundEvents.ARMOR_EQUIP_NETHERITE,
            0.0F,
            0.0F,
            () -> Ingredient.of(new ItemLike[]{(ItemLike) ItemRegistry.MITHRIL_WEAVE.get()}),
            Map.of(
                    (Attribute)AttributeRegistry.MAX_MANA.get(), new AttributeModifier("Max Mana", 200.0D, Operation.ADDITION),
                    (Attribute)AttributeRegistry.FIRE_SPELL_POWER.get(), new AttributeModifier("Fire Power", 0.15, Operation.MULTIPLY_BASE),
                    (Attribute)AttributeRegistry.NATURE_SPELL_POWER.get(), new AttributeModifier("Nature Power", 0.15, Operation.MULTIPLY_BASE),
                    (Attribute)AttributeRegistry.SPELL_POWER.get(), new AttributeModifier("Base Power", 0.15, Operation.MULTIPLY_BASE))),


    FIREBLOSSOM_CROWN("fireblossom_crown",
                           38, schoolArmorMap(),
            15, SoundEvents.ARMOR_EQUIP_NETHERITE,
            0.0F,
            0.0F,
            () -> Ingredient.of(new ItemLike[]{(ItemLike) ItemRegistry.MITHRIL_WEAVE.get()}),
            Map.of(
                    (Attribute)AttributeRegistry.MAX_MANA.get(), new AttributeModifier("Max Mana", 400.0D, Operation.ADDITION),
                    (Attribute)AttributeRegistry.FIRE_SPELL_POWER.get(), new AttributeModifier("Fire Power", 0.25, Operation.MULTIPLY_BASE),
                    (Attribute)AttributeRegistry.NATURE_SPELL_POWER.get(), new AttributeModifier("Nature Power", 0.25, Operation.MULTIPLY_BASE),
                    (Attribute)AttributeRegistry.SPELL_POWER.get(), new AttributeModifier("Base Power", 0.25, Operation.MULTIPLY_BASE))),

    FIREBLOSSOM_HELMET("fireblossom_helmet",
            38, schoolArmorMap(),
            15, SoundEvents.ARMOR_EQUIP_NETHERITE,
            0.0F,
            0.0F,
            () -> Ingredient.of(new ItemLike[]{(ItemLike) ItemRegistry.MITHRIL_WEAVE.get()}),
            Map.of(
                    (Attribute)AttributeRegistry.MAX_MANA.get(), new AttributeModifier("Max Mana", 200.0D, Operation.ADDITION),
                    (Attribute)AttributeRegistry.FIRE_SPELL_POWER.get(), new AttributeModifier("Fire Power", 0.05, Operation.MULTIPLY_BASE),
                    (Attribute)AttributeRegistry.NATURE_SPELL_POWER.get(), new AttributeModifier("Nature Power", 0.05, Operation.MULTIPLY_BASE),
                    (Attribute)Attributes.ATTACK_DAMAGE, new AttributeModifier("Nature Power", 3D, Operation.ADDITION),
                    (Attribute)Attributes.ATTACK_SPEED, new AttributeModifier("Nature Power", 0.6D, Operation.ADDITION),
                    (Attribute)AttributeRegistry.SPELL_POWER.get(), new AttributeModifier("Base Power", 0.1, Operation.MULTIPLY_BASE)))
    ;


    private static final int[] HEALTH_PER_SLOT = new int[]{13, 15, 16, 11};
    private final String name;
    private final int durabilityMultiplier;
    private final EnumMap<Type, Integer> protectionFunctionForType;
    private final int enchantmentValue;
    private final SoundEvent sound;
    private final float toughness;
    private final float knockbackResistance;
    private final LazyLoadedValue<Ingredient> repairIngredient;
    private final Map<Attribute, AttributeModifier> additionalAttributes;
    private static final EnumMap<Type, Integer> HEALTH_FUNCTION_FOR_TYPE = (EnumMap)Util.make(new EnumMap(Type.class), (p_266653_) -> {
        p_266653_.put(Type.BOOTS, 13);
        p_266653_.put(Type.LEGGINGS, 15);
        p_266653_.put(Type.CHESTPLATE, 16);
        p_266653_.put(Type.HELMET, 11);
    });

    private HnSArmorMaterial(String pName, int pDurabilityMultiplier, EnumMap<Type, Integer> protectionMap, int pEnchantmentValue, SoundEvent pSound, float pToughness, float pKnockbackResistance, Supplier<Ingredient> pRepairIngredient, Map<Attribute, AttributeModifier> additionalAttributes) {
        this.name = pName;
        this.durabilityMultiplier = pDurabilityMultiplier;
        this.protectionFunctionForType = protectionMap;
        this.enchantmentValue = pEnchantmentValue;
        this.sound = pSound;
        this.toughness = pToughness;
        this.knockbackResistance = pKnockbackResistance;
        this.repairIngredient = new LazyLoadedValue(pRepairIngredient);
        this.additionalAttributes = additionalAttributes;
    }

    public static EnumMap<Type, Integer> makeArmorMap(int helmet, int chestplate, int leggings, int boots) {
        return (EnumMap)Util.make(new EnumMap(Type.class), (p_266655_) -> {
            p_266655_.put(Type.BOOTS, boots);
            p_266655_.put(Type.LEGGINGS, leggings);
            p_266655_.put(Type.CHESTPLATE, chestplate);
            p_266655_.put(Type.HELMET, helmet);
        });
    }

    public static EnumMap<Type, Integer> schoolArmorMap() {
        return makeArmorMap(3, 8, 6, 3);
    }

    public static EnumMap<Type, Integer> pyriumArmorMap() {
        return makeArmorMap(4, 9, 7, 4);
    }

    public int getDurabilityForSlot(EquipmentSlot pSlot) {
        return HEALTH_PER_SLOT[pSlot.getIndex()] * this.durabilityMultiplier;
    }

    public int getDurabilityForType(Type p_266745_) {
        return (Integer)HEALTH_FUNCTION_FOR_TYPE.get(p_266745_) * this.durabilityMultiplier;
    }

    public int getDefenseForType(Type p_266752_) {
        return (Integer)this.protectionFunctionForType.get(p_266752_);
    }

    public int getEnchantmentValue() {
        return this.enchantmentValue;
    }

    public SoundEvent getEquipSound() {
        return this.sound;
    }

    public Ingredient getRepairIngredient() {
        return (Ingredient)this.repairIngredient.get();
    }

    public String getName() {
        return this.name;
    }

    public float getToughness() {
        return this.toughness;
    }

    public Map<Attribute, AttributeModifier> getAdditionalAttributes() {
        return this.additionalAttributes;
    }

    public float getKnockbackResistance() {
        return this.knockbackResistance;
    }
}
