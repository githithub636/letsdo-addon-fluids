package dev.ninjdai.doaddoncreate.datagen.tags;

import com.simibubi.create.AllTags;
import dev.ninjdai.doaddoncreate.dependant.Bakery;
import dev.ninjdai.doaddoncreate.dependant.Brewery;
import dev.ninjdai.doaddoncreate.dependant.Vinery;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.core.HolderLookup;

import java.util.concurrent.CompletableFuture;

public class DoAddonTagGen extends FabricTagProvider.ItemTagProvider {

    public DoAddonTagGen(FabricDataOutput output, CompletableFuture<HolderLookup.Provider> completableFuture) {
        super(output, completableFuture);
    }

    @Override
    protected void addTags(HolderLookup.Provider holderProvider) {
        getOrCreateTagBuilder(AllTags.AllItemTags.UPRIGHT_ON_BELT.tag)
                // Vinery
                .addOptionalTag(Vinery.GRAPEJUICE)
                .addOptionalTag(net.satisfy.vinery.registry.TagRegistry.WINE)
                .addOptional(net.satisfy.vinery.registry.ObjectRegistry.WINE_BOTTLE.getId())
                // Bakery
                .addOptionalTag(Bakery.JAMS)
                .addOptional(net.satisfy.bakery.registry.ObjectRegistry.JAR.getId())
                // Meadow
                .addOptionalTag(net.satisfy.meadow.registry.TagRegistry.WOODEN_MILK_BUCKET)
                .addOptional(net.satisfy.meadow.registry.ObjectRegistry.WOODEN_BUCKET.getId())
                // Brewery
                .addOptionalTag(Brewery.BEERS)
                .addOptional(net.satisfy.brewery.registry.ObjectRegistry.BEER_MUG.getId());
    }
}
