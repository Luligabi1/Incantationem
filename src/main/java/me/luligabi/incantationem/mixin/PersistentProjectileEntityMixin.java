package me.luligabi.incantationem.mixin;

import me.luligabi.incantationem.common.Util;
import me.luligabi.incantationem.common.enchantment.EnchantmentRegistry;
import me.luligabi.incantationem.common.enchantment.FuseShotEnchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.projectile.PersistentProjectileEntity;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(PersistentProjectileEntity.class)
public abstract class PersistentProjectileEntityMixin {


    @Inject(
        method = "onEntityHit",
        at = @At("TAIL")
    )
    public void onEntityHit(EntityHitResult entityHitResult, CallbackInfo ci) {
        PersistentProjectileEntity ppEntity = ((PersistentProjectileEntity) (Object) this);

        if(entityHitResult.getEntity() instanceof LivingEntity hitEntity) {
            if(ppEntity.getOwner() instanceof LivingEntity attacker) {
                int venomousLevel = EnchantmentHelper.getEquipmentLevel(EnchantmentRegistry.VENOMOUS, attacker);
                int fuseShotLevel = EnchantmentHelper.getEquipmentLevel(EnchantmentRegistry.FUSE_SHOT, attacker);

                if(venomousLevel > 0) {
                    if(Util.positiveEffectRandomNumber(attacker, attacker.getRandom(), 0, 10) < (venomousLevel*1.5)) {
                        Util.applyEffectIfNotPresent(hitEntity, StatusEffects.POISON, Util.neutralEffectRandomNumber(hitEntity.getRandom(), 2, 4), venomousLevel-1);
                        Util.sendActionBarMessage(attacker, Text.translatable("message.incantationem.venomous.applied"), Formatting.DARK_GREEN);
                    }
                }
                if(fuseShotLevel > 0) {
                    FuseShotEnchantment.createExplosion(
                        attacker, ppEntity, hitEntity,
                        entityHitResult.getPos(), ppEntity.getEntityWorld(),
                        fuseShotLevel
                    );
                }
            }
        }
    }

}