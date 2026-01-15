package net.hazen.hazennstuff.Items.Extensions;

import io.redspace.ironsspellbooks.registries.ItemRegistry;
import net.hazen.hazennstuff.Registries.ItemRegistries.HnSMaterialItemRegistry;
import net.minecraft.util.LazyLoadedValue;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;

import java.util.function.Supplier;

public enum HnSExtendedWeaponTiers implements Tier {
    FIREBLOSSOM_RAPIER(3, 4800, -2.7f, 10, 16, () -> Ingredient.of(Items.BLAZE_ROD)),
    ICE_PIKE(3, 1000, -2.6f, 5, 16, () -> Ingredient.of(HnSMaterialItemRegistry.ZENALITE_INGOT.get())),
    IONIC_SPLITTER(3, 1000, -2.6f, 5, 16, () -> Ingredient.of(HnSMaterialItemRegistry.ZENALITE_INGOT.get())),
    O_FORTUNA(3, 1000, -2.6f, 5, 16, () -> Ingredient.of(HnSMaterialItemRegistry.ZENALITE_INGOT.get())),
    UMBRANOVA(3, 1000, -2.6f, 5, 16, () -> Ingredient.of(HnSMaterialItemRegistry.ZENALITE_INGOT.get())),
    DEVESTATION(3, 1000, -2.6f, 5, 16, () -> Ingredient.of(HnSMaterialItemRegistry.ZENALITE_INGOT.get())),
    PROVOCATION(3, 1000, -2.6f, 5, 16, () -> Ingredient.of(HnSMaterialItemRegistry.ZENALITE_INGOT.get())),
    EXCALIBUR(3, 1000, -2.6f, 5, 16, () -> Ingredient.of(HnSMaterialItemRegistry.ZENALITE_INGOT.get())),
    THE_DEVOURER(3, 1000, -2.6f, 5, 16, () -> Ingredient.of(HnSMaterialItemRegistry.ZENALITE_INGOT.get())),
    RAVENS_BANE(3, 1000, -2.6f, 5, 16, () -> Ingredient.of(ItemRegistry.PYRIUM_INGOT.get())),
    PYRIUM_TIER(3, 1681, -1.3f, 14.5F, 16, () -> Ingredient.of(ItemRegistry.PYRIUM_INGOT.get())),
    ;

    private final int level;
    private final int uses;
    private final float speed;
    private final float damage;
    private final int enchantmentValue;
    private final LazyLoadedValue<Ingredient> repairIngredient;

    HnSExtendedWeaponTiers(int level, int uses, float speed, float damage, int enchantmentValue, Supplier<Ingredient> repairIngredient)
    {
        this.level = level;
        this.uses = uses;
        this.speed = speed;
        this.damage = damage;
        this.enchantmentValue = enchantmentValue;
        this.repairIngredient = new LazyLoadedValue<>(repairIngredient);
    }

    @Override
    public int getUses() {
        return this.uses;
    }

    @Override
    public float getSpeed() {
        return this.speed;
    }

    @Override
    public float getAttackDamageBonus() {
        return this.damage;
    }

    @Override
    public int getLevel() {
        return this.level;
    }

    @Override
    public int getEnchantmentValue() {
        return this.enchantmentValue;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return this.repairIngredient.get();
    }
}