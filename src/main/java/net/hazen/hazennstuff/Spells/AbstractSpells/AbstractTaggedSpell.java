package net.hazen.hazennstuff.Spells.AbstractSpells;

import io.redspace.ironsspellbooks.api.spells.AbstractSpell;
import net.hazen.hazennstuff.Registries.HnSItemRegistry;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import top.theillusivec4.curios.api.CuriosApi;

import static net.acetheeldritchking.aces_spell_utils.utils.ASUtils.isValidUnlockItemInInventory;

public abstract class AbstractTaggedSpell extends AbstractSpell {

    public boolean hasTaggedItem(LivingEntity entity, net.minecraft.tags.TagKey<net.minecraft.world.item.Item> tag) {
        if (entity.getMainHandItem().is(tag) || entity.getOffhandItem().is(tag))
            return true;

        for (ItemStack armor : entity.getArmorSlots()) {
            if (armor.is(tag))
                return true;
        }

        boolean hasCurio = CuriosApi.getCuriosInventory(entity)
                .map(curios -> !curios.findCurios(item -> item != null && item.is(tag)).isEmpty())
                .orElse(false);

        return hasCurio;
    }

    public boolean hasItem(LivingEntity entity, Item item) {
        return entity.getMainHandItem().is(item) || entity.getOffhandItem().is(item);
    }

}
