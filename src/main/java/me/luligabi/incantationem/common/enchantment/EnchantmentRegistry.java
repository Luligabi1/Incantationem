package me.luligabi.incantationem.common.enchantment;

import me.luligabi.incantationem.common.Util;
import net.minecraft.enchantment.Enchantment;

@SuppressWarnings("unused")
public class EnchantmentRegistry {

    public static Enchantment BUNNYS_HOP = Util.initEnchantment(new BunnysHopEnchantment());
    public static Enchantment SWINE_BANE = Util.initEnchantment(new BaneOfTheSwineEnchantment());
    public static Enchantment CHARMED = Util.initEnchantment(new CharmedEnchantment());
    public static Enchantment DECAY = Util.initEnchantment(new DecayEnchantment());
    public static Enchantment DEFLECTION = Util.initEnchantment(new DeflectionEnchantment());
    public static Enchantment FUSE_SHOT = Util.initEnchantment(new FuseShotEnchantment());
    public static Enchantment FORGING_TOUCH = Util.initEnchantment(new ForgingTouchEnchantment());
    public static Enchantment LAST_STAND = Util.initEnchantment(new LastStandEnchantment());
    public static Enchantment MAGNETIC = Util.initEnchantment(new MagneticEnchantment());
    public static Enchantment REAPING_ROD = Util.initEnchantment(new ReapingRodEnchantment());
    public static Enchantment RETREAT = Util.initEnchantment(new RetreatEnchantment());
    public static Enchantment VENOMOUS = Util.initEnchantment(new VenomousEnchantment());
    public static Enchantment WATER_SLASH = Util.initEnchantment(new WaterSlashEnchantment());


    public static void init() {
        // NO-OP
    }

    private EnchantmentRegistry() {
        // NO-OP
    }
}