/*
 *
 *  * Copyright (C) PrimeGames - All Rights Reserved
 *  * Unauthorized copying of this file, via any medium is strictly prohibited
 *  * Proprietary and confidential
 *
 */

package net.primegames.kitpvp.event;

import net.primegames.core.event.CoreEvent;
import net.primegames.kitpvp.KitpvpPlayer;

public class KitPvPPlayerEvent extends CoreEvent {

    private KitpvpPlayer player;

    public KitPvPPlayerEvent(KitpvpPlayer kitpvpPlayer){
        this.player = kitpvpPlayer;
    }

    public KitpvpPlayer getPlayer() {
        return player;
    }
}
