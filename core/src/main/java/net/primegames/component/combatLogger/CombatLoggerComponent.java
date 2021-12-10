/*
 *
 *  * Copyright (C) PrimeGames - All Rights Reserved
 *  * Unauthorized copying of this file, via any medium is strictly prohibited
 *  * Proprietary and confidential
 *
 */

package net.primegames.component.combatLogger;

import net.primegames.component.Component;
import net.primegames.component.ComponentIds;
import net.primegames.plugin.CorePlugin;

public class CombatLoggerComponent implements Component {

    public CombatLoggerComponent(CorePlugin plugin){
        new CombatLogHeartBeat();
        plugin.getServer().getPluginManager().registerEvents(new KitPvPCombatLoggerListener(), plugin);
    }

    @Override
    public String getIdentifier() {
        return ComponentIds.COMBAT_LOGGER;
    }
}
