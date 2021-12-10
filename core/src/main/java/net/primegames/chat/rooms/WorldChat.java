/*
 *
 *  * Copyright (C) PrimeGames - All Rights Reserved
 *  * Unauthorized copying of this file, via any medium is strictly prohibited
 *  * Proprietary and confidential
 *
 */

package net.primegames.chat.rooms;

import net.primegames.chat.Chat;
import net.primegames.chat.ChatId;
import net.primegames.CorePlayer;
import net.primegames.Utils.ChatUtils;

public class WorldChat extends Chat {
    public WorldChat() {
        super(ChatId.WORLD_CHAT, null);
    }

    @Override
    public void onText(CorePlayer player, String $message) {
        if(ChatUtils.isSpam(player, $message)){
            return;
        }
    }
}
