package me.luligabi.incantationem.curse;

import me.luligabi.incantationem.Util;
import net.minecraft.enchantment.Enchantment;

@SuppressWarnings("unused")
public class CurseRegistry {


    public static Enchantment RECKLESSNESS = Util.initEnchantment("recklessness", new RecklessnessCurse());
    public static Enchantment THUNDER = Util.initEnchantment("thunder", new ThunderCurse());
    public static Enchantment TOUGH_LUCK = Util.initEnchantment("tough_luck", new ToughLuckCurse());


    public static void init() {
        // NO-OP
    }

    private CurseRegistry() {
        // NO-OP
    }
}
