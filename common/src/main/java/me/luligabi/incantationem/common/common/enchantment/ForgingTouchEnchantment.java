package me.luligabi.incantationem.common.common.enchantment;

import me.luligabi.incantationem.common.common.Incantationem;
import me.luligabi.incantationem.common.common.Util;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeHolder;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.item.crafting.SmeltingRecipe;
import net.minecraft.world.item.enchantment.EnchantmentCategory;
import net.minecraft.world.item.enchantment.EnchantmentHelper;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ForgingTouchEnchantment extends IncantationemEnchantment {

    public ForgingTouchEnchantment() {
        super(
            "forging_touch",
            Rarity.RARE,
            EnchantmentCategory.DIGGER,
            new EquipmentSlot[]{EquipmentSlot.MAINHAND, EquipmentSlot.OFFHAND},
            Incantationem.CONFIG.enchantments.forgingTouch.maxLevel,
            Incantationem.CONFIG.enchantments.forgingTouch.availableForBookOffer,
            Incantationem.CONFIG.enchantments.forgingTouch.availableRandomly,
            Incantationem.CONFIG.enchantments.forgingTouch.availableAsTreasure
        );
    }

    @Override
    public int getMinCost(int level) {
        return 15 + (level - 1) * 9;
    }

    @Override
    public int getMaxCost(int level) {
        return super.getMinCost(level) + 50;
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

            if(recipe.isPresent() && Util.neutralEffectRandomNumber(level.getRandom(), 0, 10) < (forgingTouchLevel * 1.5)) {
                ItemStack forgedItems = recipe.get().value().getResultItem(level.registryAccess()).copy();
                forgedItems.setCount(preForgingItems.getCount());
                itemsToDropList.add(forgedItems);
                if(entity instanceof LivingEntity) {
                    Util.sendActionBarMessage((LivingEntity) entity, Component.translatable("message.incantationem.forging_touch.applied"), ChatFormatting.GOLD);
                }
            } else {
                itemsToDropList.add(preForgingItems);
            }

        }
        return itemsToDropList;
    }

}