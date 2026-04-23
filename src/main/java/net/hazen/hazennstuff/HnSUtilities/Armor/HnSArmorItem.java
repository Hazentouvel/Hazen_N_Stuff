package net.hazen.hazennstuff.HnSUtilities.Armor;

import com.google.common.base.Suppliers;
import io.redspace.ironsspellbooks.api.registry.AttributeRegistry;
import io.redspace.ironsspellbooks.api.spells.ISpellContainer;
import io.redspace.ironsspellbooks.item.weapons.AttributeContainer;
import io.redspace.ironsspellbooks.registries.ComponentRegistry;
import net.hazen.hazennstuff.HnSUtilities.Animations.HnSDispatcher;
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

public class HnSArmorItem extends ArmorItem {

    public HnSArmorItem(Holder<ArmorMaterial> material, Type type, Properties properties) {
        super(material, type, properties);
    }

    public static AttributeContainer[] dormantTier(Holder<Attribute> school1) {
        return new AttributeContainer[]{
                new AttributeContainer(school1, 0.05, AttributeModifier.Operation.ADD_MULTIPLIED_BASE),
                new AttributeContainer(AttributeRegistry.MAX_MANA, (double)50.0F, AttributeModifier.Operation.ADD_VALUE)
        };
    }

    public static AttributeContainer[] dormantTierDual(Holder<Attribute> school1, Holder<Attribute> school2) {
        return new AttributeContainer[]{
                new AttributeContainer(school1, 0.05, AttributeModifier.Operation.ADD_MULTIPLIED_BASE),
                new AttributeContainer(school2, 0.05, AttributeModifier.Operation.ADD_MULTIPLIED_BASE),
                new AttributeContainer(AttributeRegistry.MAX_MANA, (double)50.0F, AttributeModifier.Operation.ADD_VALUE)
        };
    }

    public static AttributeContainer[] dormantTierMulti(Holder<Attribute> school1, Holder<Attribute> school2, Holder<Attribute> school3) {
        return new AttributeContainer[]{
                new AttributeContainer(school1, 0.05, AttributeModifier.Operation.ADD_MULTIPLIED_BASE),
                new AttributeContainer(school2, 0.05, AttributeModifier.Operation.ADD_MULTIPLIED_BASE),
                new AttributeContainer(school3, 0.05, AttributeModifier.Operation.ADD_MULTIPLIED_BASE),
                new AttributeContainer(AttributeRegistry.MAX_MANA, (double)50.0F, AttributeModifier.Operation.ADD_VALUE)
        };
    }

    public static AttributeContainer[] schoolTierDual(Holder<Attribute> school1, Holder<Attribute> school2) {
        return new AttributeContainer[]{
                new AttributeContainer(school1, 0.1, AttributeModifier.Operation.ADD_MULTIPLIED_BASE),
                new AttributeContainer(school2, 0.1, AttributeModifier.Operation.ADD_MULTIPLIED_BASE),
                new AttributeContainer(AttributeRegistry.MAX_MANA, (double)125.0F, AttributeModifier.Operation.ADD_VALUE),
                new AttributeContainer(AttributeRegistry.SPELL_POWER, 0.05, AttributeModifier.Operation.ADD_MULTIPLIED_BASE)
        };
    }

    public static AttributeContainer[] schoolTierMulti(Holder<Attribute> school1, Holder<Attribute> school2, Holder<Attribute> school3) {
        return new AttributeContainer[]{
                new AttributeContainer(school1, 0.1, AttributeModifier.Operation.ADD_MULTIPLIED_BASE),
                new AttributeContainer(school2, 0.1, AttributeModifier.Operation.ADD_MULTIPLIED_BASE),
                new AttributeContainer(school3, 0.1, AttributeModifier.Operation.ADD_MULTIPLIED_BASE),
                new AttributeContainer(AttributeRegistry.MAX_MANA, (double)125.0F, AttributeModifier.Operation.ADD_VALUE),
                new AttributeContainer(AttributeRegistry.SPELL_POWER, 0.05, AttributeModifier.Operation.ADD_MULTIPLIED_BASE)};
    }

    public static AttributeContainer[] pureTier(Holder<Attribute> school)
    {
        return new AttributeContainer[]{
                new AttributeContainer(school, 0.15f, AttributeModifier.Operation.ADD_MULTIPLIED_BASE),
                new AttributeContainer(AttributeRegistry.MAX_MANA, 200, AttributeModifier.Operation.ADD_VALUE),
                new AttributeContainer(AttributeRegistry.SPELL_POWER, .15f, AttributeModifier.Operation.ADD_MULTIPLIED_BASE),
                new AttributeContainer(AttributeRegistry.ELDRITCH_SPELL_POWER, 0.05f, AttributeModifier.Operation.ADD_MULTIPLIED_BASE),
        };
    }

    public static AttributeContainer[] pureTierMulti(Holder<Attribute> school1, Holder<Attribute> school2)
    {
        return new AttributeContainer[]{
                new AttributeContainer(school1, 0.15f, AttributeModifier.Operation.ADD_MULTIPLIED_BASE),
                new AttributeContainer(school2, 0.15f, AttributeModifier.Operation.ADD_MULTIPLIED_BASE),
                new AttributeContainer(AttributeRegistry.SPELL_POWER, .15f, AttributeModifier.Operation.ADD_MULTIPLIED_BASE),
                new AttributeContainer(AttributeRegistry.MAX_MANA, 200, AttributeModifier.Operation.ADD_VALUE),
        };
    }

    public static AttributeContainer[] pureTierTri(Holder<Attribute> school1, Holder<Attribute> school2)
    {
        return new AttributeContainer[]{
                new AttributeContainer(school1, 0.15f, AttributeModifier.Operation.ADD_MULTIPLIED_BASE),
                new AttributeContainer(school2, 0.15f, AttributeModifier.Operation.ADD_MULTIPLIED_BASE),
                new AttributeContainer(school2, 0.15f, AttributeModifier.Operation.ADD_MULTIPLIED_BASE),
                new AttributeContainer(AttributeRegistry.SPELL_POWER, .15f, AttributeModifier.Operation.ADD_MULTIPLIED_BASE),
                new AttributeContainer(AttributeRegistry.MAX_MANA, 200, AttributeModifier.Operation.ADD_VALUE),
        };
    }

    public static AttributeContainer[] paragonTier(Holder<Attribute> school)
    {
        return new AttributeContainer[]{
                new AttributeContainer(school, 0.2f, AttributeModifier.Operation.ADD_MULTIPLIED_BASE),
                new AttributeContainer(AttributeRegistry.MAX_MANA, 300, AttributeModifier.Operation.ADD_VALUE),
                new AttributeContainer(AttributeRegistry.SPELL_RESIST, 0.15f, AttributeModifier.Operation.ADD_MULTIPLIED_BASE),
                new AttributeContainer(AttributeRegistry.SPELL_POWER, 0.15f, AttributeModifier.Operation.ADD_MULTIPLIED_BASE),
        };
    }

    public static AttributeContainer[] paragonTierMulti(Holder<Attribute> school1, Holder<Attribute> school2)
    {
        return new AttributeContainer[]{
                new AttributeContainer(school1, 0.2f, AttributeModifier.Operation.ADD_MULTIPLIED_BASE),
                new AttributeContainer(school2, 0.2f, AttributeModifier.Operation.ADD_MULTIPLIED_BASE),
                new AttributeContainer(AttributeRegistry.MAX_MANA, 300, AttributeModifier.Operation.ADD_VALUE),
                new AttributeContainer(AttributeRegistry.SPELL_RESIST, 0.15f, AttributeModifier.Operation.ADD_MULTIPLIED_BASE),
                new AttributeContainer(AttributeRegistry.SPELL_POWER, 0.15f, AttributeModifier.Operation.ADD_MULTIPLIED_BASE),
        };
    }

    public static AttributeContainer[] paragonTierTri(Holder<Attribute> school1, Holder<Attribute> school2, Holder<Attribute> school3)
    {
        return new AttributeContainer[]{
                new AttributeContainer(school1, 0.2f, AttributeModifier.Operation.ADD_MULTIPLIED_BASE),
                new AttributeContainer(school2, 0.2f, AttributeModifier.Operation.ADD_MULTIPLIED_BASE),
                new AttributeContainer(school3, 0.2f, AttributeModifier.Operation.ADD_MULTIPLIED_BASE),
                new AttributeContainer(AttributeRegistry.MAX_MANA, 300, AttributeModifier.Operation.ADD_VALUE),
                new AttributeContainer(AttributeRegistry.SPELL_RESIST, 0.15f, AttributeModifier.Operation.ADD_MULTIPLIED_BASE),
                new AttributeContainer(AttributeRegistry.SPELL_POWER, 0.15f, AttributeModifier.Operation.ADD_MULTIPLIED_BASE),
        };
    }

    public void initializeSpellContainer(ItemStack itemStack) {
        if (itemStack == null)
        {
            return;
        }

        if (itemStack.getItem() instanceof ArmorItem armorItem)
        {
            if (armorItem.getType() == Type.CHESTPLATE)
            {
                if (!ISpellContainer.isSpellContainer(itemStack))
                {
                    var spellContainer = ISpellContainer.create(1, true, true);
                    itemStack.set(ComponentRegistry.SPELL_CONTAINER, spellContainer);
                }
            }
        }
    }

}