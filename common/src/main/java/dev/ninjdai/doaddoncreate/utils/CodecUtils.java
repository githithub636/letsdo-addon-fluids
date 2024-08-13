package dev.ninjdai.doaddoncreate.utils;

import com.mojang.datafixers.util.Pair;
import com.mojang.serialization.Codec;
import com.mojang.serialization.DataResult;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.NbtOps;
import net.minecraft.nbt.Tag;

public interface CodecUtils {
    static <T> T decodeSimple(Codec<T> codec, CompoundTag key) {
        DataResult<Pair<T, Tag>> result = codec.decode(NbtOps.INSTANCE, key);
        return result.getOrThrow(false, errorMsg -> {
            throw new RuntimeException("Failed to decode codec from tag: " + errorMsg);
        }).getFirst();
    }

    static <T> Tag encodeSimple(Codec<T> codec, T value) {
        DataResult<Tag> result = codec.encodeStart(NbtOps.INSTANCE, value);
        return result.getOrThrow(false, errorMsg -> {
            throw new RuntimeException("Failed to encode codec to tag: " + errorMsg);
        });
    }
}
