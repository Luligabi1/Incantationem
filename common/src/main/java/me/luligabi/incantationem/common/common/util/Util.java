package me.luligabi.incantationem.common.common.util;

import me.luligabi.incantationem.common.common.packet.EffectAppliedPacket;
import me.luligabi.incantationem.common.common.packet.NetworkRegistry;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.tags.TagKey;
import net.minecraft.util.RandomSource;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.enchantment.Enchantment;

public class Util {

    public static boolean positiveEffectRandomNumber(LivingEntity livingEntity, RandomSource random, int failureOdds, boolean isLuckBased) {
        return effectBasedLuckRandomNumber(
            livingEntity,
            random,
            positiveRandomNumber(random),
            negativeRandomNumber(random),
            failureOdds,
            isLuckBased
        );
    }

    public static boolean negativeEffectRandomNumber(LivingEntity livingEntity, RandomSource random, int failureOdds, boolean isLuckBased) {
        return effectBasedLuckRandomNumber(
            livingEntity,
            random,
            negativeRandomNumber(random),
            positiveRandomNumber(random),
            failureOdds,
            isLuckBased
        );
    }

    public static boolean neutralEffectRandomNumber(RandomSource random, int failureOdds, boolean isLuckBased) {
        return !isLuckBased || (neutralRandomNumber(random) > failureOdds);
    }

    public static void applyEffectIfNotPresent(LivingEntity livingEntity, Holder<MobEffect> statusEffect, int duration, int strength) {
        if(livingEntity.hasEffect(statusEffect)) return;
        livingEntity.addEffect(new MobEffectInstance(statusEffect, duration * 20, strength, true, false));
    }

    public static void sendEffectAppliedMessage(LivingEntity entity, EffectAppliedMessage msg) {
        if(!(entity instanceof ServerPlayer)) return;
        if(!msg.canShow) return;
        NetworkRegistry.NETWORK_CHANNEL.sendToPlayer(
            (ServerPlayer) entity,
            new EffectAppliedPacket(msg)
        );
    }

    public static boolean isEnchantmentInTag(Enchantment enchantment, TagKey<Enchantment> tag) {
        return BuiltInRegistries.ENCHANTMENT.wrapAsHolder(enchantment).is(tag);
    }

    private static boolean effectBasedLuckRandomNumber(LivingEntity livingEntity, RandomSource random, int luckOdds, int unluckyOdds, int failureOdds, boolean isLuckBased) {
        if(hasOnlyOneEffect(livingEntity, MobEffects.LUCK, MobEffects.UNLUCK)) {
            return !isLuckBased || (luckOdds > failureOdds);
        } else if(hasOnlyOneEffect(livingEntity, MobEffects.UNLUCK, MobEffects.LUCK)) {
            return !isLuckBased || (unluckyOdds > failureOdds);
        } else {
            return !isLuckBased || (neutralRandomNumber(random) > failureOdds);
        }
    }

    private static boolean hasOnlyOneEffect(LivingEntity livingEntity, Holder<MobEffect> has, Holder<MobEffect> hasnt) {
        return livingEntity.hasEffect(has) && !livingEntity.hasEffect(hasnt);
    }

    private static int positiveRandomNumber(RandomSource random) {
        return random.nextInt(111);
    }

    private static int negativeRandomNumber(RandomSource random) {
        return random.nextInt(91);
    }

    private static int neutralRandomNumber(RandomSource random) {
        return random.nextInt(101);
    }

}