/*
 *
 *  * Copyright (C) PrimeGames - All Rights Reserved
 *  * Unauthorized copying of this file, via any medium is strictly prohibited
 *  * Proprietary and confidential
 *
 */

package net.primegames.core.listener;

import net.primegames.core.CorePlayer;
import org.cloudburstmc.server.event.Listener;
import org.cloudburstmc.server.event.player.PlayerChatEvent;


public class ChatListener {

    @Listener
    public void onChat(PlayerChatEvent event){
        CorePlayer player = CorePlayer.cast(event.getPlayer());
        player.getChat().onText(player, event.getMessage());
        event.setCancelled();
    }
}
