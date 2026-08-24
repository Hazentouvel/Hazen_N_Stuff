package net.hazen.hazennstuff.Compat.Jei;

import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.gui.builder.IRecipeLayoutBuilder;
import mezz.jei.api.gui.drawable.IDrawable;
import mezz.jei.api.gui.drawable.IDrawableAnimated;
import mezz.jei.api.gui.drawable.IDrawableStatic;
import mezz.jei.api.gui.ingredient.IRecipeSlotsView;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.recipe.IFocusGroup;
import mezz.jei.api.recipe.RecipeIngredientRole;
import mezz.jei.api.recipe.RecipeType;
import mezz.jei.api.recipe.category.IRecipeCategory;
import net.hazen.hazennstuff.HazenNStuff;
import net.hazen.hazennstuff.Item.Block.HnSBlocks;
import net.hazen.hazennstuff.Item.Block.Starforge.StarForgeRecipe;
import net.hazen.hazennstuff.Registries.HnSItemRegistry;
import net.minecraft.ChatFormatting;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;

import java.util.Arrays;
import java.util.List;

public class StarForgeRecipeCategory implements IRecipeCategory<StarForgeRecipeJei> {

    public static final ResourceLocation TEXTURE =
            ResourceLocation.fromNamespaceAndPath(HazenNStuff.MOD_ID, "textures/gui/starforge_gui.png");

    public static final RecipeType<StarForgeRecipeJei> RECIPE_TYPE =
            RecipeType.create(HazenNStuff.MOD_ID, "starforge", StarForgeRecipeJei.class);

    /** The panel without the player inventory: it ends at y=132, inventory starts at 133. */
    private static final int WIDTH = 176;
    private static final int HEIGHT = 131;

    private static final int MAIN_1_X = 68, MAIN_1_Y = 36;
    private static final int MAIN_2_X = 92, MAIN_2_Y = 36;
    private static final int MAIN_3_X = 80, MAIN_3_Y = 58;
    private static final int FUEL_X = 27, FUEL_Y = 98;
    private static final int OUTPUT_X = 80, OUTPUT_Y = 98;

    private static final int FUEL_U = 179, FUEL_V = 3, FUEL_W = 13, FUEL_H = 55;
    private static final int FUEL_DRAW_X = 28, FUEL_DRAW_Y = 28;
    private static final int PROG_U = 196, PROG_V = 2, PROG_W = 56, PROG_H = 123;
    private static final int PROG_DRAW_X = 60, PROG_DRAW_Y = 2;

    private static final int ANIMATION_TICKS = 60;

    private static final List<ItemStack> FUEL_EXAMPLES = List.of(
            new ItemStack(HnSItemRegistry.STARDUST.asItem()),
            new ItemStack(HnSItemRegistry.NETHER_STAR_FRAGMENT.asItem()),
            new ItemStack(Items.NETHER_STAR)
    );

    private final IDrawableStatic background;
    private final IDrawableStatic fuelBar;
    private final IDrawableAnimated progressBar;
    private final IDrawable icon;

    public StarForgeRecipeCategory(IGuiHelper helper) {
        this.background = helper.drawableBuilder(TEXTURE, 0, 0, WIDTH, HEIGHT)
                .setTextureSize(256, 256).build();

        this.fuelBar = helper.drawableBuilder(TEXTURE, FUEL_U, FUEL_V, FUEL_W, FUEL_H)
                .setTextureSize(256, 256).build();

        IDrawableStatic progressStatic = helper.drawableBuilder(TEXTURE, PROG_U, PROG_V, PROG_W, PROG_H)
                .setTextureSize(256, 256).build();
        this.progressBar = helper.createAnimatedDrawable(
                progressStatic, ANIMATION_TICKS, IDrawableAnimated.StartDirection.TOP, false);

        this.icon = helper.createDrawableIngredient(VanillaTypes.ITEM_STACK,
                new ItemStack(HnSBlocks.STARFORGE.get()));
    }

    @Override
    public RecipeType<StarForgeRecipeJei> getRecipeType() {
        return RECIPE_TYPE;
    }

    @Override
    public Component getTitle() {
        return Component.translatable("gui.hazennstuff.starforge");
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
        return this.icon;
    }

    @Override
    public void draw(StarForgeRecipeJei recipe, IRecipeSlotsView slotsView,
                     GuiGraphics guiGraphics, double mouseX, double mouseY) {
        background.draw(guiGraphics, 0, 0);

        // Show the gauge full
        fuelBar.draw(guiGraphics, FUEL_DRAW_X, FUEL_DRAW_Y);

        progressBar.draw(guiGraphics, PROG_DRAW_X, PROG_DRAW_Y);

        Font font = Minecraft.getInstance().font;
        String time = String.format("%.1fs", recipe.smeltTime() / 20.0f);
        guiGraphics.drawString(font, time, WIDTH - 8 - font.width(time), 34, 0xFFE8C87A, false);
    }

    @Override
    public void setRecipe(IRecipeLayoutBuilder builder, StarForgeRecipeJei recipe, IFocusGroup focuses) {
        List<StarForgeRecipe.SizedInput> inputs = recipe.ingredients();

        int[][] layout = switch (inputs.size()) {
            case 1 -> new int[][]{{MAIN_3_X, MAIN_3_Y}};
            case 2 -> new int[][]{{MAIN_1_X, MAIN_1_Y}, {MAIN_2_X, MAIN_2_Y}};
            default -> new int[][]{{MAIN_1_X, MAIN_1_Y}, {MAIN_2_X, MAIN_2_Y}, {MAIN_3_X, MAIN_3_Y}};
        };

        for (int i = 0; i < inputs.size() && i < layout.length; i++) {
            StarForgeRecipe.SizedInput input = inputs.get(i);

            List<ItemStack> stacks = Arrays.stream(input.ingredient().getItems())
                    .map(stack -> {
                        ItemStack copy = stack.copy();
                        copy.setCount(input.count());
                        return copy;
                    })
                    .toList();

            builder.addSlot(RecipeIngredientRole.INPUT, layout[i][0], layout[i][1])
                    .addItemStacks(stacks);
        }

        builder.addSlot(RecipeIngredientRole.CATALYST, FUEL_X, FUEL_Y)
                .addItemStacks(FUEL_EXAMPLES)
                .addRichTooltipCallback((view, tooltip) -> {
                    tooltip.add(Component.translatable("tooltip.hazennstuff.starforge.fuel")
                            .withStyle(ChatFormatting.GRAY));
                    tooltip.add(Component.translatable("tooltip.hazennstuff.starforge.nether_star")
                            .withStyle(ChatFormatting.AQUA));
                });

        builder.addSlot(RecipeIngredientRole.OUTPUT, OUTPUT_X, OUTPUT_Y)
                .addItemStack(recipe.result());
    }
}
