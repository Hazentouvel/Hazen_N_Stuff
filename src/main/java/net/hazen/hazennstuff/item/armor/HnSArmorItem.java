package net.hazen.hazennstuff.item.armor;

import com.google.common.base.Suppliers;
import io.redspace.ironsspellbooks.api.registry.AttributeRegistry;
import io.redspace.ironsspellbooks.item.weapons.AttributeContainer;
import mod.azure.azurelib.common.api.common.animatable.GeoItem;
import mod.azure.azurelib.common.internal.common.util.AzureLibUtil;
import net.minecraft.core.Holder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EquipmentSlotGroup;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.component.ItemAttributeModifiers;

import java.util.function.Consumer;
import java.util.function.Supplier;

public class HnSArmorItem extends ArmorItem {
    private final Supplier<ItemAttributeModifiers> defaultModifiers;

    public HnSArmorItem(Holder<ArmorMaterial> material, Type type, Properties properties, AttributeContainer... attributeContainers) {
        super(material, type, properties);
        this.defaultModifiers = Suppliers.memoize(() ->
        {
            // Looking at how ISS does this because it is 1 AM and I am tired
            int i = material.value().getDefense(type);
            float f = material.value().toughness();
            ItemAttributeModifiers.Builder builder = ItemAttributeModifiers.builder();
            EquipmentSlotGroup equipmentSlotGroup = EquipmentSlotGroup.bySlot(type.getSlot());
            ResourceLocation resourceLocation = ResourceLocation.withDefaultNamespace("armor." + type.getName());
            builder.add(Attributes.ARMOR, new AttributeModifier(resourceLocation, i, AttributeModifier.Operation.ADD_VALUE), equipmentSlotGroup);
            builder.add(Attributes.ARMOR_TOUGHNESS, new AttributeModifier(resourceLocation, f, AttributeModifier.Operation.ADD_VALUE), equipmentSlotGroup);

            float resistance = material.value().knockbackResistance();
            if (resistance > 0.0F)
            {
                builder.add(Attributes.KNOCKBACK_RESISTANCE, new AttributeModifier(resourceLocation, resistance, AttributeModifier.Operation.ADD_VALUE), equipmentSlotGroup);
            }
            for (AttributeContainer holder : attributeContainers)
            {
                builder.add(holder.attribute(), holder.createModifier(type.getSlot().getName()), equipmentSlotGroup);
            }

            return builder.build();
        });
    }

    public static AttributeContainer[] schoolAttributes(Holder<Attribute> school, int mana, float schoolSpellPower, float spellPower)
    {
        return new AttributeContainer[]{
                new AttributeContainer(AttributeRegistry.MAX_MANA, mana, AttributeModifier.Operation.ADD_VALUE),
                new AttributeContainer(school, schoolSpellPower, AttributeModifier.Operation.ADD_MULTIPLIED_BASE),
                new AttributeContainer(AttributeRegistry.SPELL_POWER, spellPower, AttributeModifier.Operation.ADD_MULTIPLIED_BASE)};
    }

    // Can also be used for giving two attributes, doesn't have to be resistance
    public static AttributeContainer[] schoolAttributesWithResistance(Holder<Attribute> school, Holder<Attribute> resistSchool, int mana, float schoolSpellPower, float spellPower, float resistSpellPower)
    {
        return new AttributeContainer[]{
                new AttributeContainer(AttributeRegistry.MAX_MANA, mana, AttributeModifier.Operation.ADD_VALUE),
                new AttributeContainer(school, schoolSpellPower, AttributeModifier.Operation.ADD_MULTIPLIED_BASE),
                new AttributeContainer(resistSchool, resistSpellPower, AttributeModifier.Operation.ADD_MULTIPLIED_BASE),
                new AttributeContainer(AttributeRegistry.SPELL_POWER, spellPower, AttributeModifier.Operation.ADD_MULTIPLIED_BASE)};
    }

    @Override
    public ItemAttributeModifiers getDefaultAttributeModifiers() {
        return this.defaultModifiers.get();
    }
}