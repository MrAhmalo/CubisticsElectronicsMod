
package net.mcreator.cubisticselectronicsmod.item;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.network.chat.Component;

import net.mcreator.cubisticselectronicsmod.procedures.ElectronicBottleFoodEffectsProcedure;
import net.mcreator.cubisticselectronicsmod.init.CubisticselectronicsmodModTabs;

import java.util.List;

public class ElectronicBottleFoodItem extends Item {
	public ElectronicBottleFoodItem() {
		super(new Item.Properties().tab(CubisticselectronicsmodModTabs.TAB_ELECTRONICS_CREATIVE_TAB).stacksTo(3).rarity(Rarity.RARE)
				.food((new FoodProperties.Builder()).nutrition(20).saturationMod(0.5f)

						.build()));
		setRegistryName("electronic_bottle_food");
	}

	@Override
	public int getUseDuration(ItemStack stack) {
		return 60;
	}

	@Override
	public UseAnim getUseAnimation(ItemStack itemstack) {
		return UseAnim.DRINK;
	}

	@Override
	public void appendHoverText(ItemStack itemstack, Level world, List<Component> list, TooltipFlag flag) {
		super.appendHoverText(itemstack, world, list, flag);
		list.add(new TextComponent("Bottle with cool effects. Also used as fuel for ovens."));
	}

	@Override
	public ItemStack finishUsingItem(ItemStack itemstack, Level world, LivingEntity entity) {
		ItemStack retval = super.finishUsingItem(itemstack, world, entity);
		double x = entity.getX();
		double y = entity.getY();
		double z = entity.getZ();

		ElectronicBottleFoodEffectsProcedure.execute(entity);
		return retval;
	}
}
