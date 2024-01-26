package io.wispforest.accessories.client.gui;

import io.wispforest.accessories.Accessories;
import io.wispforest.accessories.client.AccessoriesMenu;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.Renderable;
import net.minecraft.client.gui.components.events.GuiEventListener;
import net.minecraft.client.gui.narration.NarratableEntry;
import net.minecraft.client.gui.narration.NarrationElementOutput;
import net.minecraft.client.resources.metadata.gui.GuiSpriteScaling;
import net.minecraft.resources.ResourceLocation;

import static io.wispforest.accessories.Accessories.MODID;

public class AccessoriesViewComponent implements Renderable, GuiEventListener, NarratableEntry {

    protected static final ResourceLocation ACCESSORIES_PANEL_LOCATION = Accessories.of("textures/gui/accessories_panel.png");

    protected static final ResourceLocation BACKGROUND_PATCH = Accessories.of("background_patch");
    protected static final ResourceLocation SCROLL_BAR_PATCH = Accessories.of("scroll_bar_patch");

    protected Minecraft minecraft;

    private int xOffset;
    private int width;
    private int height;

    protected AccessoriesMenu menu;

    //private boolean visible;
    private boolean widthTooNarrow;

    public AccessoriesViewComponent() {

    }

    public void init(int width, int height, Minecraft minecraft, boolean widthTooNarrow, AccessoriesMenu menu) {
        this.minecraft = minecraft;
        this.widthTooNarrow = widthTooNarrow;

        this.width = width;
        this.height = height;

        this.menu = menu;

        //this.visible = this.isVisibleAccordingToBookData();
        //if (this.visible) {
        this.initVisuals();
        //}
    }

    public void initVisuals() {
        this.xOffset = this.widthTooNarrow ? 0 : 86;
    }

    public int updateScreenPosition(int width, int imageWidth) {
        /*int i;
        if (*//*this.isVisible() &&*//* !this.widthTooNarrow) {
            i = *//*177 +*//* (width - imageWidth - 200) / 2;
        } else {
            i = (width - imageWidth) / 2;
        }

        return i;*/

        return (width - imageWidth) / 2;
    }


    @Override
    public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTick) {
        //if (!this.isVisible()) return;
        guiGraphics.pose().pushPose();
        guiGraphics.pose().translate(0.0F, 0.0F, 100.0F);
        int i = (this.width - 147) / 2 - this.xOffset;
        int j = (this.height - 166) / 2;

        int upperPadding = 8;

        guiGraphics.blitSprite(BACKGROUND_PATCH, i + 6/*+83*/, j, 64, 158 + upperPadding); //147
        //guiGraphics.blit(ACCESSORIES_PANEL_LOCATION, i, j, 0, 0, 147, 166);

        guiGraphics.blitSprite(SCROLL_BAR_PATCH, i + 13/* + 90*/, j + 7 + upperPadding, 8, 144);


        //guiGraphics.blit(ACCESSORIES_PANEL_LOCATION, i + 90, j + 7, 185, 0, 8, 152);

        //this.searchBox.render(guiGraphics, mouseX, mouseY, partialTick);

//            for(RecipeBookTabButton recipeBookTabButton : this.tabButtons) {
//                recipeBookTabButton.render(guiGraphics, mouseX, mouseY, partialTick);
//            }

        //this.filterButton.render(guiGraphics, mouseX, mouseY, partialTick);
        //this.recipeBookPage.render(guiGraphics, i, j, mouseX, mouseY, partialTick);
        guiGraphics.pose().popPose();

    }

    //--

//    public void toggleVisibility() {
//        this.setVisible(!this.isVisible());
//    }
//
//    public boolean isVisible() {
//        return this.visible;
//    }
//
//    private boolean isVisibleAccordingToBookData() {
//        return this.book.isOpen(this.menu.getRecipeBookType());
//    }
//
//    protected void setVisible(boolean visible) {
//        if (visible) {
//            this.initVisuals();
//        }
//
//        this.visible = visible;
//        this.book.setOpen(this.menu.getRecipeBookType(), visible);
//        if (!visible) {
//            this.recipeBookPage.setInvisible();
//        }
//
//        this.sendUpdateSettings();
//    }

    //--

    @Override
    public void setFocused(boolean focused) {

    }

    @Override
    public boolean isFocused() {
        return false;
    }

    @Override
    public NarrationPriority narrationPriority() {
        return NarrationPriority.HOVERED;
        //return this.visible ? NarrationPriority.HOVERED : NarrationPriority.NONE;
    }

    @Override
    public void updateNarration(NarrationElementOutput narrationElementOutput) {

    }
}