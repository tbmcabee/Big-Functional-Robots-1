package com.bfr.robots.setup.GUI;

import com.bfr.robots.Robots;

import net.minecraft.world.inventory.ChestMenu;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.inventory.MerchantMenu;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fmllegacy.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;


public class GUIMenuTypes 
{
	private static final DeferredRegister<MenuType<?>> MENU_TYPES = DeferredRegister.create(ForgeRegistries.CONTAINERS, Robots.MOD_ID);
	
	private static boolean isInitialized;
	
	public static final RegistryObject<MenuType<ConfigMainMenu>> CONFIG_GUI = MENU_TYPES.register("config_gui",
			() -> new MenuType<>(new ConfigMainMenu.Factory())
	);
	
	public static void initialise(final IEventBus modEventBus) 
	{
		if (isInitialized) 
		{
			throw new IllegalStateException("Already initialised");
		}

		MENU_TYPES.register(modEventBus);

		isInitialized = true;
	}
}
