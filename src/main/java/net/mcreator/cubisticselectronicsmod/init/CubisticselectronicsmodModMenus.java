
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.cubisticselectronicsmod.init;

import net.minecraftforge.fmllegacy.network.IContainerFactory;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.RegistryEvent;

import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.inventory.AbstractContainerMenu;

import net.mcreator.cubisticselectronicsmod.world.inventory.ChooseTreeFarmEnergyBlockGUIMenu;
import net.mcreator.cubisticselectronicsmod.world.inventory.ChooseElementEnergyBlockMenu;
import net.mcreator.cubisticselectronicsmod.world.inventory.ActivateOakFarmGUIMenu;

import java.util.List;
import java.util.ArrayList;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class CubisticselectronicsmodModMenus {
	private static final List<MenuType<?>> REGISTRY = new ArrayList<>();
	public static final MenuType<ChooseElementEnergyBlockMenu> CHOOSE_ELEMENT_ENERGY_BLOCK = register("choose_element_energy_block",
			(id, inv, extraData) -> new ChooseElementEnergyBlockMenu(id, inv, extraData));
	public static final MenuType<ChooseTreeFarmEnergyBlockGUIMenu> CHOOSE_TREE_FARM_ENERGY_BLOCK_GUI = register("choose_tree_farm_energy_block_gui",
			(id, inv, extraData) -> new ChooseTreeFarmEnergyBlockGUIMenu(id, inv, extraData));
	public static final MenuType<ActivateOakFarmGUIMenu> ACTIVATE_OAK_FARM_GUI = register("activate_oak_farm_gui",
			(id, inv, extraData) -> new ActivateOakFarmGUIMenu(id, inv, extraData));

	private static <T extends AbstractContainerMenu> MenuType<T> register(String registryname, IContainerFactory<T> containerFactory) {
		MenuType<T> menuType = new MenuType<T>(containerFactory);
		menuType.setRegistryName(registryname);
		REGISTRY.add(menuType);
		return menuType;
	}

	@SubscribeEvent
	public static void registerContainers(RegistryEvent.Register<MenuType<?>> event) {
		event.getRegistry().registerAll(REGISTRY.toArray(new MenuType[0]));
	}
}
