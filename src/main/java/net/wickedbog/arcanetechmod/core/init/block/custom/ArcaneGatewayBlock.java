package net.wickedbog.arcanetechmod.core.init.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceKey;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.wickedbog.arcanetechmod.worldgen.dimension.ModDimensions;
import net.wickedbog.arcanetechmod.worldgen.portal.MythicalTeleporter;

public class ArcaneGatewayBlock extends Block {
    public ArcaneGatewayBlock(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResult use(BlockState pState, Level pLevel, BlockPos pPos, Player pPlayer, InteractionHand pHand, BlockHitResult pHit) {
        if(pPlayer.canChangeDimensions()) {
            handleArcaneGateway(pPlayer, pPos);
            return InteractionResult.SUCCESS;
        } else {
            return InteractionResult.CONSUME;
        }
    }

    private void handleArcaneGateway(Entity player, BlockPos pPos) {
        if (player.level() instanceof ServerLevel serverLevel) {
            MinecraftServer minecraftServer = serverLevel.getServer();
            ResourceKey<Level> resourceKey = player.level().dimension() == ModDimensions.MYTHICAL_REALM_LEVEL_KEY ?
                    Level.OVERWORLD : ModDimensions.MYTHICAL_REALM_LEVEL_KEY;

            ServerLevel portalDimension = minecraftServer.getLevel(resourceKey);
            if (portalDimension != null && !player.isPassenger()) {
                if(resourceKey == ModDimensions.MYTHICAL_REALM_LEVEL_KEY) {
                    player.changeDimension(portalDimension, new MythicalTeleporter(pPos, true));
                } else {
                    player.changeDimension(portalDimension, new MythicalTeleporter(pPos, false));
                }
            }
        }
    }
}
