package me.luligabi.incantationem.common.mixin;

import me.luligabi.incantationem.common.common.enchantment.HardcodedEnchantments;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.AbstractArrow;
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
    public void incantationem_onHitEntity(EntityHitResult entityHitResult, CallbackInfo ci) {
        AbstractArrow arrow = ((AbstractArrow) (Object) this);

        if(entityHitResult.getEntity() instanceof LivingEntity hitEntity) {
            if(arrow.getOwner() instanceof LivingEntity attacker) {
                HardcodedEnchantments.venomous(
                    attacker, hitEntity
                );
                HardcodedEnchantments.fuseShot(
                    attacker, arrow, hitEntity,
                    entityHitResult.getLocation(), arrow.level()
                );
            }
        }
    }

}