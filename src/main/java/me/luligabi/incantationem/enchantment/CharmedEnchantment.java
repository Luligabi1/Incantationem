package me.luligabi.incantationem.enchantment;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ItemStack;

public class CharmedEnchantment extends Enchantment {


    public CharmedEnchantment() {
        super(Enchantment.Rarity.RARE, EnchantmentTarget.BREAKABLE, EquipmentSlot.values());
    }

    public int getMinPower(int level) {
        return 5 + (level - 1) * 12;
    }

    public int getMaxPower(int level) {
        return super.getMinPower(level) + 50;
    }

    public int getMaxLevel() {
        return 1;
    }

    public boolean isAcceptableItem(ItemStack stack) {
        return stack.isDamageable() || super.isAcceptableItem(stack);
    }
}