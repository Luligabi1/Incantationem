package me.luligabi.incantationem.common.common;

import dev.architectury.platform.Platform;
import dev.isxander.yacl3.config.v2.api.ConfigClassHandler;
import dev.isxander.yacl3.config.v2.api.SerialEntry;
import dev.isxander.yacl3.config.v2.api.serializer.GsonConfigSerializerBuilder;

public class ModConfig {

    public static final ConfigClassHandler<ModConfig> HANDLER = ConfigClassHandler.createBuilder(ModConfig.class)
        .id(Incantationem.modId("config"))
        .serializer(config -> GsonConfigSerializerBuilder.create(config)
            .setPath(Platform.getConfigFolder().resolve("incantationem.json"))
            .build())
        .build();


    @SerialEntry
    public Enchantments enchantments = new Enchantments();

    public static class Enchantments {

        @SerialEntry
        public BaneOfTheSwine baneOfTheSwine = new BaneOfTheSwine();
        @SerialEntry
        public BunnysHop bunnysHop = new BunnysHop();
        @SerialEntry
        public Charmed charmed = new Charmed();
        @SerialEntry
        public Decay decay = new Decay();
        @SerialEntry
        public Deflection deflection = new Deflection();
        @SerialEntry
        public FuseShot fuseShot = new FuseShot();
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
        @SerialEntry
        public WaterSlash waterSlash = new WaterSlash();

        public static class BaneOfTheSwine {

            @SerialEntry
            public int maxLevel = 5;
            @SerialEntry
            public boolean availableRandomly = true;
            @SerialEntry
            public boolean availableForBookOffer = true;
            @SerialEntry
            public boolean availableAsTreasure = false;
        }

        public static class BunnysHop {

            @SerialEntry
            public int maxLevel = 3;
            @SerialEntry
            public boolean availableRandomly = true;
            @SerialEntry
            public boolean availableForBookOffer = true;
            @SerialEntry
            public boolean availableAsTreasure = false;
        }

        public static class Charmed {

            @SerialEntry
            public boolean availableRandomly = true;
            @SerialEntry
            public boolean availableForBookOffer = true;
            @SerialEntry
            public boolean availableAsTreasure = false;
        }

        public static class Decay {

            @SerialEntry
            public int maxLevel = 3;
            @SerialEntry
            public boolean availableRandomly = true;
            @SerialEntry
            public boolean availableForBookOffer = true;
            @SerialEntry
            public boolean availableAsTreasure = false;
            @SerialEntry
            public boolean isLuckBased = true;
            @SerialEntry
            public boolean showApplyMessage = true;
        }

        public static class Deflection {

            @SerialEntry
            public int maxLevel = 3;
            @SerialEntry
            public boolean availableRandomly = true;
            @SerialEntry
            public boolean availableForBookOffer = true;
            @SerialEntry
            public boolean availableAsTreasure = false;
            @SerialEntry
            public boolean isLuckBased = true;
            @SerialEntry
            public boolean showApplyMessage = true;
        }

        public static class FuseShot {

            @SerialEntry
            public int maxLevel = 3;
            @SerialEntry
            public boolean availableRandomly = false;
            @SerialEntry
            public boolean availableForBookOffer = true;
            @SerialEntry
            public boolean availableAsTreasure = true;
        }

        public static class ForgingTouch {

            @SerialEntry
            public int maxLevel = 3;
            @SerialEntry
            public boolean availableRandomly = true;
            @SerialEntry
            public boolean availableForBookOffer = true;
            @SerialEntry
            public boolean availableAsTreasure = true;
            @SerialEntry
            public boolean isLuckBased = true;
            @SerialEntry
            public boolean showApplyMessage = true;
        }

        public static class LastStand {

            @SerialEntry
            public int maxLevel = 3;
            @SerialEntry
            public boolean availableRandomly = true;
            @SerialEntry
            public boolean availableForBookOffer = true;
            @SerialEntry
            public boolean availableAsTreasure = false;
            @SerialEntry
            public boolean isLuckBased = true;
            @SerialEntry
            public boolean showApplyMessage = true;
        }

        public static class Magnetic {

            @SerialEntry
            public int maxLevel = 3;
            @SerialEntry
            public boolean availableRandomly = true;
            @SerialEntry
            public boolean availableForBookOffer = true;
            @SerialEntry
            public boolean availableAsTreasure = false;
        }

        public static class ReapingRod {

            @SerialEntry
            public boolean availableRandomly = true;
            @SerialEntry
            public boolean availableForBookOffer = true;
            @SerialEntry
            public boolean availableAsTreasure = false;
            @SerialEntry
            public boolean showApplyMessage = true;
        }

        public static class Retreat {

            @SerialEntry
            public boolean availableRandomly = true;
            @SerialEntry
            public boolean availableForBookOffer = true;
            @SerialEntry
            public boolean availableAsTreasure = false;
            @SerialEntry
            public boolean isLuckBased = true;
            @SerialEntry
            public boolean showApplyMessage = true;
        }

        public static class Venomous {

            @SerialEntry
            public int maxLevel = 3;
            @SerialEntry
            public boolean availableRandomly = true;
            @SerialEntry
            public boolean availableForBookOffer = true;
            @SerialEntry
            public boolean availableAsTreasure = false;
            @SerialEntry
            public boolean isLuckBased = true;
            @SerialEntry
            public boolean showApplyMessage = true;
        }

        public static class WaterSlash {

            @SerialEntry
            public int maxLevel = 5;
            @SerialEntry
            public boolean availableRandomly = true;
            @SerialEntry
            public boolean availableForBookOffer = true;
            @SerialEntry
            public boolean availableAsTreasure = false;
        }
    }

    @SerialEntry
    public Curses curses = new Curses();

    public static class Curses {

        @SerialEntry
        public Recklessness recklessness = new Recklessness();
        @SerialEntry
        public Shrieking shrieking = new Shrieking();
        @SerialEntry
        public Thunder thunder = new Thunder();
        @SerialEntry
        public ToughLuck toughLuck = new ToughLuck();

        public static class Recklessness {

            @SerialEntry
            public boolean availableRandomly = true;
            @SerialEntry
            public boolean availableForBookOffer = true;
            @SerialEntry
            public boolean availableAsTreasure = true;
        }

        public static class Shrieking {

            @SerialEntry
            public boolean availableRandomly = true;
            @SerialEntry
            public boolean availableForBookOffer = true;
            @SerialEntry
            public boolean availableAsTreasure = true;
        }

        public static class Thunder {

            @SerialEntry
            public boolean availableRandomly = true;
            @SerialEntry
            public boolean availableForBookOffer = true;
            @SerialEntry
            public boolean availableAsTreasure = true;
            @SerialEntry
            public boolean isLuckBased = true;
            @SerialEntry
            public boolean showApplyMessage = true;
        }

        public static class ToughLuck {

            @SerialEntry
            public boolean availableRandomly = true;
            @SerialEntry
            public boolean availableForBookOffer = true;
            @SerialEntry
            public boolean availableAsTreasure = true;
        }
    }

}