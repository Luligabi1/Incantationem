package me.luligabi.incantationem.common.common.enchantment.curse;

import me.luligabi.incantationem.common.common.Incantationem;
import me.luligabi.incantationem.common.common.Util;
import me.luligabi.incantationem.common.common.enchantment.EnchantmentRegistry;
import me.luligabi.incantationem.common.common.enchantment.IncantationemEnchantment;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentCategory;
import net.minecraft.world.item.enchantment.EnchantmentHelper;

public class ToughLuckCurse extends IncantationemEnchantment {

    public ToughLuckCurse() {
        super(
            "tough_luck",
            Rarity.VERY_RARE,
            EnchantmentCategory.BREAKABLE,
            EquipmentSlot.values(),
            Incantationem.CONFIG.curses.toughLuck.availableForBookOffer,
            true,
            Incantationem.CONFIG.curses.toughLuck.availableAsTreasure
        );
    }

    @Override
    public int getMinCost(int level) {
        return level * 25;
    }

    @Override
    public int getMaxCost(int level) {
        return this.getMinCost(level) + 50;
    }

    @Override
    public boolean isCurse() {
        return true;
    }

    @Override
    public boolean checkCompatibility(Enchantment other) {
        return super.checkCompatibility(other) && (other != EnchantmentRegistry.CHARMED);
    }


    public static void apply(LivingEntity user) {
        if(EnchantmentHelper.getEnchantmentLevel(CurseRegistry.TOUGH_LUCK.get(), user) < 1) return;
        Util.applyEffectIfNotPresent(user, MobEffects.UNLUCK, 3, 0);
    }

}