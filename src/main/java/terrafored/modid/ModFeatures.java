package terrafored.modid;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;


public class ModFeatures {
    public static final Feature<NoneFeatureConfiguration> BAOBAB_TREE = Registry.register(
            BuiltInRegistries.FEATURE,
            Identifier.fromNamespaceAndPath(Terraforged.MOD_ID, "baobab_tree"),
            new BaobabTreeFeature(NoneFeatureConfiguration.CODEC)
    );
    public static void initialize() {

    };
}
