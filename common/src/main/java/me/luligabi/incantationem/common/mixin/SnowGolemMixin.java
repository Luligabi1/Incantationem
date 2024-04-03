package me.luligabi.incantationem.common.mixin;

import me.luligabi.incantationem.common.common.Incantationem;
import net.minecraft.world.entity.MobType;
import net.minecraft.world.entity.animal.SnowGolem;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(SnowGolem.class)
public class SnowGolemMixin {

    public MobType getMobType() {
        return Incantationem.VULNERABLE_TO_WATER;
    }
}
