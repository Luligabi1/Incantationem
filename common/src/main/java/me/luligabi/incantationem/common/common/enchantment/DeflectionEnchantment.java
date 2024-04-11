package me.luligabi.incantationem.common.common.enchantment;

import me.luligabi.incantationem.common.common.Incantationem;
import me.luligabi.incantationem.common.common.util.EffectAppliedMessage;
import me.luligabi.incantationem.common.common.util.Util;
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
            Incantationem.CONFIG.enchantments.deflection.maxLevel,
            Incantationem.CONFIG.enchantments.deflection.availableRandomly,
            Incantationem.CONFIG.enchantments.deflection.availableForBookOffer,
            Incantationem.CONFIG.enchantments.deflection.availableAsTreasure
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
    public boolean checkCompatibility(Enchantment other) { // FIXME use tag for all compatibility checks
        return super.checkCompatibility(other) &&
            other != Enchantments.PROJECTILE_PROTECTION &&
            other != Enchantments.THORNS;
    }

    public static boolean apply(LivingEntity user) {
        // Sum the Deflection level on all armor pieces
        int deflectionLevel = 0;
        for(EquipmentSlot slot : EquipmentSlot.values()) {
            if(!slot.isArmor()) continue;
            deflectionLevel += EnchantmentHelper.getItemEnchantmentLevel(
                EnchantmentRegistry.DEFLECTION.get(),
                user.getItemBySlot(slot)
            );
        }
        if(deflectionLevel > 0) {
            boolean apply = Util.positiveEffectRandomNumber(
                user, user.getRandom(),
                Math.round(100 - deflectionLevel * 4.2F),
                Incantationem.CONFIG.enchantments.deflection.isLuckBased
            );
            if(apply) Util.sendEffectAppliedMessage(user, EffectAppliedMessage.DEFLECTION);

            return apply;
        }
        return false;
    }
}
