package net.hazen.hazennstuff.Registries;

import net.hazen.hazennstuff.HazenNStuff;
import net.hazen.hazennstuff.Items.Armor.Steel.Stalwart.StalwartArmor;
import net.hazen.hazennstuff.Items.Armor.Steel.SteelArmor;
import net.hazen.hazennstuff.Items.Utils.HnSArmorMaterials;
import net.hazen.hazennstuff.Items.Weapons.Ascended.IcePike.IcePikeItem;
import net.hazen.hazennstuff.Items.Weapons.Special.Skyscorcher.SkyscorcherItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.equipment.ArmorType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class HnSItemRegistry {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(HazenNStuff.MOD_ID);


    public static final DeferredItem<Item> SKYSCORCHER = ITEMS.registerItem(
            "skyscorcher",
            properties -> new SkyscorcherItem(properties.stacksTo(1))
    );

    public static final DeferredItem<Item> ICE_PIKE = ITEMS.registerItem(
            "ice_pike",
            properties -> new IcePikeItem(properties.stacksTo(1))
    );


    /*
    *** Armor
     */
    public static final DeferredItem<Item> STEEL_HELMET = ITEMS.registerItem(
            "steel_helmet",
            properties -> new SteelArmor(properties.humanoidArmor(HnSArmorMaterials.STEEL_ARMOR_MATERIAL, ArmorType.HELMET)));

    public static final DeferredItem<Item> STEEL_CHESTPLATE = ITEMS.registerItem(
            "steel_chestplate",
            properties -> new SteelArmor(properties.humanoidArmor(HnSArmorMaterials.STEEL_ARMOR_MATERIAL, ArmorType.CHESTPLATE)));
    public static final DeferredItem<Item> STEEL_LEGGINGS = ITEMS.registerItem(
            "steel_leggings",
            properties -> new SteelArmor(properties.humanoidArmor(HnSArmorMaterials.STEEL_ARMOR_MATERIAL, ArmorType.LEGGINGS)));
    public static final DeferredItem<Item> STEEL_BOOTS = ITEMS.registerItem(
            "steel_boots",
            properties -> new SteelArmor(properties.humanoidArmor(HnSArmorMaterials.STEEL_ARMOR_MATERIAL, ArmorType.BOOTS)));

    public static final DeferredItem<Item> STALWART_HELMET = ITEMS.registerItem(
            "stalwart_helmet",
            properties -> new StalwartArmor(properties.humanoidArmor(HnSArmorMaterials.STALWART_ARMOR_MATERIAL, ArmorType.HELMET), ArmorType.HELMET));

    public static final DeferredItem<Item> STALWART_CHESTPLATE = ITEMS.registerItem(
            "stalwart_chestplate",
            properties -> new StalwartArmor(properties.humanoidArmor(HnSArmorMaterials.STALWART_ARMOR_MATERIAL, ArmorType.CHESTPLATE), ArmorType.CHESTPLATE));


    public static void register(IEventBus modEventBus){
        ITEMS.register(modEventBus);
    }
}
