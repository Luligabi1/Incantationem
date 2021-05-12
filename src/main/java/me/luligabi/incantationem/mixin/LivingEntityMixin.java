package me.luligabi.incantationem.mixin;

import me.luligabi.incantationem.Util;
import me.luligabi.incantationem.enchantment.MagneticEnchantment;
import me.luligabi.incantationem.registry.EnchantmentRegistry;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffects;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(LivingEntity.class)
public abstract class LivingEntityMixin {

    // Mixin used to magnetize objects near player if using magnetic enchantment
    @Inject(method = "baseTick",
            at = @At("RETURN"),
            cancellable = true)
    public void injectBaseTick(CallbackInfo callbackInfo) {
        LivingEntity livingEntity = ((LivingEntity) (Object) this);

        int bunnysHopLevel = EnchantmentHelper.getEquipmentLevel(EnchantmentRegistry.BUNNYS_HOP, livingEntity);

        int magneticLevel = EnchantmentHelper.getEquipmentLevel(EnchantmentRegistry.MAGNETIC, livingEntity);

        if(bunnysHopLevel > 0) {
            Util.applyEffectIfNotPresent(livingEntity, StatusEffects.JUMP_BOOST, 3, bunnysHopLevel-1);
            callbackInfo.cancel();
        }
        if(magneticLevel > 0) {
            MagneticEnchantment.magnetize(livingEntity, livingEntity.getEntityWorld(), magneticLevel);
            callbackInfo.cancel();
        }

    }
}
