package me.luligabi.incantationem.common.common.enchantment;

import me.luligabi.incantationem.common.common.Incantationem;
import me.luligabi.incantationem.common.common.util.EffectAppliedMessage;
import me.luligabi.incantationem.common.common.util.Util;
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
            Incantationem.CONFIG.enchantments.decay.maxLevel,
            Incantationem.CONFIG.enchantments.decay.availableRandomly,
            Incantationem.CONFIG.enchantments.decay.availableForBookOffer,
            Incantationem.CONFIG.enchantments.decay.availableAsTreasure
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
        if(!(attacker instanceof LivingEntity)) return;
        if(!Util.positiveEffectRandomNumber(user, user.getRandom(), 85, Incantationem.CONFIG.enchantments.decay.isLuckBased)) return;
        Util.applyEffectIfNotPresent((LivingEntity) attacker, MobEffects.WITHER, 3 + level, level - 1);
        Util.sendEffectAppliedMessage(user, EffectAppliedMessage.DECAY);
    }

}