package com.bfr.robots.items;

import com.bfr.robots.items.ToolTier;
import com.bfr.robots.setup.Registration;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraftforge.fmllegacy.RegistryObject;

import java.util.List;

public class ItemAxe extends AxeItem {
    private final int harvestLevel;
    private final int maxUses;
    private final float efficiency;

    public ItemAxe(ToolTier toolTier, float attackDamage, float attackSpeed, Properties itemProperties) {
        super(toolTier, (int)attackDamage, (int)attackSpeed, itemProperties);
        this.harvestLevel = toolTier.getLevel();
        this.maxUses = toolTier.getUses();
        this.efficiency = toolTier.getSpeed();
    }

    public static final RegistryObject<Item> NOVA_CRYSTAL_AXE = Registration.ITEMS.register("nova_crystal_axe",
            () -> new ItemAxe(ToolTier.NOVA_CRYSTAL, 6.0F, -3.2F, (new Item.Properties())));

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

    public static void register() {}

}