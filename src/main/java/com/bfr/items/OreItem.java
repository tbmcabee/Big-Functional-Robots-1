package com.bfr.items;

import net.minecraft.world.item.Item;
import net.minecraftforge.fmllegacy.RegistryObject;
import setup.Registration;

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
