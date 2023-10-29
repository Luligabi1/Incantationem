package me.luligabi.incantationem.common.enchantment;

import me.luligabi.incantationem.common.Incantationem;
import me.luligabi.incantationem.common.Util;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;

public class CriticalStrikeEnchantment extends IncantationemEnchantment {

    public CriticalStrikeEnchantment() {
        super(
                Rarity.RARE,
                EnchantmentTarget.WEAPON,
                new EquipmentSlot[]{EquipmentSlot.MAINHAND, EquipmentSlot.OFFHAND},
                Incantationem.CONFIG.criticalStrikeMaxLevel,
                Incantationem.CONFIG.criticalStrikeAvailableForBookOffer,
                Incantationem.CONFIG.criticalStrikeAvailableRandomly,
                Incantationem.CONFIG.criticalStrikeAvailableAsTreasure
        );
    }

    @Override
    public int getMinPower(int level) {
        return 10 + 30 * (level - 1);
    }

    @Override
    public int getMaxPower(int level) {
        return super.getMinPower(level) + 50;
    }

    @Override
    public int getMaxLevel() {
        return 3;
    }

    @Override
    public void onTargetDamaged(LivingEntity user, Entity target, int level) {
        if(Util.positiveEffectRandomNumber(user, user.getRandom(),0, 15 - (level * 3)) < 1) {
            if(target instanceof LivingEntity && ((LivingEntity) target).canTakeDamage()) {
                //Emits additional critical hit particles for a visual indicator that Critical Strike has been activated
                emitParticles((PlayerEntity) user, target);
                //Plays an audible indicator Critical Strike has been activated
                target.playSound(SoundEvents.ENTITY_ZOMBIE_BREAK_WOODEN_DOOR, 0.5f, 1.4f);
                //Should Critical Strike kill an entity, the credit will still be given to the enchantment holder
                target.damage(user.getDamageSources().mobAttack(user), 3f * level);
                Util.sendActionBarMessage(user, Text.translatable("message.incantationem.critical_strike.applied"), Formatting.DARK_PURPLE);
            }
        }
        super.onTargetDamaged(user, target, level);
    }

    public void emitParticles(PlayerEntity player, Entity target) {
        player.addCritParticles(target);
        player.addCritParticles(target);
        player.addCritParticles(target);
        player.addEnchantedHitParticles(target);
    }
}
