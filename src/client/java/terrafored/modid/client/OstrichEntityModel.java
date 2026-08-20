package terrafored.modid.client;

import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.util.Mth;


public class OstrichEntityModel extends EntityModel<OstrichEntityRenderState> {
    private final ModelPart body;
    private final ModelPart head;
    private final ModelPart leftLeg;
    private final ModelPart rightLeg;
    private final ModelPart leftArm;
    private final ModelPart rightArm;

    public OstrichEntityModel(ModelPart root) {
        super(root);                       // new API: pass root to super
        this.body = root.getChild("Body");
        this.head = this.body.getChild("Head");
        this.leftLeg = this.body.getChild("Legs").getChild("LeftLeg");
        this.rightLeg = this.body.getChild("Legs").getChild("RightLeg");
        this.rightArm = this.body.getChild("Arms").getChild("RightArm");
        this.leftArm = this.body.getChild("Arms").getChild("LeftArm");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshDefinition = new MeshDefinition();
        PartDefinition partDefinition = meshDefinition.getRoot();

        PartDefinition body = partDefinition.addOrReplaceChild("Body",
                CubeListBuilder.create(),
                PartPose.offset(0.0F, 24.0F, 0.0F));

        PartDefinition legs = body.addOrReplaceChild("Legs",
                CubeListBuilder.create(),
                PartPose.offset(4.0F, 0.0F, -1.0F));

        legs.addOrReplaceChild("LeftLeg",
                CubeListBuilder.create()
                        .texOffs(74, 60).addBox(-1.0F, 15.0F, -2.0F, 3.0F, 1.0F, 6.0F, new CubeDeformation(0.0F))
                        .texOffs(64, 68).addBox(-1.0F, 0.0F, -2.0F, 2.0F, 15.0F, 3.0F, new CubeDeformation(0.0F)),
                PartPose.offset(-3.0F, -16.0F, 1.0F));

        legs.addOrReplaceChild("RightLeg",
                CubeListBuilder.create()
                        .texOffs(74, 53).addBox(-2.0F, 14.0F, -2.0F, 3.0F, 1.0F, 6.0F, new CubeDeformation(0.0F))
                        .texOffs(54, 68).addBox(-1.0F, -1.0F, -2.0F, 2.0F, 15.0F, 3.0F, new CubeDeformation(0.0F)),
                PartPose.offset(-6.0F, -15.0F, 1.0F));

        body.addOrReplaceChild("Torso",
                CubeListBuilder.create()
                        .texOffs(0, 0).addBox(-9.0F, -27.0F, -9.0F, 17.0F, 11.0F, 17.0F, new CubeDeformation(0.0F)),
                PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition arms = body.addOrReplaceChild("Arms",
                CubeListBuilder.create(),
                PartPose.offset(0.0F, 0.0F, 0.0F));

        arms.addOrReplaceChild("LeftArm",
                CubeListBuilder.create()
                        .texOffs(44, 28).addBox(-1.0F, -1.0F, -9.0F, 2.0F, 8.0F, 17.0F, new CubeDeformation(0.0F)),
                PartPose.offset(-10.0F, -22.0F, -4.0F));

        PartDefinition rightArm = arms.addOrReplaceChild("RightArm",
                CubeListBuilder.create(),
                PartPose.offset(10.0F, -22.0F, -5.0F));

        rightArm.addOrReplaceChild("RightArm_r1",
                CubeListBuilder.create()
                        .texOffs(0, 50).addBox(-1.0F, -8.0F, -9.0F, 2.0F, 8.0F, 17.0F, new CubeDeformation(0.0F)),
                PartPose.offsetAndRotation(-1.0F, 7.0F, 0.0F, 0.0F, 3.1416F, 0.0F));

        body.addOrReplaceChild("Tails",
                CubeListBuilder.create()
                        .texOffs(38, 53).addBox(-6.0F, -31.0F, -15.0F, 10.0F, 7.0F, 8.0F, new CubeDeformation(0.0F)),
                PartPose.offset(0.0F, 0.0F, 0.0F));

        body.addOrReplaceChild("Head",
                CubeListBuilder.create()
                        .texOffs(0, 28).addBox(-2.0F, -1.0F, -4.0F, 4.0F, 4.0F, 18.0F, new CubeDeformation(0.0F))
                        .texOffs(68, 0).addBox(-2.0F, -11.0F, 2.0F, 4.0F, 4.0F, 8.0F, new CubeDeformation(0.0F))
                        .texOffs(38, 68).addBox(-2.0F, -11.0F, 10.0F, 4.0F, 10.0F, 4.0F, new CubeDeformation(0.0F))
                        .texOffs(68, 12).addBox(-2.0F, -23.0F, 2.0F, 4.0F, 12.0F, 4.0F, new CubeDeformation(0.0F))
                        .texOffs(74, 67).addBox(-2.0F, -21.0F, 6.0F, 4.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)),
                PartPose.offset(0.0F, -24.0F, 7.0F));

        return LayerDefinition.create(meshDefinition, 128, 128);
    }

    @Override
    public void setupAnim(OstrichEntityRenderState state) {
        super.setupAnim(state);
        this.body.yRot = (float) Math.PI;

        if (state.isHiding) {
            this.head.xRot = -85.0F * Mth.DEG_TO_RAD;   // deeper tuck
            this.leftLeg.xRot = -1.2F;                  // fold legs to crouch
            this.rightLeg.xRot = -1.2F;
            this.leftArm.xRot = 0.0F;                   // wings flat
            this.rightArm.xRot = 0.0F;

        } else {
            this.head.xRot = state.xRot * Mth.DEG_TO_RAD;
            this.head.yRot = state.yRot * Mth.DEG_TO_RAD;

            float speed = state.walkAnimationSpeed;
            float pos = state.walkAnimationPos;
            this.leftLeg.xRot  = Mth.cos(pos * 0.6662F + Mth.PI) * -1.4F * speed;
            this.rightLeg.xRot = Mth.cos(pos * 0.6662F) * -1.4F * speed;
            this.leftArm.zRot  = Mth.cos(pos * 0.6662F) * 1.0F * speed;
            this.rightArm.zRot = Mth.cos(pos * 0.6662F + Mth.PI) * 1.0F * speed;
        }
    }
}