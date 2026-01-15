package net.hazen.hazennstuff.Registries.ItemRegistries;

import io.redspace.ironsspellbooks.api.registry.SpellDataRegistryHolder;
import io.redspace.ironsspellbooks.api.registry.SpellRegistry;
import io.redspace.ironsspellbooks.util.ItemPropertiesHelper;
import net.hazen.hazennstuff.HazenNStuff;
import net.hazen.hazennstuff.Items.Equipment.ArmorSets.AlchemistSupreme.AlchemistSupremeArmorItem;
import net.hazen.hazennstuff.Items.Equipment.ArmorSets.Blazeborne.BlazeborneArmorItem;
import net.hazen.hazennstuff.Items.Equipment.ArmorSets.CreakingSorcerer.CreakingSorcererArmorItem;
import net.hazen.hazennstuff.Items.Equipment.ArmorSets.CryogenicRuler.CryogenicRulerArmorItem;
import net.hazen.hazennstuff.Items.Equipment.ArmorSets.EnderDragon.EnderDragonArmorItem;
import net.hazen.hazennstuff.Items.Equipment.ArmorSets.FireblossomBattlemage.Crown.FireblossomBattlemageCrownArmorItem;
import net.hazen.hazennstuff.Items.Equipment.ArmorSets.FireblossomBattlemage.FireblossomBattlemageArmorItem;
import net.hazen.hazennstuff.Items.Equipment.ArmorSets.FireblossomBattlemage.Helmet.FireblossomBattlemageHelmetArmorItem;
import net.hazen.hazennstuff.Items.Equipment.ArmorSets.FleshMass.FleshMassArmorItem;
import net.hazen.hazennstuff.Items.Equipment.ArmorSets.Hazel.BigHazelArmorItem;
import net.hazen.hazennstuff.Items.Equipment.ArmorSets.Hazel.HazelArmorItem;
import net.hazen.hazennstuff.Items.Equipment.ArmorSets.Infestation.InfestationArmorItem;
import net.hazen.hazennstuff.Items.Equipment.ArmorSets.Seraph.SeraphArmorItem;
import net.hazen.hazennstuff.Items.Equipment.ArmorSets.ThunderProwler.ThunderProwlerArmorItem;
import net.hazen.hazennstuff.Items.Equipment.Weapons.FireblossomRapier.FireblossomRapierItem;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class HnSWeaponItemRegistry {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, HazenNStuff.MOD_ID);


    // Fireblossom Rapier
    public static final RegistryObject<Item> FIREBLOSSOM_RAPIER = ITEMS.register("fireblossom_rapier", () -> new FireblossomRapierItem(
            SpellDataRegistryHolder.of(
            new SpellDataRegistryHolder(SpellRegistry.FLAMING_STRIKE_SPELL, 5))
            )
    );

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}