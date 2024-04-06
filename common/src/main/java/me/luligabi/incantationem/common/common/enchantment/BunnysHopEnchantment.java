package me.luligabi.incantationem.common.common.enchantment;

import me.luligabi.incantationem.common.common.Incantationem;
import me.luligabi.incantationem.common.common.Util;
import me.luligabi.incantationem.common.mixin.EntityInvoker;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.enchantment.EnchantmentCategory;
import net.minecraft.world.level.block.state.BlockState;

public class BunnysHopEnchantment extends IncantationemEnchantment {

    public BunnysHopEnchantment() {
        super(
            "bunnys_hop",
            Rarity.UNCOMMON,
            EnchantmentCategory.ARMOR_FEET,
            new EquipmentSlot[]{EquipmentSlot.FEET},
            Incantationem.CONFIG.enchantments.bunnysHop.maxLevel,
            Incantationem.CONFIG.enchantments.bunnysHop.availableForBookOffer,
            Incantationem.CONFIG.enchantments.bunnysHop.availableRandomly,
            Incantationem.CONFIG.enchantments.bunnysHop.availableAsTreasure
        );
    }

    @Override
    public int getMinCost(int level) { return 10 + 10 * (level - 1); }

    @Override
    public int getMaxCost(int level) {
            return 50;
    }

    public static void apply(LivingEntity user, int i) {
        if(user.hasEffect(MobEffects.JUMP)) return;
        BlockState floor = user.level().getBlockState(((EntityInvoker) user).invokeGetVelocityAffectingPos());

        if(floor.is(BlockTags.DIRT)) {
            Util.applyEffectIfNotPresent(user, MobEffects.JUMP, 4, i - 1);
        }
    }

}