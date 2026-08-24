package net.hazen.hazennstuff.Screens.Starforge;

import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;

public class StarForgeScreen extends AbstractContainerScreen<StarForgeMenu> {

    private static final ResourceLocation TEXTURE =
            ResourceLocation.fromNamespaceAndPath("hazennstuff", "textures/gui/starforge_gui.png");

    private static final int TEX = 256;

    // ---- overlay sprites
    private static final int FUEL_U = 179, FUEL_V = 3;
    private static final int FUEL_W = 13, FUEL_H = 55;
    private static final int FUEL_X = 28, FUEL_Y = 28;

    private static final int FUEL_RIGHT_X = 135;
    private static final int FUEL_RIGHT_Y = 28;

    private static final int PROG_U = 196, PROG_V = 2;
    private static final int PROG_W = 56, PROG_H = 123;
    private static final int PROG_X = 60, PROG_Y = 2;

    private enum Fill { UP, DOWN, LEFT, RIGHT }

    public StarForgeScreen(StarForgeMenu menu, Inventory inventory, Component title) {
        super(menu, inventory, title);
        this.imageWidth = 176;
        this.imageHeight = 222;
        this.titleLabelY = 6;
        this.inventoryLabelY = 129;
    }

    @Override
    protected void renderBg(GuiGraphics guiGraphics, float partialTick, int mouseX, int mouseY) {
        guiGraphics.blit(TEXTURE, this.leftPos, this.topPos, 0, 0,
                this.imageWidth, this.imageHeight, TEX, TEX);

        blitPartial(guiGraphics, FUEL_U, FUEL_V, FUEL_X, FUEL_Y, FUEL_W, FUEL_H,
                menu.getFuelFraction(), Fill.UP);

        blitPartial(guiGraphics, FUEL_U, FUEL_V, FUEL_RIGHT_X, FUEL_RIGHT_Y, FUEL_W, FUEL_H,
                menu.getFuelFraction(), Fill.UP);

        blitPartial(guiGraphics, PROG_U, PROG_V, PROG_X, PROG_Y, PROG_W, PROG_H,
                menu.getProgressFraction(), Fill.DOWN);
    }

    private void blitPartial(GuiGraphics guiGraphics, int u, int v, int x, int y,
                             int w, int h, float fraction, Fill fill) {
        if (fraction <= 0f) return;
        fraction = Math.min(1f, fraction);

        int drawX = this.leftPos + x;
        int drawY = this.topPos + y;

        switch (fill) {
            case RIGHT -> {
                int width = Math.round(w * fraction);
                guiGraphics.blit(TEXTURE, drawX, drawY, u, v, width, h, TEX, TEX);
            }
            case LEFT -> {
                int width = Math.round(w * fraction);
                int off = w - width;
                guiGraphics.blit(TEXTURE, drawX + off, drawY, u + off, v, width, h, TEX, TEX);
            }
            case DOWN -> {
                int height = Math.round(h * fraction);
                guiGraphics.blit(TEXTURE, drawX, drawY, u, v, w, height, TEX, TEX);
            }
            case UP -> {
                int height = Math.round(h * fraction);
                int off = h - height;
                guiGraphics.blit(TEXTURE, drawX, drawY + off, u, v + off, w, height, TEX, TEX);
            }
        }
    }

    @Override
    public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTick) {
        super.render(guiGraphics, mouseX, mouseY, partialTick);
        this.renderTooltip(guiGraphics, mouseX, mouseY);
    }

    @Override
    protected void renderLabels(GuiGraphics guiGraphics, int mouseX, int mouseY) {
        // intentionally empty
    }
}
