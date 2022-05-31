package me.luligabi.incantationem.enchantment;

import me.luligabi.incantationem.Incantationem;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

@SuppressWarnings("unused")
public class EnchantmentRegistry {

    public static Enchantment BUNNYS_HOP = Registry.register(Registry.ENCHANTMENT, new Identifier(Incantationem.MOD_ID, "bunnys_hop"), new BunnysHopEnchantment());
    public static Enchantment SWINE_BANE = Registry.register(Registry.ENCHANTMENT, new Identifier(Incantationem.MOD_ID, "swine_bane"), new SwineBaneEnchantment());
    public static Enchantment CHARMED = Registry.register(Registry.ENCHANTMENT, new Identifier(Incantationem.MOD_ID, "charmed"), new CharmedEnchantment());
    public static Enchantment DECAY = Registry.register(Registry.ENCHANTMENT, new Identifier(Incantationem.MOD_ID, "decay"), new DecayEnchantment());
    public static Enchantment FORGING_TOUCH = Registry.register(Registry.ENCHANTMENT, new Identifier(Incantationem.MOD_ID, "forging_touch"), new ForgingTouchEnchantment());
    public static Enchantment LAST_STAND = Registry.register(Registry.ENCHANTMENT, new Identifier(Incantationem.MOD_ID, "last_stand"), new LastStandEnchantment());
    public static Enchantment MAGNETIC = Registry.register(Registry.ENCHANTMENT, new Identifier(Incantationem.MOD_ID, "magnetic"), new MagneticEnchantment());
    public static Enchantment REAPING_ROD = Registry.register(Registry.ENCHANTMENT, new Identifier(Incantationem.MOD_ID, "reaping_rod"), new ReapingRodEnchantment());
    public static Enchantment RETREAT = Registry.register(Registry.ENCHANTMENT, new Identifier(Incantationem.MOD_ID, "retreat"), new RetreatEnchantment());
    public static Enchantment VENOMOUS = Registry.register(Registry.ENCHANTMENT, new Identifier(Incantationem.MOD_ID, "venomous"), new VenomousEnchantment());


    public static void init() {
        // NO-OP
    }

    private EnchantmentRegistry() {
        // NO-OP
    }
}