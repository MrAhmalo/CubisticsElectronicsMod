
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.cubisticselectronicsmod.init;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.CreativeModeTab;

public class CubisticselectronicsmodModTabs {
	public static CreativeModeTab TAB_ELECTRONICS_CREATIVE_TAB;

	public static void load() {
		TAB_ELECTRONICS_CREATIVE_TAB = new CreativeModeTab("tabelectronics_creative_tab") {
			@Override
			public ItemStack makeIcon() {
				return new ItemStack(CubisticselectronicsmodModItems.ELECTRONIC_BOTTLE_FOOD);
			}

			@OnlyIn(Dist.CLIENT)
			public boolean hasSearchBar() {
				return false;
			}
		};
	}
}
