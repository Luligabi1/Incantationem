package me.luligabi.incantationem.common.common.enchantment;

import me.luligabi.incantationem.common.common.Incantationem;
import me.luligabi.incantationem.common.common.util.EffectAppliedMessage;
import me.luligabi.incantationem.common.common.util.Util;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.enchantment.Enchantment;

public class RetreatEnchantment extends IncantationemEnchantment {

    public RetreatEnchantment() {
        super(
            "retreat",
            Enchantment.definition(
                ItemTags.LEG_ARMOR_ENCHANTABLE,
                5,
                1,
                Enchantment.dynamicCost(10, 20),
                Enchantment.dynamicCost(30, 50),
                2,
                EquipmentSlot.LEGS
            ),
            Incantationem.CONFIG.enchantments.retreat.availableRandomly,
            Incantationem.CONFIG.enchantments.retreat.availableForBookOffer,
            Incantationem.CONFIG.enchantments.retreat.availableAsTreasure
        );
    }

    @Override
    public void doPostHurt(LivingEntity user, Entity attacker, int level) {
        if(!Util.positiveEffectRandomNumber(user, user.getRandom(), 80, Incantationem.CONFIG.enchantments.retreat.isLuckBased))
            return;
        Util.applyEffectIfNotPresent(user, MobEffects.MOVEMENT_SPEED, 7, 0);
        Util.sendEffectAppliedMessage(user, EffectAppliedMessage.RETREAT);
    }

}