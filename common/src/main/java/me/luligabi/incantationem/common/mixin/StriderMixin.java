package me.luligabi.incantationem.common.mixin;

import me.luligabi.incantationem.common.common.Incantationem;
import net.minecraft.world.entity.MobType;
import net.minecraft.world.entity.monster.Strider;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(Strider.class)
public class StriderMixin {

    public MobType getMobType() {
        return Incantationem.VULNERABLE_TO_WATER;
    }
}
