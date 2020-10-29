/*
 *
 *  * Copyright (C) PrimeGames - All Rights Reserved
 *  * Unauthorized copying of this file, via any medium is strictly prohibited
 *  * Proprietary and confidential
 *
 */

package net.primegames.core.event.player;

import net.primegames.core.CorePlayer;
import org.cloudburstmc.server.event.Event;

public class InteractedInCombatEvent extends CorePlayerEvent{

    private final Event event;

    public InteractedInCombatEvent(CorePlayer player, Event event) {
        super(player);
        this.event = event;
    }

    public Event getEvent() {
        return event;
    }
}
