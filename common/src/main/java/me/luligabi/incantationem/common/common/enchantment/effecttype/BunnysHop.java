package me.luligabi.incantationem.common.common.enchantment.effecttype;

import com.mojang.serialization.MapCodec;
import me.luligabi.incantationem.common.common.util.Util;
import me.luligabi.incantationem.common.mixin.EntityInvoker;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.enchantment.EnchantedItemInUse;
import net.minecraft.world.item.enchantment.effects.EnchantmentEntityEffect;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;

public record BunnysHop() implements EnchantmentEntityEffect {

    private static final BunnysHop INSTANCE = new BunnysHop();
    public static final MapCodec<BunnysHop> CODEC = MapCodec.unit(INSTANCE);

    @Override
    public void apply(ServerLevel arg, int i, EnchantedItemInUse arg2, Entity entity, Vec3 arg4) {
        if(entity instanceof LivingEntity user) {
            if(user.hasEffect(MobEffects.JUMP)) return;
            BlockState floor = user.level().getBlockState(((EntityInvoker) user).invokeGetVelocityAffectingPos());

            if(floor.is(BlockTags.DIRT)) {
                Util.applyEffectIfNotPresent(user, MobEffects.JUMP, 4, i - 1);
            }
        }
    }

    public MapCodec<BunnysHop> codec() {
        return CODEC;
    }

}