package me.luligabi.incantationem.registry;

import me.luligabi.incantationem.Incantationem;
import me.luligabi.incantationem.curse.RecklessnessCurse;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class CurseRegistry {

    public static void register() {
        RECKLESSNESS = Registry.register(Registry.ENCHANTMENT, new Identifier(Incantationem.MOD_ID, "recklessness"), new RecklessnessCurse());

    }

    public static Enchantment RECKLESSNESS;

}
