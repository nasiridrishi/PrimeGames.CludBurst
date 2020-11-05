/*
 *
 *  * Copyright (C) PrimeGames - All Rights Reserved
 *  * Unauthorized copying of this file, via any medium is strictly prohibited
 *  * Proprietary and confidential
 *
 */

package net.primegames.kitpvp.event.player;

import net.primegames.kitpvp.KitpvpPlayer;
import net.primegames.kitpvp.event.KitPvPPlayerEvent;

public class KitPvPPlayerRegisteredEvent extends KitPvPPlayerEvent {
    public KitPvPPlayerRegisteredEvent(KitpvpPlayer kitpvpPlayer) {
        super(kitpvpPlayer);
    }
}