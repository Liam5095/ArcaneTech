
package net.wickedbog.arcanetechmod.core.client.entity.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.wickedbog.arcanetechmod.core.client.entity.model.ModelFairySwarm;
import net.wickedbog.arcanetechmod.core.init.entity.custom.FairySwarmEntity;

public class FairySwarmRenderer extends MobRenderer<FairySwarmEntity, 	ModelFairySwarm<FairySwarmEntity>> {
	public FairySwarmRenderer(EntityRendererProvider.Context context) {
		super(context, new ModelFairySwarm(context.bakeLayer(ModelFairySwarm.LAYER_LOCATION)), 0.5f);
	}

	@Override
	public ResourceLocation getTextureLocation(FairySwarmEntity entity) {
		return new ResourceLocation("arcanetechmod:textures/entities/solar_panel.png");
	}
}
