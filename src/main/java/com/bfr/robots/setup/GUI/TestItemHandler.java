package com.bfr.robots.setup.GUI;

import com.bfr.robots.setup.GUI.LootItemHandler;
import net.minecraft.ChatFormatting;
import net.minecraft.Util;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Style;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.storage.loot.LootTable;


public abstract class TestItemHandler 
{

	public TestItemHandler(final BlockEntityType<?> blockEntityType, final BlockPos pos, final BlockState state) 
	{
		super(blockEntityType, pos, state);
	}

	public void openGUI(final ServerPlayer player) 
	{
		if (inventory.getLootTable() != null && player.isSpectator()) {
			player.sendMessage(new TranslatableComponent("container.spectatorCantOpen").setStyle(Style.EMPTY.withColor(ChatFormatting.RED)), Util.NIL_UUID);
		} else {
			super.openGUI(player);
		}
	}
}
