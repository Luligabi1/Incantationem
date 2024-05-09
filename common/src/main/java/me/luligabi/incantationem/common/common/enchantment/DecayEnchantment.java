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

public class DecayEnchantment extends IncantationemEnchantment {

    public DecayEnchantment() {
        super(
            "decay",
            Enchantment.definition(
                ItemTags.SHARP_WEAPON_ENCHANTABLE,
                5,
                Incantationem.CONFIG.enchantments.decay.maxLevel,
                Enchantment.dynamicCost(10, 30),
                Enchantment.dynamicCost(40, 50),
                2,
                EquipmentSlot.MAINHAND, EquipmentSlot.OFFHAND
            ),
            Incantationem.CONFIG.enchantments.decay.availableRandomly,
            Incantationem.CONFIG.enchantments.decay.availableForBookOffer,
            Incantationem.CONFIG.enchantments.decay.availableAsTreasure
        );
    }

    @Override
    public void doPostAttack(LivingEntity user, Entity attacker, int level) {
        if(!(attacker instanceof LivingEntity)) return;
        if(!Util.positiveEffectRandomNumber(user, user.getRandom(), 85, Incantationem.CONFIG.enchantments.decay.isLuckBased)) return;
        Util.applyEffectIfNotPresent((LivingEntity) attacker, MobEffects.WITHER, 3 + level, level - 1);
        Util.sendEffectAppliedMessage(user, EffectAppliedMessage.DECAY);
    }

}