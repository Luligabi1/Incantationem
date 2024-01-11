package me.luligabi.incantationem.common.enchantment;

import me.luligabi.incantationem.common.Incantationem;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.EquipmentSlot;

public class BunnysHopEnchantment extends IncantationemEnchantment {

    public BunnysHopEnchantment() {
        super(
            "bunnys_hop",
            Enchantment.Rarity.UNCOMMON,
            EnchantmentTarget.ARMOR_FEET,
            new EquipmentSlot[]{EquipmentSlot.FEET},
            Incantationem.CONFIG.bunnysHopMaxLevel,
            Incantationem.CONFIG.bunnysHopAvailableForBookOffer,
            Incantationem.CONFIG.bunnysHopAvailableRandomly,
            Incantationem.CONFIG.bunnysHopAvailableAsTreasure
        );
    }

    @Override
    public int getMinPower(int level) { return 10 + 10 * (level - 1); }

    @Override
    public int getMaxPower(int level) {
            return 50;
    }
}