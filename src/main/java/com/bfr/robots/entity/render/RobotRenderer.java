package com.bfr.robots.entity.render;

import com.bfr.robots.entity.RobotEntity;
import com.bfr.robots.entity.model.RobotModel;
import com.bfr.robots.setup.entity.BFRModelLayers;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class RobotRenderer extends MobRenderer<RobotEntity, RobotModel<RobotEntity>>{

	private static final ResourceLocation ROBOT_LOCATION = new ResourceLocation("robots:textures/entity/robot/robot_texture.png");
	
	public RobotRenderer(EntityRendererProvider.Context renderer) {
		super(renderer, new RobotModel<>(renderer.bakeLayer(BFRModelLayers.ROBOT_LAYER)), 0.7F);
	}

	@Override
	public ResourceLocation getTextureLocation(RobotEntity p_114482_) {
		// TODO Auto-generated method stub
		return ROBOT_LOCATION;
	}

}
