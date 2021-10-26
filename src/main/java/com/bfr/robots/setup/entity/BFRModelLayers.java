package com.bfr.robots.setup.entity;

import com.bfr.robots.Robots;

import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.resources.ResourceLocation;

public class BFRModelLayers {
	public static final ModelLayerLocation ROBOT_LAYER = register("robot");
			
	private static ModelLayerLocation register(String layer) {
		return new ModelLayerLocation(new ResourceLocation(Robots.MOD_ID, layer), "main");
	}
}
