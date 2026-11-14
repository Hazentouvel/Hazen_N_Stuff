package net.hazen.hazennstuff.Screens.RadiantAltar;

import net.hazen.hazennstuff.HazenNStuff;
import net.hazen.hazennstuff.Item.Block.RadiantAltar.RadiantAltarCrafting;
import net.hazen.hazennstuff.Item.Block.RadiantAltar.RadiantAltarCrafting.Problem;
import net.hazen.hazennstuff.Item.Block.RadiantAltar.RadiantAltarRecipe;
import net.hazen.hazennstuff.Item.Block.Starforge.StarForgeRecipe.SizedInput;
import net.minecraft.ChatFormatting;
import net.minecraft.Util;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.screens.inventory.tooltip.TooltipRenderUtil;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.client.resources.sounds.SimpleSoundInstance;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeHolder;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;

public class RadiantAltarScreen extends AbstractContainerScreen<RadiantAltarMenu> {

    private static final ResourceLocation TEXTURE =
            ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "textures/gui/radiant_altar_gui.png");
    private static final int TEX = 512;

    // Layout
    private static final int WIDTH = 303, HEIGHT = 242;

    private static final int LEFT_LABEL_X = 51, RIGHT_LABEL_X = 164, LABEL_Y = 18, LABEL_W = 90, LABEL_H = 13;

    private static final int[] COLUMN_X = {49, 164};
    private static final int LIST_Y = 33, ROW_H = 18, ROW_W = 91, ROWS = 6, COLUMNS = 2;
    private static final int VISIBLE = ROWS * COLUMNS;

    private static final int[][] TRACKS = {{265, 18, 106}}; // x, y, height
    private static final int TRACK_W = 12, HANDLE_H = 15;

    private static final int PROGRESS_X = 147, PROGRESS_Y = 35, PROGRESS_U = 316, PROGRESS_V = 56,
            PROGRESS_W = 10, PROGRESS_H = 88;

    private static final int EMBLEM_STAR_X = 145, EMBLEM_STAR_Y = 132;

    private static final int PLAIN_SLOT_U = 25, PLAIN_SLOT_V = 17, SECONDARY_FRAME_X = 25, SECONDARY_FRAME_Y = 107;
    private static final int HANDLE_U = 311, HANDLE_OFF_U = 323, HANDLE_V = 0;

    private static final int TOGGLE_X = 264, TOGGLE_Y = 128, TOGGLE_W = 15, TOGGLE_H = 14;
    private static final int TABLE_ICON_U = 313, TABLE_ICON_V = 22, TABLE_ICON_W = 10, TABLE_ICON_H = 9;
    private static final int DIAMOND_ICON_U = 314, DIAMOND_ICON_V = 33, DIAMOND_ICON_W = 8, DIAMOND_ICON_H = 9;

    private static final int STAR_U = 339, STAR_V = 1, STAR_SIZE = 14;
    private static final int HIGHLIGHT_U = 360, HIGHLIGHT_V = 0;

    private static final int MANA_X = 76, MANA_Y = 150, MANA_U = 70, MANA_V = 257, MANA_W = 152, MANA_H = 5;

    private static final int CHECK_X = 265, CHECK_Y = 218, CHECK_SIZE = 18;
    private static final int CHECK_HOVER_U = 360, CHECK_HOVER_V = 26;

    // Colours
    private static final int LABEL_COLOR = 0xFF5F564E;
    private static final int ROW_TEXT = 0xFFFFFFFF;
    private static final int ROW_TEXT_DISABLED = 0xFF8A847B;
    private static final int GOOD = 0xFF55FF55;
    private static final int BAD = 0xFFFF5555;
    private static final int WASH = 0x99DBD8CD;

    private enum Mode { RECIPES, CRAFTING }

    private record RecipeEntry(int index, RecipeHolder<RadiantAltarRecipe> holder) {}

    private record MaterialEntry(Ingredient ingredient, int need, int have, boolean secondary) {}

    private Mode mode = Mode.RECIPES;
    private int scrollRow = 0;
    @Nullable private ResourceLocation selected;
    private ItemStack lastMain = ItemStack.EMPTY;
    private int draggingTrack = -1;

    private boolean confirmOpen = false;
    private Button confirmButton;
    private Button cancelButton;

    public RadiantAltarScreen(RadiantAltarMenu menu, Inventory inventory, Component title) {
        super(menu, inventory, title);
        this.imageWidth = WIDTH;
        this.imageHeight = HEIGHT;
    }

    @Override
    protected void init() {
        super.init();
        int cx = leftPos + WIDTH / 2;
        int by = topPos + 108;
        confirmButton = Button.builder(Component.translatable("gui.hazennstuff.radiant_altar.confirm"), b -> confirmCraft())
                .bounds(cx - 74, by, 70, 20).build();
        cancelButton = Button.builder(Component.translatable("gui.cancel"), b -> confirmOpen = false)
                .bounds(cx + 4, by, 70, 20).build();

        addWidget(confirmButton);
        addWidget(cancelButton);
    }

    // Data

    private List<RecipeEntry> recipesForMain() {
        List<RecipeEntry> out = new ArrayList<>();
        if (minecraft == null || minecraft.level == null) return out;
        List<RecipeHolder<RadiantAltarRecipe>> recipes = RadiantAltarRecipe.recipesFor(minecraft.level, menu.getMainItem());
        for (int i = 0; i < recipes.size(); i++) out.add(new RecipeEntry(i, recipes.get(i)));
        return out;
    }

    @Nullable
    private RecipeEntry selectedEntry() {
        if (selected == null || minecraft == null || minecraft.level == null) return null;
        for (RecipeEntry entry : recipesForMain()) {
            if (entry.holder().id().equals(selected)) return entry;
        }
        // Still viewable after the main item is taken out, just not craftable.
        for (RecipeHolder<RadiantAltarRecipe> holder : RadiantAltarRecipe.sortedRecipes(minecraft.level)) {
            if (holder.id().equals(selected)) return new RecipeEntry(-1, holder);
        }
        return null;
    }

    private List<MaterialEntry> materialsFor(RadiantAltarRecipe recipe) {
        List<MaterialEntry> out = new ArrayList<>();
        recipe.secondary().ifPresent(s -> {
            ItemStack inSlot = menu.getSecondaryItem();
            int have = s.ingredient().test(inSlot) ? inSlot.getCount() : 0;
            out.add(new MaterialEntry(s.ingredient(), s.count(), have, true));
        });
        for (SizedInput m : recipe.materials()) {
            out.add(new MaterialEntry(m.ingredient(), m.count(),
                    RadiantAltarCrafting.countAvailable(menu.getPlayer().getInventory(), m.ingredient()), false));
        }
        return out;
    }

    private Problem problemFor(RadiantAltarRecipe recipe) {
        return RadiantAltarCrafting.check(recipe, menu.getPlayer(), menu.getMainItem(), menu.getSecondaryItem(),
                menu.isCrafting(), menu.getMana());
    }

    private int entryCount() {
        if (mode == Mode.RECIPES) return recipesForMain().size();
        RecipeEntry sel = selectedEntry();
        return sel == null ? 0 : materialsFor(sel.holder().value()).size();
    }

    private int maxScroll() {
        int rows = Mth.positiveCeilDiv(entryCount(), COLUMNS);
        return Math.max(0, rows - ROWS);
    }

    // Resets the view when a different main item goes in
    private void watchMainItem() {
        ItemStack main = menu.getMainItem();
        if (!ItemStack.isSameItem(main, lastMain)) {
            lastMain = main.copy();
            if (!menu.isCrafting()) {
                selected = null;
                mode = Mode.RECIPES;
                scrollRow = 0;
                confirmOpen = false;
            }
        }
        scrollRow = Mth.clamp(scrollRow, 0, maxScroll());
    }

    private static ItemStack cycle(Ingredient ingredient, int count) {
        ItemStack[] options = ingredient.getItems();
        if (options.length == 0) return new ItemStack(Items.BARRIER);
        ItemStack stack = options[(int) ((Util.getMillis() / 1000L) % options.length)].copy();
        stack.setCount(Math.max(1, count));
        return stack;
    }

    // Rendering

    @Override
    public void render(GuiGraphics g, int mouseX, int mouseY, float partialTick) {
        watchMainItem();
        confirmButton.visible = cancelButton.visible = confirmOpen;

        super.render(g, mouseX, mouseY, partialTick);
        renderHint(g);

        if (confirmOpen) {
            renderConfirmDialog(g, mouseX, mouseY, partialTick);
        } else {
            renderTooltip(g, mouseX, mouseY);
            renderAltarTooltips(g, mouseX, mouseY);
        }
    }

    @Override
    protected void renderBg(GuiGraphics g, float partialTick, int mouseX, int mouseY) {
        pendingHint = null;
        g.blit(TEXTURE, leftPos, topPos, 0, 0, WIDTH, HEIGHT, TEX, TEX);

        renderManaBar(g);
        renderProgress(g);
        renderEmblemStar(g);
        renderSecondaryFrame(g);
        renderBars(g);
        renderList(g, mouseX, mouseY);
        renderScrollbars(g);
        renderToggle(g, mouseX, mouseY);
        renderCheck(g, mouseX, mouseY);
    }

    @Override
    protected void renderLabels(GuiGraphics g, int mouseX, int mouseY) {
        // Titles are drawn in the label bars instead.
    }

    private void renderManaBar(GuiGraphics g) {
        int max = menu.getMaxMana();
        if (max <= 0) return;
        float frac = Mth.clamp((float) menu.getMana() / max, 0f, 1f);
        int w = Math.round(MANA_W * frac);
        if (w > 0) g.blit(TEXTURE, leftPos + MANA_X, topPos + MANA_Y, MANA_U, MANA_V, w, MANA_H, TEX, TEX);
    }

    private void renderProgress(GuiGraphics g) {
        if (!menu.isCrafting()) return;
        int h = Math.round(PROGRESS_H * menu.getProgressFraction());
        // Fills top to bottom, following the beam down onto the pedestal.
        if (h > 0) g.blit(TEXTURE, leftPos + PROGRESS_X, topPos + PROGRESS_Y, PROGRESS_U, PROGRESS_V, PROGRESS_W, h, TEX, TEX);
    }

    private void renderEmblemStar(GuiGraphics g) {
        RecipeEntry sel = selectedEntry();
        if (sel == null || !RadiantAltarCrafting.hasMana(menu.getPlayer(), sel.holder().value().mana(), menu.getMana())) return;
        g.blit(TEXTURE, leftPos + EMBLEM_STAR_X, topPos + EMBLEM_STAR_Y, STAR_U, STAR_V, STAR_SIZE, STAR_SIZE, TEX, TEX);
    }

    private void renderSecondaryFrame(GuiGraphics g) {
        if (menu.getSecondaryItem().isEmpty()) return;
        g.blit(TEXTURE, leftPos + SECONDARY_FRAME_X, topPos + SECONDARY_FRAME_Y,
                PLAIN_SLOT_U, PLAIN_SLOT_V, 18, 18, TEX, TEX);
    }

    private void renderBars(GuiGraphics g) {
        // Left bar: which view is showing (or the craft's progress)
        Component left;
        if (menu.isCrafting()) {
            left = Component.translatable("gui.hazennstuff.radiant_altar.infusing",
                    Math.round(menu.getProgressFraction() * 100));
        } else {
            left = Component.translatable(mode == Mode.RECIPES
                    ? "gui.hazennstuff.radiant_altar.recipes"
                    : "gui.hazennstuff.radiant_altar.crafting");
        }
        drawCentered(g, left, leftPos + LEFT_LABEL_X + LABEL_W / 2, topPos + LABEL_Y + 3, LABEL_COLOR);

        // Right bar: mana the selected recipe needs
        RecipeEntry sel = selectedEntry();
        String text;
        int color = LABEL_COLOR;
        if (sel == null) {
            text = "-";
        } else {
            int cost = sel.holder().value().mana();
            text = Integer.toString(cost);
            if (!RadiantAltarCrafting.hasMana(menu.getPlayer(), cost, menu.getMana())) color = 0xFFB03030;
        }
        drawCentered(g, Component.literal(text), leftPos + RIGHT_LABEL_X + LABEL_W / 2, topPos + LABEL_Y + 3, color);
    }

    private void drawCentered(GuiGraphics g, Component text, int cx, int y, int color) {
        g.drawString(font, text, cx - font.width(text) / 2, y, color, false);
    }

    private void renderList(GuiGraphics g, int mouseX, int mouseY) {
        int first = scrollRow * COLUMNS;

        if (mode == Mode.RECIPES) {
            List<RecipeEntry> recipes = recipesForMain();
            if (recipes.isEmpty()) {
                hint(g, menu.getMainItem().isEmpty()
                        ? "gui.hazennstuff.radiant_altar.hint.insert"
                        : "gui.hazennstuff.radiant_altar.hint.none");
                return;
            }
            for (int i = 0; i < VISIBLE && first + i < recipes.size(); i++) {
                RecipeEntry entry = recipes.get(first + i);
                RadiantAltarRecipe recipe = entry.holder().value();
                int x = leftPos + COLUMN_X[i % COLUMNS], y = topPos + LIST_Y + (i / COLUMNS) * ROW_H;

                boolean isSelected = entry.holder().id().equals(selected);
                if (isSelected || isIn(mouseX, mouseY, x, y, ROW_W, ROW_H)) {
                    g.blit(TEXTURE, x, y, HIGHLIGHT_U, HIGHLIGHT_V, ROW_W, ROW_H, TEX, TEX);
                }

                ItemStack result = recipe.result();
                g.renderItem(result, x + 1, y + 1);
                g.renderItemDecorations(font, result, x + 1, y + 1);

                boolean craftable = problemFor(recipe) == Problem.NONE;
                rowText(g, result.getHoverName().getString(), x, y, craftable ? ROW_TEXT : ROW_TEXT_DISABLED, craftable);
                if (!craftable) wash(g, x, y);
            }
        } else {
            RecipeEntry sel = selectedEntry();
            if (sel == null) {
                hint(g, "gui.hazennstuff.radiant_altar.hint.select");
                return;
            }
            List<MaterialEntry> mats = materialsFor(sel.holder().value());
            if (mats.isEmpty()) {
                hint(g, "gui.hazennstuff.radiant_altar.hint.no_materials");
                return;
            }
            for (int i = 0; i < VISIBLE && first + i < mats.size(); i++) {
                MaterialEntry mat = mats.get(first + i);
                int x = leftPos + COLUMN_X[i % COLUMNS], y = topPos + LIST_Y + (i / COLUMNS) * ROW_H;

                ItemStack icon = cycle(mat.ingredient(), 1);
                g.renderItem(icon, x + 1, y + 1);

                boolean enough = mat.have() >= mat.need();
                String counts = mat.have() + "/" + mat.need();
                g.drawString(font, counts, x + 20, y + 5, enough ? GOOD : BAD, true);
                int nameX = x + 20 + font.width(counts) + 3;
                rowText(g, icon.getHoverName().getString(), nameX, y, ROW_TEXT, true, x + ROW_W - 2 - nameX);
            }
        }
    }

    private void rowText(GuiGraphics g, String text, int x, int y, int color, boolean shadow) {
        rowText(g, text, x + 20, y, color, shadow, ROW_W - 22);
    }

    private void rowText(GuiGraphics g, String text, int x, int y, int color, boolean shadow, int maxWidth) {
        if (maxWidth <= font.width("..")) return;
        if (font.width(text) > maxWidth) {
            text = font.plainSubstrByWidth(text, maxWidth - font.width("..")) + "..";
        }
        g.drawString(font, text, x, y + 5, color, shadow);
    }

    private void wash(GuiGraphics g, int x, int y) {
        g.pose().pushPose();
        g.pose().translate(0, 0, 200); // above the item
        g.fill(x + 1, y + 1, x + 17, y + 17, WASH);
        g.pose().popPose();
    }

    // Hints show in a tooltip-style box above the GUI
    @Nullable private Component pendingHint;

    private void hint(GuiGraphics g, String key) {
        pendingHint = Component.translatable(key);
    }

    private void renderHint(GuiGraphics g) {
        if (pendingHint == null) return;
        int w = font.width(pendingHint);
        int x = leftPos + (WIDTH - w) / 2;
        int y = Math.max(6, topPos - 16);
        g.pose().pushPose();
        g.pose().translate(0, 0, 400);
        TooltipRenderUtil.renderTooltipBackground(g, x, y, w, 9, 0);
        g.drawString(font, pendingHint, x, y + 1, 0xFFFFFFFF, true);
        g.pose().popPose();
    }

    private void renderScrollbars(GuiGraphics g) {
        int max = maxScroll();
        int u = max > 0 ? HANDLE_U : HANDLE_OFF_U;
        for (int[] track : TRACKS) {
            int travel = track[2] - HANDLE_H;
            int y = track[1] + (max > 0 ? Math.round(travel * (float) scrollRow / max) : 0);
            g.blit(TEXTURE, leftPos + track[0], topPos + y, u, HANDLE_V, TRACK_W, HANDLE_H, TEX, TEX);
        }
    }

    private void renderToggle(GuiGraphics g, int mouseX, int mouseY) {
        int x = leftPos + TOGGLE_X, y = topPos + TOGGLE_Y;
        if (isIn(mouseX, mouseY, x, y, TOGGLE_W, TOGGLE_H)) {
            g.fill(x + 1, y + 1, x + TOGGLE_W - 1, y + TOGGLE_H - 1, 0x40FFFFFF);
        }
        if (mode == Mode.RECIPES) {
            g.blit(TEXTURE, x + (TOGGLE_W - TABLE_ICON_W) / 2, y + (TOGGLE_H - TABLE_ICON_H) / 2,
                    TABLE_ICON_U, TABLE_ICON_V, TABLE_ICON_W, TABLE_ICON_H, TEX, TEX);
        } else {
            g.blit(TEXTURE, x + (TOGGLE_W - DIAMOND_ICON_W) / 2, y + (TOGGLE_H - DIAMOND_ICON_H) / 2,
                    DIAMOND_ICON_U, DIAMOND_ICON_V, DIAMOND_ICON_W, DIAMOND_ICON_H, TEX, TEX);
        }
    }

    private boolean canConfirm() {
        RecipeEntry sel = selectedEntry();
        return sel != null && problemFor(sel.holder().value()) == Problem.NONE;
    }

    private void renderCheck(GuiGraphics g, int mouseX, int mouseY) {
        int x = leftPos + CHECK_X, y = topPos + CHECK_Y;
        boolean ready = canConfirm();
        if (ready && isIn(mouseX, mouseY, x, y, CHECK_SIZE, CHECK_SIZE)) {
            g.blit(TEXTURE, x, y, CHECK_HOVER_U, CHECK_HOVER_V, CHECK_SIZE, CHECK_SIZE, TEX, TEX);
        } else if (!ready) {
            g.fill(x + 1, y + 1, x + CHECK_SIZE - 1, y + CHECK_SIZE - 1, 0x99373737);
        }
    }

    private void renderAltarTooltips(GuiGraphics g, int mouseX, int mouseY) {
        // Mana bar
        if (isIn(mouseX, mouseY, leftPos + MANA_X, topPos + MANA_Y - 2, MANA_W, MANA_H + 4)) {
            g.renderTooltip(font, Component.translatable("gui.hazennstuff.radiant_altar.mana",
                    menu.getMana(), menu.getMaxMana()), mouseX, mouseY);
            return;
        }
        // Mana required
        if (isIn(mouseX, mouseY, leftPos + RIGHT_LABEL_X, topPos + LABEL_Y, LABEL_W, LABEL_H)) {
            g.renderTooltip(font, Component.translatable("gui.hazennstuff.radiant_altar.mana_required"), mouseX, mouseY);
            return;
        }
        // Toggle
        if (isIn(mouseX, mouseY, leftPos + TOGGLE_X, topPos + TOGGLE_Y, TOGGLE_W, TOGGLE_H)) {
            g.renderTooltip(font, Component.translatable(mode == Mode.RECIPES
                    ? "gui.hazennstuff.radiant_altar.toggle.to_crafting"
                    : "gui.hazennstuff.radiant_altar.toggle.to_recipes"), mouseX, mouseY);
            return;
        }
        // Confirm
        if (isIn(mouseX, mouseY, leftPos + CHECK_X, topPos + CHECK_Y, CHECK_SIZE, CHECK_SIZE)) {
            RecipeEntry sel = selectedEntry();
            Component tip = sel == null
                    ? Component.translatable("gui.hazennstuff.radiant_altar.hint.select")
                    : problemFor(sel.holder().value()) == Problem.NONE
                    ? Component.translatable("gui.hazennstuff.radiant_altar.craft")
                    : Component.translatable(RadiantAltarCrafting.translationKey(problemFor(sel.holder().value())))
                    .withStyle(ChatFormatting.RED);
            g.renderTooltip(font, tip, mouseX, mouseY);
            return;
        }
        // List rows
        int index = hoveredIndex(mouseX, mouseY);
        if (index < 0) return;

        if (mode == Mode.RECIPES) {
            List<RecipeEntry> recipes = recipesForMain();
            if (index >= recipes.size()) return;
            RadiantAltarRecipe recipe = recipes.get(index).holder().value();
            List<Component> lines = new ArrayList<>(Screen.getTooltipFromItem(minecraft, recipe.result()));
            Problem problem = problemFor(recipe);
            if (problem != Problem.NONE) {
                lines.add(Component.translatable(RadiantAltarCrafting.translationKey(problem)).withStyle(ChatFormatting.RED));
            }
            lines.add(Component.translatable("gui.hazennstuff.radiant_altar.click_to_view").withStyle(ChatFormatting.DARK_GRAY));
            g.renderComponentTooltip(font, lines, mouseX, mouseY);
        } else {
            RecipeEntry sel = selectedEntry();
            if (sel == null) return;
            List<MaterialEntry> mats = materialsFor(sel.holder().value());
            if (index >= mats.size()) return;
            MaterialEntry mat = mats.get(index);
            List<Component> lines = new ArrayList<>(Screen.getTooltipFromItem(minecraft, cycle(mat.ingredient(), 1)));
            lines.add(Component.translatable("gui.hazennstuff.radiant_altar.have_need", mat.have(), mat.need())
                    .withStyle(mat.have() >= mat.need() ? ChatFormatting.GREEN : ChatFormatting.RED));
            if (mat.secondary()) {
                lines.add(Component.translatable("gui.hazennstuff.radiant_altar.secondary_slot").withStyle(ChatFormatting.GRAY));
            }
            g.renderComponentTooltip(font, lines, mouseX, mouseY);
        }
    }

    private void renderConfirmDialog(GuiGraphics g, int mouseX, int mouseY, float partialTick) {
        RecipeEntry sel = selectedEntry();
        if (sel == null) {
            confirmOpen = false;
            return;
        }
        RadiantAltarRecipe recipe = sel.holder().value();

        g.pose().pushPose();
        g.pose().translate(0, 0, 400);

        g.fill(leftPos, topPos, leftPos + WIDTH, topPos + HEIGHT, 0xB0101010);

        int w = 220, h = 104;
        int x = leftPos + (WIDTH - w) / 2, y = topPos + 30;
        g.fill(x - 1, y - 1, x + w + 1, y + h + 1, LABEL_COLOR);
        g.fill(x, y, x + w, y + h, 0xFFDBD8CD);
        g.fill(x + 1, y + 1, x + w - 1, y + 2, 0xFFF2F0E9);

        // Title with the result
        ItemStack result = recipe.result();
        Component title = Component.translatable("gui.hazennstuff.radiant_altar.confirm_title", result.getHoverName());
        int titleW = font.width(title) + 20;
        int tx = x + (w - titleW) / 2;
        g.renderItem(result, tx, y + 6);
        g.drawString(font, title, tx + 20, y + 10, LABEL_COLOR, false);

        // What will be consumed
        g.drawString(font, Component.translatable("gui.hazennstuff.radiant_altar.confirm_consumes"),
                x + 8, y + 28, LABEL_COLOR, false);
        List<MaterialEntry> mats = materialsFor(recipe);
        int perRow = 11;
        for (int i = 0; i < mats.size(); i++) {
            int ix = x + 12 + (i % perRow) * 18, iy = y + 40 + (i / perRow) * 18;
            ItemStack icon = cycle(mats.get(i).ingredient(), mats.get(i).need());
            g.renderItem(icon, ix, iy);
            g.renderItemDecorations(font, icon, ix, iy);
        }
        if (mats.isEmpty()) {
            g.drawString(font, Component.translatable("gui.hazennstuff.radiant_altar.hint.no_materials"),
                    x + 12, y + 44, ROW_TEXT_DISABLED, false);
        }

        int manaY = y + 40 + Mth.positiveCeilDiv(Math.max(1, mats.size()), perRow) * 18 + 2;
        g.blit(TEXTURE, x + 10, manaY - 3, STAR_U, STAR_V, STAR_SIZE, STAR_SIZE, TEX, TEX);
        g.drawString(font, Component.translatable("gui.hazennstuff.radiant_altar.confirm_mana", recipe.mana()),
                x + 28, manaY, LABEL_COLOR, false);

        confirmButton.setY(y + h - 24);
        cancelButton.setY(y + h - 24);
        confirmButton.active = canConfirm();
        confirmButton.render(g, mouseX, mouseY, partialTick);
        cancelButton.render(g, mouseX, mouseY, partialTick);

        g.pose().popPose();
    }

    // Input

    private static boolean isIn(double mx, double my, int x, int y, int w, int h) {
        return mx >= x && mx < x + w && my >= y && my < y + h;
    }

    private int hoveredIndex(double mouseX, double mouseY) {
        for (int i = 0; i < VISIBLE; i++) {
            int x = leftPos + COLUMN_X[i % COLUMNS], y = topPos + LIST_Y + (i / COLUMNS) * ROW_H;
            if (isIn(mouseX, mouseY, x, y, ROW_W, ROW_H)) {
                int index = scrollRow * COLUMNS + i;
                return index < entryCount() ? index : -1;
            }
        }
        return -1;
    }

    private void click() {
        if (minecraft != null) {
            minecraft.getSoundManager().play(SimpleSoundInstance.forUI(SoundEvents.UI_BUTTON_CLICK, 1.0f));
        }
    }

    @Override
    public boolean mouseClicked(double mouseX, double mouseY, int button) {
        if (confirmOpen) {
            if (confirmButton.mouseClicked(mouseX, mouseY, button)) return true;
            if (cancelButton.mouseClicked(mouseX, mouseY, button)) return true;
            return true;
        }

        if (button == 0) {
            // Scroll tracks
            for (int t = 0; t < TRACKS.length; t++) {
                int[] track = TRACKS[t];
                if (isIn(mouseX, mouseY, leftPos + track[0], topPos + track[1], TRACK_W, track[2])) {
                    if (maxScroll() > 0) {
                        draggingTrack = t;
                        scrollTo(mouseY);
                    }
                    return true;
                }
            }

            // Recipes <-> Crafting
            if (isIn(mouseX, mouseY, leftPos + TOGGLE_X, topPos + TOGGLE_Y, TOGGLE_W, TOGGLE_H)) {
                mode = mode == Mode.RECIPES ? Mode.CRAFTING : Mode.RECIPES;
                scrollRow = 0;
                click();
                return true;
            }

            // Confirm
            if (isIn(mouseX, mouseY, leftPos + CHECK_X, topPos + CHECK_Y, CHECK_SIZE, CHECK_SIZE)) {
                if (canConfirm()) {
                    confirmOpen = true;
                    click();
                }
                return true;
            }

            // Picking a recipe opens its materials
            if (mode == Mode.RECIPES) {
                int index = hoveredIndex(mouseX, mouseY);
                List<RecipeEntry> recipes = recipesForMain();
                if (index >= 0 && index < recipes.size()) {
                    selected = recipes.get(index).holder().id();
                    mode = Mode.CRAFTING;
                    scrollRow = 0;
                    click();
                    return true;
                }
            }
        }
        return super.mouseClicked(mouseX, mouseY, button);
    }

    private void scrollTo(double mouseY) {
        if (draggingTrack < 0) return;
        int[] track = TRACKS[draggingTrack];
        float top = topPos + track[1] + HANDLE_H / 2f;
        float travel = track[2] - HANDLE_H;
        float frac = Mth.clamp(((float) mouseY - top) / travel, 0f, 1f);
        scrollRow = Math.round(frac * maxScroll());
    }

    @Override
    public boolean mouseDragged(double mouseX, double mouseY, int button, double dragX, double dragY) {
        if (draggingTrack >= 0) {
            scrollTo(mouseY);
            return true;
        }
        return super.mouseDragged(mouseX, mouseY, button, dragX, dragY);
    }

    @Override
    public boolean mouseReleased(double mouseX, double mouseY, int button) {
        draggingTrack = -1;
        if (confirmOpen) {
            confirmButton.mouseReleased(mouseX, mouseY, button);
            cancelButton.mouseReleased(mouseX, mouseY, button);
            return true;
        }
        return super.mouseReleased(mouseX, mouseY, button);
    }

    @Override
    public boolean mouseScrolled(double mouseX, double mouseY, double scrollX, double scrollY) {
        if (!confirmOpen && isIn(mouseX, mouseY, leftPos + COLUMN_X[0], topPos + LABEL_Y,
                TRACKS[0][0] + TRACK_W - COLUMN_X[0], LIST_Y + ROWS * ROW_H - LABEL_Y)) {
            scrollRow = Mth.clamp(scrollRow - (int) Math.signum(scrollY), 0, maxScroll());
            return true;
        }
        return super.mouseScrolled(mouseX, mouseY, scrollX, scrollY);
    }

    @Override
    public boolean keyPressed(int keyCode, int scanCode, int modifiers) {
        if (confirmOpen) {
            if (keyCode == 256) { // Escape closes the dialog, not the altar
                confirmOpen = false;
                return true;
            }
            if (keyCode == 257 || keyCode == 335) { // Enter
                confirmCraft();
                return true;
            }
            return true;
        }
        return super.keyPressed(keyCode, scanCode, modifiers);
    }

    private void confirmCraft() {
        RecipeEntry sel = selectedEntry();
        confirmOpen = false;
        if (sel == null || sel.index() < 0 || !canConfirm() || minecraft == null || minecraft.gameMode == null) return;
        minecraft.gameMode.handleInventoryButtonClick(menu.containerId, sel.index());
    }

}