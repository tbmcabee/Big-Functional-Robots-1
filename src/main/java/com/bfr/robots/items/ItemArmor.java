package com.bfr.robots.items;

import com.bfr.robots.items.ArmorTier;
import com.bfr.robots.setup.Registration;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraftforge.fmllegacy.RegistryObject;

import java.awt.*;
import java.util.List;

public class ItemArmor extends ArmorItem {

    //System variabes that establish the armor material and equipment slots.
    private ArmorTier armorTier;
    private EquipmentSlot equipmentSlotType;

    public ItemArmor(ArmorTier armorTier, EquipmentSlot equipmentSlotType, Properties properties) {
        super(armorTier, equipmentSlotType, properties);
        this.armorTier = armorTier;
        this.equipmentSlotType = equipmentSlotType;
    }

    public static final RegistryObject<Item> NOVA_CRYSTAL_HELMET = Registration.ITEMS.register("nova_crystal_helmet", 
			() -> new ItemArmor(ArmorTier.NOVA_CRYSTAL, EquipmentSlot.HEAD, (new Item.Properties())));
	public static final RegistryObject<Item> NOVA_CRYSTAL_CHESTPLATE = Registration.ITEMS.register("nova_crystal_chestplate", 
			() -> new ItemArmor(ArmorTier.NOVA_CRYSTAL, EquipmentSlot.CHEST, (new Item.Properties())));
	public static final RegistryObject<Item> NOVA_CRYSTAL_LEGGINGS = Registration.ITEMS.register("nova_crystal_leggings", 
			() -> new ItemArmor(ArmorTier.NOVA_CRYSTAL, EquipmentSlot.LEGS, (new Item.Properties())));
	public static final RegistryObject<Item> NOVA_CRYSTAL_BOOTS = Registration.ITEMS.register("nova_crystal_boots", 
			() -> new ItemArmor(ArmorTier.NOVA_CRYSTAL, EquipmentSlot.FEET, (new Item.Properties())));

    @Override
    public void onArmorTick(ItemStack stack, Level world, Player player) {
        Item HELMET = player.getItemBySlot(EquipmentSlot.HEAD).getItem();
        Item CHESTPLATE = player.getItemBySlot(EquipmentSlot.CHEST).getItem();
        Item LEGGINGS = player.getItemBySlot(EquipmentSlot.LEGS).getItem();
        Item BOOTS = player.getItemBySlot(EquipmentSlot.FEET).getItem();
    }


    @Override
    public EquipmentSlot getSlot() {
        return super.getSlot();
    }

    @Override
    public net.minecraft.world.item.ArmorMaterial getMaterial() {
        return super.getMaterial();
    }

    public static void register() {}

}