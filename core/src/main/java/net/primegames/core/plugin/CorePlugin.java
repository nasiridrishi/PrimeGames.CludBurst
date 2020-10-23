/*
 *
 *  * Copyright (C) PrimeGames - All Rights Reserved
 *  * Unauthorized copying of this file, via any medium is strictly prohibited
 *  * Proprietary and confidential
 *
 */

package net.primegames.core.plugin;


import org.checkerframework.checker.nullness.qual.NonNull;
import org.cloudburstmc.server.Server;
import org.cloudburstmc.server.plugin.PluginContainer;
import org.cloudburstmc.server.plugin.PluginDescription;
import org.slf4j.Logger;

import java.nio.file.Path;

public abstract class CorePlugin implements PluginContainer {
    private final Logger logger;
    private final PluginDescription description;
    private final Path dataFolder;
    private final Server server;

    public CorePlugin(Logger logger, PluginDescription description, Path dataFolder, Server server) {
        this.logger = logger;
        this.description = description;
        this.dataFolder = dataFolder;
        this.server = server;
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
}
