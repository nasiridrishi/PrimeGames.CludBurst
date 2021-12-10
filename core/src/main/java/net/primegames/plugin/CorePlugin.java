/*
 *
 *  * Copyright (C) PrimeGames - All Rights Reserved
 *  * Unauthorized copying of this file, via any medium is strictly prohibited
 *  * Proprietary and confidential
 *
 */

package net.primegames.plugin;


import cn.nukkit.plugin.PluginBase;
import cn.nukkit.plugin.PluginManager;

public abstract class CorePlugin extends PluginBase {

    private static CorePlugin instance;

    public CorePlugin(){
        instance = this;
    }

    public static CorePlugin getInstance() {
        return instance;
    }

    public PluginManager getPluginManager(){
        return getServer().getPluginManager();
    }
}
