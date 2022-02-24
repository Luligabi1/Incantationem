package me.luligabi.incantationem.tag;

import net.minecraft.block.Block;
import net.minecraft.tag.TagKey;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class TagRegistry {

    private TagRegistry() {
        // NO-OP
    }


    public static final TagKey<Block> COMMON_DIRT;

    static {
        COMMON_DIRT = TagKey.of(Registry.BLOCK_KEY, new Identifier("c", "dirt"));
    }
}