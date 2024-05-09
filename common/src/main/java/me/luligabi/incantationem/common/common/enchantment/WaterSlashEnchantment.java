package me.luligabi.incantationem.common.common.enchantment;

import me.luligabi.incantationem.common.common.Incantationem;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.Enchantment;

import java.util.Optional;

public class WaterSlashEnchantment extends IncantationemEnchantment {

    public WaterSlashEnchantment() {
        super(
            "water_slash",
            Enchantment.definition(
                ItemTags.SHARP_WEAPON_ENCHANTABLE,
                5,
                Incantationem.CONFIG.enchantments.waterSlash.maxLevel,
                Enchantment.dynamicCost(5, 10),
                Enchantment.dynamicCost(15, 30),
                2,
                EquipmentSlot.MAINHAND, EquipmentSlot.OFFHAND
            ),
            Incantationem.CONFIG.enchantments.waterSlash.availableRandomly,
            Incantationem.CONFIG.enchantments.waterSlash.availableForBookOffer,
            Incantationem.CONFIG.enchantments.waterSlash.availableAsTreasure,
            Optional.empty() // FIXME
        );

    }

    @Override
    public boolean checkCompatibility(Enchantment enchantment) {
        return super.checkCompatibility(enchantment) && !(enchantment instanceof WaterSlashEnchantment);
    }

    @Override
    public boolean canEnchant(ItemStack stack) {
        return super.canEnchant(stack) || stack.getItem() instanceof AxeItem;
    }

}