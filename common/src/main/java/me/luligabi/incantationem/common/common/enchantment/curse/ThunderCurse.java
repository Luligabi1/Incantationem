package me.luligabi.incantationem.common.common.enchantment.curse;

import me.luligabi.incantationem.common.common.Incantationem;
import me.luligabi.incantationem.common.common.Util;
import me.luligabi.incantationem.common.common.enchantment.IncantationemEnchantment;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.*;
import net.minecraft.world.item.enchantment.EnchantmentCategory;
import net.minecraft.world.level.GameRules;

public class ThunderCurse extends IncantationemEnchantment {

    public ThunderCurse() {
        super(
            "thunder",
            Rarity.VERY_RARE,
            EnchantmentCategory.ARMOR_HEAD,
            new EquipmentSlot[]{EquipmentSlot.HEAD},
            Incantationem.CONFIG.thunderAvailableForBookOffer,
            true,
            Incantationem.CONFIG.thunderAvailableAsTreasure
        );
    }

    @Override
    public int getMinCost(int level) {
        return level * 25;
    }

    @Override
    public int getMaxCost(int level) {
        return this.getMinCost(level) + 50;
    }

    @Override
    public boolean isCurse() {
        return true;
    }



    @Override
    public void doPostHurt(LivingEntity user, Entity attacker, int level) {
        if(Util.negativeEffectRandomNumber(user, user.getRandom(), 1, 10) != 1) return;
        LightningBolt lightningEntity = EntityType.LIGHTNING_BOLT.create(user.level());
        lightningEntity.setVisualOnly(!user.level().getGameRules().getBoolean(GameRules.RULE_MOBGRIEFING));
        lightningEntity.moveTo(user.blockPosition().getX(), user.blockPosition().getY(), user.blockPosition().getZ());
        user.level().addFreshEntity(lightningEntity);

        Util.sendActionBarMessage(user, Component.translatable("message.incantationem.thunder.applied"), ChatFormatting.YELLOW);
    }

}