package me.luligabi.incantationem.tag;

import net.minecraft.block.Block;
import net.minecraft.tag.TagKey;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class TagRegistry {

    public static final TagKey<Block> COMMON_DIRT = TagKey.of(Registry.BLOCK_KEY, new Identifier("c", "dirt"));


    public static void init() {
        // NO-OP
    }

    private TagRegistry() {
        // NO-OP
    }
}