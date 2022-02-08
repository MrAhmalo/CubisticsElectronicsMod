
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

public class HighElectricElementsIngotItem extends Item {
	public HighElectricElementsIngotItem() {
		super(new Item.Properties().tab(CubisticselectronicsmodModTabs.TAB_ELECTRONICS_CREATIVE_TAB).stacksTo(64).rarity(Rarity.UNCOMMON));
		setRegistryName("high_electric_elements_ingot");
	}

	@Override
	public int getUseDuration(ItemStack itemstack) {
		return 0;
	}

	@Override
	public float getDestroySpeed(ItemStack par1ItemStack, BlockState par2Block) {
		return 0F;
	}

	@Override
	public void appendHoverText(ItemStack itemstack, Level world, List<Component> list, TooltipFlag flag) {
		super.appendHoverText(itemstack, world, list, flag);
		list.add(new TextComponent("Ingot with high electric level."));
	}
}
