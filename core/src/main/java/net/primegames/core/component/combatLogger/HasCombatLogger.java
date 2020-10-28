/*
 *
 *  * Copyright (C) PrimeGames - All Rights Reserved
 *  * Unauthorized copying of this file, via any medium is strictly prohibited
 *  * Proprietary and confidential
 *
 */

package net.primegames.core.component.combatLogger;

public interface HasCombatLogger {

    boolean isInCombatLog();

    /**
     * Instantiate new CombatLogHeartBeat
     */
    void setCombatLog();

    /**
     * returns combat time left in seconds.
     */
    int getCombatTimeLeft();

    void unsetCombatLog();
}
