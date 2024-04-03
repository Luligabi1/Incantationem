package me.luligabi.incantationem.common.common.enchantment.curse;

import me.luligabi.incantationem.common.common.Incantationem;
import me.luligabi.incantationem.common.common.enchantment.IncantationemEnchantment;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.enchantment.EnchantmentCategory;
import net.minecraft.world.item.enchantment.EnchantmentHelper;

public class ShriekingCurse extends IncantationemEnchantment {

    public ShriekingCurse() {
        super(
            "shrieking",
            Rarity.VERY_RARE,
            EnchantmentCategory.ARMOR_FEET,
            new EquipmentSlot[]{EquipmentSlot.FEET},
            1,
            Incantationem.CONFIG.shriekingAvailableForBookOffer,
            true,
            Incantationem.CONFIG.shriekingAvailableAsTreasure
        );
    }

    @Override
    public int getMinCost(int level) {
        return level * 25;
    }

    @Override
    public int getMaxCost(int level) {
        return this.getMinCost(level) + 50;
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