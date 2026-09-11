package net.hazen.hazennstuff.Registries;

import net.hazen.hazennstuff.HazenNStuff;
import net.hazen.hazennstuff.Items.Armor.Steel.Stalwart.StalwartArmor;
import net.hazen.hazennstuff.Items.Armor.Steel.SteelArmor;
import net.hazen.hazennstuff.Items.Utils.HnSArmorMaterials;
import net.hazen.hazennstuff.Items.Utils.HnSToolTiers;
import net.hazen.hazennstuff.Items.Weapons.Ascended.IcePike.IcePikeItem;
import net.hazen.hazennstuff.Items.Weapons.BossDrops.RavensBane.RavensBaneItem;
import net.hazen.hazennstuff.Items.Weapons.Special.Skyscorcher.SkyscorcherItem;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.HoeItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ShovelItem;
import net.minecraft.world.item.equipment.ArmorType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class HnSItemRegistry {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(HazenNStuff.MOD_ID);


    /*
    *** Equipment
     */

    public static final DeferredItem<Item> STEEL_SPEAR = ITEMS.registerItem("steel_spear",
            properties -> new Item(properties.spear(HnSToolTiers.STEEL,
                    0.95f,
                    0.7f,
                    0.5f,
                    3.5f,
                    13f,
                    8.5f,
                    5.1f,
                    13.37f,
                    4.67f)
            ));

    public static final DeferredItem<Item> STEEL_SWORD = ITEMS.registerItem("steel_sword",
            properties -> new Item(properties.sword(HnSToolTiers.STEEL,
                    4, 1.6f)));
    public static final DeferredItem<Item> STEEL_PICKAXE = ITEMS.registerItem("steel_pickaxe",
            properties -> new Item(properties.pickaxe(HnSToolTiers.STEEL,
                    1f, -2.8f)));
    public static final DeferredItem<Item> STEEL_SHOVEL = ITEMS.registerItem("steel_shovel",
            properties -> new ShovelItem(HnSToolTiers.STEEL,
                    1.5f, -2.8f, properties));
    public static final DeferredItem<Item> STEEL_AXE = ITEMS.registerItem("steel_axe",
            properties -> new AxeItem(HnSToolTiers.STEEL,
                    6f, -3.0f, properties));
    public static final DeferredItem<Item> STEEL_HOE = ITEMS.registerItem("steel_hoe",
            properties -> new HoeItem(HnSToolTiers.STEEL,
                    2f, -2.5f, properties));

    /*
    *** Elemental Equipment
     */

    // Fire

    public static final DeferredItem<Item> RAVENS_BANE = ITEMS.registerItem(
            "ravens_bane",
            properties -> new RavensBaneItem(properties.stacksTo(1))
    );

    // Ice

    public static final DeferredItem<Item> ICE_PIKE = ITEMS.registerItem(
            "ice_pike",
            properties -> new IcePikeItem(properties.stacksTo(1))
    );

    // Nature

    // Lightning

    public static final DeferredItem<Item> SKYSCORCHER = ITEMS.registerItem(
            "skyscorcher",
            properties -> new SkyscorcherItem(properties.stacksTo(1))
    );

    //


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
