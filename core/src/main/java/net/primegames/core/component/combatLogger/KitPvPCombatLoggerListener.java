/*
 *
 *  * Copyright (C) PrimeGames - All Rights Reserved
 *  * Unauthorized copying of this file, via any medium is strictly prohibited
 *  * Proprietary and confidential
 *
 */

package net.primegames.core.component.combatLogger;

import net.primegames.core.CorePlayer;
import net.primegames.core.event.player.CommandUsedInCombatEvent;
import net.primegames.core.event.player.InteractedInCombatEvent;
import net.primegames.core.event.player.LoggedOutInCombatEvent;
import org.cloudburstmc.server.entity.Entity;
import org.cloudburstmc.server.event.EventPriority;
import org.cloudburstmc.server.event.Listener;
import org.cloudburstmc.server.event.entity.EntityDamageByEntityEvent;
import org.cloudburstmc.server.event.player.PlayerCommandPreprocessEvent;
import org.cloudburstmc.server.event.player.PlayerDeathEvent;
import org.cloudburstmc.server.event.player.PlayerInteractEvent;
import org.cloudburstmc.server.event.player.PlayerQuitEvent;
import org.cloudburstmc.server.player.Player;

public class KitPvPCombatLoggerListener {

    @Listener(priority = EventPriority.MONITOR)
    public void onDamage(EntityDamageByEntityEvent event) {
            Entity victim = event.getEntity();
            Entity damager = event.getDamager();
            if (victim instanceof CorePlayer && damager instanceof CorePlayer && !event.isCancelled()) {
                CombatLogHeartBeat.getInstance().setTagged(CorePlayer.cast((Player) victim));
                CombatLogHeartBeat.getInstance().setTagged(CorePlayer.cast((Player) damager));
            }
    }

    @Listener
    public void onQuit(PlayerQuitEvent event){
        CorePlayer player = CorePlayer.cast(event.getPlayer());
        if(CombatLogHeartBeat.getInstance().isTagged(player) && event.getReason().equals("Disconnected from Server")){
            player.getServer().getEventManager().fire(new LoggedOutInCombatEvent(player));
        }
    }

    @Listener
    public void onDeath(PlayerDeathEvent event){
        CorePlayer player = CorePlayer.cast(event.getEntity().getPlayer());
        if(CombatLogHeartBeat.getInstance().isTagged(player)){
            CombatLogHeartBeat.getInstance().removeTagged(player);
        }
    }

    @Listener
    public void onInteract(PlayerInteractEvent event){
        CorePlayer player = CorePlayer.cast(event.getPlayer());
        if(CombatLogHeartBeat.getInstance().isTagged(player)){
            player.getServer().getEventManager().fire(new InteractedInCombatEvent(player, event));
        }
    }

    @Listener
    public void onCommand(PlayerCommandPreprocessEvent event){
        CorePlayer player = CorePlayer.cast(event.getPlayer());
        String command = event.getMessage().split(" ")[0].toLowerCase();
        if(player.getServer().getCommandRegistry().getCommandList().contains(command)){
            player.getServer().getEventManager().fire(new CommandUsedInCombatEvent(player, event));
        }
    }
}
