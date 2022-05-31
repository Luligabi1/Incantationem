package me.luligabi.incantationem.enchantment;

import me.luligabi.incantationem.Util;
import net.minecraft.enchantment.Enchantment;

@SuppressWarnings("unused")
public class EnchantmentRegistry {

    public static Enchantment BUNNYS_HOP = Util.initEnchantment("bunnys_hop", new BunnysHopEnchantment());
    public static Enchantment SWINE_BANE = Util.initEnchantment("swine_bane", new SwineBaneEnchantment());
    public static Enchantment CHARMED = Util.initEnchantment("charmed", new CharmedEnchantment());
    public static Enchantment DECAY = Util.initEnchantment("decay", new DecayEnchantment());
    public static Enchantment FORGING_TOUCH =Util.initEnchantment("forging_touch", new ForgingTouchEnchantment());
    public static Enchantment LAST_STAND = Util.initEnchantment("last_stand", new LastStandEnchantment());
    public static Enchantment MAGNETIC = Util.initEnchantment("magnetic", new MagneticEnchantment());
    public static Enchantment REAPING_ROD = Util.initEnchantment("reaping_rod", new ReapingRodEnchantment());
    public static Enchantment RETREAT = Util.initEnchantment("retreat", new RetreatEnchantment());
    public static Enchantment VENOMOUS = Util.initEnchantment("venomous", new VenomousEnchantment());


    public static void init() {
        // NO-OP
    }

    private EnchantmentRegistry() {
        // NO-OP
    }
}