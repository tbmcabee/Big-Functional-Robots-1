package com.bfr.robots.setup;

import com.bfr.robots.blocks.BlockOre;
import com.bfr.robots.items.OreItem;
import com.bfr.robots.robot.Robots;

import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fmllegacy.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class Registration 
{
	//This static initialization creates a DeferredRegister object for the ITEMS group class where the ITEMS can be utilized
	//to act as a super() statement when creating new ITEMS assets such as the ore ingot (Tallon)
	public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Robots.MOD_ID);
	
	//This static initialization creates a DeferredRegister object for the BLOCKS group class where the BLOCKS can be utilized
	//to act as a super() statement when creating new BLOCKS assets such as the ore block (Tallon)
	public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, Robots.MOD_ID);
	
	public static void register()
	{
		//This statement creates an IEventBus object which will be utilized to record registered mod items (Tallon)
		IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
		
		//These two register methods (ITEMS and BLOCKS) give the registration class the ability to reference ITEMS and BLOCKS
		//group properties when registering new assets such as the Ore Ingot item and Ore Block. (Tallon)
		ITEMS.register(modEventBus);
		BLOCKS.register(modEventBus);
		
		//OreItem register refers back to the Ore Item class and registers the information within that class (Tallon)
		//This handles the Ore Ingot's Item asset. 
		OreItem.register();
		
		//BlockOre register refers back to the Ore Item class and registers the information within that class (Tallon)
		//This handles the Ore Block's Block and BlockItem assets
		BlockOre.register();
	}
	
}
