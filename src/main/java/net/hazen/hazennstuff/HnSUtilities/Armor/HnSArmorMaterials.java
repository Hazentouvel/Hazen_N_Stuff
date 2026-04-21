package net.hazen.hazennstuff.HnSUtilities.Armor;

import io.redspace.ironsspellbooks.registries.ItemRegistry;
import net.hazen.hazennstuff.HazenNStuff;
import net.hazen.hazennstuff.Registries.HnSItemRegistry;
import net.hazen.hazennstuff.Registries.HnSSounds;
import net.minecraft.Util;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.EnumMap;
import java.util.List;
import java.util.function.Supplier;

public class HnSArmorMaterials {
    private static final DeferredRegister<ArmorMaterial> ARMOR_MATERIALS = DeferredRegister.create(Registries.ARMOR_MATERIAL, HazenNStuff.MOD_ID);

    /*
    *** Pure Armor Sets
     */

    public static DeferredHolder<ArmorMaterial, ArmorMaterial> BLAZEBORNE_MATERIAL = register("blazeborne",
            pureArmorMap(),
            20,
            SoundEvents.ARMOR_EQUIP_NETHERITE,
            () -> Ingredient.of(ItemRegistry.MITHRIL_WEAVE.get()),
            4,
            0.15F);

    public static DeferredHolder<ArmorMaterial, ArmorMaterial> CREAKING_SORCERER_MATERIAL = register("creaking",
            pureArmorMap(),
            20,
            HnSSounds.CREAKING_SORCERER_EQUIP,
            () -> Ingredient.of(ItemRegistry.MITHRIL_WEAVE.get()),
            4,
            0.15F);

    public static DeferredHolder<ArmorMaterial, ArmorMaterial> SERAPH_MATERIAL = register("seraph",
            pureArmorMap(),
            20,
            HnSSounds.SERAPH_EQUIP,
            () -> Ingredient.of(ItemRegistry.MITHRIL_WEAVE.get()),
            4,
            0.15F);

    public static DeferredHolder<ArmorMaterial, ArmorMaterial> CHARGED_SCOURGE_MATERIAL = register("scourge",
            pureArmorMap(),
            20,
            HnSSounds.CHARGED_SCOURGE_EQUIP,
            () -> Ingredient.of(ItemRegistry.MITHRIL_WEAVE.get()),
            4,
            0.15F);

    public static DeferredHolder<ArmorMaterial, ArmorMaterial> SOUL_FLAME_MATERIAL = register("soul_flame",
            pureArmorMap(),
            20,
            HnSSounds.SOUL_FLAME_EQUIP,
            () -> Ingredient.of(ItemRegistry.MITHRIL_WEAVE.get()),
            4,
            0.15F);

    public static DeferredHolder<ArmorMaterial, ArmorMaterial> ALCHEMIST_SUPREME_MATERIAL = register("alchemist_supreme",
            pureArmorMap(),
            20,
            HnSSounds.SUPREME_WITCH_EQUIP,
            () -> Ingredient.of(ItemRegistry.MITHRIL_WEAVE.get()),
            4,
            0.15F);

    public static DeferredHolder<ArmorMaterial, ArmorMaterial> CRYOGENIC_RULER_MATERIAL = register("cryogenic_ruler",
            pureArmorMap(),
            20,
            HnSSounds.CRYOGENIC_RULER_EQUIP,
            () -> Ingredient.of(ItemRegistry.MITHRIL_WEAVE.get()),
            4,
            0.15F);

    public static DeferredHolder<ArmorMaterial, ArmorMaterial> FLESH_MASS_MATERIAL = register("flesh_mass",
            pureArmorMap(),
            20,
            HnSSounds.FLESH_MASS_EQUIP,
            () -> Ingredient.of(ItemRegistry.MITHRIL_WEAVE.get()),
            4,
            0.15F);

    public static DeferredHolder<ArmorMaterial, ArmorMaterial> ENDER_DRAGON_MATERIAL = register("ender_dragon",
            pureArmorMap(),
            20,
            HnSSounds.ENDER_DRAGON_EQUIP,
            () -> Ingredient.of(ItemRegistry.MITHRIL_WEAVE.get()),
            4,
            0.15F);

    public static DeferredHolder<ArmorMaterial, ArmorMaterial> ELDRITCH_MATERIAL = register("eldritch",
            battlemageArmorMap(),
            20,
            SoundEvents.ARMOR_EQUIP_NETHERITE,
            () -> Ingredient.of(ItemRegistry.MITHRIL_WEAVE.get()),
            4,
            0.15F);

    public static DeferredHolder<ArmorMaterial, ArmorMaterial> CALAMITAS_MATERIAL = register("calamitas",
            pureArmorMap(),
            20,
            HnSSounds.CALAMITAS_EQUIP,
            () -> Ingredient.of(ItemRegistry.MITHRIL_WEAVE.get()),
            4,
            0.15F);

    public static DeferredHolder<ArmorMaterial, ArmorMaterial> PURE_ARMOR_TIER_MATERIAL = register("pure_armor_tier",
            pureArmorMap(),
            20,
            SoundEvents.ARMOR_EQUIP_LEATHER,
            () -> Ingredient.of(ItemRegistry.MITHRIL_WEAVE.get()),
            4,
            0.15F);

    public static DeferredHolder<ArmorMaterial, ArmorMaterial> INFESTATION_MATERIAL = register("infestation",
            pureArmorMap(),
            20,
            SoundEvents.ARMOR_EQUIP_NETHERITE,
            () -> Ingredient.of(ItemRegistry.MITHRIL_WEAVE.get()),
            4,
            0.15F);


    public static DeferredHolder<ArmorMaterial, ArmorMaterial> TYROS_MATERIAL = register("tyros",
            paragonArmorMap(),
            30,
            SoundEvents.ARMOR_EQUIP_NETHERITE,
            () -> Ingredient.of(HnSItemRegistry.ZENALITE_INGOT),
            5,
            0.25F);

    public static DeferredHolder<ArmorMaterial, ArmorMaterial> PARAGON_MATERIAL = register("paragon",
            paragonArmorMap(),
            30,
            SoundEvents.ARMOR_EQUIP_NETHERITE,
            () -> Ingredient.of(HnSItemRegistry.ZENALITE_INGOT),
            5,
            0.25F);


    public static DeferredHolder<ArmorMaterial, ArmorMaterial> PYRIUM_MATERIAL = register("pyrium",
            pyrium(),
            25,
            SoundEvents.ARMOR_EQUIP_NETHERITE,
            () -> Ingredient.of(Items.NETHERITE_INGOT),
            4,
            0.15F);


    /*
    *** Melee Armor Sets
     */


    /*
    *** Misc Armor Sets
     */


    public static DeferredHolder<ArmorMaterial, ArmorMaterial> ADVANCED_BATTLEMAGE_MATERIAL = register("advanced_battlemage",
            advancedBattlemageArmorMap(),
            15,
            SoundEvents.ARMOR_EQUIP_NETHERITE,
            () -> Ingredient.of(ItemRegistry.MAGIC_CLOTH.get()),
            2,
            0F);


    private static DeferredHolder<ArmorMaterial, ArmorMaterial> register(
            String name,
            EnumMap<ArmorItem.Type, Integer> defense,
            int enchantmentValue,
            Holder<SoundEvent> equipSound,
            Supplier<Ingredient> repairIngredient,
            float toughness,
            float knockbackResistance
    )
    {
        List<ArmorMaterial.Layer> list = List.of(new ArmorMaterial.Layer(HazenNStuff.id(name)));
        return ARMOR_MATERIALS.register(name, () -> new ArmorMaterial(defense, enchantmentValue, equipSound, repairIngredient, list, toughness, knockbackResistance));
    }

    public static EnumMap<ArmorItem.Type, Integer> makeArmorMap(int helmet, int chestplate, int leggings, int boots)
    {
        return Util.make(new EnumMap<>(ArmorItem.Type.class), (typeIntegerEnumMap) -> {
            typeIntegerEnumMap.put(ArmorItem.Type.HELMET, helmet);
            typeIntegerEnumMap.put(ArmorItem.Type.CHESTPLATE, chestplate);
            typeIntegerEnumMap.put(ArmorItem.Type.LEGGINGS, leggings);
            typeIntegerEnumMap.put(ArmorItem.Type.BOOTS, boots);
        });
    }

    public static EnumMap<ArmorItem.Type, Integer> paragonArmorMap()
    {
        return makeArmorMap(6, 11, 9, 6);
    }

    public static EnumMap<ArmorItem.Type, Integer> pureArmorMap()
    {
        return makeArmorMap(5, 10, 8, 5);
    }

    public static EnumMap<ArmorItem.Type, Integer> battlemageArmorMap(){
        return makeArmorMap(3, 8, 6, 3);
    }
    public static EnumMap<ArmorItem.Type, Integer> advancedBattlemageArmorMap(){
        return makeArmorMap(4, 9, 6, 4);
    }
    public static EnumMap<ArmorItem.Type, Integer> pyrium(){return makeArmorMap(4, 9, 6, 4);}

    public static void register(IEventBus eventBus)
    {
        ARMOR_MATERIALS.register(eventBus);
    }
}