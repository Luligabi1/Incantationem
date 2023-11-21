package me.luligabi.incantationem.common.enchantment.curse;

import me.luligabi.incantationem.common.Util;
import net.minecraft.enchantment.Enchantment;

@SuppressWarnings("unused")
public class CurseRegistry {


    public static Enchantment RECKLESSNESS = Util.initEnchantment(new RecklessnessCurse());
    public static Enchantment SHRIEKING = Util.initEnchantment(new ShriekingCurse());
    public static Enchantment THUNDER = Util.initEnchantment(new ThunderCurse());
    public static Enchantment TOUGH_LUCK = Util.initEnchantment(new ToughLuckCurse());


    public static void init() {
        // NO-OP
    }

    private CurseRegistry() {
        // NO-OP
    }
}
