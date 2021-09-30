package com.bfr.robots.blocks;

import java.util.function.Supplier;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;
import net.minecraftforge.fmllegacy.RegistryObject;
import com.bfr.robots.setup.Registration;

//This is the class for creating the RegistryObject object for the Ore Block, helper method registerBlock, helper method registerBlockItem and the static
//register method (Tallon)
public class BlockOre
{
	//This initialization method creates a RegistryObject Object utilizing the registerBlock and registerBlockItem helper methods.
	//The purpose of this method is to create a forward facing registration item for the entire block, including its block
	//registration and item registration, for the game even bus to interact with. This initialization will also dictate 
	//the properties that the block item will follow including the base mining strength (mining resistance) and a method to 
	//establish the block will only drop its loot table for the correctly set out Tool (Defined in Block Tags under Data). (Tallon)
	public static final RegistryObject<Block> ORE_BLOCK = registerBlock("ore_block", 
			() -> new Block(BlockBehaviour.Properties.of(Material.METAL, MaterialColor.TERRACOTTA_LIGHT_GRAY).strength(5.0f, 6.0f)
					.sound(SoundType.METAL).requiresCorrectToolForDrops()));
	
	//This helper method will create a registration item based upon a generic supplier T and a string name.
	//This method will utilize a Block Supplier and a string name to register the block and create a 
	//logically symmetric item to represent the registered block. At the end of this method it will return the 
	//completed block registration. (Tallon)
	private static <T extends Block>RegistryObject<T> registerBlock(String name, Supplier<T> block)
	{
        RegistryObject<T> toReturn = Registration.BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }
	
	//This helper method will create a registration item based upon a generic supplier T and a string name. 
	//The purpose of this method is to create an item for the block to utilize as an asset for the player to hold.
	//If this asset did not exist, the block would not be intereactable for player to utilize within the game world. (Tallon)
	private static <T extends Block> void registerBlockItem(String name, RegistryObject<T> block)
	{
		//This statement 
        Registration.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }
	
	//This method will be utilized to register the BlockOre's ORE_BLOCK asset into the Registration Class' event bus (Tallon)
	public static void register() {}
}
