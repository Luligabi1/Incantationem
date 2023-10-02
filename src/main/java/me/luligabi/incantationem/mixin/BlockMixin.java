package me.luligabi.incantationem.mixin;

import com.llamalad7.mixinextras.injector.ModifyReturnValue;
import me.luligabi.incantationem.common.Util;
import me.luligabi.incantationem.common.enchantment.curse.CurseRegistry;
import me.luligabi.incantationem.common.enchantment.EnchantmentRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.recipe.RecipeType;
import net.minecraft.recipe.SmeltingRecipe;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.stat.Stats;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Mixin(Block.class)
public abstract class BlockMixin {

    // Recklessness Curse
    @Inject(
            method = "afterBreak",
            at = @At("HEAD"),
            cancellable = true
    )
    public void afterBreak(World world, PlayerEntity player, BlockPos pos, BlockState state, BlockEntity blockEntity, ItemStack stack, CallbackInfo ci) {
        if(EnchantmentHelper.getEquipmentLevel(CurseRegistry.RECKLESSNESS, player) > 0) {
            player.incrementStat(Stats.MINED.getOrCreateStat((Block) (Object) this));
            player.addExhaustion(0.005F);
            ci.cancel();
        }
    }

    // Forging Touch
    @ModifyReturnValue(
            method = "getDroppedStacks(Lnet/minecraft/block/BlockState;Lnet/minecraft/server/world/ServerWorld;Lnet/minecraft/util/math/BlockPos;Lnet/minecraft/block/entity/BlockEntity;Lnet/minecraft/entity/Entity;Lnet/minecraft/item/ItemStack;)Ljava/util/List;",
            at = @At("RETURN")
    )
    private static List<ItemStack> getDroppedStacks(List<ItemStack> original, BlockState state, ServerWorld world, BlockPos pos, BlockEntity blockEntity, Entity entity, ItemStack stack) {
        List<ItemStack> itemsToDropList = new ArrayList<>();
        int forgingTouchLevel = EnchantmentHelper.getLevel(EnchantmentRegistry.FORGING_TOUCH, stack);
        if (forgingTouchLevel <= 0) return original;

        for(ItemStack preForgingItems : original) {
            Optional<SmeltingRecipe> recipe = world.getRecipeManager().listAllOfType(RecipeType.SMELTING).stream().filter(
                    smeltingRecipe -> smeltingRecipe.getIngredients().get(0).test(preForgingItems)
            ).findFirst();

            if(recipe.isPresent() && Util.neutralEffectRandomNumber(world.getRandom(), 0, 10) < (forgingTouchLevel*1.5)) {
                ItemStack forgedItems = recipe.get().getOutput(world.getRegistryManager()).copy();
                forgedItems.setCount(preForgingItems.getCount());
                itemsToDropList.add(forgedItems);
                if(entity instanceof LivingEntity) {
                    Util.sendActionBarMessage((LivingEntity) entity, Text.translatable("message.incantationem.forging_touch.applied"), Formatting.GOLD);
                }
            } else {
                itemsToDropList.add(preForgingItems);
            }

        }
        return itemsToDropList;
    }
}