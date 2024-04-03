package me.luligabi.incantationem.common.mixin;

import me.luligabi.incantationem.common.common.Incantationem;
import net.minecraft.world.entity.MobType;
import net.minecraft.world.entity.monster.EnderMan;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(EnderMan.class)
public class EndermanMixin {

    public MobType getMobType() {
        return Incantationem.VULNERABLE_TO_WATER;
    }
}
