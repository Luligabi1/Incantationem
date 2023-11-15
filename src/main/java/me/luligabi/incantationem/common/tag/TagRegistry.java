package me.luligabi.incantationem.common.tag;

import me.luligabi.incantationem.common.Incantationem;
import net.minecraft.block.Block;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

public class TagRegistry {

    public static final TagKey<Block> COMMON_DIRT = TagKey.of(RegistryKeys.BLOCK, new Identifier("c", "dirt"));

    public static final TagKey<Enchantment> FUSE_SHOT_INCOMPATIBLE = TagKey.of(RegistryKeys.ENCHANTMENT, Incantationem.modId("fuse_shot_incompatible"));
    public static final TagKey<Enchantment> WATER_SLASH_INCOMPATIBLE = TagKey.of(RegistryKeys.ENCHANTMENT, Incantationem.modId("water_slash_incompatible"));

    public static void init() {
        // NO-OP
    }

    private TagRegistry() {
        // NO-OP
    }
}