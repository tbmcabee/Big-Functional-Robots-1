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

public class BFRFeatures {
	public static void addOres(BiomeGenerationSettings.Builder builder, Biome.BiomeCategory biomeCategory) {
        int stageOre = GenerationStep.Decoration.UNDERGROUND_ORES.ordinal();
        
        builder.addFeature(stageOre, () -> BFRConfiguredFeatures.ORE_BLOCK);
    }
}
