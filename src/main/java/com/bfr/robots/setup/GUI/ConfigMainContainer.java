package com.bfr.robots.setup.GUI;

import com.bfr.robots.Robots;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;

import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.components.EditBox;
import net.minecraft.client.gui.components.ImageButton;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;

public class ConfigMainContainer extends AbstractContainerScreen<ConfigMainMenu>
{
	private static final ResourceLocation GUI_LOCATION = new ResourceLocation("textures/gui/container/main_gui.png");
	
	public EditBox minX;
	public EditBox minY;
	public EditBox minZ;
	public EditBox maxX;
	public EditBox maxY;
	public EditBox maxZ;
	
	public ConfigMainContainer(ConfigMainMenu menuContain, Inventory playerInventory, Component compContain) 
	{
		super(menuContain, playerInventory, compContain);
	}
	
	protected void init()
	{
		int relX = (this.width - this.imageWidth) / 2;
		int relY = (this.height - this.imageHeight) / 2;
		
		minX = new EditBox(font, relX + 206, relY + 15, 35, 10, TextComponent.EMPTY);
		minY = new EditBox(font, relX + 244, relY + 15, 35, 10, TextComponent.EMPTY);
		minZ = new EditBox(font, relX + 282, relY + 15, 35, 10, TextComponent.EMPTY);
		
		maxX = new EditBox(font, relX + 206, relY + 35, 35, 10, TextComponent.EMPTY);
		maxY = new EditBox(font, relX + 244, relY + 35, 35, 10, TextComponent.EMPTY);
		maxZ = new EditBox(font, relX + 282, relY + 35, 35, 10, TextComponent.EMPTY);
		
		this.maxX.setValue("" + menu.getMaxX());
		this.maxY.setValue("" + menu.getMaxY());
		this.maxZ.setValue("" + menu.getMaxZ());
		this.minX.setValue("" + menu.getMinX());
		this.minY.setValue("" + menu.getMinY());
		this.minZ.setValue("" + menu.getMinZ());
		
		this.addRenderableWidget(minX);
		this.addRenderableWidget(minY);
		this.addRenderableWidget(minZ);
		this.addRenderableWidget(maxX);
		this.addRenderableWidget(maxY);
		this.addRenderableWidget(maxZ);

		this.addRenderableWidget(new Button(relX + 235, relY + 50, 50, 20, new TranslatableComponent("screen." + Robots.MOD_ID + ".region_block.apply_location"), (button) ->
		{ 
			
			int minX = this.minX.getValue().matches("-?\\d+") ? Integer.parseInt(this.minX.getValue()) : 0;
			int minY = this.minY.getValue().matches("-?\\d+") ? Integer.parseInt(this.minY.getValue()) : 0;
			int minZ = this.minZ.getValue().matches("-?\\d+") ? Integer.parseInt(this.minZ.getValue()) : 0;
			
			int maxX = this.maxX.getValue().matches("-?\\d+") ? Integer.parseInt(this.maxX.getValue()) : 0;
			int maxY = this.maxY.getValue().matches("-?\\d+") ? Integer.parseInt(this.maxY.getValue()) : 0;
			int maxZ = this.maxZ.getValue().matches("-?\\d+") ? Integer.parseInt(this.maxZ.getValue()) : 0;
			
		}));
	}
	
	
	protected void renderBg(PoseStack PoseStack, float Ticks, int mouseX, int mouseY) 
	{
		int relX = (this.width - this.imageWidth) / 2;
		int relY = (this.height - this.imageHeight) / 2;
		
		RenderSystem.setShaderTexture(0, GUI_LOCATION);
		
		this.blit(PoseStack, relX, relY, 0, 0, this.imageWidth, this.imageHeight);
		
	}
	
	public void render(PoseStack MatrixStack, int mouseX, int mouseY, float Ticks)
	{
		
		this.renderBackground(MatrixStack);

		super.render(MatrixStack, mouseX, mouseY, Ticks);
		
	}
	
	
	

}
