package terrafored.modid.client;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.state.LivingEntityRenderState;
import net.minecraft.resources.Identifier;
import terrafored.modid.OstrichEntity;
import terrafored.modid.Terraforged;

public class OstrichEntityRenderer extends MobRenderer<OstrichEntity,OstrichEntityRenderState, OstrichEntityModel> {
    private static final Identifier TEXTURE = Identifier.fromNamespaceAndPath(Terraforged.MOD_ID, "textures/entity/ostrich.png");

    public OstrichEntityRenderer(EntityRendererProvider.Context context) {
        super(context, new OstrichEntityModel(context.bakeLayer(TerraforgedEntityModelLayers.OSTRICH)), 0.375f); // 0.375 shadow radius
    }

    @Override
    public OstrichEntityRenderState createRenderState() {
        return new OstrichEntityRenderState();
    }

    @Override
    public Identifier getTextureLocation(OstrichEntityRenderState state) {
        return TEXTURE;
    }
    @Override
    public void extractRenderState(OstrichEntity entity, OstrichEntityRenderState state, float partialTick) {
        super.extractRenderState(entity, state, partialTick);
        state.isHiding = entity.isHiding();
    }
}
