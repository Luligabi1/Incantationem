package me.luligabi.incantationem.common.common;

import net.minecraft.ChatFormatting;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.network.chat.Style;
import net.minecraft.tags.TagKey;
import net.minecraft.util.RandomSource;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.enchantment.Enchantment;

public class Util {

    public static int positiveEffectRandomNumber(LivingEntity livingEntity, RandomSource random, int min, int max){
        return effectBasedLuckRandomNumber(
                livingEntity,
                random,
                min, max,
                random.nextInt(max - min) + min,
                random.nextInt(max + 2 - min) + min
        );
    }

    public static int negativeEffectRandomNumber(LivingEntity livingEntity, RandomSource random, int min, int max){
        return effectBasedLuckRandomNumber(
                livingEntity,
                random,
                min, max,
                random.nextInt(max + 2 - min) + min,
                random.nextInt(max - min) + min
        );
    }

    public static int neutralEffectRandomNumber(RandomSource random, int min, int max) {
        return random.nextInt(max + 1 - min) + min;
    }

    public static void applyEffectIfNotPresent(LivingEntity livingEntity, MobEffect statusEffect, int duration, int strength) {
        if(livingEntity.hasEffect(statusEffect)) return;
        livingEntity.addEffect(new MobEffectInstance(statusEffect, duration * 20, strength, true, false));
    }

    public static void sendActionBarMessage(LivingEntity livingEntity, MutableComponent message, ChatFormatting formatting) {
        if(!(livingEntity instanceof Player)) return;
        ((Player) livingEntity).displayClientMessage(message.setStyle(Style.EMPTY.withColor(formatting)), true);
    }


    public static boolean isEnchantmentInTag(Enchantment enchantment, TagKey<Enchantment> tag) {
        return BuiltInRegistries.ENCHANTMENT.wrapAsHolder(enchantment).is(tag);
    }

    private static int effectBasedLuckRandomNumber(LivingEntity livingEntity, RandomSource random, int min, int max, int luckOdds, int unluckyOdds){
        if(hasOnlyOneEffect(livingEntity, MobEffects.LUCK, MobEffects.UNLUCK)) {
            return luckOdds;
        } else if(hasOnlyOneEffect(livingEntity, MobEffects.UNLUCK, MobEffects.LUCK)) {
            return unluckyOdds;
        } else {
            return neutralEffectRandomNumber(random, min, max);
        }
    }

    private static boolean hasOnlyOneEffect(LivingEntity livingEntity, MobEffect has, MobEffect hasnt) {
        return livingEntity.hasEffect(has) && !livingEntity.hasEffect(hasnt);
    }

}