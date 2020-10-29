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

public class InteractedInCombatEvent extends CorePlayerEvent{

    private final Cancellable event;

    public InteractedInCombatEvent(CorePlayer player, Cancellable event) {
        super(player);
        this.event = event;
    }

    public Cancellable getEvent() {
        return event;
    }
}
