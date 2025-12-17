package net.hazen.hazennstuff.Item.Staves;

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
            new AttributeContainer(HnSAttributeRegistry.SHADOW_MAGIC_POWER, .15, AttributeModifier.Operation.ADD_MULTIPLIED_BASE),
            new AttributeContainer(AttributeRegistry.SPELL_POWER, .05, AttributeModifier.Operation.ADD_MULTIPLIED_BASE)
    );

    // White Lily Staff
    public static HnSStaffTier WHITE_LILY_STAFF = new HnSStaffTier(3, -3,
            new AttributeContainer(AttributeRegistry.NATURE_SPELL_POWER, .15, AttributeModifier.Operation.ADD_MULTIPLIED_BASE),
            new AttributeContainer(AttributeRegistry.MANA_REGEN, .15, AttributeModifier.Operation.ADD_MULTIPLIED_BASE),
            new AttributeContainer(AttributeRegistry.SPELL_POWER, .05, AttributeModifier.Operation.ADD_MULTIPLIED_BASE)
    );

    // RoD
    public static HnSStaffTier SOULCALLING_SCEPTER = new HnSStaffTier(3, -2.4F,
            new AttributeContainer(AttributeRegistry.FIRE_SPELL_POWER, .15, AttributeModifier.Operation.ADD_MULTIPLIED_BASE),
            new AttributeContainer(AttributeRegistry.MANA_REGEN, .1, AttributeModifier.Operation.ADD_MULTIPLIED_BASE),
            new AttributeContainer(AttributeRegistry.CAST_TIME_REDUCTION, .15, AttributeModifier.Operation.ADD_MULTIPLIED_BASE),
            new AttributeContainer(ASAttributeRegistry.MANA_REND, .1, AttributeModifier.Operation.ADD_MULTIPLIED_BASE),
            new AttributeContainer(AttributeRegistry.SPELL_POWER, .1, AttributeModifier.Operation.ADD_MULTIPLIED_BASE)
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