package me.luligabi.incantationem.common.common;

import com.google.common.base.Supplier;
import com.google.common.base.Suppliers;
import com.mojang.serialization.MapCodec;
import dev.architectury.event.events.common.CommandRegistrationEvent;
import dev.architectury.platform.Platform;
import dev.architectury.registry.registries.Registrar;
import dev.architectury.registry.registries.RegistrarManager;
import me.luligabi.incantationem.common.common.enchantment.effecttype.EnchantmentEffectTypeRegistry;
import me.luligabi.incantationem.common.common.network.NetworkRegistry;
import me.luligabi.incantationem.common.common.util.TagRegistry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.commands.WardenSpawnTrackerCommand;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.effects.EnchantmentEntityEffect;

public class Incantationem {

    public static void init() {
        TagRegistry.init();
        EnchantmentEffectTypeRegistry.init();
        NetworkRegistry.init();

        if(Platform.isDevelopmentEnvironment()) {
            CommandRegistrationEvent.EVENT.register((dispatcher, registry, selection) -> {
                WardenSpawnTrackerCommand.register(dispatcher);
            });
        }
    }


    public static final ModConfig CONFIG;

    public static ResourceLocation id(String id) {
        return ResourceLocation.fromNamespaceAndPath(MOD_ID, id);
    }

    public static final String MOD_ID = "incantationem";


    public static final Registrar<MapCodec<? extends EnchantmentEntityEffect>> ENTITY_EFFECTS;
    private static final Supplier<RegistrarManager> MANAGER;

    static {
        MANAGER = Suppliers.memoize(() -> RegistrarManager.get(Incantationem.MOD_ID));
        ENTITY_EFFECTS = Incantationem.MANAGER.get().get(BuiltInRegistries.ENCHANTMENT_ENTITY_EFFECT_TYPE);

        ModConfig.HANDLER.load();
        CONFIG = ModConfig.HANDLER.instance();
    }
}