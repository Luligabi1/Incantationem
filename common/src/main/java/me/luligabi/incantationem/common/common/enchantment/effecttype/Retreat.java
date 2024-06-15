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


public record Retreat() implements EnchantmentEntityEffect {

    private static final Retreat INSTANCE = new Retreat();
    public static final MapCodec<Retreat> CODEC = MapCodec.unit(INSTANCE);

    @Override
    public void apply(ServerLevel serverLevel, int i, EnchantedItemInUse enchantedItemInUse, Entity entity, Vec3 vec3) {
        LivingEntity user = enchantedItemInUse.owner();
        if(!Util.positiveEffectRandomNumber(user, user.getRandom(), 80, Incantationem.CONFIG.enchantments.retreat.isLuckBased)) return;
        Util.applyEffectIfNotPresent(user, MobEffects.MOVEMENT_SPEED, 7, 0);
        Util.sendEffectAppliedMessage(user, EffectAppliedMessage.RETREAT);

    }

    public MapCodec<Retreat> codec() {
        return CODEC;
    }
}