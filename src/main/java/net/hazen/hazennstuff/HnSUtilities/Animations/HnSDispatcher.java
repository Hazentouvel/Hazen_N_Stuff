package net.hazen.hazennstuff.HnSUtilities.Animations;

import mod.azure.azurelib.common.animation.dispatch.command.AzCommand;
import mod.azure.azurelib.common.animation.play_behavior.AzPlayBehaviors;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.ItemStack;

public class HnSDispatcher {
    private static final AzCommand IDLE = AzCommand.create(
            "base_controller",
            "idle",
            AzPlayBehaviors.LOOP
    );

    private static final AzCommand ELYTRA_FLIGHT_COMMAND = AzCommand.create(
            "base_controller",
            "flying",
            AzPlayBehaviors.LOOP
    );

    private static final AzCommand DIVING = AzCommand.create(
            "base_controller",
            "diving",
            AzPlayBehaviors.LOOP
    );

    private static final AzCommand INSTANT_CAST = AzCommand.create(
            "base_controller",
            "instant_cast",
            AzPlayBehaviors.LOOP
    );

    private static final AzCommand LONG_CAST = AzCommand.create(
            "base_controller",
            "long_cast",
            AzPlayBehaviors.LOOP
    );

    private static final AzCommand CONTINUOUS_CAST = AzCommand.create(
            "base_controller",
            "continuous_cast",
            AzPlayBehaviors.LOOP
    );

    public void diving(Entity entity, ItemStack itemStack) {
        DIVING.sendForItem(entity, itemStack);
    }

    public void idle(Entity entity, ItemStack itemStack) {
        IDLE.sendForItem(entity, itemStack);
    }

    public void flight(Entity entity, ItemStack itemStack) {
        ELYTRA_FLIGHT_COMMAND.sendForItem(entity, itemStack);
    }

    public void instantCast(Entity entity, ItemStack itemStack) {
        INSTANT_CAST.sendForItem(entity, itemStack);
    }

    public void longCast(Entity entity, ItemStack itemStack) {
        LONG_CAST.sendForItem(entity, itemStack);
    }

    public void continuousCast(Entity entity, ItemStack itemStack) {
        CONTINUOUS_CAST.sendForItem(entity, itemStack);
    }

}