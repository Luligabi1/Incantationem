package me.luligabi.incantationem.common.common.enchantment.effecttype;

import com.mojang.serialization.MapCodec;
import me.luligabi.incantationem.common.common.Incantationem;
import me.luligabi.incantationem.common.common.util.EffectAppliedMessage;
import me.luligabi.incantationem.common.common.util.Util;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LightningBolt;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.enchantment.EnchantedItemInUse;
import net.minecraft.world.item.enchantment.effects.EnchantmentEntityEffect;
import net.minecraft.world.level.GameRules;
import net.minecraft.world.phys.Vec3;


public record Thunder() implements EnchantmentEntityEffect {

    private static final Thunder INSTANCE = new Thunder();
    public static final MapCodec<Thunder> CODEC = MapCodec.unit(INSTANCE);

    @Override
    public void apply(ServerLevel serverLevel, int i, EnchantedItemInUse enchantedItemInUse, Entity entity, Vec3 vec3) {
        LivingEntity user = enchantedItemInUse.owner();
        if(!Util.negativeEffectRandomNumber(
            user, user.getRandom(),
            (100 - Incantationem.CONFIG.curses.thunder.successRate),
            Incantationem.CONFIG.curses.thunder.isLuckBased
        )) return;

        LightningBolt lightningEntity = EntityType.LIGHTNING_BOLT.create(user.level());
        lightningEntity.setVisualOnly(!user.level().getGameRules().getBoolean(GameRules.RULE_MOBGRIEFING));
        lightningEntity.moveTo(user.blockPosition().getX(), user.blockPosition().getY(), user.blockPosition().getZ());
        user.level().addFreshEntity(lightningEntity);
        Util.sendEffectAppliedMessage(user, EffectAppliedMessage.THUNDER);

    }

    public MapCodec<Thunder> codec() {
        return CODEC;
    }
}