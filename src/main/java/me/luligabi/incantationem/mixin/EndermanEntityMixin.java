package me.luligabi.incantationem.mixin;

import me.luligabi.incantationem.common.Incantationem;
import net.minecraft.entity.EntityGroup;
import net.minecraft.entity.mob.EndermanEntity;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(EndermanEntity.class)
public class EndermanEntityMixin {

    public EntityGroup getGroup() {
        return Incantationem.ENDER;
    }
}
