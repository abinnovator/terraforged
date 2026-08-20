package terrafored.modid;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;

public class TerraforgedEntityTypes {
    // Register my ostrich in mc
    public static EntityType<OstrichEntity> OSTRICH =
            register("ostrich", EntityType.Builder.of(OstrichEntity::new, net.minecraft.world.entity.MobCategory.CREATURE).sized(1.0F, 1.0F));
    private static <T extends Entity> EntityType<T> register(String name, EntityType.Builder<T> builder) {
        ResourceKey<EntityType<?>> key = ResourceKey.create(Registries.ENTITY_TYPE, Identifier.fromNamespaceAndPath(Terraforged.MOD_ID, name));
        return Registry.register(BuiltInRegistries.ENTITY_TYPE, key, builder.build(key));
    }

    public static void registerModEntityTypes() {
        Terraforged.LOGGER.info("Registering EntityTypes for " + Terraforged.MOD_ID);
    }

    public static void registerAttributes() {
        FabricDefaultAttributeRegistry.register(OSTRICH, OstrichEntity.createAttributes());
    }
}
