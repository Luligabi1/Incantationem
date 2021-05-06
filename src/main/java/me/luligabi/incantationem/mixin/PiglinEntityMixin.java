package me.luligabi.incantationem.mixin;

import me.luligabi.incantationem.Incantationem;
import net.minecraft.entity.EntityGroup;
import net.minecraft.entity.mob.PiglinEntity;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(PiglinEntity.class)
public class PiglinEntityMixin {

    public EntityGroup getGroup() {
        return Incantationem.SWINE;
    }
}
