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
import cn.nukkit.event.player.PlayerChatEvent;
import net.primegames.CorePlayer;


public class ChatListener implements Listener {

    @EventHandler
    public void onChat(PlayerChatEvent event){
        CorePlayer player = CorePlayer.cast(event.getPlayer());
        player.getChat().onText(player, event.getMessage());
        event.setCancelled();
    }
}
