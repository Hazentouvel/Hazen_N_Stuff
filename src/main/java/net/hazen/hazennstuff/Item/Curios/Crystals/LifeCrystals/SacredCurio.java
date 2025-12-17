package net.hazen.hazennstuff.Item.Curios.Crystals.LifeCrystals;

import com.google.common.collect.LinkedHashMultimap;
import com.google.common.collect.Multimap;
import dev.shadowsoffire.apothic_attributes.api.ALObjects;
import io.redspace.ironsspellbooks.item.curios.CurioBaseItem;
import io.redspace.ironsspellbooks.util.ItemPropertiesHelper;
import net.minecraft.core.Holder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import top.theillusivec4.curios.api.SlotContext;

public class SacredCurio extends CurioBaseItem {
    public SacredCurio() {
        super(ItemPropertiesHelper
                .equipment()
                .stacksTo(1)
                .fireResistant()
                .rarity(Rarity.EPIC));
    }

    //naur
    @Override
    public Multimap<Holder<Attribute>, AttributeModifier> getAttributeModifiers(SlotContext slotContext, ResourceLocation id, ItemStack stack) {
        Multimap<Holder<Attribute>, AttributeModifier> attr = LinkedHashMultimap.create();
        //The attributes of the curio
        attr.put(Attributes.MAX_HEALTH, new AttributeModifier(id, 10.0, AttributeModifier.Operation.ADD_VALUE));
        attr.put(ALObjects.Attributes.HEALING_RECEIVED, new AttributeModifier(id, 0.10, AttributeModifier.Operation.ADD_MULTIPLIED_BASE));
        return attr;
    }
}
