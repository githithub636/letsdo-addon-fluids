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

    static FluidData CHERRY_WINE_PROPS;
    static FluidData CHORUS_WINE_PROPS;
    static FluidData MAGNETIC_WINE_PROPS;
    static FluidData JO_SPECIAL_MIXTURE_PROPS;
    static FluidData CRISTEL_WINE_PROPS;
    static FluidData GLOWING_WINE_PROPS;
    static FluidData CREEPERS_CRUSH_PROPS;
    static FluidData MEAD_PROPS;
    static FluidData RED_WINE_PROPS;
    static FluidData JELLIE_WINE_PROPS;
    static FluidData STAL_WINE_PROPS;
    static FluidData NOIR_WINE_PROPS;
    static FluidData BOLVAR_WINE_PROPS;
    static FluidData SOLARIS_WINE_PROPS;
    static FluidData EISWEIN_PROPS;
    static FluidData CHENET_WINE_PROPS;
    static FluidData KELP_CIDER_PROPS;
    static FluidData AEGIS_WINE_PROPS;
    static FluidData CLARK_WINE_PROPS;
    static FluidData MELLOHI_WINE_PROPS;
    static FluidData STRAD_WINE_PROPS;
    static FluidData APPLE_CIDER_PROPS;
    static FluidData APPLE_WINE_PROPS;
    static FluidData KNULP_WINE_PROPS;
    static FluidData LILITU_WINE_PROPS;
    static FluidData BOTTLE_MOJANG_NOIR_PROPS;
    static FluidData VILLAGERS_FRIGHT_PROPS;
    static FluidData COUNT_ROLEESTER_SHIRAZ_PROPS;
    static FluidData LAMROC_WINE_PROPS;

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

        CHERRY_WINE_PROPS = FLUID_PROPERTIES.register("cherry_wine", new DoAddonFluidProperties.BetterBuilder().setWhiskyBeerGrapeJuice().tintColor(new Color(0x7E174C)).get().viscosity(GRAPEJUICE_VISCOSITY));
        CHORUS_WINE_PROPS = FLUID_PROPERTIES.register("chorus_wine", new DoAddonFluidProperties.BetterBuilder().setWhiskyBeerGrapeJuice().tintColor(new Color(0x825083)).get().viscosity(GRAPEJUICE_VISCOSITY));
        MAGNETIC_WINE_PROPS = FLUID_PROPERTIES.register("magnetic_wine", new DoAddonFluidProperties.BetterBuilder().setWhiskyBeerGrapeJuice().tintColor(new Color(0x513F35)).get().viscosity(GRAPEJUICE_VISCOSITY));
        JO_SPECIAL_MIXTURE_PROPS = FLUID_PROPERTIES.register("jo_special_mixture", new DoAddonFluidProperties.BetterBuilder().setWhiskyBeerGrapeJuice().tintColor(new Color(0x51191F)).get().viscosity(GRAPEJUICE_VISCOSITY));
        CRISTEL_WINE_PROPS = FLUID_PROPERTIES.register("cristel_wine", new DoAddonFluidProperties.BetterBuilder().setWhiskyBeerGrapeJuice().tintColor(new Color(0xB4434A)).get().viscosity(GRAPEJUICE_VISCOSITY));
        GLOWING_WINE_PROPS = FLUID_PROPERTIES.register("glowing_wine", new DoAddonFluidProperties.BetterBuilder().setWhiskyBeerGrapeJuice().tintColor(new Color(0xCDA955)).get().viscosity(GRAPEJUICE_VISCOSITY));
        CREEPERS_CRUSH_PROPS = FLUID_PROPERTIES.register("creepers_crush", new DoAddonFluidProperties.BetterBuilder().setWhiskyBeerGrapeJuice().tintColor(new Color(0x4BB900)).get().viscosity(GRAPEJUICE_VISCOSITY));
        MEAD_PROPS = FLUID_PROPERTIES.register("mead", new DoAddonFluidProperties.BetterBuilder().setWhiskyBeerGrapeJuice().tintColor(new Color(0xD59E3D)).get().viscosity(GRAPEJUICE_VISCOSITY));
        RED_WINE_PROPS = FLUID_PROPERTIES.register("red_wine", new DoAddonFluidProperties.BetterBuilder().setWhiskyBeerGrapeJuice().tintColor(new Color(0x630B0A)).get().viscosity(GRAPEJUICE_VISCOSITY));
        JELLIE_WINE_PROPS = FLUID_PROPERTIES.register("jellie_wine", new DoAddonFluidProperties.BetterBuilder().setWhiskyBeerGrapeJuice().tintColor(new Color(0x55163E)).get().viscosity(GRAPEJUICE_VISCOSITY));
        STAL_WINE_PROPS = FLUID_PROPERTIES.register("stal_wine", new DoAddonFluidProperties.BetterBuilder().setWhiskyBeerGrapeJuice().tintColor(new Color(0x891212)).get().viscosity(GRAPEJUICE_VISCOSITY));
        NOIR_WINE_PROPS = FLUID_PROPERTIES.register("noir_wine", new DoAddonFluidProperties.BetterBuilder().setWhiskyBeerGrapeJuice().tintColor(new Color(0x5E2A45)).get().viscosity(GRAPEJUICE_VISCOSITY));
        BOLVAR_WINE_PROPS = FLUID_PROPERTIES.register("bolvar_wine", new DoAddonFluidProperties.BetterBuilder().setWhiskyBeerGrapeJuice().tintColor(new Color(0x480404)).get().viscosity(GRAPEJUICE_VISCOSITY));
        SOLARIS_WINE_PROPS = FLUID_PROPERTIES.register("solaris_wine", new DoAddonFluidProperties.BetterBuilder().setWhiskyBeerGrapeJuice().tintColor(new Color(0xD0B058)).get().viscosity(GRAPEJUICE_VISCOSITY));
        EISWEIN_PROPS = FLUID_PROPERTIES.register("eiswein", new DoAddonFluidProperties.BetterBuilder().setWhiskyBeerGrapeJuice().tintColor(new Color(0x4C5ED1)).get().viscosity(GRAPEJUICE_VISCOSITY));
        CHENET_WINE_PROPS = FLUID_PROPERTIES.register("chenet_wine", new DoAddonFluidProperties.BetterBuilder().setWhiskyBeerGrapeJuice().tintColor(new Color(0x6A1932)).get().viscosity(GRAPEJUICE_VISCOSITY));
        KELP_CIDER_PROPS = FLUID_PROPERTIES.register("kelp_cider", new DoAddonFluidProperties.BetterBuilder().setWhiskyBeerGrapeJuice().tintColor(new Color(0x2DB864)).get().viscosity(GRAPEJUICE_VISCOSITY));
        AEGIS_WINE_PROPS = FLUID_PROPERTIES.register("aegis_wine", new DoAddonFluidProperties.BetterBuilder().setWhiskyBeerGrapeJuice().tintColor(new Color(0xA23B22)).get().viscosity(GRAPEJUICE_VISCOSITY));
        CLARK_WINE_PROPS = FLUID_PROPERTIES.register("clark_wine", new DoAddonFluidProperties.BetterBuilder().setWhiskyBeerGrapeJuice().tintColor(new Color(0x353535)).get().viscosity(GRAPEJUICE_VISCOSITY));
        MELLOHI_WINE_PROPS = FLUID_PROPERTIES.register("mellohi_wine", new DoAddonFluidProperties.BetterBuilder().setWhiskyBeerGrapeJuice().tintColor(new Color(0x8F9F6C)).get().viscosity(GRAPEJUICE_VISCOSITY));
        STRAD_WINE_PROPS = FLUID_PROPERTIES.register("strad_wine", new DoAddonFluidProperties.BetterBuilder().setWhiskyBeerGrapeJuice().tintColor(new Color(0x0B1920)).get().viscosity(GRAPEJUICE_VISCOSITY));
        APPLE_CIDER_PROPS = FLUID_PROPERTIES.register("apple_cider", new DoAddonFluidProperties.BetterBuilder().setWhiskyBeerGrapeJuice().tintColor(new Color(0x782E1E)).get().viscosity(GRAPEJUICE_VISCOSITY));
        APPLE_WINE_PROPS = FLUID_PROPERTIES.register("apple_wine", new DoAddonFluidProperties.BetterBuilder().setWhiskyBeerGrapeJuice().tintColor(new Color(0xB48245)).get().viscosity(GRAPEJUICE_VISCOSITY));
        KNULP_WINE_PROPS = FLUID_PROPERTIES.register("knulp_wine", new DoAddonFluidProperties.BetterBuilder().setWhiskyBeerGrapeJuice().tintColor(new Color(0x253D74)).get().viscosity(GRAPEJUICE_VISCOSITY));
        LILITU_WINE_PROPS = FLUID_PROPERTIES.register("lilitu_wine", new DoAddonFluidProperties.BetterBuilder().setWhiskyBeerGrapeJuice().tintColor(new Color(0xE15D5D)).get().viscosity(GRAPEJUICE_VISCOSITY));
        BOTTLE_MOJANG_NOIR_PROPS = FLUID_PROPERTIES.register("bottle_mojang_noir", new DoAddonFluidProperties.BetterBuilder().setWhiskyBeerGrapeJuice().tintColor(new Color(0x1B1118)).get().viscosity(GRAPEJUICE_VISCOSITY));
        VILLAGERS_FRIGHT_PROPS = FLUID_PROPERTIES.register("villagers_fright", new DoAddonFluidProperties.BetterBuilder().setWhiskyBeerGrapeJuice().tintColor(new Color(0x322A3C)).get().viscosity(GRAPEJUICE_VISCOSITY));
        COUNT_ROLEESTER_SHIRAZ_PROPS = FLUID_PROPERTIES.register("count_roleester_shiraz", new DoAddonFluidProperties.BetterBuilder().setWhiskyBeerGrapeJuice().tintColor(new Color(0x3A0D25)).get().viscosity(GRAPEJUICE_VISCOSITY));
        LAMROC_WINE_PROPS = FLUID_PROPERTIES.register("lamroc_wine", new DoAddonFluidProperties.BetterBuilder().setWhiskyBeerGrapeJuice().tintColor(new Color(0x0E0000)).get().viscosity(GRAPEJUICE_VISCOSITY));
    }

    static DoAddonFluids.StateIndependantFluid RED_GRAPEJUICE;
    static DoAddonFluids.StateIndependantFluid WHITE_GRAPEJUICE;
    static DoAddonFluids.StateIndependantFluid JUNGLE_RED_GRAPEJUICE;
    static DoAddonFluids.StateIndependantFluid JUNGLE_WHITE_GRAPEJUICE;
    static DoAddonFluids.StateIndependantFluid SAVANNA_RED_GRAPEJUICE;
    static DoAddonFluids.StateIndependantFluid SAVANNA_WHITE_GRAPEJUICE;
    static DoAddonFluids.StateIndependantFluid TAIGA_RED_GRAPEJUICE;
    static DoAddonFluids.StateIndependantFluid TAIGA_WHITE_GRAPEJUICE;

    static DoAddonFluids.StateIndependantFluid CHERRY_WINE;
    static DoAddonFluids.StateIndependantFluid CHORUS_WINE;
    static DoAddonFluids.StateIndependantFluid MAGNETIC_WINE;
    static DoAddonFluids.StateIndependantFluid JO_SPECIAL_MIXTURE;
    static DoAddonFluids.StateIndependantFluid CRISTEL_WINE;
    static DoAddonFluids.StateIndependantFluid GLOWING_WINE;
    static DoAddonFluids.StateIndependantFluid CREEPERS_CRUSH;
    static DoAddonFluids.StateIndependantFluid MEAD;
    static DoAddonFluids.StateIndependantFluid RED_WINE;
    static DoAddonFluids.StateIndependantFluid JELLIE_WINE;
    static DoAddonFluids.StateIndependantFluid STAL_WINE;
    static DoAddonFluids.StateIndependantFluid NOIR_WINE;
    static DoAddonFluids.StateIndependantFluid BOLVAR_WINE;
    static DoAddonFluids.StateIndependantFluid SOLARIS_WINE;
    static DoAddonFluids.StateIndependantFluid EISWEIN;
    static DoAddonFluids.StateIndependantFluid CHENET_WINE;
    static DoAddonFluids.StateIndependantFluid KELP_CIDER;
    static DoAddonFluids.StateIndependantFluid AEGIS_WINE;
    static DoAddonFluids.StateIndependantFluid CLARK_WINE;
    static DoAddonFluids.StateIndependantFluid MELLOHI_WINE;
    static DoAddonFluids.StateIndependantFluid STRAD_WINE;
    static DoAddonFluids.StateIndependantFluid APPLE_CIDER;
    static DoAddonFluids.StateIndependantFluid APPLE_WINE;
    static DoAddonFluids.StateIndependantFluid KNULP_WINE;
    static DoAddonFluids.StateIndependantFluid LILITU_WINE;
    static DoAddonFluids.StateIndependantFluid BOTTLE_MOJANG_NOIR;
    static DoAddonFluids.StateIndependantFluid VILLAGERS_FRIGHT;
    static DoAddonFluids.StateIndependantFluid COUNT_ROLEESTER_SHIRAZ;
    static DoAddonFluids.StateIndependantFluid LAMROC_WINE;

    public void registerFluids() {
        RED_GRAPEJUICE = DoAddonFluids.registerDualStatesByName("red_grapejuice", RED_GRAPEJUICE_PROPS);
        WHITE_GRAPEJUICE = DoAddonFluids.registerDualStatesByName("white_grapejuice", WHITE_GRAPEJUICE_PROPS);
        JUNGLE_RED_GRAPEJUICE = DoAddonFluids.registerDualStatesByName("jungle_red_grapejuice", JUNGLE_RED_GRAPEJUICE_PROPS);
        JUNGLE_WHITE_GRAPEJUICE = DoAddonFluids.registerDualStatesByName("jungle_white_grapejuice", JUNGLE_WHITE_GRAPEJUICE_PROPS);
        SAVANNA_RED_GRAPEJUICE = DoAddonFluids.registerDualStatesByName("savanna_red_grapejuice", SAVANNA_RED_GRAPEJUICE_PROPS);
        SAVANNA_WHITE_GRAPEJUICE = DoAddonFluids.registerDualStatesByName("savanna_white_grapejuice", SAVANNA_WHITE_GRAPEJUICE_PROPS);
        TAIGA_RED_GRAPEJUICE = DoAddonFluids.registerDualStatesByName("taiga_red_grapejuice", TAIGA_RED_GRAPEJUICE_PROPS);
        TAIGA_WHITE_GRAPEJUICE = DoAddonFluids.registerDualStatesByName("taiga_white_grapejuice", TAIGA_WHITE_GRAPEJUICE_PROPS);

        CHERRY_WINE = DoAddonFluids.registerDualStatesByName("cherry_wine", CHERRY_WINE_PROPS);
        CHORUS_WINE = DoAddonFluids.registerDualStatesByName("chorus_wine", CHORUS_WINE_PROPS);
        MAGNETIC_WINE = DoAddonFluids.registerDualStatesByName("magnetic_wine", MAGNETIC_WINE_PROPS);
        JO_SPECIAL_MIXTURE = DoAddonFluids.registerDualStatesByName("jo_special_mixture", JO_SPECIAL_MIXTURE_PROPS);
        CRISTEL_WINE = DoAddonFluids.registerDualStatesByName("cristel_wine", CRISTEL_WINE_PROPS);
        GLOWING_WINE = DoAddonFluids.registerDualStatesByName("glowing_wine", GLOWING_WINE_PROPS);
        CREEPERS_CRUSH = DoAddonFluids.registerDualStatesByName("creepers_crush", CREEPERS_CRUSH_PROPS);
        MEAD = DoAddonFluids.registerDualStatesByName("mead", MEAD_PROPS);
        RED_WINE = DoAddonFluids.registerDualStatesByName("red_wine", RED_WINE_PROPS);
        JELLIE_WINE = DoAddonFluids.registerDualStatesByName("jellie_wine", JELLIE_WINE_PROPS);
        STAL_WINE = DoAddonFluids.registerDualStatesByName("stal_wine", STAL_WINE_PROPS);
        NOIR_WINE = DoAddonFluids.registerDualStatesByName("noir_wine", NOIR_WINE_PROPS);
        BOLVAR_WINE = DoAddonFluids.registerDualStatesByName("bolvar_wine", BOLVAR_WINE_PROPS);
        SOLARIS_WINE = DoAddonFluids.registerDualStatesByName("solaris_wine", SOLARIS_WINE_PROPS);
        EISWEIN = DoAddonFluids.registerDualStatesByName("eiswein", EISWEIN_PROPS);
        CHENET_WINE = DoAddonFluids.registerDualStatesByName("chenet_wine", CHENET_WINE_PROPS);
        KELP_CIDER = DoAddonFluids.registerDualStatesByName("kelp_cider", KELP_CIDER_PROPS);
        AEGIS_WINE = DoAddonFluids.registerDualStatesByName("aegis_wine", AEGIS_WINE_PROPS);
        CLARK_WINE = DoAddonFluids.registerDualStatesByName("clark_wine", CLARK_WINE_PROPS);
        MELLOHI_WINE = DoAddonFluids.registerDualStatesByName("mellohi_wine", MELLOHI_WINE_PROPS);
        STRAD_WINE = DoAddonFluids.registerDualStatesByName("strad_wine", STRAD_WINE_PROPS);
        APPLE_CIDER = DoAddonFluids.registerDualStatesByName("apple_cider", APPLE_CIDER_PROPS);
        APPLE_WINE = DoAddonFluids.registerDualStatesByName("apple_wine", APPLE_WINE_PROPS);
        KNULP_WINE = DoAddonFluids.registerDualStatesByName("knulp_wine", KNULP_WINE_PROPS);
        LILITU_WINE = DoAddonFluids.registerDualStatesByName("lilitu_wine", LILITU_WINE_PROPS);
        BOTTLE_MOJANG_NOIR = DoAddonFluids.registerDualStatesByName("bottle_mojang_noir", BOTTLE_MOJANG_NOIR_PROPS);
        VILLAGERS_FRIGHT = DoAddonFluids.registerDualStatesByName("villagers_fright", VILLAGERS_FRIGHT_PROPS);
        COUNT_ROLEESTER_SHIRAZ = DoAddonFluids.registerDualStatesByName("count_roleester_shiraz", COUNT_ROLEESTER_SHIRAZ_PROPS);
        LAMROC_WINE = DoAddonFluids.registerDualStatesByName("lamroc_wine", LAMROC_WINE_PROPS);

        ExtraFluidDataRegistry.registerFluidDA(
                FluidDataAttachment.create(ObjectRegistry.WINE_BOTTLE.get())
                        .supports(CHERRY_WINE, getRegistrarItemSupplier("cherry_wine"))
                        .supports(CHORUS_WINE, getRegistrarItemSupplier("chorus_wine"))
                        .supports(MAGNETIC_WINE, getRegistrarItemSupplier("magnetic_wine"))
                        .supports(JO_SPECIAL_MIXTURE, getRegistrarItemSupplier("jo_special_mixture"))
                        .supports(CRISTEL_WINE, getRegistrarItemSupplier("cristel_wine"))
                        .supports(GLOWING_WINE, getRegistrarItemSupplier("glowing_wine"))
                        .supports(CREEPERS_CRUSH, ObjectRegistry.CREEPERS_CRUSH_ITEM.get())
                        .supports(MEAD, ObjectRegistry.MEAD_ITEM.get())
                        .supports(RED_WINE, getRegistrarItemSupplier("red_wine"))
                        .supports(JELLIE_WINE, getRegistrarItemSupplier("jellie_wine"))
                        .supports(STAL_WINE, getRegistrarItemSupplier("stal_wine"))
                        .supports(NOIR_WINE, ObjectRegistry.NOIR_WINE_ITEM.get())
                        .supports(BOLVAR_WINE, getRegistrarItemSupplier("bolvar_wine"))
                        .supports(SOLARIS_WINE, getRegistrarItemSupplier("solaris_wine"))
                        .supports(EISWEIN, getRegistrarItemSupplier("eiswein"))
                        .supports(CHENET_WINE, getRegistrarItemSupplier("chenet_wine"))
                        .supports(KELP_CIDER, getRegistrarItemSupplier("kelp_cider"))
                        .supports(AEGIS_WINE, getRegistrarItemSupplier("aegis_wine"))
                        .supports(CLARK_WINE, getRegistrarItemSupplier("clark_wine"))
                        .supports(MELLOHI_WINE, getRegistrarItemSupplier("mellohi_wine"))
                        .supports(STRAD_WINE, getRegistrarItemSupplier("mellohi_wine"))
                        .supports(APPLE_CIDER, getRegistrarItemSupplier("apple_cider"))
                        .supports(APPLE_WINE, getRegistrarItemSupplier("apple_wine"))
                        .supports(KNULP_WINE, getRegistrarItemSupplier("knulp_wine"))
                        .supports(LILITU_WINE, getRegistrarItemSupplier("lilitu_wine"))
                        .supports(BOTTLE_MOJANG_NOIR, getRegistrarItemSupplier("bottle_mojang_noir"))
                        .supports(VILLAGERS_FRIGHT, getRegistrarItemSupplier("villagers_fright"))
                        .supports(COUNT_ROLEESTER_SHIRAZ, getRegistrarItemSupplier("count_roleester_shiraz"))
                        .supports(LAMROC_WINE, getRegistrarItemSupplier("lamroc_wine"))
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

    static RegistryEntry<Block> CHERRY_WINE_BLOCK;
    static RegistryEntry<Block> CHORUS_WINE_BLOCK;
    static RegistryEntry<Block> MAGNETIC_WINE_BLOCK;
    static RegistryEntry<Block> JO_SPECIAL_MIXTURE_BLOCK;
    static RegistryEntry<Block> CRISTEL_WINE_BLOCK;
    static RegistryEntry<Block> GLOWING_WINE_BLOCK;
    static RegistryEntry<Block> CREEPERS_CRUSH_BLOCK;
    static RegistryEntry<Block> MEAD_BLOCK;
    static RegistryEntry<Block> RED_WINE_BLOCK;
    static RegistryEntry<Block> JELLIE_WINE_BLOCK;
    static RegistryEntry<Block> STAL_WINE_BLOCK;
    static RegistryEntry<Block> NOIR_WINE_BLOCK;
    static RegistryEntry<Block> BOLVAR_WINE_BLOCK;
    static RegistryEntry<Block> SOLARIS_WINE_BLOCK;
    static RegistryEntry<Block> EISWEIN_BLOCK;
    static RegistryEntry<Block> CHENET_WINE_BLOCK;
    static RegistryEntry<Block> KELP_CIDER_BLOCK;
    static RegistryEntry<Block> AEGIS_WINE_BLOCK;
    static RegistryEntry<Block> CLARK_WINE_BLOCK;
    static RegistryEntry<Block> MELLOHI_WINE_BLOCK;
    static RegistryEntry<Block> STRAD_WINE_BLOCK;
    static RegistryEntry<Block> APPLE_CIDER_BLOCK;
    static RegistryEntry<Block> APPLE_WINE_BLOCK;
    static RegistryEntry<Block> KNULP_WINE_BLOCK;
    static RegistryEntry<Block> LILITU_WINE_BLOCK;
    static RegistryEntry<Block> BOTTLE_MOJANG_NOIR_BLOCK;
    static RegistryEntry<Block> VILLAGERS_FRIGHT_BLOCK;
    static RegistryEntry<Block> COUNT_ROLEESTER_SHIRAZ_BLOCK;
    static RegistryEntry<Block> LAMROC_WINE_BLOCK;

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

        CHERRY_WINE_BLOCK = BLOCKS.register("cherry_wine", () -> new BotariumLiquidBlock(CHERRY_WINE_PROPS, BlockBehaviour.Properties.copy(Blocks.WATER).mapColor(MapColor.COLOR_RED)));
        CHORUS_WINE_BLOCK = BLOCKS.register("chorus_wine", () -> new BotariumLiquidBlock(CHORUS_WINE_PROPS, BlockBehaviour.Properties.copy(Blocks.WATER).mapColor(MapColor.TERRACOTTA_PURPLE)));
        MAGNETIC_WINE_BLOCK = BLOCKS.register("magnetic_wine", () -> new BotariumLiquidBlock(CHERRY_WINE_PROPS, BlockBehaviour.Properties.copy(Blocks.WATER).mapColor(MapColor.COLOR_GRAY)));
        JO_SPECIAL_MIXTURE_BLOCK = BLOCKS.register("jo_special_mixture", () -> new BotariumLiquidBlock(CHERRY_WINE_PROPS, BlockBehaviour.Properties.copy(Blocks.WATER).mapColor(MapColor.COLOR_RED)));
        CRISTEL_WINE_BLOCK = BLOCKS.register("cristel_wine", () -> new BotariumLiquidBlock(CHERRY_WINE_PROPS, BlockBehaviour.Properties.copy(Blocks.WATER).mapColor(MapColor.COLOR_RED)));
        GLOWING_WINE_BLOCK = BLOCKS.register("glowing_wine", () -> new GlitteringFluidBlock(CHERRY_WINE_PROPS, BlockBehaviour.Properties.copy(Blocks.WATER).mapColor(MapColor.COLOR_RED)));
        CREEPERS_CRUSH_BLOCK = BLOCKS.register("creepers_crush", () -> new GlitteringFluidBlock(CHERRY_WINE_PROPS, BlockBehaviour.Properties.copy(Blocks.WATER).mapColor(MapColor.COLOR_LIGHT_GREEN)));
        MEAD_BLOCK = BLOCKS.register("mead", () -> new BotariumLiquidBlock(CHERRY_WINE_PROPS, BlockBehaviour.Properties.copy(Blocks.WATER).mapColor(MapColor.COLOR_RED)));
        RED_WINE_BLOCK = BLOCKS.register("red_wine", () -> new BotariumLiquidBlock(CHERRY_WINE_PROPS, BlockBehaviour.Properties.copy(Blocks.WATER).mapColor(MapColor.COLOR_RED)));
        JELLIE_WINE_BLOCK = BLOCKS.register("jellie_wine", () -> new BotariumLiquidBlock(CHERRY_WINE_PROPS, BlockBehaviour.Properties.copy(Blocks.WATER).mapColor(MapColor.COLOR_RED)));
        STAL_WINE_BLOCK = BLOCKS.register("stal_wine", () -> new BotariumLiquidBlock(CHERRY_WINE_PROPS, BlockBehaviour.Properties.copy(Blocks.WATER).mapColor(MapColor.COLOR_RED)));
        NOIR_WINE_BLOCK = BLOCKS.register("noir_wine", () -> new BotariumLiquidBlock(NOIR_WINE_PROPS, BlockBehaviour.Properties.copy(Blocks.WATER).mapColor(MapColor.COLOR_RED)));
        BOLVAR_WINE_BLOCK = BLOCKS.register("bolvar_wine", () -> new BotariumLiquidBlock(CHERRY_WINE_PROPS, BlockBehaviour.Properties.copy(Blocks.WATER).mapColor(MapColor.COLOR_RED)));
        SOLARIS_WINE_BLOCK = BLOCKS.register("solaris_wine", () -> new BotariumLiquidBlock(CHERRY_WINE_PROPS, BlockBehaviour.Properties.copy(Blocks.WATER).mapColor(MapColor.COLOR_YELLOW)));
        EISWEIN_BLOCK = BLOCKS.register("eiswein", () -> new GlitteringFluidBlock(EISWEIN_PROPS, BlockBehaviour.Properties.copy(Blocks.WATER).mapColor(MapColor.COLOR_LIGHT_BLUE)));
        CHENET_WINE_BLOCK = BLOCKS.register("chenet_wine", () -> new BotariumLiquidBlock(EISWEIN_PROPS, BlockBehaviour.Properties.copy(Blocks.WATER).mapColor(MapColor.COLOR_LIGHT_BLUE)));
        KELP_CIDER_BLOCK = BLOCKS.register("kelp_cider", () -> new BotariumLiquidBlock(EISWEIN_PROPS, BlockBehaviour.Properties.copy(Blocks.WATER).mapColor(MapColor.COLOR_LIGHT_BLUE)));
        AEGIS_WINE_BLOCK = BLOCKS.register("aegis_wine", () -> new BotariumLiquidBlock(EISWEIN_PROPS, BlockBehaviour.Properties.copy(Blocks.WATER).mapColor(MapColor.COLOR_LIGHT_BLUE)));
        CLARK_WINE_BLOCK = BLOCKS.register("clark_wine", () -> new BotariumLiquidBlock(EISWEIN_PROPS, BlockBehaviour.Properties.copy(Blocks.WATER).mapColor(MapColor.COLOR_LIGHT_BLUE)));
        MELLOHI_WINE_BLOCK = BLOCKS.register("mellohi_wine", () -> new BotariumLiquidBlock(EISWEIN_PROPS, BlockBehaviour.Properties.copy(Blocks.WATER).mapColor(MapColor.COLOR_LIGHT_BLUE)));
        STRAD_WINE_BLOCK = BLOCKS.register("strad_wine", () -> new BotariumLiquidBlock(EISWEIN_PROPS, BlockBehaviour.Properties.copy(Blocks.WATER).mapColor(MapColor.COLOR_LIGHT_BLUE)));
        APPLE_CIDER_BLOCK = BLOCKS.register("apple_cider", () -> new BotariumLiquidBlock(EISWEIN_PROPS, BlockBehaviour.Properties.copy(Blocks.WATER).mapColor(MapColor.COLOR_YELLOW)));
        APPLE_WINE_BLOCK = BLOCKS.register("apple_wine", () -> new BotariumLiquidBlock(EISWEIN_PROPS, BlockBehaviour.Properties.copy(Blocks.WATER).mapColor(MapColor.COLOR_YELLOW)));
        KNULP_WINE_BLOCK = BLOCKS.register("knulp_wine", () -> new BotariumLiquidBlock(EISWEIN_PROPS, BlockBehaviour.Properties.copy(Blocks.WATER).mapColor(MapColor.COLOR_LIGHT_BLUE)));
        LILITU_WINE_BLOCK = BLOCKS.register("lilitu_wine", () -> new BotariumLiquidBlock(EISWEIN_PROPS, BlockBehaviour.Properties.copy(Blocks.WATER).mapColor(MapColor.COLOR_LIGHT_BLUE)));
        BOTTLE_MOJANG_NOIR_BLOCK = BLOCKS.register("bottle_mojang_noir", () -> new BotariumLiquidBlock(EISWEIN_PROPS, BlockBehaviour.Properties.copy(Blocks.WATER).mapColor(MapColor.COLOR_LIGHT_BLUE)));
        VILLAGERS_FRIGHT_BLOCK = BLOCKS.register("villagers_fright", () -> new BotariumLiquidBlock(EISWEIN_PROPS, BlockBehaviour.Properties.copy(Blocks.WATER).mapColor(MapColor.COLOR_LIGHT_BLUE)));
        COUNT_ROLEESTER_SHIRAZ_BLOCK = BLOCKS.register("count_roleester_shiraz", () -> new BotariumLiquidBlock(EISWEIN_PROPS, BlockBehaviour.Properties.copy(Blocks.WATER).mapColor(MapColor.COLOR_LIGHT_BLUE)));
        LAMROC_WINE_BLOCK = BLOCKS.register("lamroc_wine", () -> new BotariumLiquidBlock(EISWEIN_PROPS, BlockBehaviour.Properties.copy(Blocks.WATER).mapColor(MapColor.COLOR_LIGHT_BLUE)));
    }

    // Tags
    public static TagKey<Item> GRAPEJUICE = TagKey.create(Registries.ITEM, new ResourceLocation(new Vinery().supportedMod(), "grapejuice"));
}
