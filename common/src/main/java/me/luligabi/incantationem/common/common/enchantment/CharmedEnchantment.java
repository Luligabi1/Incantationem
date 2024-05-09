package me.luligabi.incantationem.common.common.enchantment;

import me.luligabi.incantationem.common.common.Incantationem;
import me.luligabi.incantationem.common.common.util.Util;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentHelper;

public class CharmedEnchantment extends IncantationemEnchantment {


    public CharmedEnchantment() {
        super(
            "charmed",
            Enchantment.definition(
                ItemTags.DURABILITY_ENCHANTABLE,
                5,
                1,
                Enchantment.dynamicCost(5, 12),
                Enchantment.dynamicCost(17, 50),
                2,
                EquipmentSlot.values()
            ),
            Incantationem.CONFIG.enchantments.charmed.availableRandomly,
            Incantationem.CONFIG.enchantments.charmed.availableForBookOffer,
            Incantationem.CONFIG.enchantments.charmed.availableAsTreasure
        );
    }

    @Override
    public boolean canEnchant(ItemStack stack) {
        return stack.isDamageableItem() || super.canEnchant(stack);
    }

    public static void apply(LivingEntity user) {
        if(EnchantmentHelper.getEnchantmentLevel(EnchantmentRegistry.CHARMED.get(), user) < 1) return;
        Util.applyEffectIfNotPresent(user, MobEffects.LUCK, 3, 0);
    }
}