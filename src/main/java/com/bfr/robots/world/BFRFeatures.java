package com.bfr.robots.world;

import net.minecraft.data.worldgen.BiomeDefaultFeatures;
import net.minecraft.data.worldgen.Features;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.BiomeGenerationSettings;
import net.minecraft.world.level.biome.MobSpawnSettings;
import net.minecraft.world.level.levelgen.GenerationStep;
import com.bfr.robots.world.*;

// This class works with BFRBiomeLoadingEvent to actually add the ore feature to the world. (Jaiden)
public class BFRFeatures {
	public static void addOres(BiomeGenerationSettings.Builder builder, Biome.BiomeCategory biomeCategory){
		
		// Staging the ore for world generation (Jaiden)
        int stageOre = GenerationStep.Decoration.UNDERGROUND_ORES.ordinal();
        
        // Adds the ore to the game via generation (Jaiden)
        builder.addFeature(stageOre, () -> BFRConfiguredFeatures.ORE_BLOCK);
    }
}
