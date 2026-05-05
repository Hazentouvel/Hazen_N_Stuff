package net.hazen.hazennstuff.HnSUtilities.Armor;

import com.google.common.base.Suppliers;
import io.redspace.ironsspellbooks.api.registry.AttributeRegistry;
import io.redspace.ironsspellbooks.item.weapons.AttributeContainer;
import net.hazen.hazennstuff.HnSUtilities.Animations.HnSDispatcher;
import net.hazen.hazentouvelib.Items.Armor.HLArmorItem;
import net.minecraft.core.Holder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EquipmentSlotGroup;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.component.ItemAttributeModifiers;

import java.util.List;
import java.util.function.Supplier;

public class HnSAzureLibArmorItem extends HLArmorItem {
    private final Supplier<ItemAttributeModifiers> defaultModifiers;
    public final HnSDispatcher dispatcher;

    public HnSAzureLibArmorItem(Holder<ArmorMaterial> material, Type type, Properties properties, AttributeContainer... attributeContainers) {
        super(material, type, properties);
        this.dispatcher = new HnSDispatcher();

        this.defaultModifiers = Suppliers.memoize(() ->
        {
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

    @Override
    public ItemAttributeModifiers getDefaultAttributeModifiers() {
        return this.defaultModifiers.get();
    }

    public List<ItemAttributeModifiers.Entry> createExtraAttributes() {
        return List.of(); // or Collections.emptyList();
    }

    @Override
    public ItemAttributeModifiers getDefaultAttributeModifiers(ItemStack stack) {
        ItemAttributeModifiers modifiers = super.getDefaultAttributeModifiers(stack);
        ItemAttributeModifiers.Builder builder = ItemAttributeModifiers.builder();

        List<ItemAttributeModifiers.Entry> entries = modifiers.modifiers();
        for (ItemAttributeModifiers.Entry entry : entries) {
            builder.add(entry.attribute(), entry.modifier(), entry.slot());
        }

        List<ItemAttributeModifiers.Entry> extraEntries = createExtraAttributes();
        for (ItemAttributeModifiers.Entry entry : extraEntries) {
            builder.add(entry.attribute(), entry.modifier(), entry.slot());
        }

        return builder.build();
    }
}