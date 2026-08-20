package net.hazen.hazennstuff.Item.Block.Starforge;

import net.hazen.hazennstuff.Registries.HnSSounds;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.sounds.AbstractTickableSoundInstance;
import net.minecraft.client.resources.sounds.SoundInstance;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;

public class StarForgeSoundInstance extends AbstractTickableSoundInstance {

    private final StarForgeBlockEntity forge;

    private StarForgeSoundInstance(StarForgeBlockEntity forge, SoundEvent event, boolean loop) {
        super(event, SoundSource.BLOCKS, SoundInstance.createUnseededRandom());

        this.forge = forge;
        this.looping = loop;
        this.delay = 0;
        this.volume = 1.0f;
        this.pitch = 1.0f;

        BlockPos pos = forge.getBlockPos();
        this.x = pos.getX() + 0.5;
        this.y = pos.getY() + 0.5;
        this.z = pos.getZ() + 0.5;
    }

    public static void playActivate(StarForgeBlockEntity forge) {
        Minecraft.getInstance().getSoundManager().play(
                new StarForgeSoundInstance(forge, HnSSounds.STARFORGE_ACTIVATE.get(), false));
    }

    public static void playLoop(StarForgeBlockEntity forge) {
        Minecraft.getInstance().getSoundManager().play(
                new StarForgeSoundInstance(forge, HnSSounds.STARFORGE_LOOP.get(), false));
    }

    @Override
    public void tick() {
        if (forge.isRemoved() || !forge.isCrafting()) {
            this.stop();
        }
    }
}
