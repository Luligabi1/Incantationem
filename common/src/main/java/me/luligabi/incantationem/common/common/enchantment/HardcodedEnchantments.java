package me.luligabi.incantationem.common.common.enchantment;

import me.luligabi.incantationem.common.common.Incantationem;
import me.luligabi.incantationem.common.common.util.EffectAppliedMessage;
import me.luligabi.incantationem.common.common.util.Util;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.stats.Stats;
import net.minecraft.util.Mth;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeHolder;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.item.crafting.SmeltingRecipe;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class HardcodedEnchantments { // TODO attempt to move these onto Mojang's system


    public static boolean deflection(LivingEntity user) {
        // Sum the Deflection level on all armor pieces
        int deflectionLevel = 0;
        for(EquipmentSlot slot : EquipmentSlot.values()) {
            if(!slot.isArmor()) continue;
            deflectionLevel += Util.getItemEnchantmentLevel(
                "deflection",
                user.getItemBySlot(slot),
                user.level()
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

    public static List<ItemStack> forgingTouch(List<ItemStack> original, ServerLevel level, Entity entity, ItemStack stack) {
        List<ItemStack> itemsToDropList = new ArrayList<>();
        int forgingTouchLevel = Util.getItemEnchantmentLevel(
            "forging_touch",
            stack,
            entity.level()
        );
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

    public static void fuseShot(LivingEntity attacker, AbstractArrow arrow, @Nullable Entity hitEntity, Vec3 pos, Level level, int i) {
        if(i < 1) return;
        DamageSource damageSource = attacker.damageSources().explosion(arrow, attacker);
        float damage = (float) Mth.clamp(arrow.getDeltaMovement().length(), 0.1, i * 1.25);

        level.explode(
            hitEntity,
            damageSource,
            null,
            pos.x, pos.y, pos.z,
            damage, false, Level.ExplosionInteraction.NONE
        );
    }

    public static void venomous(LivingEntity attacker, LivingEntity hitEntity, int i) {
        if(i < 1) return;
        if(!Util.positiveEffectRandomNumber(attacker, attacker.getRandom(), (100 - (i * 15)), Incantationem.CONFIG.enchantments.venomous.isLuckBased)) return;

        Util.applyEffectIfNotPresent(hitEntity, MobEffects.POISON, hitEntity.getRandom().nextInt(i + 2), i - 1);
        Util.sendEffectAppliedMessage(attacker, EffectAppliedMessage.VENOMOUS);
    }

    /*
     * CURSES
     */
    public static void recklessness(Player player, Block block, CallbackInfo ci) {
        int i = Util.getEnchantmentLevel(
            "recklessness",
            player,
            player.level()
        );
        if(i < 1) return;

        player.awardStat(Stats.BLOCK_MINED.get(block));
        player.causeFoodExhaustion(0.005F);
        ci.cancel();
    }

    public static void shrieking(ServerPlayer player) {
        int i = Util.getEnchantmentLevel(
            "shrieking",
            player,
            player.level()
        );
        if(i > 0) {
            player.getWardenSpawnTracker().ifPresent(wardenSpawnTracker -> {
                wardenSpawnTracker.setWarningLevel(wardenSpawnTracker.getWarningLevel() + 2);
            });
        }
    }
}