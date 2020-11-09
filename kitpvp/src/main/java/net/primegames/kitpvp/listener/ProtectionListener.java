/*
 *
 *  * Copyright (C) PrimeGames - All Rights Reserved
 *  * Unauthorized copying of this file, via any medium is strictly prohibited
 *  * Proprietary and confidential
 *
 */

package net.primegames.kitpvp.listener;

import cn.nukkit.Player;
import cn.nukkit.entity.Entity;
import cn.nukkit.event.EventHandler;
import cn.nukkit.event.Listener;
import cn.nukkit.event.block.BlockBreakEvent;
import cn.nukkit.event.block.BlockPlaceEvent;
import cn.nukkit.event.entity.EntityDamageEvent;
import cn.nukkit.event.player.PlayerInteractEvent;
import cn.nukkit.item.ItemID;

public class ProtectionListener implements Listener {

    @EventHandler
    public void onBreak(BlockBreakEvent event){
        event.setCancelled();
    }

    @EventHandler
    public void onPlace(BlockPlaceEvent event){
        event.setCancelled();
    }

    @EventHandler
    public void onInteract(PlayerInteractEvent event){
        if(event.getItem().getId() == ItemID.ENDER_PEARL || event.getItem().getId() == ItemID.BOW){
            return;
        }
        event.setCancelled();
    }

    @EventHandler
    public void onFall(EntityDamageEvent event){
        Entity entity = event.getEntity();
        if(entity instanceof Player && event.getCause() == EntityDamageEvent.DamageCause.FALL){
            event.setCancelled();
        }
    }
}
