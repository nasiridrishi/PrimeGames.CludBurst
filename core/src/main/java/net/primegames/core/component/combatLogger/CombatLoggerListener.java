/*
 *
 *  * Copyright (C) PrimeGames - All Rights Reserved
 *  * Unauthorized copying of this file, via any medium is strictly prohibited
 *  * Proprietary and confidential
 *
 */

package net.primegames.core.component.combatLogger;

import net.primegames.core.CorePlayer;
import org.cloudburstmc.server.entity.Entity;
import org.cloudburstmc.server.event.EventPriority;
import org.cloudburstmc.server.event.Listener;
import org.cloudburstmc.server.event.entity.EntityDamageEvent;
import org.cloudburstmc.server.event.player.PlayerDeathEvent;
import org.cloudburstmc.server.event.player.PlayerInteractEvent;
import org.cloudburstmc.server.event.player.PlayerQuitEvent;

public class CombatLoggerListener {

    @Listener(priority = EventPriority.MONITOR)
    public void onDamage(EntityDamageEvent event){
        Entity entity = event.getEntity();
        EntityDamageEvent cause =  entity.getLastDamageCause();
        if(!(event.getEntity() instanceof CorePlayer) || event.isCancelled()){
            return;
        }

    }

    @Listener
    public void onQuit(PlayerQuitEvent event){

    }

    @Listener
    public void onDeath(PlayerDeathEvent event){

    }

    @Listener
    public void onInteract(PlayerInteractEvent event){

    }
}
