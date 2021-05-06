package me.luligabi.incantationem.mixin;

import me.luligabi.incantationem.Incantationem;
import net.minecraft.entity.EntityGroup;
import net.minecraft.entity.mob.HoglinEntity;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(HoglinEntity.class)
public class HoglinEntityMixin {

    public EntityGroup getGroup() {
        return Incantationem.SWINE;
    }
}
