package me.luligabi.incantationem.common.common.enchantment.effecttype;

import com.mojang.serialization.MapCodec;
import me.luligabi.incantationem.common.common.Incantationem;
import me.luligabi.incantationem.common.common.util.EffectAppliedMessage;
import me.luligabi.incantationem.common.common.util.Util;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.enchantment.EnchantedItemInUse;
import net.minecraft.world.item.enchantment.effects.EnchantmentEntityEffect;
import net.minecraft.world.phys.Vec3;


public record Decay() implements EnchantmentEntityEffect {

    private static final Decay INSTANCE = new Decay();
    public static final MapCodec<Decay> CODEC = MapCodec.unit(INSTANCE);

    @Override
    public void apply(ServerLevel serverLevel, int i, EnchantedItemInUse enchantedItemInUse, Entity entity, Vec3 vec3) {
        if(entity instanceof LivingEntity attacker) {
            LivingEntity user = enchantedItemInUse.owner();
            if(!Util.positiveEffectRandomNumber(user, user.getRandom(), 85, Incantationem.CONFIG.enchantments.decay.isLuckBased)) return;
            Util.applyEffectIfNotPresent(attacker, MobEffects.WITHER, 3 + i, i - 1);
            Util.sendEffectAppliedMessage(user, EffectAppliedMessage.DECAY);
        }
    }

    public MapCodec<Decay> codec() {
        return CODEC;
    }
}