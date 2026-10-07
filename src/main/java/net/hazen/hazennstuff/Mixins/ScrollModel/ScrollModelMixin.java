package net.hazen.hazennstuff.Mixins.ScrollModel;

import io.redspace.ironsspellbooks.api.registry.SpellRegistry;
import io.redspace.ironsspellbooks.api.spells.AbstractSpell;
import io.redspace.ironsspellbooks.api.spells.ISpellContainer;
import io.redspace.ironsspellbooks.render.ScrollModel;
import net.hazen.hazennstuff.Spells.ScrollTextureRegistry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.Optional;


// Thank you Kammy for letting me look at how you did this.
@Mixin(value = ScrollModel.class, remap = false)
public abstract class ScrollModelMixin {

    @Inject(
            method = "getModelFromStack",
            at = @At("RETURN"),
            cancellable = true,
            remap = false
    )
    private void es$replaceScrollModel(
            ItemStack stack,
            CallbackInfoReturnable<Optional<ResourceLocation>> cir
    ) {
        if (!ISpellContainer.isSpellContainer(stack)) {
            return;
        }

        ISpellContainer spellContainer = ISpellContainer.get(stack);

        if (spellContainer == null) {
            return;
        }

        if (spellContainer.getSpellAtIndex(0) == null) {
            return;
        }

        AbstractSpell spell =
                spellContainer.getSpellAtIndex(0).getSpell();

        if (spell == null) {
            return;
        }

        ResourceLocation spellId = SpellRegistry.REGISTRY.getKey(spell);

        if (spellId == null) {
            return;
        }

        ResourceLocation customModel =
                ScrollTextureRegistry.getModel(spellId);

        if (customModel == null) {
            return;
        }

        cir.setReturnValue(Optional.of(customModel));
    }
}