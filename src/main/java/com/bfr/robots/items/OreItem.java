package com.bfr.robots.items;

import com.bfr.robots.setup.Registration;

import net.minecraft.world.item.Item;
import net.minecraftforge.fmllegacy.RegistryObject;

//This is the class for creating the RegistryObject object for the Ore Ingot, setting up the OreItem constructor and register method (Tallon)
public class OreItem extends Item 
{
	//This specific constructor utilizes the Item class as a super, where any OreItem object will inherit the Item Class' constructor (Tallon)
	public OreItem(Properties properties)
	{
		//The OreItem constructor will be inherit the Item Class' constructor and take in a Properties object (Tallon)
		super(properties);
	}
	
	//This statement creates the RegistryObject reference for the Ore Ingot utilizing Registration.ITEMS.register method in order
	//to create the Ore Ingot utilizing Minecraft's preset ITEM Group class (Tallon)
	public static final RegistryObject<Item> ORE_INGOT = Registration.ITEMS.register("ore_ingot", () ->
		new OreItem(new Item.Properties()));
	
	//This method will be utilized to register the OreItem's ORE_INGOT asset into the Registration Class's event bus (Tallon)
	public static void register() {}
}
