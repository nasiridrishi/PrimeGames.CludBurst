/*
 *
 *  * Copyright (C) PrimeGames - All Rights Reserved
 *  * Unauthorized copying of this file, via any medium is strictly prohibited
 *  * Proprietary and confidential
 *
 */

package net.primegames.kitpvp.listener;

import org.cloudburstmc.server.entity.Entity;
import org.cloudburstmc.server.event.Listener;
import org.cloudburstmc.server.event.block.BlockBreakEvent;
import org.cloudburstmc.server.event.block.BlockPlaceEvent;
import org.cloudburstmc.server.event.entity.EntityDamageEvent;
import org.cloudburstmc.server.event.player.PlayerInteractEvent;
import org.cloudburstmc.server.item.behavior.ItemIds;
import org.cloudburstmc.server.player.Player;

public class ProtectionListener{

    @Listener
    public void onBreak(BlockBreakEvent event){
        event.setCancelled();
    }

    @Listener
    public void onPlace(BlockPlaceEvent event){
        event.setCancelled();
    }

    @Listener
    public void onInteract(PlayerInteractEvent event){
        if(event.getItem().getId().equals(ItemIds.ENDER_PEARL) || event.getItem().getId().equals(ItemIds.BOW)){
            return;
        }
        event.setCancelled();
    }

    @Listener
    public void onFall(EntityDamageEvent event){
        Entity entity = event.getEntity();
        if(entity instanceof Player && event.getCause() == EntityDamageEvent.DamageCause.FALL){
            event.setCancelled();
        }
    }
}
