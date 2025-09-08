package net.hazen.hazennstuff.registries;

import net.hazen.hazennstuff.HazenNStuff;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.damagesource.DamageScaling;
import net.minecraft.world.damagesource.DamageType;

public class HnSDamageTypes {
    public static ResourceKey<DamageType> register(String name) {
        return ResourceKey.create(
                Registries.DAMAGE_TYPE,
                ResourceLocation.parse(ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, name).toString())
        );
    }

    public static final ResourceKey<DamageType> RADIANCE_MAGIC = register("radiance");
    public static final ResourceKey<DamageType> SHADOW_MAGIC = register("shadow");

    public static void bootstrap(BootstrapContext<DamageType> context)
    {
        context.register(RADIANCE_MAGIC, new DamageType(RADIANCE_MAGIC.location().getPath(), DamageScaling.WHEN_CAUSED_BY_LIVING_NON_PLAYER, 0F));
        context.register(SHADOW_MAGIC, new DamageType(SHADOW_MAGIC.location().getPath(), DamageScaling.WHEN_CAUSED_BY_LIVING_NON_PLAYER, 0F));
    }
}