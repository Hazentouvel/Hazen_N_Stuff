package net.hazen.hazennstuff.Spells.Tooltips;

import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.inventory.tooltip.ClientTooltipComponent;
import net.minecraft.network.chat.Component;
import net.minecraft.world.inventory.tooltip.TooltipComponent;
import org.joml.Matrix4f;
import net.minecraft.client.renderer.MultiBufferSource;

public class LightningClientTooltipComponent implements ClientTooltipComponent {

    public record LightningTooltipData(Component text) implements TooltipComponent {}

    private final Component text;

    public LightningClientTooltipComponent(LightningTooltipData data) {
        this.text = data.text();
    }

    @Override
    public int getHeight() { return 10; }

    @Override
    public int getWidth(Font font) { return font.width(text); }

    /**
     * DIAGNOSTIC RENDER IMAGE
     * If this works, you will see a bright red box behind/around your text.
     */
    @Override
    public void renderImage(Font font, int x, int y, GuiGraphics guiGraphics) {
        int width = getWidth(font);
        int height = getHeight();

        guiGraphics.pose().pushPose();

        // Test 1: High Z-index to bring it to the absolute front
        guiGraphics.pose().translate(0, 0, 500f);

        // Draw a solid red "Target" box
        // If you see this, the method is working.
        guiGraphics.fill(x - 2, y - 2, x + width + 2, y + height + 2, 0xFFFF0000);

        // Draw a smaller white box inside to check for offset issues
        guiGraphics.fill(x, y, x + width, y + height, 0xFFFFFFFF);

        guiGraphics.pose().popPose();
    }

    @Override
    public void renderText(Font font, int x, int y, Matrix4f matrix, MultiBufferSource.BufferSource buffer) {
        // Keeping text simple for the test
        font.drawInBatch(text, x, y, -1, true, matrix, buffer, Font.DisplayMode.NORMAL, 0, 15728880);
    }
}