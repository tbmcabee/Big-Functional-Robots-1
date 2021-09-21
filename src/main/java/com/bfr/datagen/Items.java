package com.bfr.datagen;

import com.bfr.items.OreItem;
import com.bfr.robots.Robots;

import net.minecraft.data.DataGenerator;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import setup.Registration;

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
