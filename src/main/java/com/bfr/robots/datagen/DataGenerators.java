package com.bfr.robots.datagen;

import net.minecraft.data.DataGenerator;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.forge.event.lifecycle.GatherDataEvent;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
//This class is the staging point for JSON model data generation within the gradle container. (Tallon)
public class DataGenerators 
{
	@SubscribeEvent
	//This driver method will run when the Gradle container is ran in runData mode. Once ran it will execute code from the Items.java class through the
	//created DataGenerator object. (Tallon)
	public static void gatherData(GatherDataEvent event)
	{
		DataGenerator generator = event.getGenerator();
		if (event.includeClient())
		{
			generator.addProvider(new Items(generator, event.getExistingFileHelper()));
		}
	}

}
