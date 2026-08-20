package terrafored.modid.client;

import net.fabricmc.fabric.api.client.rendering.v1.ModelLayerRegistry;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.resources.Identifier;
import terrafored.modid.Terraforged;

public class TerraforgedEntityModelLayers {
    public static final ModelLayerLocation OSTRICH = createMain("ostrich");
    private static ModelLayerLocation createMain(String name) {
        return new ModelLayerLocation(Identifier.fromNamespaceAndPath(Terraforged.MOD_ID, name), "main");
    }

    public static void registerModelLayers() {
        ModelLayerRegistry.registerModelLayer(TerraforgedEntityModelLayers.OSTRICH, OstrichEntityModel::createBodyLayer);
    }
}
