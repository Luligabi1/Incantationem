package me.luligabi.incantationem.common.common.enchantment;

import me.luligabi.incantationem.common.common.Incantationem;
import me.luligabi.incantationem.common.common.util.EffectAppliedMessage;
import me.luligabi.incantationem.common.common.util.Util;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.enchantment.EnchantmentCategory;

public class RetreatEnchantment extends IncantationemEnchantment {

    public RetreatEnchantment() {
        super(
            "retreat",
            Rarity.UNCOMMON,
            EnchantmentCategory.ARMOR_LEGS,
            new EquipmentSlot[]{EquipmentSlot.LEGS},
            Incantationem.CONFIG.enchantments.retreat.availableForBookOffer,
            Incantationem.CONFIG.enchantments.retreat.availableRandomly,
            Incantationem.CONFIG.enchantments.retreat.availableAsTreasure
        );
    }

    @Override
    public int getMinCost(int level) {
        return 10 + 20 * (level - 1);
    }

    @Override
    public int getMaxCost(int level) {
        return super.getMinCost(level) + 50;
    }

    @Override
    public void doPostHurt(LivingEntity user, Entity attacker, int level) {
        if(Util.positiveEffectRandomNumber(user, user.getRandom(),0, 10) < 2) {
            Util.applyEffectIfNotPresent(user, MobEffects.MOVEMENT_SPEED, 7, 0);
            Util.sendEffectAppliedMessage(user, EffectAppliedMessage.RETREAT);
        }
    }

}