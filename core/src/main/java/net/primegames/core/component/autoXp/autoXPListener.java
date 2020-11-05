/*
 *
 *  * Copyright (C) PrimeGames - All Rights Reserved
 *  * Unauthorized copying of this file, via any medium is strictly prohibited
 *  * Proprietary and confidential
 *
 */

package net.primegames.core.component.autoXp;

import org.cloudburstmc.server.entity.Entity;
import org.cloudburstmc.server.event.Listener;
import org.cloudburstmc.server.event.block.BlockBreakEvent;
import org.cloudburstmc.server.event.entity.EntityDamageEvent;
import org.cloudburstmc.server.event.player.PlayerDeathEvent;
import org.cloudburstmc.server.player.Player;

public class autoXPListener {

    @Listener
    public void onBreak(BlockBreakEvent event){
        event.getPlayer().addExperience(event.getDropExp());
        event.setDropExp(0);
    }

    @Listener
    public void onDeath(PlayerDeathEvent event){
        Player player = event.getEntity().getPlayer();
        EntityDamageEvent damageEvent = player.getLastDamageCause();
        Entity attacker = damageEvent.getEntity();
        if(attacker instanceof Player){
            ((Player) attacker).addExperience(event.getExperience());
            player.setExperience(0);
        }
    }
}
