package com.bfr.robots.items.tools;

import com.bfr.robots.items.tools.ToolTier;
import com.bfr.robots.setup.Registration;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.HoeItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraftforge.fmllegacy.RegistryObject;

import java.util.List;

public class ItemHoe extends HoeItem {
    private final int harvestLevel;
    private final int maxUses;
    private final float efficiency;

    public ItemHoe(ToolTier toolTier, float attackDamage, float attackSpeed, Properties itemProperties) {
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