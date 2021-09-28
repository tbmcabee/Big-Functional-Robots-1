package com.bfr.robots.world;

import net.minecraft.world.level.biome.Biome;
import net.minecraftforge.common.world.BiomeGenerationSettingsBuilder;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import com.bfr.robots.robot.*;
import com.bfr.robots.world.*;

@Mod.EventBusSubscriber(modid = Robots.MOD_ID)
public class BFRBiomeLoadingEvent 
{
	@SubscribeEvent(priority = EventPriority.HIGH)	
	public static void addFeatures(BiomeLoadingEvent event)
	{
        Biome.BiomeCategory biomeCategory = event.getCategory();
        BiomeGenerationSettingsBuilder builder = event.getGeneration();

        BFRFeatures.addOres(builder, biomeCategory);
    }
}
