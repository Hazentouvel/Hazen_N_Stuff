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

    public static final ResourceKey<DamageType> LUMINESCENT_MAGIC = register("luminescent");
    public static final ResourceKey<DamageType> DARK_MAGIC = register("corrupt");

    public static void bootstrap(BootstrapContext<DamageType> context)
    {
        context.register(LUMINESCENT_MAGIC, new DamageType(LUMINESCENT_MAGIC.location().getPath(), DamageScaling.WHEN_CAUSED_BY_LIVING_NON_PLAYER, 0F));
        context.register(DARK_MAGIC, new DamageType(DARK_MAGIC.location().getPath(), DamageScaling.WHEN_CAUSED_BY_LIVING_NON_PLAYER, 0F));
    }
}