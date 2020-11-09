/*
 *
 *  * Copyright (C) PrimeGames - All Rights Reserved
 *  * Unauthorized copying of this file, via any medium is strictly prohibited
 *  * Proprietary and confidential
 *
 */

package net.primegames.core.listener;

import cn.nukkit.event.EventHandler;
import cn.nukkit.event.Listener;
import net.primegames.core.Core;
import net.primegames.core.event.player.CorePlayerLoadedEvent;
import net.primegames.core.providor.task.player.punishment.MySQLCheckPlayerPunishmentTask;

public class PlayerLoadedListener implements Listener {

    @EventHandler
    public void onLoaded(CorePlayerLoadedEvent event){
        Core.getInstance().getMySQLProvider().scheduleTask(new MySQLCheckPlayerPunishmentTask(event.getPlayer()));
    }
}
