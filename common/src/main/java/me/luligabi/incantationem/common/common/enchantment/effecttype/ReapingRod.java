package me.luligabi.incantationem.common.common.enchantment.effecttype;

import com.mojang.serialization.MapCodec;
import me.luligabi.incantationem.common.common.Incantationem;
import me.luligabi.incantationem.common.common.util.EffectAppliedMessage;
import me.luligabi.incantationem.common.common.util.Util;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.item.enchantment.EnchantedItemInUse;
import net.minecraft.world.item.enchantment.effects.EnchantmentEntityEffect;
import net.minecraft.world.phys.Vec3;


public record ReapingRod() implements EnchantmentEntityEffect {

    private static final ReapingRod INSTANCE = new ReapingRod();
    public static final MapCodec<ReapingRod> CODEC = MapCodec.unit(INSTANCE);

    @Override
    public void apply(ServerLevel serverLevel, int i, EnchantedItemInUse enchantedItemInUse, Entity entity, Vec3 vec3) {
        if(entity instanceof Monster attacker) {
            if(attacker.getHealth() > 0.25) return;
            LivingEntity user = enchantedItemInUse.owner();
            Util.applyEffectIfNotPresent(user, MobEffects.REGENERATION, 10, 1);
            Util.applyEffectIfNotPresent(user, MobEffects.ABSORPTION, 25, 2);
            Util.applyEffectIfNotPresent(user, MobEffects.DAMAGE_RESISTANCE, 30, 0);
            Util.sendEffectAppliedMessage(user, EffectAppliedMessage.REAPING_ROD);
        }
    }

    public MapCodec<ReapingRod> codec() {
        return CODEC;
    }
}