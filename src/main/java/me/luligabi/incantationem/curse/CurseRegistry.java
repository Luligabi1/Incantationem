package me.luligabi.incantationem.curse;

import me.luligabi.incantationem.Incantationem;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

@SuppressWarnings("unused")
public class CurseRegistry {


    public static Enchantment RECKLESSNESS = Registry.register(Registry.ENCHANTMENT, new Identifier(Incantationem.MOD_ID, "recklessness"), new RecklessnessCurse());
    public static Enchantment THUNDER = Registry.register(Registry.ENCHANTMENT, new Identifier(Incantationem.MOD_ID, "thunder"), new ThunderCurse());
    public static Enchantment TOUGH_LUCK = Registry.register(Registry.ENCHANTMENT, new Identifier(Incantationem.MOD_ID, "tough_luck"), new ToughLuckCurse());


    public static void init() {
        // NO-OP
    }

    private CurseRegistry() {
        // NO-OP
    }
}
