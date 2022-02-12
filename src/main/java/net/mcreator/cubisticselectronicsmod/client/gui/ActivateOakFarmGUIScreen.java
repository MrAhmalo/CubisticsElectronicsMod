
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

import net.mcreator.cubisticselectronicsmod.world.inventory.ActivateOakFarmGUIMenu;
import net.mcreator.cubisticselectronicsmod.network.ActivateOakFarmGUIButtonMessage;
import net.mcreator.cubisticselectronicsmod.CubisticselectronicsmodMod;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.systems.RenderSystem;

public class ActivateOakFarmGUIScreen extends AbstractContainerScreen<ActivateOakFarmGUIMenu> {
	private final Level world;
	private final int x, y, z;
	private final Player entity;

	public ActivateOakFarmGUIScreen(ActivateOakFarmGUIMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 176;
		this.imageHeight = 166;
	}

	private static final ResourceLocation texture = new ResourceLocation("cubisticselectronicsmod:textures/activate_oak_farm_gui.png");

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

		RenderSystem.setShaderTexture(0, new ResourceLocation("cubisticselectronicsmod:textures/low_element.png"));
		this.blit(ms, this.leftPos + 6, this.topPos + 40, 0, 0, 16, 16, 16, 16);

		RenderSystem.setShaderTexture(0, new ResourceLocation("cubisticselectronicsmod:textures/upgradetableiconinto.png"));
		this.blit(ms, this.leftPos + 26, this.topPos + 41, 0, 0, 22, 15, 22, 15);

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
		this.font.draw(poseStack, "Activate Oak Farm:", 44, 8, -12829636);
		this.font.draw(poseStack, "4", 16, 37, -1);
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
		this.addRenderableWidget(new Button(this.leftPos + 75, this.topPos + 39, 93, 20, new TextComponent("Activate Farm"), e -> {
			if (true) {
				CubisticselectronicsmodMod.PACKET_HANDLER.sendToServer(new ActivateOakFarmGUIButtonMessage(0, x, y, z));
				ActivateOakFarmGUIButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		}));
	}
}
