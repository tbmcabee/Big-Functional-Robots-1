package com.bfr.robots.setup.GUI;

import net.minecraft.world.Container;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;

public interface MenuCallbacks 
{
	MenuCallbacks NOOP = new MenuCallbacks() 
	{
		public void onMenuOpened(final Player player)
		{
			
		}
		
		public void onMenuClosed(final Player player)
		{
			
		}
		
		public boolean isUsableByPlayer(final Player player)
		{
			return true;
		}
		
	};
	
	void onMenuOpened(Player player);
	
	void onMenuClosed(Player player);
	
	boolean isUsableByPlayer(Player player);

}
