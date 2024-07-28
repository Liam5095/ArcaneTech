package net.wickedbog.arcanetechmod.core.init.entity.renderer;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.wickedbog.arcanetechmod.core.init.entity.custom.FairySwarmEntity;
import net.wickedbog.arcanetechmod.core.init.entity.model.FairySwarmModel;
import org.jetbrains.annotations.NotNull;

public class FairySwarmRenderer extends MobRenderer<FairySwarmEntity, FairySwarmModel<FairySwarmEntity>> {
    public FairySwarmRenderer(EntityRendererProvider.Context context) {
        super(context, new FairySwarmModel<>(context.bakeLayer(FairySwarmModel.LAYER_LOCATION)), 0.1f);
    }

    @Override
    public @NotNull ResourceLocation getTextureLocation(FairySwarmEntity entity) {
        return new ResourceLocation("arcanetechmod:textures/entities/texture.png");
    }
}
