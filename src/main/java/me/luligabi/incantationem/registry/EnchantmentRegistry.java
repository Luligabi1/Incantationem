package me.luligabi.incantationem.registry;

import me.luligabi.incantationem.Incantationem;
import me.luligabi.incantationem.enchantment.*;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class EnchantmentRegistry {

    public static void register() {
        RETREAT = Registry.register(Registry.ENCHANTMENT, new Identifier(Incantationem.MOD_ID, "retreat"), new RetreatEnchantment());
        DECAY = Registry.register(Registry.ENCHANTMENT, new Identifier(Incantationem.MOD_ID, "decay"), new DecayEnchantment());
        MAGNETIC = Registry.register(Registry.ENCHANTMENT, new Identifier(Incantationem.MOD_ID, "magnetic"), new MagneticEnchantment());
        SWINE_BANE = Registry.register(Registry.ENCHANTMENT, new Identifier(Incantationem.MOD_ID, "swine_bane"), new SwineBaneEnchantment());
        LAST_STAND = Registry.register(Registry.ENCHANTMENT, new Identifier(Incantationem.MOD_ID, "last_stand"), new LastStandEnchantment());
        REAPING_ROD = Registry.register(Registry.ENCHANTMENT, new Identifier(Incantationem.MOD_ID, "reaping_rod"), new ReapingRodEnchantment());
        FORGING_TOUCH = Registry.register(Registry.ENCHANTMENT, new Identifier(Incantationem.MOD_ID, "forging_touch"), new ForgingTouchEnchantment());
    }

    public static Enchantment RETREAT;
    public static Enchantment DECAY;
    public static Enchantment MAGNETIC;
    public static Enchantment SWINE_BANE;
    public static Enchantment LAST_STAND;
    public static Enchantment REAPING_ROD;
    public static Enchantment FORGING_TOUCH;

}
