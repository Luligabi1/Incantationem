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
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;

public class DeflectionEnchantment extends IncantationemEnchantment {


    public DeflectionEnchantment() {
        super(
                Enchantment.Rarity.RARE,
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
        return 5 + (level - 1) * 12;
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
        return super.canAccept(other) && (other != Enchantments.PROJECTILE_PROTECTION);
    }

    public static boolean shouldDeflect(LivingEntity user) {
        //Can't use EnchantmentHelper.getEquipmentLevel, as that doesn't seem to account for multiple equipment slots,
        //Rather, it returns the highest value of the equipment slots(e.g. would return "3" if helmet had Deflection 3, but chestplate had Deflection 1)
        //Instead, this method gathers the enchantment level of each individual equipment slot, then adds them for one final integer.
        int headDeflectionLevel = EnchantmentHelper.getLevel(EnchantmentRegistry.DEFLECTION, user.getEquippedStack(EquipmentSlot.HEAD));
        int chestDeflectionLevel = EnchantmentHelper.getLevel(EnchantmentRegistry.DEFLECTION, user.getEquippedStack(EquipmentSlot.CHEST));
        int legsDeflectionLevel = EnchantmentHelper.getLevel(EnchantmentRegistry.DEFLECTION, user.getEquippedStack(EquipmentSlot.LEGS));
        int feetDeflectionLevel = EnchantmentHelper.getLevel(EnchantmentRegistry.DEFLECTION, user.getEquippedStack(EquipmentSlot.FEET));
        int deflectionLevel = headDeflectionLevel + chestDeflectionLevel + legsDeflectionLevel + feetDeflectionLevel;
        if(deflectionLevel > 0) {
            //If an entity has Deflection 3 on all four armor pieces,
            //gives ~50%(about 50.4%) chance of deflecting an arrow, slightly in the enchantment wearer's favor
            if(Util.positiveEffectRandomNumber(user, user.getRandom(), 0, 100) < deflectionLevel * 4.2) {
                Util.sendActionBarMessage(user, Text.translatable("message.incantationem.deflection.applied"), Formatting.LIGHT_PURPLE);
                return true;
            }
        }
        return false;
    }
}
