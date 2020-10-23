/*
 *
 *  * Copyright (C) PrimeGames - All Rights Reserved
 *  * Unauthorized copying of this file, via any medium is strictly prohibited
 *  * Proprietary and confidential
 *
 */

package net.primegames.survival;

import net.primegames.core.plugin.CorePlugin;
import org.cloudburstmc.server.Server;
import org.cloudburstmc.server.plugin.Plugin;
import org.cloudburstmc.server.plugin.PluginDescription;
import org.slf4j.Logger;

import java.nio.file.Path;

@Plugin(id = "Survival", version = "0.0.1", authors = {"Nasir Idrishi"})
public class Survival extends CorePlugin {

    public Survival(Logger logger, PluginDescription description, Path dataFolder, Server server){
        super(logger, description, dataFolder, server);
    }
}
