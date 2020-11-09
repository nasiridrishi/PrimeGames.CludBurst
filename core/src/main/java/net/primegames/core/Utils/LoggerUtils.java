/*
 *
 *  * Copyright (C) PrimeGames - All Rights Reserved
 *  * Unauthorized copying of this file, via any medium is strictly prohibited
 *  * Proprietary and confidential
 *
 */

package net.primegames.core.Utils;

import net.primegames.core.Core;

public class LoggerUtils {

    static public void info(String $msg){
        Core.getInstance().getPlugin().getLogger().info($msg);
    }

    static public void error(String $msg){
        Core.getInstance().getPlugin().getLogger().error($msg);
    }

    static public void warn(String $msg){
        Core.getInstance().getPlugin().getLogger().warning($msg);
    }

    static public void debug(String $msg){
        Core.getInstance().getPlugin().getLogger().debug($msg);
    }
}
