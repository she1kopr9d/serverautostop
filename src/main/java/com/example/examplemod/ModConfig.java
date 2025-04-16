package com.example.examplemod;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import net.fabricmc.loader.api.FabricLoader;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;

public class ModConfig {
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();
    private static final Path CONFIG_PATH = FabricLoader.getInstance().getConfigDir().resolve("serverautostop.json");
    
    public int inactivityTimeout = 10; // в минутах
    public boolean enabled = true;
    public String stopCommand = "stop";
    public int warningTime = 5; // в минутах
    public String warningMessage = "Сервер будет остановлен через %d минут из-за отсутствия игроков";

    public static ModConfig load() {
        ModConfig config = new ModConfig();
        
        if (Files.exists(CONFIG_PATH)) {
            try (Reader reader = Files.newBufferedReader(CONFIG_PATH)) {
                config = GSON.fromJson(reader, ModConfig.class);
            } catch (IOException e) {
                ExampleMod.LOGGER.error("Could not load config", e);
            }
        }
        
        config.save();
        return config;
    }

    public void save() {
        try (Writer writer = Files.newBufferedWriter(CONFIG_PATH)) {
            GSON.toJson(this, writer);
        } catch (IOException e) {
            ExampleMod.LOGGER.error("Could not save config", e);
        }
    }
} 