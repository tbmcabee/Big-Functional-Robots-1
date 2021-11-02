package com.bfr.robots.entity;

import java.util.UUID;

import javax.annotation.Nullable;

import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.NeutralMob;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.ai.goal.RandomStrollGoal;
import net.minecraft.world.entity.animal.AbstractGolem;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;

public class RobotEntity extends AbstractGolem implements NeutralMob
{

	public RobotEntity(EntityType<? extends AbstractGolem> entity, Level world) 
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
		this.goalSelector.addGoal(0, new RandomStrollGoal(this, 1.0D));
		this.goalSelector.addGoal(1, new LookAtPlayerGoal(this, Player.class, 8.0F));
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

	@Override
	public int getRemainingPersistentAngerTime() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setRemainingPersistentAngerTime(int p_21673_) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public UUID getPersistentAngerTarget() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setPersistentAngerTarget(UUID p_21672_) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void startPersistentAngerTimer() {
		// TODO Auto-generated method stub
		
	}
	
}
