package net.primegames.core;

import com.nukkitx.protocol.bedrock.BedrockServerSession;
import net.primegames.core.Utils.LoggerUtils;
import net.primegames.core.chat.Chat;
import net.primegames.core.group.Group;
import net.primegames.core.player.CorePlayerDatabaseData;
import org.cloudburstmc.server.player.Player;
import org.cloudburstmc.server.utils.ClientChainData;

import java.util.ArrayList;

public class CorePlayer extends Player{

    public final String STATUS_LOADING = "status.loading";
    public final String STATUS_REGISTER_PENDING = "status.registration_pending";
    public final String STATUS_ONLINE = "status.loaded";
    public final String STATUS_UPDATING = "status.updating";
    //public final String STATUS_PLAYING = "status.playing";
    //public final String STATUS_SPECTATING = "status.spectating";

    private Chat chat;


    private String status = STATUS_LOADING;

    private CorePlayerDatabaseData databaseData;

    private ArrayList<Group> groups;

    public CorePlayer(BedrockServerSession session, ClientChainData chainData) {
        super(session, chainData);


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



    public void setDatabaseData(CorePlayerDatabaseData databaseData) {
        this.databaseData = databaseData;
    }

    public CorePlayerDatabaseData getDatabaseData() {
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
}
