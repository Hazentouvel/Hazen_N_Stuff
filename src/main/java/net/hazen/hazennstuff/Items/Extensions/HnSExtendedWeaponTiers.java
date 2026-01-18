package net.hazen.hazennstuff.Items.Extensions;

import io.redspace.ironsspellbooks.registries.ItemRegistry;
import net.hazen.hazennstuff.Registries.HnSItemRegistry;
import net.minecraft.util.LazyLoadedValue;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;

import java.util.function.Supplier;

public enum HnSExtendedWeaponTiers implements Tier {
    FIREBLOSSOM_RAPIER(5, 6400, -1.7f, 10, 24, () -> Ingredient.of(Items.BLAZE_ROD)),
    ICE_PIKE(5, 6400, -2.4f, 12, 24, () -> Ingredient.of(HnSItemRegistry.ZENALITE_INGOT.get())),
    IONIC_SPLITTER(5, 6400, -2f, 12, 24, () -> Ingredient.of(HnSItemRegistry.ZENALITE_INGOT.get())),
    O_FORTUNA(5, 6400, -2.6f, 12, 24, () -> Ingredient.of(HnSItemRegistry.ZENALITE_INGOT.get())),
    UMBRANOVA(5, 6400, -2.4f, 12, 24, () -> Ingredient.of(HnSItemRegistry.ZENALITE_INGOT.get())),
    DEVESTATOR(5, 6400, -2.4f, 12, 24, () -> Ingredient.of(HnSItemRegistry.ZENALITE_INGOT.get())),
    PROVOCATION(5, 6400, -2.1f, 12, 24, () -> Ingredient.of(HnSItemRegistry.ZENALITE_INGOT.get())),
    EXCALIBUR(5, 6400, -2f, 10, 24, () -> Ingredient.of(HnSItemRegistry.ZENALITE_INGOT.get())),
    THE_DEVOURER(5, 6400, -2.6f, 14, 24, () -> Ingredient.of(HnSItemRegistry.ZENALITE_INGOT.get())),
    RAVENS_BANE(6, 6400, -2.4f, 15, 32, () -> Ingredient.of(ItemRegistry.PYRIUM_INGOT.get())),
    DRACONIC_SPLITTER(5, 6400, -2.7f, 13, 24, () -> Ingredient.of(HnSItemRegistry.ZENALITE_INGOT.get())),
    PYRIUM_TIER(6, 1681, -2.3f, 14F, 32, () -> Ingredient.of(ItemRegistry.PYRIUM_INGOT.get())),
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