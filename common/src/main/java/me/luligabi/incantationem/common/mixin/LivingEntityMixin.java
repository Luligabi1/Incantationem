package me.luligabi.incantationem.common.mixin;

import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import me.luligabi.incantationem.common.common.enchantment.HardcodedEnchantments;
import net.minecraft.tags.DamageTypeTags;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.LivingEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(LivingEntity.class)
public class LivingEntityMixin {

    @ModifyExpressionValue(
        method = "hurt",
        at = @At(
            value = "INVOKE",
            target = "Lnet/minecraft/world/entity/LivingEntity;isInvulnerableTo(Lnet/minecraft/world/damagesource/DamageSource;)Z"
        )
    )
    public boolean incantationem_hurt(boolean original, DamageSource source, float amount) {
        if(!source.is(DamageTypeTags.IS_PROJECTILE)) return original;
        return HardcodedEnchantments.deflection(((LivingEntity) (Object) this)) || original;
    }
}