package me.luligabi.incantationem.curse;

import me.luligabi.incantationem.Util;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.*;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.world.GameRules;

// Curse of the Thunders
public class ThunderCurse extends Enchantment {

    public ThunderCurse() {
        super(Rarity.VERY_RARE, EnchantmentTarget.ARMOR_HEAD, new EquipmentSlot[]{EquipmentSlot.HEAD});
    }

    public int getMinPower(int level) { return level * 25; }

    public int getMaxPower(int level) { return this.getMinPower(level) + 50; }

    public int getMaxLevel() { return 1; }

    public boolean isTreasure() { return true; }

    public boolean isCursed() { return true; }

    public boolean isAvailableForEnchantedBookOffer() {
        return false;
    }

    @Override
    public void onUserDamaged(LivingEntity user, Entity attacker, int level) {
        if(Util.negativeEffectRandomNumber(user, user.getRandom(), 1, 10) == 1) {
            LightningEntity lightningEntity = EntityType.LIGHTNING_BOLT.create(user.getEntityWorld());
            lightningEntity.setCosmetic(!user.getEntityWorld().getGameRules().getBoolean(GameRules.DO_MOB_GRIEFING));
            lightningEntity.refreshPositionAfterTeleport(user.getPos().x, user.getPos().y, user.getPos().z);
            user.getEntityWorld().spawnEntity(lightningEntity);

            Util.sendActionBarMessage(user, Text.translatable("message.incantationem.thunder.applied"), Formatting.YELLOW);
        }
        super.onUserDamaged(user, attacker, level);
    }
}