/*
 *
 *  * Copyright (C) PrimeGames - All Rights Reserved
 *  * Unauthorized copying of this file, via any medium is strictly prohibited
 *  * Proprietary and confidential
 *
 */

package net.primegames.core.event.player;

import net.primegames.core.CorePlayer;

public class CorePlayerLoadedEvent extends CorePlayerEvent{
//    private static final HandlerList handlers = new HandlerList();
//
//    public static HandlerList getHandlers() {
//        return handlers;
//    }

    public CorePlayerLoadedEvent(CorePlayer player) {
        super(player);
    }
}
