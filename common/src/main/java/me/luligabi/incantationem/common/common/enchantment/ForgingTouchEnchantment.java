package me.luligabi.incantationem.common.common.enchantment;

import me.luligabi.incantationem.common.common.Incantationem;
import me.luligabi.incantationem.common.common.util.EffectAppliedMessage;
import me.luligabi.incantationem.common.common.util.Util;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeHolder;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.item.crafting.SmeltingRecipe;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentHelper;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ForgingTouchEnchantment extends IncantationemEnchantment {

    public ForgingTouchEnchantment() {
        super(
            "forging_touch",
            Enchantment.definition(
                ItemTags.MINING_LOOT_ENCHANTABLE,
                5,
                Incantationem.CONFIG.enchantments.forgingTouch.maxLevel,
                Enchantment.dynamicCost(15, 9),
                Enchantment.dynamicCost(24, 50),
                2,
                EquipmentSlot.MAINHAND, EquipmentSlot.OFFHAND
            ),
            Incantationem.CONFIG.enchantments.forgingTouch.availableRandomly,
            Incantationem.CONFIG.enchantments.forgingTouch.availableForBookOffer,
            Incantationem.CONFIG.enchantments.forgingTouch.availableAsTreasure
        );
    }

    public static List<ItemStack> apply(List<ItemStack> original, ServerLevel level, Entity entity, ItemStack stack) {
        List<ItemStack> itemsToDropList = new ArrayList<>();
        int forgingTouchLevel = EnchantmentHelper.getItemEnchantmentLevel(EnchantmentRegistry.FORGING_TOUCH.get(), stack);
        if(forgingTouchLevel < 1) return original;

        for(ItemStack preForgingItems : original) {
            Optional<RecipeHolder<SmeltingRecipe>> recipe = level.getRecipeManager().getAllRecipesFor(RecipeType.SMELTING)
                .stream()
                .filter(smeltingRecipe -> smeltingRecipe.value().getIngredients().get(0).test(preForgingItems))
                .findFirst();

            if(recipe.isPresent() && Util.neutralEffectRandomNumber(level.getRandom(), (100 - (forgingTouchLevel * 15)), Incantationem.CONFIG.enchantments.forgingTouch.isLuckBased)) {
                ItemStack forgedItems = recipe.get().value().getResultItem(level.registryAccess()).copy();
                forgedItems.setCount(preForgingItems.getCount());
                itemsToDropList.add(forgedItems);
                if(entity instanceof LivingEntity) {
                    Util.sendEffectAppliedMessage((LivingEntity) entity, EffectAppliedMessage.FORGING_TOUCH);
                }
            } else {
                itemsToDropList.add(preForgingItems);
            }

        }
        return itemsToDropList;
    }

}