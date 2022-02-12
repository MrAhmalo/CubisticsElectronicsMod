
package net.mcreator.cubisticselectronicsmod.item;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.network.chat.Component;

import net.mcreator.cubisticselectronicsmod.init.CubisticselectronicsmodModTabs;

import java.util.List;

public class SetOakFarmItemItem extends Item {
	public SetOakFarmItemItem() {
		super(new Item.Properties().tab(CubisticselectronicsmodModTabs.TAB_ELECTRONICS_CREATIVE_TAB).stacksTo(24).fireResistant()
				.rarity(Rarity.UNCOMMON));
		setRegistryName("set_oak_farm_item");
	}

	@Override
	public int getUseDuration(ItemStack itemstack) {
		return 0;
	}

	@Override
	public float getDestroySpeed(ItemStack par1ItemStack, BlockState par2Block) {
		return 2F;
	}

	@Override
	public void appendHoverText(ItemStack itemstack, Level world, List<Component> list, TooltipFlag flag) {
		super.appendHoverText(itemstack, world, list, flag);
		list.add(new TextComponent("Item to place Oak Farm"));
	}
}
