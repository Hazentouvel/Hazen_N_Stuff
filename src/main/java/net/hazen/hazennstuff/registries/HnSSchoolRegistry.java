package net.hazen.hazennstuff.registries;

import io.redspace.ironsspellbooks.api.spells.SchoolType;
import io.redspace.ironsspellbooks.registries.SoundRegistry;
import net.hazen.hazennstuff.HazenNStuff;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Style;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

import static io.redspace.ironsspellbooks.api.registry.SchoolRegistry.SCHOOL_REGISTRY_KEY;

public class HnSSchoolRegistry {
    private static final DeferredRegister<SchoolType> HNS_SCHOOLS = DeferredRegister.create(SCHOOL_REGISTRY_KEY, HazenNStuff.MOD_ID);

    public static void register(IEventBus eventBus)
    {
        HNS_SCHOOLS.register(eventBus);
    }

    private static Supplier<SchoolType> registerSchool(SchoolType type)
    {
        return HNS_SCHOOLS.register(type.getId().getPath(), () -> type);
    }

    public static final ResourceLocation LUMINESCENT_RESOURCE = HazenNStuff.id("luminescent");

    public static final Supplier<SchoolType> LUMINESCENT = registerSchool(new SchoolType
            (
                    LUMINESCENT_RESOURCE,
                    HnSTags.LUMINESCENT_FOCUS,
                    Component.translatable("school.hazennstuff.luminescent").withStyle(Style.EMPTY.withColor(0x2c2fb0)),
                    HnSAttributeRegistry.LUMINESCENT_MAGIC_POWER,
                    HnSAttributeRegistry.LUMINESCENT_MAGIC_RESIST,
                    SoundRegistry.EVOCATION_CAST,
                    HnSDamageTypes.LUMINESCENT_MAGIC
            ));

    public static final ResourceLocation DARK_RESOURCE = HazenNStuff.id("dark");

    public static final Supplier<SchoolType> DARK = registerSchool(new SchoolType
            (
                    DARK_RESOURCE,
                    HnSTags.DARK_FOCUS,
                    Component.translatable("school.hazennstuff.dark").withStyle(Style.EMPTY.withColor(0x553a7f)),
                    HnSAttributeRegistry.DARK_MAGIC_POWER,
                    HnSAttributeRegistry.DARK_MAGIC_RESIST,
                    SoundRegistry.BLOOD_CAST,
                    HnSDamageTypes.DARK_MAGIC
            ));
}