package com.bfr.robots.setup.world;

import net.minecraft.core.Registry;
import net.minecraft.data.BuiltinRegistries;
import net.minecraft.data.worldgen.Features;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.valueproviders.BiasedToBottomInt;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.blockplacers.ColumnPlacer;
import net.minecraft.world.level.levelgen.feature.configurations.*;
import net.minecraft.world.level.levelgen.feature.featuresize.TwoLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.foliageplacers.BlobFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FancyFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.stateproviders.SimpleStateProvider;
import net.minecraft.world.level.levelgen.feature.trunkplacers.FancyTrunkPlacer;
import net.minecraft.world.level.levelgen.feature.trunkplacers.StraightTrunkPlacer;
import net.minecraft.world.level.levelgen.placement.FeatureDecorator;
import net.minecraft.world.level.levelgen.placement.FrequencyWithExtraChanceDecoratorConfiguration;
import com.bfr.robots.setup.Registration;
import com.bfr.robots.setup.blocks.BFRBlocks;
import com.bfr.robots.Robots;

// Anything that needs to be generated in the world will be put in this class (Jaiden)
public class BFRConfiguredFeatures 
{
	
	// Declaring a ConfiguredFeature for ORE_BLOCK. A configured feature is pretty much filling in the parameters on how the object should generate in the world. (Jaiden)
    public static final ConfiguredFeature<?, ?> ORE_BLOCK = register("ore_block", Feature.ORE.configured(new OreConfiguration(OreConfiguration.Predicates.STONE_ORE_REPLACEABLES, BlockStates.ORE_BLOCK, 9)).rangeUniform(VerticalAnchor.bottom(), VerticalAnchor.absolute(15))).squared().count(20);

    // This function just registers all our configured features for the mod. (Jaiden)
    private static <FC extends FeatureConfiguration> ConfiguredFeature<FC, ?> register(String name, ConfiguredFeature<FC, ?> feature)
    {
        return Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, new ResourceLocation(Robots.MOD_ID, name), feature);
    }
    
    
    //  Not positive what this class is for, but I'm assuming it just gets the defaultBlockState to load into the world (Jaiden)
    private static class BlockStates
    {
    	public static final BlockState ORE_BLOCK = BFRBlocks.ORE_BLOCK.get().defaultBlockState();
    }
}
