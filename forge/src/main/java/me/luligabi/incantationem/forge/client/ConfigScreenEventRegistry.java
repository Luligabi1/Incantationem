package me.luligabi.incantationem.forge.client;

import me.luligabi.incantationem.common.client.ConfigScreen;
import me.luligabi.incantationem.common.common.Incantationem;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModList;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.neoforge.client.ConfigScreenHandler;

@Mod.EventBusSubscriber(modid = Incantationem.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ConfigScreenEventRegistry {

    @SubscribeEvent
    public static void onPostInit(FMLClientSetupEvent event) {
        ModList.get().getModContainerById(Incantationem.MOD_ID).ifPresent(modContainer -> {
            modContainer.registerExtensionPoint(
                ConfigScreenHandler.ConfigScreenFactory.class,
                () -> new ConfigScreenHandler.ConfigScreenFactory((client, parent) -> {
                    return ConfigScreen.createConfigScreen(parent);
                })
            );
        });
    }
}