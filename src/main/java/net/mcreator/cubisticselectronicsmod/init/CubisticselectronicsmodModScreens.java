
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.cubisticselectronicsmod.init;

import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.client.gui.screens.MenuScreens;

import net.mcreator.cubisticselectronicsmod.client.gui.ChooseTreeFarmEnergyBlockGUIScreen;
import net.mcreator.cubisticselectronicsmod.client.gui.ChooseElementEnergyBlockScreen;
import net.mcreator.cubisticselectronicsmod.client.gui.ActivateOakFarmGUIScreen;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class CubisticselectronicsmodModScreens {
	@SubscribeEvent
	public static void clientLoad(FMLClientSetupEvent event) {
		event.enqueueWork(() -> {
			MenuScreens.register(CubisticselectronicsmodModMenus.CHOOSE_ELEMENT_ENERGY_BLOCK, ChooseElementEnergyBlockScreen::new);
			MenuScreens.register(CubisticselectronicsmodModMenus.CHOOSE_TREE_FARM_ENERGY_BLOCK_GUI, ChooseTreeFarmEnergyBlockGUIScreen::new);
			MenuScreens.register(CubisticselectronicsmodModMenus.ACTIVATE_OAK_FARM_GUI, ActivateOakFarmGUIScreen::new);
		});
	}
}
