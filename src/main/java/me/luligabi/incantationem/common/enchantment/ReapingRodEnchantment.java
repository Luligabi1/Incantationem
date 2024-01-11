package me.luligabi.incantationem.common.enchantment;

import me.luligabi.incantationem.common.Incantationem;
import me.luligabi.incantationem.common.Util;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;

public class ReapingRodEnchantment extends IncantationemEnchantment {

    public ReapingRodEnchantment() {
        super(
            "reaping_rod",
            Rarity.VERY_RARE,
            EnchantmentTarget.FISHING_ROD,
            new EquipmentSlot[]{EquipmentSlot.MAINHAND, EquipmentSlot.OFFHAND},
            Incantationem.CONFIG.reapingRodAvailableForBookOffer,
            Incantationem.CONFIG.reapingRodAvailableRandomly,
            Incantationem.CONFIG.reapingRodAvailableAsTreasure
        );
    }

    @Override
    public int getMinPower(int level) { return 29; }

    @Override
    public int getMaxPower(int level) {
        return 50;
    }

    @Override
    public void onTargetDamaged(LivingEntity user, Entity target, int level) {
        if(target instanceof HostileEntity) {
            if(((LivingEntity) target).getHealth() <= 0.25) {
                Util.applyEffectIfNotPresent(user, StatusEffects.REGENERATION, 10, 1);
                Util.applyEffectIfNotPresent(user, StatusEffects.ABSORPTION, 25, 2);
                Util.applyEffectIfNotPresent(user, StatusEffects.RESISTANCE, 30, 0);
                Util.sendActionBarMessage(user, Text.translatable("message.incantationem.reaping_rod.applied"), Formatting.LIGHT_PURPLE);
            }
        }
        super.onTargetDamaged(user, target, level);
    }

}