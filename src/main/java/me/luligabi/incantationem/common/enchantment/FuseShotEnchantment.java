package me.luligabi.incantationem.common.enchantment;

import me.luligabi.incantationem.common.Incantationem;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.projectile.PersistentProjectileEntity;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

/*
 * Inspired by Minecraft Dungeons: https://minecraft.wiki/w/Minecraft_Dungeons:Fuse_Shot
 */
public class FuseShotEnchantment extends IncantationemEnchantment {

    public FuseShotEnchantment() {
        super(
            "fuse_shot",
            Enchantment.Rarity.RARE,
            EnchantmentTarget.BOW,
            new EquipmentSlot[]{EquipmentSlot.MAINHAND, EquipmentSlot.OFFHAND},
            Incantationem.CONFIG.fuseShotMaxLevel,
            Incantationem.CONFIG.fuseShotAvailableForBookOffer,
            Incantationem.CONFIG.fuseShotAvailableRandomly,
            Incantationem.CONFIG.fuseShotAvailableAsTreasure
        );
    }

    @Override
    public int getMinPower(int level) {
        return 18;
    }

    @Override
    public int getMaxPower(int level) {
        return 42;
    }


    public static void createExplosion(LivingEntity attacker, PersistentProjectileEntity arrow, @Nullable Entity hitEntity, Vec3d pos, World world, int level) {
        DamageSource damageSource = attacker.getDamageSources().explosion(arrow, attacker);
        float damage = (float) MathHelper.clamp(arrow.getVelocity().length(), 0.1, level * 1.25);

        world.createExplosion(
                hitEntity,
                damageSource,
                null,
                pos.x, pos.y, pos.z,
                damage, false, World.ExplosionSourceType.NONE
        );
    }

}