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


public record LastStand() implements EnchantmentEntityEffect {

    private static final LastStand INSTANCE = new LastStand();
    public static final MapCodec<LastStand> CODEC = MapCodec.unit(INSTANCE);

    @Override
    public void apply(ServerLevel serverLevel, int i, EnchantedItemInUse enchantedItemInUse, Entity entity, Vec3 vec3) {
        LivingEntity user = enchantedItemInUse.owner();
        if(user.getHealth() >= 5) return;
        if(!Util.positiveEffectRandomNumber(user, user.getRandom(), (100 - (i * 30)), Incantationem.CONFIG.enchantments.lastStand.isLuckBased)) return;
        Util.applyEffectIfNotPresent(user, MobEffects.DAMAGE_BOOST, (int) Math.ceil(i * 2.5), i - 1);
        Util.sendEffectAppliedMessage(user, EffectAppliedMessage.LAST_STAND);
    }

    public MapCodec<LastStand> codec() {
        return CODEC;
    }
}