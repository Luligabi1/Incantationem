package me.luligabi.incantationem.mixin;

import me.luligabi.incantationem.common.Incantationem;
import net.minecraft.entity.EntityGroup;
import net.minecraft.entity.mob.EndermanEntity;
import net.minecraft.entity.passive.StriderEntity;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(StriderEntity.class)
public class StriderEntityMixin {

    public EntityGroup getGroup() {
        return Incantationem.VULNERABLE_TO_WATER;
    }
}
