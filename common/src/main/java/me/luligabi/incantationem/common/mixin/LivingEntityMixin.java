package me.luligabi.incantationem.common.mixin;

import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import me.luligabi.incantationem.common.common.enchantment.*;
import me.luligabi.incantationem.common.common.enchantment.curse.ToughLuckCurse;
import net.minecraft.tags.DamageTypeTags;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(LivingEntity.class)
public abstract class LivingEntityMixin {


    @Inject(
        method = "baseTick",
        at = @At("RETURN")
    )
    public void injectBaseTick(CallbackInfo callbackInfo) {
        LivingEntity livingEntity = ((LivingEntity) (Object) this);

        int bunnysHopLevel = EnchantmentHelper.getEnchantmentLevel(EnchantmentRegistry.BUNNYS_HOP.get(), livingEntity);
        if(bunnysHopLevel > 0) {
            BunnysHopEnchantment.apply(livingEntity, bunnysHopLevel);
        }

        int magneticLevel = EnchantmentHelper.getEnchantmentLevel(EnchantmentRegistry.MAGNETIC.get(), livingEntity);
        if(magneticLevel > 0) {
            MagneticEnchantment.apply(livingEntity, livingEntity.level(), magneticLevel);
        }

        CharmedEnchantment.apply(livingEntity);
        ToughLuckCurse.apply(livingEntity);
    }

    @ModifyExpressionValue(
        method = "hurt",
        at = @At(
            value = "INVOKE",
            target = "Lnet/minecraft/world/entity/LivingEntity;isInvulnerableTo(Lnet/minecraft/world/damagesource/DamageSource;)Z"
        )
    )
    public boolean shouldDeflect(boolean original, DamageSource source, float amount) {
        if(!source.is(DamageTypeTags.IS_PROJECTILE)) return original;
        return DeflectionEnchantment.apply(((LivingEntity) (Object) this)) || original;
    }

}