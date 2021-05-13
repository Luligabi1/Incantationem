package me.luligabi.incantationem.enchantment;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.EquipmentSlot;

public class BunnysHopEnchantment extends Enchantment {

    public BunnysHopEnchantment() {
        super(Enchantment.Rarity.UNCOMMON, EnchantmentTarget.ARMOR_FEET, new EquipmentSlot[]{EquipmentSlot.FEET});
    }

        public int getMinPower(int level) { return 10 + 10 * (level - 1); }

        public int getMaxPower(int level) {
            return 50;
        }

        public int getMaxLevel() {
            return 3;
        }

}
