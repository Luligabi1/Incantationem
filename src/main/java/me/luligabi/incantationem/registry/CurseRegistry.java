package me.luligabi.incantationem.registry;

import me.luligabi.incantationem.Incantationem;
import me.luligabi.incantationem.curse.RecklessnessCurse;
import me.luligabi.incantationem.curse.ThunderCurse;
import me.luligabi.incantationem.curse.ToughLuckCurse;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class CurseRegistry {

    public static void init() {
        RECKLESSNESS = Registry.register(Registry.ENCHANTMENT, new Identifier(Incantationem.MOD_ID, "recklessness"), new RecklessnessCurse());
        THUNDER = Registry.register(Registry.ENCHANTMENT, new Identifier(Incantationem.MOD_ID, "thunder"), new ThunderCurse());
        TOUGH_LUCK = Registry.register(Registry.ENCHANTMENT, new Identifier(Incantationem.MOD_ID, "tough_luck"), new ToughLuckCurse());
    }

    public static Enchantment RECKLESSNESS;
    public static Enchantment THUNDER;
    public static Enchantment TOUGH_LUCK;
}
