package me.luligabi.incantationem.enchantment;

import me.luligabi.incantationem.Util;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.Formatting;

public class ReapingRodEnchantment extends Enchantment {

    public ReapingRodEnchantment() {
        super(Rarity.VERY_RARE, EnchantmentTarget.FISHING_ROD, new EquipmentSlot[]{EquipmentSlot.MAINHAND, EquipmentSlot.OFFHAND});
    }

    public int getMinPower(int level) { return 29; }

    public int getMaxPower(int level) {
        return 50;
    }

    public int getMaxLevel() {
        return 1;
    }

    @Override
    public void onTargetDamaged(LivingEntity user, Entity target, int level) {
        if(target instanceof HostileEntity) {
            if(((LivingEntity) target).getHealth() <= 0.5) {
                Util.applyEffectIfNotPresent(user, StatusEffects.REGENERATION, 10, 1);
                Util.applyEffectIfNotPresent(user, StatusEffects.ABSORPTION, 25, 2);
                Util.applyEffectIfNotPresent(user, StatusEffects.RESISTANCE, 30, 0);
                Util.sendActionBarMessage(user, new TranslatableText("message.incantationem.reaping_rod.applied"), Formatting.LIGHT_PURPLE);
            }
        }
        super.onTargetDamaged(user, target, level);
    }
}