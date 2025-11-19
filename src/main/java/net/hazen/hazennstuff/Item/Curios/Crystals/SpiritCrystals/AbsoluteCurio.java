package net.hazen.hazennstuff.Item.Curios.Crystals.SpiritCrystals;

import com.google.common.collect.LinkedHashMultimap;
import com.google.common.collect.Multimap;
import dev.shadowsoffire.apothic_attributes.api.ALObjects;
import io.redspace.ironsspellbooks.item.curios.CurioBaseItem;
import io.redspace.ironsspellbooks.util.ItemPropertiesHelper;
import net.hazen.hazennstuff.Rarity.HnSRarities;
import net.minecraft.core.Holder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.item.ItemStack;
import top.theillusivec4.curios.api.SlotContext;

public class AbsoluteCurio extends CurioBaseItem {
    public AbsoluteCurio() {
        super(ItemPropertiesHelper
                .equipment()
                .stacksTo(1)
                .fireResistant()
                .rarity(HnSRarities.DEUS_RARITY.getValue()));
    }

    //naur
    @Override
    public Multimap<Holder<Attribute>, AttributeModifier> getAttributeModifiers(SlotContext slotContext, ResourceLocation id, ItemStack stack) {
        Multimap<Holder<Attribute>, AttributeModifier> attr = LinkedHashMultimap.create();
        //The attributes of the curio
        attr.put(Attributes.ATTACK_DAMAGE, new AttributeModifier(id, 4.0, AttributeModifier.Operation.ADD_VALUE));
        attr.put(Attributes.ATTACK_SPEED, new AttributeModifier(id, 0.15, AttributeModifier.Operation.ADD_MULTIPLIED_BASE));
        attr.put(ALObjects.Attributes.ARROW_DAMAGE, new AttributeModifier(id, 4.0, AttributeModifier.Operation.ADD_VALUE));
        attr.put(ALObjects.Attributes.ARROW_VELOCITY, new AttributeModifier(id, 0.15, AttributeModifier.Operation.ADD_VALUE));
        return attr;
    }
}
