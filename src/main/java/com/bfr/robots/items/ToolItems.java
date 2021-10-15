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

public class ToolItems extends Item 
{

	//Constructor utilizes the Item class constructor which is called as super (Nicholas)
	public ToolItems(Properties properties)
	{
		
		super(properties);
		
	}
	
	//Registering each tool item to the mod's registry (Nicholas) 
    public static final RegistryObject<Item> NOVA_CRYSTAL_AXE = Registration.ITEMS.register("NovaCrystalAxe",
            () -> new AxeItem(ToolTier.NOVA_CRYSTAL, 6.0F, -3.2F, (new Item.Properties())));
    public static final RegistryObject<Item> NOVA_CRYSTAL_HOE = Registration.ITEMS.register("NovaCrystalHoe",
            () -> new HoeItem(ToolTier.NOVA_CRYSTAL, 0, -3.0F, (new Item.Properties())));
    public static final RegistryObject<Item> NOVA_CRYSTAL_PICKAXE = Registration.ITEMS.register("NovaCrystalPickaxe",
            () -> new PickaxeItem(ToolTier.NOVA_CRYSTAL, 1, -2.8F, (new Item.Properties())));
    public static final RegistryObject<Item> NOVA_CRYSTAL_SHOVEL = Registration.ITEMS.register("NovaCrystalShovel",
            () -> new ShovelItem(ToolTier.NOVA_CRYSTAL, 1.5F, -3.0F, (new Item.Properties())));
    public static final RegistryObject<Item> NOVA_CRYSTAL_SWORD = Registration.ITEMS.register("NovaCrystalSword",
            () -> new SwordItem(ToolTier.NOVA_CRYSTAL, 3, -2.4F, (new Item.Properties())));
    
  //Method to be utilized to register the armor items to the event bus in the Registration class (Nicholas)
    public static void register() {}
	
}
