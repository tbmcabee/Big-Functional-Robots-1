package com.bfr.robots.setup.world;

import net.minecraft.world.level.biome.Biome;
import net.minecraftforge.common.world.BiomeGenerationSettingsBuilder;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import com.bfr.robots.Robots;

// This class loads the configured features into the biomes (Jaiden) 
@Mod.EventBusSubscriber(modid = Robots.MOD_ID)
public class BFRBiomeLoadingEvent 
{
	// addFeatures gets the biome and generates your ore/trees/whatever in if the biome matches. (We 
	// dont have a specified biome so the ore generates no matter what.) (Jaiden)
	@SubscribeEvent(priority = EventPriority.HIGH)	
	public static void addFeatures(BiomeLoadingEvent event)
	{
        Biome.BiomeCategory biomeCategory = event.getCategory();
        BiomeGenerationSettingsBuilder builder = event.getGeneration();

        
        // Refers to the addOres function in BFRFeatures class (Jaiden) 
        BFRFeatures.addOres(builder, biomeCategory);
    }
}
