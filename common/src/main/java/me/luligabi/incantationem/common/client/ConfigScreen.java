package me.luligabi.incantationem.common.client;

import dev.isxander.yacl3.api.*;
import dev.isxander.yacl3.api.controller.BooleanControllerBuilder;
import dev.isxander.yacl3.api.controller.IntegerFieldControllerBuilder;
import me.luligabi.incantationem.common.common.Incantationem;
import me.luligabi.incantationem.common.common.ModConfig;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;

public class ConfigScreen {

    public static Screen createConfigScreen(Screen parent) {
        ModConfig config = Incantationem.CONFIG;


        /*
         * ENCHANTMENTS
         */
        // Decay
        Option<Boolean> decayIsLuckBased = isLuckBased()
            .binding(
                true,
                () -> config.enchantments.decay.isLuckBased,
                newValue -> config.enchantments.decay.isLuckBased = newValue
            )
            .build();

        Option<Integer> decaySuccessRate = successRate(config.enchantments.decay.isLuckBased)
            .binding(
                10,
                () -> config.enchantments.decay.successRate,
                newValue -> config.enchantments.decay.successRate = newValue
            )
            .build();

        Option<Boolean> decayShowApplyMessage = showApplyMessage()
            .binding(
                true,
                () -> config.enchantments.decay.showApplyMessage,
                newValue -> config.enchantments.decay.showApplyMessage = newValue
            )
            .build();


        // Deflection
        Option<Boolean> deflectionIsLuckBased = isLuckBased()
            .binding(
                true,
                () -> config.enchantments.deflection.isLuckBased,
                newValue -> config.enchantments.deflection.isLuckBased = newValue
            )
            .build();

        Option<Integer> deflectionSuccessRate = successRate(config.enchantments.deflection.isLuckBased)
            .binding(
                4,
                () -> config.enchantments.deflection.successRate,
                newValue -> config.enchantments.deflection.successRate = newValue
            )
            .build();

        Option<Boolean> deflectionShowApplyMessage = showApplyMessage()
            .binding(
                true,
                () -> config.enchantments.deflection.showApplyMessage,
                newValue -> config.enchantments.deflection.showApplyMessage = newValue
            )
            .build();

        // Forging Touch
        Option<Boolean> forgingTouchIsLuckBased = isLuckBased()
            .binding(
                true,
                () -> config.enchantments.forgingTouch.isLuckBased,
                newValue -> config.enchantments.forgingTouch.isLuckBased = newValue
            )
            .build();

        Option<Integer> forgingTouchSuccessRate = successRate(config.enchantments.forgingTouch.isLuckBased)
            .binding(
                15,
                () -> config.enchantments.forgingTouch.successRate,
                newValue -> config.enchantments.forgingTouch.successRate = newValue
            )
            .build();

        Option<Boolean> forgingTouchShowApplyMessage = showApplyMessage()
            .binding(
                true,
                () -> config.enchantments.forgingTouch.showApplyMessage,
                newValue -> config.enchantments.forgingTouch.showApplyMessage = newValue
            )
            .build();

        // Last Stand
        Option<Boolean> lastStandIsLuckBased = isLuckBased()
            .binding(
                true,
                () -> config.enchantments.lastStand.isLuckBased,
                newValue -> config.enchantments.lastStand.isLuckBased = newValue
            )
            .build();

        Option<Integer> lastStandSuccessRate = successRate(config.enchantments.lastStand.isLuckBased)
            .binding(
                30,
                () -> config.enchantments.lastStand.successRate,
                newValue -> config.enchantments.lastStand.successRate = newValue
            )
            .build();

        Option<Boolean> lastStandShowApplyMessage = showApplyMessage()
            .binding(
                true,
                () -> config.enchantments.lastStand.showApplyMessage,
                newValue -> config.enchantments.lastStand.showApplyMessage = newValue
            )
            .build();

        // Reaping Rod

        Option<Boolean> reapingRodShowApplyMessage = showApplyMessage()
            .binding(
                true,
                () -> config.enchantments.reapingRod.showApplyMessage,
                newValue -> config.enchantments.reapingRod.showApplyMessage = newValue
            )
            .build();

        // Retreat
        Option<Boolean> retreatIsLuckBased = isLuckBased()
            .binding(
                true,
                () -> config.enchantments.retreat.isLuckBased,
                newValue -> config.enchantments.retreat.isLuckBased = newValue
            )
            .build();

        Option<Integer> retreatSuccessRate = successRate(config.enchantments.retreat.isLuckBased)
            .binding(
                20,
                () -> config.enchantments.retreat.successRate,
                newValue -> config.enchantments.retreat.successRate = newValue
            )
            .build();

        Option<Boolean> retreatShowApplyMessage = showApplyMessage()
            .binding(
                true,
                () -> config.enchantments.retreat.showApplyMessage,
                newValue -> config.enchantments.retreat.showApplyMessage = newValue
            )
            .build();

        // Venomous
        Option<Boolean> venomousIsLuckBased = isLuckBased()
            .binding(
                true,
                () -> config.enchantments.venomous.isLuckBased,
                newValue -> config.enchantments.venomous.isLuckBased = newValue
            )
            .build();

        Option<Integer> venomousSuccessRate = successRate(config.enchantments.venomous.isLuckBased)
            .binding(
                15,
                () -> config.enchantments.venomous.successRate,
                newValue -> config.enchantments.venomous.successRate = newValue
            )
            .build();

        Option<Boolean> venomousShowApplyMessage = showApplyMessage()
            .binding(
                true,
                () -> config.enchantments.venomous.showApplyMessage,
                newValue -> config.enchantments.venomous.showApplyMessage = newValue
            )
            .build();

        /*
         * CURSES
         */
        // Curse of the Thunders
        Option<Boolean> thunderIsLuckBased = isLuckBased()
            .binding(
                true,
                () -> config.curses.thunder.isLuckBased,
                newValue -> config.curses.thunder.isLuckBased = newValue
            )
            .build();

        Option<Integer> thunderSuccessRate = successRate(config.curses.thunder.isLuckBased)
            .binding(
                15,
                () -> config.curses.thunder.successRate,
                newValue -> config.curses.thunder.successRate = newValue
            )
            .build();

        Option<Boolean> thunderShowApplyMessage = showApplyMessage()
            .binding(
                true,
                () -> config.curses.thunder.showApplyMessage,
                newValue -> config.curses.thunder.showApplyMessage = newValue
            )
            .build();

        return YetAnotherConfigLib.createBuilder()
            .title(Component.literal("Incantationem"))
            .category(ConfigCategory.createBuilder()
                .name(Component.translatable("configCategory.incantationem.enchantment"))
                .group(
                    createLuckBasedEnchantmentGroup(
                        "decay",
                        decayIsLuckBased,
                        decaySuccessRate,
                        decayShowApplyMessage
                    )
                )
                .group(
                    createLuckBasedEnchantmentGroup(
                        "deflection",
                        deflectionIsLuckBased,
                        deflectionSuccessRate,
                        deflectionShowApplyMessage
                    )
                )
                .group(
                    createLuckBasedEnchantmentGroup(
                        "forging_touch",
                        forgingTouchIsLuckBased,
                        forgingTouchSuccessRate,
                        forgingTouchShowApplyMessage
                    )
                )
                .group(
                    createLuckBasedEnchantmentGroup(
                        "last_stand",
                        lastStandIsLuckBased,
                        lastStandSuccessRate,
                        lastStandShowApplyMessage
                    )
                )
                .group(
                    createApplyMessageOnlyEnchantmentGroup(
                        "reaping_rod",
                        reapingRodShowApplyMessage
                    )
                )
                .group(
                    createLuckBasedEnchantmentGroup(
                        "retreat",
                        retreatIsLuckBased,
                        retreatSuccessRate,
                        retreatShowApplyMessage
                    )
                )
                .group(
                    createLuckBasedEnchantmentGroup(
                        "venomous",
                        venomousIsLuckBased,
                        venomousSuccessRate,
                        venomousShowApplyMessage
                    )
                )
                .build())
            .category(ConfigCategory.createBuilder()
                .name(Component.translatable("configCategory.incantationem.curse"))
                .group(
                    createLuckBasedEnchantmentGroup(
                        "thunder",
                        thunderIsLuckBased,
                        thunderSuccessRate,
                        thunderShowApplyMessage
                    )
                )
                .build())
            .save(ModConfig.HANDLER::save)
            .build()
            .generateScreen(parent);
    }

    private static Option.Builder<Boolean> isLuckBased() {
        return Option.<Boolean>createBuilder()
            .name(Component.translatable("configOption.incantationem.isLuckBased"))
            .description(OptionDescription.of(Component.translatable("configOption.incantationem.isLuckBased.tooltip")))
            .controller(option -> BooleanControllerBuilder.create(option).yesNoFormatter().coloured(true));
    }

    private static Option.Builder<Integer> successRate(boolean available) {
        return Option.<Integer>createBuilder()
            .name(Component.translatable("configOption.incantationem.successRate"))
            .description(OptionDescription.of(Component.translatable("configOption.incantationem.successRate.tooltip")))
            .controller(option -> IntegerFieldControllerBuilder.create(option).min(0).max(100))
            .available(available);
    }

    private static Option.Builder<Boolean> showApplyMessage() {
        return Option.<Boolean>createBuilder()
            .name(Component.translatable("configOption.incantationem.showApplyMessage"))
            .description(OptionDescription.of(Component.translatable("configOption.incantationem.showApplyMessage.tooltip")))
            .controller(option -> BooleanControllerBuilder.create(option).yesNoFormatter().coloured(true))
            .flag(OptionFlag.GAME_RESTART);
    }


    private static OptionGroup createLuckBasedEnchantmentGroup(String enchantmentId, Option<Boolean> isLuckBased, Option<Integer> successRate, Option<Boolean> showApplyMessage) {
        return OptionGroup.createBuilder()
            .name(Component.translatable("enchantment.incantationem." + enchantmentId))
            .description(OptionDescription.of(Component.translatable(String.format("enchantment.incantationem.%s.desc", enchantmentId))))
            .collapsed(true)
            .option(isLuckBased)
            .option(successRate)
            .option(showApplyMessage)
            .build();
    }

    private static OptionGroup createApplyMessageOnlyEnchantmentGroup(String enchantmentId, Option<Boolean> showApplyMessage) {
        return OptionGroup.createBuilder()
            .name(Component.translatable("enchantment.incantationem." + enchantmentId))
            .description(OptionDescription.of(Component.translatable(String.format("enchantment.incantationem.%s.desc", enchantmentId))))
            .collapsed(true)
            .option(showApplyMessage)
            .build();
    }

}