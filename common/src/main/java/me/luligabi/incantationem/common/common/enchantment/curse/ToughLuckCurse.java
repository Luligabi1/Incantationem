package me.luligabi.incantationem.common.common.enchantment.curse;

import me.luligabi.incantationem.common.common.Incantationem;
import me.luligabi.incantationem.common.common.enchantment.IncantationemEnchantment;
import me.luligabi.incantationem.common.common.util.Util;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentHelper;

public class ToughLuckCurse extends IncantationemEnchantment {

    public ToughLuckCurse() {
        super(
            "tough_luck",
            Enchantment.definition(
                ItemTags.DURABILITY_ENCHANTABLE,
                5,
                1,
                Enchantment.dynamicCost(0, 25),
                Enchantment.dynamicCost(25, 50),
                2,
                EquipmentSlot.values()
            ),
            Incantationem.CONFIG.curses.toughLuck.availableRandomly,
            Incantationem.CONFIG.curses.toughLuck.availableForBookOffer,
            Incantationem.CONFIG.curses.toughLuck.availableAsTreasure
        );
    }

    @Override
    public boolean isCurse() {
        return true;
    }

    public static void apply(LivingEntity user) {
        if(EnchantmentHelper.getEnchantmentLevel(CurseRegistry.TOUGH_LUCK.get(), user) < 1) return;
        Util.applyEffectIfNotPresent(user, MobEffects.UNLUCK, 3, 0);
    }

}