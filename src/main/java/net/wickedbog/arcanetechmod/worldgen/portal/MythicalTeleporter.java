package net.wickedbog.arcanetechmod.worldgen.portal;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.material.Fluids;
import net.neoforged.neoforge.common.util.ITeleporter;
import net.wickedbog.arcanetechmod.core.init.block.BlockInit;
import net.wickedbog.arcanetechmod.core.init.block.custom.ArcaneGatewayBlock;

import java.util.function.Function;

public class MythicalTeleporter implements ITeleporter {
    public static BlockPos thisPos = BlockPos.ZERO;
    public static boolean insideDimension = true;

    public MythicalTeleporter(BlockPos pos, boolean insideDim) {
        thisPos = pos;
        insideDimension = insideDim;
    }

    @Override
    public Entity placeEntity(Entity entity, ServerLevel currentWorld, ServerLevel destWorld,
                              float yaw, Function<Boolean, Entity> repositionEntity) {
        entity = repositionEntity.apply(false);
        int y = 61;

        if(!insideDimension) {
            y = thisPos.getY();
        }

        BlockPos destinationPos = new BlockPos(thisPos.getX(), y, thisPos.getZ());

        int tries = 0;
        while ((destWorld.getBlockState(destinationPos).getBlock() != Blocks.AIR) &&
                !destWorld.getBlockState(destinationPos).canBeReplaced(Fluids.WATER) &&
                (destWorld.getBlockState(destinationPos.above()).getBlock()  != Blocks.AIR) &&
                !destWorld.getBlockState(destinationPos.above()).canBeReplaced(Fluids.WATER) && (tries < 25)) {
            destinationPos = destinationPos.above(2);
            tries++;
        }

        entity.setPos(destinationPos.getX(), destinationPos.getY(), destinationPos.getZ());

        if (insideDimension) {
            boolean doSetBlock = true;
            for (BlockPos checkPos : BlockPos.betweenClosed(destinationPos.below(10).west(10),
                    destinationPos.above(10).east(10))) {
                if (destWorld.getBlockState(checkPos).getBlock() instanceof ArcaneGatewayBlock) {
                    doSetBlock = false;
                    break;
                }
            }

            if (doSetBlock) {
                destWorld.setBlock(destinationPos, BlockInit.ARCANE_GATEWAY.get().defaultBlockState(), 3);
            }
        }

        return entity;
    }
}
