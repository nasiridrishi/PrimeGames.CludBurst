/*
 *
 *  * Copyright (C) PrimeGames - All Rights Reserved
 *  * Unauthorized copying of this file, via any medium is strictly prohibited
 *  * Proprietary and confidential
 *
 */

package net.primegames.core.event.player;

import net.primegames.core.CorePlayer;
import org.cloudburstmc.server.event.Cancellable;

public class CommandUsedInCombatEvent extends CorePlayerEvent{

    private final Cancellable cancellable;

    public CommandUsedInCombatEvent(CorePlayer player, Cancellable cancellable) {
        super(player);
        this.cancellable = cancellable;
    }

    public Cancellable getEvent(){
        return cancellable;
    }
}
