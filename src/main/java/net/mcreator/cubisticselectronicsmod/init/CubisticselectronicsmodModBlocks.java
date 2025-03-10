
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.cubisticselectronicsmod.init;

import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.level.block.Block;

import net.mcreator.cubisticselectronicsmod.block.PlateBlock;
import net.mcreator.cubisticselectronicsmod.block.LowElectricElementsOreBlock;
import net.mcreator.cubisticselectronicsmod.block.LowElectricElementsBlockBlock;
import net.mcreator.cubisticselectronicsmod.block.HighElectricElementsOreBlock;
import net.mcreator.cubisticselectronicsmod.block.HighElectricElementsBlockBlock;
import net.mcreator.cubisticselectronicsmod.block.EnergyBlockBlock;

import java.util.List;
import java.util.ArrayList;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class CubisticselectronicsmodModBlocks {
	private static final List<Block> REGISTRY = new ArrayList<>();
	public static final Block LOW_ELECTRIC_ELEMENTS_ORE = register(new LowElectricElementsOreBlock());
	public static final Block HIGH_ELECTRIC_ELEMENTS_ORE = register(new HighElectricElementsOreBlock());
	public static final Block LOW_ELECTRIC_ELEMENTS_BLOCK = register(new LowElectricElementsBlockBlock());
	public static final Block HIGH_ELECTRIC_ELEMENTS_BLOCK = register(new HighElectricElementsBlockBlock());
	public static final Block ENERGY_BLOCK = register(new EnergyBlockBlock());
	public static final Block PLATE = register(new PlateBlock());

	private static Block register(Block block) {
		REGISTRY.add(block);
		return block;
	}

	@SubscribeEvent
	public static void registerBlocks(RegistryEvent.Register<Block> event) {
		event.getRegistry().registerAll(REGISTRY.toArray(new Block[0]));
	}

	@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
	public static class ClientSideHandler {
		@SubscribeEvent
		public static void clientSetup(FMLClientSetupEvent event) {
			PlateBlock.registerRenderLayer();
		}
	}
}
