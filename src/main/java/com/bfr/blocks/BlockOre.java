package com.bfr.blocks;

import java.util.function.Supplier;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;
import net.minecraftforge.fmllegacy.RegistryObject;
import setup.Registration;

public class BlockOre
{
	public static final RegistryObject<Block> ORE_BLOCK = registerBlock("ore_block", 
			() -> new Block(BlockBehaviour.Properties.of(Material.METAL, MaterialColor.TERRACOTTA_LIGHT_GRAY).strength(1.0f, 1.0f).sound(SoundType.STONE).requiresCorrectToolForDrops()));
	
	private static <T extends Block>RegistryObject<T> registerBlock(String name, Supplier<T> block)
	{
        RegistryObject<T> toReturn = Registration.BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }
	
	private static <T extends Block> void registerBlockItem(String name, RegistryObject<T> block)
	{
        Registration.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }
	
	public static void register() {}
}
