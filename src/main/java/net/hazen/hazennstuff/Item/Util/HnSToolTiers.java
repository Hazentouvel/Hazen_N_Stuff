package net.hazen.hazennstuff.Item.Util;

import io.redspace.ironsspellbooks.registries.ItemRegistry;
import net.hazen.hazennstuff.Datagen.HnSTags;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;
import net.neoforged.neoforge.common.SimpleTier;

public class HnSToolTiers {
    public static final Tier MITHRIL = new SimpleTier(HnSTags.Blocks.INCORRECT_FOR_MITHRIL_TOOl,
            6093, 10f, 5f, 40, () -> Ingredient.of(ItemRegistry.MITHRIL_SCRAP.get()));
}

