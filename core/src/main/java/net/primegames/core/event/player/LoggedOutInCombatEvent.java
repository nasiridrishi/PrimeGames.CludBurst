/*
 *
 *  * Copyright (C) PrimeGames - All Rights Reserved
 *  * Unauthorized copying of this file, via any medium is strictly prohibited
 *  * Proprietary and confidential
 *
 */

package net.primegames.core.event.player;

import net.primegames.core.CorePlayer;

public class LoggedOutInCombatEvent extends CorePlayerEvent{
    public LoggedOutInCombatEvent(CorePlayer player) {
        super(player);
    }
}
