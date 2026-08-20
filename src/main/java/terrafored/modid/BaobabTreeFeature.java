package terrafored.modid;

import com.mojang.serialization.Codec;
import net.minecraft.resources.Identifier;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.core.Direction;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructurePlaceSettings;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureTemplate;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureTemplateManager;

import java.util.Optional;

public class BaobabTreeFeature extends Feature<NoneFeatureConfiguration> {
    public BaobabTreeFeature(Codec<NoneFeatureConfiguration> codec) {
        super(codec);
    }

    @Override
    public boolean place(FeaturePlaceContext<NoneFeatureConfiguration> context) {
        // Implement the logic to place the baobab tree in the world
        // This is where you would define how the tree is generated, including trunk and foliage placement
        // Get the world generation level from the context
        WorldGenLevel world = context.level();
        BlockPos origin = context.origin();
        BlockPos ground = origin.below();
        if (!world.getFluidState(origin).isEmpty()
                || !world.getBlockState(ground).isFaceSturdy(world, ground, Direction.UP)) {
            return false;
        }

        // Get All the NBT files by going to the structure manager and getting the structure template for the baobab tree
        StructureTemplateManager templateManager = world.getLevel().getServer().getStructureManager();

        // THis gets my nbt file from the templateManager
        Optional<StructureTemplate> baobabTreeTemplate = templateManager.get(
                Identifier.fromNamespaceAndPath(Terraforged.MOD_ID, "baobab_tree_1"));
        if (baobabTreeTemplate.isEmpty()) return false;
        Rotation rotation = Rotation.getRandom(context.random());

        // Tells the structure manager how to place the structure in the world
        StructurePlaceSettings settings = new StructurePlaceSettings().setRotation(rotation);
        //Place it in the world
        return baobabTreeTemplate.get().placeInWorld(world, origin, origin, settings, context.random(), Block.UPDATE_CLIENTS);
    }
}
