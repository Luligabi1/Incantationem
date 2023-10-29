package me.luligabi.incantationem.mixin;

import me.luligabi.incantationem.common.Incantationem;
import net.minecraft.entity.EntityGroup;
import net.minecraft.entity.mob.ShulkerEntity;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(ShulkerEntity.class)
public class ShulkerEntityMixin {

    public EntityGroup getGroup() {
        return Incantationem.ENDER;
    }
}
