/*
 *
 *  * Copyright (C) PrimeGames - All Rights Reserved
 *  * Unauthorized copying of this file, via any medium is strictly prohibited
 *  * Proprietary and confidential
 *
 */

package net.primegames.event.player;

import net.primegames.CorePlayer;

public class CorePlayerDataUpdateScheduleEvent extends CorePlayerEvent{
    public CorePlayerDataUpdateScheduleEvent(CorePlayer player) {
        super(player);
    }
}
