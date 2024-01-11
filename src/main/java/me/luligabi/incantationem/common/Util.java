package me.luligabi.incantationem.common;

import me.luligabi.incantationem.common.enchantment.IncantationemEnchantment;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.text.MutableText;
import net.minecraft.text.Style;
import net.minecraft.util.Formatting;
import net.minecraft.util.math.random.Random;

public class Util {

    public static int positiveEffectRandomNumber(LivingEntity livingEntity, Random random, int min, int max){
        if(livingEntity.hasStatusEffect(StatusEffects.LUCK) && !livingEntity.hasStatusEffect(StatusEffects.UNLUCK)) {
            return random.nextInt(max - min) + min; // Lucky -  Increase chance of getting the effect
        } else if(livingEntity.hasStatusEffect(StatusEffects.UNLUCK) && !livingEntity.hasStatusEffect(StatusEffects.LUCK)) {
            return random.nextInt(max + 2 - min) + min; // Unlucky - Reduce chance of getting the effect
        } else {
            return random.nextInt(max + 1 - min) + min; // No Effect - Regular odds
        }
    }

    public static int neutralEffectRandomNumber(Random random, int min, int max) { return random.nextInt(max + 1 - min) + min; }

    public static int negativeEffectRandomNumber(LivingEntity livingEntity, Random random, int min, int max){
        if(livingEntity.hasStatusEffect(StatusEffects.LUCK) && !livingEntity.hasStatusEffect(StatusEffects.UNLUCK)) {
            return random.nextInt(max + 2 - min) + min; // Lucky - Reduce chance of getting the effect
        } else if(livingEntity.hasStatusEffect(StatusEffects.UNLUCK) && !livingEntity.hasStatusEffect(StatusEffects.LUCK)) {
            return random.nextInt(max - min) + min; // Unlucky - Increase chance of getting the effect
        } else {
            return random.nextInt(max + 1 - min) + min; // No Effect - Regular odds
        }
    }

    public static void applyEffectIfNotPresent(LivingEntity livingEntity, StatusEffect statusEffect, int duration, int strength) {
        if(livingEntity.hasStatusEffect(statusEffect)) return;
        livingEntity.addStatusEffect(new StatusEffectInstance(statusEffect, duration*20, strength, true, false));
    }

    public static void sendActionBarMessage(LivingEntity livingEntity, MutableText message, Formatting formatting) {
        if(!(livingEntity instanceof PlayerEntity)) return;
        ((PlayerEntity) livingEntity).sendMessage(message.setStyle(Style.EMPTY.withColor(formatting)), true);
    }


    public static Enchantment initEnchantment(IncantationemEnchantment enchantment) {
        return Registry.register(
            Registries.ENCHANTMENT,
            Incantationem.modId(enchantment.id),
            enchantment
        );
    }

    public static boolean isEnchantmentInTag(Enchantment enchantment, TagKey<Enchantment> tag) {
        return Registries.ENCHANTMENT.getEntry(enchantment).isIn(tag);
    }

}