package me.luligabi.incantationem.client.compat.modmenu;

import com.terraformersmc.modmenu.api.ConfigScreenFactory;
import com.terraformersmc.modmenu.api.ModMenuApi;
import dev.isxander.yacl3.api.*;
import dev.isxander.yacl3.api.controller.BooleanControllerBuilder;
import dev.isxander.yacl3.api.controller.IntegerFieldControllerBuilder;
import me.luligabi.incantationem.common.Incantationem;
import me.luligabi.incantationem.common.ModConfig;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.text.Text;

public class ConfigScreenEntrypoint implements ModMenuApi {

    @Override
    public ConfigScreenFactory<Screen> getModConfigScreenFactory() {
        return this::createConfigScreen;
    }

    private Screen createConfigScreen(Screen parent) {
        ModConfig config = Incantationem.CONFIG;


        /*
         * ENCHANTMENTS
         */
        // Bane of Ender
        Option<Integer> baneOfEnderMaxLevel = Option.<Integer>createBuilder()
                .name(Text.translatable("configOption.incantationem.maxLevel"))
                .description(OptionDescription.of(Text.translatable("configOption.incantationem.maxLevel.tooltip")))
                .binding(
                        5,
                        () -> config.baneOfEnderMaxLevel,
                        newValue -> config.baneOfEnderMaxLevel = newValue
                )
                .controller(option -> IntegerFieldControllerBuilder.create(option).range(1, 10))
                .build();

        Option<Boolean> baneOfEnderAvailableRandomly = Option.<Boolean>createBuilder()
                .name(Text.translatable("configOption.incantationem.availableRandomly"))
                .description(OptionDescription.of(Text.translatable("configOption.incantationem.availableRandomly.tooltip")))
                .binding(
                        true,
                        () -> config.baneOfEnderAvailableRandomly,
                        newValue -> config.baneOfEnderAvailableRandomly = newValue
                )
                .controller(option -> BooleanControllerBuilder.create(option).yesNoFormatter().coloured(true))
                .build();

        Option<Boolean> baneOfEnderAvailableForBookOffer = Option.<Boolean>createBuilder()
                .name(Text.translatable("configOption.incantationem.availableForBookOffer"))
                .description(OptionDescription.of(Text.translatable("configOption.incantationem.availableForBookOffer.tooltip")))
                .binding(
                        true,
                        () -> config.baneOfEnderAvailableForBookOffer,
                        newValue -> config.baneOfEnderAvailableForBookOffer = newValue
                )
                .controller(option -> BooleanControllerBuilder.create(option).yesNoFormatter().coloured(true))
                .build();

        Option<Boolean> baneOfEnderAvailableAsTreasure = Option.<Boolean>createBuilder()
                .name(Text.translatable("configOption.incantationem.availableAsTreasure"))
                .description(OptionDescription.of(Text.translatable("configOption.incantationem.availableAsTreasure.tooltip")))
                .binding(
                        false,
                        () -> config.baneOfEnderAvailableAsTreasure,
                        newValue -> config.baneOfEnderAvailableAsTreasure = newValue
                )
                .controller(option -> BooleanControllerBuilder.create(option).yesNoFormatter().coloured(true))
                .build();

        // Bane of The Swine
        Option<Integer> baneOfTheSwineMaxLevel = Option.<Integer>createBuilder()
                .name(Text.translatable("configOption.incantationem.maxLevel"))
                .description(OptionDescription.of(Text.translatable("configOption.incantationem.maxLevel.tooltip")))
                .binding(
                        5,
                        () -> config.baneOfTheSwineMaxLevel,
                        newValue -> config.baneOfTheSwineMaxLevel = newValue
                )
                .controller(option -> IntegerFieldControllerBuilder.create(option).range(1, 10))
        .build();

        Option<Boolean> baneOfTheSwineAvailableRandomly = Option.<Boolean>createBuilder()
                .name(Text.translatable("configOption.incantationem.availableRandomly"))
                .description(OptionDescription.of(Text.translatable("configOption.incantationem.availableRandomly.tooltip")))
                .binding(
                        true,
                        () -> config.baneOfTheSwineAvailableRandomly,
                        newValue -> config.baneOfTheSwineAvailableRandomly = newValue
                )
                .controller(option -> BooleanControllerBuilder.create(option).yesNoFormatter().coloured(true))
                .build();

        Option<Boolean> baneOfTheSwineAvailableForBookOffer = Option.<Boolean>createBuilder()
                .name(Text.translatable("configOption.incantationem.availableForBookOffer"))
                .description(OptionDescription.of(Text.translatable("configOption.incantationem.availableForBookOffer.tooltip")))
                .binding(
                        true,
                        () -> config.baneOfTheSwineAvailableForBookOffer,
                        newValue -> config.baneOfTheSwineAvailableForBookOffer = newValue
                )
                .controller(option -> BooleanControllerBuilder.create(option).yesNoFormatter().coloured(true))
                .build();

        Option<Boolean> baneOfTheSwineAvailableAsTreasure = Option.<Boolean>createBuilder()
                .name(Text.translatable("configOption.incantationem.availableAsTreasure"))
                .description(OptionDescription.of(Text.translatable("configOption.incantationem.availableAsTreasure.tooltip")))
                .binding(
                        false,
                        () -> config.baneOfTheSwineAvailableAsTreasure,
                        newValue -> config.baneOfTheSwineAvailableAsTreasure = newValue
                )
                .controller(option -> BooleanControllerBuilder.create(option).yesNoFormatter().coloured(true))
                .build();

        // Bunny's Hop
        Option<Integer> bunnysHopMaxLevel = Option.<Integer>createBuilder()
                .name(Text.translatable("configOption.incantationem.maxLevel"))
                .description(OptionDescription.of(Text.translatable("configOption.incantationem.maxLevel.tooltip")))
                .binding(
                        3,
                        () -> config.bunnysHopMaxLevel,
                        newValue -> config.bunnysHopMaxLevel = newValue
                )
                .controller(option -> IntegerFieldControllerBuilder.create(option).min(1).max(10))
                .build();

        Option<Boolean> bunnysHopAvailableRandomly = Option.<Boolean>createBuilder()
                .name(Text.translatable("configOption.incantationem.availableRandomly"))
                .description(OptionDescription.of(Text.translatable("configOption.incantationem.availableRandomly.tooltip")))
                .binding(
                        true,
                        () -> config.bunnysHopAvailableRandomly,
                        newValue -> config.bunnysHopAvailableRandomly = newValue
                )
                .controller(option -> BooleanControllerBuilder.create(option).yesNoFormatter().coloured(true))
                .build();

        Option<Boolean> bunnysHopAvailableForBookOffer = Option.<Boolean>createBuilder()
                .name(Text.translatable("configOption.incantationem.availableForBookOffer"))
                .description(OptionDescription.of(Text.translatable("configOption.incantationem.availableForBookOffer.tooltip")))
                .binding(
                        true,
                        () -> config.bunnysHopAvailableForBookOffer,
                        newValue -> config.bunnysHopAvailableForBookOffer = newValue
                )
                .controller(option -> BooleanControllerBuilder.create(option).yesNoFormatter().coloured(true))
                .build();

        Option<Boolean> bunnysHopAvailableAsTreasure = Option.<Boolean>createBuilder()
                .name(Text.translatable("configOption.incantationem.availableAsTreasure"))
                .description(OptionDescription.of(Text.translatable("configOption.incantationem.availableAsTreasure.tooltip")))
                .binding(
                        false,
                        () -> config.bunnysHopAvailableAsTreasure,
                        newValue -> config.bunnysHopAvailableAsTreasure = newValue
                )
                .controller(option -> BooleanControllerBuilder.create(option).yesNoFormatter().coloured(true))
                .build();

        // Charmed
        Option<Boolean> charmedAvailableRandomly = Option.<Boolean>createBuilder()
                .name(Text.translatable("configOption.incantationem.availableRandomly"))
                .description(OptionDescription.of(Text.translatable("configOption.incantationem.availableRandomly.tooltip")))
                .binding(
                        true,
                        () -> config.charmedAvailableRandomly,
                        newValue -> config.charmedAvailableRandomly = newValue
                )
                .controller(option -> BooleanControllerBuilder.create(option).yesNoFormatter().coloured(true))
                .build();

        Option<Boolean> charmedAvailableForBookOffer = Option.<Boolean>createBuilder()
                .name(Text.translatable("configOption.incantationem.availableForBookOffer"))
                .description(OptionDescription.of(Text.translatable("configOption.incantationem.availableForBookOffer.tooltip")))
                .binding(
                        true,
                        () -> config.charmedAvailableForBookOffer,
                        newValue -> config.charmedAvailableForBookOffer = newValue
                )
                .controller(option -> BooleanControllerBuilder.create(option).yesNoFormatter().coloured(true))
                .build();

        Option<Boolean> charmedAvailableAsTreasure = Option.<Boolean>createBuilder()
                .name(Text.translatable("configOption.incantationem.availableAsTreasure"))
                .description(OptionDescription.of(Text.translatable("configOption.incantationem.availableAsTreasure.tooltip")))
                .binding(
                        false,
                        () -> config.charmedAvailableAsTreasure,
                        newValue -> config.charmedAvailableAsTreasure = newValue
                )
                .controller(option -> BooleanControllerBuilder.create(option).yesNoFormatter().coloured(true))
                .build();

        // Critical Strike
        Option<Integer> criticalStrikeMaxLevel = Option.<Integer>createBuilder()
                .name(Text.translatable("configOption.incantationem.maxLevel"))
                .description(OptionDescription.of(Text.translatable("configOption.incantationem.maxLevel.tooltip")))
                .binding(
                        3,
                        () -> config.criticalStrikeMaxLevel,
                        newValue -> config.criticalStrikeMaxLevel = newValue
                )
                .controller(option -> IntegerFieldControllerBuilder.create(option).min(1).max(10))
                .build();

        Option<Boolean> criticalStrikeAvailableRandomly = Option.<Boolean>createBuilder()
                .name(Text.translatable("configOption.incantationem.availableRandomly"))
                .description(OptionDescription.of(Text.translatable("configOption.incantationem.availableRandomly.tooltip")))
                .binding(
                        false,
                        () -> config.criticalStrikeAvailableRandomly,
                        newValue -> config.criticalStrikeAvailableRandomly = newValue
                )
                .controller(option -> BooleanControllerBuilder.create(option).yesNoFormatter().coloured(true))
                .build();

        Option<Boolean> criticalStrikeAvailableForBookOffer = Option.<Boolean>createBuilder()
                .name(Text.translatable("configOption.incantationem.availableForBookOffer"))
                .description(OptionDescription.of(Text.translatable("configOption.incantationem.availableForBookOffer.tooltip")))
                .binding(
                        true,
                        () -> config.criticalStrikeAvailableForBookOffer,
                        newValue -> config.criticalStrikeAvailableForBookOffer = newValue
                )
                .controller(option -> BooleanControllerBuilder.create(option).yesNoFormatter().coloured(true))
                .build();

        Option<Boolean> criticalStrikeAvailableAsTreasure = Option.<Boolean>createBuilder()
                .name(Text.translatable("configOption.incantationem.availableAsTreasure"))
                .description(OptionDescription.of(Text.translatable("configOption.incantationem.availableAsTreasure.tooltip")))
                .binding(
                        true,
                        () -> config.criticalStrikeAvailableAsTreasure,
                        newValue -> config.criticalStrikeAvailableAsTreasure = newValue
                )
                .controller(option -> BooleanControllerBuilder.create(option).yesNoFormatter().coloured(true))
                .build();

        // Decay
        Option<Integer> decayMaxLevel = Option.<Integer>createBuilder()
                .name(Text.translatable("configOption.incantationem.maxLevel"))
                .description(OptionDescription.of(Text.translatable("configOption.incantationem.maxLevel.tooltip")))
                .binding(
                        3,
                        () -> config.decayMaxLevel,
                        newValue -> config.decayMaxLevel = newValue
                )
                .controller(option -> IntegerFieldControllerBuilder.create(option).min(1).max(10))
                .build();

        Option<Boolean> decayAvailableRandomly = Option.<Boolean>createBuilder()
                .name(Text.translatable("configOption.incantationem.availableRandomly"))
                .description(OptionDescription.of(Text.translatable("configOption.incantationem.availableRandomly.tooltip")))
                .binding(
                        true,
                        () -> config.decayAvailableRandomly,
                        newValue -> config.decayAvailableRandomly = newValue
                )
                .controller(option -> BooleanControllerBuilder.create(option).yesNoFormatter().coloured(true))
                .build();

        Option<Boolean> decayAvailableForBookOffer = Option.<Boolean>createBuilder()
                .name(Text.translatable("configOption.incantationem.availableForBookOffer"))
                .description(OptionDescription.of(Text.translatable("configOption.incantationem.availableForBookOffer.tooltip")))
                .binding(
                        true,
                        () -> config.decayAvailableForBookOffer,
                        newValue -> config.decayAvailableForBookOffer = newValue
                )
                .controller(option -> BooleanControllerBuilder.create(option).yesNoFormatter().coloured(true))
                .build();

        Option<Boolean> decayAvailableAsTreasure = Option.<Boolean>createBuilder()
                .name(Text.translatable("configOption.incantationem.availableAsTreasure"))
                .description(OptionDescription.of(Text.translatable("configOption.incantationem.availableAsTreasure.tooltip")))
                .binding(
                        false,
                        () -> config.decayAvailableAsTreasure,
                        newValue -> config.decayAvailableAsTreasure = newValue
                )
                .controller(option -> BooleanControllerBuilder.create(option).yesNoFormatter().coloured(true))
                .build();

        // Deflection
        Option<Integer> deflectionMaxLevel = Option.<Integer>createBuilder()
                .name(Text.translatable("configOption.incantationem.maxLevel"))
                .description(OptionDescription.of(Text.translatable("configOption.incantationem.maxLevel.tooltip")))
                .binding(
                        3,
                        () -> config.deflectionMaxLevel,
                        newValue -> config.deflectionMaxLevel = newValue
                )
                .controller(option -> IntegerFieldControllerBuilder.create(option).min(1).max(10))
                .build();

        Option<Boolean> deflectionAvailableRandomly = Option.<Boolean>createBuilder()
                .name(Text.translatable("configOption.incantationem.availableRandomly"))
                .description(OptionDescription.of(Text.translatable("configOption.incantationem.availableRandomly.tooltip")))
                .binding(
                        true,
                        () -> config.deflectionAvailableRandomly,
                        newValue -> config.deflectionAvailableRandomly = newValue
                )
                .controller(option -> BooleanControllerBuilder.create(option).yesNoFormatter().coloured(true))
                .build();

        Option<Boolean> deflectionAvailableForBookOffer = Option.<Boolean>createBuilder()
                .name(Text.translatable("configOption.incantationem.availableForBookOffer"))
                .description(OptionDescription.of(Text.translatable("configOption.incantationem.availableForBookOffer.tooltip")))
                .binding(
                        true,
                        () -> config.deflectionAvailableForBookOffer,
                        newValue -> config.deflectionAvailableForBookOffer = newValue
                )
                .controller(option -> BooleanControllerBuilder.create(option).yesNoFormatter().coloured(true))
                .build();

        Option<Boolean> deflectionAvailableAsTreasure = Option.<Boolean>createBuilder()
                .name(Text.translatable("configOption.incantationem.availableAsTreasure"))
                .description(OptionDescription.of(Text.translatable("configOption.incantationem.availableAsTreasure.tooltip")))
                .binding(
                        false,
                        () -> config.deflectionAvailableAsTreasure,
                        newValue -> config.deflectionAvailableAsTreasure = newValue
                )
                .controller(option -> BooleanControllerBuilder.create(option).yesNoFormatter().coloured(true))
                .build();

        // Explosive
        Option<Integer> explosiveMaxLevel = Option.<Integer>createBuilder()
                .name(Text.translatable("configOption.incantationem.maxLevel"))
                .description(OptionDescription.of(Text.translatable("configOption.incantationem.maxLevel.tooltip")))
                .binding(
                        3,
                        () -> config.explosiveMaxLevel,
                        newValue -> config.explosiveMaxLevel = newValue
                )
                .controller(option -> IntegerFieldControllerBuilder.create(option).min(1).max(10))
                .build();

        Option<Boolean> explosiveAvailableRandomly = Option.<Boolean>createBuilder()
                .name(Text.translatable("configOption.incantationem.availableRandomly"))
                .description(OptionDescription.of(Text.translatable("configOption.incantationem.availableRandomly.tooltip")))
                .binding(
                        false,
                        () -> config.explosiveAvailableRandomly,
                        newValue -> config.explosiveAvailableRandomly = newValue
                )
                .controller(option -> BooleanControllerBuilder.create(option).yesNoFormatter().coloured(true))
                .build();

        Option<Boolean> explosiveAvailableForBookOffer = Option.<Boolean>createBuilder()
                .name(Text.translatable("configOption.incantationem.availableForBookOffer"))
                .description(OptionDescription.of(Text.translatable("configOption.incantationem.availableForBookOffer.tooltip")))
                .binding(
                        true,
                        () -> config.explosiveAvailableForBookOffer,
                        newValue -> config.explosiveAvailableForBookOffer = newValue
                )
                .controller(option -> BooleanControllerBuilder.create(option).yesNoFormatter().coloured(true))
                .build();

        Option<Boolean> explosiveAvailableAsTreasure = Option.<Boolean>createBuilder()
                .name(Text.translatable("configOption.incantationem.availableAsTreasure"))
                .description(OptionDescription.of(Text.translatable("configOption.incantationem.availableAsTreasure.tooltip")))
                .binding(
                        true,
                        () -> config.explosiveAvailableAsTreasure,
                        newValue -> config.explosiveAvailableAsTreasure = newValue
                )
                .controller(option -> BooleanControllerBuilder.create(option).yesNoFormatter().coloured(true))
                .build();

        // Forging Touch
        Option<Integer> forgingTouchMaxLevel = Option.<Integer>createBuilder()
                .name(Text.translatable("configOption.incantationem.maxLevel"))
                .description(OptionDescription.of(Text.translatable("configOption.incantationem.maxLevel.tooltip")))
                .binding(
                        3,
                        () -> config.forgingTouchMaxLevel,
                        newValue -> config.forgingTouchMaxLevel = newValue
                )
                .controller(option -> IntegerFieldControllerBuilder.create(option).min(1).max(10))
                .build();

        Option<Boolean> forgingTouchAvailableRandomly = Option.<Boolean>createBuilder()
                .name(Text.translatable("configOption.incantationem.availableRandomly"))
                .description(OptionDescription.of(Text.translatable("configOption.incantationem.availableRandomly.tooltip")))
                .binding(
                        true,
                        () -> config.forgingTouchAvailableRandomly,
                        newValue -> config.forgingTouchAvailableRandomly = newValue
                )
                .controller(option -> BooleanControllerBuilder.create(option).yesNoFormatter().coloured(true))
                .build();

        Option<Boolean> forgingTouchAvailableForBookOffer = Option.<Boolean>createBuilder()
                .name(Text.translatable("configOption.incantationem.availableForBookOffer"))
                .description(OptionDescription.of(Text.translatable("configOption.incantationem.availableForBookOffer.tooltip")))
                .binding(
                        true,
                        () -> config.forgingTouchAvailableForBookOffer,
                        newValue -> config.forgingTouchAvailableForBookOffer = newValue
                )
                .controller(option -> BooleanControllerBuilder.create(option).yesNoFormatter().coloured(true))
                .build();

        Option<Boolean> forgingTouchAvailableAsTreasure = Option.<Boolean>createBuilder()
                .name(Text.translatable("configOption.incantationem.availableAsTreasure"))
                .description(OptionDescription.of(Text.translatable("configOption.incantationem.availableAsTreasure.tooltip")))
                .binding(
                        true,
                        () -> config.forgingTouchAvailableAsTreasure,
                        newValue -> config.forgingTouchAvailableAsTreasure = newValue
                )
                .controller(option -> BooleanControllerBuilder.create(option).yesNoFormatter().coloured(true))
                .build();

        // Last Stand
        Option<Integer> lastStandMaxLevel = Option.<Integer>createBuilder()
                .name(Text.translatable("configOption.incantationem.maxLevel"))
                .description(OptionDescription.of(Text.translatable("configOption.incantationem.maxLevel.tooltip")))
                .binding(
                        3,
                        () -> config.lastStandMaxLevel,
                        newValue -> config.lastStandMaxLevel = newValue
                )
                .controller(option -> IntegerFieldControllerBuilder.create(option).min(1).max(10))
                .build();

        Option<Boolean> lastStandAvailableRandomly = Option.<Boolean>createBuilder()
                .name(Text.translatable("configOption.incantationem.availableRandomly"))
                .description(OptionDescription.of(Text.translatable("configOption.incantationem.availableRandomly.tooltip")))
                .binding(
                        true,
                        () -> config.lastStandAvailableRandomly,
                        newValue -> config.lastStandAvailableRandomly = newValue
                )
                .controller(option -> BooleanControllerBuilder.create(option).yesNoFormatter().coloured(true))
                .build();

        Option<Boolean> lastStandAvailableForBookOffer = Option.<Boolean>createBuilder()
                .name(Text.translatable("configOption.incantationem.availableForBookOffer"))
                .description(OptionDescription.of(Text.translatable("configOption.incantationem.availableForBookOffer.tooltip")))
                .binding(
                        true,
                        () -> config.lastStandAvailableForBookOffer,
                        newValue -> config.lastStandAvailableForBookOffer = newValue
                )
                .controller(option -> BooleanControllerBuilder.create(option).yesNoFormatter().coloured(true))
                .build();

        Option<Boolean> lastStandAvailableAsTreasure = Option.<Boolean>createBuilder()
                .name(Text.translatable("configOption.incantationem.availableAsTreasure"))
                .description(OptionDescription.of(Text.translatable("configOption.incantationem.availableAsTreasure.tooltip")))
                .binding(
                        false,
                        () -> config.lastStandAvailableAsTreasure,
                        newValue -> config.lastStandAvailableAsTreasure = newValue
                )
                .controller(option -> BooleanControllerBuilder.create(option).yesNoFormatter().coloured(true))
                .build();

        //Loot & Scoot
        Option<Boolean> lootAndScootAvailableRandomly = Option.<Boolean>createBuilder()
                .name(Text.translatable("configOption.incantationem.availableRandomly"))
                .description(OptionDescription.of(Text.translatable("configOption.incantationem.availableRandomly.tooltip")))
                .binding(
                        false,
                        () -> config.lootAndScootAvailableRandomly,
                        newValue -> config.lootAndScootAvailableRandomly = newValue
                )
                .controller(option -> BooleanControllerBuilder.create(option).yesNoFormatter().coloured(true))
                .build();

        Option<Boolean> lootAndScootAvailableForBookOffer = Option.<Boolean>createBuilder()
                .name(Text.translatable("configOption.incantationem.availableForBookOffer"))
                .description(OptionDescription.of(Text.translatable("configOption.incantationem.availableForBookOffer.tooltip")))
                .binding(
                        true,
                        () -> config.lootAndScootAvailableForBookOffer,
                        newValue -> config.lootAndScootAvailableForBookOffer = newValue
                )
                .controller(option -> BooleanControllerBuilder.create(option).yesNoFormatter().coloured(true))
                .build();

        Option<Boolean> lootAndScootAvailableAsTreasure = Option.<Boolean>createBuilder()
                .name(Text.translatable("configOption.incantationem.availableAsTreasure"))
                .description(OptionDescription.of(Text.translatable("configOption.incantationem.availableAsTreasure.tooltip")))
                .binding(
                        true,
                        () -> config.lootAndScootAvailableAsTreasure,
                        newValue -> config.lootAndScootAvailableAsTreasure = newValue
                )
                .controller(option -> BooleanControllerBuilder.create(option).yesNoFormatter().coloured(true))
                .build();

        // Magnetic
        Option<Integer> magneticMaxLevel = Option.<Integer>createBuilder()
                .name(Text.translatable("configOption.incantationem.maxLevel"))
                .description(OptionDescription.of(Text.translatable("configOption.incantationem.maxLevel.tooltip")))
                .binding(
                        3,
                        () -> config.magneticMaxLevel,
                        newValue -> config.magneticMaxLevel = newValue
                )
                .controller(option -> IntegerFieldControllerBuilder.create(option).min(1).max(10))
                .build();

        Option<Boolean> magneticAvailableRandomly = Option.<Boolean>createBuilder()
                .name(Text.translatable("configOption.incantationem.availableRandomly"))
                .description(OptionDescription.of(Text.translatable("configOption.incantationem.availableRandomly.tooltip")))
                .binding(
                        true,
                        () -> config.magneticAvailableRandomly,
                        newValue -> config.magneticAvailableRandomly = newValue
                )
                .controller(option -> BooleanControllerBuilder.create(option).yesNoFormatter().coloured(true))
                .build();

        Option<Boolean> magneticAvailableForBookOffer = Option.<Boolean>createBuilder()
                .name(Text.translatable("configOption.incantationem.availableForBookOffer"))
                .description(OptionDescription.of(Text.translatable("configOption.incantationem.availableForBookOffer.tooltip")))
                .binding(
                        true,
                        () -> config.magneticAvailableForBookOffer,
                        newValue -> config.magneticAvailableForBookOffer = newValue
                )
                .controller(option -> BooleanControllerBuilder.create(option).yesNoFormatter().coloured(true))
                .build();

        Option<Boolean> magneticAvailableAsTreasure = Option.<Boolean>createBuilder()
                .name(Text.translatable("configOption.incantationem.availableAsTreasure"))
                .description(OptionDescription.of(Text.translatable("configOption.incantationem.availableAsTreasure.tooltip")))
                .binding(
                        false,
                        () -> config.magneticAvailableAsTreasure,
                        newValue -> config.magneticAvailableAsTreasure = newValue
                )
                .controller(option -> BooleanControllerBuilder.create(option).yesNoFormatter().coloured(true))
                .build();

        // Reaping Rod
        Option<Boolean> reapingRodAvailableRandomly = Option.<Boolean>createBuilder()
                .name(Text.translatable("configOption.incantationem.availableRandomly"))
                .description(OptionDescription.of(Text.translatable("configOption.incantationem.availableRandomly.tooltip")))
                .binding(
                        true,
                        () -> config.reapingRodAvailableRandomly,
                        newValue -> config.reapingRodAvailableRandomly = newValue
                )
                .controller(option -> BooleanControllerBuilder.create(option).yesNoFormatter().coloured(true))
                .build();

        Option<Boolean> reapingRodAvailableForBookOffer = Option.<Boolean>createBuilder()
                .name(Text.translatable("configOption.incantationem.availableForBookOffer"))
                .description(OptionDescription.of(Text.translatable("configOption.incantationem.availableForBookOffer.tooltip")))
                .binding(
                        true,
                        () -> config.reapingRodAvailableForBookOffer,
                        newValue -> config.reapingRodAvailableForBookOffer = newValue
                )
                .controller(option -> BooleanControllerBuilder.create(option).yesNoFormatter().coloured(true))
                .build();

        Option<Boolean> reapingRodAvailableAsTreasure = Option.<Boolean>createBuilder()
                .name(Text.translatable("configOption.incantationem.availableAsTreasure"))
                .description(OptionDescription.of(Text.translatable("configOption.incantationem.availableAsTreasure.tooltip")))
                .binding(
                        false,
                        () -> config.reapingRodAvailableAsTreasure,
                        newValue -> config.reapingRodAvailableAsTreasure = newValue
                )
                .controller(option -> BooleanControllerBuilder.create(option).yesNoFormatter().coloured(true))
                .build();

        // Retreat
        Option<Boolean> retreatAvailableRandomly = Option.<Boolean>createBuilder()
                .name(Text.translatable("configOption.incantationem.availableRandomly"))
                .description(OptionDescription.of(Text.translatable("configOption.incantationem.availableRandomly.tooltip")))
                .binding(
                        true,
                        () -> config.retreatAvailableRandomly,
                        newValue -> config.retreatAvailableRandomly = newValue
                )
                .controller(option -> BooleanControllerBuilder.create(option).yesNoFormatter().coloured(true))
                .build();

        Option<Boolean> retreatAvailableForBookOffer = Option.<Boolean>createBuilder()
                .name(Text.translatable("configOption.incantationem.availableForBookOffer"))
                .description(OptionDescription.of(Text.translatable("configOption.incantationem.availableForBookOffer.tooltip")))
                .binding(
                        true,
                        () -> config.retreatAvailableForBookOffer,
                        newValue -> config.retreatAvailableForBookOffer = newValue
                )
                .controller(option -> BooleanControllerBuilder.create(option).yesNoFormatter().coloured(true))
                .build();

        Option<Boolean> retreatAvailableAsTreasure = Option.<Boolean>createBuilder()
                .name(Text.translatable("configOption.incantationem.availableAsTreasure"))
                .description(OptionDescription.of(Text.translatable("configOption.incantationem.availableAsTreasure.tooltip")))
                .binding(
                        false,
                        () -> config.retreatAvailableAsTreasure,
                        newValue -> config.retreatAvailableAsTreasure = newValue
                )
                .controller(option -> BooleanControllerBuilder.create(option).yesNoFormatter().coloured(true))
                .build();

        // Venomous
        Option<Integer> venomousMaxLevel = Option.<Integer>createBuilder()
                .name(Text.translatable("configOption.incantationem.maxLevel"))
                .description(OptionDescription.of(Text.translatable("configOption.incantationem.maxLevel.tooltip")))
                .binding(
                        3,
                        () -> config.venomousMaxLevel,
                        newValue -> config.venomousMaxLevel = newValue
                )
                .controller(option -> IntegerFieldControllerBuilder.create(option).min(1).max(10))
                .build();

        Option<Boolean> venomousAvailableRandomly = Option.<Boolean>createBuilder()
                .name(Text.translatable("configOption.incantationem.availableRandomly"))
                .description(OptionDescription.of(Text.translatable("configOption.incantationem.availableRandomly.tooltip")))
                .binding(
                        true,
                        () -> config.venomousAvailableRandomly,
                        newValue -> config.venomousAvailableRandomly = newValue
                )
                .controller(option -> BooleanControllerBuilder.create(option).yesNoFormatter().coloured(true))
                .build();

        Option<Boolean> venomousAvailableForBookOffer = Option.<Boolean>createBuilder()
                .name(Text.translatable("configOption.incantationem.availableForBookOffer"))
                .description(OptionDescription.of(Text.translatable("configOption.incantationem.availableForBookOffer.tooltip")))
                .binding(
                        true,
                        () -> config.venomousAvailableForBookOffer,
                        newValue -> config.venomousAvailableForBookOffer = newValue
                )
                .controller(option -> BooleanControllerBuilder.create(option).yesNoFormatter().coloured(true))
                .build();

        Option<Boolean> venomousAvailableAsTreasure = Option.<Boolean>createBuilder()
                .name(Text.translatable("configOption.incantationem.availableAsTreasure"))
                .description(OptionDescription.of(Text.translatable("configOption.incantationem.availableAsTreasure.tooltip")))
                .binding(
                        false,
                        () -> config.venomousAvailableAsTreasure,
                        newValue -> config.venomousAvailableAsTreasure = newValue
                )
                .controller(option -> BooleanControllerBuilder.create(option).yesNoFormatter().coloured(true))
                .build();

        /*
         * CURSES
         */
        // Curse of Recklessness
        Option<Boolean> recklessnessAvailableForBookOffer = Option.<Boolean>createBuilder()
                .name(Text.translatable("configOption.incantationem.availableForBookOffer"))
                .description(OptionDescription.of(Text.translatable("configOption.incantationem.availableForBookOffer.tooltip")))
                .binding(
                        true,
                        () -> config.recklessnessAvailableForBookOffer,
                        newValue -> config.recklessnessAvailableForBookOffer = newValue
                )
                .controller(option -> BooleanControllerBuilder.create(option).yesNoFormatter().coloured(true))
                .build();

        Option<Boolean> recklessnessAvailableAsTreasure = Option.<Boolean>createBuilder()
                .name(Text.translatable("configOption.incantationem.availableAsTreasure"))
                .description(OptionDescription.of(Text.translatable("configOption.incantationem.availableAsTreasure.tooltip")))
                .binding(
                        true,
                        () -> config.recklessnessAvailableAsTreasure,
                        newValue -> config.recklessnessAvailableAsTreasure = newValue
                )
                .controller(option -> BooleanControllerBuilder.create(option).yesNoFormatter().coloured(true))
                .build();

        // Curse of Shrieking
        Option<Boolean> shriekingAvailableForBookOffer = Option.<Boolean>createBuilder()
                .name(Text.translatable("configOption.incantationem.availableForBookOffer"))
                .description(OptionDescription.of(Text.translatable("configOption.incantationem.availableForBookOffer.tooltip")))
                .binding(
                        true,
                        () -> config.shriekingAvailableForBookOffer,
                        newValue -> config.shriekingAvailableForBookOffer = newValue
                )
                .controller(option -> BooleanControllerBuilder.create(option).yesNoFormatter().coloured(true))
                .build();

        Option<Boolean> shriekingAvailableAsTreasure = Option.<Boolean>createBuilder()
                .name(Text.translatable("configOption.incantationem.availableAsTreasure"))
                .description(OptionDescription.of(Text.translatable("configOption.incantationem.availableAsTreasure.tooltip")))
                .binding(
                        true,
                        () -> config.shriekingAvailableAsTreasure,
                        newValue -> config.shriekingAvailableAsTreasure = newValue
                )
                .controller(option -> BooleanControllerBuilder.create(option).yesNoFormatter().coloured(true))
                .build();

        // Curse of the Thunders
        Option<Boolean> thunderAvailableForBookOffer = Option.<Boolean>createBuilder()
                .name(Text.translatable("configOption.incantationem.availableForBookOffer"))
                .description(OptionDescription.of(Text.translatable("configOption.incantationem.availableForBookOffer.tooltip")))
                .binding(
                        true,
                        () -> config.thunderAvailableForBookOffer,
                        newValue -> config.thunderAvailableForBookOffer = newValue
                )
                .controller(option -> BooleanControllerBuilder.create(option).yesNoFormatter().coloured(true))
                .build();

        Option<Boolean> thunderAvailableAsTreasure = Option.<Boolean>createBuilder()
                .name(Text.translatable("configOption.incantationem.availableAsTreasure"))
                .description(OptionDescription.of(Text.translatable("configOption.incantationem.availableAsTreasure.tooltip")))
                .binding(
                        true,
                        () -> config.thunderAvailableAsTreasure,
                        newValue -> config.thunderAvailableAsTreasure = newValue
                )
                .controller(option -> BooleanControllerBuilder.create(option).yesNoFormatter().coloured(true))
                .build();

        // Curse of Tough Luck
        Option<Boolean> toughLuckAvailableForBookOffer = Option.<Boolean>createBuilder()
                .name(Text.translatable("configOption.incantationem.availableForBookOffer"))
                .description(OptionDescription.of(Text.translatable("configOption.incantationem.availableForBookOffer.tooltip")))
                .binding(
                        true,
                        () -> config.toughLuckAvailableForBookOffer,
                        newValue -> config.toughLuckAvailableForBookOffer = newValue
                )
                .controller(option -> BooleanControllerBuilder.create(option).yesNoFormatter().coloured(true))
                .build();

        Option<Boolean> toughLuckAvailableAsTreasure = Option.<Boolean>createBuilder()
                .name(Text.translatable("configOption.incantationem.availableAsTreasure"))
                .description(OptionDescription.of(Text.translatable("configOption.incantationem.availableAsTreasure.tooltip")))
                .binding(
                        true,
                        () -> config.toughLuckAvailableAsTreasure,
                        newValue -> config.toughLuckAvailableAsTreasure = newValue
                )
                .controller(option -> BooleanControllerBuilder.create(option).yesNoFormatter().coloured(true))
                .build();


        return YetAnotherConfigLib.createBuilder()
                .title(Text.of("Incantationem"))
                .category(ConfigCategory.createBuilder()
                        .name(Text.translatable("configCategory.incantationem.enchantment"))
                        .group(
                                createEnchantmentGroup(
                                        "ender_bane",
                                        baneOfEnderMaxLevel,
                                        baneOfEnderAvailableRandomly,
                                        baneOfEnderAvailableForBookOffer,
                                        baneOfEnderAvailableAsTreasure
                                )
                        )
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
                                        "critical_strike",
                                        criticalStrikeMaxLevel,
                                        criticalStrikeAvailableRandomly,
                                        criticalStrikeAvailableForBookOffer,
                                        criticalStrikeAvailableAsTreasure
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
                                        "explosive",
                                        explosiveMaxLevel,
                                        explosiveAvailableRandomly,
                                        explosiveAvailableForBookOffer,
                                        explosiveAvailableAsTreasure
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
                                createLevellessEnchantmentGroup(
                                        "loot_scoot",
                                        lootAndScootAvailableRandomly,
                                        lootAndScootAvailableForBookOffer,
                                        lootAndScootAvailableAsTreasure
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
                        .build())
                .category(ConfigCategory.createBuilder()
                        .name(Text.translatable("configCategory.incantationem.curse"))
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
                .save(() -> Incantationem.saveConfig(config))
                .build()
                .generateScreen(parent);
    }


    private OptionGroup createEnchantmentGroup(String enchantmentId, Option<Integer> maxLevel, Option<Boolean> availableRandomly, Option<Boolean> availableForBookOffer, Option<Boolean> availableAsTreasure) {
        return OptionGroup.createBuilder()
                .name(Text.translatable("enchantment.incantationem." + enchantmentId))
                .description(OptionDescription.of(Text.translatable(String.format("enchantment.incantationem.%s.desc", enchantmentId))))
                .option(maxLevel)
                .option(availableRandomly)
                .option(availableForBookOffer)
                .option(availableAsTreasure)
                .build();
    }

    private OptionGroup createLevellessEnchantmentGroup(String enchantmentId, Option<Boolean> availableRandomly, Option<Boolean> availableForBookOffer, Option<Boolean> availableAsTreasure) {
        return OptionGroup.createBuilder()
                .name(Text.translatable("enchantment.incantationem." + enchantmentId))
                .description(OptionDescription.of(Text.translatable(String.format("enchantment.incantationem.%s.desc", enchantmentId))))
                .option(availableRandomly)
                .option(availableForBookOffer)
                .option(availableAsTreasure)
                .build();
    }

    private OptionGroup createCurseGroup(String enchantmentId, Option<Boolean> availableForBookOffer, Option<Boolean> availableAsTreasure) {
        return OptionGroup.createBuilder()
                .name(Text.translatable("enchantment.incantationem." + enchantmentId))
                .description(OptionDescription.of(Text.translatable(String.format("enchantment.incantationem.%s.desc", enchantmentId))))
                .option(availableForBookOffer)
                .option(availableAsTreasure)
                .build();
    }
    
}