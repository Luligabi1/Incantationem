package me.luligabi.incantationem.common.common.enchantment;

import me.luligabi.incantationem.common.common.Incantationem;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MobType;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentCategory;

public class WaterSlashEnchantment extends IncantationemEnchantment {

    public WaterSlashEnchantment() {
        super(
            "water_slash",
            Rarity.UNCOMMON,
            EnchantmentCategory.WEAPON,
            new EquipmentSlot[]{EquipmentSlot.MAINHAND, EquipmentSlot.OFFHAND},
            Incantationem.CONFIG.enchantments.waterSlash.maxLevel,
            Incantationem.CONFIG.enchantments.waterSlash.availableRandomly,
            Incantationem.CONFIG.enchantments.waterSlash.availableForBookOffer,
            Incantationem.CONFIG.enchantments.waterSlash.availableAsTreasure
        );
    }

    @Override
    public int getMinCost(int level) {
        return 5 + (level - 1) * 10;
    }

    @Override
    public int getMaxCost(int level) {
        return getMinCost(level) + 30;
    }


    @Override
    public boolean checkCompatibility(Enchantment enchantment) {
        return super.checkCompatibility(enchantment) && !(enchantment instanceof WaterSlashEnchantment);
    }

    @Override
    public boolean canEnchant(ItemStack stack) {
        return super.canEnchant(stack) || stack.getItem() instanceof AxeItem;
    }

    @Override
    public float getDamageBonus(int level, MobType mobType) {
        return mobType == Incantationem.VULNERABLE_TO_WATER ? (float) level * 2.5F : 0.0F;
    }

    @Override
    public void doPostAttack(LivingEntity user, Entity target, int level) {
        if(target instanceof LivingEntity livingEntity) {

            if(livingEntity.getMobType() == Incantationem.VULNERABLE_TO_WATER) {
                int randomEffectTimer = 20 + user.getRandom().nextInt(10 * level);
                livingEntity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, randomEffectTimer, 3));
            }
        }
    }
}