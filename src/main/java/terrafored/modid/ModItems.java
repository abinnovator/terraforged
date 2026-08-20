package terrafored.modid;

import net.fabricmc.fabric.api.creativetab.v1.CreativeModeTabEvents;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.SpawnEggItem;

import java.util.function.Function;

public class ModItems {
    public static Item register(ResourceKey<Item> itemKey, Function<Item.Properties, Item> itemFactory, Item.Properties settings) {
        // Create the item instance.
        Item item = itemFactory.apply(settings.setId(itemKey));

        // Register the item.
        Registry.register(BuiltInRegistries.ITEM, itemKey, item);

        return item;
    }

    public static final Item OSTRICH_SPAWN_EGG_ITEM = register(
            ModItemIds.OSTRICH_SPAWN_EGG,
            SpawnEggItem::new,
            new Item.Properties().spawnEgg(TerraforgedEntityTypes.OSTRICH)
    );
    public static void initialize() {
        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.SPAWN_EGGS).register(creativeTab -> {
            creativeTab.accept(ModItems.OSTRICH_SPAWN_EGG_ITEM);
        });
    }

}