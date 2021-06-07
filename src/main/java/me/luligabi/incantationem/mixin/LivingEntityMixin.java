package me.luligabi.incantationem.mixin;

import me.luligabi.incantationem.Util;
import me.luligabi.incantationem.enchantment.MagneticEnchantment;
import me.luligabi.incantationem.registry.CurseRegistry;
import me.luligabi.incantationem.registry.EnchantmentRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffects;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.Arrays;

@Mixin(LivingEntity.class)
public abstract class LivingEntityMixin {

    LivingEntity livingEntity = ((LivingEntity) (Object) this);

    @Inject(method = "baseTick",
            at = @At("RETURN"),
            cancellable = true)
    public void injectBaseTick(CallbackInfo callbackInfo) {
        int bunnysHopLevel = EnchantmentHelper.getEquipmentLevel(EnchantmentRegistry.BUNNYS_HOP, livingEntity);

        int charmedLevel = EnchantmentHelper.getEquipmentLevel(EnchantmentRegistry.CHARMED, livingEntity);

        int magneticLevel = EnchantmentHelper.getEquipmentLevel(EnchantmentRegistry.MAGNETIC, livingEntity);

        int toughLuckLevel = EnchantmentHelper.getEquipmentLevel(CurseRegistry.TOUGH_LUCK, livingEntity);

        if(bunnysHopLevel > 0) {
            Block floor = livingEntity.world.getBlockState(((EntityInvoker) livingEntity).invokeGetVelocityAffectingPos()).getBlock();

            Block[] grassBlocks = {Blocks.GRASS,
                    Blocks.DIRT,
                    Blocks.COARSE_DIRT};
            if(Arrays.asList(grassBlocks).contains(floor)) {
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