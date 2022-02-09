
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.cubisticselectronicsmod.init;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.RegistryEvent;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.BlockItem;

import net.mcreator.cubisticselectronicsmod.item.LowElectricElementsIngotItem;
import net.mcreator.cubisticselectronicsmod.item.HighElectricElementsIngotItem;
import net.mcreator.cubisticselectronicsmod.item.ElectronicBottleFoodItem;

import java.util.List;
import java.util.ArrayList;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class CubisticselectronicsmodModItems {
	private static final List<Item> REGISTRY = new ArrayList<>();
	public static final Item ELECTRONIC_BOTTLE_FOOD = register(new ElectronicBottleFoodItem());
	public static final Item LOW_ELECTRIC_ELEMENTS_INGOT = register(new LowElectricElementsIngotItem());
	public static final Item HIGH_ELECTRIC_ELEMENTS_INGOT = register(new HighElectricElementsIngotItem());
	public static final Item LOW_ELECTRIC_ELEMENTS_ORE = register(CubisticselectronicsmodModBlocks.LOW_ELECTRIC_ELEMENTS_ORE,
			CubisticselectronicsmodModTabs.TAB_ELECTRONICS_CREATIVE_TAB);
	public static final Item HIGH_ELECTRIC_ELEMENTS_ORE = register(CubisticselectronicsmodModBlocks.HIGH_ELECTRIC_ELEMENTS_ORE,
			CubisticselectronicsmodModTabs.TAB_ELECTRONICS_CREATIVE_TAB);
	public static final Item LOW_ELECTRIC_ELEMENTS_BLOCK = register(CubisticselectronicsmodModBlocks.LOW_ELECTRIC_ELEMENTS_BLOCK,
			CubisticselectronicsmodModTabs.TAB_ELECTRONICS_CREATIVE_TAB);
	public static final Item HIGH_ELECTRIC_ELEMENTS_BLOCK = register(CubisticselectronicsmodModBlocks.HIGH_ELECTRIC_ELEMENTS_BLOCK,
			CubisticselectronicsmodModTabs.TAB_ELECTRONICS_CREATIVE_TAB);
	public static final Item ENERGY_BLOCK = register(CubisticselectronicsmodModBlocks.ENERGY_BLOCK,
			CubisticselectronicsmodModTabs.TAB_ELECTRONICS_CREATIVE_TAB);

	private static Item register(Item item) {
		REGISTRY.add(item);
		return item;
	}

	private static Item register(Block block, CreativeModeTab tab) {
		return register(new BlockItem(block, new Item.Properties().tab(tab)).setRegistryName(block.getRegistryName()));
	}

	@SubscribeEvent
	public static void registerItems(RegistryEvent.Register<Item> event) {
		event.getRegistry().registerAll(REGISTRY.toArray(new Item[0]));
	}
}
