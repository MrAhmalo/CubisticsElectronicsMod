
package net.mcreator.cubisticselectronicsmod.network;

import net.minecraftforge.fmllegacy.network.NetworkEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.core.BlockPos;

import net.mcreator.cubisticselectronicsmod.world.inventory.ChooseTreeFarmEnergyBlockGUIMenu;
import net.mcreator.cubisticselectronicsmod.procedures.OpenOakFarmGUIProcedure;
import net.mcreator.cubisticselectronicsmod.procedures.OpenEnergyBlockFarmGUIProcedure;
import net.mcreator.cubisticselectronicsmod.CubisticselectronicsmodMod;

import java.util.function.Supplier;
import java.util.HashMap;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class ChooseTreeFarmEnergyBlockGUIButtonMessage {
	private final int buttonID, x, y, z;

	public ChooseTreeFarmEnergyBlockGUIButtonMessage(FriendlyByteBuf buffer) {
		this.buttonID = buffer.readInt();
		this.x = buffer.readInt();
		this.y = buffer.readInt();
		this.z = buffer.readInt();
	}

	public ChooseTreeFarmEnergyBlockGUIButtonMessage(int buttonID, int x, int y, int z) {
		this.buttonID = buttonID;
		this.x = x;
		this.y = y;
		this.z = z;
	}

	public static void buffer(ChooseTreeFarmEnergyBlockGUIButtonMessage message, FriendlyByteBuf buffer) {
		buffer.writeInt(message.buttonID);
		buffer.writeInt(message.x);
		buffer.writeInt(message.y);
		buffer.writeInt(message.z);
	}

	public static void handler(ChooseTreeFarmEnergyBlockGUIButtonMessage message, Supplier<NetworkEvent.Context> contextSupplier) {
		NetworkEvent.Context context = contextSupplier.get();
		context.enqueueWork(() -> {
			Player entity = context.getSender();
			int buttonID = message.buttonID;
			int x = message.x;
			int y = message.y;
			int z = message.z;
			handleButtonAction(entity, buttonID, x, y, z);
		});
		context.setPacketHandled(true);
	}

	public static void handleButtonAction(Player entity, int buttonID, int x, int y, int z) {
		Level world = entity.level;
		HashMap guistate = ChooseTreeFarmEnergyBlockGUIMenu.guistate;
		// security measure to prevent arbitrary chunk generation
		if (!world.hasChunkAt(new BlockPos(x, y, z)))
			return;
		if (buttonID == 0) {

			OpenOakFarmGUIProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 3) {

			OpenEnergyBlockFarmGUIProcedure.execute(world, x, y, z, entity);
		}
	}

	@SubscribeEvent
	public static void registerMessage(FMLCommonSetupEvent event) {
		CubisticselectronicsmodMod.addNetworkMessage(ChooseTreeFarmEnergyBlockGUIButtonMessage.class,
				ChooseTreeFarmEnergyBlockGUIButtonMessage::buffer, ChooseTreeFarmEnergyBlockGUIButtonMessage::new,
				ChooseTreeFarmEnergyBlockGUIButtonMessage::handler);
	}
}
