package me.luligabi.incantationem.registry;

import me.luligabi.incantationem.Incantationem;
import me.luligabi.incantationem.enchantment.DecayEnchantment;
import me.luligabi.incantationem.enchantment.MagneticEnchantment;
import me.luligabi.incantationem.enchantment.RetreatEnchantment;
import me.luligabi.incantationem.enchantment.SwineBaneEnchantment;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class EnchantmentRegistry {

    public static void register() {
        RETREAT = Registry.register(Registry.ENCHANTMENT, new Identifier(Incantationem.MOD_ID, "retreat"), new RetreatEnchantment());
        DECAY = Registry.register(Registry.ENCHANTMENT, new Identifier(Incantationem.MOD_ID, "decay"), new DecayEnchantment());
        MAGNETIC = Registry.register(Registry.ENCHANTMENT, new Identifier(Incantationem.MOD_ID, "magnetic"), new MagneticEnchantment());
        SWINE_BANE = Registry.register(Registry.ENCHANTMENT, new Identifier(Incantationem.MOD_ID, "swine_bane"), new SwineBaneEnchantment());
    }

    public static Enchantment RETREAT;
    public static Enchantment DECAY;
    public static Enchantment MAGNETIC;
    public static Enchantment SWINE_BANE;

}
