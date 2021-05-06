package me.luligabi.incantationem.mixin;

import me.luligabi.incantationem.Incantationem;
import net.minecraft.entity.EntityGroup;
import net.minecraft.entity.mob.PiglinBruteEntity;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(PiglinBruteEntity.class)
public class PiglinBruteEntityMixin {

    public EntityGroup getGroup() {
        return Incantationem.SWINE;
    }
}
