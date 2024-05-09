package me.luligabi.incantationem.common.common.enchantment.curse;

import me.luligabi.incantationem.common.common.Incantationem;
import me.luligabi.incantationem.common.common.enchantment.IncantationemEnchantment;
import net.minecraft.stats.Stats;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.level.block.Block;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

/*
 * Original idea by u/celerysatan @ https://reddit.com/r/minecraftsuggestions/comments/mzyf9q/a_curse_with_a_compromise_curse_of_recklessness/
 */
public class RecklessnessCurse extends IncantationemEnchantment {

    public RecklessnessCurse() {
        super(
            "recklessness",
            Enchantment.definition(
                ItemTags.MINING_ENCHANTABLE,
                5,
                1,
                Enchantment.dynamicCost(0, 25),
                Enchantment.dynamicCost(25, 50),
                2,
                EquipmentSlot.MAINHAND, EquipmentSlot.OFFHAND
            ),
            Incantationem.CONFIG.curses.recklessness.availableRandomly,
            Incantationem.CONFIG.curses.recklessness.availableForBookOffer,
            Incantationem.CONFIG.curses.recklessness.availableAsTreasure
        );
    }

    @Override
    public boolean isCurse() {
        return true;
    }

    public static void apply(Player player, Block block, CallbackInfo ci) {
        if(EnchantmentHelper.getEnchantmentLevel(CurseRegistry.RECKLESSNESS.get(), player) < 1) return;

        player.awardStat(Stats.BLOCK_MINED.get(block));
        player.causeFoodExhaustion(0.005F);
        ci.cancel();
    }

}