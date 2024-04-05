package me.luligabi.incantationem.common.common;

import dev.architectury.platform.Platform;
import dev.isxander.yacl3.config.v2.api.ConfigClassHandler;
import dev.isxander.yacl3.config.v2.api.SerialEntry;
import dev.isxander.yacl3.config.v2.api.serializer.GsonConfigSerializerBuilder;

public class ModConfig {

    public static final ConfigClassHandler<ModConfig> HANDLER = ConfigClassHandler.createBuilder(ModConfig.class)
        .id(Incantationem.modId("config"))
        .serializer(config -> GsonConfigSerializerBuilder.create(config)
            .setPath(Platform.getConfigFolder().resolve("incantationem.json5"))
            .setJson5(true)
            .build())
        .build();

    /*
     * ENCHANTMENTS
     */
    // Bane of The Swine
    @SerialEntry public int baneOfTheSwineMaxLevel = 5;
    @SerialEntry public boolean baneOfTheSwineAvailableRandomly = true;
    @SerialEntry public boolean baneOfTheSwineAvailableForBookOffer = true;
    @SerialEntry public boolean baneOfTheSwineAvailableAsTreasure = false;

    // Bunny's Hop
    @SerialEntry public int bunnysHopMaxLevel = 3;
    @SerialEntry public boolean bunnysHopAvailableRandomly = true;
    @SerialEntry public boolean bunnysHopAvailableForBookOffer = true;
    @SerialEntry public boolean bunnysHopAvailableAsTreasure = false;

    // Charmed
    @SerialEntry public boolean charmedAvailableRandomly = true;
    @SerialEntry public boolean charmedAvailableForBookOffer = true;
    @SerialEntry public boolean charmedAvailableAsTreasure = false;

    // Decay
    @SerialEntry public int decayMaxLevel = 3;
    @SerialEntry public boolean decayAvailableRandomly = true;
    @SerialEntry public boolean decayAvailableForBookOffer = true;
    @SerialEntry public boolean decayAvailableAsTreasure = false;

    // Deflection
    @SerialEntry public int deflectionMaxLevel = 3;
    @SerialEntry public boolean deflectionAvailableRandomly = true;
    @SerialEntry public boolean deflectionAvailableForBookOffer = true;
    @SerialEntry public boolean deflectionAvailableAsTreasure = false;

    // Fuse Shot
    @SerialEntry public int fuseShotMaxLevel = 3;
    @SerialEntry public boolean fuseShotAvailableRandomly = false;
    @SerialEntry public boolean fuseShotAvailableForBookOffer = true;
    @SerialEntry public boolean fuseShotAvailableAsTreasure = true;

    // Forging Touch
    @SerialEntry public int forgingTouchMaxLevel = 3;
    @SerialEntry public boolean forgingTouchAvailableRandomly = true;
    @SerialEntry public boolean forgingTouchAvailableForBookOffer = true;
    @SerialEntry public boolean forgingTouchAvailableAsTreasure = true;

    // Last Stand
    @SerialEntry public int lastStandMaxLevel = 3;
    @SerialEntry public boolean lastStandAvailableRandomly = true;
    @SerialEntry public boolean lastStandAvailableForBookOffer = true;
    @SerialEntry public boolean lastStandAvailableAsTreasure = false;

    // Magnetic
    @SerialEntry public int magneticMaxLevel = 3;
    @SerialEntry public boolean magneticAvailableRandomly = true;
    @SerialEntry public boolean magneticAvailableForBookOffer = true;
    @SerialEntry public boolean magneticAvailableAsTreasure = false;

    // Reaping Rod
    @SerialEntry public boolean reapingRodAvailableRandomly = true;
    @SerialEntry public boolean reapingRodAvailableForBookOffer = true;
    @SerialEntry public boolean reapingRodAvailableAsTreasure = false;

    // Retreat
    @SerialEntry public boolean retreatAvailableRandomly = true;
    @SerialEntry public boolean retreatAvailableForBookOffer = true;
    @SerialEntry public boolean retreatAvailableAsTreasure = false;

    // Venomous
    @SerialEntry public int venomousMaxLevel = 3;
    @SerialEntry public boolean venomousAvailableRandomly = true;
    @SerialEntry public boolean venomousAvailableForBookOffer = true;
    @SerialEntry public boolean venomousAvailableAsTreasure = false;

    // Water Slash
    @SerialEntry public int waterSlashMaxLevel = 5;
    @SerialEntry public boolean waterSlashAvailableRandomly = true;
    @SerialEntry public boolean waterSlashAvailableForBookOffer = true;
    @SerialEntry public boolean waterSlashAvailableAsTreasure = false;


    /*
     * CURSES
     */
    // Curse of Recklessness
    @SerialEntry public boolean recklessnessAvailableForBookOffer = true;
    @SerialEntry public boolean recklessnessAvailableAsTreasure = true;

    // Curse of Shrieking
    @SerialEntry public boolean shriekingAvailableForBookOffer = true;
    @SerialEntry public boolean shriekingAvailableAsTreasure = true;

    // Curse of the Thunders
    @SerialEntry public boolean thunderAvailableForBookOffer = true;
    @SerialEntry public boolean thunderAvailableAsTreasure = true;

    // Curse of Tough Luck
    @SerialEntry public boolean toughLuckAvailableForBookOffer = true;
    @SerialEntry public boolean toughLuckAvailableAsTreasure = true;

}