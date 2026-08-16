package terrafored.modid;

import net.fabricmc.fabric.api.creativetab.v1.CreativeModeTabEvents;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.level.block.Block;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.references.BlockItemId;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.DoorBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.BlockSetType;

import java.util.function.Function;

public class ModBlocks {
    private static Block register(BlockItemId id, Function<BlockBehaviour.Properties, Block> blockFactory, BlockBehaviour.Properties properties) {
        // Set the block's ID on the properties before constructing
        Block block = Registry.register(
                BuiltInRegistries.BLOCK,
                id.block(),
                blockFactory.apply(properties.setId(id.block()))
        );

        BlockItem blockItem = new BlockItem(block, new Item.Properties().useBlockDescriptionPrefix().setId(id.item()));
        Registry.register(BuiltInRegistries.ITEM, id.item(), blockItem);

        return block;
    }
    public static void initialize () {
        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.NATURAL_BLOCKS).register((creativeTab) -> {
            creativeTab.accept(ModBlocks.BAOBAB_LOG.asItem());
        });
        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.NATURAL_BLOCKS).register((creativeTab) -> {
            creativeTab.accept(ModBlocks.BAOBAB_PLANK.asItem());
        });
        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.NATURAL_BLOCKS).register((creativeTab) -> {
            creativeTab.accept(ModBlocks.BAOBAB_DOOR.asItem());
        });
    }
    public static final Block BAOBAB_LOG = register(
            ModBlockItemIds.BAOBAB_LOG,
            Block::new,
            BlockBehaviour.Properties.of().sound(SoundType.BAMBOO).strength(2.0f,3.0f)
    );
    public static final Block BAOBAB_PLANK = register(
            ModBlockItemIds.BAOBAB_PLANK,
            Block::new,
            BlockBehaviour.Properties.of().sound(SoundType.BAMBOO_WOOD).strength(2.0f,3.0f)
    );
    public static final Block BAOBAB_DOOR = register(
            ModBlockItemIds.BAOBAB_DOOR,
            props -> new DoorBlock(BlockSetType.OAK, props),
            BlockBehaviour.Properties.of()
                    .sound(SoundType.WOOD)
                    .strength(3.0f)
                    .noOcclusion()
    );
}
