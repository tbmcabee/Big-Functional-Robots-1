package com.bfr.robots.setup.items;

import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.Item;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fmllegacy.RegistryObject;

import com.bfr.robots.Robots;
import com.bfr.robots.items.ArmorTier;
import com.bfr.robots.items.ConfigItem;
import com.bfr.robots.items.ItemArmor;
import com.bfr.robots.items.ItemAxe;
import com.bfr.robots.items.ItemHoe;
import com.bfr.robots.items.ItemPickaxe;
import com.bfr.robots.items.ItemShovel;
import com.bfr.robots.items.ItemSword;
import com.bfr.robots.items.OreItem;
import com.bfr.robots.items.ToolTier;
import com.bfr.robots.setup.Registration;

@Mod.EventBusSubscriber(modid = Robots.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class BFRItems {
	
	//This statement creates the RegistryObject reference for the Ore Ingot utilizing Registration.ITEMS.register method in order
	//to create the Ore Ingot utilizing Minecraft's preset ITEM Group class (Tallon)
	public static final RegistryObject<Item> ORE_INGOT = Registration.ITEMS.register("ore_ingot", () ->
		new OreItem(new Item.Properties()));
	
	public static final RegistryObject<Item> NOVA_CRYSTAL_HELMET = Registration.ITEMS.register("nova_crystal_helmet", 
			() -> new ItemArmor(ArmorTier.NOVA_CRYSTAL, EquipmentSlot.HEAD, (new Item.Properties())));
	
	public static final RegistryObject<Item> NOVA_CRYSTAL_CHESTPLATE = Registration.ITEMS.register("nova_crystal_chestplate", 
			() -> new ItemArmor(ArmorTier.NOVA_CRYSTAL, EquipmentSlot.CHEST, (new Item.Properties())));
	
	public static final RegistryObject<Item> NOVA_CRYSTAL_LEGGINGS = Registration.ITEMS.register("nova_crystal_leggings", 
			() -> new ItemArmor(ArmorTier.NOVA_CRYSTAL, EquipmentSlot.LEGS, (new Item.Properties())));
	
	public static final RegistryObject<Item> NOVA_CRYSTAL_BOOTS = Registration.ITEMS.register("nova_crystal_boots", 
			() -> new ItemArmor(ArmorTier.NOVA_CRYSTAL, EquipmentSlot.FEET, (new Item.Properties())));
	
	public static final RegistryObject<Item> NOVA_CRYSTAL_AXE = Registration.ITEMS.register("nova_crystal_axe",
            () -> new ItemAxe(ToolTier.NOVA_CRYSTAL, 6.0F, -3.2F, (new Item.Properties())));
	
	public static final RegistryObject<Item> NOVA_CRYSTAL_HOE = Registration.ITEMS.register("nova_crystal_hoe",
            () -> new ItemHoe(ToolTier.NOVA_CRYSTAL, 0, -3.0F, (new Item.Properties())));
	
    public static final RegistryObject<Item> NOVA_CRYSTAL_PICKAXE = Registration.ITEMS.register("nova_crystal_pickaxe",
            () -> new ItemPickaxe(ToolTier.NOVA_CRYSTAL, 1, -2.8F, (new Item.Properties())));
    
    public static final RegistryObject<Item> NOVA_CRYSTAL_SHOVEL = Registration.ITEMS.register("nova_crystal_shovel",
            () -> new ItemShovel(ToolTier.NOVA_CRYSTAL, 1.5F, -3.0F, (new Item.Properties())));
    
    public static final RegistryObject<Item> NOVA_CRYSTAL_SWORD = Registration.ITEMS.register("nova_crystal_sword",
            () -> new ItemSword(ToolTier.NOVA_CRYSTAL, 3, -2.4F, (new Item.Properties())));
	
    public static final RegistryObject<Item> CONFIG_ITEM = Registration.ITEMS.register("config_item", () ->
		new ConfigItem(new Item.Properties()));
    
	public static void register() {}
	
}
