/*
 *
 *  * Copyright (C) PrimeGames - All Rights Reserved
 *  * Unauthorized copying of this file, via any medium is strictly prohibited
 *  * Proprietary and confidential
 *
 */

package net.primegames.core.component.autoInv;

import net.primegames.core.CorePlayer;
import org.cloudburstmc.server.event.Listener;
import org.cloudburstmc.server.event.block.BlockBreakEvent;
import org.cloudburstmc.server.inventory.Inventory;
import org.cloudburstmc.server.item.behavior.Item;
import org.cloudburstmc.server.utils.TextFormat;

public class AutoInvListener {

    @Listener
    public void onBreak(BlockBreakEvent event){
        CorePlayer player = CorePlayer.cast(event.getPlayer());
        Inventory inventory = player.getInventory();
        for (Item item :event.getDrops()){
            if(inventory.canAddItem(item)){
                inventory.addItem(item);
            }else {
                player.sendPopup(TextFormat.RED + "Inventory full");
            }
        }
        event.setDrops(null);
    }
}
