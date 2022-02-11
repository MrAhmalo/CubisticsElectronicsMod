package net.mcreator.cubisticselectronicsmod.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.layers.EyesLayer;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.RenderType;

import net.mcreator.cubisticselectronicsmod.entity.OakTreeFarmEntity;
import net.mcreator.cubisticselectronicsmod.client.model.Modelcustom_model;

public class OakTreeFarmRenderer extends MobRenderer<OakTreeFarmEntity, Modelcustom_model<OakTreeFarmEntity>> {
	public OakTreeFarmRenderer(EntityRendererProvider.Context context) {
		super(context, new Modelcustom_model(context.bakeLayer(Modelcustom_model.LAYER_LOCATION)), 0.5f);
		this.addLayer(new EyesLayer<OakTreeFarmEntity, Modelcustom_model<OakTreeFarmEntity>>(this) {
			@Override
			public RenderType renderType() {
				return RenderType.eyes(new ResourceLocation("cubisticselectronicsmod:textures/glass.png"));
			}
		});
	}

	@Override
	public ResourceLocation getTextureLocation(OakTreeFarmEntity entity) {
		return new ResourceLocation("cubisticselectronicsmod:textures/glass.png");
	}
}
