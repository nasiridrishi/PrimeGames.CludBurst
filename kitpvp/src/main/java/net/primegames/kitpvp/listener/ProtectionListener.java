/*
 *
 *  * Copyright (C) PrimeGames - All Rights Reserved
 *  * Unauthorized copying of this file, via any medium is strictly prohibited
 *  * Proprietary and confidential
 *
 */

package net.primegames.kitpvp.listener;

import org.cloudburstmc.server.entity.Entity;
import org.cloudburstmc.server.event.EventHandler;
import org.cloudburstmc.server.event.EventPriority;
import org.cloudburstmc.server.event.Listener;
import org.cloudburstmc.server.event.block.BlockBreakEvent;
import org.cloudburstmc.server.event.block.BlockPlaceEvent;
import org.cloudburstmc.server.event.entity.EntityDamageEvent;
import org.cloudburstmc.server.event.player.PlayerInteractEvent;
import org.cloudburstmc.server.item.ItemIds;
import org.cloudburstmc.server.player.Player;

public class ProtectionListener implements Listener {

    @EventHandler(priority = EventPriority.NORMAL, ignoreCancelled = false)
    public void onBreak(BlockBreakEvent event){
        event.setCancelled();
    }

    @EventHandler(priority = EventPriority.NORMAL, ignoreCancelled = false)
    public void onPlace(BlockPlaceEvent event){
        event.setCancelled();
    }

    @EventHandler(priority = EventPriority.NORMAL, ignoreCancelled = false)
    public void onInteract(PlayerInteractEvent event){
        if(event.getItem().getId().equals(ItemIds.ENDER_PEARL) || event.getItem().getId().equals(ItemIds.BOW)){
            return;
        }
        event.setCancelled();
    }

    @EventHandler(priority = EventPriority.NORMAL, ignoreCancelled = false)
    public void onFall(EntityDamageEvent event){
        Entity entity = event.getEntity();
        if(entity instanceof Player && event.getCause() == EntityDamageEvent.DamageCause.FALL){
            event.setCancelled();
        }
    }
}
