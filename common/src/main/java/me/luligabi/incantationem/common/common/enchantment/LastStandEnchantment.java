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


public class LastStandEnchantment extends IncantationemEnchantment {

    public LastStandEnchantment() {
        super(
            "last_stand",
            Enchantment.definition(
                ItemTags.CHEST_ARMOR_ENCHANTABLE,
                5,
                Incantationem.CONFIG.enchantments.lastStand.maxLevel,
                Enchantment.dynamicCost(10, 20),
                Enchantment.constantCost(50),
                2,
                EquipmentSlot.CHEST
            ),
            Incantationem.CONFIG.enchantments.lastStand.availableRandomly,
            Incantationem.CONFIG.enchantments.lastStand.availableForBookOffer,
            Incantationem.CONFIG.enchantments.lastStand.availableAsTreasure
        );
    }

    @Override
    public void doPostHurt(LivingEntity user, Entity attacker, int i) {
        if(user.getHealth() >= 5) return;
        if(!Util.positiveEffectRandomNumber(user, user.getRandom(), (100 - (i * 30)), Incantationem.CONFIG.enchantments.lastStand.isLuckBased)) return;
        Util.applyEffectIfNotPresent(user, MobEffects.DAMAGE_BOOST, (int) Math.ceil(i * 2.5), i - 1);
        Util.sendEffectAppliedMessage(user, EffectAppliedMessage.LAST_STAND);
    }

}