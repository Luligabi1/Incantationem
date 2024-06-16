package me.luligabi.incantationem.common.common.enchantment.effecttype;

import com.mojang.serialization.MapCodec;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.ExperienceOrb;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.item.enchantment.EnchantedItemInUse;
import net.minecraft.world.item.enchantment.effects.EnchantmentEntityEffect;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

import java.util.List;

public record Magnetic() implements EnchantmentEntityEffect {

    private static final Magnetic INSTANCE = new Magnetic();
    public static final MapCodec<Magnetic> CODEC = MapCodec.unit(INSTANCE);

    @Override
    public void apply(ServerLevel arg, int i, EnchantedItemInUse arg2, Entity entity, Vec3 arg4) {
        Vec3 pos = entity.position();
        Vec3 box1 = new Vec3(pos.x + (i * 2), pos.y + (i * 2), pos.z + (i * 2));
        Vec3 box2 = new Vec3(pos.x - (i * 2), pos.y - (i * 2), pos.z - (i * 2));

        List<Entity> entities = entity.level().getEntities(
            (Entity) null,
            new AABB(box1, box2),
            e -> e instanceof ItemEntity || e instanceof ExperienceOrb
        );

        for(Entity e : entities) {
            Vec3 velocity = e.position().vectorTo(new Vec3(pos.x + 0.5, pos.y + 0.5, pos.z + 0.5)).normalize().scale(0.1);
            e.push(velocity.x, velocity.y, velocity.z);
        }
    }

    public MapCodec<Magnetic> codec() {
        return CODEC;
    }

}