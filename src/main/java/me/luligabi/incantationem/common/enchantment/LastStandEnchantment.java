package me.luligabi.incantationem.common.enchantment;

import me.luligabi.incantationem.common.Incantationem;
import me.luligabi.incantationem.common.Util;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;

public class LastStandEnchantment extends IncantationemEnchantment {

    public LastStandEnchantment() {
        super(
            "last_stand",
            Enchantment.Rarity.RARE,
            EnchantmentTarget.ARMOR_CHEST,
            new EquipmentSlot[]{EquipmentSlot.CHEST},
            Incantationem.CONFIG.lastStandMaxLevel,
            Incantationem.CONFIG.lastStandAvailableForBookOffer,
            Incantationem.CONFIG.lastStandAvailableRandomly,
            Incantationem.CONFIG.lastStandAvailableAsTreasure
        );
    }

    @Override
    public int getMinPower(int level) { return 10 + 20 * (level - 1); }

    @Override
    public int getMaxPower(int level) {
        return 50;
    }

    @Override
    public void onUserDamaged(LivingEntity user, Entity attacker, int level) {
        if (user.getHealth() <= 4) {
            if (Util.positiveEffectRandomNumber(user, user.getRandom(), 0, 10) < level*0.35) {
                Util.applyEffectIfNotPresent(user, StatusEffects.STRENGTH, (int) Math.ceil(level * 2.5), level-1);
                Util.sendActionBarMessage(user, Text.translatable("message.incantationem.last_stand.applied"), Formatting.GOLD);
            }
            super.onUserDamaged(user, attacker, level);
        }
    }

}