package me.luligabi.incantationem.enchantment;

import me.luligabi.incantationem.Util;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.Formatting;

public class RetreatEnchantment extends Enchantment {

    public RetreatEnchantment() {
        super(Rarity.UNCOMMON, EnchantmentTarget.ARMOR_LEGS, new EquipmentSlot[]{EquipmentSlot.LEGS});
    }

    public int getMinPower(int level) {
        return 10 + 20 * (level - 1);
    }

    public int getMaxPower(int level) {
        return super.getMinPower(level) + 50;
    }

    public int getMaxLevel() {
        return 1;
    }

    @Override
    public void onUserDamaged(LivingEntity user, Entity attacker, int level) {
        if(Util.positiveEffectRandomNumber(user, user.getRandom(),0, 10) < 2) {
            Util.applyEffectIfNotPresent(user, StatusEffects.SPEED, 7, 0);
            Util.sendActionBarMessage(user, new TranslatableText("message.incantationem.retreat.applied"), Formatting.AQUA);
        }
        super.onUserDamaged(user, attacker, level);
    }
}