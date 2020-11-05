/*
 *
 *  * Copyright (C) PrimeGames - All Rights Reserved
 *  * Unauthorized copying of this file, via any medium is strictly prohibited
 *  * Proprietary and confidential
 *
 */

package net.primegames.kitpvp.item;

import net.primegames.core.component.killtracker.tracker.KillTrackerDataStore;
import net.primegames.kitpvp.KitpvpPlayer;
import org.cloudburstmc.server.item.behavior.ItemIds;
import org.cloudburstmc.server.item.behavior.ItemSwordDiamond;
import org.cloudburstmc.server.utils.Identifier;

public class FixedHotBarSword extends ItemSwordDiamond {

    public FixedHotBarSword(Identifier id) {
        super(id);
    }

    public void setData(KitpvpPlayer player){
        KillTrackerDataStore tracker = player.getKillTracker();
        String[] lore = new String[]{
                "Total Kills: " + tracker.getTotalKills(),
                "Total Deaths: " + tracker.getTotalDeaths(),
                "KD: " + (tracker.getTotalKills() / tracker . getTotalDeaths())
        };
        this.setCustomName("Original Owner: " + player.getName());
        this.setLore(lore);
    }
}
