package com.bfr.robots.items.tools;

import com.bfr.robots.items.tools.ToolTier;
import com.bfr.robots.setup.Registration;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.item.PickaxeItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.fmllegacy.RegistryObject;

import java.util.List;

public class ItemPickaxe extends PickaxeItem {
    private final int harvestLevel;
    private final int maxUses;
    private final float efficiency;

    public ItemPickaxe(ToolTier toolTier, float attackDamage, float attackSpeed, Properties itemProperties) {
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
    public boolean mineBlock(ItemStack stack, Level worldIn, BlockState state, BlockPos pos,
                             LivingEntity entityLiving)
    {
        return super.mineBlock(stack, worldIn, state, pos, entityLiving);
    }

    @Override
    public InteractionResult useOn(UseOnContext context)
    {
        return super.useOn(context);
    }

    @Override
    public Item asItem() {
        return this;
    }

}