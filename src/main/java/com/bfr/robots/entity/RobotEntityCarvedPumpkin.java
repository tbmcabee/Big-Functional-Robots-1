package com.bfr.robots.entity;

import net.minecraft.core.Direction;
import net.minecraft.world.level.block.CarvedPumpkinBlock;

public class RobotEntityCarvedPumpkin extends CarvedPumpkinBlock {

	public RobotEntityCarvedPumpkin(Properties p_51375_) {
		super(p_51375_);
		// TODO Auto-generated constructor stub
	    this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.NORTH));
	}
	
	

}
