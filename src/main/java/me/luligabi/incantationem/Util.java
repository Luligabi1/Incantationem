package me.luligabi.incantationem;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;

import java.util.Random;

public class Util {

    public static int randomNumber(Random random, int min, int max){
        return random.nextInt(max + 1 - min) + min;
    }

    public static void applyEffectIfNotPresent(LivingEntity livingEntity, StatusEffect statusEffect, int duration, int strength) {
        if(!livingEntity.hasStatusEffect(statusEffect)) {
            livingEntity.addStatusEffect(new StatusEffectInstance(statusEffect, duration*20, strength));
        }
    }
}
