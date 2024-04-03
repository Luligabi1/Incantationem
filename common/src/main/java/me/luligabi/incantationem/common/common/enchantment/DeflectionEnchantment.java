package me.luligabi.incantationem.common.common.enchantment;

import me.luligabi.incantationem.common.common.Incantationem;
import me.luligabi.incantationem.common.common.Util;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentCategory;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.enchantment.Enchantments;

public class DeflectionEnchantment extends IncantationemEnchantment {


    public DeflectionEnchantment() {
        super(
            "deflection",
            Rarity.VERY_RARE,
            EnchantmentCategory.ARMOR,
            new EquipmentSlot[]{EquipmentSlot.HEAD, EquipmentSlot.CHEST, EquipmentSlot.LEGS, EquipmentSlot.FEET},
            Incantationem.CONFIG.deflectionMaxLevel,
            Incantationem.CONFIG.deflectionAvailableForBookOffer,
            Incantationem.CONFIG.deflectionAvailableRandomly,
            Incantationem.CONFIG.deflectionAvailableAsTreasure
        );
    }

    @Override
    public int getMinCost(int level) {
        return 10 + 20 * (level - 1);
    }

    @Override
    public int getMaxCost(int level) {
        return super.getMinCost(level) + 50;
    }

    @Override
    public boolean canEnchant(ItemStack stack) {
        return stack.isDamageableItem() || super.canEnchant(stack);
    }

    @Override
    public boolean checkCompatibility(Enchantment other) {
        return super.checkCompatibility(other) &&
            other != Enchantments.PROJECTILE_PROTECTION &&
            other != Enchantments.THORNS;
    }

    public static boolean apply(LivingEntity user) {
        // Sum the Deflection level on all armor pieces
        int deflectionLevel = 0;
        for(EquipmentSlot slot : EquipmentSlot.values()) {
            if(!slot.isArmor()) continue;
            deflectionLevel += EnchantmentHelper.getItemEnchantmentLevel(EnchantmentRegistry.DEFLECTION.get(), user.getItemBySlot(slot));
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
