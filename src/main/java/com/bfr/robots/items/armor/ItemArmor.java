package com.bfr.robots.items.armor;

import com.bfr.robots.items.armor.ArmorTier;
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

}