package net.hazen.hazennstuff.Registries;

import io.redspace.ironsspellbooks.api.attribute.MagicRangedAttribute;
import net.hazen.hazennstuff.HazenNStuff;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.EntityAttributeModificationEvent;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

@EventBusSubscriber(value = Dist.CLIENT)
public class HnSAttributeRegistry {
    private static final DeferredRegister<Attribute> ATTRIBUTES = DeferredRegister.create(Registries.ATTRIBUTE, HazenNStuff.MOD_ID);

    public static final DeferredHolder<Attribute, Attribute> RADIANCE_SPELL_RESIST = registerResistanceAttribute("radiance");
    public static final DeferredHolder<Attribute, Attribute> SHADOW_SPELL_RESIST = registerResistanceAttribute("shadow");
    public static final DeferredHolder<Attribute, Attribute> COSMIC_SPELL_RESIST = registerResistanceAttribute("cosmic");

    public static final DeferredHolder<Attribute, Attribute> RADIANCE_SPELL_POWER = registerPowerAttribute("radiance");
    public static final DeferredHolder<Attribute, Attribute> SHADOW_SPELL_POWER = registerPowerAttribute("shadow");
    public static final DeferredHolder<Attribute, Attribute> COSMIC_SPELL_POWER = registerPowerAttribute("cosmic");

    public static void register(IEventBus eventBus)
    {
        ATTRIBUTES.register(eventBus);
    }

    @SubscribeEvent
    public static void modifyEntityAttributes(EntityAttributeModificationEvent event)
    {
        event.getTypes().forEach(entityType ->
                ATTRIBUTES.getEntries().forEach(
                        attributeDeferredHolder -> event.add(entityType, attributeDeferredHolder
                        )));
    }

    // ;_;
    private static DeferredHolder<Attribute, Attribute> registerResistanceAttribute(String id)
    {
        return ATTRIBUTES.register(id + "_magic_resist", () ->
                (new MagicRangedAttribute("attribute.hazennstuff." + id + "_magic_resist",
                        1.0D, 0, 10).setSyncable(true)));
    }

    private static DeferredHolder<Attribute, Attribute> registerPowerAttribute(String id)
    {
        return ATTRIBUTES.register(id + "_spell_power", () ->
                (new MagicRangedAttribute("attribute.hazennstuff." + id + "_spell_power",
                        1.0D, 0, 10).setSyncable(true)));
    }
}