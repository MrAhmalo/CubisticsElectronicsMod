
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

import net.mcreator.cubisticselectronicsmod.procedures.ElectricBottleEffectsProcedure;
import net.mcreator.cubisticselectronicsmod.init.CubisticselectronicsmodModTabs;

import java.util.List;

public class EletricBottleFoodItem extends Item {
	public EletricBottleFoodItem() {
		super(new Item.Properties().tab(CubisticselectronicsmodModTabs.TAB_ELECTRONICS_CREATIVE_TAB).stacksTo(64).rarity(Rarity.RARE)
				.food((new FoodProperties.Builder()).nutrition(4).saturationMod(0.7f)

						.build()));
		setRegistryName("eletric_bottle_food");
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
		list.add(new TextComponent("Elctric in a bottle."));
	}

	@Override
	public ItemStack finishUsingItem(ItemStack itemstack, Level world, LivingEntity entity) {
		ItemStack retval = super.finishUsingItem(itemstack, world, entity);
		double x = entity.getX();
		double y = entity.getY();
		double z = entity.getZ();

		ElectricBottleEffectsProcedure.execute(entity);
		return retval;
	}
}
