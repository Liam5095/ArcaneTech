package net.wickedbog.arcanetechmod.core.init.block.custom.energy.cables;

import net.minecraft.util.StringRepresentable;
import org.checkerframework.checker.nullness.qual.NonNull;

public enum ConnectorType implements StringRepresentable {
    NONE,
    CABLE,
    BLOCK;

    public static final ConnectorType[] VALUES = values();

    @Override
    @NonNull
    public String getSerializedName() {
        return name().toLowerCase();
    }
}
