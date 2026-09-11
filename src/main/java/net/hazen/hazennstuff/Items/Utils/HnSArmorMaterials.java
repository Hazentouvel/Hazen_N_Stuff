package net.hazen.hazennstuff.Items.Utils;

import com.google.common.collect.Maps;
import io.redspace.ironslib.registry.IronsLibRegistries;
import net.hazen.hazennstuff.Datagen.Tags.HnSTags;
import net.hazen.hazennstuff.HazenNStuff;
import net.hazen.hazentouvelib.Utils.AdditionalArmorAttributes;
import net.minecraft.core.Registry;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.item.equipment.ArmorMaterial;
import net.minecraft.world.item.equipment.ArmorType;
import net.minecraft.world.item.equipment.EquipmentAsset;

import java.util.List;
import java.util.Map;

public class HnSArmorMaterials {
    private static ResourceKey<? extends Registry<EquipmentAsset>> ROOT_ID =
            ResourceKey.createRegistryKey(Identifier.withDefaultNamespace("equipment_asset"));

    public static ResourceKey<EquipmentAsset> STEEL_KEY = ResourceKey.create(ROOT_ID,
            Identifier.fromNamespaceAndPath(HazenNStuff.MOD_ID, "steel"));

    public static ResourceKey<EquipmentAsset> PURE_TIER_KEY = ResourceKey.create(ROOT_ID,
            Identifier.fromNamespaceAndPath(HazenNStuff.MOD_ID, "pure_tier"));

    public static final ArmorMaterial STEEL_ARMOR_MATERIAL = new ArmorMaterial(29,
            makeDefense(2, 5, 6, 2, 5), 9, SoundEvents.ARMOR_EQUIP_IRON,
            1f,
            1f,
            HnSTags.Items.STEEL_REPAIR, STEEL_KEY);

    public static final ArmorMaterial STALWART_ARMOR_MATERIAL = new ArmorMaterial(29,
            makeDefense(2, 5, 7, 3, 5), 9, SoundEvents.ARMOR_EQUIP_IRON,
            2f,
            2f,
            HnSTags.Items.STEEL_REPAIR, STEEL_KEY);

    public static final List<AdditionalArmorAttributes.CustomAttribute> STALWART_ATTRIBUTES =
            List.of(
                    new AdditionalArmorAttributes.CustomAttribute(IronsLibRegistries.AttributeRegistry.ARMOR_PIERCE, Identifier.fromNamespaceAndPath(HazenNStuff.MOD_ID,
                            "armor_pierce"), 0.05, AttributeModifier.Operation.ADD_MULTIPLIED_BASE)
            );

    public static final ArmorMaterial PURE_TIER_ARMOR_MATERIAL = new ArmorMaterial(29,
            makeDefense(4, 7, 9, 4, 21), 18, SoundEvents.ARMOR_EQUIP_GOLD,
            2f,
            0f,
            HnSTags.Items.ZENALITE_REPAIR, PURE_TIER_KEY);


    private static Map<ArmorType, Integer> makeDefense(int boots, int legs, int chest, int helm, int body) {
        return Maps.newEnumMap(
                Map.of(ArmorType.BOOTS, boots, ArmorType.LEGGINGS, legs, ArmorType.CHESTPLATE, chest, ArmorType.HELMET, helm, ArmorType.BODY, body)
        );
    }
}