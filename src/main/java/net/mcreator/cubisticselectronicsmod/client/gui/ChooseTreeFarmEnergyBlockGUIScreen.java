
package net.mcreator.cubisticselectronicsmod.client.gui;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.Minecraft;

import net.mcreator.cubisticselectronicsmod.world.inventory.ChooseTreeFarmEnergyBlockGUIMenu;
import net.mcreator.cubisticselectronicsmod.network.ChooseTreeFarmEnergyBlockGUIButtonMessage;
import net.mcreator.cubisticselectronicsmod.CubisticselectronicsmodMod;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.systems.RenderSystem;

public class ChooseTreeFarmEnergyBlockGUIScreen extends AbstractContainerScreen<ChooseTreeFarmEnergyBlockGUIMenu> {
	private final Level world;
	private final int x, y, z;
	private final Player entity;

	public ChooseTreeFarmEnergyBlockGUIScreen(ChooseTreeFarmEnergyBlockGUIMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 176;
		this.imageHeight = 166;
	}

	private static final ResourceLocation texture = new ResourceLocation("cubisticselectronicsmod:textures/choose_tree_farm_energy_block_gui.png");

	@Override
	public void render(PoseStack ms, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(ms);
		super.render(ms, mouseX, mouseY, partialTicks);
		this.renderTooltip(ms, mouseX, mouseY);
	}

	@Override
	protected void renderBg(PoseStack ms, float partialTicks, int gx, int gy) {
		RenderSystem.setShaderColor(1, 1, 1, 1);
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();
		RenderSystem.setShaderTexture(0, texture);
		this.blit(ms, this.leftPos, this.topPos, 0, 0, this.imageWidth, this.imageHeight, this.imageWidth, this.imageHeight);
		RenderSystem.disableBlend();
	}

	@Override
	public boolean keyPressed(int key, int b, int c) {
		if (key == 256) {
			this.minecraft.player.closeContainer();
			return true;
		}
		return super.keyPressed(key, b, c);
	}

	@Override
	public void containerTick() {
		super.containerTick();
	}

	@Override
	protected void renderLabels(PoseStack poseStack, int mouseX, int mouseY) {
		this.font.draw(poseStack, "Choose Tree Farm:", 43, 8, -12829636);
	}

	@Override
	public void onClose() {
		super.onClose();
		Minecraft.getInstance().keyboardHandler.setSendRepeatsToGui(false);
	}

	@Override
	public void init() {
		super.init();
		this.minecraft.keyboardHandler.setSendRepeatsToGui(true);
		this.addRenderableWidget(new Button(this.leftPos + 54, this.topPos + 33, 66, 20, new TextComponent("Oak Farm"), e -> {
			if (true) {
				CubisticselectronicsmodMod.PACKET_HANDLER.sendToServer(new ChooseTreeFarmEnergyBlockGUIButtonMessage(0, x, y, z));
				ChooseTreeFarmEnergyBlockGUIButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		}));
		this.addRenderableWidget(new Button(this.leftPos + 45, this.topPos + 58, 82, 20, new TextComponent("Spruce Farm"), e -> {
		}));
		this.addRenderableWidget(new Button(this.leftPos + 40, this.topPos + 84, 92, 20, new TextComponent("Dark Oak Farm"), e -> {
		}));
		this.addRenderableWidget(new Button(this.leftPos + 4, this.topPos + 141, 30, 20, new TextComponent("<"), e -> {
			if (true) {
				CubisticselectronicsmodMod.PACKET_HANDLER.sendToServer(new ChooseTreeFarmEnergyBlockGUIButtonMessage(3, x, y, z));
				ChooseTreeFarmEnergyBlockGUIButtonMessage.handleButtonAction(entity, 3, x, y, z);
			}
		}));
	}
}
