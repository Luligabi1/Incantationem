package me.luligabi.incantationem;

import me.luligabi.incantationem.curse.CurseRegistry;
import me.luligabi.incantationem.enchantment.EnchantmentRegistry;
import me.luligabi.incantationem.tag.TagRegistry;
import net.fabricmc.api.ModInitializer;
import net.minecraft.entity.EntityGroup;

public class Incantationem implements ModInitializer {

    @Override
    public void onInitialize() {
        CurseRegistry.init();
        EnchantmentRegistry.init();

        TagRegistry.init();
    }

    public static String MOD_ID = "incantationem";

    public static final EntityGroup SWINE = new EntityGroup();

}