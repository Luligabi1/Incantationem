package me.luligabi.incantationem.common.common.enchantment;

import me.luligabi.incantationem.common.common.Incantationem;
import me.luligabi.incantationem.common.common.util.EffectAppliedMessage;
import me.luligabi.incantationem.common.common.util.Util;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentCategory;

public class VenomousEnchantment extends IncantationemEnchantment {

    public VenomousEnchantment() {
        super(
            "venomous",
            Enchantment.Rarity.RARE,
            EnchantmentCategory.BOW,
            new EquipmentSlot[]{EquipmentSlot.MAINHAND, EquipmentSlot.OFFHAND},
            Incantationem.CONFIG.enchantments.venomous.maxLevel,
            Incantationem.CONFIG.enchantments.venomous.availableRandomly,
            Incantationem.CONFIG.enchantments.venomous.availableForBookOffer,
            Incantationem.CONFIG.enchantments.venomous.availableAsTreasure
        );
    }

    @Override
    public int getMinCost(int level) {
        return 5 + 20 * (level - 1);
    }

    @Override
    public int getMaxCost(int level) {
        return super.getMinCost(level) + 50;
    }

    public static void apply(LivingEntity attacker, LivingEntity hitEntity, int i) {
        if(i < 1) return;
        if(!Util.positiveEffectRandomNumber(attacker, attacker.getRandom(), (100 - (i * 15)), Incantationem.CONFIG.enchantments.venomous.isLuckBased)) return;

        Util.applyEffectIfNotPresent(hitEntity, MobEffects.POISON, hitEntity.getRandom().nextInt(i + 2), i - 1);
        Util.sendEffectAppliedMessage(attacker, EffectAppliedMessage.VENOMOUS);
    }

}