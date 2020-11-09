/*
 *
 *  * Copyright (C) PrimeGames - All Rights Reserved
 *  * Unauthorized copying of this file, via any medium is strictly prohibited
 *  * Proprietary and confidential
 *
 */

package net.primegames.core.component.autoInv;

import cn.nukkit.event.EventHandler;
import cn.nukkit.event.Listener;
import cn.nukkit.event.block.BlockBreakEvent;
import cn.nukkit.inventory.Inventory;
import cn.nukkit.item.Item;
import cn.nukkit.utils.TextFormat;
import net.primegames.core.CorePlayer;

public class AutoInvListener implements Listener {

    @EventHandler
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
