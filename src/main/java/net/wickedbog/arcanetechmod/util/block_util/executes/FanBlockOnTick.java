package net.wickedbog.arcanetechmod.util.block_util.executes;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.neoforged.neoforge.capabilities.Capabilities;
import net.neoforged.neoforge.common.extensions.ILevelExtension;
import net.neoforged.neoforge.energy.IEnergyStorage;

import java.util.Comparator;

public class FanBlockOnTick {
    public static void execute(LevelAccessor world, double x, double y, double z) {
        if (new Object() {
            public int getEnergyStored(LevelAccessor level, BlockPos pos) {
                if (level instanceof ILevelExtension _ext) {
                    IEnergyStorage _entityStorage = _ext.getCapability(Capabilities.EnergyStorage.BLOCK, pos, null);
                    if (_entityStorage != null)
                        return _entityStorage.getEnergyStored();
                }
                return 0;
            }
        }.getEnergyStored(world, BlockPos.containing(x, y, z)) >= 50) {
            if (world instanceof ILevelExtension _ext) {
                IEnergyStorage _entityStorage = _ext.getCapability(Capabilities.EnergyStorage.BLOCK, BlockPos.containing(x, y, z), null);
                if (_entityStorage != null)
                    _entityStorage.extractEnergy(50, false);
            }
            if ((new Object() {
                public Direction getDirection(BlockPos pos) {
                    BlockState _bs = world.getBlockState(pos);
                    Property<?> property = _bs.getBlock().getStateDefinition().getProperty("facing");
                    if (property != null && _bs.getValue(property) instanceof Direction _dir)
                        return _dir;
                    else if (_bs.hasProperty(BlockStateProperties.AXIS))
                        return Direction.fromAxisAndDirection(_bs.getValue(BlockStateProperties.AXIS), Direction.AxisDirection.POSITIVE);
                    else if (_bs.hasProperty(BlockStateProperties.HORIZONTAL_AXIS))
                        return Direction.fromAxisAndDirection(_bs.getValue(BlockStateProperties.HORIZONTAL_AXIS), Direction.AxisDirection.POSITIVE);
                    return Direction.NORTH;
                }
            }.getDirection(BlockPos.containing(x, y, z))) == Direction.UP) {
                if (!world.getEntitiesOfClass(LivingEntity.class, AABB.ofSize(new Vec3(x, (y + 3), z), 6, 6, 6), e -> true).isEmpty()) {
                    ((Entity) world.getEntitiesOfClass(LivingEntity.class, AABB.ofSize(new Vec3(x, (y + 3), z), 6, 6, 6), e -> true).stream().sorted(new Object() {
                        Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                            return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                        }
                    }.compareDistOf(x, (y + 3), z)).findFirst().orElse(null)).setDeltaMovement(new Vec3(0, 0.2, 0));
                }
                if (!world.getEntitiesOfClass(ItemEntity.class, AABB.ofSize(new Vec3(x, (y + 3), z), 6, 6, 6), e -> true).isEmpty()) {
                    ((Entity) world.getEntitiesOfClass(ItemEntity.class, AABB.ofSize(new Vec3(x, (y + 3), z), 6, 6, 6), e -> true).stream().sorted(new Object() {
                        Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                            return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                        }
                    }.compareDistOf(x, (y + 3), z)).findFirst().orElse(null)).setDeltaMovement(new Vec3(0, 0.2, 0));
                }
            } else if ((new Object() {
                public Direction getDirection(BlockPos pos) {
                    BlockState _bs = world.getBlockState(pos);
                    Property<?> property = _bs.getBlock().getStateDefinition().getProperty("facing");
                    if (property != null && _bs.getValue(property) instanceof Direction _dir)
                        return _dir;
                    else if (_bs.hasProperty(BlockStateProperties.AXIS))
                        return Direction.fromAxisAndDirection(_bs.getValue(BlockStateProperties.AXIS), Direction.AxisDirection.POSITIVE);
                    else if (_bs.hasProperty(BlockStateProperties.HORIZONTAL_AXIS))
                        return Direction.fromAxisAndDirection(_bs.getValue(BlockStateProperties.HORIZONTAL_AXIS), Direction.AxisDirection.POSITIVE);
                    return Direction.NORTH;
                }
            }.getDirection(BlockPos.containing(x, y, z))) == Direction.DOWN) {
                if (!world.getEntitiesOfClass(LivingEntity.class, AABB.ofSize(new Vec3(x, (y - 3), z), 6, 6, 6), e -> true).isEmpty()) {
                    ((Entity) world.getEntitiesOfClass(LivingEntity.class, AABB.ofSize(new Vec3(x, (y - 3), z), 6, 6, 6), e -> true).stream().sorted(new Object() {
                        Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                            return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                        }
                    }.compareDistOf(x, (y - 3), z)).findFirst().orElse(null)).setDeltaMovement(new Vec3(0, (-0.2), 0));
                }
                if (!world.getEntitiesOfClass(ItemEntity.class, AABB.ofSize(new Vec3(x, (y - 3), z), 6, 6, 6), e -> true).isEmpty()) {
                    ((Entity) world.getEntitiesOfClass(ItemEntity.class, AABB.ofSize(new Vec3(x, (y - 3), z), 6, 6, 6), e -> true).stream().sorted(new Object() {
                        Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                            return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                        }
                    }.compareDistOf(x, (y - 3), z)).findFirst().orElse(null)).setDeltaMovement(new Vec3(0, (-0.2), 0));
                }
            } else if ((new Object() {
                public Direction getDirection(BlockPos pos) {
                    BlockState _bs = world.getBlockState(pos);
                    Property<?> property = _bs.getBlock().getStateDefinition().getProperty("facing");
                    if (property != null && _bs.getValue(property) instanceof Direction _dir)
                        return _dir;
                    else if (_bs.hasProperty(BlockStateProperties.AXIS))
                        return Direction.fromAxisAndDirection(_bs.getValue(BlockStateProperties.AXIS), Direction.AxisDirection.POSITIVE);
                    else if (_bs.hasProperty(BlockStateProperties.HORIZONTAL_AXIS))
                        return Direction.fromAxisAndDirection(_bs.getValue(BlockStateProperties.HORIZONTAL_AXIS), Direction.AxisDirection.POSITIVE);
                    return Direction.NORTH;
                }
            }.getDirection(BlockPos.containing(x, y, z))) == Direction.NORTH) {
                if (!world.getEntitiesOfClass(LivingEntity.class, AABB.ofSize(new Vec3(x, y, (z - 3)), 6, 6, 6), e -> true).isEmpty()) {
                    ((Entity) world.getEntitiesOfClass(LivingEntity.class, AABB.ofSize(new Vec3(x, y, (z - 3)), 6, 6, 6), e -> true).stream().sorted(new Object() {
                        Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                            return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                        }
                    }.compareDistOf(x, y, (z - 3))).findFirst().orElse(null)).setDeltaMovement(new Vec3(0, 0, (-0.2)));
                }
                if (!world.getEntitiesOfClass(ItemEntity.class, AABB.ofSize(new Vec3(x, y, (z - 3)), 6, 6, 6), e -> true).isEmpty()) {
                    ((Entity) world.getEntitiesOfClass(ItemEntity.class, AABB.ofSize(new Vec3(x, y, (z - 3)), 6, 6, 6), e -> true).stream().sorted(new Object() {
                        Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                            return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                        }
                    }.compareDistOf(x, y, (z - 3))).findFirst().orElse(null)).setDeltaMovement(new Vec3(0, 0, (-0.2)));
                }
            } else if ((new Object() {
                public Direction getDirection(BlockPos pos) {
                    BlockState _bs = world.getBlockState(pos);
                    Property<?> property = _bs.getBlock().getStateDefinition().getProperty("facing");
                    if (property != null && _bs.getValue(property) instanceof Direction _dir)
                        return _dir;
                    else if (_bs.hasProperty(BlockStateProperties.AXIS))
                        return Direction.fromAxisAndDirection(_bs.getValue(BlockStateProperties.AXIS), Direction.AxisDirection.POSITIVE);
                    else if (_bs.hasProperty(BlockStateProperties.HORIZONTAL_AXIS))
                        return Direction.fromAxisAndDirection(_bs.getValue(BlockStateProperties.HORIZONTAL_AXIS), Direction.AxisDirection.POSITIVE);
                    return Direction.NORTH;
                }
            }.getDirection(BlockPos.containing(x, y, z))) == Direction.SOUTH) {
                if (!world.getEntitiesOfClass(LivingEntity.class, AABB.ofSize(new Vec3(x, y, (z + 3)), 6, 6, 6), e -> true).isEmpty()) {
                    ((Entity) world.getEntitiesOfClass(LivingEntity.class, AABB.ofSize(new Vec3(x, y, (z + 3)), 6, 6, 6), e -> true).stream().sorted(new Object() {
                        Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                            return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                        }
                    }.compareDistOf(x, y, (z + 3))).findFirst().orElse(null)).setDeltaMovement(new Vec3(0, 0, 0.2));
                }
                if (!world.getEntitiesOfClass(ItemEntity.class, AABB.ofSize(new Vec3(x, y, (z + 3)), 6, 6, 6), e -> true).isEmpty()) {
                    ((Entity) world.getEntitiesOfClass(ItemEntity.class, AABB.ofSize(new Vec3(x, y, (z + 3)), 6, 6, 6), e -> true).stream().sorted(new Object() {
                        Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                            return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                        }
                    }.compareDistOf(x, y, (z + 3))).findFirst().orElse(null)).setDeltaMovement(new Vec3(0, 0, 0.2));
                }
            } else if ((new Object() {
                public Direction getDirection(BlockPos pos) {
                    BlockState _bs = world.getBlockState(pos);
                    Property<?> property = _bs.getBlock().getStateDefinition().getProperty("facing");
                    if (property != null && _bs.getValue(property) instanceof Direction _dir)
                        return _dir;
                    else if (_bs.hasProperty(BlockStateProperties.AXIS))
                        return Direction.fromAxisAndDirection(_bs.getValue(BlockStateProperties.AXIS), Direction.AxisDirection.POSITIVE);
                    else if (_bs.hasProperty(BlockStateProperties.HORIZONTAL_AXIS))
                        return Direction.fromAxisAndDirection(_bs.getValue(BlockStateProperties.HORIZONTAL_AXIS), Direction.AxisDirection.POSITIVE);
                    return Direction.NORTH;
                }
            }.getDirection(BlockPos.containing(x, y, z))) == Direction.WEST) {
                if (!world.getEntitiesOfClass(LivingEntity.class, AABB.ofSize(new Vec3((x - 3), y, z), 6, 6, 6), e -> true).isEmpty()) {
                    ((Entity) world.getEntitiesOfClass(LivingEntity.class, AABB.ofSize(new Vec3((x - 3), y, z), 6, 6, 6), e -> true).stream().sorted(new Object() {
                        Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                            return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                        }
                    }.compareDistOf((x - 3), y, z)).findFirst().orElse(null)).setDeltaMovement(new Vec3((-0.2), 0, 0));
                }
                if (!world.getEntitiesOfClass(ItemEntity.class, AABB.ofSize(new Vec3((x - 3), y, z), 6, 6, 6), e -> true).isEmpty()) {
                    ((Entity) world.getEntitiesOfClass(ItemEntity.class, AABB.ofSize(new Vec3((x - 3), y, z), 6, 6, 6), e -> true).stream().sorted(new Object() {
                        Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                            return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                        }
                    }.compareDistOf((x - 3), y, z)).findFirst().orElse(null)).setDeltaMovement(new Vec3((-0.2), 0, 0));
                }
            } else if ((new Object() {
                public Direction getDirection(BlockPos pos) {
                    BlockState _bs = world.getBlockState(pos);
                    Property<?> property = _bs.getBlock().getStateDefinition().getProperty("facing");
                    if (property != null && _bs.getValue(property) instanceof Direction _dir)
                        return _dir;
                    else if (_bs.hasProperty(BlockStateProperties.AXIS))
                        return Direction.fromAxisAndDirection(_bs.getValue(BlockStateProperties.AXIS), Direction.AxisDirection.POSITIVE);
                    else if (_bs.hasProperty(BlockStateProperties.HORIZONTAL_AXIS))
                        return Direction.fromAxisAndDirection(_bs.getValue(BlockStateProperties.HORIZONTAL_AXIS), Direction.AxisDirection.POSITIVE);
                    return Direction.NORTH;
                }
            }.getDirection(BlockPos.containing(x, y, z))) == Direction.EAST) {
                if (!world.getEntitiesOfClass(LivingEntity.class, AABB.ofSize(new Vec3((x + 3), y, z), 6, 6, 6), e -> true).isEmpty()) {
                    ((Entity) world.getEntitiesOfClass(LivingEntity.class, AABB.ofSize(new Vec3((x + 3), y, z), 6, 6, 6), e -> true).stream().sorted(new Object() {
                        Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                            return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                        }
                    }.compareDistOf((x + 3), y, z)).findFirst().orElse(null)).setDeltaMovement(new Vec3(0.2, 0, 0));
                }
                if (!world.getEntitiesOfClass(ItemEntity.class, AABB.ofSize(new Vec3((x + 3), y, z), 6, 6, 6), e -> true).isEmpty()) {
                    ((Entity) world.getEntitiesOfClass(ItemEntity.class, AABB.ofSize(new Vec3((x + 3), y, z), 6, 6, 6), e -> true).stream().sorted(new Object() {
                        Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
                            return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
                        }
                    }.compareDistOf((x + 3), y, z)).findFirst().orElse(null)).setDeltaMovement(new Vec3(0.2, 0, 0));
                }
            }
        }
    }

}
