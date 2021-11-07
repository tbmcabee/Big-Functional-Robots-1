package com.bfr.robots.setup.entity;

import com.bfr.robots.Robots;
import com.bfr.robots.entity.RobotEntity;
import com.bfr.robots.entity.model.RobotModel;
import com.bfr.robots.entity.render.RobotRenderer;
import com.bfr.robots.setup.Registration;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fmllegacy.RegistryObject;

@Mod.EventBusSubscriber(modid = Robots.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class BFREntityTypes 
{
	
	public static final RegistryObject<EntityType<RobotEntity>> ROBOT = Registration.ENTITY_TYPES.register("robot", 
			() -> EntityType.Builder.of(RobotEntity::new, MobCategory.CREATURE).sized(.5f, 1.0f)
			.build(new ResourceLocation(Robots.MOD_ID, "robot").toString()));
	
	@SubscribeEvent
	public static void registerAttributes(EntityAttributeCreationEvent event)
	{
		event.put(ROBOT.get(), RobotEntity.setCustomAttributes().build());
	}
	
	@SubscribeEvent
	public static void registerLayers(EntityRenderersEvent.RegisterLayerDefinitions event)
	{
		event.registerLayerDefinition(BFRModelLayers.ROBOT_LAYER, RobotModel::createBodyLayer);
	}
	
	 @SubscribeEvent
	 public static void registerRenderers(EntityRenderersEvent.RegisterRenderers event)
	 {
		 event.registerEntityRenderer(ROBOT.get(), RobotRenderer::new);
	 }
	 

	public static void register() {}
}
