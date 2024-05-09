package me.luligabi.incantationem.forge.client;

import me.luligabi.incantationem.common.client.ConfigScreen;
import me.luligabi.incantationem.common.common.Incantationem;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModList;
import net.neoforged.fml.ModLoadingContext;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.neoforge.client.gui.IConfigScreenFactory;

@EventBusSubscriber(modid = Incantationem.MOD_ID, bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ConfigScreenEventRegistry {

    @SubscribeEvent // FIXME
    public static void onPostInit(FMLClientSetupEvent event) {
        ModLoadingContext.get().registerExtensionPoint(
            IConfigScreenFactory.class,
            () -> (client, parent) -> ConfigScreen.createConfigScreen(parent)
        );
    }
}