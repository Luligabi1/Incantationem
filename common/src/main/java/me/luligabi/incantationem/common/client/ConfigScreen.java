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
                () -> config.enchantments.baneOfTheSwine.maxLevel,
                newValue -> config.enchantments.baneOfTheSwine.maxLevel = newValue
            )
            .build();

        Option<Boolean> baneOfTheSwineAvailableRandomly = availableRandomly()
            .binding(
                true,
                () -> config.enchantments.baneOfTheSwine.availableRandomly,
                newValue -> config.enchantments.baneOfTheSwine.availableRandomly = newValue
            )
            .build();

        Option<Boolean> baneOfTheSwineAvailableForBookOffer = availableForBookOffer()
            .binding(
                true,
                () -> config.enchantments.baneOfTheSwine.availableForBookOffer,
                newValue -> config.enchantments.baneOfTheSwine.availableForBookOffer = newValue
            )
            .build();

        Option<Boolean> baneOfTheSwineAvailableAsTreasure = availableAsTreasure()
            .binding(
                false,
                () -> config.enchantments.baneOfTheSwine.availableAsTreasure,
                newValue -> config.enchantments.baneOfTheSwine.availableAsTreasure = newValue
            )
            .build();

        // Bunny's Hop
        Option<Integer> bunnysHopMaxLevel = maxLevel()
            .binding(
                3,
                () -> config.enchantments.bunnysHop.maxLevel,
                newValue -> config.enchantments.bunnysHop.maxLevel = newValue
            )
            .build();

        Option<Boolean> bunnysHopAvailableRandomly = availableRandomly()
            .binding(
                true,
                () -> config.enchantments.bunnysHop.availableRandomly,
                newValue -> config.enchantments.bunnysHop.availableRandomly = newValue
            )
            .build();

        Option<Boolean> bunnysHopAvailableForBookOffer = availableForBookOffer()
            .binding(
                true,
                () -> config.enchantments.bunnysHop.availableForBookOffer,
                newValue -> config.enchantments.bunnysHop.availableForBookOffer = newValue
            )
            .build();

        Option<Boolean> bunnysHopAvailableAsTreasure = availableAsTreasure()
            .binding(
                false,
                () -> config.enchantments.bunnysHop.availableAsTreasure,
                newValue -> config.enchantments.bunnysHop.availableAsTreasure = newValue
            )
            .build();

        // Charmed
        Option<Boolean> charmedAvailableRandomly = availableRandomly()
            .binding(
                true,
                () -> config.enchantments.charmed.availableRandomly,
                newValue -> config.enchantments.charmed.availableRandomly = newValue
            )
            .build();

        Option<Boolean> charmedAvailableForBookOffer = availableForBookOffer()
            .binding(
                true,
                () -> config.enchantments.charmed.availableForBookOffer,
                newValue -> config.enchantments.charmed.availableForBookOffer = newValue
            )
            .build();

        Option<Boolean> charmedAvailableAsTreasure = availableAsTreasure()
            .binding(
                false,
                () -> config.enchantments.charmed.availableAsTreasure,
                newValue -> config.enchantments.charmed.availableAsTreasure = newValue
            )
            .build();

        // Decay
        Option<Integer> decayMaxLevel = maxLevel()
            .binding(
                3,
                () -> config.enchantments.decay.maxLevel,
                newValue -> config.enchantments.decay.maxLevel = newValue
            )
            .build();

        Option<Boolean> decayAvailableRandomly = availableRandomly()
            .binding(
                true,
                () -> config.enchantments.decay.availableRandomly,
                newValue -> config.enchantments.decay.availableRandomly = newValue
            )
            .build();

        Option<Boolean> decayAvailableForBookOffer = availableForBookOffer()
            .binding(
                true,
                () -> config.enchantments.decay.availableForBookOffer,
                newValue -> config.enchantments.decay.availableForBookOffer = newValue
            )
            .build();

        Option<Boolean> decayAvailableAsTreasure = availableAsTreasure()
            .binding(
                false,
                () -> config.enchantments.decay.availableAsTreasure,
                newValue -> config.enchantments.decay.availableAsTreasure = newValue
            )
            .build();

        Option<Boolean> decayIsLuckBased = isLuckBased()
            .binding(
                true,
                () -> config.enchantments.decay.isLuckBased,
                newValue -> config.enchantments.decay.isLuckBased = newValue
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
        Option<Integer> deflectionMaxLevel = maxLevel()
            .binding(
                3,
                () -> config.enchantments.deflection.maxLevel,
                newValue -> config.enchantments.deflection.maxLevel = newValue
            )
            .build();

        Option<Boolean> deflectionAvailableRandomly = availableRandomly()
            .binding(
                true,
                () -> config.enchantments.deflection.availableRandomly,
                newValue -> config.enchantments.deflection.availableRandomly = newValue
            )
            .build();

        Option<Boolean> deflectionAvailableForBookOffer = availableForBookOffer()
            .binding(
                true,
                () -> config.enchantments.deflection.availableForBookOffer,
                newValue -> config.enchantments.deflection.availableForBookOffer = newValue
            )
            .build();

        Option<Boolean> deflectionAvailableAsTreasure = availableAsTreasure()
            .binding(
                false,
                () -> config.enchantments.deflection.availableAsTreasure,
                newValue -> config.enchantments.deflection.availableAsTreasure = newValue
            )
            .build();

        Option<Boolean> deflectionIsLuckBased = isLuckBased()
            .binding(
                true,
                () -> config.enchantments.deflection.isLuckBased,
                newValue -> config.enchantments.deflection.isLuckBased = newValue
            )
            .build();

        Option<Boolean> deflectionShowApplyMessage = showApplyMessage()
            .binding(
                true,
                () -> config.enchantments.deflection.showApplyMessage,
                newValue -> config.enchantments.deflection.showApplyMessage = newValue
            )
            .build();

        // Fuse Shot
        Option<Integer> fuseShotMaxLevel = maxLevel()
            .binding(
                3,
                () -> config.enchantments.fuseShot.maxLevel,
                newValue -> config.enchantments.fuseShot.maxLevel = newValue
            )
            .build();

        Option<Boolean> fuseShotAvailableRandomly = availableRandomly()
            .binding(
                false,
                () -> config.enchantments.fuseShot.availableRandomly,
                newValue -> config.enchantments.fuseShot.availableRandomly = newValue
            )
            .build();

        Option<Boolean> fuseShotAvailableForBookOffer = availableForBookOffer()
            .binding(
                true,
                () -> config.enchantments.fuseShot.availableForBookOffer,
                newValue -> config.enchantments.fuseShot.availableForBookOffer = newValue
            )
            .build();

        Option<Boolean> fuseShotAvailableAsTreasure = availableAsTreasure()
            .binding(
                true,
                () -> config.enchantments.fuseShot.availableAsTreasure,
                newValue -> config.enchantments.fuseShot.availableAsTreasure = newValue
            )
            .build();

        // Forging Touch
        Option<Integer> forgingTouchMaxLevel = maxLevel()
            .binding(
                3,
                () -> config.enchantments.forgingTouch.maxLevel,
                newValue -> config.enchantments.forgingTouch.maxLevel = newValue
            )
            .build();

        Option<Boolean> forgingTouchAvailableRandomly = availableRandomly()
            .binding(
                true,
                () -> config.enchantments.forgingTouch.availableRandomly,
                newValue -> config.enchantments.forgingTouch.availableRandomly = newValue
            )
            .build();

        Option<Boolean> forgingTouchAvailableForBookOffer = availableForBookOffer()
            .binding(
                true,
                () -> config.enchantments.forgingTouch.availableForBookOffer,
                newValue -> config.enchantments.forgingTouch.availableForBookOffer = newValue
            )
            .build();

        Option<Boolean> forgingTouchAvailableAsTreasure = availableAsTreasure()
            .binding(
                true,
                () -> config.enchantments.forgingTouch.availableAsTreasure,
                newValue -> config.enchantments.forgingTouch.availableAsTreasure = newValue
            )
            .build();

        Option<Boolean> forgingTouchIsLuckBased = isLuckBased()
            .binding(
                true,
                () -> config.enchantments.forgingTouch.isLuckBased,
                newValue -> config.enchantments.forgingTouch.isLuckBased = newValue
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
        Option<Integer> lastStandMaxLevel = maxLevel()
            .binding(
                3,
                () -> config.enchantments.lastStand.maxLevel,
                newValue -> config.enchantments.lastStand.maxLevel = newValue
            )
            .build();

        Option<Boolean> lastStandAvailableRandomly = availableRandomly()
            .binding(
                true,
                () -> config.enchantments.lastStand.availableRandomly,
                newValue -> config.enchantments.lastStand.availableRandomly = newValue
            )
            .build();

        Option<Boolean> lastStandAvailableForBookOffer = availableForBookOffer()
            .binding(
                true,
                () -> config.enchantments.lastStand.availableForBookOffer,
                newValue -> config.enchantments.lastStand.availableForBookOffer = newValue
            )
            .build();

        Option<Boolean> lastStandAvailableAsTreasure = availableAsTreasure()
            .binding(
                false,
                () -> config.enchantments.lastStand.availableAsTreasure,
                newValue -> config.enchantments.lastStand.availableAsTreasure = newValue
            )
            .build();

        Option<Boolean> lastStandIsLuckBased = isLuckBased()
            .binding(
                true,
                () -> config.enchantments.lastStand.isLuckBased,
                newValue -> config.enchantments.lastStand.isLuckBased = newValue
            )
            .build();

        Option<Boolean> lastStandShowApplyMessage = showApplyMessage()
            .binding(
                true,
                () -> config.enchantments.lastStand.showApplyMessage,
                newValue -> config.enchantments.lastStand.showApplyMessage = newValue
            )
            .build();

        // Magnetic
        Option<Integer> magneticMaxLevel = maxLevel()
            .binding(
                3,
                () -> config.enchantments.magnetic.maxLevel,
                newValue -> config.enchantments.magnetic.maxLevel = newValue
            )
            .build();

        Option<Boolean> magneticAvailableRandomly = availableRandomly()
            .binding(
                true,
                () -> config.enchantments.magnetic.availableRandomly,
                newValue -> config.enchantments.magnetic.availableRandomly = newValue
            )
            .build();

        Option<Boolean> magneticAvailableForBookOffer = availableForBookOffer()
            .binding(
                true,
                () -> config.enchantments.magnetic.availableForBookOffer,
                newValue -> config.enchantments.magnetic.availableForBookOffer = newValue
            )
            .build();

        Option<Boolean> magneticAvailableAsTreasure = availableAsTreasure()
            .binding(
                false,
                () -> config.enchantments.magnetic.availableAsTreasure,
                newValue -> config.enchantments.magnetic.availableAsTreasure = newValue
            )
            .build();

        // Reaping Rod
        Option<Boolean> reapingRodAvailableRandomly = availableRandomly()
            .binding(
                true,
                () -> config.enchantments.reapingRod.availableRandomly,
                newValue -> config.enchantments.reapingRod.availableRandomly = newValue
            )
            .build();

        Option<Boolean> reapingRodAvailableForBookOffer = availableForBookOffer()
            .binding(
                true,
                () -> config.enchantments.reapingRod.availableForBookOffer,
                newValue -> config.enchantments.reapingRod.availableForBookOffer = newValue
            )
            .build();

        Option<Boolean> reapingRodAvailableAsTreasure = availableAsTreasure()
            .binding(
                false,
                () -> config.enchantments.reapingRod.availableAsTreasure,
                newValue -> config.enchantments.reapingRod.availableAsTreasure = newValue
            )
            .build();

        // Retreat
        Option<Boolean> retreatAvailableRandomly = availableRandomly()
            .binding(
                true,
                () -> config.enchantments.retreat.availableRandomly,
                newValue -> config.enchantments.retreat.availableRandomly = newValue
            )
            .build();

        Option<Boolean> retreatAvailableForBookOffer = availableForBookOffer()
            .binding(
                true,
                () -> config.enchantments.retreat.availableForBookOffer,
                newValue -> config.enchantments.retreat.availableForBookOffer = newValue
            )
            .build();

        Option<Boolean> retreatAvailableAsTreasure = availableAsTreasure()
            .binding(
                false,
                () -> config.enchantments.retreat.availableAsTreasure,
                newValue -> config.enchantments.retreat.availableAsTreasure = newValue
            )
            .build();

        Option<Boolean> retreatIsLuckBased = isLuckBased()
            .binding(
                true,
                () -> config.enchantments.retreat.isLuckBased,
                newValue -> config.enchantments.retreat.isLuckBased = newValue
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
        Option<Integer> venomousMaxLevel = maxLevel()
            .binding(
                3,
                () -> config.enchantments.venomous.maxLevel,
                newValue -> config.enchantments.venomous.maxLevel = newValue
            )
            .build();

        Option<Boolean> venomousAvailableRandomly = availableRandomly()
            .binding(
                true,
                () -> config.enchantments.venomous.availableRandomly,
                newValue -> config.enchantments.venomous.availableRandomly = newValue
            )
            .build();

        Option<Boolean> venomousAvailableForBookOffer = availableForBookOffer()
            .binding(
                true,
                () -> config.enchantments.venomous.availableForBookOffer,
                newValue -> config.enchantments.venomous.availableForBookOffer = newValue
            )
            .build();

        Option<Boolean> venomousAvailableAsTreasure = availableAsTreasure()
            .binding(
                false,
                () -> config.enchantments.venomous.availableAsTreasure,
                newValue -> config.enchantments.venomous.availableAsTreasure = newValue
            )
            .build();

        Option<Boolean> venomousIsLuckBased = isLuckBased()
            .binding(
                true,
                () -> config.enchantments.venomous.isLuckBased,
                newValue -> config.enchantments.venomous.isLuckBased = newValue
            )
            .build();

        Option<Boolean> venomousShowApplyMessage = showApplyMessage()
            .binding(
                true,
                () -> config.enchantments.venomous.showApplyMessage,
                newValue -> config.enchantments.venomous.showApplyMessage = newValue
            )
            .build();

        // Water Slash
        Option<Integer> waterSlashMaxLevel = maxLevel()
            .binding(
                5,
                () -> config.enchantments.waterSlash.maxLevel,
                newValue -> config.enchantments.waterSlash.maxLevel = newValue
            )
            .build();

        Option<Boolean> waterSlashAvailableRandomly = availableRandomly()
            .binding(
                true,
                () -> config.enchantments.waterSlash.availableRandomly,
                newValue -> config.enchantments.waterSlash.availableRandomly = newValue
            )
            .build();

        Option<Boolean> waterSlashAvailableForBookOffer = availableForBookOffer()
            .binding(
                true,
                () -> config.enchantments.waterSlash.availableForBookOffer,
                newValue -> config.enchantments.waterSlash.availableForBookOffer = newValue
            )
            .build();

        Option<Boolean> waterSlashAvailableAsTreasure = availableAsTreasure()
            .binding(
                false,
                () -> config.enchantments.waterSlash.availableAsTreasure,
                newValue -> config.enchantments.waterSlash.availableAsTreasure = newValue
            )
            .build();

        /*
         * CURSES
         */
        // Curse of Recklessness
        Option<Boolean> recklessnessAvailableRandomly = availableRandomly()
            .binding(
                true,
                () -> config.curses.recklessness.availableRandomly,
                newValue -> config.curses.recklessness.availableRandomly = newValue
            )
            .build();

        Option<Boolean> recklessnessAvailableForBookOffer = availableForBookOffer()
            .binding(
                true,
                () -> config.curses.recklessness.availableForBookOffer,
                newValue -> config.curses.recklessness.availableForBookOffer = newValue
            )
            .build();

        Option<Boolean> recklessnessAvailableAsTreasure = availableAsTreasure()
            .binding(
                true,
                () -> config.curses.recklessness.availableAsTreasure,
                newValue -> config.curses.recklessness.availableAsTreasure = newValue
            )
            .build();

        // Curse of Shrieking
        Option<Boolean> shriekingAvailableRandomly = availableRandomly()
            .binding(
                true,
                () -> config.curses.shrieking.availableRandomly,
                newValue -> config.curses.shrieking.availableRandomly = newValue
            )
            .build();

        Option<Boolean> shriekingAvailableForBookOffer = availableForBookOffer()
            .binding(
                true,
                () -> config.curses.shrieking.availableForBookOffer,
                newValue -> config.curses.shrieking.availableForBookOffer = newValue
            )
            .build();

        Option<Boolean> shriekingAvailableAsTreasure = availableAsTreasure()
            .binding(
                true,
                () -> config.curses.shrieking.availableAsTreasure,
                newValue -> config.curses.shrieking.availableAsTreasure = newValue
            )
            .build();

        // Curse of the Thunders
        Option<Boolean> thunderAvailableRandomly = availableRandomly()
            .binding(
                true,
                () -> config.curses.thunder.availableRandomly,
                newValue -> config.curses.thunder.availableRandomly = newValue
            )
            .build();

        Option<Boolean> thunderAvailableForBookOffer = availableForBookOffer()
            .binding(
                true,
                () -> config.curses.thunder.availableForBookOffer,
                newValue -> config.curses.thunder.availableForBookOffer = newValue
            )
            .build();

        Option<Boolean> thunderAvailableAsTreasure = availableAsTreasure()
            .binding(
                true,
                () -> config.curses.thunder.availableAsTreasure,
                newValue -> config.curses.thunder.availableAsTreasure = newValue
            )
            .build();

        Option<Boolean> thunderIsLuckBased = isLuckBased()
            .binding(
                true,
                () -> config.curses.thunder.isLuckBased,
                newValue -> config.curses.thunder.isLuckBased = newValue
            )
            .build();

        Option<Boolean> thunderShowApplyMessage = showApplyMessage()
            .binding(
                true,
                () -> config.curses.thunder.showApplyMessage,
                newValue -> config.curses.thunder.showApplyMessage = newValue
            )
            .build();

        // Curse of Tough Luck
        Option<Boolean> toughLuckAvailableRandomly = availableRandomly()
            .binding(
                true,
                () -> config.curses.toughLuck.availableRandomly,
                newValue -> config.curses.toughLuck.availableRandomly = newValue
            )
            .build();

        Option<Boolean> toughLuckAvailableForBookOffer = availableForBookOffer()
            .binding(
                true,
                () -> config.curses.toughLuck.availableForBookOffer,
                newValue -> config.curses.toughLuck.availableForBookOffer = newValue
            )
            .build();

        Option<Boolean> toughLuckAvailableAsTreasure = availableAsTreasure()
            .binding(
                true,
                () -> config.curses.toughLuck.availableAsTreasure,
                newValue -> config.curses.toughLuck.availableAsTreasure = newValue
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
                    createLuckBasedEnchantmentGroup(
                        "decay",
                        decayMaxLevel,
                        decayAvailableRandomly,
                        decayAvailableForBookOffer,
                        decayAvailableAsTreasure,
                        decayIsLuckBased,
                        decayShowApplyMessage
                    )
                )
                .group(
                    createLuckBasedEnchantmentGroup(
                        "deflection",
                        deflectionMaxLevel,
                        deflectionAvailableRandomly,
                        deflectionAvailableForBookOffer,
                        deflectionAvailableAsTreasure,
                        deflectionIsLuckBased,
                        deflectionShowApplyMessage
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
                    createLuckBasedEnchantmentGroup(
                        "forging_touch",
                        forgingTouchMaxLevel,
                        forgingTouchAvailableRandomly,
                        forgingTouchAvailableForBookOffer,
                        forgingTouchAvailableAsTreasure,
                        forgingTouchIsLuckBased,
                        forgingTouchShowApplyMessage
                    )
                )
                .group(
                    createLuckBasedEnchantmentGroup(
                        "last_stand",
                        lastStandMaxLevel,
                        lastStandAvailableRandomly,
                        lastStandAvailableForBookOffer,
                        lastStandAvailableAsTreasure,
                        lastStandIsLuckBased,
                        lastStandShowApplyMessage
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
                    createLevellessLuckBasedEnchantmentGroup(
                        "retreat",
                        retreatAvailableRandomly,
                        retreatAvailableForBookOffer,
                        retreatAvailableAsTreasure,
                        retreatIsLuckBased,
                        retreatShowApplyMessage
                    )
                )
                .group(
                    createLuckBasedEnchantmentGroup(
                        "venomous",
                        venomousMaxLevel,
                        venomousAvailableRandomly,
                        venomousAvailableForBookOffer,
                        venomousAvailableAsTreasure,
                        venomousIsLuckBased,
                        venomousShowApplyMessage
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
                    createLevellessEnchantmentGroup(
                        "recklessness",
                        recklessnessAvailableRandomly,
                        recklessnessAvailableForBookOffer,
                        recklessnessAvailableAsTreasure
                    )
                )
                .group(
                    createLevellessEnchantmentGroup(
                        "shrieking",
                        shriekingAvailableRandomly,
                        shriekingAvailableForBookOffer,
                        shriekingAvailableAsTreasure
                    )
                )
                .group(
                    createLevellessLuckBasedEnchantmentGroup(
                        "thunder",
                        thunderAvailableRandomly,
                        thunderAvailableForBookOffer,
                        thunderAvailableAsTreasure,
                        thunderIsLuckBased,
                        thunderShowApplyMessage
                    )
                )
                .group(
                    createLevellessEnchantmentGroup(
                        "tough_luck",
                        toughLuckAvailableRandomly,
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

    private static Option.Builder<Boolean> isLuckBased() {
        return Option.<Boolean>createBuilder()
            .name(Component.translatable("configOption.incantationem.isLuckBased"))
            .description(OptionDescription.of(Component.translatable("configOption.incantationem.isLuckBased.tooltip")))
            .controller(option -> BooleanControllerBuilder.create(option).yesNoFormatter().coloured(true));
    }

    private static Option.Builder<Boolean> showApplyMessage() {
        return Option.<Boolean>createBuilder()
            .name(Component.translatable("configOption.incantationem.showApplyMessage"))
            .description(OptionDescription.of(Component.translatable("configOption.incantationem.showApplyMessage.tooltip")))
            .controller(option -> BooleanControllerBuilder.create(option).yesNoFormatter().coloured(true));
    }


    private static OptionGroup createEnchantmentGroup(String enchantmentId, Option<Integer> maxLevel, Option<Boolean> availableRandomly, Option<Boolean> availableForBookOffer, Option<Boolean> availableAsTreasure) {
        return OptionGroup.createBuilder()
            .name(Component.translatable("enchantment.incantationem." + enchantmentId))
            .description(OptionDescription.of(Component.translatable(String.format("enchantment.incantationem.%s.desc", enchantmentId))))
            .collapsed(true)
            .option(maxLevel)
            .option(availableRandomly)
            .option(availableForBookOffer)
            .option(availableAsTreasure)
            .build();
    }

    private static OptionGroup createLuckBasedEnchantmentGroup(String enchantmentId, Option<Integer> maxLevel, Option<Boolean> availableRandomly, Option<Boolean> availableForBookOffer, Option<Boolean> availableAsTreasure, Option<Boolean> isLuckBased, Option<Boolean> showApplyMessage) {
        return OptionGroup.createBuilder()
            .name(Component.translatable("enchantment.incantationem." + enchantmentId))
            .description(OptionDescription.of(Component.translatable(String.format("enchantment.incantationem.%s.desc", enchantmentId))))
            .collapsed(true)
            .option(maxLevel)
            .option(availableRandomly)
            .option(availableForBookOffer)
            .option(availableAsTreasure)
            .option(isLuckBased)
            .option(showApplyMessage)
            .build();
    }

    private static OptionGroup createLevellessEnchantmentGroup(String enchantmentId, Option<Boolean> availableRandomly, Option<Boolean> availableForBookOffer, Option<Boolean> availableAsTreasure) {
        return OptionGroup.createBuilder()
            .name(Component.translatable("enchantment.incantationem." + enchantmentId))
            .description(OptionDescription.of(Component.translatable(String.format("enchantment.incantationem.%s.desc", enchantmentId))))
            .collapsed(true)
            .option(availableRandomly)
            .option(availableForBookOffer)
            .option(availableAsTreasure)
            .build();
    }

    // Winner for longest, somewhat cohesive method name I've ever written
    private static OptionGroup createLevellessLuckBasedEnchantmentGroup(String enchantmentId, Option<Boolean> availableRandomly, Option<Boolean> availableForBookOffer, Option<Boolean> availableAsTreasure, Option<Boolean> isLuckBased, Option<Boolean> showApplyMessage) {
        return OptionGroup.createBuilder()
            .name(Component.translatable("enchantment.incantationem." + enchantmentId))
            .description(OptionDescription.of(Component.translatable(String.format("enchantment.incantationem.%s.desc", enchantmentId))))
            .collapsed(true)
            .option(availableRandomly)
            .option(availableForBookOffer)
            .option(availableAsTreasure)
            .option(isLuckBased)
            .option(showApplyMessage)
            .build();
    }

}
