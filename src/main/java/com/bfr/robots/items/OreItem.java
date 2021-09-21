package com.bfr.robots.items;

import com.bfr.robots.setup.Registration;

import net.minecraft.world.item.Item;
import net.minecraftforge.fmllegacy.RegistryObject;

public class OreItem extends Item 
{
			
	public OreItem(Properties properties)
	{
		super(properties);
	}
	
	public static final RegistryObject<Item> ORE_INGOT = Registration.ITEMS.register("ore_ingot", () ->
		new OreItem(new Item.Properties()));
	
	public static void register() {}
}
