/*
 *
 *  * Copyright (C) PrimeGames - All Rights Reserved
 *  * Unauthorized copying of this file, via any medium is strictly prohibited
 *  * Proprietary and confidential
 *
 */

package net.primegames.kitpvp.listener;

import cn.nukkit.event.EventHandler;
import cn.nukkit.event.Listener;
import net.primegames.core.Utils.Utils;
import net.primegames.core.event.player.CommandUsedInCombatEvent;
import net.primegames.core.event.player.LoggedOutInCombatEvent;

public class KitpvpCombatLoggListener implements Listener {

    @EventHandler
    public void onCombatQuit(LoggedOutInCombatEvent event){
        //todo give kill points to last damager
    }

    @EventHandler
    public void onCombatCommand(CommandUsedInCombatEvent event){
        event.setCancelled();
        event.getPlayer().getPlayer().sendMessage(Utils.translateColors("{RED}Action disabled in combat"));
    }
}
