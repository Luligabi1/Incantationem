package me.luligabi.incantationem.common.mixin;

import me.luligabi.incantationem.common.common.Incantationem;
import net.minecraft.world.entity.MobType;
import net.minecraft.world.entity.monster.piglin.PiglinBrute;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(PiglinBrute.class)
public class PiglinBruteMixin {

    public MobType getMobType() {
        return Incantationem.SWINE;
    }
}
