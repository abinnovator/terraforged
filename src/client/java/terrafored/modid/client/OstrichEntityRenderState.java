package terrafored.modid.client;

import net.minecraft.client.renderer.entity.state.LivingEntityRenderState;

public class OstrichEntityRenderState extends LivingEntityRenderState {
    public boolean isHiding;

    public OstrichEntityRenderState() {
        super();
        this.isHiding = false;
    }
}
