package me.luligabi.incantationem.enchantment;

import me.luligabi.incantationem.registry.CurseRegistry;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.EquipmentSlot;

public class ForgingTouchEnchantment extends Enchantment {

    public ForgingTouchEnchantment() {
        super(Rarity.RARE, EnchantmentTarget.DIGGER, new EquipmentSlot[]{EquipmentSlot.MAINHAND, EquipmentSlot.OFFHAND});
    }

    public int getMinPower(int level) { return 15 + (level - 1) * 9; }

    public int getMaxPower(int level) { return super.getMinPower(level) + 50; }

    public int getMaxLevel() { return 3; }

    public boolean isTreasure() {
        return true;
    }

    public boolean canAccept(Enchantment other) { return super.canAccept(other) && other != CurseRegistry.RECKLESSNESS; }

}