package dev.ninjdai.doaddoncreate.dependant;

import dev.ninjdai.doaddoncreate.registry.DoAddonFluids;
import dev.ninjdai.doaddoncreate.support.ModSupport;
import dev.ninjdai.doaddoncreate.support.annotations.SupportsMod;
import dev.ninjdai.doaddoncreate.registry.DoAddonFluidProperties;
import dev.ninjdai.doaddoncreate.utils.DoAddonColors;
import dev.ninjdai.doaddoncreate.utils.fluid.ExtraFluidDataRegistry;
import dev.ninjdai.doaddoncreate.utils.fluid.FluidDataAttachment;
import earth.terrarium.botarium.common.registry.fluid.FluidData;
import net.minecraft.core.registries.Registries;
import net.minecraft.nbt.IntTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.satisfy.brewery.registry.ObjectRegistry;

import static dev.ninjdai.doaddoncreate.registry.DoAddonFluidProperties.FLUID_PROPERTIES;

@SupportsMod("brewery")
public class Brewery implements ModSupport {

    // Fluids
    static FluidData WHEAT_BEER_PROPS;
    static FluidData BARLEY_BEER_PROPS;
    static FluidData HOPS_BEER_PROPS;
    static FluidData OAT_BEER_PROPS;
    static FluidData NETTLE_BEER_PROPS;
    static FluidData HALEY_BEER_PROPS;

    static FluidData JOJANNIK_WHISKEY_PROPS;
    static FluidData LILITUSINGLEMALT_WHISKEY_PROPS;
    static FluidData CRISTELWALKER_WHISKEY_PROPS;
    static FluidData MAGGOALLAN_WHISKEY_PROPS;
    static FluidData CARRASCONLABEL_WHISKEY_PROPS;


    @Override
    public void registerFluidProperties() {
        final int BEER_VISCOSITY = 1750;
        final int WHISKEY_VISCOSITY = 2000;

        WHEAT_BEER_PROPS = FLUID_PROPERTIES.register("beer_wheat", new DoAddonFluidProperties.BetterBuilder().setWhiskyBeerGrapeJuice().get()
                .tintColor(DoAddonColors.WHEAT_BEER.value)
                .viscosity(BEER_VISCOSITY)
                .density(1500)
        );
        BARLEY_BEER_PROPS = FLUID_PROPERTIES.register("beer_barley", new DoAddonFluidProperties.BetterBuilder().setWhiskyBeerGrapeJuice().get()
                .tintColor(DoAddonColors.BARLEY_BEER.value)
                .viscosity(BEER_VISCOSITY)
                .density(1500)
        );
        HOPS_BEER_PROPS = FLUID_PROPERTIES.register("beer_hops", new DoAddonFluidProperties.BetterBuilder().setWhiskyBeerGrapeJuice().get()
                .tintColor(DoAddonColors.HOPS_BEER.value)
                .viscosity(BEER_VISCOSITY)
                .density(1500)
        );
        OAT_BEER_PROPS = FLUID_PROPERTIES.register("beer_oat", new DoAddonFluidProperties.BetterBuilder().setWhiskyBeerGrapeJuice().get()
                .tintColor(DoAddonColors.OAT_BEER.value)
                .viscosity(WHISKEY_VISCOSITY)
        );
        NETTLE_BEER_PROPS = FLUID_PROPERTIES.register("beer_nettle", new DoAddonFluidProperties.BetterBuilder().setWhiskyBeerGrapeJuice().get()
                .tintColor(DoAddonColors.NETTLE_BEER.value)
                .viscosity(WHISKEY_VISCOSITY)
        );
        HALEY_BEER_PROPS = FLUID_PROPERTIES.register("beer_haley", new DoAddonFluidProperties.BetterBuilder().setWhiskyBeerGrapeJuice().get()
                .tintColor(DoAddonColors.HALEY_BEER.value)
                .viscosity(BEER_VISCOSITY)
                .density(1500)
        );

        JOJANNIK_WHISKEY_PROPS = FLUID_PROPERTIES.register("whiskey_jojannik", new DoAddonFluidProperties.BetterBuilder().setWhiskyBeerGrapeJuice().get()
                .tintColor(DoAddonColors.JOJANNIK_WHISKEY.value)
                .viscosity(WHISKEY_VISCOSITY)
                .density(1500)
        );
        LILITUSINGLEMALT_WHISKEY_PROPS = FLUID_PROPERTIES.register("whiskey_lilitusinglemalt", new DoAddonFluidProperties.BetterBuilder().setWhiskyBeerGrapeJuice().get()
                .tintColor(DoAddonColors.LILITUSINGLEMALT_WHISKEY.value)
                .viscosity(WHISKEY_VISCOSITY)
                .density(1500)
        );
        CRISTELWALKER_WHISKEY_PROPS = FLUID_PROPERTIES.register("whiskey_cristelwalker", new DoAddonFluidProperties.BetterBuilder().setWhiskyBeerGrapeJuice().get()
                .tintColor(DoAddonColors.CRISTELWALKER_WHISKEY.value)
                .viscosity(WHISKEY_VISCOSITY)
                .density(1500)
        );
        MAGGOALLAN_WHISKEY_PROPS = FLUID_PROPERTIES.register("whiskey_maggoallan", new DoAddonFluidProperties.BetterBuilder().setWhiskyBeerGrapeJuice().get()
                .tintColor(DoAddonColors.MAGGOALLAN_WHISKEY.value)
                .viscosity(WHISKEY_VISCOSITY)
        );
        CARRASCONLABEL_WHISKEY_PROPS = FLUID_PROPERTIES.register("whiskey_carrasonlabel", new DoAddonFluidProperties.BetterBuilder().setWhiskyBeerGrapeJuice().get()
                .tintColor(DoAddonColors.CARRASCONLABEL_WHISKEY.value)
                .viscosity(WHISKEY_VISCOSITY)
        );
    }

    static DoAddonFluids.StateIndependantFluid WHEAT_BEER;
    static DoAddonFluids.StateIndependantFluid BARLEY_BEER;
    static DoAddonFluids.StateIndependantFluid OAT_BEER;
    static DoAddonFluids.StateIndependantFluid NETTLE_BEER;
    static DoAddonFluids.StateIndependantFluid HOPS_BEER;
    static DoAddonFluids.StateIndependantFluid HALEY_BEER;

    static DoAddonFluids.StateIndependantFluid JOJANNIK_WHISKEY;
    static DoAddonFluids.StateIndependantFluid LILITUSINGLEMALT_WHISKEY;
    static DoAddonFluids.StateIndependantFluid CRISTELWALKER_WHISKEY;
    static DoAddonFluids.StateIndependantFluid MAGGOALLAN_WHISKEY;
    static DoAddonFluids.StateIndependantFluid CARRASCONLABEL_WHISKEY;

    @Override
    public void registerFluids() {
        WHEAT_BEER = DoAddonFluids.registerDualStatesByName("beer_wheat", WHEAT_BEER_PROPS);
        BARLEY_BEER = DoAddonFluids.registerDualStatesByName("beer_barley", BARLEY_BEER_PROPS);
        OAT_BEER = DoAddonFluids.registerDualStatesByName("beer_oat", OAT_BEER_PROPS);
        NETTLE_BEER = DoAddonFluids.registerDualStatesByName("beer_nettle", NETTLE_BEER_PROPS);
        HOPS_BEER = DoAddonFluids.registerDualStatesByName("beer_hops", HOPS_BEER_PROPS);
        HALEY_BEER = DoAddonFluids.registerDualStatesByName("beer_haley", HALEY_BEER_PROPS);

        JOJANNIK_WHISKEY = DoAddonFluids.registerDualStatesByName("whiskey_jojannik", JOJANNIK_WHISKEY_PROPS);
        LILITUSINGLEMALT_WHISKEY = DoAddonFluids.registerDualStatesByName("whiskey_lilitusinglemalt", LILITUSINGLEMALT_WHISKEY_PROPS);
        CRISTELWALKER_WHISKEY = DoAddonFluids.registerDualStatesByName("whiskey_cristelwalker", CRISTELWALKER_WHISKEY_PROPS);
        MAGGOALLAN_WHISKEY = DoAddonFluids.registerDualStatesByName("whiskey_maggoallan", MAGGOALLAN_WHISKEY_PROPS);
        CARRASCONLABEL_WHISKEY = DoAddonFluids.registerDualStatesByName("whiskey_carrasonlabel", CARRASCONLABEL_WHISKEY_PROPS);

        ExtraFluidDataRegistry.registerFluidDA(
                FluidDataAttachment.create(ObjectRegistry.BEER_MUG.get().asItem())
                        .supports(WHEAT_BEER, ObjectRegistry.BEER_WHEAT)
                        .supports(BARLEY_BEER, ObjectRegistry.BEER_BARLEY)
                        .supports(OAT_BEER, ObjectRegistry.BEER_OAT)
                        .supports(NETTLE_BEER, ObjectRegistry.BEER_NETTLE)
                        .supports(HOPS_BEER, ObjectRegistry.BEER_HOPS)
                        .supports(HALEY_BEER, ObjectRegistry.BEER_HALEY)
                        .supports(JOJANNIK_WHISKEY, ObjectRegistry.WHISKEY_JOJANNIK)
                        .supports(LILITUSINGLEMALT_WHISKEY, ObjectRegistry.WHISKEY_LILITUSINGLEMALT)
                        .supports(CRISTELWALKER_WHISKEY, ObjectRegistry.WHISKEY_CRISTELWALKER)
                        .supports(MAGGOALLAN_WHISKEY, ObjectRegistry.WHISKEY_MAGGOALLAN)
                        .supports(CARRASCONLABEL_WHISKEY, ObjectRegistry.WHISKEY_CARRASCONLABEL)
                        .nbtMigrateFluidwards("brewery.beer_quality", "brewery:beer_quality", IntTag.valueOf(0))
                        .build()
        );
    }

    // Tags
    public static TagKey<Item> BEERS = TagKey.create(Registries.ITEM, new ResourceLocation(new Brewery().supportedMod(), "beer"));
}
