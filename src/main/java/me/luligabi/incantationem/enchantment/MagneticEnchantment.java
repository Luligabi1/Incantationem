package me.luligabi.incantationem.enchantment;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

import java.util.List;

public class MagneticEnchantment extends Enchantment {

    public MagneticEnchantment() {
        super(Rarity.VERY_RARE, EnchantmentTarget.ARMOR, new EquipmentSlot[]{EquipmentSlot.HEAD, EquipmentSlot.CHEST, EquipmentSlot.LEGS, EquipmentSlot.FEET});
    }

    public int getMinPower(int level) {
        return 10 + 20 * (level - 1);
    }

    public int getMaxPower(int level) {
        return super.getMinPower(level) + 50;
    }

    public int getMaxLevel() {
        return 3;
    }


    public static void magnetize(LivingEntity entity, World world, int level) {
        Vec3d pos = entity.getPos();
        BlockPos box1 = new BlockPos(pos.x + (level*2), pos.y + (level*2), pos.z + (level*2));
        BlockPos box2 = new BlockPos(pos.x - (level*2), pos.y - (level*2), pos.z - (level*2));

        List<Entity> entities = world.getEntitiesByType(null, new Box(box1, box2), e -> e instanceof ItemEntity || e instanceof ExperienceOrbEntity);

        for(Entity e : entities) {
            Vec3d velocity = e.getPos().reverseSubtract(new Vec3d(pos.x + 0.5, pos.y + 0.5, pos.z + 0.5)).normalize().multiply(0.1);
            e.addVelocity(velocity.x, velocity.y, velocity.z);
        }
    }
}
