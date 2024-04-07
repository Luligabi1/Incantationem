package me.luligabi.incantationem.common.common.util;

import me.luligabi.incantationem.common.common.Incantationem;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;

public enum EffectAppliedMessage {

    DECAY(Incantationem.CONFIG.enchantments.decay.showApplyMessage, "decay", ChatFormatting.GRAY),
    FORGING_TOUCH(Incantationem.CONFIG.enchantments.forgingTouch.showApplyMessage, "forging_touch", ChatFormatting.GOLD),
    LAST_STAND(Incantationem.CONFIG.enchantments.lastStand.showApplyMessage, "last_stand", ChatFormatting.GOLD),
    REAPING_ROD(Incantationem.CONFIG.enchantments.reapingRod.showApplyMessage, "reaping_rod", ChatFormatting.LIGHT_PURPLE),
    RETREAT(Incantationem.CONFIG.enchantments.retreat.showApplyMessage, "retreat", ChatFormatting.AQUA),
    VENOMOUS(Incantationem.CONFIG.enchantments.venomous.showApplyMessage, "venomous", ChatFormatting.DARK_GREEN),
    THUNDER(Incantationem.CONFIG.curses.thunder.showApplyMessage, "thunder", ChatFormatting.YELLOW);

    EffectAppliedMessage(boolean canShow, String id, ChatFormatting color) {
        this.canShow = canShow;
        this.component = Component.translatable(String.format("message.incantationem.%s.applied", id)).withStyle(color);
    }

    public final boolean canShow;
    public final Component component;
}