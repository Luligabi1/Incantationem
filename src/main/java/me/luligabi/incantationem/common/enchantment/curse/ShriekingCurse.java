package me.luligabi.incantationem.common.enchantment.curse;

import me.luligabi.incantationem.common.Incantationem;
import me.luligabi.incantationem.common.enchantment.IncantationemEnchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.EquipmentSlot;

public class ShriekingCurse extends IncantationemEnchantment {

    public ShriekingCurse() {
        super(
                Rarity.VERY_RARE,
                EnchantmentTarget.ARMOR_FEET,
                new EquipmentSlot[]{EquipmentSlot.FEET},
                1,
                Incantationem.CONFIG.shriekingAvailableForBookOffer,
                true,
                Incantationem.CONFIG.shriekingAvailableAsTreasure
        );
    }

    @Override
    public int getMinPower(int level) {
        return level * 25;
    }

    @Override
    public int getMaxPower(int level) {
        return this.getMinPower(level) + 50;
    }

    @Override
    public boolean isCursed() {
        return true;
    }
}
