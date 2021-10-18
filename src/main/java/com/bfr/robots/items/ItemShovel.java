package com.bfr.robots.items;

import com.bfr.robots.items.ToolTier;
import com.bfr.robots.setup.Registration;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import net.minecraftforge.fmllegacy.RegistryObject;

import java.util.List;

public class ItemShovel extends ShovelItem {
    private final int harvestLevel;
    private final int maxUses;
    private final float efficiency;


    public ItemShovel(ToolTier toolTier, float attackDamage, float attackSpeed, Item.Properties itemProperties) {
        super(toolTier, (int)attackDamage, (int)attackSpeed, itemProperties);
        this.harvestLevel = toolTier.getLevel();
        this.maxUses = toolTier.getUses();
        this.efficiency = toolTier.getSpeed();
    }

    @Override
    public void appendHoverText(ItemStack stack, Level worldIn, List<Component> tooltip, TooltipFlag flagIn){
        super.appendHoverText(stack, worldIn, tooltip, flagIn);
        tooltip.add(Component.nullToEmpty("Harvest Level: " + ChatFormatting.GOLD + harvestLevel));
        tooltip.add(Component.nullToEmpty("Max Uses: " + ChatFormatting.LIGHT_PURPLE + maxUses));
        tooltip.add(Component.nullToEmpty("Efficiency: " + ChatFormatting.RED + efficiency));
    }

    @Override
    public Item asItem() {
        return this;
    }

}