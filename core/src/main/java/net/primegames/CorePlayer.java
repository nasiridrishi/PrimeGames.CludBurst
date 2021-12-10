/*
 *
 *  * Copyright (C) PrimeGames - All Rights Reserved
 *  * Unauthorized copying of this file, via any medium is strictly prohibited
 *  * Proprietary and confidential
 *
 */

package net.primegames;

import cn.nukkit.Player;
import cn.nukkit.network.SourceInterface;
import net.primegames.Utils.LoggerUtils;
import net.primegames.chat.Chat;
import net.primegames.chat.ChatFactory;
import net.primegames.chat.ChatId;
import net.primegames.group.Group;
import net.primegames.group.GroupIds;
import net.primegames.player.CorePlayerDataStore;
import net.primegames.providor.task.player.punishment.MySQLPunishPlayerTask;

import java.net.InetSocketAddress;
import java.sql.Date;
import java.util.ArrayList;

public class CorePlayer extends Player {

    public final String STATUS_LOADING = "status.loading";
    public final String STATUS_REGISTER_PENDING = "status.registration_pending";
    public final String STATUS_ONLINE = "status.loaded";
    public final String STATUS_UPDATING = "status.updating";

    private Chat chat;

    private Boolean muted = false;

    private ArrayList<CorePlayer> ignoredPlayers = new ArrayList<>();


    private String status = STATUS_LOADING;

    private CorePlayerDataStore databaseData;

    private ArrayList<Group> groups = new ArrayList<>();

    public CorePlayer(SourceInterface interfaz, Long clientID, InetSocketAddress socketAddress) {
        super(interfaz, clientID, socketAddress);
        addGroup(Core.getInstance().getGroupManager().getGroup(GroupIds.MORTAL));
        chat = ChatFactory.getChat(ChatId.MAIN_CHAT);
    }


    public ArrayList<Group> getGroups(){
        return groups;
    }

    public void setGroups(ArrayList<Group> groups) {
        this.groups = groups;
    }

    public void addGroup(Group group){
        if(hasGroup(group)){
            LoggerUtils.error("Tried to re-add an existing group to CorePlayer");
            return;
        }
        //todo send message to player
        //todo save to db
        groups.add(group);
    }

    public void removeGroup(Group group){
        if(groups.remove(group)){
            //todo save tp db
            //todo send transble
            sendMessage(group.getName() + " was removed");
        }else {
            LoggerUtils.warn("Tried to remove a group which " + getName() + " did not have");
        }
    }

    public boolean hasGroupPermission(String permission){
        for (Group group:groups){
            if(group.hasPermission(permission)){
                return true;
            }
        }
        return  false;
    }

    public Group getHighestPriorityGroup(){
        Group result = null;
        for (Group group: groups){
            if(result == null){
                result  = group;
            } else if (group.getPriorityLevel() > result.getPriorityLevel()){
                result = group;
            }
        }
        return result;
    }

    public boolean hasGroup(Group group){
        return groups.contains(group);
    }

    public Chat getChat(){
        return chat;
    }


    public void setChat(Chat chat){
        this.chat = chat;
    }



    public void setDatabaseData(CorePlayerDataStore databaseData) {
        this.databaseData = databaseData;
    }

    public CorePlayerDataStore getCoreDataStore() {
        return databaseData;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Boolean isLoaded(){
        return status.equals(STATUS_ONLINE);
    }

    public ArrayList<CorePlayer> getIgnoredPlayers() {
        return ignoredPlayers;
    }

    public boolean isIgnored(CorePlayer player){
        for(CorePlayer ignored:ignoredPlayers){
            if(player.getName().equals(ignored.getName())){
                return true;
            }
        }
        return false;
    }

    public void setIgnoredPlayers(ArrayList<CorePlayer> ignoredPlayers) {
        this.ignoredPlayers = ignoredPlayers;
    }

    public void unIgnorePlayer(CorePlayer player){
        if(isIgnored(player)){
            ignoredPlayers.remove(player);
        }
    }

    public void ignorePlayer(CorePlayer player){
        if(!isIgnored(player)){
            ignoredPlayers.add(player);
        }
    }

    public void sentence(String reason, String effector, Date expiration, int category){
        Core.getInstance().getMySQLProvider().scheduleTask(new MySQLPunishPlayerTask(getName(), effector, reason, getUniqueId().toString(), expiration, getAddress(), category));
    }

    public void mute(){
        muted = true;
    }

    public boolean isMuted(){
        return muted;
    }

    public void unmute(){
        muted = false;
    }

    public static CorePlayer cast(Player player){
        return (CorePlayer)player;
    }

    public int getFloorX(){
        return (int) this.getX();
    }

    public int getFloorY(){
        return (int) this.getY();
    }

    public int getFloorZ(){
        return (int) this.getZ();
    }

}
