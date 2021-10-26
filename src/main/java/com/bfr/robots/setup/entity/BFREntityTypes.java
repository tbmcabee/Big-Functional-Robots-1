package com.bfr.robots.setup.entity;

import com.bfr.robots.Robots;
import com.bfr.robots.entity.RobotEntity;
import com.bfr.robots.setup.Registration;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.fmllegacy.RegistryObject;

public class BFREntityTypes 
{
	
	public static final RegistryObject<EntityType<RobotEntity>> ROBOT = Registration.ENTITY_TYPES.register("robot", 
			() -> EntityType.Builder.of(RobotEntity::new, MobCategory.CREATURE).sized(1.0f, 3.0f)
			.build(new ResourceLocation(Robots.MOD_ID, "robot").toString()));
	

	public static void register() {}
}
