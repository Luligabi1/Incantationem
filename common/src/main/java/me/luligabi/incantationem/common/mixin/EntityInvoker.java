package me.luligabi.incantationem.common.mixin;


import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.Entity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;

@Mixin(Entity.class)
public interface EntityInvoker {

    @Invoker("getBlockPosBelowThatAffectsMyMovement")
        // what the hell, mojang
    BlockPos invokeGetVelocityAffectingPos();
}