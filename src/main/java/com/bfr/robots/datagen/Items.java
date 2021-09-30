package com.bfr.robots.datagen;

import com.bfr.robots.items.OreItem;
import com.bfr.robots.robot.Robots;
import com.bfr.robots.setup.Registration;

import net.minecraft.data.DataGenerator;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

//This class is meant to represent the specific item model JSON generation code that will be 
//utilized within DataGenerators in order to create its specific JSON model. 
public class Items extends ItemModelProvider 
{
	
	//The public constructor that will be utilized within the DataGenerators class 
	//in order to create a class object that can be interacted within within the class' code. 
	//This constructor is inherited from the ItemModelProvider class (Tallon)
	public Items(DataGenerator generator, ExistingFileHelper existingFileHelper) 
	{
		super(generator, Robots.MOD_ID, existingFileHelper);
		// TODO Auto-generated constructor stub
	}
	
	//This method will register the texture location with a specified preset JSON model to utilize within the game engine.
	//This is specifically for generating a JSON model to represent the OreItem class' registered item within the game 
	//when the player is "holding" the item. (Tallon)
	protected void registerModels()
	{
		singleTexture(OreItem.ORE_INGOT.get().getRegistryName().getPath(),
				new ResourceLocation("item/handheld"),
				"layer0",
				new ResourceLocation(Robots.MOD_ID, "item/bforeitem"));
	}
	

}
