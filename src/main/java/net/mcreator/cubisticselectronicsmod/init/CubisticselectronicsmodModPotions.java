
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.cubisticselectronicsmod.init;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.RegistryEvent;

import net.minecraft.world.item.alchemy.Potion;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;

import java.util.List;
import java.util.ArrayList;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class CubisticselectronicsmodModPotions {
	private static final List<Potion> REGISTRY = new ArrayList<>();
	public static final Potion ELECTRIC_BOTTLE_POTION = register(new Potion(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 10800, 2, false, false),
			new MobEffectInstance(MobEffects.DAMAGE_BOOST, 3600, 3, false, true), new MobEffectInstance(MobEffects.GLOWING, 300, 1, false, false),
			new MobEffectInstance(MobEffects.HARM, 20, 1, false, true)).setRegistryName("electric_bottle_potion"));

	private static Potion register(Potion potion) {
		REGISTRY.add(potion);
		return potion;
	}

	@SubscribeEvent
	public static void registerPotions(RegistryEvent.Register<Potion> event) {
		event.getRegistry().registerAll(REGISTRY.toArray(new Potion[0]));
	}
}
