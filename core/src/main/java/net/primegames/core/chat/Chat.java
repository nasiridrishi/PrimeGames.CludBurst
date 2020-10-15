/*
 *
 *  * Copyright (C) PrimeGames - All Rights Reserved
 *  * Unauthorized copying of this file, via any medium is strictly prohibited
 *  * Proprietary and confidential
 *
 */

package net.primegames.core.chat;

import net.primegames.core.Core;
import net.primegames.core.CorePlayer;
import org.cloudburstmc.server.item.Item;
import org.cloudburstmc.server.player.Player;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public abstract class Chat {

    private String id;

    private String permission;

    public Chat(String id, String permission){
        this.id = id;
        this.permission = permission;
    }

    public String getId() {
        return id;
    }

    public String getPermission() {
        return permission;
    }

//    public ArrayList<CorePlayer> getPlayers(){
//        ArrayList<Player> players = new ArrayList<>();
//        for (Map.Entry<UUID, Player> player:Core.getInstance().getServer().getOnlinePlayers().entrySet()){
//            (CorePlayer)(player.getValue()).
//        }
////        private void setItems(Player player){
////            Map<Integer, Item> entry = new HashMap<Integer, Item>();
////            for (int i = 0; i < getItems().size(); i++){
////                entry.put(i, getItems().get(i));
////            }
////            player.getInventory().setContents(entry);
////        }
//        Map<>
//    }

    abstract public void onText(CorePlayer player, String $message);
}
