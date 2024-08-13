package dev.ninjdai.doaddoncreate.datagen.tags;

import com.simibubi.create.AllTags;
import dev.ninjdai.doaddoncreate.dependant.Bakery;
import dev.ninjdai.doaddoncreate.dependant.Vinery;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.core.HolderLookup;
import satisfyu.vinery.registry.ObjectRegistry;
import satisfyu.vinery.registry.TagRegistry;

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
                .addOptionalTag(TagRegistry.WINE)
                .addOptional(ObjectRegistry.WINE_BOTTLE.getId())
                // Bakery
                .addOptionalTag(Bakery.JAMS)
                .addOptional(net.satisfy.bakery.registry.ObjectRegistry.JAR.getId());
    }
}
