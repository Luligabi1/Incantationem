package me.luligabi.incantationem.common.enchantment;

import me.luligabi.incantationem.common.Util;
import net.minecraft.enchantment.Enchantment;

@SuppressWarnings("unused")
public class EnchantmentRegistry {

    public static Enchantment BUNNYS_HOP = Util.initEnchantment("bunnys_hop", new BunnysHopEnchantment());
    public static Enchantment ENDER_BANE = Util.initEnchantment("ender_bane", new BaneOfEnderEnchantment());
    public static Enchantment SWINE_BANE = Util.initEnchantment("swine_bane", new BaneOfTheSwineEnchantment());
    public static Enchantment CHARMED = Util.initEnchantment("charmed", new CharmedEnchantment());
    public static Enchantment CRITICAL_STRIKE = Util.initEnchantment("critical_strike", new CriticalStrikeEnchantment());
    public static Enchantment DECAY = Util.initEnchantment("decay", new DecayEnchantment());
    public static Enchantment DEFLECTION = Util.initEnchantment("deflection", new DeflectionEnchantment());
    public static Enchantment EXPLOSIVE = Util.initEnchantment("explosive", new ExplosiveEnchantment());
    public static Enchantment FORGING_TOUCH =Util.initEnchantment("forging_touch", new ForgingTouchEnchantment());
    public static Enchantment LAST_STAND = Util.initEnchantment("last_stand", new LastStandEnchantment());
    public static Enchantment LOOT_SCOOT = Util.initEnchantment("loot_scoot", new LootAndScootEnchantment());
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