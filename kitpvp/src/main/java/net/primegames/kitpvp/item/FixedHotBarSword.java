/*
 *
 *  * Copyright (C) PrimeGames - All Rights Reserved
 *  * Unauthorized copying of this file, via any medium is strictly prohibited
 *  * Proprietary and confidential
 *
 */

package net.primegames.kitpvp.item;

import cn.nukkit.item.ItemID;
import cn.nukkit.item.ItemSwordDiamond;
import net.primegames.core.component.killtracker.tracker.KillTrackerDataStore;
import net.primegames.kitpvp.KitpvpPlayer;

public class FixedHotBarSword extends ItemSwordDiamond {

    public FixedHotBarSword() {
        super(ItemID.DIAMOND_SWORD);
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
