/*
 *
 *  * Copyright (C) PrimeGames - All Rights Reserved
 *  * Unauthorized copying of this file, via any medium is strictly prohibited
 *  * Proprietary and confidential
 *
 */

package net.primegames.chat;

import cn.nukkit.Player;
import net.primegames.Core;
import net.primegames.CorePlayer;

import java.util.ArrayList;
import java.util.Map;
import java.util.UUID;

public abstract class Chat {

    private final String id;

    private final String permission;

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

    public ArrayList<CorePlayer> getPlayers(){
        ArrayList<CorePlayer> players = new ArrayList<>();
        for (Map.Entry<UUID, Player> entry:Core.getInstance().getServer().getOnlinePlayers().entrySet()){
            Player player = entry.getValue();
            if(player instanceof CorePlayer){
                CorePlayer player1 = (CorePlayer) player;
                if(player1.getChat().getId().equals(this.id)){
                    players.add(player1);
                }
            }
        }
        return players;
    }

    public void sendMessage(CorePlayer owner, String message, ArrayList<CorePlayer> corePlayers){
        String finalMessage = "☛ " + owner.getHighestPriorityGroup().getChatFormatFor(owner, message);
        for (CorePlayer player:corePlayers){
            if(!player.isIgnored(owner)){
                player.sendMessage(finalMessage);
            }
        }
    }

    public void sendMessage(CorePlayer owner, String message){
        ArrayList<CorePlayer> corePlayers = getPlayers();
        String finalMessage = "☛ " + owner.getHighestPriorityGroup().getChatFormatFor(owner, message);
        for (CorePlayer player:corePlayers){
            if(!player.isIgnored(owner)){
                player.sendMessage(finalMessage);
            }
        }
    }

    abstract public void onText(CorePlayer player, String $message);
}
