/*
 *
 *  * Copyright (C) PrimeGames - All Rights Reserved
 *  * Unauthorized copying of this file, via any medium is strictly prohibited
 *  * Proprietary and confidential
 *
 */

package net.primegames.core.chat.rooms;

import net.primegames.core.CorePlayer;
import net.primegames.core.chat.Chat;
import net.primegames.core.chat.ChatId;

public class WorldChat extends Chat {
    public WorldChat() {
        super(ChatId.WORLD_CHAT, null);
    }

    @Override
    public void onText(CorePlayer player, String $message) {

    }
}
