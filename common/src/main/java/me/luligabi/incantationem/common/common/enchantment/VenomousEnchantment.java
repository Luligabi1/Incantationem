package me.luligabi.incantationem.common.common.enchantment;

import me.luligabi.incantationem.common.common.Incantationem;
import me.luligabi.incantationem.common.common.util.EffectAppliedMessage;
import me.luligabi.incantationem.common.common.util.Util;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.enchantment.Enchantment;

public class VenomousEnchantment extends IncantationemEnchantment {

    public VenomousEnchantment() {
        super(
            "venomous",
            Enchantment.definition(
                ItemTags.BOW_ENCHANTABLE,
                5,
                Incantationem.CONFIG.enchantments.venomous.maxLevel,
                Enchantment.dynamicCost(5, 20),
                Enchantment.dynamicCost(25, 50),
                2,
                EquipmentSlot.MAINHAND, EquipmentSlot.OFFHAND
            ),
            Incantationem.CONFIG.enchantments.venomous.availableRandomly,
            Incantationem.CONFIG.enchantments.venomous.availableForBookOffer,
            Incantationem.CONFIG.enchantments.venomous.availableAsTreasure
        );
    }

    public static void apply(LivingEntity attacker, LivingEntity hitEntity, int i) {
        if(i < 1) return;
        if(!Util.positiveEffectRandomNumber(attacker, attacker.getRandom(), (100 - (i * 15)), Incantationem.CONFIG.enchantments.venomous.isLuckBased)) return;

        Util.applyEffectIfNotPresent(hitEntity, MobEffects.POISON, hitEntity.getRandom().nextInt(i + 2), i - 1);
        Util.sendEffectAppliedMessage(attacker, EffectAppliedMessage.VENOMOUS);
    }

}