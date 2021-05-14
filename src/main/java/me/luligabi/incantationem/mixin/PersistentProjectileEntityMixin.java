package me.luligabi.incantationem.mixin;

import me.luligabi.incantationem.Util;
import me.luligabi.incantationem.registry.EnchantmentRegistry;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.projectile.PersistentProjectileEntity;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.Formatting;
import net.minecraft.util.hit.EntityHitResult;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(PersistentProjectileEntity.class)
public abstract class PersistentProjectileEntityMixin {

    PersistentProjectileEntity ppEntity = ((PersistentProjectileEntity) (Object) this);

    @Inject(method = "onEntityHit",
            at = @At("TAIL"),
            cancellable = true)
    public void onEntityHit(EntityHitResult entityHitResult, CallbackInfo ci) {

        if(entityHitResult.getEntity() instanceof LivingEntity) {
            if(ppEntity.getOwner() instanceof LivingEntity) {
                LivingEntity hitEntity = (LivingEntity) entityHitResult.getEntity();
                LivingEntity attacker = (LivingEntity) ppEntity.getOwner();
                int venomousLevel = EnchantmentHelper.getEquipmentLevel(EnchantmentRegistry.VENOMOUS, attacker);

                if(venomousLevel > 0) {
                    if(Util.positiveEffectRandomNumber(attacker, attacker.getRandom(), 0, 10) < (venomousLevel*1.5)) {
                        Util.applyEffectIfNotPresent(hitEntity, StatusEffects.POISON, Util.neutralEffectRandomNumber(hitEntity.getRandom(), 2, 4), venomousLevel-1);
                        Util.sendActionBarMessage(attacker, new TranslatableText("message.incantationem.venomous.applied"), Formatting.DARK_GREEN);
                    }
                }
            }
        }
    }
}
