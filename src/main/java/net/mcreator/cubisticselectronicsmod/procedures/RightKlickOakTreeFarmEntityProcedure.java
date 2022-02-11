package net.mcreator.cubisticselectronicsmod.procedures;

import net.minecraftforge.items.ItemHandlerHelper;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;

import net.mcreator.cubisticselectronicsmod.init.CubisticselectronicsmodModItems;

public class RightKlickOakTreeFarmEntityProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof Player _player) {
			ItemStack _setstack = new ItemStack(CubisticselectronicsmodModItems.LOW_ELECTRIC_ELEMENTS_INGOT);
			_setstack.setCount(1);
			ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
		}
	}
}
