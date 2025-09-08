package net.hazen.hazennstuff.registries;

import io.redspace.ironsspellbooks.item.armor.UpgradeOrbType;
import io.redspace.ironsspellbooks.registries.UpgradeOrbTypeRegistry;
import net.hazen.hazennstuff.HazenNStuff;
import net.minecraft.resources.ResourceKey;

public class HnSUpgradeOrbTypeRegistry {

    public static ResourceKey<UpgradeOrbType> RADIANCE_SPELL_POWER = ResourceKey.create(UpgradeOrbTypeRegistry.UPGRADE_ORB_REGISTRY_KEY, HazenNStuff.id("luminescent_power"));
    public static ResourceKey<UpgradeOrbType> SHADOW_SPELL_POWER = ResourceKey.create(UpgradeOrbTypeRegistry.UPGRADE_ORB_REGISTRY_KEY, HazenNStuff.id("dark_power"));
    public static ResourceKey<UpgradeOrbType> MELEE_POWER = ResourceKey.create(UpgradeOrbTypeRegistry.UPGRADE_ORB_REGISTRY_KEY, HazenNStuff.id("melee_power"));
    public static ResourceKey<UpgradeOrbType> HEALTH_POWER = ResourceKey.create(UpgradeOrbTypeRegistry.UPGRADE_ORB_REGISTRY_KEY, HazenNStuff.id("health_power"));
    public static ResourceKey<UpgradeOrbType> ARCHERY_POWER = ResourceKey.create(UpgradeOrbTypeRegistry.UPGRADE_ORB_REGISTRY_KEY, HazenNStuff.id("archery_power"));
}