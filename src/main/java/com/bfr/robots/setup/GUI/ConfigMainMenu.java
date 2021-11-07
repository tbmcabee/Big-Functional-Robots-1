package com.bfr.robots.setup.GUI;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.core.BlockPos;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ChestMenu;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraftforge.fmllegacy.network.IContainerFactory;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.SlotItemHandler;
import net.minecraftforge.items.wrapper.PlayerMainInvWrapper;

public class ConfigMainMenu extends AbstractContainerMenu
{
	public RobotEntity robotEntity;
	public Player playerEntity;
	
	//Robot entity is just a placeholder until we figure out what class we need to use with the robot itself
	public ConfigMainMenu(final int windowID, final Inventory playerInv, final RobotEntity robotEntity) 
	{
		super(GUIMenuTypes.CONFIG_GUI.get(), windowID);
		// TODO Auto-generated constructor stub
		
		super(GUIMenuTypes.REGION_BLOCK.get(), windowId);
		 blockEntity = world.getBlockEntity(pos);
		 playerEntity = player;
		
	}

	@Override
	public boolean stillValid(Player p_38874_) {
		// TODO Auto-generated method stub
		return false;
	}
	
	public static class Factory implements IContainerFactory<ConfigMainMenu> 
	{
		@Override
		public ConfigMainMenu create(final int windowId, final Inventory inv, final FriendlyByteBuf data) {
			final BlockPos pos = data.readBlockPos();
			final Level world = inv.player.getCommandSenderWorld();
			final BlockEntity blockEntity = world.getBlockEntity(pos);

			if (!(blockEntity instanceof RobotEntity)) {
				throw new IllegalStateException("Invalid block at " + pos);
			}

			return new ConfigMainMenu(windowId, inv, (RobotEntity) robotEntity);
		}
	}
}
