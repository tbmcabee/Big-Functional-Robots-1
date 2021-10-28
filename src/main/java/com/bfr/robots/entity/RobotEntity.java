package com.bfr.robots.entity;

import javax.annotation.Nullable;

import com.bfr.robots.setup.entity.BFREntityTypes;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.AgeableMob;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;

import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;

public class RobotEntity extends Animal
{

	public RobotEntity(EntityType<? extends Animal> entity, Level world) 
	{
		super(entity, world);
	}
	
	public static AttributeSupplier.Builder setCustomAttributes()
	{
		return Mob.createMobAttributes()
				.add(Attributes.MAX_HEALTH, 100.0D)
				.add(Attributes.MOVEMENT_SPEED, 0.15D);
	}
	
	@Override
	protected void registerGoals()
	{
		super.registerGoals();
		this.goalSelector.addGoal(0, new LookAtPlayerGoal(this, Player.class, 8.0F));
	}
	
	@SuppressWarnings("resource")
	@Override
	protected int getExperienceReward(Player player)
	{
		return 20 + this.level.random.nextInt(40);
		
	}
	
	@Nullable
	@Override
	protected SoundEvent getAmbientSound()
	{
		return SoundEvents.AMBIENT_CAVE;
	}
	
	@Nullable
	@Override
	protected SoundEvent getDeathSound()
	{
		return SoundEvents.IRON_GOLEM_DEATH;
	}
	
	@Override
	protected SoundEvent getHurtSound(DamageSource damageSourceIn)
	{
		return SoundEvents.IRON_GOLEM_HURT;
	}
	
	protected void playStepSound(BlockPos pos, BlockState blockIn) 
	{
		this.playSound(SoundEvents.IRON_GOLEM_STEP, .15F, 1.0F);;
	}
	
	@Nullable
	@Override
	public AgeableMob getBreedOffspring(ServerLevel level, AgeableMob mob)
	{
		return BFREntityTypes.ROBOT.get().create(this.level);
	}
	
}
