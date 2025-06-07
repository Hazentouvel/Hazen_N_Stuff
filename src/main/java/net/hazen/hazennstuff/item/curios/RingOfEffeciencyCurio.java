package net.hazen.hazennstuff.item.curios;

import com.google.common.collect.LinkedHashMultimap;
import com.google.common.collect.Multimap;
import io.redspace.ironsspellbooks.api.registry.AttributeRegistry;
import io.redspace.ironsspellbooks.item.curios.CurioBaseItem;
import io.redspace.ironsspellbooks.util.ItemPropertiesHelper;
import net.hazen.hazennstuff.rarity.DivineRarity;
import net.minecraft.core.Holder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.item.ItemStack;
import top.theillusivec4.curios.api.SlotContext;

public class RingOfEffeciencyCurio extends CurioBaseItem {
    public RingOfEffeciencyCurio() {
        super(ItemPropertiesHelper.equipment().stacksTo(1).fireResistant().rarity(DivineRarity.DIVINE_RARITY_PROXY.getValue()));
    }

    //naur
    @Override
    public Multimap<Holder<Attribute>, AttributeModifier> getAttributeModifiers(SlotContext slotContext, ResourceLocation id, ItemStack stack) {
        Multimap<Holder<Attribute>, AttributeModifier> attr = LinkedHashMultimap.create();
        //The attributes of the curio
        attr.put(AttributeRegistry.MAX_MANA, new AttributeModifier(id, 150.0, AttributeModifier.Operation.ADD_VALUE));
        attr.put(AttributeRegistry.MANA_REGEN, new AttributeModifier(id, 0.10, AttributeModifier.Operation.ADD_MULTIPLIED_BASE));
        return attr;
    }
}
