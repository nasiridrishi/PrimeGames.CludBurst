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
import net.primegames.core.group.Permissions;

public class StaffChat extends Chat {
    public StaffChat() {
        super(ChatId.STAFF_CHAT, Permissions.IS_STAFF);
    }

    @Override
    public void onText(CorePlayer player, String $message) {

    }
}