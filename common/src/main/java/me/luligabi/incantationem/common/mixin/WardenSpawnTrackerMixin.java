package me.luligabi.incantationem.common.mixin;

import me.luligabi.incantationem.common.common.enchantment.HardcodedEnchantments;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.monster.warden.WardenSpawnTracker;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.OptionalInt;

@Mixin(WardenSpawnTracker.class)
public abstract class WardenSpawnTrackerMixin {

    @Inject(
        method = "tryWarn",
        at = @At(
            value = "INVOKE",
            target = "Lnet/minecraft/world/entity/monster/warden/WardenSpawnTracker;increaseWarningLevel()V"
        )
    )
    private static void incantationem_tryWarn(ServerLevel level, BlockPos pos, ServerPlayer player, CallbackInfoReturnable<OptionalInt> cir) {
        HardcodedEnchantments.shrieking(player);
    }
}