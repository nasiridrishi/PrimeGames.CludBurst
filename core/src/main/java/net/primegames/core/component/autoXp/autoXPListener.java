/*
 *
 *  * Copyright (C) PrimeGames - All Rights Reserved
 *  * Unauthorized copying of this file, via any medium is strictly prohibited
 *  * Proprietary and confidential
 *
 */

package net.primegames.core.component.autoXp;

import cn.nukkit.Player;
import cn.nukkit.entity.Entity;
import cn.nukkit.event.EventHandler;
import cn.nukkit.event.Listener;
import cn.nukkit.event.block.BlockBreakEvent;
import cn.nukkit.event.entity.EntityDamageEvent;
import cn.nukkit.event.player.PlayerDeathEvent;

public class autoXPListener implements Listener {

    @EventHandler
    public void onBreak(BlockBreakEvent event){
        event.getPlayer().addExperience(event.getDropExp());
        event.setDropExp(0);
    }

    @EventHandler
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
