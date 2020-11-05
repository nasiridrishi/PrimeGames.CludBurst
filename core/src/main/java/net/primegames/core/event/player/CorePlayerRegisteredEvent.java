/*
 *
 *  * Copyright (C) PrimeGames - All Rights Reserved
 *  * Unauthorized copying of this file, via any medium is strictly prohibited
 *  * Proprietary and confidential
 *
 */

package net.primegames.core.event.player;

import net.primegames.core.CorePlayer;

public class CorePlayerRegisteredEvent extends CorePlayerEvent{
    public CorePlayerRegisteredEvent(CorePlayer player) {
        super(player);
    }
}
