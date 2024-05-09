package me.luligabi.incantationem.common.common.enchantment;

import me.luligabi.incantationem.common.common.Incantationem;
import me.luligabi.incantationem.common.common.util.EffectAppliedMessage;
import me.luligabi.incantationem.common.common.util.Util;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentHelper;

public class DeflectionEnchantment extends IncantationemEnchantment {


    public DeflectionEnchantment() {
        super(
            "deflection",
            Enchantment.definition(
                ItemTags.ARMOR_ENCHANTABLE,
                5,
                Incantationem.CONFIG.enchantments.deflection.maxLevel,
                Enchantment.dynamicCost(10, 20),
                Enchantment.dynamicCost(30, 50),
                2,
                EquipmentSlot.HEAD, EquipmentSlot.CHEST, EquipmentSlot.LEGS, EquipmentSlot.FEET
            ),
            Incantationem.CONFIG.enchantments.deflection.availableRandomly,
            Incantationem.CONFIG.enchantments.deflection.availableForBookOffer,
            Incantationem.CONFIG.enchantments.deflection.availableAsTreasure
        );
    }

    @Override
    public boolean canEnchant(ItemStack stack) {
        return stack.isDamageableItem() || super.canEnchant(stack);
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
