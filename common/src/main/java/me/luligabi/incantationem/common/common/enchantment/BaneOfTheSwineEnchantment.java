package me.luligabi.incantationem.common.common.enchantment;

import me.luligabi.incantationem.common.common.Incantationem;
import me.luligabi.incantationem.common.common.util.TagRegistry;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.DamageEnchantment;
import net.minecraft.world.item.enchantment.Enchantment;

/*
 * Original idea by u/nonexistnt @ https://reddit.com/r/minecraftsuggestions/comments/kpqs0r/new_enchantment_bane_of_the_swine/
 */
public class BaneOfTheSwineEnchantment extends IncantationemEnchantment {

    public BaneOfTheSwineEnchantment() {
        super(
            "swine_bane",
            Enchantment.definition(
                ItemTags.WEAPON_ENCHANTABLE,
                ItemTags.SWORD_ENCHANTABLE,
                5,
                Incantationem.CONFIG.enchantments.baneOfTheSwine.maxLevel,
                Enchantment.dynamicCost(20, 20),
                Enchantment.dynamicCost(40, 60),
                2,
                EquipmentSlot.MAINHAND
            ),
            Incantationem.CONFIG.enchantments.baneOfTheSwine.availableRandomly,
            Incantationem.CONFIG.enchantments.baneOfTheSwine.availableForBookOffer,
            Incantationem.CONFIG.enchantments.baneOfTheSwine.availableAsTreasure,
            TagRegistry.SENSITIVE_TO_BANE_OF_THE_SWINE
        );
    }

    @Override
    public boolean checkCompatibility(Enchantment enchantment) {
        return super.checkCompatibility(enchantment) && !(enchantment instanceof DamageEnchantment);
    }

    @Override
    public boolean canEnchant(ItemStack stack) {
        return super.canEnchant(stack) || stack.getItem() instanceof AxeItem;
    }

}