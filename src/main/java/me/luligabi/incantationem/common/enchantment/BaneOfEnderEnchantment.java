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

public class BaneOfEnderEnchantment extends IncantationemEnchantment {

    public BaneOfEnderEnchantment() {
        super(
                Rarity.UNCOMMON,
                EnchantmentTarget.WEAPON,
                new EquipmentSlot[]{EquipmentSlot.MAINHAND, EquipmentSlot.OFFHAND},
                Incantationem.CONFIG.baneOfEnderMaxLevel,
                Incantationem.CONFIG.baneOfEnderAvailableForBookOffer,
                Incantationem.CONFIG.baneOfEnderAvailableRandomly,
                Incantationem.CONFIG.baneOfEnderAvailableAsTreasure
        );
    }

    @Override
    public int getMinPower(int level) {
        return 20 + 20 * (level - 1);
    }

    @Override
    public int getMaxPower(int level) {
        return super.getMinPower(level) + 60;
    }

    @Override
    public boolean canAccept(Enchantment enchantment) {
        return !(enchantment instanceof BaneOfEnderEnchantment);
    }

    @Override
    public boolean isAcceptableItem(ItemStack stack) {
        return super.isAcceptableItem(stack) || stack.getItem() instanceof AxeItem;
    }

    @Override
    public float getAttackDamage(int level, EntityGroup group) { // TODO: Change group check for a tag check if method signature changes accordingly
        return group == Incantationem.ENDER ? (float)level * 2.5F : 0.0F;
    }

    @Override
    public void onTargetDamaged(LivingEntity user, Entity target, int level) {
        if (target instanceof LivingEntity livingEntity) {

            if (livingEntity.getGroup() == Incantationem.ENDER) {
                int randomEffectTimer = 20 + user.getRandom().nextInt(10 * level);
                livingEntity.addStatusEffect(new StatusEffectInstance(StatusEffects.SLOWNESS, randomEffectTimer, 3));
            }
        }
    }
}
