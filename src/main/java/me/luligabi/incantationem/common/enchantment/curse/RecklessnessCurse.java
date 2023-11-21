package me.luligabi.incantationem.common.enchantment.curse;

import me.luligabi.incantationem.common.Incantationem;
import me.luligabi.incantationem.common.enchantment.IncantationemEnchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.EquipmentSlot;

/*
 * Original idea by u/celerysatan @ https://reddit.com/r/minecraftsuggestions/comments/mzyf9q/a_curse_with_a_compromise_curse_of_recklessness/
 */
public class RecklessnessCurse extends IncantationemEnchantment {

    public RecklessnessCurse() {
        super(
            "recklessness",
            Rarity.VERY_RARE,
            EnchantmentTarget.DIGGER,
            new EquipmentSlot[]{EquipmentSlot.MAINHAND, EquipmentSlot.OFFHAND},
            1,
            Incantationem.CONFIG.recklessnessAvailableForBookOffer,
            true,
            Incantationem.CONFIG.recklessnessAvailableAsTreasure
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
    public boolean isCursed() { return true; }

}