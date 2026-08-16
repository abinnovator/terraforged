package terrafored.modid;

import net.minecraft.references.BlockItemId;
import net.minecraft.resources.Identifier;

public class ModBlockItemIds {
    public static final BlockItemId BAOBAB_LOG = create("baobab_log");
    public static final BlockItemId BAOBAB_PLANK = create("baobab_plank");
    public static final BlockItemId BAOBAB_DOOR = create("baobab_door");
    private static BlockItemId create(String name) {
        Identifier id = Identifier.fromNamespaceAndPath(Terraforged.MOD_ID, name);
        return BlockItemId.create(id, id);
    }
}
