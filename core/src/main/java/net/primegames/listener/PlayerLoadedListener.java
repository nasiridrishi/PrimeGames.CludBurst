/*
 *
 *  * Copyright (C) PrimeGames - All Rights Reserved
 *  * Unauthorized copying of this file, via any medium is strictly prohibited
 *  * Proprietary and confidential
 *
 */

package net.primegames.listener;

import cn.nukkit.event.EventHandler;
import cn.nukkit.event.Listener;
import net.primegames.Core;
import net.primegames.event.player.CorePlayerLoadedEvent;
import net.primegames.providor.task.player.punishment.MySQLCheckPlayerPunishmentTask;

public class PlayerLoadedListener implements Listener {

    @EventHandler
    public void onLoaded(CorePlayerLoadedEvent event){
        Core.getInstance().getMySQLProvider().scheduleTask(new MySQLCheckPlayerPunishmentTask(event.getPlayer()));
    }
}
