package me.luligabi.incantationem.mixin;

import me.luligabi.incantationem.Util;
import me.luligabi.incantationem.registry.CurseRegistry;
import me.luligabi.incantationem.registry.EnchantmentRegistry;
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
import net.minecraft.text.TranslatableText;
import net.minecraft.util.Formatting;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

@Mixin(Block.class)
public abstract class BlockMixin {

    // Mixin for Recklessness Curse.
    @Inject(method = "afterBreak",
            at = @At("HEAD"),
            cancellable = true)
    public void afterBreak(World world, PlayerEntity player, BlockPos pos, BlockState state, @Nullable BlockEntity blockEntity, ItemStack stack, CallbackInfo callbackInfo) {
        player.incrementStat(Stats.MINED.getOrCreateStat(((Block) (Object) this)));
        player.addExhaustion(0.005F);
        if(EnchantmentHelper.getEquipmentLevel(CurseRegistry.RECKLESSNESS, player) < 1) {
            Block.dropStacks(state, world, pos, blockEntity, player, stack);
        }
        callbackInfo.cancel();
    }

    //Mixin for Forging Touch Enchantment.
    @Inject(method = "getDroppedStacks(Lnet/minecraft/block/BlockState;Lnet/minecraft/server/world/ServerWorld;Lnet/minecraft/util/math/BlockPos;Lnet/minecraft/block/entity/BlockEntity;Lnet/minecraft/entity/Entity;Lnet/minecraft/item/ItemStack;)Ljava/util/List;",
            at = @At("RETURN"),
            cancellable = true)
    private static void getDroppedStacks(BlockState state, ServerWorld world, BlockPos pos, BlockEntity blockEntity, Entity entity, ItemStack stack, CallbackInfoReturnable<List<ItemStack>> callbackInfo) {
        List<ItemStack> itemsToDropList = new ArrayList<>();

        int forgingTouchLevel = EnchantmentHelper.getLevel(EnchantmentRegistry.FORGING_TOUCH, stack);
        if (forgingTouchLevel == 0) {
            callbackInfo.setReturnValue(callbackInfo.getReturnValue());
            return;
        }
        for (ItemStack preForgingItems : callbackInfo.getReturnValue()) {
            Optional<SmeltingRecipe> recipe = world.getRecipeManager().listAllOfType(RecipeType.SMELTING).stream().filter((
                    smeltingRecipe -> smeltingRecipe.getIngredients().get(0).test(preForgingItems))).findFirst();

            if (recipe.isPresent() && Util.neutralEffectRandomNumber(new Random(), 0, 10) < (forgingTouchLevel*1.5)) {
                ItemStack forgedItems = recipe.get().getOutput();
                forgedItems.setCount(preForgingItems.getCount());
                itemsToDropList.add(forgedItems);
                if(entity instanceof LivingEntity) {
                    Util.sendActionBarMessage((LivingEntity) entity, new TranslatableText("message.incantationem.forging_touch.applied"), Formatting.GOLD);
                }
            } else {
                itemsToDropList.add(preForgingItems);
            }

        }
        callbackInfo.setReturnValue(itemsToDropList);
    }
}