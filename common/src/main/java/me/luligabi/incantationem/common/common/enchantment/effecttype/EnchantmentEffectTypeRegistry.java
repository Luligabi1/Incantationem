package me.luligabi.incantationem.common.common.enchantment.effecttype;

import com.mojang.serialization.MapCodec;
import dev.architectury.registry.registries.RegistrySupplier;
import me.luligabi.incantationem.common.common.Incantationem;
import net.minecraft.world.item.enchantment.effects.EnchantmentEntityEffect;

@SuppressWarnings("unused")
public class EnchantmentEffectTypeRegistry {

    public static final RegistrySupplier<MapCodec<? extends EnchantmentEntityEffect>> APPLY_EFFECT = Incantationem.ENTITY_EFFECTS.register(
        Incantationem.id("apply_effect"),
        () -> ApplyEffect.CODEC
    );

    public static final RegistrySupplier<MapCodec<? extends EnchantmentEntityEffect>> BUNNYS_HOP = Incantationem.ENTITY_EFFECTS.register(
        Incantationem.id("bunnys_hop"),
        () -> BunnysHop.CODEC
    );

    public static final RegistrySupplier<MapCodec<? extends EnchantmentEntityEffect>> DECAY = Incantationem.ENTITY_EFFECTS.register(
        Incantationem.id("decay"),
        () -> Decay.CODEC
    );

    public static final RegistrySupplier<MapCodec<? extends EnchantmentEntityEffect>> LAST_STAND = Incantationem.ENTITY_EFFECTS.register(
        Incantationem.id("last_stand"),
        () -> LastStand.CODEC
    );

    public static final RegistrySupplier<MapCodec<? extends EnchantmentEntityEffect>> MAGNETIC = Incantationem.ENTITY_EFFECTS.register(
        Incantationem.id("magnetic"),
        () -> Magnetic.CODEC
    );

    public static final RegistrySupplier<MapCodec<? extends EnchantmentEntityEffect>> REAPING_ROD = Incantationem.ENTITY_EFFECTS.register(
        Incantationem.id("reaping_rod"),
        () -> ReapingRod.CODEC
    );

    public static final RegistrySupplier<MapCodec<? extends EnchantmentEntityEffect>> RETREAT = Incantationem.ENTITY_EFFECTS.register(
        Incantationem.id("retreat"),
        () -> Retreat.CODEC
    );

    public static final RegistrySupplier<MapCodec<? extends EnchantmentEntityEffect>> THUNDER = Incantationem.ENTITY_EFFECTS.register(
        Incantationem.id("thunder"),
        () -> Thunder.CODEC
    );


    public static void init() {
        // NO-OP
    }

    private EnchantmentEffectTypeRegistry() {
        // NO-OP
    }
}