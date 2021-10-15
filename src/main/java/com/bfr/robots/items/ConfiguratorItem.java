package com.bfr.robots.items;

import com.bfr.robots.setup.Registration;

import net.minecraft.world.item.Item;
import net.minecraftforge.fmllegacy.RegistryObject;

public class ConfiguratorItem extends Item
{
	public ConfiguratorItem(Properties properties)
	{
		super(properties);
	}
	
	public static final RegistryObject<Item> CONFIG_ITEM = Registration.ITEMS.register("config_item", () ->
		new ConfiguratorItem(new Item.Properties()));
	
	public static void register() {}

}
