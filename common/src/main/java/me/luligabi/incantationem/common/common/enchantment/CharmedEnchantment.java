package me.luligabi.incantationem.common.common.enchantment;

import me.luligabi.incantationem.common.common.Incantationem;
import me.luligabi.incantationem.common.common.enchantment.curse.CurseRegistry;
import me.luligabi.incantationem.common.common.util.Util;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentCategory;
import net.minecraft.world.item.enchantment.EnchantmentHelper;

public class CharmedEnchantment extends IncantationemEnchantment {


    public CharmedEnchantment() {
        super(
            "charmed",
            Rarity.RARE,
            EnchantmentCategory.BREAKABLE,
            EquipmentSlot.values(),
            Incantationem.CONFIG.enchantments.charmed.availableRandomly,
            Incantationem.CONFIG.enchantments.charmed.availableForBookOffer,
            Incantationem.CONFIG.enchantments.charmed.availableAsTreasure
        );
    }

    @Override
    public int getMinCost(int level) {
        return 5 + (level - 1) * 12;
    }

    @Override
    public int getMaxCost(int level) {
        return super.getMinCost(level) + 50;
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