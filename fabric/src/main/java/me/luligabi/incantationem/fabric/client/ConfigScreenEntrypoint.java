package me.luligabi.incantationem.fabric.client;

import com.terraformersmc.modmenu.api.ConfigScreenFactory;
import com.terraformersmc.modmenu.api.ModMenuApi;
import me.luligabi.incantationem.common.client.ConfigScreen;

public class ConfigScreenEntrypoint implements ModMenuApi {

    @Override
    public ConfigScreenFactory<?> getModConfigScreenFactory() {
        return ConfigScreen::createConfigScreen;
    }
}