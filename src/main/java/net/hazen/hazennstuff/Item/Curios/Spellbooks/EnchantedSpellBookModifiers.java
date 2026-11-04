package net.hazen.hazennstuff.Item.Curios.Spellbooks;

import net.hazen.hazennstuff.HazenNStuff;
import net.hazen.hazentouvelib.Datagen.HLTags;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EquipmentSlotGroup;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentEffectComponents;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.GatherSkippedAttributeTooltipsEvent;
import top.theillusivec4.curios.api.event.CurioAttributeModifierEvent;

@EventBusSubscriber(modid = HazenNStuff.MOD_ID)
public class EnchantedSpellBookModifiers {
    @SubscribeEvent
    public static void enchantedSpellBook(CurioAttributeModifierEvent event) {
        if (!"spellbook".equals(event.getSlotContext().identifier())) return;
        if (!(event.getItemStack().is(HLTags.ENCHANTED_SPELLBOOK))) return;
        if (event.getSlotContext().entity() == null) return;

        var enchantments = event.getItemStack().getAllEnchantments(event.getSlotContext().entity().registryAccess().lookupOrThrow(Registries.ENCHANTMENT));
        for (var entry : enchantments.entrySet()) {
            addEnchantmentAttributes(event, entry.getKey(), entry.getIntValue());
        }
    }
    @SubscribeEvent
    public static void hideVanillaAttributes(GatherSkippedAttributeTooltipsEvent event) {
        if (!event.getStack().is(HLTags.ENCHANTED_SPELLBOOK)) return;
        event.skipGroup(EquipmentSlotGroup.ANY);
    }

    private static void addEnchantmentAttributes(
            CurioAttributeModifierEvent event,
            Holder<Enchantment> enchantment,
            int level
    ) {
        var context = event.getSlotContext();
        for (var effect : enchantment.value()
                .getEffects(EnchantmentEffectComponents.ATTRIBUTES)) {
            var id = ResourceLocation.fromNamespaceAndPath(
                    effect.id().getNamespace(),
                    effect.id().getPath() + "/curios/"
                            + context.identifier() + "/" + context.index()
            );
            event.addModifier(
                    effect.attribute(),
                    new AttributeModifier(
                            id,
                            effect.amount().calculate(level),
                            effect.operation()
                    )
            );
        }
    }
}
