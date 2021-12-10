/*
 *
 *  * Copyright (C) PrimeGames - All Rights Reserved
 *  * Unauthorized copying of this file, via any medium is strictly prohibited
 *  * Proprietary and confidential
 *
 */

package net.primegames.component.autoXp;

import net.primegames.component.Component;
import net.primegames.component.ComponentIds;
import net.primegames.plugin.CorePlugin;

public class AutoXpComponent implements Component {

    public AutoXpComponent(CorePlugin plugin){
        plugin.getServer().getPluginManager().registerEvents(new autoXPListener(), plugin);
    }

    @Override
    public String getIdentifier() {
        return ComponentIds.AUTO_XP;
    }
}
