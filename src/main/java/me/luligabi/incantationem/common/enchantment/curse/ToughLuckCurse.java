package me.luligabi.incantationem.common.enchantment.curse;

import me.luligabi.incantationem.common.Incantationem;
import me.luligabi.incantationem.common.enchantment.EnchantmentRegistry;
import me.luligabi.incantationem.common.enchantment.IncantationemEnchantment;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.EquipmentSlot;

public class ToughLuckCurse extends IncantationemEnchantment {

    public ToughLuckCurse() {
        super(
            "tough_luck",
            Rarity.VERY_RARE,
            EnchantmentTarget.BREAKABLE,
            EquipmentSlot.values(),
            Incantationem.CONFIG.toughLuckAvailableForBookOffer,
            true,
            Incantationem.CONFIG.toughLuckAvailableAsTreasure
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

    @Override
    public boolean canAccept(Enchantment other) {
        return super.canAccept(other) && (other != EnchantmentRegistry.CHARMED);
    }

}
