package me.luligabi.incantationem.common.enchantment;

import me.luligabi.incantationem.common.Incantationem;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityGroup;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.AxeItem;
import net.minecraft.item.ItemStack;

public class WaterSlashEnchantment extends IncantationemEnchantment {

    public WaterSlashEnchantment() {
        super(
            "water_slash",
            Rarity.UNCOMMON,
            EnchantmentTarget.WEAPON,
            new EquipmentSlot[]{EquipmentSlot.MAINHAND, EquipmentSlot.OFFHAND},
            Incantationem.CONFIG.waterSlashMaxLevel,
            Incantationem.CONFIG.waterSlashAvailableForBookOffer,
            Incantationem.CONFIG.waterSlashAvailableRandomly,
            Incantationem.CONFIG.waterSlashAvailableAsTreasure
        );
    }

    @Override
    public int getMinPower(int level) {
        return 5 + (level - 1) * 10;
    }

    @Override
    public int getMaxPower(int level) {
        return getMinPower(level) + 30;
    }


    @Override
    public boolean canAccept(Enchantment enchantment) {
        return super.canAccept(enchantment) && !(enchantment instanceof WaterSlashEnchantment);
    }

    @Override
    public boolean isAcceptableItem(ItemStack stack) {
        return super.isAcceptableItem(stack) || stack.getItem() instanceof AxeItem;
    }

    @Override
    public float getAttackDamage(int level, EntityGroup group) { // TODO: Change group check for a tag check if method signature changes accordingly
        return group == Incantationem.VULNERABLE_TO_WATER ? (float) level * 2.5F : 0.0F;
    }

    @Override
    public void onTargetDamaged(LivingEntity user, Entity target, int level) {
        if(target instanceof LivingEntity livingEntity) {

            if(livingEntity.getGroup() == Incantationem.VULNERABLE_TO_WATER) {
                int randomEffectTimer = 20 + user.getRandom().nextInt(10 * level);
                livingEntity.addStatusEffect(new StatusEffectInstance(StatusEffects.SLOWNESS, randomEffectTimer, 3));
            }
        }
    }
}