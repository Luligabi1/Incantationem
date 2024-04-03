package me.luligabi.incantationem.common.mixin;

import me.luligabi.incantationem.common.common.enchantment.EnchantmentRegistry;
import me.luligabi.incantationem.common.common.enchantment.FuseShotEnchantment;
import me.luligabi.incantationem.common.common.enchantment.VenomousEnchantment;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.phys.EntityHitResult;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(AbstractArrow.class)
public abstract class AbstractArrowMixin {


    @Inject(
        method = "onHitEntity",
        at = @At("TAIL")
    )
    public void onHitEntity(EntityHitResult entityHitResult, CallbackInfo ci) {
        AbstractArrow arrow = ((AbstractArrow) (Object) this);

        if(entityHitResult.getEntity() instanceof LivingEntity hitEntity) {
            if(arrow.getOwner() instanceof LivingEntity attacker) {
                VenomousEnchantment.apply(
                    attacker, hitEntity,
                    EnchantmentHelper.getEnchantmentLevel(
                        EnchantmentRegistry.VENOMOUS.get(),
                        attacker
                    )
                );
                FuseShotEnchantment.createExplosion(
                    attacker, arrow, hitEntity,
                    entityHitResult.getLocation(), arrow.level(),
                    EnchantmentHelper.getEnchantmentLevel(
                        EnchantmentRegistry.FUSE_SHOT.get(),
                        attacker
                    )
                );
            }
        }
    }

}