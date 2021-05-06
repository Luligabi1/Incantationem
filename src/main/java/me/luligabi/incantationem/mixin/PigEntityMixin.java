package me.luligabi.incantationem.mixin;

import me.luligabi.incantationem.Incantationem;
import net.minecraft.entity.EntityGroup;
import net.minecraft.entity.passive.PigEntity;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(PigEntity.class)
public class PigEntityMixin {

    public EntityGroup getGroup() { return Incantationem.SWINE; }
}
