package com.bfr.robots.setup.GUI;

import com.bfr.robots.Robots;

import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.level.Level;
import net.minecraftforge.common.extensions.IForgeContainerType;
import net.minecraftforge.fmllegacy.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class GUIMenuTypes 
{
	private static final DeferredRegister<MenuType<?>> MENU_TYPES = DeferredRegister.create(ForgeRegistries.CONTAINERS, Robots.MOD_ID);
	
	private static boolean isInitialized;
	
	public static final RegistryObject<MenuType<ConfigMainMenu>> CONFIG_GUI = MENU_TYPES.register("config_gui",
			() ->
			{
	
					return IForgeContainerType.create
								(
						
											(id, inv, data) ->
											{
												RobotEntity robotE = data.read;
												Level world = inv.player.getCommandSenderWorld();
												return new ConfigMainMenu(id, inv.player, robotE);
							
											}
						
										);
	
			}
	
			);
	
}
