package me.luligabi.incantationem.enchantment;

import me.luligabi.incantationem.Incantationem;
import me.luligabi.incantationem.enchantment.*;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class EnchantmentRegistry {

    public static void init() {
        BUNNYS_HOP = Registry.register(Registry.ENCHANTMENT, new Identifier(Incantationem.MOD_ID, "bunnys_hop"), new BunnysHopEnchantment());
        SWINE_BANE = Registry.register(Registry.ENCHANTMENT, new Identifier(Incantationem.MOD_ID, "swine_bane"), new SwineBaneEnchantment());
        CHARMED = Registry.register(Registry.ENCHANTMENT, new Identifier(Incantationem.MOD_ID, "charmed"), new CharmedEnchantment());
        DECAY = Registry.register(Registry.ENCHANTMENT, new Identifier(Incantationem.MOD_ID, "decay"), new DecayEnchantment());
        FORGING_TOUCH = Registry.register(Registry.ENCHANTMENT, new Identifier(Incantationem.MOD_ID, "forging_touch"), new ForgingTouchEnchantment());
        LAST_STAND = Registry.register(Registry.ENCHANTMENT, new Identifier(Incantationem.MOD_ID, "last_stand"), new LastStandEnchantment());
        MAGNETIC = Registry.register(Registry.ENCHANTMENT, new Identifier(Incantationem.MOD_ID, "magnetic"), new MagneticEnchantment());
        REAPING_ROD = Registry.register(Registry.ENCHANTMENT, new Identifier(Incantationem.MOD_ID, "reaping_rod"), new ReapingRodEnchantment());
        RETREAT = Registry.register(Registry.ENCHANTMENT, new Identifier(Incantationem.MOD_ID, "retreat"), new RetreatEnchantment());
        VENOMOUS = Registry.register(Registry.ENCHANTMENT, new Identifier(Incantationem.MOD_ID, "venomous"), new VenomousEnchantment());
    }

    public static Enchantment BUNNYS_HOP;
    public static Enchantment SWINE_BANE;
    public static Enchantment CHARMED;
    public static Enchantment DECAY;
    public static Enchantment FORGING_TOUCH;
    public static Enchantment LAST_STAND;
    public static Enchantment MAGNETIC;
    public static Enchantment REAPING_ROD;
    public static Enchantment RETREAT;
    public static Enchantment VENOMOUS;

}
