package me.luligabi.incantationem.common.mixin;

import me.luligabi.incantationem.common.common.Incantationem;
import net.minecraft.world.entity.MobType;
import net.minecraft.world.entity.monster.piglin.Piglin;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(Piglin.class)
public class PiglinMixin {

    public MobType getMobType() {
        return Incantationem.SWINE;
    }
}
