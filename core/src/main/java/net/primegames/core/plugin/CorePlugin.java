/*
 *
 *  * Copyright (C) PrimeGames - All Rights Reserved
 *  * Unauthorized copying of this file, via any medium is strictly prohibited
 *  * Proprietary and confidential
 *
 */

package net.primegames.core.plugin;

import org.cloudburstmc.server.plugin.PluginBase;

public abstract class CorePlugin extends PluginBase {

    private boolean disabling = false;

    public boolean isDisabling() {
        return disabling;
    }

    @Override
    final public void onDisable() {
        disabling = true;
        disable();
        disabling = false;
    }

    protected void disable(){
    }
}
