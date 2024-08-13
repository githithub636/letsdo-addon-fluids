package dev.ninjdai.doaddoncreate.support;

import dev.ninjdai.doaddoncreate.support.annotations.SupportsMod;

public interface ModSupport {
    default void registerFluids() {};
    default void registerFluidProperties() {}
    default void registerBlocks() {}

    default String supportedMod() {
        return this.getClass().getAnnotation(SupportsMod.class).value();
    }
}
