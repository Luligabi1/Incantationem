package me.luligabi.incantationem.common;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonParser;
import me.luligabi.incantationem.common.enchantment.EnchantmentRegistry;
import me.luligabi.incantationem.common.enchantment.curse.CurseRegistry;
import me.luligabi.incantationem.common.tag.TagRegistry;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.entity.EntityGroup;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;

public class Incantationem implements ModInitializer {

    @Override
    public void onInitialize() {
        CurseRegistry.init();
        EnchantmentRegistry.init();

        TagRegistry.init();

        //Registers an unused, vanilla command for setting and clearing the Sculk Shrieker warning level
        //This isn't really needed, but saves 40 minutes each time you want to test the Curse of Shrieking enchantment
//        if(FabricLoader.getInstance().isDevelopmentEnvironment()) {
//            CommandRegistrationCallback.EVENT.register(((dispatcher, registryAccess, environment) -> {
//                WardenSpawnTrackerCommand.register(dispatcher);
//            }));
//        }
    }


    public static Identifier modId(String id) {
        return new Identifier(MOD_ID, id);
    }

    public static final String MOD_ID = "incantationem";

    public static final EntityGroup SWINE = new EntityGroup();
    public static final EntityGroup ENDER = new EntityGroup();


    private static ModConfig createConfig() {
        ModConfig finalConfig;
        LOGGER.info("Trying to read config file...");
        try {
            if(CONFIG_FILE.createNewFile()) {
                LOGGER.info("No config file found, creating a new one...");
                writeConfig(GSON.toJson(JsonParser.parseString(GSON.toJson(new ModConfig()))));
                finalConfig = new ModConfig();
                LOGGER.info("Successfully created default config file.");
            } else {
                LOGGER.info("A config file was found, loading it..");
                finalConfig = GSON.fromJson(new String(Files.readAllBytes(CONFIG_FILE.toPath())), ModConfig.class);
                if(finalConfig == null) {
                    throw new NullPointerException("The config file was empty.");
                } else {
                    LOGGER.info("Successfully loaded config file.");
                }
            }
        } catch(Exception e) {
            LOGGER.error("There was an error creating/loading the config file!", e);
            finalConfig = new ModConfig();
            LOGGER.warn("Defaulting to original config.");
        }
        return finalConfig;
    }

    public static void saveConfig(ModConfig modConfig) {
        try {
            writeConfig(GSON.toJson(JsonParser.parseString(GSON.toJson(modConfig))));
            LOGGER.info("Saved new config file.");
        } catch(Exception e) {
            LOGGER.error("There was an error saving the config file!", e);
        }
    }

    private static void writeConfig(String json) {
        try(PrintWriter printWriter = new PrintWriter(CONFIG_FILE)) {
            printWriter.write(json);
            printWriter.flush();
        } catch(IOException e) {
            LOGGER.error("Failed to write config file", e);
        }
    }


    public static final Logger LOGGER;
    private static final Gson GSON;

    private static final File CONFIG_FILE;
    public static final ModConfig CONFIG;

    static {
        LOGGER = LoggerFactory.getLogger("Incantationem");
        GSON = new GsonBuilder().setPrettyPrinting().create();

        CONFIG_FILE = new File(String.format("%s%s%s.json", FabricLoader.getInstance().getConfigDir(), File.separator, MOD_ID));
        CONFIG = createConfig();
    }
}