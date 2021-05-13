package me.luligabi.incantationem.curse;

import me.luligabi.incantationem.registry.EnchantmentRegistry;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.EquipmentSlot;

public class ToughLuckCurse extends Enchantment {

    public ToughLuckCurse() {
        super(Rarity.VERY_RARE, EnchantmentTarget.BREAKABLE, EquipmentSlot.values());
    }

    public int getMinPower(int level) { return level * 25; }

    public int getMaxPower(int level) { return this.getMinPower(level) + 50; }

    public int getMaxLevel() { return 1; }

    public boolean isTreasure() {
        return true;
    }

    public boolean isCursed() { return true; }

    public boolean isAvailableForEnchantedBookOffer() {
        return false;
    }

    public boolean canAccept(Enchantment other) { return super.canAccept(other) && (other != EnchantmentRegistry.CHARMED); }

}
