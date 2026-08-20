package terrafored.modid.client.datagen;

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.Registries;
import terrafored.modid.TerraforgedWorldConfiguredFeatures;
import terrafored.modid.TerraforgedWorldPlacementFeatures;
import terrafored.modid.WorldGenProvider;

public class TerraforgedDataGenerator implements DataGeneratorEntrypoint {
    @Override
    public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
        FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();
        pack.addProvider(WorldGenProvider::new);
    }
    @Override
    public void buildRegistry(RegistrySetBuilder registryBuilder) {
        registryBuilder.add(Registries.CONFIGURED_FEATURE, TerraforgedWorldConfiguredFeatures::configure);
        registryBuilder.add(Registries.PLACED_FEATURE, TerraforgedWorldPlacementFeatures::configure);
    }
}
