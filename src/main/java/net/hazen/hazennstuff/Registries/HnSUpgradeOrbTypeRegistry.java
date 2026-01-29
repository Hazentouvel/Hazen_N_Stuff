package net.hazen.hazennstuff.Registries;

import io.redspace.ironsspellbooks.item.armor.UpgradeOrbType;
import io.redspace.ironsspellbooks.registries.UpgradeOrbTypeRegistry;
import net.hazen.hazennstuff.HazenNStuff;
import net.minecraft.resources.ResourceKey;

public class HnSUpgradeOrbTypeRegistry {

    public static ResourceKey<UpgradeOrbType> RADIANCE_SPELL_POWER = ResourceKey.create(UpgradeOrbTypeRegistry.UPGRADE_ORB_REGISTRY_KEY, HazenNStuff.id("radiance_power"));
    public static ResourceKey<UpgradeOrbType> SHADOW_SPELL_POWER = ResourceKey.create(UpgradeOrbTypeRegistry.UPGRADE_ORB_REGISTRY_KEY, HazenNStuff.id("shadow_power"));
    public static ResourceKey<UpgradeOrbType> ASTRAL_SPELL_POWER = ResourceKey.create(UpgradeOrbTypeRegistry.UPGRADE_ORB_REGISTRY_KEY, HazenNStuff.id("astral_power"));
    public static ResourceKey<UpgradeOrbType> ELDRITCH_SPELL_POWER = ResourceKey.create(UpgradeOrbTypeRegistry.UPGRADE_ORB_REGISTRY_KEY, HazenNStuff.id("eldritch_power"));

    public static ResourceKey<UpgradeOrbType> MELEE_POWER = ResourceKey.create(UpgradeOrbTypeRegistry.UPGRADE_ORB_REGISTRY_KEY, HazenNStuff.id("melee_power"));
    public static ResourceKey<UpgradeOrbType> HEALTH_POWER = ResourceKey.create(UpgradeOrbTypeRegistry.UPGRADE_ORB_REGISTRY_KEY, HazenNStuff.id("health_power"));
    public static ResourceKey<UpgradeOrbType> ARCHERY_POWER = ResourceKey.create(UpgradeOrbTypeRegistry.UPGRADE_ORB_REGISTRY_KEY, HazenNStuff.id("archery_power"));


    public static ResourceKey<UpgradeOrbType> ENHANCED_FIRE = ResourceKey.create(UpgradeOrbTypeRegistry.UPGRADE_ORB_REGISTRY_KEY, HazenNStuff.id("enhanced_fire_power"));

}