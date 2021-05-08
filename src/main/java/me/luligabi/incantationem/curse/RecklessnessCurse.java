package me.luligabi.incantationem.curse;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.EquipmentSlot;

/*
 * Original idea by u/celerysatan @ https://reddit.com/r/minecraftsuggestions/comments/mzyf9q/a_curse_with_a_compromise_curse_of_recklessness/
 */
public class RecklessnessCurse extends Enchantment {

    public RecklessnessCurse() {
        super(Rarity.VERY_RARE, EnchantmentTarget.DIGGER, new EquipmentSlot[]{EquipmentSlot.MAINHAND, EquipmentSlot.OFFHAND});
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

}
