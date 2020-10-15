/*
 *
 *  * Copyright (C) PrimeGames - All Rights Reserved
 *  * Unauthorized copying of this file, via any medium is strictly prohibited
 *  * Proprietary and confidential
 *
 */

package net.primegames.core.event.player;

import net.primegames.core.CorePlayer;
import net.primegames.core.event.CoreEvent;

public class CorePlayerEvent extends CoreEvent {

    private CorePlayer player;

    public CorePlayerEvent(CorePlayer player){
        this.player = player;
    }

    public CorePlayer getPlayer() {
        return player;
    }
}
