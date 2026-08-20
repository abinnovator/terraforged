package terrafored.modid;

import net.fabricmc.fabric.api.creativetab.v1.CreativeModeTabEvents;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.level.block.*;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.references.BlockItemId;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.LeavesBlock;
import java.util.function.Function;

public class ModBlocks {
    private static Block register(BlockItemId id, Function<BlockBehaviour.Properties, Block> blockFactory, BlockBehaviour.Properties properties) {
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
        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.NATURAL_BLOCKS).register((creativeTab) -> {
            creativeTab.accept(ModBlocks.BAOBAB_BUTTON.asItem());
        });
        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.NATURAL_BLOCKS).register((creativeTab)->{creativeTab.accept(
                ModBlocks.BAOBAB_TRAPDOOR.asItem()
        );});
        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.NATURAL_BLOCKS).register((creativeTab)->{creativeTab.accept(
                ModBlocks.BAOBAB_LEAVES.asItem()
        );});
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
            props -> new DoorBlock(ModWoodTypes.BAOBAB_SET_TYPE, props),
            BlockBehaviour.Properties.of()
                    .sound(SoundType.WOOD)
                    .strength(3.0f)
                    .noOcclusion()
    );
    public static final Block BAOBAB_BUTTON = register(
            ModBlockItemIds.BAOBAB_BUTTON,
            props -> new ButtonBlock(ModWoodTypes.BAOBAB_SET_TYPE,2, props),
            BlockBehaviour.Properties.of().sound(SoundType.WOOD).strength(1f).noOcclusion()
    );
    public static final Block BAOBAB_TRAPDOOR = register(
            ModBlockItemIds.BAOBAB_TRAPDOOR,
            props -> new TrapDoorBlock(ModWoodTypes.BAOBAB_SET_TYPE, props),
            BlockBehaviour.Properties.of().sound(SoundType.WOOD).strength(1f).noOcclusion()
    );
    public static final Block BAOBAB_LEAVES = register(
            ModBlockItemIds.BAOBAB_LEAVES,
            props -> new UntintedParticleLeavesBlock(0.01F, ParticleTypes.FALLING_SPORE_BLOSSOM, props),
            BlockBehaviour.Properties.of()
                    .strength(0.2f)
                    .sound(SoundType.GRASS)
                    .ignitedByLava()
                    .noOcclusion()
                    .requiresCorrectToolForDrops()
                    .isValidSpawn((state, level, pos, type) -> false)
                    .isSuffocating((state, level, pos) -> false)
                    .isViewBlocking((state, level, pos) -> false)
    );
}
