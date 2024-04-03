package me.luligabi.incantationem.common.common.enchantment;

import me.luligabi.incantationem.common.common.Incantationem;
import me.luligabi.incantationem.common.common.Util;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.enchantment.EnchantmentCategory;

public class DecayEnchantment extends IncantationemEnchantment {

    public DecayEnchantment() {
        super(
            "decay",
            Rarity.RARE,
            EnchantmentCategory.WEAPON,
            new EquipmentSlot[]{EquipmentSlot.MAINHAND, EquipmentSlot.OFFHAND},
            Incantationem.CONFIG.decayMaxLevel,
            Incantationem.CONFIG.decayAvailableForBookOffer,
            Incantationem.CONFIG.decayAvailableRandomly,
            Incantationem.CONFIG.decayAvailableAsTreasure
        );
    }

    @Override
    public int getMinCost(int level) {
        return 10 + 30 * (level - 1);
    }

    @Override
    public int getMaxCost(int level) {
        return super.getMinCost(level) + 50;
    }

    @Override
    public int getMaxLevel() {
        return 3;
    }

    @Override
    public void doPostAttack(LivingEntity user, Entity attacker, int level) {
        if(Util.positiveEffectRandomNumber(user, user.getRandom(),0, 10) < 1) {
            if(attacker instanceof LivingEntity) {
                Util.applyEffectIfNotPresent((LivingEntity) attacker, MobEffects.WITHER, 3 + level, level - 1);
                Util.sendActionBarMessage(user, Component.translatable("message.incantationem.decay.applied"), ChatFormatting.GRAY);
            }
        }
        super.doPostAttack(user, attacker, level);
    }

}