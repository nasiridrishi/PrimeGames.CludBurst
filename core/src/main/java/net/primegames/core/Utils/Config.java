/*
 *
 *  * Copyright (C) PrimeGames - All Rights Reserved
 *  * Unauthorized copying of this file, via any medium is strictly prohibited
 *  * Proprietary and confidential
 *
 */

package net.primegames.core.Utils;

import net.primegames.core.Core;
import org.cloudburstmc.server.utils.PluginConfig;

import java.nio.file.Path;
import java.nio.file.Paths;

public class Config extends PluginConfig {
    public Config(Path path) {
        super(Paths.get(path.toString() + "/config.yml"));
    }
}
