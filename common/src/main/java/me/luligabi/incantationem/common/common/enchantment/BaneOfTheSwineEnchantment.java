package me.luligabi.incantationem.common.common.enchantment;

import me.luligabi.incantationem.common.common.Incantationem;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MobType;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentCategory;

/*
 * Original idea by u/nonexistnt @ https://reddit.com/r/minecraftsuggestions/comments/kpqs0r/new_enchantment_bane_of_the_swine/
 */
public class BaneOfTheSwineEnchantment extends IncantationemEnchantment {

    public BaneOfTheSwineEnchantment() {
        super(
            "swine_bane",
            Rarity.UNCOMMON,
            EnchantmentCategory.WEAPON,
            new EquipmentSlot[]{EquipmentSlot.MAINHAND, EquipmentSlot.OFFHAND},
            Incantationem.CONFIG.baneOfTheSwineMaxLevel,
            Incantationem.CONFIG.baneOfTheSwineAvailableForBookOffer,
            Incantationem.CONFIG.baneOfTheSwineAvailableRandomly,
            Incantationem.CONFIG.baneOfTheSwineAvailableAsTreasure
        );
    }

    @Override
    public int getMinCost(int level) {
        return 20 + 20 * (level - 1);
    }

    @Override
    public int getMaxCost(int level) {
        return super.getMinCost(level) + 60;
    }

    @Override
    public boolean checkCompatibility(Enchantment enchantment) {
        return super.checkCompatibility(enchantment) && !(enchantment instanceof BaneOfTheSwineEnchantment);
    }

    @Override
    public boolean canEnchant(ItemStack stack) {
        return super.canEnchant(stack) || stack.getItem() instanceof AxeItem;
    }

    @Override
    public float getDamageBonus(int level, MobType mobType) {
        return mobType == Incantationem.SWINE ? (float)level * 2.5F : 0.0F;
    }

    @Override
    public void doPostAttack(LivingEntity user, Entity target, int level) {
        if(target instanceof LivingEntity livingEntity) {
            if(livingEntity.getMobType() == Incantationem.SWINE) {
                int randomEffectTimer = 20 + user.getRandom().nextInt(10 * level);
                livingEntity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, randomEffectTimer, 3));
            }
        }
    }

}