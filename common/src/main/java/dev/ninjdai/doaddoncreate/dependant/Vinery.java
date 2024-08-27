package dev.ninjdai.doaddoncreate.dependant;

import com.teamresourceful.resourcefullib.common.registry.RegistryEntry;
import dev.architectury.platform.Platform;
import dev.ninjdai.doaddoncreate.registry.blocks.fluids.GlitteringFluidBlock;
import dev.ninjdai.doaddoncreate.support.ModSupport;
import dev.ninjdai.doaddoncreate.support.annotations.SupportsMod;
import dev.ninjdai.doaddoncreate.registry.DoAddonFluidProperties;
import dev.ninjdai.doaddoncreate.registry.DoAddonFluids;
import dev.ninjdai.doaddoncreate.utils.fluid.ExtraFluidDataRegistry;
import dev.ninjdai.doaddoncreate.utils.fluid.FluidDataAttachment;
import earth.terrarium.botarium.common.registry.fluid.BotariumLiquidBlock;
import earth.terrarium.botarium.common.registry.fluid.FluidData;
import net.minecraft.core.registries.Registries;
import net.minecraft.nbt.IntTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.satisfy.vinery.registry.ObjectRegistry;

import java.awt.*;
import java.util.function.Supplier;

import static dev.ninjdai.doaddoncreate.registry.DoAddonBlocks.BLOCKS;
import static dev.ninjdai.doaddoncreate.registry.DoAddonFluidProperties.FLUID_PROPERTIES;

@SupportsMod("vinery")
public class Vinery implements ModSupport {
    // Fluids
    static FluidData RED_GRAPEJUICE_PROPS;
    static FluidData WHITE_GRAPEJUICE_PROPS;
    static FluidData JUNGLE_RED_GRAPEJUICE_PROPS;
    static FluidData JUNGLE_WHITE_GRAPEJUICE_PROPS;
    static FluidData SAVANNA_RED_GRAPEJUICE_PROPS;
    static FluidData SAVANNA_WHITE_GRAPEJUICE_PROPS;
    static FluidData TAIGA_RED_GRAPEJUICE_PROPS;
    static FluidData TAIGA_WHITE_GRAPEJUICE_PROPS;

    static FluidData NOIR_WINE_PROPS;
    static FluidData CHERRY_WINE_PROPS;
    static FluidData CHORUS_WINE_PROPS;
    static FluidData EISWEIN_PROPS;

    @Override
    public void registerFluidProperties() {
        final int GRAPEJUICE_VISCOSITY = 2000;

        RED_GRAPEJUICE_PROPS = FLUID_PROPERTIES.register("red_grapejuice", new DoAddonFluidProperties.BetterBuilder().setWhiskyBeerGrapeJuice().namespacedTextures(supportedMod(), "red_grapejuice").get().viscosity(GRAPEJUICE_VISCOSITY));
        WHITE_GRAPEJUICE_PROPS = FLUID_PROPERTIES.register("white_grapejuice", new DoAddonFluidProperties.BetterBuilder().setWhiskyBeerGrapeJuice().namespacedTextures(supportedMod(), "white_grapejuice").get().viscosity(GRAPEJUICE_VISCOSITY));
        JUNGLE_RED_GRAPEJUICE_PROPS = FLUID_PROPERTIES.register("jungle_red_grapejuice", new DoAddonFluidProperties.BetterBuilder().setWhiskyBeerGrapeJuice().namespacedTextures(supportedMod(), "jungle_red_grapejuice").get().viscosity(GRAPEJUICE_VISCOSITY));
        JUNGLE_WHITE_GRAPEJUICE_PROPS = FLUID_PROPERTIES.register("jungle_white_grapejuice", new DoAddonFluidProperties.BetterBuilder().setWhiskyBeerGrapeJuice().namespacedTextures(supportedMod(), "jungle_white_grapejuice").get().viscosity(GRAPEJUICE_VISCOSITY));
        SAVANNA_RED_GRAPEJUICE_PROPS = FLUID_PROPERTIES.register("savanna_red_grapejuice", new DoAddonFluidProperties.BetterBuilder().setWhiskyBeerGrapeJuice().namespacedTextures(supportedMod(), "savanna_red_grapejuice").get().viscosity(GRAPEJUICE_VISCOSITY));
        SAVANNA_WHITE_GRAPEJUICE_PROPS = FLUID_PROPERTIES.register("savanna_white_grapejuice", new DoAddonFluidProperties.BetterBuilder().setWhiskyBeerGrapeJuice().namespacedTextures(supportedMod(), "savanna_white_grapejuice").get().viscosity(GRAPEJUICE_VISCOSITY));
        TAIGA_RED_GRAPEJUICE_PROPS = FLUID_PROPERTIES.register("taiga_red_grapejuice", new DoAddonFluidProperties.BetterBuilder().setWhiskyBeerGrapeJuice().namespacedTextures(supportedMod(), "taiga_red_grapejuice").get().viscosity(GRAPEJUICE_VISCOSITY));
        TAIGA_WHITE_GRAPEJUICE_PROPS = FLUID_PROPERTIES.register("taiga_white_grapejuice", new DoAddonFluidProperties.BetterBuilder().setWhiskyBeerGrapeJuice().namespacedTextures(supportedMod(), "taiga_white_grapejuice").get().viscosity(GRAPEJUICE_VISCOSITY));

        NOIR_WINE_PROPS = FLUID_PROPERTIES.register("noir_wine", new DoAddonFluidProperties.BetterBuilder().setWhiskyBeerGrapeJuice().tintColor(new Color(0x5E2A45)).get().viscosity(GRAPEJUICE_VISCOSITY));
        CHERRY_WINE_PROPS = FLUID_PROPERTIES.register("cherry_wine", new DoAddonFluidProperties.BetterBuilder().setWhiskyBeerGrapeJuice().tintColor(new Color(0x7E174C)).get().viscosity(GRAPEJUICE_VISCOSITY));
        CHORUS_WINE_PROPS = FLUID_PROPERTIES.register("chorus_wine", new DoAddonFluidProperties.BetterBuilder().setWhiskyBeerGrapeJuice().tintColor(new Color(0x825083)).get().viscosity(GRAPEJUICE_VISCOSITY));
        EISWEIN_PROPS = FLUID_PROPERTIES.register("eiswein", new DoAddonFluidProperties.BetterBuilder().setWhiskyBeerGrapeJuice().tintColor(new Color(0x4C5ED1)).get().viscosity(GRAPEJUICE_VISCOSITY));
    }

    static DoAddonFluids.StateIndependantFluid RED_GRAPEJUICE;
    static DoAddonFluids.StateIndependantFluid WHITE_GRAPEJUICE;
    static DoAddonFluids.StateIndependantFluid JUNGLE_RED_GRAPEJUICE;
    static DoAddonFluids.StateIndependantFluid JUNGLE_WHITE_GRAPEJUICE;
    static DoAddonFluids.StateIndependantFluid SAVANNA_RED_GRAPEJUICE;
    static DoAddonFluids.StateIndependantFluid SAVANNA_WHITE_GRAPEJUICE;
    static DoAddonFluids.StateIndependantFluid TAIGA_RED_GRAPEJUICE;
    static DoAddonFluids.StateIndependantFluid TAIGA_WHITE_GRAPEJUICE;

    static DoAddonFluids.StateIndependantFluid NOIR_WINE;
    static DoAddonFluids.StateIndependantFluid CHERRY_WINE;
    static DoAddonFluids.StateIndependantFluid CHORUS_WINE;
    static DoAddonFluids.StateIndependantFluid EISWEIN;

    public void registerFluids() {
        RED_GRAPEJUICE = DoAddonFluids.registerDualStatesByName("red_grapejuice", RED_GRAPEJUICE_PROPS);
        WHITE_GRAPEJUICE = DoAddonFluids.registerDualStatesByName("white_grapejuice", WHITE_GRAPEJUICE_PROPS);
        JUNGLE_RED_GRAPEJUICE = DoAddonFluids.registerDualStatesByName("jungle_red_grapejuice", JUNGLE_RED_GRAPEJUICE_PROPS);
        JUNGLE_WHITE_GRAPEJUICE = DoAddonFluids.registerDualStatesByName("jungle_white_grapejuice", JUNGLE_WHITE_GRAPEJUICE_PROPS);
        SAVANNA_RED_GRAPEJUICE = DoAddonFluids.registerDualStatesByName("savanna_red_grapejuice", SAVANNA_RED_GRAPEJUICE_PROPS);
        SAVANNA_WHITE_GRAPEJUICE = DoAddonFluids.registerDualStatesByName("savanna_white_grapejuice", SAVANNA_WHITE_GRAPEJUICE_PROPS);
        TAIGA_RED_GRAPEJUICE = DoAddonFluids.registerDualStatesByName("taiga_red_grapejuice", TAIGA_RED_GRAPEJUICE_PROPS);
        TAIGA_WHITE_GRAPEJUICE = DoAddonFluids.registerDualStatesByName("taiga_white_grapejuice", TAIGA_WHITE_GRAPEJUICE_PROPS);

        NOIR_WINE = DoAddonFluids.registerDualStatesByName("noir_wine", NOIR_WINE_PROPS);
        CHERRY_WINE = DoAddonFluids.registerDualStatesByName("cherry_wine", CHERRY_WINE_PROPS);
        CHORUS_WINE = DoAddonFluids.registerDualStatesByName("chorus_wine", CHORUS_WINE_PROPS);
        EISWEIN = DoAddonFluids.registerDualStatesByName("eiswein", EISWEIN_PROPS);

        ExtraFluidDataRegistry.registerFluidDA(
                FluidDataAttachment.create(ObjectRegistry.WINE_BOTTLE.get())
                        .supports(NOIR_WINE, ObjectRegistry.NOIR_WINE_ITEM.get())
                        .supports(CHERRY_WINE, getRegistrarItemSupplier("cherry_wine"))
                        .supports(CHORUS_WINE, getRegistrarItemSupplier("chorus_wine"))
                        .supports(EISWEIN, getRegistrarItemSupplier("eiswein"))
                        .nbtMigrateFluidwards("Year", "vinery:production_year", IntTag.valueOf(0))
                        .build()
        );
    }

    private Supplier<Item> getRegistrarItemSupplier(String id){
        return Platform.isForge()
                ? () -> ObjectRegistry.ITEMS.getRegistrar().get(new ResourceLocation(new Vinery().supportedMod(), id))
                : () -> ObjectRegistry.ITEM_REGISTRAR.get(new ResourceLocation(new Vinery().supportedMod(), id));
    }

    // Blocks
    static RegistryEntry<Block> RED_GRAPEJUICE_BLOCK;
    static RegistryEntry<Block> WHITE_GRAPEJUICE_BLOCK;
    static RegistryEntry<Block> JUNGLE_RED_GRAPEJUICE_BLOCK;
    static RegistryEntry<Block> JUNGLE_WHITE_GRAPEJUICE_BLOCK;
    static RegistryEntry<Block> SAVANNA_RED_GRAPEJUICE_BLOCK;
    static RegistryEntry<Block> SAVANNA_WHITE_GRAPEJUICE_BLOCK;
    static RegistryEntry<Block> TAIGA_RED_GRAPEJUICE_BLOCK;
    static RegistryEntry<Block> TAIGA_WHITE_GRAPEJUICE_BLOCK;

    static RegistryEntry<Block> NOIR_WINE_BLOCK;
    static RegistryEntry<Block> CHERRY_WINE_BLOCK;
    static RegistryEntry<Block> CHORUS_WINE_BLOCK;
    static RegistryEntry<Block> EISWEIN_BLOCK;

    @Override
    public void registerBlocks() {
        RED_GRAPEJUICE_BLOCK = BLOCKS.register("red_grapejuice", () -> new BotariumLiquidBlock(RED_GRAPEJUICE_PROPS, BlockBehaviour.Properties.copy(Blocks.WATER).mapColor(MapColor.COLOR_RED)));
        WHITE_GRAPEJUICE_BLOCK = BLOCKS.register("white_grapejuice", () -> new BotariumLiquidBlock(WHITE_GRAPEJUICE_PROPS, BlockBehaviour.Properties.copy(Blocks.WATER).mapColor(MapColor.COLOR_LIGHT_GREEN)));
        JUNGLE_RED_GRAPEJUICE_BLOCK = BLOCKS.register("jungle_red_grapejuice", () -> new BotariumLiquidBlock(JUNGLE_RED_GRAPEJUICE_PROPS, BlockBehaviour.Properties.copy(Blocks.WATER).mapColor(MapColor.COLOR_RED)));
        JUNGLE_WHITE_GRAPEJUICE_BLOCK = BLOCKS.register("jungle_white_grapejuice", () -> new BotariumLiquidBlock(JUNGLE_WHITE_GRAPEJUICE_PROPS, BlockBehaviour.Properties.copy(Blocks.WATER).mapColor(MapColor.COLOR_LIGHT_GREEN)));
        SAVANNA_RED_GRAPEJUICE_BLOCK = BLOCKS.register("savanna_red_grapejuice", () -> new BotariumLiquidBlock(SAVANNA_RED_GRAPEJUICE_PROPS, BlockBehaviour.Properties.copy(Blocks.WATER).mapColor(MapColor.COLOR_RED)));
        SAVANNA_WHITE_GRAPEJUICE_BLOCK = BLOCKS.register("savanna_white_grapejuice", () -> new BotariumLiquidBlock(SAVANNA_WHITE_GRAPEJUICE_PROPS, BlockBehaviour.Properties.copy(Blocks.WATER).mapColor(MapColor.COLOR_LIGHT_GREEN)));
        TAIGA_RED_GRAPEJUICE_BLOCK = BLOCKS.register("taiga_red_grapejuice", () -> new BotariumLiquidBlock(TAIGA_RED_GRAPEJUICE_PROPS, BlockBehaviour.Properties.copy(Blocks.WATER).mapColor(MapColor.COLOR_RED)));
        TAIGA_WHITE_GRAPEJUICE_BLOCK = BLOCKS.register("taiga_white_grapejuice", () -> new BotariumLiquidBlock(TAIGA_WHITE_GRAPEJUICE_PROPS, BlockBehaviour.Properties.copy(Blocks.WATER).mapColor(MapColor.COLOR_LIGHT_GREEN)));

        NOIR_WINE_BLOCK = BLOCKS.register("noir_wine", () -> new BotariumLiquidBlock(NOIR_WINE_PROPS, BlockBehaviour.Properties.copy(Blocks.WATER).mapColor(MapColor.COLOR_RED)));
        CHERRY_WINE_BLOCK = BLOCKS.register("cherry_wine", () -> new BotariumLiquidBlock(CHERRY_WINE_PROPS, BlockBehaviour.Properties.copy(Blocks.WATER).mapColor(MapColor.COLOR_RED)));
        CHORUS_WINE_BLOCK = BLOCKS.register("chorus_wine", () -> new BotariumLiquidBlock(CHORUS_WINE_PROPS, BlockBehaviour.Properties.copy(Blocks.WATER).mapColor(MapColor.TERRACOTTA_PURPLE)));
        EISWEIN_BLOCK = BLOCKS.register("eiswein", () -> new GlitteringFluidBlock(EISWEIN_PROPS, BlockBehaviour.Properties.copy(Blocks.WATER).mapColor(MapColor.COLOR_LIGHT_BLUE)));
    }

    // Tags
    public static TagKey<Item> GRAPEJUICE = TagKey.create(Registries.ITEM, new ResourceLocation(new Vinery().supportedMod(), "grapejuice"));
}
