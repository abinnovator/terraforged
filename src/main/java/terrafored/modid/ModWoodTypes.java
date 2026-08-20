package terrafored.modid;

import net.fabricmc.fabric.api.object.builder.v1.block.type.BlockSetTypeBuilder;
import net.fabricmc.fabric.api.object.builder.v1.block.type.WoodTypeBuilder;
import net.minecraft.resources.Identifier;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.WoodType;
import terrafored.modid.Terraforged;

public class ModWoodTypes {
    public static final BlockSetType BAOBAB_SET_TYPE =
            BlockSetTypeBuilder.copyOf(BlockSetType.OAK)
                    .register(Identifier.fromNamespaceAndPath(Terraforged.MOD_ID, "baobab"));

    public static final WoodType BAOBAB_WOOD_TYPE =
            WoodTypeBuilder.copyOf(WoodType.OAK)
                    .register(Identifier.fromNamespaceAndPath(Terraforged.MOD_ID, "baobab"), BAOBAB_SET_TYPE);

    public static void initialize() {}
}