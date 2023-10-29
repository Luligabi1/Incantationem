package me.luligabi.incantationem.common.enchantment;

import me.luligabi.incantationem.common.Incantationem;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.EquipmentSlot;

public class LootAndScootEnchantment extends IncantationemEnchantment {

    public LootAndScootEnchantment() {
        super(
                Enchantment.Rarity.RARE,
                EnchantmentTarget.ARMOR_FEET,
                new EquipmentSlot[]{EquipmentSlot.FEET},
                Incantationem.CONFIG.lootAndScootAvailableForBookOffer,
                Incantationem.CONFIG.lootAndScootAvailableRandomly,
                Incantationem.CONFIG.lootAndScootAvailableAsTreasure
        );
    }

    @Override
    public int getMinPower(int level) {
        return 5 + (level - 1) * 12;
    }

    @Override
    public int getMaxPower(int level) {
        return super.getMinPower(level) + 50;
    }
}
