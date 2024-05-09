package me.luligabi.incantationem.common.common.enchantment;

import me.luligabi.incantationem.common.common.Incantationem;
import me.luligabi.incantationem.common.common.util.Util;
import me.luligabi.incantationem.common.mixin.EntityInvoker;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.level.block.state.BlockState;

public class BunnysHopEnchantment extends IncantationemEnchantment {

    public BunnysHopEnchantment() {
        super(
            "bunnys_hop",
            Enchantment.definition(
                ItemTags.FOOT_ARMOR_ENCHANTABLE,
                5,
                Incantationem.CONFIG.enchantments.bunnysHop.maxLevel,
                Enchantment.dynamicCost(10, 10),
                Enchantment.constantCost(50),
                2,
                EquipmentSlot.FEET
            ),
            Incantationem.CONFIG.enchantments.bunnysHop.availableRandomly,
            Incantationem.CONFIG.enchantments.bunnysHop.availableForBookOffer,
            Incantationem.CONFIG.enchantments.bunnysHop.availableAsTreasure
        );
    }

    public static void apply(LivingEntity user, int i) {
        if(user.hasEffect(MobEffects.JUMP)) return;
        BlockState floor = user.level().getBlockState(((EntityInvoker) user).invokeGetVelocityAffectingPos());

        if(floor.is(BlockTags.DIRT)) {
            Util.applyEffectIfNotPresent(user, MobEffects.JUMP, 4, i - 1);
        }
    }

}