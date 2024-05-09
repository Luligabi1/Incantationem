package me.luligabi.incantationem.common.common.enchantment;

import me.luligabi.incantationem.common.common.Incantationem;
import me.luligabi.incantationem.common.common.util.EffectAppliedMessage;
import me.luligabi.incantationem.common.common.util.Util;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.item.enchantment.Enchantment;


public class ReapingRodEnchantment extends IncantationemEnchantment {

    public ReapingRodEnchantment() {
        super(
            "reaping_rod",
            Enchantment.definition(
                ItemTags.FISHING_ENCHANTABLE,
                5,
                1,
                Enchantment.constantCost(29),
                Enchantment.constantCost(50),
                2,
                EquipmentSlot.MAINHAND, EquipmentSlot.OFFHAND
            ),
            Incantationem.CONFIG.enchantments.reapingRod.availableRandomly,
            Incantationem.CONFIG.enchantments.reapingRod.availableForBookOffer,
            Incantationem.CONFIG.enchantments.reapingRod.availableAsTreasure
        );
    }

    @Override
    public void doPostAttack(LivingEntity user, Entity target, int level) {
        if(!(target instanceof Monster)) return;
        if(((LivingEntity) target).getHealth() > 0.25) return;
        Util.applyEffectIfNotPresent(user, MobEffects.REGENERATION, 10, 1);
        Util.applyEffectIfNotPresent(user, MobEffects.ABSORPTION, 25, 2);
        Util.applyEffectIfNotPresent(user, MobEffects.DAMAGE_RESISTANCE, 30, 0);
        Util.sendEffectAppliedMessage(user, EffectAppliedMessage.REAPING_ROD);
    }

}