/*
 *
 *  * Copyright (C) PrimeGames - All Rights Reserved
 *  * Unauthorized copying of this file, via any medium is strictly prohibited
 *  * Proprietary and confidential
 *
 */

package net.primegames.core.component.combatLogger;

import cn.nukkit.Player;
import cn.nukkit.entity.Entity;
import cn.nukkit.event.EventHandler;
import cn.nukkit.event.Listener;
import cn.nukkit.event.entity.EntityDamageByEntityEvent;
import cn.nukkit.event.player.PlayerCommandPreprocessEvent;
import cn.nukkit.event.player.PlayerDeathEvent;
import cn.nukkit.event.player.PlayerInteractEvent;
import cn.nukkit.event.player.PlayerQuitEvent;
import net.primegames.core.Core;
import net.primegames.core.CorePlayer;
import net.primegames.core.event.player.CommandUsedInCombatEvent;
import net.primegames.core.event.player.InteractedInCombatEvent;
import net.primegames.core.event.player.LoggedOutInCombatEvent;

public class KitPvPCombatLoggerListener implements Listener {

    @EventHandler
    public void onDamage(EntityDamageByEntityEvent event) {
            Entity victim = event.getEntity();
            Entity damager = event.getDamager();
            if (victim instanceof CorePlayer && damager instanceof CorePlayer && !event.isCancelled()) {
                CombatLogHeartBeat.getInstance().setTagged(CorePlayer.cast((Player) victim));
                CombatLogHeartBeat.getInstance().setTagged(CorePlayer.cast((Player) damager));
            }
    }

    @EventHandler
    public void onQuit(PlayerQuitEvent event){
        CorePlayer player = CorePlayer.cast(event.getPlayer());
        if(CombatLogHeartBeat.getInstance().isTagged(player) && event.getReason().equals("Disconnected from Server")){
            Core.getInstance().getServer().getPluginManager().callEvent(new LoggedOutInCombatEvent(player));
        }
    }

    @EventHandler
    public void onDeath(PlayerDeathEvent event){
        CorePlayer player = CorePlayer.cast(event.getEntity().getPlayer());
        if(CombatLogHeartBeat.getInstance().isTagged(player)){
            CombatLogHeartBeat.getInstance().removeTagged(player);
        }
    }

    @EventHandler
    public void onInteract(PlayerInteractEvent event){
        CorePlayer player = CorePlayer.cast(event.getPlayer());
        if(CombatLogHeartBeat.getInstance().isTagged(player)){
            Core.getInstance().getServer().getPluginManager().callEvent(new InteractedInCombatEvent(player, event));
        }
    }

    @EventHandler
    public void onCommand(PlayerCommandPreprocessEvent event){
        CorePlayer player = CorePlayer.cast(event.getPlayer());
        String command = event.getMessage().split(" ")[0].toLowerCase();
        if(player.getServer().getCommandMap().getCommands().containsKey(command)){
            Core.getInstance().getServer().getPluginManager().callEvent(new CommandUsedInCombatEvent(player, event));
        }
    }
}
