/*
 *
 *  * Copyright (C) PrimeGames - All Rights Reserved
 *  * Unauthorized copying of this file, via any medium is strictly prohibited
 *  * Proprietary and confidential
 *
 */

package net.primegames.core.plugin;


import net.primegames.core.Utils.Config;
import net.primegames.core.Utils.LoggerUtils;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.cloudburstmc.server.Server;
import org.cloudburstmc.server.event.EventManager;
import org.cloudburstmc.server.event.server.ServerInitializationEvent;
import org.cloudburstmc.server.event.server.ServerStartEvent;
import org.cloudburstmc.server.plugin.PluginContainer;
import org.cloudburstmc.server.plugin.PluginDescription;
import org.slf4j.Logger;

import java.nio.file.Path;

public abstract class CorePlugin implements PluginContainer {
    private final Logger logger;
    private final PluginDescription description;
    private final Path dataFolder;
    private final Server server;

    private final Config defaultConfig;

    public CorePlugin(Logger logger, PluginDescription description, Path dataFolder, Server server) {
        this.logger = logger;
        this.description = description;
        this.dataFolder = dataFolder;
        this.server = server;
        defaultConfig = new Config(dataFolder);
    }

    public Server getServer() {
        return server;
    }

    @Override
    @NonNull
    public Object getPlugin() {
        return this;
    }

    @Override
    @NonNull
    public PluginDescription getDescription() {
        return description;
    }

    @Override
    @NonNull
    public Logger getLogger() {
        return logger;
    }

    @Override
    @NonNull
    public Path getDataDirectory() {
        return dataFolder;
    }

    public Config getDefaultConfig() {
        return defaultConfig;
    }

    public EventManager getEventManager(){
        return server.getEventManager();
    }


    public void onInitialization(ServerInitializationEvent event) {

    }

    public void onStart(ServerStartEvent event) {
    }
}
