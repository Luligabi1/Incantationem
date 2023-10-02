package me.luligabi.incantationem.mixin;

import me.luligabi.incantationem.common.Util;
import me.luligabi.incantationem.common.enchantment.MagneticEnchantment;
import me.luligabi.incantationem.common.enchantment.curse.CurseRegistry;
import me.luligabi.incantationem.common.enchantment.EnchantmentRegistry;
import me.luligabi.incantationem.common.tag.TagRegistry;
import net.minecraft.block.BlockState;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffects;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(LivingEntity.class)
public abstract class LivingEntityMixin {


    @Inject(method = "baseTick",
            at = @At("RETURN"),
            cancellable = true)
    public void injectBaseTick(CallbackInfo callbackInfo) {
        LivingEntity livingEntity = ((LivingEntity) (Object) this);

        int bunnysHopLevel = EnchantmentHelper.getEquipmentLevel(EnchantmentRegistry.BUNNYS_HOP, livingEntity);

        int charmedLevel = EnchantmentHelper.getEquipmentLevel(EnchantmentRegistry.CHARMED, livingEntity);

        int magneticLevel = EnchantmentHelper.getEquipmentLevel(EnchantmentRegistry.MAGNETIC, livingEntity);

        int toughLuckLevel = EnchantmentHelper.getEquipmentLevel(CurseRegistry.TOUGH_LUCK, livingEntity);

        if(bunnysHopLevel > 0) {
            if(livingEntity.hasStatusEffect(StatusEffects.JUMP_BOOST)) return;
            BlockState floor = livingEntity.getWorld().getBlockState(((EntityInvoker) livingEntity).invokeGetVelocityAffectingPos());

            if(floor.isIn(TagRegistry.COMMON_DIRT)) {
                Util.applyEffectIfNotPresent(livingEntity, StatusEffects.JUMP_BOOST, 4, bunnysHopLevel-1);
            }
            callbackInfo.cancel();
        }
        if(charmedLevel > 0) {
            Util.applyEffectIfNotPresent(livingEntity, StatusEffects.LUCK, 3, 0);
            callbackInfo.cancel();
        }
        if(magneticLevel > 0) {
            MagneticEnchantment.magnetize(livingEntity, livingEntity.getEntityWorld(), magneticLevel);
            callbackInfo.cancel();
        }
        if(toughLuckLevel > 0) {
            Util.applyEffectIfNotPresent(livingEntity, StatusEffects.UNLUCK, 3, 0);
            callbackInfo.cancel();
        }
    }

}