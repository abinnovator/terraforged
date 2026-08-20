package terrafored.modid;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.Item;

public class ModItemIds {
    public static ResourceKey<Item> create(String name) {
        // Create the item key.
        return ResourceKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(Terraforged.MOD_ID, name));
    }
    public static final ResourceKey<Item> OSTRICH_SPAWN_EGG = create("ostrich_spawn_egg");
}
