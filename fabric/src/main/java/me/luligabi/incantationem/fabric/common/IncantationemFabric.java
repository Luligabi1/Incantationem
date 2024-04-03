package me.luligabi.incantationem.fabric.common;

import me.luligabi.incantationem.common.common.Incantationem;
import net.fabricmc.api.ModInitializer;

public class IncantationemFabric implements ModInitializer {

    @Override
    public void onInitialize() {
        Incantationem.init();
    }
}