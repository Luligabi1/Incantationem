package me.luligabi.incantationem.common.common.enchantment;

import me.luligabi.incantationem.common.common.Incantationem;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.ExperienceOrb;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

import java.util.List;

public class MagneticEnchantment extends IncantationemEnchantment {

    public MagneticEnchantment() {
        super(
            "magnetic",
            Enchantment.definition(
                ItemTags.LEG_ARMOR_ENCHANTABLE,
                5,
                Incantationem.CONFIG.enchantments.magnetic.maxLevel,
                Enchantment.dynamicCost(10, 20),
                Enchantment.dynamicCost(30, 50),
                2,
                EquipmentSlot.LEGS
            ),
            Incantationem.CONFIG.enchantments.magnetic.availableRandomly,
            Incantationem.CONFIG.enchantments.magnetic.availableForBookOffer,
            Incantationem.CONFIG.enchantments.magnetic.availableAsTreasure
        );
    }

    public static void apply(LivingEntity entity, Level level, int i) {
        Vec3 pos = entity.position();
        Vec3 box1 = new Vec3(pos.x + (i * 2), pos.y + (i * 2), pos.z + (i * 2));
        Vec3 box2 = new Vec3(pos.x - (i * 2), pos.y - (i * 2), pos.z - (i * 2));

        List<Entity> entities = level.getEntities(
            (Entity) null,
            new AABB(box1, box2),
            e -> e instanceof ItemEntity || e instanceof ExperienceOrb
        );

        for(Entity e : entities) {
            Vec3 velocity = e.position().vectorTo(new Vec3(pos.x + 0.5, pos.y + 0.5, pos.z + 0.5)).normalize().scale(0.1);
            e.addDeltaMovement(velocity);
        }
    }

}