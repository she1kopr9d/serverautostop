package com.example.examplemod;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerLifecycleEvents;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.text.Text;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.atomic.AtomicBoolean;

public class ExampleMod implements ModInitializer {
    public static final String MOD_ID = "examplemod";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);
    
    private ModConfig config;
    private Timer inactivityTimer;
    private Timer warningTimer;
    private final AtomicBoolean isTimerRunning = new AtomicBoolean(false);
    private MinecraftServer server;

    @Override
    public void onInitialize() {
        LOGGER.info("Server Auto Stop mod initialized!");
        config = ModConfig.load();
        
        ServerLifecycleEvents.SERVER_STARTED.register(server -> {
            this.server = server;
            if (config.enabled) {
                startInactivityTimer();
            }
        });

        ServerTickEvents.END_SERVER_TICK.register(server -> {
            if (server.getCurrentPlayerCount() > 0) {
                resetInactivityTimer();
            }
        });

        ServerLifecycleEvents.SERVER_STOPPING.register(server -> {
            stopInactivityTimer();
        });
    }

    private void startInactivityTimer() {
        if (isTimerRunning.compareAndSet(false, true)) {
            inactivityTimer = new Timer();
            inactivityTimer.schedule(new TimerTask() {
                @Override
                public void run() {
                    if (server != null && server.getCurrentPlayerCount() == 0 && config.enabled) {
                        LOGGER.info("No players online for {} minutes. Stopping server...", config.inactivityTimeout);
                        ServerCommandSource source = server.getCommandSource();
                        server.getCommandManager().executeWithPrefix(source, config.stopCommand);
                    }
                }
            }, config.inactivityTimeout * 60L * 1000L);

            // Запускаем таймер предупреждения
            if (config.warningTime > 0 && config.warningTime < config.inactivityTimeout) {
                warningTimer = new Timer();
                warningTimer.schedule(new TimerTask() {
                    @Override
                    public void run() {
                        if (server != null && server.getCurrentPlayerCount() == 0 && config.enabled) {
                            String message = String.format(config.warningMessage, config.inactivityTimeout - config.warningTime);
                            server.getPlayerManager().broadcast(Text.literal(message), false);
                            LOGGER.info(message);
                        }
                    }
                }, (config.inactivityTimeout - config.warningTime) * 60L * 1000L);
            }
        }
    }

    private void resetInactivityTimer() {
        stopInactivityTimer();
        if (config.enabled) {
            startInactivityTimer();
        }
    }

    private void stopInactivityTimer() {
        if (isTimerRunning.compareAndSet(true, false)) {
            if (inactivityTimer != null) {
                inactivityTimer.cancel();
                inactivityTimer = null;
            }
            if (warningTimer != null) {
                warningTimer.cancel();
                warningTimer = null;
            }
        }
    }
} 