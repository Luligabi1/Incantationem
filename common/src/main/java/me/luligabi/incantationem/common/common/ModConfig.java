package me.luligabi.incantationem.common.common;

import dev.architectury.platform.Platform;
import dev.isxander.yacl3.config.v2.api.ConfigClassHandler;
import dev.isxander.yacl3.config.v2.api.SerialEntry;
import dev.isxander.yacl3.config.v2.api.serializer.GsonConfigSerializerBuilder;
import me.luligabi.incantationem.common.common.enchantment.effecttype.Magnetic;

public class ModConfig {

    public static final ConfigClassHandler<ModConfig> HANDLER = ConfigClassHandler.createBuilder(ModConfig.class)
        .id(Incantationem.id("config"))
        .serializer(config -> GsonConfigSerializerBuilder.create(config)
            .setPath(Platform.getConfigFolder().resolve("incantationem.json"))
            .build())
        .build();


    @SerialEntry
    public Enchantments enchantments = new Enchantments();

    public static class Enchantments {

        @SerialEntry
        public Decay decay = new Decay();
        @SerialEntry
        public Deflection deflection = new Deflection();
        @SerialEntry
        public ForgingTouch forgingTouch = new ForgingTouch();
        @SerialEntry
        public LastStand lastStand = new LastStand();
        @SerialEntry
        public Magnetic magnetic = new Magnetic();
        @SerialEntry
        public ReapingRod reapingRod = new ReapingRod();
        @SerialEntry
        public Retreat retreat = new Retreat();
        @SerialEntry
        public Venomous venomous = new Venomous();

        public static class Decay {

            @SerialEntry
            public boolean isLuckBased = true;
            @SerialEntry
            public int successRate = 10;
            @SerialEntry
            public boolean showApplyMessage = true;
        }

        public static class Deflection {

            @SerialEntry
            public boolean isLuckBased = true;
            @SerialEntry
            public int successRate = 4;
            @SerialEntry
            public boolean showApplyMessage = true;
        }

        public static class ForgingTouch {

            @SerialEntry
            public boolean isLuckBased = true;
            @SerialEntry
            public int successRate = 15;
            @SerialEntry
            public boolean showApplyMessage = true;
        }

        public static class LastStand {

            @SerialEntry
            public boolean isLuckBased = true;
            @SerialEntry
            public int successRate = 30;
            @SerialEntry
            public boolean showApplyMessage = true;
        }

        public static class ReapingRod {

            @SerialEntry
            public boolean showApplyMessage = true;
        }

        public static class Retreat {

            @SerialEntry
            public boolean isLuckBased = true;
            @SerialEntry
            public int successRate = 20;
            @SerialEntry
            public boolean showApplyMessage = true;
        }

        public static class Venomous {

            @SerialEntry
            public boolean isLuckBased = true;
            @SerialEntry
            public int successRate = 15;
            @SerialEntry
            public boolean showApplyMessage = true;
        }
    }

    @SerialEntry
    public Curses curses = new Curses();

    public static class Curses {

        @SerialEntry
        public Thunder thunder = new Thunder();

        public static class Thunder {

            @SerialEntry
            public boolean isLuckBased = true;
            @SerialEntry
            public int successRate = 15;
            @SerialEntry
            public boolean showApplyMessage = true;
        }
    }

}