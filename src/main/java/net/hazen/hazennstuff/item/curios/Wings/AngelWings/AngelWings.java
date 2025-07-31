package net.hazen.hazennstuff.item.curios.Wings.AngelWings;

import com.google.common.collect.LinkedHashMultimap;
import com.google.common.collect.Multimap;
import dev.shadowsoffire.apothic_attributes.api.ALObjects;
import io.redspace.ironsspellbooks.api.registry.AttributeRegistry;
import io.redspace.ironsspellbooks.util.ItemPropertiesHelper;
import net.hazen.hazennstuff.item.dispatcher.HnSCurioDispatcher;
import net.hazen.hazennstuff.rarity.DeusRarity;
import net.minecraft.core.Holder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.item.ItemStack;
import top.theillusivec4.curios.api.SlotContext;

public class AngelWings extends AngelWingsCurio {
    private final HnSCurioDispatcher dispatcher = new HnSCurioDispatcher();


    public AngelWings() {
        super(ItemPropertiesHelper.equipment()
                .stacksTo(1)
                .fireResistant()
                .rarity(DeusRarity.DEUS_RARITY_PROXY.getValue()), null);
    }

    //naur
    @Override
    public Multimap<Holder<Attribute>, AttributeModifier> getAttributeModifiers(SlotContext slotContext, ResourceLocation id, ItemStack stack) {
        Multimap<Holder<Attribute>, AttributeModifier> attr = LinkedHashMultimap.create();
        //The attributes of the curio
        attr.put(ALObjects.Attributes.ELYTRA_FLIGHT, new AttributeModifier(id, 300.0, AttributeModifier.Operation.ADD_VALUE));
        return attr;
    }
}
