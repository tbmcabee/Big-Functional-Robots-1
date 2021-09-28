package com.bfr.robots.datagen;

import com.bfr.robots.items.OreItem;
import com.bfr.robots.robot.Robots;
import com.bfr.robots.setup.Registration;

import net.minecraft.data.DataGenerator;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

public class Items extends ItemModelProvider 
{

	public Items(DataGenerator generator, ExistingFileHelper existingFileHelper) 
	{
		super(generator, Robots.MOD_ID, existingFileHelper);
		// TODO Auto-generated constructor stub
	}
	
	protected void registerModels()
	{
		singleTexture(OreItem.ORE_INGOT.get().getRegistryName().getPath(),
				new ResourceLocation("item/handheld"),
				"layer0",
				new ResourceLocation(Robots.MOD_ID, "item/bforeitem"));
	}
	

}
