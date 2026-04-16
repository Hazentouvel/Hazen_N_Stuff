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

            // Generate 2 thin arcs
            for (int i = 0; i < 2; i++) {
                int x1 = x + random.nextInt(width);
                int y1 = y + 2;
                int x2 = x + random.nextInt(width);
                int y2 = y + height - 2;
                drawThinArc(guiGraphics, x1, y1, x2, y2, random);
            }

            guiGraphics.flush();
            RenderSystem.disableBlend();
            guiGraphics.pose().popPose();
        }
    }

    private void drawThinArc(GuiGraphics guiGraphics, int x1, int y1, int x2, int y2, RandomSource random) {

        int segments = 4; // controls how wiggly the arc is
        int[] px = new int[segments + 1];
        int[] py = new int[segments + 1];

        for (int i = 0; i <= segments; i++) {
            float pct = (float) i / segments;
            px[i] = (int) (x1 + (x2 - x1) * pct) + (random.nextInt(5) - 2);
            py[i] = (int) (y1 + (y2 - y1) * pct) + (random.nextInt(3) - 1);
        }

        // Draw between consecutive points with 1-pixel steps
        for (int i = 0; i < segments; i++) {
            int sx = px[i];
            int sy = py[i];
            int ex = px[i + 1];
            int ey = py[i + 1];

            int dx = ex - sx;
            int dy = ey - sy;
            double dist = Math.max(1.0, Math.hypot(dx, dy));
            double stepX = dx / dist;
            double stepY = dy / dist;

            double curX = sx;
            double curY = sy;

            for (int s = 0; s <= (int) dist; s++) {
                int ix = (int) Math.round(curX);
                int iy = (int) Math.round(curY);

                // Outer glow: small semi-transparent cyan pixel (2x2)
                guiGraphics.fill(ix - 1, iy - 1, ix + 1, iy + 1, 0x6655FFFF);
                // Inner core: single white pixel
                guiGraphics.fill(ix, iy, ix + 1, iy + 1, 0xFFFFFFFF);

                curX += stepX;
                curY += stepY;
            }
        }
    }

    @Override
    public void renderText(Font font, int x, int y, Matrix4f matrix, MultiBufferSource.BufferSource buffer) {
        String rawString = text.getString();
        long time = System.currentTimeMillis();

        float xOffset = x;

        // Make a left-to-right travelling wave: each character's vertical offset is phased by its
        // index so the wave appears to run across the string rather than shaking the whole string.
        float waveSpeed = 0.012f; // how fast the wave moves
        float wavePhase = 0.30f; // phase difference between characters
        float amplitude = 1.6f; // vertical amplitude in pixels

        for (int i = 0; i < rawString.length(); i++) {
            String letter = String.valueOf(rawString.charAt(i));

            float colorPhase = (float) (Math.sin((time * 0.005) + (i * 0.3f)) + 1.0f) / 2.0f;
            int baseColor = interpolateColor(RED, GOLD, colorPhase);

            float glintSwell = (float) Math.max(0, Math.sin((time * 0.012) + (i * 0.5f)) - 0.7f) * 3.0f;
            int finalColor = applyGlint(baseColor, glintSwell);

            float yWave = (float) Math.sin((time * waveSpeed) + (i * wavePhase)) * amplitude;

            font.drawInBatch(letter, xOffset, y + (int) yWave + 2, finalColor, true, matrix, buffer, Font.DisplayMode.NORMAL, 0, 15728880);
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

