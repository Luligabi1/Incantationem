package me.luligabi.incantationem.common.common.util;

import me.luligabi.incantationem.common.common.Incantationem;
import net.minecraft.core.registries.Registries;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.EntityType;

public class TagRegistry {

    public static final TagKey<EntityType<?>> SENSITIVE_TO_BANE_OF_THE_SWINE = createSensitiveToTag("bane_of_the_swine");
    public static final TagKey<EntityType<?>> SENSITIVE_TO_WATER_SLASH = createSensitiveToTag("water_slash");


    private static TagKey<EntityType<?>> createSensitiveToTag(String id) {
        return TagKey.create(Registries.ENTITY_TYPE, Incantationem.id("sensitive_to_" + id));
    }

    public static void init() {
        // NO-OP
    }

    private TagRegistry() {
        // NO-OP
    }
}