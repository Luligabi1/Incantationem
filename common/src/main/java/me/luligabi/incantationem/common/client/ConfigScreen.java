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
        // Bane of The Swine
        Option<Integer> baneOfTheSwineMaxLevel = maxLevel()
            .binding(
                5,
                () -> config.baneOfTheSwineMaxLevel,
                newValue -> config.baneOfTheSwineMaxLevel = newValue
            )
            .build();

        Option<Boolean> baneOfTheSwineAvailableRandomly = availableRandomly()
            .binding(
                true,
                () -> config.baneOfTheSwineAvailableRandomly,
                newValue -> config.baneOfTheSwineAvailableRandomly = newValue
            )
            .build();

        Option<Boolean> baneOfTheSwineAvailableForBookOffer = availableForBookOffer()
            .binding(
                true,
                () -> config.baneOfTheSwineAvailableForBookOffer,
                newValue -> config.baneOfTheSwineAvailableForBookOffer = newValue
            )
            .build();

        Option<Boolean> baneOfTheSwineAvailableAsTreasure = availableAsTreasure()
            .binding(
                false,
                () -> config.baneOfTheSwineAvailableAsTreasure,
                newValue -> config.baneOfTheSwineAvailableAsTreasure = newValue
            )
            .build();

        // Bunny's Hop
        Option<Integer> bunnysHopMaxLevel = maxLevel()
            .binding(
                3,
                () -> config.bunnysHopMaxLevel,
                newValue -> config.bunnysHopMaxLevel = newValue
            )
            .build();

        Option<Boolean> bunnysHopAvailableRandomly = availableRandomly()
            .binding(
                true,
                () -> config.bunnysHopAvailableRandomly,
                newValue -> config.bunnysHopAvailableRandomly = newValue
            )
            .build();

        Option<Boolean> bunnysHopAvailableForBookOffer = availableForBookOffer()
            .binding(
                true,
                () -> config.bunnysHopAvailableForBookOffer,
                newValue -> config.bunnysHopAvailableForBookOffer = newValue
            )
            .build();

        Option<Boolean> bunnysHopAvailableAsTreasure = availableAsTreasure()
            .binding(
                false,
                () -> config.bunnysHopAvailableAsTreasure,
                newValue -> config.bunnysHopAvailableAsTreasure = newValue
            )
            .build();

        // Charmed
        Option<Boolean> charmedAvailableRandomly = availableRandomly()
            .binding(
                true,
                () -> config.charmedAvailableRandomly,
                newValue -> config.charmedAvailableRandomly = newValue
            )
            .build();

        Option<Boolean> charmedAvailableForBookOffer = availableForBookOffer()
            .binding(
                true,
                () -> config.charmedAvailableForBookOffer,
                newValue -> config.charmedAvailableForBookOffer = newValue
            )
            .build();

        Option<Boolean> charmedAvailableAsTreasure = availableAsTreasure()
            .binding(
                false,
                () -> config.charmedAvailableAsTreasure,
                newValue -> config.charmedAvailableAsTreasure = newValue
            )
            .build();

        // Decay
        Option<Integer> decayMaxLevel = maxLevel()
            .binding(
                3,
                () -> config.decayMaxLevel,
                newValue -> config.decayMaxLevel = newValue
            )
            .build();

        Option<Boolean> decayAvailableRandomly = availableRandomly()
            .binding(
                true,
                () -> config.decayAvailableRandomly,
                newValue -> config.decayAvailableRandomly = newValue
            )
            .build();

        Option<Boolean> decayAvailableForBookOffer = availableForBookOffer()
            .binding(
                true,
                () -> config.decayAvailableForBookOffer,
                newValue -> config.decayAvailableForBookOffer = newValue
            )
            .build();

        Option<Boolean> decayAvailableAsTreasure = availableAsTreasure()
            .binding(
                false,
                () -> config.decayAvailableAsTreasure,
                newValue -> config.decayAvailableAsTreasure = newValue
            )
            .build();

        // Deflection
        Option<Integer> deflectionMaxLevel = maxLevel()
            .binding(
                3,
                () -> config.deflectionMaxLevel,
                newValue -> config.deflectionMaxLevel = newValue
            )
            .build();

        Option<Boolean> deflectionAvailableRandomly = availableRandomly()
            .binding(
                true,
                () -> config.deflectionAvailableRandomly,
                newValue -> config.deflectionAvailableRandomly = newValue
            )
            .build();

        Option<Boolean> deflectionAvailableForBookOffer = availableForBookOffer()
            .binding(
                true,
                () -> config.deflectionAvailableForBookOffer,
                newValue -> config.deflectionAvailableForBookOffer = newValue
            )
            .build();

        Option<Boolean> deflectionAvailableAsTreasure = availableAsTreasure()
            .binding(
                false,
                () -> config.deflectionAvailableAsTreasure,
                newValue -> config.deflectionAvailableAsTreasure = newValue
            )
            .build();

        // Fuse Shot
        Option<Integer> fuseShotMaxLevel = maxLevel()
            .binding(
                3,
                () -> config.fuseShotMaxLevel,
                newValue -> config.fuseShotMaxLevel = newValue
            )
            .build();

        Option<Boolean> fuseShotAvailableRandomly = availableRandomly()
            .binding(
                false,
                () -> config.fuseShotAvailableRandomly,
                newValue -> config.fuseShotAvailableRandomly = newValue
            )
            .build();

        Option<Boolean> fuseShotAvailableForBookOffer = availableForBookOffer()
            .binding(
                true,
                () -> config.fuseShotAvailableForBookOffer,
                newValue -> config.fuseShotAvailableForBookOffer = newValue
            )
            .build();

        Option<Boolean> fuseShotAvailableAsTreasure = availableAsTreasure()
            .binding(
                true,
                () -> config.fuseShotAvailableAsTreasure,
                newValue -> config.fuseShotAvailableAsTreasure = newValue
            )
            .build();

        // Forging Touch
        Option<Integer> forgingTouchMaxLevel = maxLevel()
            .binding(
                3,
                () -> config.forgingTouchMaxLevel,
                newValue -> config.forgingTouchMaxLevel = newValue
            )
            .build();

        Option<Boolean> forgingTouchAvailableRandomly = availableRandomly()
            .binding(
                true,
                () -> config.forgingTouchAvailableRandomly,
                newValue -> config.forgingTouchAvailableRandomly = newValue
            )
            .build();

        Option<Boolean> forgingTouchAvailableForBookOffer = availableForBookOffer()
            .binding(
                true,
                () -> config.forgingTouchAvailableForBookOffer,
                newValue -> config.forgingTouchAvailableForBookOffer = newValue
            )
            .build();

        Option<Boolean> forgingTouchAvailableAsTreasure = availableAsTreasure()
            .binding(
                true,
                () -> config.forgingTouchAvailableAsTreasure,
                newValue -> config.forgingTouchAvailableAsTreasure = newValue
            )
            .build();

        // Last Stand
        Option<Integer> lastStandMaxLevel = maxLevel()
            .binding(
                3,
                () -> config.lastStandMaxLevel,
                newValue -> config.lastStandMaxLevel = newValue
            )
            .build();

        Option<Boolean> lastStandAvailableRandomly = availableRandomly()
            .binding(
                true,
                () -> config.lastStandAvailableRandomly,
                newValue -> config.lastStandAvailableRandomly = newValue
            )
            .build();

        Option<Boolean> lastStandAvailableForBookOffer = availableForBookOffer()
            .binding(
                true,
                () -> config.lastStandAvailableForBookOffer,
                newValue -> config.lastStandAvailableForBookOffer = newValue
            )
            .build();

        Option<Boolean> lastStandAvailableAsTreasure = availableAsTreasure()
            .binding(
                false,
                () -> config.lastStandAvailableAsTreasure,
                newValue -> config.lastStandAvailableAsTreasure = newValue
            )
            .build();

        // Magnetic
        Option<Integer> magneticMaxLevel = maxLevel()
            .binding(
                3,
                () -> config.magneticMaxLevel,
                newValue -> config.magneticMaxLevel = newValue
            )
            .build();

        Option<Boolean> magneticAvailableRandomly = availableRandomly()
            .binding(
                true,
                () -> config.magneticAvailableRandomly,
                newValue -> config.magneticAvailableRandomly = newValue
            )
            .build();

        Option<Boolean> magneticAvailableForBookOffer = availableForBookOffer()
            .binding(
                true,
                () -> config.magneticAvailableForBookOffer,
                newValue -> config.magneticAvailableForBookOffer = newValue
            )
            .build();

        Option<Boolean> magneticAvailableAsTreasure = availableAsTreasure()
            .binding(
                false,
                () -> config.magneticAvailableAsTreasure,
                newValue -> config.magneticAvailableAsTreasure = newValue
            )
            .build();

        // Reaping Rod
        Option<Boolean> reapingRodAvailableRandomly = availableRandomly()
            .binding(
                true,
                () -> config.reapingRodAvailableRandomly,
                newValue -> config.reapingRodAvailableRandomly = newValue
            )
            .build();

        Option<Boolean> reapingRodAvailableForBookOffer = availableForBookOffer()
            .binding(
                true,
                () -> config.reapingRodAvailableForBookOffer,
                newValue -> config.reapingRodAvailableForBookOffer = newValue
            )
            .build();

        Option<Boolean> reapingRodAvailableAsTreasure = availableAsTreasure()
            .binding(
                false,
                () -> config.reapingRodAvailableAsTreasure,
                newValue -> config.reapingRodAvailableAsTreasure = newValue
            )
            .build();

        // Retreat
        Option<Boolean> retreatAvailableRandomly = availableRandomly()
            .binding(
                true,
                () -> config.retreatAvailableRandomly,
                newValue -> config.retreatAvailableRandomly = newValue
            )
            .build();

        Option<Boolean> retreatAvailableForBookOffer = availableForBookOffer()
            .binding(
                true,
                () -> config.retreatAvailableForBookOffer,
                newValue -> config.retreatAvailableForBookOffer = newValue
            )
            .build();

        Option<Boolean> retreatAvailableAsTreasure = availableAsTreasure()
            .binding(
                false,
                () -> config.retreatAvailableAsTreasure,
                newValue -> config.retreatAvailableAsTreasure = newValue
            )
            .build();

        // Venomous
        Option<Integer> venomousMaxLevel = maxLevel()
            .binding(
                3,
                () -> config.venomousMaxLevel,
                newValue -> config.venomousMaxLevel = newValue
            )
            .build();

        Option<Boolean> venomousAvailableRandomly = availableRandomly()
            .binding(
                true,
                () -> config.venomousAvailableRandomly,
                newValue -> config.venomousAvailableRandomly = newValue
            )
            .build();

        Option<Boolean> venomousAvailableForBookOffer = availableForBookOffer()
            .binding(
                true,
                () -> config.venomousAvailableForBookOffer,
                newValue -> config.venomousAvailableForBookOffer = newValue
            )
            .build();

        Option<Boolean> venomousAvailableAsTreasure = availableAsTreasure()
            .binding(
                false,
                () -> config.venomousAvailableAsTreasure,
                newValue -> config.venomousAvailableAsTreasure = newValue
            )
            .build();

        // Water Slash
        Option<Integer> waterSlashMaxLevel = maxLevel()
            .binding(
                5,
                () -> config.waterSlashMaxLevel,
                newValue -> config.waterSlashMaxLevel = newValue
            )
            .build();

        Option<Boolean> waterSlashAvailableRandomly = availableRandomly()
            .binding(
                true,
                () -> config.waterSlashAvailableRandomly,
                newValue -> config.waterSlashAvailableRandomly = newValue
            )
            .build();

        Option<Boolean> waterSlashAvailableForBookOffer = availableForBookOffer()
            .binding(
                true,
                () -> config.waterSlashAvailableForBookOffer,
                newValue -> config.waterSlashAvailableForBookOffer = newValue
            )
            .build();

        Option<Boolean> waterSlashAvailableAsTreasure = availableAsTreasure()
            .binding(
                false,
                () -> config.waterSlashAvailableAsTreasure,
                newValue -> config.waterSlashAvailableAsTreasure = newValue
            )
            .build();

        /*
         * CURSES
         */
        // Curse of Recklessness
        Option<Boolean> recklessnessAvailableForBookOffer = availableForBookOffer()
            .binding(
                true,
                () -> config.recklessnessAvailableForBookOffer,
                newValue -> config.recklessnessAvailableForBookOffer = newValue
            )
            .build();

        Option<Boolean> recklessnessAvailableAsTreasure = availableAsTreasure()
            .binding(
                true,
                () -> config.recklessnessAvailableAsTreasure,
                newValue -> config.recklessnessAvailableAsTreasure = newValue
            )
            .build();

        // Curse of Shrieking
        Option<Boolean> shriekingAvailableForBookOffer = availableForBookOffer()
            .binding(
                true,
                () -> config.shriekingAvailableForBookOffer,
                newValue -> config.shriekingAvailableForBookOffer = newValue
            )
            .build();

        Option<Boolean> shriekingAvailableAsTreasure = availableAsTreasure()
            .binding(
                true,
                () -> config.shriekingAvailableAsTreasure,
                newValue -> config.shriekingAvailableAsTreasure = newValue
            )
            .build();

        // Curse of the Thunders
        Option<Boolean> thunderAvailableForBookOffer = availableForBookOffer()
            .binding(
                true,
                () -> config.thunderAvailableForBookOffer,
                newValue -> config.thunderAvailableForBookOffer = newValue
            )
            .build();

        Option<Boolean> thunderAvailableAsTreasure = availableAsTreasure()
            .binding(
                true,
                () -> config.thunderAvailableAsTreasure,
                newValue -> config.thunderAvailableAsTreasure = newValue
            )
            .build();

        // Curse of Tough Luck
        Option<Boolean> toughLuckAvailableForBookOffer = availableForBookOffer()
            .binding(
                true,
                () -> config.toughLuckAvailableForBookOffer,
                newValue -> config.toughLuckAvailableForBookOffer = newValue
            )
            .build();

        Option<Boolean> toughLuckAvailableAsTreasure = availableAsTreasure()
            .binding(
                true,
                () -> config.toughLuckAvailableAsTreasure,
                newValue -> config.toughLuckAvailableAsTreasure = newValue
            )
            .build();


        return YetAnotherConfigLib.createBuilder()
            .title(Component.literal("Incantationem"))
            .category(ConfigCategory.createBuilder()
                .name(Component.translatable("configCategory.incantationem.enchantment"))
                .group(
                    createEnchantmentGroup(
                        "swine_bane",
                        baneOfTheSwineMaxLevel,
                        baneOfTheSwineAvailableRandomly,
                        baneOfTheSwineAvailableForBookOffer,
                        baneOfTheSwineAvailableAsTreasure
                    )
                )
                .group(
                    createEnchantmentGroup(
                        "bunnys_hop",
                        bunnysHopMaxLevel,
                        bunnysHopAvailableRandomly,
                        bunnysHopAvailableForBookOffer,
                        bunnysHopAvailableAsTreasure
                    )
                )
                .group(
                    createLevellessEnchantmentGroup(
                        "charmed",
                        charmedAvailableRandomly,
                        charmedAvailableForBookOffer,
                        charmedAvailableAsTreasure
                    )
                )
                .group(
                    createEnchantmentGroup(
                        "decay",
                        decayMaxLevel,
                        decayAvailableRandomly,
                        decayAvailableForBookOffer,
                        decayAvailableAsTreasure
                    )
                )
                .group(
                    createEnchantmentGroup(
                        "deflection",
                        deflectionMaxLevel,
                        deflectionAvailableRandomly,
                        deflectionAvailableForBookOffer,
                        deflectionAvailableAsTreasure
                    )
                )
                .group(
                    createEnchantmentGroup(
                        "fuse_shot",
                        fuseShotMaxLevel,
                        fuseShotAvailableRandomly,
                        fuseShotAvailableForBookOffer,
                        fuseShotAvailableAsTreasure
                    )
                )
                .group(
                    createEnchantmentGroup(
                        "forging_touch",
                        forgingTouchMaxLevel,
                        forgingTouchAvailableRandomly,
                        forgingTouchAvailableForBookOffer,
                        forgingTouchAvailableAsTreasure
                    )
                )
                .group(
                    createEnchantmentGroup(
                        "last_stand",
                        lastStandMaxLevel,
                        lastStandAvailableRandomly,
                        lastStandAvailableForBookOffer,
                        lastStandAvailableAsTreasure
                    )
                )
                .group(
                    createEnchantmentGroup(
                        "magnetic",
                        magneticMaxLevel,
                        magneticAvailableRandomly,
                        magneticAvailableForBookOffer,
                        magneticAvailableAsTreasure
                    )
                )
                .group(
                    createLevellessEnchantmentGroup(
                        "reaping_rod",
                        reapingRodAvailableRandomly,
                        reapingRodAvailableForBookOffer,
                        reapingRodAvailableAsTreasure
                    )
                )
                .group(
                    createLevellessEnchantmentGroup(
                        "retreat",
                        retreatAvailableRandomly,
                        retreatAvailableForBookOffer,
                        retreatAvailableAsTreasure
                    )
                )
                .group(
                    createEnchantmentGroup(
                        "venomous",
                        venomousMaxLevel,
                        venomousAvailableRandomly,
                        venomousAvailableForBookOffer,
                        venomousAvailableAsTreasure
                    )
                )
                .group(
                    createEnchantmentGroup(
                        "water_slash",
                        waterSlashMaxLevel,
                        waterSlashAvailableRandomly,
                        waterSlashAvailableForBookOffer,
                        waterSlashAvailableAsTreasure
                    )
                )
                .build())
            .category(ConfigCategory.createBuilder()
                .name(Component.translatable("configCategory.incantationem.curse"))
                .group(
                    createCurseGroup(
                        "recklessness",
                        recklessnessAvailableForBookOffer,
                        recklessnessAvailableAsTreasure
                    )
                )
                .group(
                    createCurseGroup(
                        "shrieking",
                        shriekingAvailableForBookOffer,
                        shriekingAvailableAsTreasure
                    )
                )
                .group(
                    createCurseGroup(
                        "thunder",
                        thunderAvailableForBookOffer,
                        thunderAvailableAsTreasure
                    )
                )
                .group(
                    createCurseGroup(
                        "tough_luck",
                        toughLuckAvailableForBookOffer,
                        toughLuckAvailableAsTreasure
                    )
                )
                .build())
            .save(ModConfig.HANDLER::save)
            .build()
            .generateScreen(parent);
    }


    private static Option.Builder<Integer> maxLevel() {
        return Option.<Integer>createBuilder()
            .name(Component.translatable("configOption.incantationem.maxLevel"))
            .description(OptionDescription.of(Component.translatable("configOption.incantationem.maxLevel.tooltip")))
            .controller(option -> IntegerFieldControllerBuilder.create(option).range(1, 10));
    }

    private static Option.Builder<Boolean> availableRandomly() {
        return Option.<Boolean>createBuilder()
            .name(Component.translatable("configOption.incantationem.availableRandomly"))
            .description(OptionDescription.of(Component.translatable("configOption.incantationem.availableRandomly.tooltip")))
            .controller(option -> BooleanControllerBuilder.create(option).yesNoFormatter().coloured(true));
    }

    private static Option.Builder<Boolean> availableForBookOffer() {
        return Option.<Boolean>createBuilder()
            .name(Component.translatable("configOption.incantationem.availableForBookOffer"))
            .description(OptionDescription.of(Component.translatable("configOption.incantationem.availableForBookOffer.tooltip")))
            .controller(option -> BooleanControllerBuilder.create(option).yesNoFormatter().coloured(true));
    }

    private static Option.Builder<Boolean> availableAsTreasure() {
        return Option.<Boolean>createBuilder()
            .name(Component.translatable("configOption.incantationem.availableAsTreasure"))
            .description(OptionDescription.of(Component.translatable("configOption.incantationem.availableAsTreasure.tooltip")))
            .controller(option -> BooleanControllerBuilder.create(option).yesNoFormatter().coloured(true));
    }


    private static OptionGroup createEnchantmentGroup(String enchantmentId, Option<Integer> maxLevel, Option<Boolean> availableRandomly, Option<Boolean> availableForBookOffer, Option<Boolean> availableAsTreasure) {
        return OptionGroup.createBuilder()
            .name(Component.translatable("enchantment.incantationem." + enchantmentId))
            .description(OptionDescription.of(Component.translatable(String.format("enchantment.incantationem.%s.desc", enchantmentId))))
            .option(maxLevel)
            .option(availableRandomly)
            .option(availableForBookOffer)
            .option(availableAsTreasure)
            .build();
    }

    private static OptionGroup createLevellessEnchantmentGroup(String enchantmentId, Option<Boolean> availableRandomly, Option<Boolean> availableForBookOffer, Option<Boolean> availableAsTreasure) {
        return OptionGroup.createBuilder()
            .name(Component.translatable("enchantment.incantationem." + enchantmentId))
            .description(OptionDescription.of(Component.translatable(String.format("enchantment.incantationem.%s.desc", enchantmentId))))
            .option(availableRandomly)
            .option(availableForBookOffer)
            .option(availableAsTreasure)
            .build();
    }

    private static OptionGroup createCurseGroup(String enchantmentId, Option<Boolean> availableForBookOffer, Option<Boolean> availableAsTreasure) {
        return OptionGroup.createBuilder()
            .name(Component.translatable("enchantment.incantationem." + enchantmentId))
            .description(OptionDescription.of(Component.translatable(String.format("enchantment.incantationem.%s.desc", enchantmentId))))
            .option(availableForBookOffer)
            .option(availableAsTreasure)
            .build();
    }

}
