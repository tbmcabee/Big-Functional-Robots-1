package com.bfr.robots.entity;

import java.util.function.Predicate;

import javax.annotation.Nullable;

import com.bfr.robots.setup.entity.BFREntityTypes;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier.Builder;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.CarvedPumpkinBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.pattern.BlockInWorld;
import net.minecraft.world.level.block.state.pattern.BlockPattern;
import net.minecraft.world.level.block.state.pattern.BlockPatternBuilder;
import net.minecraft.world.level.block.state.predicate.BlockMaterialPredicate;
import net.minecraft.world.level.block.state.predicate.BlockStatePredicate;
import net.minecraft.world.level.material.Material;

public class RobotEntityCarvedPumpkin extends CarvedPumpkinBlock {
	
	@Nullable
	BlockPattern robotBase;
	
	private static final Predicate<BlockState> PUMPKINS_PREDICATE = (p_51396_) -> {
	      return p_51396_ != null && (p_51396_.is(Blocks.CARVED_PUMPKIN) || p_51396_.is(Blocks.JACK_O_LANTERN));
	   };

	public RobotEntityCarvedPumpkin(Properties prop) {
		super(prop);
	}
	
	private void trySpawnGolem(Level level, BlockPos blockPosition){
		BlockPattern.BlockPatternMatch blockpattern$blockpatternmatch = this.getOrCreateRobotBase().find(level, blockPosition);
		
		if (blockpattern$blockpatternmatch != null){
			for(int i = 0; i < this.getOrCreateRobotBase().getHeight(); ++i) {
	            BlockInWorld blockinworld = blockpattern$blockpatternmatch.getBlock(0, i, 0);
	            level.setBlock(blockinworld.getPos(), Blocks.AIR.defaultBlockState(), 2);
	            level.levelEvent(2001, blockinworld.getPos(), Block.getId(blockinworld.getState()));
	         }
		}
		
		RobotEntity robot = BFREntityTypes.ROBOT.get().create(level);
        BlockPos blockpos1 = blockpattern$blockpatternmatch.getBlock(0, 2, 0).getPos();
        
	}
	
	private BlockPattern getOrCreateRobotBase() {
		if(this.robotBase == null)
			this.robotBase = BlockPatternBuilder.start().aisle("~^~", "###", "~#~").where('^', BlockInWorld.hasState(PUMPKINS_PREDICATE))
			.where('#', BlockInWorld.hasState(BlockStatePredicate.forBlock(Blocks.COBBLESTONE))).where('~', BlockInWorld.hasState(BlockMaterialPredicate.forMaterial(Material.AIR))).build();
		return this.robotBase;
	}
}
