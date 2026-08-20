package terrafored.modid.client;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import terrafored.modid.TerraforgedEntityTypes;

public class TerraforgedClient implements ClientModInitializer {
	@Override
	public void onInitializeClient() {
		TerraforgedEntityModelLayers.registerModelLayers();

		EntityRendererRegistry.register(TerraforgedEntityTypes.OSTRICH, OstrichEntityRenderer::new);
	}
}