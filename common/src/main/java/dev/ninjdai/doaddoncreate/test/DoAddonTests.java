package dev.ninjdai.doaddoncreate.test;

import com.simibubi.create.infrastructure.gametest.CreateTestFunction;
import net.minecraft.gametest.framework.GameTestGenerator;
import net.minecraft.gametest.framework.TestFunction;

import java.util.Collection;

public class DoAddonTests {
    private static final Class<?>[] testHolders = {
            FluidInterfaceTests.class
    };

    @GameTestGenerator
    public static Collection<TestFunction> generateTests() {
        return CreateTestFunction.getTestsFrom(testHolders);
    }
}
