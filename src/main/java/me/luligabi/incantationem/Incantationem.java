package me.luligabi.incantationem;

import me.luligabi.incantationem.curse.CurseRegistry;
import me.luligabi.incantationem.enchantment.EnchantmentRegistry;
import net.fabricmc.api.ModInitializer;
import net.minecraft.entity.EntityGroup;

public class Incantationem implements ModInitializer {

    @Override
    public void onInitialize() {
        CurseRegistry.init();
        EnchantmentRegistry.init();
    }

    public static String MOD_ID = "incantationem";

    public static final EntityGroup SWINE = new EntityGroup();

}