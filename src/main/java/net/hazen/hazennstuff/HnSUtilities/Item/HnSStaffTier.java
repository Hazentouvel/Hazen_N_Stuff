package net.hazen.hazennstuff.HnSUtilities.Item;

import dev.shadowsoffire.apothic_attributes.api.ALObjects;
import io.redspace.ironsspellbooks.api.registry.AttributeRegistry;
import io.redspace.ironsspellbooks.item.weapons.AttributeContainer;
import io.redspace.ironsspellbooks.item.weapons.IronsWeaponTier;
import net.acetheeldritchking.aces_spell_utils.registries.ASAttributeRegistry;
import net.hazen.hazennstuff.Registries.HnSAttributeRegistry;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;

public class HnSStaffTier implements IronsWeaponTier {
    // Artificer
    public static HnSStaffTier ARTIFICER = new HnSStaffTier(3, -3,
            new AttributeContainer(AttributeRegistry.CAST_TIME_REDUCTION, .15, AttributeModifier.Operation.ADD_MULTIPLIED_BASE),
            new AttributeContainer(AttributeRegistry.COOLDOWN_REDUCTION, .15, AttributeModifier.Operation.ADD_MULTIPLIED_BASE),
            new AttributeContainer(AttributeRegistry.SPELL_POWER, .10, AttributeModifier.Operation.ADD_MULTIPLIED_BASE)
    );

    // RoD
    public static HnSStaffTier ROD_OF_DISCORD = new HnSStaffTier(3, -3,
            new AttributeContainer(AttributeRegistry.ENDER_SPELL_POWER, .15, AttributeModifier.Operation.ADD_MULTIPLIED_BASE),
            new AttributeContainer(HnSAttributeRegistry.SHADOW_SPELL_POWER, .15, AttributeModifier.Operation.ADD_MULTIPLIED_BASE),
            new AttributeContainer(AttributeRegistry.SPELL_POWER, .05, AttributeModifier.Operation.ADD_MULTIPLIED_BASE)
    );

    // White Lily Staff
    public static HnSStaffTier WHITE_LILY_STAFF = new HnSStaffTier(3, -3,
            new AttributeContainer(AttributeRegistry.NATURE_SPELL_POWER, .15, AttributeModifier.Operation.ADD_MULTIPLIED_BASE),
            new AttributeContainer(AttributeRegistry.MANA_REGEN, .15, AttributeModifier.Operation.ADD_MULTIPLIED_BASE),
            new AttributeContainer(AttributeRegistry.SPELL_POWER, .05, AttributeModifier.Operation.ADD_MULTIPLIED_BASE)
    );

    // Soulcalling Scepter
    public static HnSStaffTier SOULCALLING_SCEPTER = new HnSStaffTier(3, -2.4F,
            new AttributeContainer(AttributeRegistry.FIRE_SPELL_POWER, .15, AttributeModifier.Operation.ADD_MULTIPLIED_BASE),
            new AttributeContainer(AttributeRegistry.MANA_REGEN, .1, AttributeModifier.Operation.ADD_MULTIPLIED_BASE),
            new AttributeContainer(AttributeRegistry.CAST_TIME_REDUCTION, .15, AttributeModifier.Operation.ADD_MULTIPLIED_BASE),
            new AttributeContainer(ASAttributeRegistry.MANA_REND, .1, AttributeModifier.Operation.ADD_MULTIPLIED_BASE),
            new AttributeContainer(AttributeRegistry.SPELL_POWER, .1, AttributeModifier.Operation.ADD_MULTIPLIED_BASE)
    );

    // Divine Scepter
    public static HnSStaffTier DIVINE_SCEPTER = new HnSStaffTier(3, -3,
            new AttributeContainer(AttributeRegistry.HOLY_SPELL_POWER, .15, AttributeModifier.Operation.ADD_MULTIPLIED_BASE),
            new AttributeContainer(AttributeRegistry.CAST_TIME_REDUCTION, .15, AttributeModifier.Operation.ADD_MULTIPLIED_BASE),
            new AttributeContainer(AttributeRegistry.CASTING_MOVESPEED, .15, AttributeModifier.Operation.ADD_MULTIPLIED_BASE),
            new AttributeContainer(AttributeRegistry.SPELL_POWER, .05, AttributeModifier.Operation.ADD_MULTIPLIED_BASE)
    );

    // Blossom of the Enchantress
    public static HnSStaffTier BLOSSOM_OF_THE_ENCHANTRESS = new HnSStaffTier(3, -3,
            new AttributeContainer(AttributeRegistry.NATURE_SPELL_POWER, .15, AttributeModifier.Operation.ADD_MULTIPLIED_BASE),
            new AttributeContainer(ALObjects.Attributes.HEALING_RECEIVED, .15, AttributeModifier.Operation.ADD_MULTIPLIED_BASE),
            new AttributeContainer(AttributeRegistry.SPELL_RESIST, .15, AttributeModifier.Operation.ADD_MULTIPLIED_BASE),
            new AttributeContainer(AttributeRegistry.SPELL_POWER, .05, AttributeModifier.Operation.ADD_MULTIPLIED_BASE)
    );

    // Grimoire Staff
    public static HnSStaffTier GRIMOIRE_STAFF = new HnSStaffTier(3, -3,
            new AttributeContainer(AttributeRegistry.EVOCATION_SPELL_POWER, .15, AttributeModifier.Operation.ADD_MULTIPLIED_BASE),
            new AttributeContainer(AttributeRegistry.COOLDOWN_REDUCTION, .15, AttributeModifier.Operation.ADD_MULTIPLIED_BASE),
            new AttributeContainer(AttributeRegistry.CASTING_MOVESPEED, .15, AttributeModifier.Operation.ADD_MULTIPLIED_BASE),
            new AttributeContainer(AttributeRegistry.SPELL_POWER, .05, AttributeModifier.Operation.ADD_MULTIPLIED_BASE)
    );

    // Enderconic Scepter
    public static HnSStaffTier ENDERCONIC_SCEPTER = new HnSStaffTier(3, -3,
            new AttributeContainer(AttributeRegistry.ENDER_SPELL_POWER, .15, AttributeModifier.Operation.ADD_MULTIPLIED_BASE),
            new AttributeContainer(AttributeRegistry.SPELL_RESIST, .05, AttributeModifier.Operation.ADD_MULTIPLIED_BASE),
            new AttributeContainer(AttributeRegistry.SPELL_POWER, .1, AttributeModifier.Operation.ADD_MULTIPLIED_BASE)
    );

    // Insania Aeternus
    public static HnSStaffTier INSANIA_AETERNUS = new HnSStaffTier(3, -3,
            new AttributeContainer(AttributeRegistry.ELDRITCH_SPELL_POWER, .15, AttributeModifier.Operation.ADD_MULTIPLIED_BASE),
            new AttributeContainer(AttributeRegistry.COOLDOWN_REDUCTION, .15, AttributeModifier.Operation.ADD_MULTIPLIED_BASE),
            new AttributeContainer(AttributeRegistry.CAST_TIME_REDUCTION, .05, AttributeModifier.Operation.ADD_MULTIPLIED_BASE),
            new AttributeContainer(AttributeRegistry.SPELL_POWER, .05, AttributeModifier.Operation.ADD_MULTIPLIED_BASE)
    );

    // Glassweaver Staff
    public static HnSStaffTier GLASSWEAVER_SCEPTER = new HnSStaffTier(3, -3,
            new AttributeContainer(HnSAttributeRegistry.RADIANCE_SPELL_POWER, .15, AttributeModifier.Operation.ADD_MULTIPLIED_BASE),
            new AttributeContainer(AttributeRegistry.COOLDOWN_REDUCTION, .15, AttributeModifier.Operation.ADD_MULTIPLIED_BASE),
            new AttributeContainer(AttributeRegistry.SPELL_POWER, .05, AttributeModifier.Operation.ADD_MULTIPLIED_BASE)
    );

    // Ceaseless Void
    public static HnSStaffTier CEASELESS_VOID = new HnSStaffTier(3, -3,
            new AttributeContainer(HnSAttributeRegistry.SHADOW_SPELL_POWER, .15, AttributeModifier.Operation.ADD_MULTIPLIED_BASE),
            new AttributeContainer(AttributeRegistry.CAST_TIME_REDUCTION, .05, AttributeModifier.Operation.ADD_MULTIPLIED_BASE),
            new AttributeContainer(AttributeRegistry.SPELL_POWER, .05, AttributeModifier.Operation.ADD_MULTIPLIED_BASE)
    );

    // Coralite Cane
    public static HnSStaffTier CORALITE_CANE = new HnSStaffTier(3, -3,
            new AttributeContainer(ASAttributeRegistry.HYDRO_MAGIC_POWER, .15, AttributeModifier.Operation.ADD_MULTIPLIED_BASE),
            new AttributeContainer(AttributeRegistry.CAST_TIME_REDUCTION, .05, AttributeModifier.Operation.ADD_MULTIPLIED_BASE),
            new AttributeContainer(AttributeRegistry.SPELL_POWER, .05, AttributeModifier.Operation.ADD_MULTIPLIED_BASE)
    );

    // Nexus
    public static HnSStaffTier NEXUS = new HnSStaffTier(3, -3,
            new AttributeContainer(HnSAttributeRegistry.COSMIC_SPELL_POWER, .15, AttributeModifier.Operation.ADD_MULTIPLIED_BASE),
            new AttributeContainer(AttributeRegistry.CAST_TIME_REDUCTION, .05, AttributeModifier.Operation.ADD_MULTIPLIED_BASE),
            new AttributeContainer(AttributeRegistry.SPELL_POWER, .05, AttributeModifier.Operation.ADD_MULTIPLIED_BASE)
    );

    float damage;
    float speed;
    AttributeContainer[] attributeContainers;

    public HnSStaffTier(float damage, float speed, AttributeContainer... attributeContainers)
    {
        this.damage = damage;
        this.speed = speed;
        this.attributeContainers = attributeContainers;
    }

    @Override
    public float getAttackDamageBonus() {
        return damage;
    }

    @Override
    public float getSpeed() {
        return speed;
    }

    @Override
    public AttributeContainer[] getAdditionalAttributes() {
        return this.attributeContainers;
    }
}