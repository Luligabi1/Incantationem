package me.luligabi.incantationem.common.common.enchantment;

import me.luligabi.incantationem.common.common.Incantationem;
import me.luligabi.incantationem.common.common.util.EffectAppliedMessage;
import me.luligabi.incantationem.common.common.util.Util;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.enchantment.EnchantmentCategory;


public class LastStandEnchantment extends IncantationemEnchantment {

    public LastStandEnchantment() {
        super(
            "last_stand",
            Rarity.RARE,
            EnchantmentCategory.ARMOR_CHEST,
            new EquipmentSlot[]{EquipmentSlot.CHEST},
            Incantationem.CONFIG.enchantments.lastStand.maxLevel,
            Incantationem.CONFIG.enchantments.lastStand.availableRandomly,
            Incantationem.CONFIG.enchantments.lastStand.availableForBookOffer,
            Incantationem.CONFIG.enchantments.lastStand.availableAsTreasure
        );
    }

    @Override
    public int getMinCost(int level) {
        return 10 + 20 * (level - 1);
    }

    @Override
    public int getMaxCost(int level) {
        return 50;
    }

    @Override
    public void doPostHurt(LivingEntity user, Entity attacker, int i) {
        if(user.getHealth() >= 5) return;
        if(!Util.positiveEffectRandomNumber(user, user.getRandom(), (100 - (i * 30)), Incantationem.CONFIG.enchantments.lastStand.isLuckBased)) return;
        Util.applyEffectIfNotPresent(user, MobEffects.DAMAGE_BOOST, (int) Math.ceil(i * 2.5), i - 1);
        Util.sendEffectAppliedMessage(user, EffectAppliedMessage.LAST_STAND);
    }

}