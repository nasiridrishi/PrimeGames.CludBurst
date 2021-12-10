/*
 *
 *  * Copyright (C) PrimeGames - All Rights Reserved
 *  * Unauthorized copying of this file, via any medium is strictly prohibited
 *  * Proprietary and confidential
 *
 */

package net.primegames.event.player;

import net.primegames.CorePlayer;

public class CorePlayerEvent extends CoreEvent {

    private final CorePlayer player;

    public CorePlayerEvent(CorePlayer player){
        this.player = player;
    }

    public CorePlayer getPlayer() {
        return player;
    }
}
