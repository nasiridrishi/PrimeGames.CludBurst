/*
 *
 *  * Copyright (C) PrimeGames - All Rights Reserved
 *  * Unauthorized copying of this file, via any medium is strictly prohibited
 *  * Proprietary and confidential
 *
 */

package net.primegames.core.component.autoInv;

import net.primegames.core.component.Component;
import net.primegames.core.component.ComponentIds;
import net.primegames.core.plugin.CorePlugin;

public class AutoInvComponent implements Component {

    public AutoInvComponent(CorePlugin plugin){
        plugin.getEventManager().registerListeners(plugin, new AutoInvListener());
    }

    @Override
    public String getIdentifier() {
        return ComponentIds.AUTO_INV;
    }
}
