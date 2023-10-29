package me.luligabi.incantationem.mixin;

import me.luligabi.incantationem.common.Util;
import me.luligabi.incantationem.common.enchantment.EnchantmentRegistry;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.projectile.PersistentProjectileEntity;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(PersistentProjectileEntity.class)
public abstract class PersistentProjectileEntityMixin {

    PersistentProjectileEntity ppEntity = ((PersistentProjectileEntity) (Object) this);

    @Inject(method = "onEntityHit",
            at = @At("TAIL"))
    public void onEntityHit(EntityHitResult entityHitResult, CallbackInfo ci) {
        if(entityHitResult.getEntity() instanceof LivingEntity) {
            if(ppEntity.getOwner() instanceof LivingEntity attacker) {
                LivingEntity hitEntity = (LivingEntity) entityHitResult.getEntity();
                int venomousLevel = EnchantmentHelper.getEquipmentLevel(EnchantmentRegistry.VENOMOUS, attacker);
                int explosiveLevel = EnchantmentHelper.getEquipmentLevel(EnchantmentRegistry.EXPLOSIVE, attacker);

                if(venomousLevel > 0) {
                    if(Util.positiveEffectRandomNumber(attacker, attacker.getRandom(), 0, 10) < (venomousLevel*1.5)) {
                        Util.applyEffectIfNotPresent(hitEntity, StatusEffects.POISON, Util.neutralEffectRandomNumber(hitEntity.getRandom(), 2, 4), venomousLevel-1);
                        Util.sendActionBarMessage(attacker, Text.translatable("message.incantationem.venomous.applied"), Formatting.DARK_GREEN);
                    }
                }

                //The range is affected by the Explosive level
                //It always activates 100% of the time
                if(explosiveLevel > 0) {
                    Entity arrowOwner = ppEntity.getOwner();
                    //The damage source for the entities to be damaged
                    //This is important to ensure that death messages and kill credit is correct
                    DamageSource explosionDamageSource = arrowOwner != null ? arrowOwner.getDamageSources().explosion(ppEntity, arrowOwner) : ppEntity.getDamageSources().arrow(ppEntity, hitEntity);
                    //Only allows the explosion damage amount to be capped depending on the Explosive level
                    //Velocity also plays a role in determining the damage to discourage spamming arrows with little to no pulling on the bow
                    float explosionDamageAmount = (float) MathHelper.clamp(ppEntity.getVelocity().length(), 0.1, explosiveLevel * 1.25);
                    //Spawns an explosion which damages nearby entities, spawns particles, and plays a sound
                    //The Explosive level also plays a role in the radius of the explosion
                    hitEntity.getWorld().createExplosion(hitEntity, explosionDamageSource, null, hitEntity.getX(), hitEntity.getEyeY(), hitEntity.getZ(), explosionDamageAmount, false, World.ExplosionSourceType.NONE);
                }
            }
        }
    }
}
