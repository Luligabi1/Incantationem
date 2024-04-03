package me.luligabi.incantationem.common.mixin;

import me.luligabi.incantationem.common.common.Incantationem;
import net.minecraft.world.entity.MobType;
import net.minecraft.world.entity.monster.Shulker;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(Shulker.class)
public class ShulkerMixin {

    public MobType getMobType() {
        return Incantationem.VULNERABLE_TO_WATER;
    }
}
