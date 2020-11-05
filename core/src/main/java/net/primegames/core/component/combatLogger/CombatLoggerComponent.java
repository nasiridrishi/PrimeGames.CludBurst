/*
 *
 *  * Copyright (C) PrimeGames - All Rights Reserved
 *  * Unauthorized copying of this file, via any medium is strictly prohibited
 *  * Proprietary and confidential
 *
 */

package net.primegames.core.component.combatLogger;

import net.primegames.core.component.Component;
import net.primegames.core.component.ComponentIds;
import net.primegames.core.plugin.CorePlugin;

public class CombatLoggerComponent implements Component {

    public CombatLoggerComponent(CorePlugin plugin){
        new CombatLogHeartBeat();
        plugin.getEventManager().registerListeners(plugin, new KitPvPCombatLoggerListener());
    }

    @Override
    public String getIdentifier() {
        return ComponentIds.COMBAT_LOGGER;
    }
}
