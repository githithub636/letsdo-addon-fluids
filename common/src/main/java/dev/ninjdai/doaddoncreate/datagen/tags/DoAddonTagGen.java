package dev.ninjdai.doaddoncreate.datagen.tags;

import com.simibubi.create.AllTags;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class DoAddonTagGen extends FabricTagProvider.ItemTagProvider {
    public DoAddonTagGen(FabricDataOutput output, CompletableFuture<HolderLookup.Provider> completableFuture, @Nullable FabricTagProvider.BlockTagProvider blockTagProvider) {
        super(output, completableFuture, blockTagProvider);
    }

    @Override
    protected void addTags(HolderLookup.Provider arg) {
        getOrCreateTagBuilder(AllTags.AllItemTags.UPRIGHT_ON_BELT.tag)
                // Vinery
                .addOptionalTag(satisfyu.vinery.registry.TagRegistry.WINE)
                .addOptional(satisfyu.vinery.registry.ObjectRegistry.WINE_BOTTLE.getId());
    }
}
