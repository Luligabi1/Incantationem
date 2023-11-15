package me.luligabi.incantationem.common.enchantment;

import me.luligabi.incantationem.common.Incantationem;
import me.luligabi.incantationem.common.Util;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;

public class DeflectionEnchantment extends IncantationemEnchantment {


    public DeflectionEnchantment() {
        super(
                Enchantment.Rarity.VERY_RARE,
                EnchantmentTarget.ARMOR,
                new EquipmentSlot[]{EquipmentSlot.HEAD, EquipmentSlot.CHEST, EquipmentSlot.LEGS, EquipmentSlot.FEET},
                Incantationem.CONFIG.deflectionMaxLevel,
                Incantationem.CONFIG.deflectionAvailableForBookOffer,
                Incantationem.CONFIG.deflectionAvailableRandomly,
                Incantationem.CONFIG.deflectionAvailableAsTreasure
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

    @Override
    public boolean isAcceptableItem(ItemStack stack) {
        return stack.isDamageable() || super.isAcceptableItem(stack);
    }

    @Override
    public boolean canAccept(Enchantment other) {
        return super.canAccept(other) &&
                other != Enchantments.PROJECTILE_PROTECTION &&
                other != Enchantments.THORNS;
    }

    public static boolean shouldDeflect(LivingEntity user) {
        // Sum the Deflection level on all armor pieces
        int deflectionLevel = 0;
        for(EquipmentSlot slot : EquipmentSlot.values()) {
            if(!slot.isArmorSlot()) continue;
            deflectionLevel += EnchantmentHelper.getLevel(
                    EnchantmentRegistry.DEFLECTION,
                    user.getEquippedStack(slot)
            );
        }
        if(deflectionLevel > 0) {
            /*
             * When using Deflection 3 on all 4 armor pieces, the user
             * has ~50% chance of deflecting an arrow.
             */
            return Util.positiveEffectRandomNumber(user, user.getRandom(), 0, 100) < deflectionLevel * 4.2;
        }
        return false;
    }
}
