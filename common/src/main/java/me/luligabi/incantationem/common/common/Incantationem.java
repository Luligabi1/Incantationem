package me.luligabi.incantationem.common.common;

import com.google.common.base.Supplier;
import com.google.common.base.Suppliers;
import dev.architectury.event.events.common.CommandRegistrationEvent;
import dev.architectury.platform.Platform;
import dev.architectury.registry.registries.Registrar;
import dev.architectury.registry.registries.RegistrarManager;
import me.luligabi.incantationem.common.common.enchantment.EnchantmentRegistry;
import me.luligabi.incantationem.common.common.enchantment.curse.CurseRegistry;
import me.luligabi.incantationem.common.common.network.NetworkRegistry;
import me.luligabi.incantationem.common.common.util.TagRegistry;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.commands.WardenSpawnTrackerCommand;
import net.minecraft.world.item.enchantment.Enchantment;

public class Incantationem {

    public static void init() {
        TagRegistry.init();
        CurseRegistry.init();
        EnchantmentRegistry.init();
        NetworkRegistry.init();

        if(Platform.isDevelopmentEnvironment()) {
            CommandRegistrationEvent.EVENT.register((dispatcher, registry, selection) -> {
                WardenSpawnTrackerCommand.register(dispatcher);
            });
        }
    }


    public static final ModConfig CONFIG;

    public static ResourceLocation modId(String id) {
        return new ResourceLocation(MOD_ID, id);
    }

    public static final String MOD_ID = "incantationem";

    public static final Registrar<Enchantment> ENCHANTMENTS;
    private static final Supplier<RegistrarManager> MANAGER;

    static {
        MANAGER = Suppliers.memoize(() -> RegistrarManager.get(Incantationem.MOD_ID));
        ENCHANTMENTS = Incantationem.MANAGER.get().get(Registries.ENCHANTMENT);

        ModConfig.HANDLER.load();
        CONFIG = ModConfig.HANDLER.instance();
    }
}