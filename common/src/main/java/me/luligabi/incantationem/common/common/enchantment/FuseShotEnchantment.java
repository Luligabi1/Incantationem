package me.luligabi.incantationem.common.common.enchantment;

import me.luligabi.incantationem.common.common.Incantationem;
import net.minecraft.tags.ItemTags;
import net.minecraft.util.Mth;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.Nullable;

/*
 * Inspired by Minecraft Dungeons: https://minecraft.wiki/w/Minecraft_Dungeons:Fuse_Shot
 */
public class FuseShotEnchantment extends IncantationemEnchantment {

    public FuseShotEnchantment() {
        super(
            "fuse_shot",
            Enchantment.definition(
                ItemTags.BOW_ENCHANTABLE,
                5,
                Incantationem.CONFIG.enchantments.fuseShot.maxLevel,
                Enchantment.constantCost(18),
                Enchantment.constantCost(42),
                2,
                EquipmentSlot.MAINHAND, EquipmentSlot.OFFHAND
            ),
            Incantationem.CONFIG.enchantments.fuseShot.availableRandomly,
            Incantationem.CONFIG.enchantments.fuseShot.availableForBookOffer,
            Incantationem.CONFIG.enchantments.fuseShot.availableAsTreasure
        );
    }

    public static void createExplosion(LivingEntity attacker, AbstractArrow arrow, @Nullable Entity hitEntity, Vec3 pos, Level level, int i) {
        if(i < 1) return;
        DamageSource damageSource = attacker.damageSources().explosion(arrow, attacker);
        float damage = (float) Mth.clamp(arrow.getDeltaMovement().length(), 0.1, i * 1.25);

        level.explode(
            hitEntity,
            damageSource,
            null,
            pos.x, pos.y, pos.z,
            damage, false, Level.ExplosionInteraction.NONE
        );
    }

}