package me.luligabi.incantationem.common.mixin;

import me.luligabi.incantationem.common.common.Incantationem;
import net.minecraft.world.entity.MobType;
import net.minecraft.world.entity.monster.hoglin.Hoglin;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(Hoglin.class)
public class HoglinMixin {

    public MobType getMobType() {
        return Incantationem.SWINE;
    }
}
