package terrafored.modid;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.*;
import net.minecraft.data.worldgen.placement.PlacementUtils;

import java.util.List;

public class TerraforgedWorldPlacementFeatures {
    public static final ResourceKey<PlacedFeature> BAOBAB_TREE_KEY =
            ResourceKey.create(
                    Registries.PLACED_FEATURE,
                    Identifier.fromNamespaceAndPath(Terraforged.MOD_ID, "baobab_tree")
            );
    public static void configure(BootstrapContext<PlacedFeature> context) {
        HolderGetter<ConfiguredFeature<?, ?>> configuredFeatures = context.lookup(Registries.CONFIGURED_FEATURE);

        context.register(
                BAOBAB_TREE_KEY,
                new PlacedFeature(
                        configuredFeatures.getOrThrow(TerraforgedWorldConfiguredFeatures.BAOBAB_TREE_CONFIGURED_KEY),
                        List.of(
                                RarityFilter.onAverageOnceEvery(5),
                                InSquarePlacement.spread(),
                                PlacementUtils.HEIGHTMAP_WORLD_SURFACE,
                                BiomeFilter.biome()
                        )
                )
        );
        // Spawns everywhere in the overworld

    }
}
