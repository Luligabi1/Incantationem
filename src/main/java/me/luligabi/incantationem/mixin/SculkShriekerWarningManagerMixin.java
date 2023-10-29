package me.luligabi.incantationem.mixin;

import me.luligabi.incantationem.common.enchantment.curse.CurseRegistry;
import net.minecraft.block.entity.SculkShriekerWarningManager;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.OptionalInt;

@Mixin(SculkShriekerWarningManager.class)
public abstract class SculkShriekerWarningManagerMixin {

    @Inject(method = "warnNearbyPlayers", at = @At(value = "INVOKE", target = "Lnet/minecraft/block/entity/SculkShriekerWarningManager;increaseWarningLevel()V"))
    private static void shouldCurseOfShrieking(ServerWorld world, BlockPos pos, ServerPlayerEntity player, CallbackInfoReturnable<OptionalInt> cir) {
        //Checks if a surrounding player has the Curse of Shrieking enchantment
        if(EnchantmentHelper.getEquipmentLevel(CurseRegistry.SHRIEKING, player) > 0) {
            player.getSculkShriekerWarningManager().ifPresent((sculkShriekerWarningManager -> {
                //Adds only 2 levels to the warning level, as one is also already being added from vanilla's code
                //Assuming the warning level hasn't decreased yet, the next shrieker will spawn the warden
                //Minecraft's own code ensures that the warning level never goes higher than what it is supposed to(4),
                //so we don't have to worry about going to high
                sculkShriekerWarningManager.setWarningLevel(sculkShriekerWarningManager.getWarningLevel() + 2);
            }));
        }
    }

}
