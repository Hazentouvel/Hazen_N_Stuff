package net.hazen.hazennstuff.HnSUtilities.Tooltips;

import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.inventory.tooltip.ClientTooltipComponent;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.network.chat.Component;
import net.minecraft.util.RandomSource;
import net.minecraft.world.inventory.tooltip.TooltipComponent;
import org.joml.Matrix4f;

public class HnSSpellTooltip implements ClientTooltipComponent {

    public record HnSSpellTooltipData(Component text) implements TooltipComponent {}

    private final Component text;
    private static final int RED = 0xff1b59;
    private static final int GOLD = 0xffc444;

    public HnSSpellTooltip(HnSSpellTooltipData data) {
        this.text = data.text();
    }

    @Override
    public int getHeight() { return 12; }

    @Override
    public int getWidth(Font font) { return font.width(text); }

    @Override
    public void renderImage(Font font, int x, int y, GuiGraphics guiGraphics) {
        int width = getWidth(font);
        int height = getHeight();

        long seed = System.currentTimeMillis() / 100;
        RandomSource random = RandomSource.create(seed);

        if (random.nextFloat() < 0.4f) {
            guiGraphics.pose().pushPose();
            // Confirmed working Z-index
            guiGraphics.pose().translate(0, 0, 500f);

            RenderSystem.enableBlend();
            RenderSystem.defaultBlendFunc();
            RenderSystem.setShader(GameRenderer::getPositionColorShader);

            guiGraphics.flush();
            RenderSystem.disableBlend();
            guiGraphics.pose().popPose();
        }
    }

    @Override
    public void renderText(Font font, int x, int y, Matrix4f matrix, MultiBufferSource.BufferSource buffer) {
        String rawString = text.getString();
        long timeMs = System.currentTimeMillis();
        float xOffset = x;

        // Smooth rainbow movement
        float ticks = timeMs / 50f;

        // Wave controls
        double waveSpeed = 7.0;
        double wavePhase = 0.65;
        float amplitude = 1.8f;

        for (int i = 0; i < rawString.length(); i++) {
            String letter = String.valueOf(rawString.charAt(i));

            float colorPhase = (float) (Math.sin((timeMs * 0.005) + (i * 0.3f)) + 1.0f) / 2.0f;
            int baseColor = interpolateColor(RED, GOLD, colorPhase);

            float glintSwell = (float) Math.max(0, Math.sin((timeMs * 0.012) + (i * 0.5f)) - 0.7f) * 3.0f;
            int finalColor = applyGlint(baseColor, glintSwell);

            double phase = (i * wavePhase) - ((timeMs / 1000.0) * waveSpeed);
            float yWave = (float) (Math.sin(phase) * amplitude);

            font.drawInBatch(
                    letter,
                    xOffset,
                    y + yWave + 2,
                    finalColor,
                    true,
                    matrix,
                    buffer,
                    Font.DisplayMode.NORMAL,
                    0,
                    15728880
            );
            xOffset += font.width(letter);
        }
    }

    private int interpolateColor(int c1, int c2, float ratio) {
        int r = (int) (((c1 >> 16) & 0xFF) * (1 - ratio) + ((c2 >> 16) & 0xFF) * ratio);
        int g = (int) (((c1 >> 8) & 0xFF) * (1 - ratio) + ((c2 >> 8) & 0xFF) * ratio);
        int b = (int) ((c1 & 0xFF) * (1 - ratio) + (c2 & 0xFF) * ratio);
        return (255 << 24) | (r << 16) | (g << 8) | b;
    }

    private int applyGlint(int color, float glint) {
        int r = Math.min(255, (int) (((color >> 16) & 0xFF) + (255 * glint)));
        int g = Math.min(255, (int) (((color >> 8) & 0xFF) + (255 * glint)));
        int b = Math.min(255, (int) ((color & 0xFF) + (255 * glint)));
        return (255 << 24) | (r << 16) | (g << 8) | b;
    }
}
