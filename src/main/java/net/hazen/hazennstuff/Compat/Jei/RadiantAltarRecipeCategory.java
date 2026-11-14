package net.hazen.hazennstuff.Compat.Jei;

import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.gui.builder.IRecipeLayoutBuilder;
import mezz.jei.api.gui.drawable.IDrawable;
import mezz.jei.api.gui.drawable.IDrawableStatic;
import mezz.jei.api.gui.ingredient.IRecipeSlotsView;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.recipe.IFocusGroup;
import mezz.jei.api.recipe.RecipeIngredientRole;
import mezz.jei.api.recipe.RecipeType;
import mezz.jei.api.recipe.category.IRecipeCategory;
import net.hazen.hazennstuff.HazenNStuff;
import net.hazen.hazennstuff.Item.Block.HnSBlocks;
import net.hazen.hazennstuff.Item.Block.RadiantAltar.RadiantAltarRecipe;
import net.hazen.hazennstuff.Item.Block.Starforge.StarForgeRecipe.SizedInput;
import net.minecraft.ChatFormatting;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

import java.util.Arrays;
import java.util.List;

public class RadiantAltarRecipeCategory implements IRecipeCategory<RadiantAltarRecipe> {

    private static final ResourceLocation GUI =
            ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "textures/gui/radiant_altar_gui.png");

    public static final RecipeType<RadiantAltarRecipe> RECIPE_TYPE =
            RecipeType.create(HazenNStuff.MOD_ID, "radiant_altar", RadiantAltarRecipe.class);

    private static final int WIDTH = 160;
    private static final int HEIGHT = 70;

    private static final int MAIN_X = 3, MAIN_Y = 3;
    private static final int SECONDARY_X = 3, SECONDARY_Y = 27;
    private static final int GRID_X = 31, GRID_Y = 3, GRID_COLUMNS = 4;
    private static final int ARROW_X = 108, ARROW_Y = 22;
    private static final int RESULT_X = 139, RESULT_Y = 21;

    private final IDrawableStatic slot;
    private final IDrawableStatic arrow;
    private final IDrawableStatic star;
    private final IDrawable icon;

    public RadiantAltarRecipeCategory(IGuiHelper helper) {
        this.slot = helper.getSlotDrawable();
        this.arrow = helper.getRecipeArrow();
        this.star = helper.drawableBuilder(GUI, 339, 1, 14, 14).setTextureSize(512, 512).build();
        this.icon = helper.createDrawableIngredient(VanillaTypes.ITEM_STACK, new ItemStack(HnSBlocks.RADIANT_ALTAR.get()));
    }

    public static List<RadiantAltarRecipe> getRecipes(Level level) {
        if (level == null) return List.of();
        return RadiantAltarRecipe.sortedRecipes(level).stream().map(h -> h.value()).toList();
    }

    @Override
    public RecipeType<RadiantAltarRecipe> getRecipeType() {
        return RECIPE_TYPE;
    }

    @Override
    public Component getTitle() {
        return Component.translatable("gui.hazennstuff.radiant_altar");
    }

    @Override
    public int getWidth() {
        return WIDTH;
    }

    @Override
    public int getHeight() {
        return HEIGHT;
    }

    @Override
    public IDrawable getIcon() {
        return icon;
    }

    @Override
    public void draw(RadiantAltarRecipe recipe, IRecipeSlotsView slotsView, GuiGraphics g, double mouseX, double mouseY) {
        slot.draw(g, MAIN_X - 1, MAIN_Y - 1);
        if (recipe.secondary().isPresent()) slot.draw(g, SECONDARY_X - 1, SECONDARY_Y - 1);
        for (int i = 0; i < recipe.materials().size(); i++) {
            slot.draw(g, gridX(i) - 1, gridY(i) - 1);
        }
        slot.draw(g, RESULT_X - 1, RESULT_Y - 1);
        arrow.draw(g, ARROW_X, ARROW_Y);

        Font font = Minecraft.getInstance().font;
        int textY = HEIGHT - 11;
        if (recipe.mana() > 0) {
            star.draw(g, 1, textY - 3);
            g.drawString(font, Component.translatable("gui.hazennstuff.radiant_altar.confirm_mana", recipe.mana()),
                    17, textY, 0xFF3F76E4, false);
        }
        String time = String.format("%.1fs", recipe.craftTime() / 20.0f);
        g.drawString(font, time, WIDTH - 2 - font.width(time), textY, 0xFF808080, false);
    }

    private static int gridX(int i) {
        return GRID_X + (i % GRID_COLUMNS) * 18;
    }

    private static int gridY(int i) {
        return GRID_Y + (i / GRID_COLUMNS) * 18;
    }

    private static List<ItemStack> sized(SizedInput input) {
        return Arrays.stream(input.ingredient().getItems())
                .map(stack -> stack.copyWithCount(input.count()))
                .toList();
    }

    @Override
    public void setRecipe(IRecipeLayoutBuilder builder, RadiantAltarRecipe recipe, IFocusGroup focuses) {
        builder.addSlot(RecipeIngredientRole.INPUT, MAIN_X, MAIN_Y)
                .addIngredients(recipe.main())
                .addRichTooltipCallback((view, tooltip) -> tooltip.add(
                        Component.translatable("gui.hazennstuff.radiant_altar.main_slot").withStyle(ChatFormatting.GOLD)));

        recipe.secondary().ifPresent(secondary ->
                builder.addSlot(RecipeIngredientRole.INPUT, SECONDARY_X, SECONDARY_Y)
                        .addItemStacks(sized(secondary))
                        .addRichTooltipCallback((view, tooltip) -> tooltip.add(
                                Component.translatable("gui.hazennstuff.radiant_altar.secondary_slot").withStyle(ChatFormatting.GRAY))));

        List<SizedInput> materials = recipe.materials();
        for (int i = 0; i < materials.size(); i++) {
            builder.addSlot(RecipeIngredientRole.INPUT, gridX(i), gridY(i))
                    .addItemStacks(sized(materials.get(i)));
        }

        builder.addSlot(RecipeIngredientRole.OUTPUT, RESULT_X, RESULT_Y)
                .addItemStack(recipe.result());
    }
}
