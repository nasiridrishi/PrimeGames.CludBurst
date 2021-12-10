/*
 *
 *  * Copyright (C) PrimeGames - All Rights Reserved
 *  * Unauthorized copying of this file, via any medium is strictly prohibited
 *  * Proprietary and confidential
 *
 */

package net.primegames.event.player;

import cn.nukkit.event.Cancellable;
import net.primegames.CorePlayer;

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
