package com.bfr.robots.items.tools;

import com.bfr.robots.setup.items.BFRItems;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.fmllegacy.RegistryObject;

//A Few Notes (From Nicholas): 
	//1. Everything related to crafting ingredients has not been finished
	//2. Currently working on the texture
	//3. Parts of this code are based on documentation from 1.16

public enum ToolTier implements Tier
{

	//Sets the material for the tool items to use (Nicholas)
	NOVA_CRYSTAL(4, 3092, 14.0F, 5.0F, 15, BFRItems.ORE_INGOT);
	
	//System variables for tool items (Nicholas)
    private final float speed, attackDamage;
    private final int level, durability, enchantmentValue;
    private final RegistryObject<Item> repairIngredient;

  //Constructor for the class that initializes the system variables (Nicholas)
    private ToolTier(int level, int durability, float speed, float attackDamage, int enchantmentValue, RegistryObject<Item> repairIngredient) 
    {
        this.level = level;
        this.durability = durability;
        this.speed = speed;
        this.attackDamage = attackDamage;
        this.enchantmentValue = enchantmentValue;
        this.repairIngredient = repairIngredient;
    }

    //Method returns the durability of the tool item (Nicholas)
    @Override
    public int getUses() 
    {
        return this.durability;
    }

    //Method returns the speed of the tool item (Nicholas)
    @Override
    public float getSpeed() 
    {
        return this.speed;
    }

    //Method returns the attack damage of the tool item (Nicholas)
    @Override
    public float getAttackDamageBonus() 
    {
        return this.attackDamage;
    }

    //Method returns the level of the tool item (Nicholas)
    @Override
    public int getLevel() 
    {
        return this.level;
    }

    //Method returns the enchantmnent value of the tool item (Nicholas)
    @Override
    public int getEnchantmentValue() 
    {
        return this.enchantmentValue;
    }

    //Method returns the repair ingredient for the tool item (Nicholas)
    @Override
    public Ingredient getRepairIngredient() 
    {
        return Ingredient.of(this.repairIngredient.get());
    }
	
}
