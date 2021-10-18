package com.bfr.robots.items;

import com.bfr.robots.Robots;
import com.bfr.robots.setup.items.BFRItems;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fmllegacy.RegistryObject;

//A Few Notes (From Nicholas): 
	//1. Everything related to crafting ingredients has not been finished
	//2. Currently working on the texture
	//3. Parts of this code are based on documentation from 1.16

public enum ArmorTier implements ArmorMaterial 
{

	//Sets the material for the armor items to use (Nicholas)
	NOVA_CRYSTAL("NovaCrystal", 40, new int[] { 4, 6, 8, 4 }, 15, SoundEvents.ARMOR_EQUIP_NETHERITE, 3.5F, 0.1F, BFRItems.ORE_INGOT);
	
	//System variables for armor items (Nicholas)
    private static final int[] HEALTH_PER_SLOT = new int[] { 13, 15, 16, 11 };
    private final String name;
    private final int durability, enchantmentValue;
    private final int[] slotProtections;
    private final SoundEvent sound;
    private final float toughness, knockbackResistance;
    private final RegistryObject<Item> repairIngredient;

    //Constructor for the class that initializes the system variables (Nicholas)
    private ArmorTier(String name, int durability, int[] slotProtections, int enchantmentValue, SoundEvent sound, float toughness,
                          float knockbackResistance, RegistryObject<Item> repairIngredient) 
    {
        this.name = name;
        this.durability = durability;
        this.slotProtections = slotProtections;
        this.enchantmentValue = enchantmentValue;
        this.sound = sound;
        this.toughness = toughness;
        this.knockbackResistance = knockbackResistance;
        this.repairIngredient = repairIngredient;
    }

    //Method gets the durability for the item slot (Nicholas)
    @Override
    public int getDurabilityForSlot(EquipmentSlot slot) 
    {
        return HEALTH_PER_SLOT[slot.getIndex()] * this.durability;
    }

    //Method gets the defense protection for the slot (Nicholas)
    @Override
    public int getDefenseForSlot(EquipmentSlot slot) 
    {
        return this.slotProtections[slot.getIndex()];
    }

    //Method returns the enchantment value of the armor item (Nicholas)
    @Override
    public int getEnchantmentValue() 
    {
        return this.enchantmentValue;
    }

    //Method returns the sound made when the armor item is equipped (Nicholas)
    @Override
    public SoundEvent getEquipSound() 
    {
        return this.sound;
    }

    //Method returns the repair ingredient for the armor item (Nicholas)
    @Override
    public Ingredient getRepairIngredient() 
    {
        return Ingredient.of(this.repairIngredient.get());
    }

    //Method returns the name of the armor item (Nicholas)
    @Override
    public String getName() 
    {
        return Robots.MOD_ID + ":" + this.name;
    }

    //Method returns the toughness of the armor item (Nicholas)
    @Override
    public float getToughness() 
    {
        return this.toughness;
    }

    //Method returns the knockback resistance of the armor item (Nicholas)
    @Override
    public float getKnockbackResistance() 
    {
        return this.knockbackResistance;
    }
	
}
