package net.hazen.hazennstuff.Registries;

import io.redspace.ironsspellbooks.api.spells.SchoolType;
import io.redspace.ironsspellbooks.registries.SoundRegistry;
import net.hazen.hazennstuff.Datagen.HnSTags;
import net.hazen.hazennstuff.HazenNStuff;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Style;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

import static io.redspace.ironsspellbooks.api.registry.SchoolRegistry.SCHOOL_REGISTRY_KEY;

public class HnSSchoolRegistry {
    private static final DeferredRegister<SchoolType> HnS_SCHOOLS = DeferredRegister.create(SCHOOL_REGISTRY_KEY, HazenNStuff.MOD_ID);

    public static void register(IEventBus eventBus)
    {
        HnS_SCHOOLS.register(eventBus);
    }

    private static Supplier<SchoolType> registerSchool(SchoolType type)
    {
        return HnS_SCHOOLS.register(type.getId().getPath(), () -> type);
    }

    public static final ResourceLocation RADIANCE_RESOURCE = HazenNStuff.id("radiance");

    public static final Supplier<SchoolType> RADIANCE = registerSchool(new SchoolType
            (
                    RADIANCE_RESOURCE,
                    HnSTags.RADIANCE_FOCUS,
                    Component.translatable("school.hazennstuff.radiance").withStyle(Style.EMPTY.withColor(0xe4a6ea)),
                    HnSAttributeRegistry.RADIANCE_SPELL_POWER,
                    HnSAttributeRegistry.RADIANCE_SPELL_RESIST,
                    SoundRegistry.EVOCATION_CAST,
                    HnSDamageTypes.RADIANCE_MAGIC
            ));

    public static final ResourceLocation SHADOW_RESOURCE = HazenNStuff.id("shadow");

    public static final Supplier<SchoolType> SHADOW = registerSchool(new SchoolType
            (
                    SHADOW_RESOURCE,
                    HnSTags.SHADOW_FOCUS,
                    Component.translatable("school.hazennstuff.shadow").withStyle(Style.EMPTY.withColor(0x553a7f)),
                    HnSAttributeRegistry.SHADOW_SPELL_POWER,
                    HnSAttributeRegistry.SHADOW_SPELL_RESIST,
                    SoundRegistry.BLOOD_CAST,
                    HnSDamageTypes.SHADOW_MAGIC
            ));
}