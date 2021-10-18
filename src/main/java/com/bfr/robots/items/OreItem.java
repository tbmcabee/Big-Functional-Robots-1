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
	
}
