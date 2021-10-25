package com.bfr.robots.setup.GUI;

import com.mojang.blaze3d.vertex.PoseStack;


import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.AbstractContainerMenu;

@SuppressWarnings("rawtypes")
public class ConfigMainContainer extends AbstractContainerScreen<ConfigMainMenu>
{
	private static final ResourceLocation GUI_LOCATION = new ResourceLocation("textures/gui/container/main_gui.png");
	@SuppressWarnings("unchecked")
	public ConfigMainContainer(AbstractContainerMenu menuContain, Inventory playerInventory, Component compContain) 
	{
		super(menuContain, playerInventory, compContain);

		
	}

	@Override
	protected void renderBg(PoseStack p_97787_, float p_97788_, int p_97789_, int p_97790_) {
		// TODO Auto-generated method stub
		
	}
	

}
