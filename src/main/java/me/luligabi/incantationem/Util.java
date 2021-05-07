package me.luligabi.incantationem;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.text.Style;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.Formatting;

import java.util.Random;

public class Util {

    public static int randomNumber(Random random, int min, int max){
        return random.nextInt(max + 1 - min) + min;
    }

    public static void applyEffectIfNotPresent(LivingEntity livingEntity, StatusEffect statusEffect, int duration, int strength) {
        if(livingEntity.hasStatusEffect(statusEffect)) return;
        livingEntity.addStatusEffect(new StatusEffectInstance(statusEffect, duration*20, strength));
    }

    public static void sendActionBarMessage(LivingEntity livingEntity, TranslatableText message, Formatting formatting) {
        if(!(livingEntity instanceof PlayerEntity)) return;
        ((PlayerEntity) livingEntity).sendMessage(message.setStyle(Style.EMPTY.withColor(formatting)), true);
    }
}