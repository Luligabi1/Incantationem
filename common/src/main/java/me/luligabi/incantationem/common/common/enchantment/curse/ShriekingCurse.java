package me.luligabi.incantationem.common.common.enchantment.curse;

import me.luligabi.incantationem.common.common.Incantationem;
import me.luligabi.incantationem.common.common.enchantment.IncantationemEnchantment;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentHelper;

public class ShriekingCurse extends IncantationemEnchantment {

    public ShriekingCurse() {
        super(
            "shrieking",
            Enchantment.definition(
                ItemTags.FOOT_ARMOR_ENCHANTABLE,
                5,
                1,
                Enchantment.dynamicCost(0, 25),
                Enchantment.dynamicCost(25, 50),
                2,
                EquipmentSlot.FEET
            ),
            Incantationem.CONFIG.curses.shrieking.availableRandomly,
            Incantationem.CONFIG.curses.shrieking.availableForBookOffer,
            Incantationem.CONFIG.curses.shrieking.availableAsTreasure
        );
    }

    @Override
    public boolean isCurse() {
        return true;
    }

    public static void apply(ServerPlayer player) {
        if(EnchantmentHelper.getEnchantmentLevel(CurseRegistry.SHRIEKING.get(), player) > 0) {
            player.getWardenSpawnTracker().ifPresent(wardenSpawnTracker -> {
                wardenSpawnTracker.setWarningLevel(wardenSpawnTracker.getWarningLevel() + 2);
            });
        }
    }
}