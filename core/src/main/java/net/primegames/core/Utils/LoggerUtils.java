/*
 *
 *  * Copyright (C) PrimeGames - All Rights Reserved
 *  * Unauthorized copying of this file, via any medium is strictly prohibited
 *  * Proprietary and confidential
 *
 */

package net.primegames.core.Utils;

import net.primegames.core.Core;
import org.cloudburstmc.server.Server;
import org.cloudburstmc.server.utils.Utils;

public class LoggerUtils {

    static public void info(String $msg){
        Core.getInstance().getLogger().info($msg);
    }

    static public void error(String $msg){
        Core.getInstance().getLogger().error($msg);
    }

    static public void warn(String $msg){
        Core.getInstance().getLogger().warn($msg);
    }

    static public void debug(String $msg){
        Core.getInstance().getLogger().debug($msg);
    }
}
