
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.cubisticselectronicsmod.init;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.RegistryEvent;

import net.minecraft.world.item.Item;

import net.mcreator.cubisticselectronicsmod.item.EletricBottleFoodItem;
import net.mcreator.cubisticselectronicsmod.item.ElectronicsBottleItem;

import java.util.List;
import java.util.ArrayList;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class CubisticselectronicsmodModItems {
	private static final List<Item> REGISTRY = new ArrayList<>();
	public static final Item ELECTRONIC_BOTTLE = register(new ElectronicsBottleItem());
	public static final Item ELETRIC_BOTTLE_FOOD = register(new EletricBottleFoodItem());

	private static Item register(Item item) {
		REGISTRY.add(item);
		return item;
	}

	@SubscribeEvent
	public static void registerItems(RegistryEvent.Register<Item> event) {
		event.getRegistry().registerAll(REGISTRY.toArray(new Item[0]));
	}
}
