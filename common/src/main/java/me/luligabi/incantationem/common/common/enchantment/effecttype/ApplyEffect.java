package me.luligabi.incantationem.common.common.enchantment.effecttype;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import me.luligabi.incantationem.common.common.util.Util;
import net.minecraft.core.Holder;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.enchantment.EnchantedItemInUse;
import net.minecraft.world.item.enchantment.effects.EnchantmentEntityEffect;
import net.minecraft.world.phys.Vec3;

public record ApplyEffect(Holder<MobEffect> effect) implements EnchantmentEntityEffect {
    public static final MapCodec<ApplyEffect> CODEC = RecordCodecBuilder.mapCodec((instance) ->
        instance.group(MobEffect.CODEC.fieldOf("effect").forGetter((arg) -> arg.effect))
        .apply(instance, ApplyEffect::new));

    @Override
    public void apply(ServerLevel arg, int i, EnchantedItemInUse arg2, Entity entity, Vec3 arg4) {
        if(entity instanceof LivingEntity user) {
            Util.applyEffectIfNotPresent(user, effect, 3, 0);
        }
    }

    public MapCodec<ApplyEffect> codec() {
        return CODEC;
    }

    public Holder<MobEffect> effect() {
        return effect;
    }
}