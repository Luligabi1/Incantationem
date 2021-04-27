package me.luligabi.incantationem;

import me.luligabi.incantationem.registry.EnchantmentRegistry;
import net.fabricmc.api.ModInitializer;

public class Incantationem implements ModInitializer {

    public static String MOD_ID = "incantationem";

    @Override
    public void onInitialize() {
        EnchantmentRegistry.register();
    }
}
