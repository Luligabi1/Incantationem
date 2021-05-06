package me.luligabi.incantationem.mixin;

import me.luligabi.incantationem.enchantment.MagneticEnchantment;
import me.luligabi.incantationem.registry.EnchantmentRegistry;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.LivingEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(LivingEntity.class)
public abstract class LivingEntityMixin {

    // Mixin used to magnetize objects near player if using magnetic enchantment
    @Inject(method = "baseTick", at = @At("RETURN"), cancellable = true)
    public void injectBaseTick(CallbackInfo callbackInfo) {
        LivingEntity livingEntity = ((LivingEntity) (Object) this);

        int enchantmentLevel = EnchantmentHelper.getEquipmentLevel(EnchantmentRegistry.MAGNETIC, livingEntity);

        if(enchantmentLevel > 0) {
            MagneticEnchantment.magnetize(livingEntity, livingEntity.getEntityWorld(), enchantmentLevel);
            callbackInfo.cancel();
        }
    }
}
