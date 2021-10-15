package com.bfr.robots.items;

import com.bfr.robots.setup.Registration;

import net.minecraft.world.item.Item;
import net.minecraftforge.fmllegacy.RegistryObject;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.*;
import net.minecraftforge.fmllegacy.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

//A Few Notes (From Nicholas): 
	//1. Everything related to crafting ingredients has not been finished
	//2. Currently working on the texture
	//3. Parts of this code are based on documentation from 1.16

public class ArmorItems extends Item 
{

	//Constructor utilizes the Item class constructor which is called as super (Nicholas)
	public ArmorItems(Properties properties)
	{
		
		super(properties);
		
	}
	
	//Registering each armor piece to the mod's registry (Nicholas) 
	public static final RegistryObject<Item> NOVA_CRYSTAL_HELMET = Registration.ITEMS.register("NovaCrystalHelmet", 
			() -> new ItemArmor(Armor.NOVA_CRYSTAL, EquipmentSlot.HEAD, (new Item.Properties())));
	public static final RegistryObject<Item> NOVA_CRYSTAL_CHESTPLATE = Registration.ITEMS.register("NovaCrystalChestplate", 
			() -> new ItemArmor(Armor.NOVA_CRYSTAL, EquipmentSlot.CHEST, (new Item.Properties())));
	public static final RegistryObject<Item> NOVA_CRYSTAL_LEGGINGS = Registration.ITEMS.register("NovaCrystalLeggings", 
			() -> new ItemArmor(Armor.NOVA_CRYSTAL, EquipmentSlot.LEGS, (new Item.Properties())));
	public static final RegistryObject<Item> NOVA_CRYSTAL_BOOTS = Registration.ITEMS.register("NovaCrystalBoots", 
			() -> new ItemArmor(Armor.NOVA_CRYSTAL, EquipmentSlot.FEET, (new Item.Properties())));
	
	//Method to be utilized to register the armor items to the event bus in the Registration class (Nicholas)
	public static void register() {}
	
}
