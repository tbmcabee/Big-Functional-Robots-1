package com.bfr.robots.items;

import com.bfr.robots.items.ToolTier;
import com.bfr.robots.setup.Registration;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import net.minecraftforge.fmllegacy.RegistryObject;

import java.util.List;

public class ItemSword extends SwordItem {
    private final int maxUses;


    public ItemSword(ToolTier toolTier, float attackDamage, float attackSpeed, Item.Properties itemProperties) {
        super(toolTier, (int)attackDamage, (int)attackSpeed, itemProperties);
        this.maxUses = toolTier.getUses();
    }

    public static final RegistryObject<Item> NOVA_CRYSTAL_SWORD = Registration.ITEMS.register("nova_crystal_sword",
            () -> new ItemSword(ToolTier.NOVA_CRYSTAL, 3, -2.4F, (new Item.Properties())));

    @Override
    public void appendHoverText(ItemStack stack, Level worldIn, List<Component> tooltip, TooltipFlag flagIn){
        super.appendHoverText(stack, worldIn, tooltip, flagIn);
        tooltip.add(Component.nullToEmpty("Max Uses: " + ChatFormatting.LIGHT_PURPLE + maxUses));
    }

    @Override
    public boolean hurtEnemy(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        return super.hurtEnemy(stack, target, attacker);
    }

    @Override
    public void onCraftedBy(ItemStack stack, Level world, Player playerEntity) {
        super.onCraftedBy(stack, world, playerEntity);
    }

    @Override
    public Item asItem() {
        return this;
    }

    public static void register() {}

}