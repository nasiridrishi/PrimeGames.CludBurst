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
import net.primegames.group.Permissions;

public class StaffChat extends Chat {
    public StaffChat() {
        super(ChatId.STAFF_CHAT, Permissions.IS_STAFF);
    }

    @Override
    public void onText(CorePlayer player, String $message) {

    }
}