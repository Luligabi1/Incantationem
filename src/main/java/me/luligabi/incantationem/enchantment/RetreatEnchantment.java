package me.luligabi.incantationem.enchantment;

import me.luligabi.incantationem.Util;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.text.Style;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.Formatting;

public class RetreatEnchantment extends Enchantment {

    public RetreatEnchantment() {
        super(Rarity.UNCOMMON, EnchantmentTarget.ARMOR_LEGS, new EquipmentSlot[]{EquipmentSlot.LEGS});
    }

    public int getMinPower(int level) {
        return 10 + 20 * (level - 1);
    }

    public int getMaxPower(int level) {
        return super.getMinPower(level) + 50;
    }

    public int getMaxLevel() {
        return 3;
    }

    @Override
    public void onUserDamaged(LivingEntity user, Entity attacker, int level) {
        if(Util.randomNumber(user.getRandom(),0, 10) < level*1.25) {
            if(!user.hasStatusEffect(StatusEffects.SPEED)) {
                user.addStatusEffect(new StatusEffectInstance(StatusEffects.SPEED, (5+(level*2))*20, level-1));
                if(user instanceof PlayerEntity) { //TODO: Add config setting to show message.
                    ((PlayerEntity) user).sendMessage(new TranslatableText("message.incantationem.retreat.applied").setStyle(Style.EMPTY.withColor(Formatting.GREEN)), true);
                }
            }
        }
        super.onUserDamaged(user, attacker, level);
    }
}