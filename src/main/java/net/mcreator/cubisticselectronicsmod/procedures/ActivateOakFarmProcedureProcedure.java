package net.mcreator.cubisticselectronicsmod.procedures;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.core.BlockPos;

import net.mcreator.cubisticselectronicsmod.init.CubisticselectronicsmodModItems;

import java.util.function.Supplier;
import java.util.Map;

public class ActivateOakFarmProcedureProcedure {
	public static void execute(LevelAccessor world, double x, double y, Entity entity) {
		if (entity == null)
			return;
		if ((world.getBlockState(new BlockPos((int) x, (int) y, (int) 1))).getMaterial() == net.minecraft.world.level.material.Material.AIR) {
			if (new Object() {
				public int getAmount(int sltid) {
					if (entity instanceof ServerPlayer _player && _player.containerMenu instanceof Supplier _current
							&& _current.get()instanceof Map _slots) {
						ItemStack stack = ((Slot) _slots.get(sltid)).getItem();
						if (stack != null)
							return stack.getCount();
					}
					return 0;
				}
			}.getAmount(0) == 1 && (entity instanceof ServerPlayer _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr
					&& _splr.get()instanceof Map _slt ? ((Slot) _slt.get(0)).getItem() : ItemStack.EMPTY)
							.getItem() == CubisticselectronicsmodModItems.LOW_ELECTRIC_ELEMENTS_INGOT) {
				world.setBlock(new BlockPos((int) x, (int) y, (int) 1), Blocks.CHEST.defaultBlockState(), 3);
			}
		} else {
			{
				Entity _ent = entity;
				if (!_ent.level.isClientSide() && _ent.getServer() != null)
					_ent.getServer().getCommands().performCommand(_ent.createCommandSourceStack().withSuppressedOutput().withPermission(4),
							"tellraw @s \"Please remove all blocks around the EnergyBlock to let this work.\"");
			}
		}
	}
}
