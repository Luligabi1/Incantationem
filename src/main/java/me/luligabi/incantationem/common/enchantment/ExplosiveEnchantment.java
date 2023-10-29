package me.luligabi.incantationem.common.enchantment;

import me.luligabi.incantationem.common.Incantationem;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.EquipmentSlot;

public class ExplosiveEnchantment extends IncantationemEnchantment {

    public ExplosiveEnchantment() {
        super(
                Enchantment.Rarity.RARE,
                EnchantmentTarget.BOW,
                new EquipmentSlot[]{EquipmentSlot.MAINHAND, EquipmentSlot.OFFHAND},
                Incantationem.CONFIG.explosiveMaxLevel,
                Incantationem.CONFIG.explosiveAvailableForBookOffer,
                Incantationem.CONFIG.explosiveAvailableRandomly,
                Incantationem.CONFIG.explosiveAvailableAsTreasure
        );
    }

    @Override
    public int getMinPower(int level) {
        return 5 + 20 * (level - 1);
    }

    @Override
    public int getMaxPower(int level) {
        return super.getMinPower(level) + 50;
    }

}
