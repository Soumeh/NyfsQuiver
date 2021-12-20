package com.nyfaria.nyfsquiver.cap;

import net.minecraft.nbt.Tag;
import net.minecraftforge.common.util.INBTSerializable;

public interface INBTSavable<T extends Tag> extends INBTSerializable<T> {
    /**
     * @deprecated Use {@link #serializeNBT(boolean)}
     */
    @Deprecated
    @Override
    default T serializeNBT() {
        return serializeNBT(false);
    }

    T serializeNBT(boolean savingToDisk);

    /**
     * @deprecated Use {@link #deserializeNBT(T, boolean)}
     */
    @Deprecated
    @Override
    default void deserializeNBT(T nbt) {
        deserializeNBT(nbt, false);
    }

    void deserializeNBT(T nbt, boolean readingFromDisk);
}
