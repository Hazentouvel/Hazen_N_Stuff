package net.hazen.hazennstuff.Item.Block.RadiantAltar;

import io.redspace.ironsspellbooks.api.magic.MagicData;
import net.hazen.hazennstuff.Item.Block.Starforge.StarForgeRecipe.SizedInput;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;

import java.util.ArrayList;
import java.util.List;

public final class RadiantAltarCrafting {

    public enum Problem {
        NONE, BUSY, NO_MAIN, NO_SECONDARY, NO_MATERIALS, NO_MANA
    }

    // How many items in the player's main inventory (hotbar included) match the ingredient
    public static int countAvailable(Inventory inv, Ingredient ingredient) {
        int total = 0;
        for (ItemStack stack : inv.items) {
            if (!stack.isEmpty() && ingredient.test(stack)) total += stack.getCount();
        }
        return total;
    }

    // Simulates taking every material in order, so two materials that accept the same item (overlapping tags) can't both count the same stack
    public static boolean hasMaterials(Inventory inv, List<SizedInput> materials) {
        int[] remaining = new int[inv.items.size()];
        for (int i = 0; i < remaining.length; i++) remaining[i] = inv.items.get(i).getCount();

        for (SizedInput material : materials) {
            int need = material.count();
            for (int i = 0; i < remaining.length && need > 0; i++) {
                if (remaining[i] <= 0) continue;
                ItemStack stack = inv.items.get(i);
                if (stack.isEmpty() || !material.ingredient().test(stack)) continue;
                int take = Math.min(need, remaining[i]);
                remaining[i] -= take;
                need -= take;
            }
            if (need > 0) return false;
        }
        return true;
    }

    // Takes the materials out of the inventory
    public static List<ItemStack> consumeMaterials(Inventory inv, List<SizedInput> materials) {
        List<ItemStack> taken = new ArrayList<>(materials.size());
        for (SizedInput material : materials) {
            int need = material.count();
            for (int i = 0; i < inv.items.size() && need > 0; i++) {
                ItemStack stack = inv.items.get(i);
                if (stack.isEmpty() || !material.ingredient().test(stack)) continue;
                int take = Math.min(need, stack.getCount());
                merge(taken, stack.copyWithCount(take));
                stack.shrink(take);
                need -= take;
            }
        }
        inv.setChanged();
        return taken;
    }

    private static void merge(List<ItemStack> into, ItemStack stack) {
        for (ItemStack existing : into) {
            if (ItemStack.isSameItemSameComponents(existing, stack)) {
                existing.grow(stack.getCount());
                return;
            }
        }
        into.add(stack);
    }

    public static boolean hasMana(Player player, int mana, int clientMana) {
        if (mana <= 0 || player.getAbilities().instabuild) return true;
        float current = player.level().isClientSide ? clientMana : MagicData.getPlayerMagicData(player).getMana();
        return current >= mana;
    }

    // Why this recipe can't be started right now, or Problem.NONE
    public static Problem check(RadiantAltarRecipe recipe, Player player, ItemStack main, ItemStack secondary,
                                boolean busy, int clientMana) {
        if (busy) return Problem.BUSY;
        if (!recipe.acceptsMain(main)) return Problem.NO_MAIN;
        if (!recipe.secondarySatisfied(secondary)) return Problem.NO_SECONDARY;
        if (!hasMaterials(player.getInventory(), recipe.materials())) return Problem.NO_MATERIALS;
        if (!hasMana(player, recipe.mana(), clientMana)) return Problem.NO_MANA;
        return Problem.NONE;
    }

    public static String translationKey(Problem problem) {
        return "gui.hazennstuff.radiant_altar.problem." + problem.name().toLowerCase();
    }
}
