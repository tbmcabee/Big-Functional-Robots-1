package com.bfr.robots;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.InterModComms;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.InterModEnqueueEvent;
import net.minecraftforge.fml.event.lifecycle.InterModProcessEvent;
import net.minecraftforge.fmlserverevents.FMLServerStartingEvent;

import com.bfr.robots.setup.Registration;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

//net/minecraft/world/item/CreativeModeTab

import net.minecraft.world.inventory.*;

import java.util.stream.Collectors;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(Robots.MOD_ID)
public class Robots
{
	public final static String MOD_ID = "robots"; //MOD_ID constant value to be used for MOD_ID contexts and any items that are logically connected to the MOD application 
    
    private static final Logger LOGGER = LogManager.getLogger(); // Directly reference a log4j logger named LOGGER.
    
    public Robots() 
    {
    	// This call registers custom mod items into the game engine's Event Bus
    	Registration.register();
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
        // Register the setup method for modloading
        bus.addListener(this::setup);

        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);
        IEventBus forgeEventBus = MinecraftForge.EVENT_BUS;
    }

    private void setup(final FMLCommonSetupEvent event)
    {
    	
    }
}
