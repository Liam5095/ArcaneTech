package net.wickedbog.arcanetechmod.core.init.block.custom.energy.cables.block.entity;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.neoforge.capabilities.Capabilities;
import net.neoforged.neoforge.common.util.Lazy;
import net.neoforged.neoforge.energy.EnergyStorage;
import net.neoforged.neoforge.energy.IEnergyStorage;
import net.wickedbog.arcanetechmod.core.init.block.BlockEntityInit;
import net.wickedbog.arcanetechmod.util.block_util.energy.AdaptedEnergyStorage;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nonnull;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.function.Consumer;

public class CableBlockEntity extends BlockEntity {
    public static final String ENERGY_TAG = "Energy";

    public static final int MAXTRANSFER = 25;
    public static final int CAPACITY = 150;

    private final EnergyStorage energy = createEnergyStorage();
    private final Lazy<IEnergyStorage> energyHandler = Lazy.of(() -> new AdaptedEnergyStorage(energy) {
        @Override
        public int extractEnergy(int maxExtract, boolean simulate) {
            return 0;
        }

        @Override
        public int receiveEnergy(int maxReceive, boolean simulate) {
            setChanged();
            return super.receiveEnergy(maxReceive, simulate);
        }

        @Override
        public boolean canExtract() {
            return false;
        }

        @Override
        public boolean canReceive() {
            return true;
        }
    });

    private Set<BlockPos> outputs = null;

    protected CableBlockEntity(BlockEntityType<?> type, BlockPos pos, BlockState blockstate) {
        super(type, pos, blockstate);
    }

    public CableBlockEntity(BlockPos pos, BlockState blockstate) {
        super(BlockEntityInit.CABLE_BLOCK_ENTITY.get(), pos, blockstate);
    }

    public void tickServer() {
        if (energy.getEnergyStored() > 0) {
            checkOutputs();
            if (!outputs.isEmpty()) {
                int amount = energy.getEnergyStored() / outputs.size();
                for (BlockPos p : outputs) {
                    assert level != null;
                    IEnergyStorage handler = level.getCapability(Capabilities.EnergyStorage.BLOCK, p, null);
                    if (handler != null) {
                        if (handler.canReceive()) {
                            int received = handler.receiveEnergy(amount, false);
                            energy.extractEnergy(received, false);
                        }
                    }
                }
            }
        }
    }

    private void checkOutputs() {
        if (outputs == null) {
            outputs = new HashSet<>();
            traverse(worldPosition, cable -> {
                // Check for all energy receivers around this position (ignore cables)
                for (Direction direction : Direction.values()) {
                    BlockPos p = cable.getBlockPos().relative(direction);
                    assert level != null;
                    BlockEntity te = level.getBlockEntity(p);
                    if (te != null && !(te instanceof CableBlockEntity)) {
                        IEnergyStorage handler = level.getCapability(Capabilities.EnergyStorage.BLOCK, p, null);
                        if (handler != null) {
                            if (handler.canReceive()) {
                                outputs.add(p);
                            }
                        }
                    }
                }
            });
        }
    }

    public void markDirty() {
        traverse(worldPosition, cable -> cable.outputs = null);
    }

    private void traverse(BlockPos pos, Consumer<CableBlockEntity> consumer) {
        Set<BlockPos> traversed = new HashSet<>();
        traversed.add(pos);
        consumer.accept(this);
        traverse(pos, traversed, consumer);
    }

    private void traverse(BlockPos pos, Set<BlockPos> traversed, Consumer<CableBlockEntity> consumer) {
        for (Direction direction : Direction.values()) {
            BlockPos p = pos.relative(direction);
            if (!traversed.contains(p)) {
                traversed.add(p);
                assert level != null;
                if (level.getBlockEntity(p) instanceof CableBlockEntity cable) {
                    consumer.accept(cable);
                    cable.traverse(p, traversed, consumer);
                }
            }
        }
    }

    @Override
    protected void saveAdditional(@NotNull CompoundTag tag) {
        super.saveAdditional(tag);
        tag.put(ENERGY_TAG, energy.serializeNBT());
    }

    @Override
    public void load(@NotNull CompoundTag tag) {
        super.load(tag);
        if (tag.contains(ENERGY_TAG)) {
            energy.deserializeNBT(Objects.requireNonNull(tag.get(ENERGY_TAG)));
        }
    }

    @Nonnull
    private EnergyStorage createEnergyStorage() {
        return new EnergyStorage(CAPACITY, MAXTRANSFER, MAXTRANSFER);
    }

    public IEnergyStorage getEnergyHandler() {
        return energyHandler.get();
    }
}
