package me.luligabi.incantationem.common.enchantment;

import me.luligabi.incantationem.common.Incantationem;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.*;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

import java.util.List;

public class MagneticEnchantment extends IncantationemEnchantment {

    public MagneticEnchantment() {
        super(
                Rarity.VERY_RARE,
                EnchantmentTarget.ARMOR_LEGS,
                new EquipmentSlot[]{EquipmentSlot.LEGS},
                Incantationem.CONFIG.magneticMaxLevel,
                Incantationem.CONFIG.magneticAvailableForBookOffer,
                Incantationem.CONFIG.magneticAvailableRandomly,
                Incantationem.CONFIG.magneticAvailableAsTreasure
        );
    }

    @Override
    public int getMinPower(int level) {
        return 10 + 20 * (level - 1);
    }

    @Override
    public int getMaxPower(int level) {
        return super.getMinPower(level) + 50;
    }


    public static void magnetize(LivingEntity entity, World world, int level) {
        Vec3d pos = entity.getPos();
        Vec3d box1 = new Vec3d(pos.x + (level*2), pos.y + (level*2), pos.z + (level*2));
        Vec3d box2 = new Vec3d(pos.x - (level*2), pos.y - (level*2), pos.z - (level*2));

        List<Entity> entities = world.getOtherEntities(null, new Box(box1, box2), e -> e instanceof ItemEntity || e instanceof ExperienceOrbEntity);

         for(Entity e : entities) {
            Vec3d velocity = e.getPos().relativize(new Vec3d(pos.x + 0.5, pos.y + 0.5, pos.z + 0.5)).normalize().multiply(0.1);
            e.addVelocity(velocity.x, velocity.y, velocity.z);
        }
    }

}