package me.luligabi.incantationem.common.common.enchantment;

import dev.architectury.registry.registries.RegistrySupplier;
import me.luligabi.incantationem.common.common.Incantationem;

@SuppressWarnings("unused")
public class EnchantmentRegistry {


    public static final RegistrySupplier<BunnysHopEnchantment> BUNNYS_HOP = Incantationem.ENCHANTMENTS.register(
        Incantationem.modId("bunnys_hop"),
        BunnysHopEnchantment::new
    );
    public static final RegistrySupplier<BaneOfTheSwineEnchantment> SWINE_BANE = Incantationem.ENCHANTMENTS.register(
        Incantationem.modId("swine_bane"),
        BaneOfTheSwineEnchantment::new
    );
    public static final RegistrySupplier<CharmedEnchantment> CHARMED = Incantationem.ENCHANTMENTS.register(
        Incantationem.modId("charmed"),
        CharmedEnchantment::new
    );
    public static final RegistrySupplier<DecayEnchantment> DECAY = Incantationem.ENCHANTMENTS.register(
        Incantationem.modId("decay"),
        DecayEnchantment::new
    );
    public static final RegistrySupplier<DeflectionEnchantment> DEFLECTION = Incantationem.ENCHANTMENTS.register(
        Incantationem.modId("deflection"),
        DeflectionEnchantment::new
    );
    public static final RegistrySupplier<ForgingTouchEnchantment> FORGING_TOUCH = Incantationem.ENCHANTMENTS.register(
            Incantationem.modId("forging_touch"),
            ForgingTouchEnchantment::new
    );
    public static final RegistrySupplier<FuseShotEnchantment> FUSE_SHOT = Incantationem.ENCHANTMENTS.register(
        Incantationem.modId("fuse_shot"),
        FuseShotEnchantment::new
    );
    public static final RegistrySupplier<LastStandEnchantment> LAST_STAND = Incantationem.ENCHANTMENTS.register(
        Incantationem.modId("last_stand"),
        LastStandEnchantment::new
    );
    public static final RegistrySupplier<MagneticEnchantment> MAGNETIC = Incantationem.ENCHANTMENTS.register(
        Incantationem.modId("magnetic"),
        MagneticEnchantment::new
    );
    public static final RegistrySupplier<ReapingRodEnchantment> REAPING_ROD = Incantationem.ENCHANTMENTS.register(
        Incantationem.modId("reaping_rod"),
        ReapingRodEnchantment::new
    );
    public static final RegistrySupplier<RetreatEnchantment> RETREAT = Incantationem.ENCHANTMENTS.register(
        Incantationem.modId("retreat"),
        RetreatEnchantment::new
    );
    public static final RegistrySupplier<VenomousEnchantment> VENOMOUS = Incantationem.ENCHANTMENTS.register(
        Incantationem.modId("venomous"),
        VenomousEnchantment::new
    );
    public static final RegistrySupplier<WaterSlashEnchantment> WATER_SLASH = Incantationem.ENCHANTMENTS.register(
        Incantationem.modId("water_slash"),
        WaterSlashEnchantment::new
    );


    public static void init() {
        // NO-OP
    }

    private EnchantmentRegistry() {
        // NO-OP
    }

}